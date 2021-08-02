package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.wizard;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class QueryFileCreationCommand extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        Shell activeShell = HandlerUtil.getActiveShell(event);

        var wizard = new QueryFileCreationWizard();
        IWorkbench workbench = PlatformUI.getWorkbench();
        IStructuredSelection selection = (IStructuredSelection) workbench.getActiveWorkbenchWindow().getSelectionService().getSelection();
        wizard.init(workbench, selection);
        WizardDialog dialog = new WizardDialog(activeShell, wizard);

        dialog.open();
        return null;
    }

    
}
