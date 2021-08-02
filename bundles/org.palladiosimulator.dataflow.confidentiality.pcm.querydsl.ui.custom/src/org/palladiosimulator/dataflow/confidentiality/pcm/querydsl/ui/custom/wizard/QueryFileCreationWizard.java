package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom.wizard;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.PCMDFDConstraintLanguageFactory;
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.internal.QuerydslActivator;
import org.palladiosimulator.dataflow.confidentiality.ui.wizard.AbstractXtextFileCreationWizard;

import de.sebinside.dcp.dsl.dSL.DSLFactory;

public class QueryFileCreationWizard extends AbstractXtextFileCreationWizard {

    protected QueryFileImportSelectionPage importPage;

    public QueryFileCreationWizard() {
        super(QuerydslActivator.getInstance()
            .getInjector(
                    QuerydslActivator.ORG_PALLADIOSIMULATOR_DATAFLOW_CONFIDENTIALITY_PCM_QUERYDSL_PCMDFDCONSTRAINTLANGUAGE),
                "Analysis Query");
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        super.init(workbench, selection);
        importPage = new QueryFileImportSelectionPage();
    }

    @Override
    public void addPages() {
        super.addPages();
        addPage(importPage);
    }

    @Override
    protected void createXtextFile(IFile file, IProgressMonitor progressMonitor) throws CoreException {
        // construct URIs
        var rUri = URI.createPlatformResourceURI(file.getFullPath()
            .toString(), false);
        var referencedDictionary = URI.createPlatformResourceURI(importPage.getDictionaryFile()
            .getFullPath()
            .toString(), false);

        // construct model
        var emptyModel = PCMDFDConstraintLanguageFactory.eINSTANCE.createModel();
        var include = DSLFactory.eINSTANCE.createInclude();
        emptyModel.getElements()
            .add(include);
        include.setImportURI(referencedDictionary.toString());

        // serialize file
        var rs = new ResourceSetImpl();
        var r = rs.createResource(rUri);
        r.getContents()
            .add(emptyModel);
        try {
            r.save(Collections.emptyMap());
        } catch (IOException e) {
            throw new CoreException(
                    new Status(IStatus.ERROR, QueryFileCreationWizard.class, "Could not create file.", e));
        }
    }

}
