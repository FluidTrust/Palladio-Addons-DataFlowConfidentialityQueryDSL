/*
 * generated by Xtext 2.25.0
 */
package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl;

import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.generic.GenericResourceServiceProvider;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class PCMDFDConstraintLanguageStandaloneSetup extends PCMDFDConstraintLanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new PCMDFDConstraintLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public void register(Injector injector) {
		super.register(injector);

		IResourceServiceProvider serviceProvider = injector.getInstance(GenericResourceServiceProvider.class);
		IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("characteristics", serviceProvider);
	}
}
