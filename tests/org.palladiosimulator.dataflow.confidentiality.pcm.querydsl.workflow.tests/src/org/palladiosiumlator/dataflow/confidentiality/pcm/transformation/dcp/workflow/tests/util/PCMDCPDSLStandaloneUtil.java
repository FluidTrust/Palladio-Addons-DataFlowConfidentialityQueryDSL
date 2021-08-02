package org.palladiosiumlator.dataflow.confidentiality.pcm.transformation.dcp.workflow.tests.util;

import org.eclipse.emf.common.util.URI;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.PCMDFDConstraintLanguageStandaloneSetup;
import org.palladiosimulator.dataflow.confidentiality.pcm.model.profile.ProfileConstants;
import org.palladiosimulator.dataflow.confidentiality.pcm.testmodels.Activator;
import org.palladiosimulator.supporting.prolog.PrologStandaloneSetup;

import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializer;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;
import tools.mdsd.library.standalone.initialization.emfprofiles.EMFProfileInitializationTask;
import tools.mdsd.library.standalone.initialization.log4j.Log4jInitilizationTask;

public class PCMDCPDSLStandaloneUtil {
	
	private PCMDCPDSLStandaloneUtil() {
        // intentionally left blank
    }

    public static void init() throws StandaloneInitializationException {
    	StandaloneInitializer initializer = StandaloneInitializerBuilder.builder()
                .registerProjectURI(Activator.class, "org.palladiosimulator.dataflow.confidentiality.pcm.testmodels")
                .registerProjectURI(ProfileConstants.class,
                        "org.palladiosimulator.dataflow.confidentiality.pcm.model.profile")
                .registerProjectURI(PCMDCPDSLStandaloneUtil.class,
                        "org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.tests") 
                .addCustomTask(new Log4jInitilizationTask())
                .addCustomTask(PrologStandaloneSetup::doSetup)
                .addCustomTask(PCMDFDConstraintLanguageStandaloneSetup::doSetup)
                .addCustomTask(new EMFProfileInitializationTask("org.palladiosimulator.dataflow.confidentiality.pcm.model.profile",
                      "profile.emfprofile_diagram"))
                .build();
            initializer.init();
        
    }
    
    public static URI getModelURI(String model) {
    	return URI.createPlatformPluginURI("/org.palladiosimulator.dataflow.confidentiality.pcm.testmodels/models/TravelPlanner_CallReturn_RBAC/" + model, false);
    }

    public static URI getRelativeURI(String relativePath) {
        return URI.createPlatformPluginURI("/org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.tests/models/" + relativePath, false);
    }

}
