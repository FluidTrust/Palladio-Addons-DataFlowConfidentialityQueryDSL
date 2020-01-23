/*
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.sebinside.dcp.dsl.DSLRuntimeModule;
import de.sebinside.dcp.dsl.DSLStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class DSLIdeSetup extends DSLStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new DSLRuntimeModule(), new DSLIdeModule()));
	}
	
}
