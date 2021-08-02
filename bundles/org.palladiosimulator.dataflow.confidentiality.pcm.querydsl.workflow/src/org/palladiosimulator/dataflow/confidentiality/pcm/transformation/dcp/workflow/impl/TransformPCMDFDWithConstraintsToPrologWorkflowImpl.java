package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.impl;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.TransformPCMDFDWithConstraintsToPrologWorkflow;
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs.TransformPCMDFDWithConstraintsToPrologJob;
import org.palladiosimulator.dataflow.confidentiality.pcm.workflow.TransitiveTransformationTrace;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.WorkflowExceptionHandler;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;

public class TransformPCMDFDWithConstraintsToPrologWorkflowImpl implements TransformPCMDFDWithConstraintsToPrologWorkflow {
		
    private final KeyValueMDSDBlackboard blackboard = new KeyValueMDSDBlackboard();
    private final BlackboardBasedWorkflow<KeyValueMDSDBlackboard> workflow;
    private final String prologProgramKey;
    private final String traceKey;
    private final String constraintsKey;
    private final WorkflowExceptionHandler handler;
    private final IProgressMonitor monitor;
	
	public TransformPCMDFDWithConstraintsToPrologWorkflowImpl(TransformPCMDFDWithConstraintsToPrologJob<? extends KeyValueMDSDBlackboard> job) {
		this(job, new NullProgressMonitor(), new WorkflowExceptionHandler(true));
	}
	
	public TransformPCMDFDWithConstraintsToPrologWorkflowImpl(TransformPCMDFDWithConstraintsToPrologJob<? extends KeyValueMDSDBlackboard> job,
            IProgressMonitor monitor, WorkflowExceptionHandler handler) {
		this.workflow = createWorkflow(job, monitor, handler, blackboard);
        this.prologProgramKey = job.getPrologKey();
        this.traceKey = job.getTraceKey();
        this.constraintsKey = job.getConstraintsKey();
        this.handler = handler;
        this.monitor = monitor;
	}
	
	public static BlackboardBasedWorkflow<KeyValueMDSDBlackboard> createWorkflow(
			TransformPCMDFDWithConstraintsToPrologJob<? extends KeyValueMDSDBlackboard> job, IProgressMonitor monitor,
            WorkflowExceptionHandler handler, KeyValueMDSDBlackboard blackboard) {
        return new BlackboardBasedWorkflow<KeyValueMDSDBlackboard>(job, monitor, handler, blackboard);
    }

	@Override
	public void run() {
		try {
            workflow.execute(monitor);
        } catch (JobFailedException e) {
            handler.handleJobFailed(e);
        } catch (UserCanceledException e) {
            handler.handleUserCanceled(e);
        }
	}
	
	@Override
	public Optional<String> getPrologProgram() {
		return blackboard.get(prologProgramKey)
	            .map(String.class::cast);
	}

	@Override
	public Optional<TransitiveTransformationTrace> getTrace() {
		return blackboard.get(traceKey)
	            .map(TransitiveTransformationTrace.class::cast);
	}

	@Override
	public Optional<String> getPrologConstraints() {
		return blackboard.get(constraintsKey)
	            .map(String.class::cast);
	}
}
