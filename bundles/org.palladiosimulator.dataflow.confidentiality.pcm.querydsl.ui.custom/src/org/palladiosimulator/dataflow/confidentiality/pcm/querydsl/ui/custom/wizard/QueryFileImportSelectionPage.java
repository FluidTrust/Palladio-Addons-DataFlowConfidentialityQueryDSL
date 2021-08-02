package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.wizard;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.apache.commons.lang3.mutable.MutableObject;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class QueryFileImportSelectionPage extends WizardPage {

    protected static final IWorkspaceRoot ROOT = ResourcesPlugin.getWorkspace()
        .getRoot();
    protected final MutableObject<IFile> dictionaryFile = new MutableObject<>(null);

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

    protected void validatePage() {
        setPageComplete(false);
        if (isSelectionValid()) {
            setPageComplete(true);
        }
    }

    protected boolean isSelectionValid() {
        return dictionaryFile.getValue() != null;
    }

    protected void createFileSelectionRow(Composite parent, String artifact, MutableObject<IFile> valueHolder,
            Collection<String> acceptableFileExtensions) {
        var label = new Label(parent, NONE);
        label.setText(artifact);
        var text = new Text(parent, SWT.FILL);
        var textGridData = new GridData();
        textGridData.horizontalAlignment = GridData.FILL;
        textGridData.grabExcessHorizontalSpace = true;
        text.setLayoutData(textGridData);
        text.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setErrorMessage(null);
                var workspaceFile = findWorkspaceFile(text);
                valueHolder.setValue(workspaceFile.orElse(null));
                if (!workspaceFile.isPresent()) {
                    setErrorMessage("The given path for " + artifact + " is invalid.");
                }
                validatePage();
            }
        });
        var dictionaryButton = new Button(parent, NONE);
        dictionaryButton.setText("...");
        dictionaryButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                super.widgetSelected(e);
                var existingSelection = findWorkspaceFile(text).map(f -> new IFile[] { f })
                    .orElse(new IFile[0]);
                var selectionResult = WorkspaceResourceDialog.openFileSelection(getShell(), "Selection of " + artifact,
                        "Select a " + artifact, false, existingSelection, Arrays.asList(new ViewerFilter() {
                            @Override
                            public boolean select(Viewer viewer, Object parentElement, Object element) {
                                return Optional.ofNullable(element)
                                    .map(e -> {
                                        if (e instanceof IContainer) {
                                            return true;
                                        }

                                        if (e instanceof IFile) {
                                            var fileExtension = ((IFile) e).getFileExtension();
                                            return acceptableFileExtensions.contains(fileExtension);
                                        }

                                        return false;
                                    })
                                    .orElse(false);
                            }
                        }));
                if (selectionResult.length > 0) {
                    // only pick first one
                    var selectedFile = selectionResult[0];
                    text.setText(selectedFile.getFullPath()
                        .toPortableString());
                }
            }
        });
    }

    protected static Optional<IFile> findWorkspaceFile(Text text) {
        return Optional.ofNullable(text.getText())
            .filter(s -> !s.isBlank())
            .map(Path::fromPortableString)
            .map(ROOT::getFile)
            .filter(IFile::exists);
    }

}
