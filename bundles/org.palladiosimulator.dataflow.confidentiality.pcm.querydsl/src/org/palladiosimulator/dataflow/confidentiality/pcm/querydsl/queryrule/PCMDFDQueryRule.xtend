package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.queryrule

import de.sebinside.dcp.dsl.dSL.Rule
import de.sebinside.dcp.dsl.generator.queryrule.QueryRule
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.converter.PCMDFDConverter
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.NodeIdentitiySelector
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.NodeTypeSelectorForArchitecture

import static de.sebinside.dcp.dsl.generator.util.DSLGeneratorUtils.*
import static de.sebinside.dcp.dsl.generator.util.PrologUtils.*

abstract class PCMDFDQueryRule extends QueryRule {

	new(Rule rule, String nameBase, PCMDFDConverter converter) {
		super(rule, nameBase, converter)
	}

	def dispatch generateNodeSelectorTerm(NodeTypeSelectorForArchitecture selector, String nodeName) {
		val term = switch (selector.type) {
			case USERACTION,
			case USER: {
				CompoundTerm("containedInScenarioBehaviour", #[CompoundTerm(nodeName)])
			}
			case STORE: {
				CompoundTerm("isAStore", CompoundTerm(nodeName))
			}
			case SEFF: {
				LogicalOr(CompoundTerm("isASEFFEntry", CompoundTerm(nodeName)),
					CompoundTerm("isASEFFExit", CompoundTerm(nodeName)))
			}
			case ACTION: {
				expressionsToLogicalAnd(#[
					CompoundTerm("containedInComponent", #[CompoundTerm(nodeName)]),
					NotProvable(CompoundTerm("isASEFFEntry", #[CompoundTerm(nodeName)])),
					NotProvable(CompoundTerm("isASEFFExit", #[CompoundTerm(nodeName)]))
				])
			}
			case DATACHANNEL: {
				CompoundTerm("containedInDataChannel", CompoundTerm(nodeName))
			}
		}
		#[term]
	}

	def dispatch generateNodeSelectorTerm(NodeIdentitiySelector selector, String nodeName) {
		val identifiers = converter.convert(selector)
		if (identifiers.isEmpty) {
			throw new IllegalStateException("Could not find the selected node identity in the trace.")
		}
		#[expressionsToLogicalOr(identifiers.map[i|Unification(CompoundTerm(nodeName), i)])]
	}

}
