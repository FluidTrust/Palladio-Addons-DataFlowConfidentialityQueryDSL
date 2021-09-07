package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs;

import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.resultmapping.SerializerFactory;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

public class CreateResultMappingFromSolutionJob<T extends KeyValueMDSDBlackboard> extends
        org.palladiosimulator.dataflow.confidentiality.transformation.dcp.workflow.jobs.CreateResultMappingFromSolutionJob<T> {

    public CreateResultMappingFromSolutionJob(String solutionKey, ModelLocation dcpdslLocation, String resultMappingKey,
            boolean serializeFlowTree) {
        super(solutionKey, dcpdslLocation, resultMappingKey,
                SerializerFactory.createPlainTextSerializer(serializeFlowTree));
    }

}
