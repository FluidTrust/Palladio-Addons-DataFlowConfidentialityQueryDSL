package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.launch;

import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.TransformPCMDFDWithConstraintsToPrologWorkflowFactory;
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs.TransformPCMDFDWithConstraintsToPrologJobBuilder;

import de.uka.ipd.sdq.workflow.WorkflowExceptionHandler;

public class PCMConfidentialityDSLLaunchConfigurationType implements ILaunchConfigurationDelegate {

    protected static class PCMConfidentialityDSLWorkflowExceptionHandler extends WorkflowExceptionHandler {

        private final Consumer<CoreException> exceptionConsumer;

        public PCMConfidentialityDSLWorkflowExceptionHandler(Consumer<CoreException> exceptionConsumer) {
            super(false);
            this.exceptionConsumer = exceptionConsumer;
        }

        @Override
        protected void handleCriticalException(Exception e) {
            super.handleCriticalException(e);
            var status = new Status(IStatus.ERROR, PCMConfidentialityDSLLaunchConfigurationType.class, "", e);
            var exception = new CoreException(status);
            exceptionConsumer.accept(exception);
        }

    }

    @Override
    public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
            throws CoreException {

        // data acquisition (assumption: config has been validated before)
        var usageModelURI = getFileURI(configuration,
                PCMConfidentialityDSLLaunchConfigurationConstants.USAGE_MODEL_FILE_ATTRIBUTE);
        var allocationModelURI = getFileURI(configuration,
                PCMConfidentialityDSLLaunchConfigurationConstants.ALLOCATION_MODEL_FILE_ATTRIBUTE);
        var queryModelURI = getFileURI(configuration,
                PCMConfidentialityDSLLaunchConfigurationConstants.QUERY_FILE_ATTRIBUTE);
        var resultFile = PCMConfidentialityDSLLaunchConfigurationConstants.getFileFromConfiguration(configuration,
                PCMConfidentialityDSLLaunchConfigurationConstants.RESULT_FILE_ATTRIBUTE);

        // workflow building
        var job = TransformPCMDFDWithConstraintsToPrologJobBuilder.create()
            .addUsageModelsByURI(usageModelURI)
            .addAllocationModelByURI(allocationModelURI)
            .addDCPDSL(queryModelURI)
            .setSerializeResultToFile(resultFile)
            .setSerializeFlowTree(false) //TODO remove this after serialization has been fixed
            .build();
        var exceptionHolder = new CoreException[1];
        var exceptionHandler = new PCMConfidentialityDSLWorkflowExceptionHandler(e -> exceptionHolder[0] = e);
        var workflow = TransformPCMDFDWithConstraintsToPrologWorkflowFactory.createWorkflow(job, monitor,
                exceptionHandler);

        // workflow running
        workflow.run();

        // exception handling
        if (exceptionHolder[0] != null) {
            throw exceptionHolder[0];
        }

    }

    protected URI getFileURI(ILaunchConfiguration configuration, String attribute) throws CoreException {
        var modelFile = PCMConfidentialityDSLLaunchConfigurationConstants.getFileFromConfiguration(configuration,
                attribute);
        return URI.createPlatformResourceURI(modelFile.getFullPath()
            .toString(), false);
    }

}
