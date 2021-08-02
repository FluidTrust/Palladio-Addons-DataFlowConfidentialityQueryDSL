package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs;

import org.palladiosimulator.dataflow.confidentiality.pcm.workflow.jobs.TransformPCMDFDtoPrologJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

public interface TransformPCMDFDWithConstraintsToPrologJob<T extends KeyValueMDSDBlackboard>  
		extends TransformPCMDFDtoPrologJob<T> {
	
	String getConstraintsKey();
}
