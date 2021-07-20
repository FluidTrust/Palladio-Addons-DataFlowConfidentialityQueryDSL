/*
 * generated by Xtext 2.25.0
 */
package org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.parser.antlr.internal.InternalPCMDFDConstraintLanguageParser;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.services.PCMDFDConstraintLanguageGrammarAccess;

public class PCMDFDConstraintLanguageParser extends AbstractAntlrParser {

	@Inject
	private PCMDFDConstraintLanguageGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalPCMDFDConstraintLanguageParser createParser(XtextTokenStream stream) {
		return new InternalPCMDFDConstraintLanguageParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}

	public PCMDFDConstraintLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(PCMDFDConstraintLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}