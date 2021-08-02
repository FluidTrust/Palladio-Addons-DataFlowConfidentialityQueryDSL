package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow;

import java.util.Optional;

import org.palladiosimulator.dataflow.confidentiality.pcm.workflow.TransformPCMDFDToPrologWorkflow;

public interface TransformPCMDFDWithConstraintsToPrologWorkflow extends TransformPCMDFDToPrologWorkflow {
	
	public Optional<String> getPrologConstraints();
}
