/*
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class DSLAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("de/sebinside/dcp/dsl/parser/antlr/internal/InternalDSL.tokens");
	}
}