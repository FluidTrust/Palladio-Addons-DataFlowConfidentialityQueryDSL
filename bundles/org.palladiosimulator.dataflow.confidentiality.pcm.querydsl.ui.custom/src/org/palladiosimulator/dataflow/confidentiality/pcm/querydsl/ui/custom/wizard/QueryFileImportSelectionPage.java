package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.wizard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.util.DialogUtils;

public class QueryFileImportSelectionPage extends WizardPage {

    protected static final IWorkspaceRoot ROOT = ResourcesPlugin.getWorkspace()
        .getRoot();
    protected final Collection<Runnable> disposeJobs = new ArrayList<>();
    protected final IObservableValue<IFile> dictionaryFile = new WritableValue<>(null, IFile.class);

    public QueryFileImportSelectionPage() {
        super("Usable resources import");
        setTitle("Resource Selection");
        setDescription("Select resources that will be used during the definition of the analysis query.");
    }

    public IFile getDictionaryFile() {
        return dictionaryFile.getValue();
    }

    @Override
    public void createControl(Composite parent) {
        var composite = new Composite(parent, SWT.FILL);
        composite.setLayout(new GridLayout(3, false));
        createFileSelectionRow(composite, "Dictionary", dictionaryFile, Arrays.asList("pddc", "ddc", "xmi"));
        validatePage();
        setControl(composite);
    }

    @Override
    public void dispose() {
        disposeJobs.forEach(Runnable::run);
        disposeJobs.clear();
        super.dispose();
    }

    protected void validatePage() {
        setPageComplete(false);
        if (isSelectionValid()) {
            setPageComplete(true);
        }
    }

    protected boolean isSelectionValid() {
        return dictionaryFile.getValue() != null;
    }

    protected void createFileSelectionRow(Composite parent, String artifact, IObservableValue<IFile> valueHolder,
            Collection<String> acceptableFileExtensions) {

        IValueChangeListener<IFile> listener = e -> {
            setErrorMessage(null);
            if (e.diff.getNewValue() == null) {
                setErrorMessage("The given path for " + artifact + " is invalid.");
            }
            validatePage();
        };
        valueHolder.addValueChangeListener(listener);
        disposeJobs.add(() -> valueHolder.removeValueChangeListener(listener));

        DialogUtils.createFileSelectionRow(parent, artifact, valueHolder, acceptableFileExtensions);
    }
}
