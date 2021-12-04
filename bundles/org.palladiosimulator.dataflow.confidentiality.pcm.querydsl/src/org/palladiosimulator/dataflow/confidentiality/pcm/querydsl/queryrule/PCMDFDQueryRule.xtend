package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.queryrule

import de.sebinside.dcp.dsl.dSL.Rule
import de.sebinside.dcp.dsl.generator.queryrule.QueryRule
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.converter.PCMDFDConverter

abstract class PCMDFDQueryRule extends QueryRule {
	
	new(Rule rule, String nameBase, PCMDFDConverter converter) {
		super(rule, nameBase, converter)
	}

}
