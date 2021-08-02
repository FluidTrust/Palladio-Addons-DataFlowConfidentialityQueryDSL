package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.generator.PCMDFDConstraintLanguageGenerator;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.Model;
import org.palladiosimulator.dataflow.confidentiality.pcm.workflow.TransitiveTransformationTrace;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

public class TransfromPCMDFDConstraintsToPrologJob<T extends KeyValueMDSDBlackboard> extends AbstractBlackboardInteractingJob<T>  {

    private final String traceKey;
	private final ModelLocation dcpdslLocation;
	private final ModelLocation constraintsLocation;
	private final ModelLocation callableQueryLocation;
	
	public TransfromPCMDFDConstraintsToPrologJob(ModelLocation dcpdslLocation, ModelLocation constraintsLocation, ModelLocation callableQueryLocation, String traceKey) {
		this.dcpdslLocation = dcpdslLocation;
		this.constraintsLocation = constraintsLocation;
		this.callableQueryLocation = callableQueryLocation;
        this.traceKey = traceKey;
    }
	
	@Override
	public String getName() {
		return "Transform DCP DSL Constraints to Prolog";
	}
	
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		// getting and setting the trace for both cases
		var optTrace = getBlackboard().get(traceKey);
		if(optTrace.isEmpty()) {
            throw new JobFailedException("There is no trace available on blackboard.");
		}
		var traceObj = optTrace.get();

		var generator = new PCMDFDConstraintLanguageGenerator();
		if(traceObj instanceof TransitiveTransformationTrace) {
			var pcm2PrologTrace = (TransitiveTransformationTrace) traceObj;
			generator.setTransitiveTransformationTrace(pcm2PrologTrace);
		} else {
			throw new JobFailedException("There is no transtive trace from PCM2Prolog transformation available on blackboard.");
		}

		var dcpdslFiles = getBlackboard().getContents(this.dcpdslLocation)
				.stream()
	            .filter(Model.class::isInstance)
	            .map(Model.class::cast)
	            .collect(Collectors.toList());
		if (dcpdslFiles.size() != 1) {
            throw new JobFailedException("There is not exactly one DCP DSL Constraints file available.");
        }

		var prologConstraints = generator.generateFromModel(dcpdslFiles.get(0));
		getBlackboard().put("converter", generator.getConverter());
		
		var callQueryProgram = generator.getCallableQueryProgram();
		
		getBlackboard().setContents(constraintsLocation, Arrays.asList(prologConstraints));
		getBlackboard().setContents(callableQueryLocation, Arrays.asList(callQueryProgram));
		
        monitor.worked(1);
        monitor.done();
	}

	@Override
	public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {}
}
