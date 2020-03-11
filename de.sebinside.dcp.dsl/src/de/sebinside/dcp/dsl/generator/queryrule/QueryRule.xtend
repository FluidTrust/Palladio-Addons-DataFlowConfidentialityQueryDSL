package de.sebinside.dcp.dsl.generator.queryrule

import de.sebinside.dcp.dsl.dSL.AttributeClassSelector
import de.sebinside.dcp.dsl.dSL.AttributeSelector
import de.sebinside.dcp.dsl.dSL.CharacteristicClass
import de.sebinside.dcp.dsl.dSL.DataSelector
import de.sebinside.dcp.dsl.dSL.DestinationSelector
import de.sebinside.dcp.dsl.dSL.PropertyClassSelector
import de.sebinside.dcp.dsl.dSL.PropertySelector
import de.sebinside.dcp.dsl.dSL.Rule
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Set
import org.palladiosimulator.supporting.prolog.model.prolog.CompoundTerm
import org.palladiosimulator.supporting.prolog.model.prolog.expressions.Expression

import static de.sebinside.dcp.dsl.generator.DSLGeneratorUtils.*
import static de.sebinside.dcp.dsl.generator.PrologUtils.*

abstract class QueryRule {

	protected val callStack = "S"
	protected val operation = "OP"
	protected val parameter = "P"
	protected val callState = "ST"
	val queryTypeTerm = createQueryTypeUnification(queryTypeIdentification)

	var Rule rule = null
	var String nameBase = null
	var Set<CharacteristicClass> characteristicClasses = new HashSet<CharacteristicClass>

	new(Rule rule, String nameBase) {
		this.rule = rule
		this.nameBase = nameBase
	}

	def generateDataSelectorTerm(AttributeSelector selector) {
		selector.ref.literals.map [ literal |
			val query = createParameterQuery(CompoundTerm(callStack), CompoundTerm(parameter),
				AtomicQuotedString(selector.ref.ref.name), AtomicQuotedString(literal.entityName), CompoundTerm(operation),
				CompoundTerm(callState))

			if (selector.ref.negated) {
				negate(query)
			} else {
				query
			}
		]
	}

	def generateDataSelectorTerm(AttributeClassSelector selector) {
		characteristicClasses.add(selector.ref)

		selector.ref.members.map [ member |
			val query = createParameterQuery(CompoundTerm(callStack), CompoundTerm(parameter),
				AtomicQuotedString(selector.ref.name), CompoundTerm(member.ref.name), CompoundTerm(operation),
				CompoundTerm(callState))

			val memberQuery = createMemberQuery(member.ref.ref.entityName, CompoundTerm(member.ref.name))

			LogicalAnd(query, memberQuery)
		]
	}

	// FIXME: Somehow get rid of these switch methods
	def generateDataSelectorTerm(DataSelector selector) {
		switch selector {
			AttributeSelector: generateDataSelectorTerm(selector)
			AttributeClassSelector: generateDataSelectorTerm(selector)
		}
	}

	def generateDestinationSelectorTerm(DestinationSelector selector) {
		switch selector {
			PropertySelector: generateDestinationSelectorTerm(selector)
			PropertyClassSelector: generateDestinationSelectorTerm(selector)
		}
	}

	def generateDestinationSelectorTerm(PropertySelector selector) {
		selector.ref.literals.map [ literal |
			val query = createPropertyQuery(CompoundTerm(operation), AtomicQuotedString(selector.ref.ref.name),
				AtomicQuotedString(literal.entityName))

			if (selector.ref.negated) {
				negate(query)
			} else {
				query
			}
		]
	}

	def generateDestinationSelectorTerm(PropertyClassSelector selector) {
		characteristicClasses.add(selector.ref)

		selector.ref.members.map [ member |
			val query = createPropertyQuery(CompoundTerm(operation), AtomicQuotedString(member.ref.name),
				CompoundTerm(member.ref.name))

			val memberQuery = createMemberQuery(member.ref.ref.entityName, CompoundTerm(member.ref.name))

			LogicalAnd(query, memberQuery)
		]
	}

	def generate() {
		val subRule = Rule('''«nameBase»_«queryTypeIdentification»''')

		// Map all data selectors to parts of a rule
		val dataSelectorTerm = rule.dataSelectors.map[selector|generateDataSelectorTerm(selector)].map [ queries |
			expressionsToLogicalAnd(queries)
		]

		// Map all destination selectors to parts of a rule
		val destinationSelectorTerm = rule.destinationSelectors.map [ selector |
			generateDestinationSelectorTerm(selector)
		].map[queries|expressionsToLogicalAnd(queries)]

		// Create characteristics class terms
		val characteristicsClassesTerms = characteristicClasses.map[clazz|createCharacteristicsClassTerm(clazz)]

		// Create final rule body
		val subRuleComponents = #[queryTypeTerm,
			createCallStackUnification(CompoundTerm(callStack), CompoundTerm(operation)),
			expressionsToLogicalAnd(dataSelectorTerm), expressionsToLogicalAnd(destinationSelectorTerm),
			if (characteristicClasses.size > 0) {
				expressionsToLogicalAnd(characteristicsClassesTerms)
			}]
		subRule.body = expressionsToLogicalAnd(subRuleComponents)

		// Create rules parameters
		var List<CompoundTerm> parametersList = new ArrayList<CompoundTerm>
		parametersList.addAll(CompoundTerm("QueryType"), CompoundTerm(operation))
		parametersList.add(parameterTerm())

		// Add all (unique) classes members names to the list
		val classTerms = characteristicClasses.toList.map[clazz|clazz.members.map[member|member.ref.name]].toSet.
			flatten.map[term|CompoundTerm(term)]
		parametersList.addAll(classTerms)

		subRule.head.arguments.addAll(parametersList)
		subRule
	}

	abstract def Expression createParameterQuery(Expression stack, Expression parameter, Expression attribute,
		Expression value, Expression operation, Expression stateVariable)

	abstract def String queryTypeIdentification()

	abstract def CompoundTerm parameterTerm()

}