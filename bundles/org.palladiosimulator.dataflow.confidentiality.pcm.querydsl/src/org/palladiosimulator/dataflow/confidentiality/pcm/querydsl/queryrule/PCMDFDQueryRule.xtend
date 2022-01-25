package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.queryrule

import de.sebinside.dcp.dsl.dSL.Rule
import de.sebinside.dcp.dsl.generator.queryrule.QueryRule
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.converter.PCMDFDConverter
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.NodeTypeSelectorForArchitecture

import static de.sebinside.dcp.dsl.generator.util.PrologUtils.*

abstract class PCMDFDQueryRule extends QueryRule {
	
	new(Rule rule, String nameBase, PCMDFDConverter converter) {
		super(rule, nameBase, converter)
	}
	
	def dispatch generateNodeSelectorTerm(NodeTypeSelectorForArchitecture selector, String nodeName) {
		val term = switch (selector.type) {
			case USERACTION: {
				CompoundTerm("containedInScenarioBehaviour", #[CompoundTerm(nodeName)])
			}
			case STORE: {
				CompoundTerm("isAStore", CompoundTerm(nodeName))
			}
			case SEFF: {
				LogicalOr(CompoundTerm("isASEFFEntry", CompoundTerm(nodeName)), CompoundTerm("isASEFFExit", CompoundTerm(nodeName)))
			}
		}
		#[term]
	}

}
