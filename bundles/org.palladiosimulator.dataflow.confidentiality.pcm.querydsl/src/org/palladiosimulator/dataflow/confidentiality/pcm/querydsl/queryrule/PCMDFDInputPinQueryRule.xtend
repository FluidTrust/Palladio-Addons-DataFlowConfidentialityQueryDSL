package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.queryrule

import de.sebinside.dcp.dsl.dSL.Rule
import de.sebinside.dcp.dsl.generator.GlobalConstants
import de.sebinside.dcp.dsl.generator.crossplatform.Converter
import org.palladiosimulator.supporting.prolog.model.prolog.expressions.Expression

import static de.sebinside.dcp.dsl.generator.util.PrologUtils.*

class PCMDFDInputPinQueryRule extends PCMDFDQueryRule {
	
	new(Rule rule, String nameBase, Converter converter) {
		super(rule, nameBase, converter)
	}

	override queryTypeIdentification() {
		'''«GlobalConstants.QueryTypes.INPUT_PIN»'''
	}
	
	override createPinLocationQuery(Expression node, Expression pin) {
		CompoundTerm(GlobalConstants.QueryTypes.INPUT_PIN.prolog, #[node, pin])
	}
}
