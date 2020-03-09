/*
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.generator

import de.sebinside.dcp.dsl.dSL.CharacteristicClass
import de.sebinside.dcp.dsl.dSL.Constraint
import de.sebinside.dcp.dsl.generator.queryrule.CallArgumentQueryRule
import de.sebinside.dcp.dsl.generator.queryrule.CallStateQueryRule
import de.sebinside.dcp.dsl.generator.queryrule.ReturnValueQueryRule
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.palladiosimulator.supporting.prolog.model.prolog.Clause
import org.palladiosimulator.supporting.prolog.model.prolog.PrologFactory

import static de.sebinside.dcp.dsl.generator.DSLGeneratorUtils.*
import static de.sebinside.dcp.dsl.generator.PrologUtils.*

class DSLGenerator extends AbstractGenerator {

	static final String DEV_OUTPUT_FILE_NAME = "output.pl"

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val program = PrologFactory.eINSTANCE.createProgram

		for (element : resource.allContents.toIterable.filter(CharacteristicClass)) {
			program.clauses.addAll(element.compile)
		}

		for (element : resource.allContents.toIterable.filter(Constraint)) {
			program.clauses.addAll(element.compile)
		}

		saveFile(fsa, resource, program, DEV_OUTPUT_FILE_NAME)
	}

	def List<Clause> compile(CharacteristicClass charateristicClass) {
		val clauses = new ArrayList<Clause>

		// Create rule referencing all facts
		val rule = Rule('''characteristicClass_«charateristicClass.name»''')
		rule.body = null

		// A rules arguments are all contained member types
		rule.head.arguments.addAll(charateristicClass.members.map[member|member.ref.name].toSet.map [ type |
			CompoundTerm(type)
		].toList)

		// Create single facts for every member
		charateristicClass.members.forEach [ member, index |
			member.literals.forEach [ literal |

				// Create and add fact
				val factName = '''characteristicsClass_«charateristicClass.name»_«member.ref.name»_«index»«if(member.negated) "_NEG"»'''
				val fact = SimpleFact(factName, literal)
				clauses.add(fact)

				// Create fact reference for the rule
				val factReference = CompoundTerm(fact.head.value, CompoundTerm(member.ref.name))

				// Handle negated facts
				val factExpression = if (member.negated) {
						NotProvable(factReference)
					} else {
						factReference
					}

				// A rule body consists of one or multiple combined facts
				if (rule.body === null) {
					rule.body = factExpression
				} else {
					// FIXME: conjuncted is not supported yet
					rule.body = LogicalAnd(rule.body, factExpression)
				}
			]
		]

		clauses.add(rule)
		clauses
	}

	def List<Clause> compile(Constraint constraint) {
		val clauses = new ArrayList<Clause>
		val constraintName = '''constraint_«constraint.name»'''

		// Every constraint is mapped to a rule
		val constraintRule = Rule(constraintName)

		// FIXME: The first iteration does only support one rule per constraint
		val mainRule = constraint.rule

		// FIXME: The first iteration does only support NEVER FLOW statements
		if (!mainRule.statement.modality.name.equals("NEVER") || !mainRule.statement.type.name.equals("FLOWS")) {
			println("Unable to generate. Unsupported modality or statement type.")
		} else {

			// A NEVER FLOWS statement consists of three sub rules
			val callArgumentRule = new CallArgumentQueryRule(mainRule, constraintName).generate()
			val returnValueRule = new ReturnValueQueryRule(mainRule, constraintName).generate()
			val callStateRule = new CallStateQueryRule(mainRule, constraintName).generate()
			
			// Combine rules
			constraintRule.body = LogicalOr(
				ruleToRuleCall(callArgumentRule),
				LogicalOr(ruleToRuleCall(returnValueRule), ruleToRuleCall(callStateRule))
			)

			// Combine (unique) arguments of all rules
			val allArguments = combineRuleArguments(#[callArgumentRule, returnValueRule, callStateRule])
			constraintRule.head.arguments.addAll(allArguments)

			clauses.add(constraintRule)
			clauses.addAll(callArgumentRule, returnValueRule, callStateRule)
		}
		clauses
	}
	
}
