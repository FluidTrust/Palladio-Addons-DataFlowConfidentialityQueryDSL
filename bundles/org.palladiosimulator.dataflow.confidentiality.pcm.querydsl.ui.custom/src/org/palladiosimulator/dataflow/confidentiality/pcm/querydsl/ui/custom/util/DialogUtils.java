package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public final class DialogUtils {

    private static final class FileExtensionViewerFilter extends ViewerFilter {
        private final Collection<String> acceptableFileExtensions;

        private FileExtensionViewerFilter(Collection<String> acceptableFileExtensions) {
            this.acceptableFileExtensions = acceptableFileExtensions;
        }

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
    }

    protected static final IWorkspaceRoot ROOT = ResourcesPlugin.getWorkspace()
        .getRoot();

    private DialogUtils() {
        // intentionally left blank
    }

    public static void createFileSelectionRow(Composite parent, String artifact, IObservableValue<IFile> valueHolder,
            Collection<String> acceptableFileExtensions) {
        var label = new Label(parent, SWT.NONE);
        label.setText(artifact);
        var text = createFileSelectionRowTextField(parent, valueHolder);
        createFileSelectionRowButton(parent, artifact, acceptableFileExtensions, text);
    }

    protected static void createFileSelectionRowButton(Composite parent, String artifact,
            Collection<String> acceptableFileExtensions, Text text) {
        var dictionaryButton = new Button(parent, SWT.NONE);
        dictionaryButton.setText("...");

        dictionaryButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                super.widgetSelected(e);
                var existingSelection = findExistingWorkspaceFile(text).map(f -> new IFile[] { f })
                    .orElse(new IFile[0]);
                var selectionResult = WorkspaceResourceDialog.openFileSelection(parent.getShell(),
                        "Selection of " + artifact, "Select a " + artifact, false, existingSelection,
                        Arrays.asList(new FileExtensionViewerFilter(acceptableFileExtensions)));
                if (selectionResult.length > 0) {
                    // only pick first one
                    var selectedFile = selectionResult[0];
                    text.setText(selectedFile.getFullPath()
                        .toPortableString());
                }
            }
        });

    }

    protected static Text createFileSelectionRowTextField(Composite parent, IObservableValue<IFile> valueHolder) {
        var text = new Text(parent, SWT.FILL);

        var textGridData = new GridData();
        textGridData.horizontalAlignment = GridData.FILL;
        textGridData.grabExcessHorizontalSpace = true;
        text.setLayoutData(textGridData);

        text.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                var workspaceFile = findExistingWorkspaceFile(text);
                valueHolder.setValue(workspaceFile.orElse(null));
            }
        });

        IValueChangeListener<IFile> valueHolderListener = e -> {
            var newTextContent = Optional.ofNullable(e.diff.getNewValue())
                .map(IFile::getFullPath)
                .map(IPath::toPortableString)
                .orElse(null);
            if (newTextContent != null && !newTextContent.equals(text.getText()) && !text.isDisposed()) {
                Display.getCurrent()
                    .asyncExec(() -> text.setText(newTextContent));
            }
        };
        valueHolder.addValueChangeListener(valueHolderListener);
        text.addDisposeListener(e -> valueHolder.removeValueChangeListener(valueHolderListener));

        return text;
    }

    public static Optional<IFile> findWorkspaceFile(Text text) {
        return Optional.ofNullable(text.getText())
            .filter(s -> !s.isBlank())
            .map(Path::fromPortableString)
            .map(f -> {
                try {
                    return ROOT.getFile(f);
                } catch (IllegalArgumentException e) {
                    return null;
                }
            });
    }

    public static Optional<IFile> findExistingWorkspaceFile(Text text) {
        return findWorkspaceFile(text).filter(IFile::exists);
    }
}
