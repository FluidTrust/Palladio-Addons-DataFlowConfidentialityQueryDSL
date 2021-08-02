package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.impl.TransformPCMDFDWithConstraintsToPrologWorkflowImpl;
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs.TransformPCMDFDWithConstraintsToPrologJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

import de.uka.ipd.sdq.workflow.WorkflowExceptionHandler;

public class TransformPCMDFDWithConstraintsToPrologWorkflowFactory {
	
	 private TransformPCMDFDWithConstraintsToPrologWorkflowFactory() {
	        // intentionally left blank
	    }

	    public static TransformPCMDFDWithConstraintsToPrologWorkflow createWorkflow(
	    		TransformPCMDFDWithConstraintsToPrologJob<? extends KeyValueMDSDBlackboard> job) {
	        return new TransformPCMDFDWithConstraintsToPrologWorkflowImpl(job);
	    }

	    public static TransformPCMDFDWithConstraintsToPrologWorkflow createWorkflow(
	    		TransformPCMDFDWithConstraintsToPrologJob<? extends KeyValueMDSDBlackboard> job, IProgressMonitor monitor,
	            WorkflowExceptionHandler handler) {
	        return new TransformPCMDFDWithConstraintsToPrologWorkflowImpl(job, monitor, handler);
	    }

}
