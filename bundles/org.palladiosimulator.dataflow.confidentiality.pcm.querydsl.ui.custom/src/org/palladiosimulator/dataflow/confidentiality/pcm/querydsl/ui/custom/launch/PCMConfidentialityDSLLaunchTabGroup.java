package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class PCMConfidentialityDSLLaunchTabGroup extends AbstractLaunchConfigurationTabGroup {

    public PCMConfidentialityDSLLaunchTabGroup() {
        // intentionally left blank
    }

    @Override
    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        setTabs(new ILaunchConfigurationTab[] { new PCMConfidentialityDSLLaunchConfigurationTab() });
    }

}
