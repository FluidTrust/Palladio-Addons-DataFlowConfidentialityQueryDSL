package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

import org.apache.commons.lang3.Validate;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.util.StringInputStream;
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.internal.Activator;
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs.StringConsumerJob.ThrowingConsumer;
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs.impl.TransformPCMDFDWithConstraintsToPrologJobImpl;
import org.palladiosimulator.dataflow.confidentiality.pcm.workflow.jobs.TransformPCMDFDToPrologJobBuilder;
import org.palladiosimulator.dataflow.confidentiality.pcm.workflow.jobs.impl.TransformPCMDFDtoPrologJobImpl;
import org.palladiosimulator.dataflow.confidentiality.transformation.dcp.workflow.jobs.RunConstraintsQueryJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.InitPartitionJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.LoadModelJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.SerializeModelToStringJob;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.prolog4j.IProverFactory;

import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.SavePartitionToDiskJob;

public class TransformPCMDFDWithConstraintsToPrologJobBuilder {

    private static final ModelLocation DEFAULT_DCPDSL_LOCATION = new ModelLocation(
            TransformPCMDFDToPrologJobBuilder.DEFAULT_PCM_INPUT_PARTITION_ID,
            URI.createFileURI("tmp/constaints.DCPDSL"));
    private static final ModelLocation DEFAULT_CONSTRAINTS_LOCATION = new ModelLocation("constraints",
            URI.createFileURI("tmp/constraints.pl"));
    private static final ModelLocation DEFAULT_CALLABLE_QUERY_LOCATION = new ModelLocation("query",
            URI.createFileURI("tmp/query.pl"));
    private static final String DEFAULT_CONSTRAINTS_KEY = "stringconstraints";
    private static final String DEFAULT_CALLABLE_QUERY_KEY = "stringquery";
    private static final String DEFAULT_SOLUTION_KEY = "solution";
    private static final String DEFAULT_SERIALIZED_QUERY_RESULT_KEY = "serializedQueryResult";

    private ModelLocation dcpdslLocation;
    private ModelLocation prologConstraintsLocation;
    private boolean serializeConstraintsToString = false;
    private String constraintsResultKey;
    private ThrowingConsumer<String> serializedResultConsumer;
    private IProverFactory proverFactory;
    private boolean serializeFlowTree = true;

    private TransformPCMDFDToPrologJobBuilder base = new TransformPCMDFDToPrologJobBuilder();

    public static TransformPCMDFDWithConstraintsToPrologJobBuilder create() {
        var builder = new TransformPCMDFDWithConstraintsToPrologJobBuilder();
        builder.addSerializeModelToString(); // meet API requirements
        builder.addSerializeDCPPrologToString(); // reasonable default
        return builder;
    }

    public TransformPCMDFDWithConstraintsToPrologJob<? extends KeyValueMDSDBlackboard> build() {
        Validate.notNull(serializedResultConsumer);

        if (proverFactory == null) {
            var proverFactories = Activator.getInstance()
                .getProverManager()
                .getProvers()
                .values();
            Validate.isTrue(!proverFactories.isEmpty());
            proverFactory = proverFactories.iterator()
                .next();
        }

        var baseSequence = base.build();
        @SuppressWarnings("unchecked")
        var baseSequenceImpl = (TransformPCMDFDtoPrologJobImpl<KeyValueMDSDBlackboard>) baseSequence;
        if (baseSequenceImpl == null) {
            // Error
        }

        var jobSequence = new TransformPCMDFDWithConstraintsToPrologJobImpl<KeyValueMDSDBlackboard>(
                "\"PCM to Prolog Transformation with Constraints\"", baseSequence.getPrologKey(),
                baseSequence.getTraceKey(), DEFAULT_CONSTRAINTS_KEY);

        // copy jobs from builder without constraints to new job
        baseSequenceImpl.iterator()
            .forEachRemaining(jobSequence::add);

        // load DCPDSL file
        var loadDCPDSLJob = new LoadModelJob<>(dcpdslLocation);
        jobSequence.add(loadDCPDSLJob);

        // initialize blackboard partition for transformed prolog constraints
        var initPrologConstraintsPartitionJob = new InitPartitionJob(prologConstraintsLocation.getPartitionID());
        jobSequence.add(initPrologConstraintsPartitionJob);
        // initialize blackboard partition for callable query location
        IJob initPrologPartitionJob = new InitPartitionJob(DEFAULT_CALLABLE_QUERY_LOCATION.getPartitionID());
        jobSequence.add(initPrologPartitionJob);

        // actual transformation job
        var dcpdslToConstraintsJob = new TransfromPCMDFDConstraintsToPrologJob<KeyValueMDSDBlackboard>(dcpdslLocation,
                prologConstraintsLocation, DEFAULT_CALLABLE_QUERY_LOCATION, baseSequence.getTraceKey());
        jobSequence.add(dcpdslToConstraintsJob);

        // serialize the prolog constraints either to file or to string
        IJob serializeConstraintsJob;
        if (serializeConstraintsToString) {
            serializeConstraintsJob = new SerializeModelToStringJob(prologConstraintsLocation, constraintsResultKey);
        } else {
            serializeConstraintsJob = new SavePartitionToDiskJob(prologConstraintsLocation.getPartitionID());
        }
        jobSequence.add(serializeConstraintsJob);

        // add serialize model job; toplevel constraints at DEFAULT_CALLABLE_QUERY_LOCATION
        jobSequence.add(new SerializeModelToStringJob(DEFAULT_CALLABLE_QUERY_LOCATION, SaveOptions.newBuilder()
            .format()
            .getOptions()
            .toOptionsMap(), DEFAULT_CALLABLE_QUERY_KEY));

        jobSequence.add(new RunConstraintsQueryJob<>(TransformPCMDFDToPrologJobBuilder.DEFAULT_PROLOG_KEY,
                DEFAULT_CONSTRAINTS_KEY, DEFAULT_CALLABLE_QUERY_KEY, DEFAULT_SOLUTION_KEY, proverFactory));

        jobSequence.add(new CreateResultMappingFromSolutionJob<>(DEFAULT_SOLUTION_KEY, dcpdslLocation,
                DEFAULT_SERIALIZED_QUERY_RESULT_KEY, serializeFlowTree));

        jobSequence.add(new StringConsumerJob<>(DEFAULT_SERIALIZED_QUERY_RESULT_KEY, serializedResultConsumer));

        return jobSequence;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addDCPDSL(URI dcpURI) {
        dcpdslLocation = new ModelLocation(DEFAULT_DCPDSL_LOCATION.getPartitionID(), dcpURI);
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addSerializeDCPPrologToFile(URI destinationURI) {
        serializeConstraintsToString = false;
        prologConstraintsLocation = new ModelLocation(DEFAULT_CONSTRAINTS_LOCATION.getPartitionID(), destinationURI);
        constraintsResultKey = DEFAULT_CONSTRAINTS_KEY;
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addSerializeDCPPrologToString() {
        addSerializeDCPPrologToString(DEFAULT_CONSTRAINTS_KEY);
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addSerializeDCPPrologToString(String blackboardKey) {
        serializeConstraintsToString = true;
        prologConstraintsLocation = DEFAULT_CONSTRAINTS_LOCATION;
        constraintsResultKey = blackboardKey;
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addUsageModelsByURI(URI... uris) {
        return this.addUsageModelsByURI(Arrays.asList(uris));
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addUsageModelsByURI(Collection<URI> uris) {
        base.addUsageModelsByURI(uris);
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addUsageModels(UsageModel... usageModels) {
        return this.addUsageModels(Arrays.asList(usageModels));
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addUsageModels(Collection<UsageModel> usageModels) {
        base.addUsageModels(usageModels);
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addAllocationModelByURI(URI uri) {
        base.addAllocationModelByURI(uri);
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addAllocationModel(Allocation allocation) {
        base.addAllocationModel(allocation);
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addSerializeModelToString() {
        base.addSerializeModelToString();
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder addSerializeModelToString(String blackboardKey) {
        base.addSerializeModelToString(blackboardKey);
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder setSerializeResultToFile(Path file) {
        this.serializedResultConsumer = s -> {
            Files.writeString(file, s, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        };
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder setSerializeResultToFile(IFile file) {
        this.serializedResultConsumer = s -> {
            try (var is = new StringInputStream(s)) {
                if (file.exists()) {
                    file.setContents(is, IFile.FORCE, new NullProgressMonitor());
                } else {
                    file.create(is, IFile.FORCE, new NullProgressMonitor());
                }
            }
        };
        return this;
    }

    public TransformPCMDFDWithConstraintsToPrologJobBuilder setSerializeResultHandler(Consumer<String> stringConsumer) {
        this.serializedResultConsumer = s -> stringConsumer.accept(s);
        return this;
    }
    
    public TransformPCMDFDWithConstraintsToPrologJobBuilder addProverFactory(IProverFactory proverFactory) {
        this.proverFactory = proverFactory;
        return this;
    }
    
    public TransformPCMDFDWithConstraintsToPrologJobBuilder setSerializeFlowTree(boolean serializationFlag) {
        this.serializeFlowTree = serializationFlag;
        return this;
    }
}
