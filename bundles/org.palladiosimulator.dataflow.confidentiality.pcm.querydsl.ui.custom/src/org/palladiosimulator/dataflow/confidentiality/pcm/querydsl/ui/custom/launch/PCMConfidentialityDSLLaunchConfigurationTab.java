package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.launch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.Activator;
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.util.DialogUtils;

public class PCMConfidentialityDSLLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

    protected interface AttributeTakingExecutor {
        void execute(String attribute) throws CoreException;
    }

    protected final Map<String, IObservableValue<IFile>> fileValues = new HashMap<>();
    protected final Collection<Runnable> disposeTasks = new ArrayList<>();
    protected final Map<String, String> errorMessages = new HashMap<>();

    @Override
    public void createControl(Composite parent) {
        var composite = new Composite(parent, SWT.FILL);
        var compositeLayout = new GridLayout(3, false);
        composite.setLayout(compositeLayout);

        try {
            executeForAllFiles(attr -> fileValues.put(attr, new WritableValue<IFile>()));
        } catch (CoreException e) {
            Activator.getInstance()
                .getLog()
                .error("Error while creating launch config controls.", e);
            return;
        }

        addFileControls(composite, "Usage Model",
                PCMConfidentialityDSLLaunchConfigurationConstants.USAGE_MODEL_FILE_ATTRIBUTE,
                Arrays.asList("usagemodel", "xmi"));
        addFileControls(composite, "Allocation Model",
                PCMConfidentialityDSLLaunchConfigurationConstants.ALLOCATION_MODEL_FILE_ATTRIBUTE,
                Arrays.asList("allocation", "xmi"));
        addFileControls(composite, "Analysis Definition",
                PCMConfidentialityDSLLaunchConfigurationConstants.QUERY_FILE_ATTRIBUTE, Arrays.asList("DCPDSL", "xmi"));

        setControl(composite);
    }

    @Override
    public void dispose() {
        disposeTasks.forEach(Runnable::run);
        super.dispose();
    }

    @Override
    public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
        try {
            executeForAllFiles(attr -> configuration.setAttribute(attr, (String) null));
        } catch (CoreException e) {
            Activator.getInstance()
                .getLog()
                .error("Error while initializing launch config with defaults.", e);
        }
    }

    @Override
    public void initializeFrom(ILaunchConfiguration configuration) {
        try {
            executeForAllFiles(attr -> setFileInModel(configuration, attr, fileValues.get(attr)));
        } catch (CoreException e) {
            Activator.getInstance()
                .getLog()
                .error("Error while initializing launch config from saved values.", e);
        }
    }

    @Override
    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
        try {
            executeForAllFiles(attr -> setFileInLaunchConfig(configuration, attr, fileValues.get(attr)));
        } catch (CoreException e) {
            Activator.getInstance()
                .getLog()
                .error("Error while applying launch config.", e);
        }
    }

    @Override
    public boolean isValid(ILaunchConfiguration launchConfig) {
        return super.isValid(launchConfig) && validateConfig(launchConfig);
    }

    @Override
    public String getName() {
        return "Analysis Definition";
    }

    protected boolean validateConfig(ILaunchConfiguration launchConfig) {
        var isValid = new AtomicBoolean(true);
        try {
            executeForAllFiles(attr -> {
                var file = PCMConfidentialityDSLLaunchConfigurationConstants.getFileFromConfiguration(launchConfig,
                        attr);
                isValid.set(isValid.get() && file != null && file.exists());
            });
        } catch (CoreException e) {
            Activator.getInstance()
                .getLog()
                .error("Error while validating launch config.", e);
        }
        return isValid.get();
    }

    protected static void executeForAllFiles(AttributeTakingExecutor task) throws CoreException {
        task.execute(PCMConfidentialityDSLLaunchConfigurationConstants.USAGE_MODEL_FILE_ATTRIBUTE);
        task.execute(PCMConfidentialityDSLLaunchConfigurationConstants.ALLOCATION_MODEL_FILE_ATTRIBUTE);
        task.execute(PCMConfidentialityDSLLaunchConfigurationConstants.QUERY_FILE_ATTRIBUTE);
    }

    protected void addFileControls(Composite parent, String artifactName, String attributeName,
            Collection<String> fileExtensions) {
        var valueHolder = fileValues.get(attributeName);
        DialogUtils.createFileSelectionRow(parent, artifactName, valueHolder, fileExtensions);
        IValueChangeListener<IFile> valueChangeListener = e -> {
            var newValue = e.diff.getNewValue();
            if (newValue == null) {
                errorMessages.put(attributeName, "The path for " + attributeName + " is invalid.");
                updateErrorMessages();
            } else {
                errorMessages.remove(attributeName);
                updateErrorMessages();
            }
        };
        valueHolder.addValueChangeListener(valueChangeListener);
        disposeTasks.add(() -> valueHolder.removeValueChangeListener(valueChangeListener));
    }

    protected void updateErrorMessages() {
        var newErrorMessage = errorMessages.values()
            .stream()
            .collect(Collectors.joining(" "));
        setErrorMessage(null);
        if (!newErrorMessage.isBlank()) {
            setErrorMessage(newErrorMessage);
        }
        this.updateLaunchConfigurationDialog();
    }

    protected static void setFileInModel(ILaunchConfiguration configuration, String attributeName,
            IObservableValue<IFile> model) throws CoreException {
        var foundFile = PCMConfidentialityDSLLaunchConfigurationConstants.getFileFromConfiguration(configuration,
                attributeName);
        if (foundFile == null || !foundFile.exists()) {
            model.setValue(null);
        } else {
            model.setValue(foundFile);
        }
    }

    protected static void setFileInLaunchConfig(ILaunchConfigurationWorkingCopy configuration, String attributeName,
            IObservableValue<IFile> model) {
        var valueToSet = Optional.ofNullable(model.getValue())
            .map(IFile::getFullPath)
            .map(IPath::toPortableString)
            .orElse(null);
        configuration.setAttribute(attributeName, valueToSet);
    }

}
