package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs.impl;

import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs.TransformPCMDFDWithConstraintsToPrologJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;

public class TransformPCMDFDWithConstraintsToPrologJobImpl <T extends KeyValueMDSDBlackboard>
		extends SequentialBlackboardInteractingJob<T> 
		implements TransformPCMDFDWithConstraintsToPrologJob<T> {
	
	private final String prologKey;
    private final String traceKey;
    private final String constraintsKey;
	
	public TransformPCMDFDWithConstraintsToPrologJobImpl(String name, String prologKey, String traceKey, String constraintsKey) {
        super(name);
        this.prologKey = prologKey;
        this.traceKey = traceKey;
        this.constraintsKey = constraintsKey;
    }

	@Override
    public String getPrologKey() {
        return prologKey;
    }

    @Override
    public String getTraceKey() {
        return traceKey;
    }

	@Override
	public String getConstraintsKey() {
		return constraintsKey;
	}
}
