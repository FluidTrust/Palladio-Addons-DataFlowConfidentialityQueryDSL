package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;

public final class PCMConfidentialityDSLLaunchConfigurationConstants {

    public static final String USAGE_MODEL_FILE_ATTRIBUTE = "usageModel";
    public static final String ALLOCATION_MODEL_FILE_ATTRIBUTE = "allocation";
    public static final String QUERY_FILE_ATTRIBUTE = "query";

    protected static final IWorkspaceRoot ROOT = ResourcesPlugin.getWorkspace()
        .getRoot();

    private PCMConfidentialityDSLLaunchConfigurationConstants() {
        // intentionally left blank
    }

    public static IFile getFileFromConfiguration(ILaunchConfiguration configuration, String attributeName)
            throws CoreException {
        var attributeValue = configuration.getAttribute(attributeName, (String) null);
        if (attributeValue == null) {
            return null;
        }
        var foundFile = ROOT.getFile(new Path(attributeValue));
        return foundFile;
    }

}
