package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.converter

import de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector
import de.sebinside.dcp.dsl.generator.GlobalConstants.QueryTypes
import de.sebinside.dcp.dsl.generator.crossplatform.DFDConverter
import de.uka.ipd.sdq.identifier.Identifier
import java.util.Collection
import java.util.Stack
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.ActionNodeIdentitySelector
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.DataChannelNodeIdentitySelector
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.SEFFNodeIdentitySelector
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.StoreNodeIdentitySelector
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.UserActionNodeIdentitySelector
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.UserNodeIdentitySelector
import org.palladiosimulator.dataflow.confidentiality.pcm.queryutils.ModelQueryUtils
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.pcm2dfd.trace.PCMSingleTraceElement
import org.palladiosimulator.dataflow.confidentiality.pcm.workflow.TransitiveTransformationTrace
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.repository.BasicComponent
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall
import org.palladiosimulator.supporting.prolog.model.prolog.AtomicQuotedString

import static de.sebinside.dcp.dsl.generator.util.PrologUtils.*
import de.sebinside.dcp.dsl.dSL.CharacteristicType

class PCMDFDConverter extends DFDConverter {

	val extension ModelQueryUtils queryUtils = new ModelQueryUtils()
	val TransitiveTransformationTrace trace

	new(TransitiveTransformationTrace trace) {
		super(null)
		this.trace = trace
	}

	override convert(CharacteristicType characteristicType) {
		val refType = characteristicType.ref
		var id = trace.getFactId([ct|ct.id == refType.id && ct.name == refType.name]).findFirst[true]
		if (id === null) {
			throw new Exception("Unable to resolve CharacteristicType id.")
		} else {
			AtomicQuotedString(id)
		}
	}

	override convert(Literal characteristicLiteral) {
		var id = trace.getLiteralFactIds(characteristicLiteral).findFirst[true]
		if (id === null) {
			throw new Exception("Unable to resolve Literal id.")
		} else {
			AtomicQuotedString(id)
		}
	}

	override convert(NodeIdentitiySelector selector) {
		convertIdentitySelector(selector)
	}

	protected def dispatch convertIdentitySelector(SEFFNodeIdentitySelector selector) {
		val context = new Stack<Identifier>
		selector.assemblies.forEach[a|context.add(a)]
		val assemblyContext = context.peek as AssemblyContext
		val component = (assemblyContext.encapsulatedComponent__AssemblyContext as BasicComponent)
		val seff = component.serviceEffectSpecifications__BasicComponent.findFirst [ seff |
			seff.describedService__SEFF == selector.signature
		]
		val factIds = trace.getFactIds(seff, context)
		factIds.toPrologStrings
	}

	protected def dispatch convertIdentitySelector(StoreNodeIdentitySelector selector) {
		selector.assemblies.factIdsForLastAssembly
	}

	protected def dispatch convertIdentitySelector(UserActionNodeIdentitySelector selector) {
		val action = selector.userAction;
		val factIds = trace.getFactIds(action)
		factIds.toPrologStrings
	}

	protected def dispatch convertIdentitySelector(UserNodeIdentitySelector selector) {
		val elscs = selector.usageScenario.findAllChildrenIncludingSelfOfType(EntryLevelSystemCall)
		val factIds = elscs.flatMap[elsc|trace.getFactIds(elsc)]
		factIds.toPrologStrings
	}

	protected def dispatch convertIdentitySelector(DataChannelNodeIdentitySelector selector) {
		selector.assemblies.factIdsForLastAssembly
	}

	protected def dispatch convertIdentitySelector(ActionNodeIdentitySelector selector) {
		val context = selector.assemblies.stack
		val action = selector.action
		val factIds = trace.getFactIds(action, context)
		factIds.toPrologStrings
	}

	protected def getFactIdsForLastAssembly(Iterable<AssemblyContext> assemblyHierarchy) {
		val context = assemblyHierarchy.stack
		val assemblyContext = context.peek as AssemblyContext
		val component = assemblyContext.encapsulatedComponent__AssemblyContext
		val factIds = trace.getFactIds(component, context)
		factIds.toPrologStrings
	}

	protected def dispatch Collection<AtomicQuotedString> convertIdentitySelector(NodeIdentitiySelector selector) {
		throw new UnsupportedOperationException("No handling for selector of type " + selector.class.name +
			" available.")
	}

	override convertCharacteristicLiteral(String id) {
		var entries = trace.getPCMEntries(id).filter(PCMSingleTraceElement)
		if (entries.isEmpty) {
			id
		} else if (entries.size > 1) {
			throw new UnsupportedOperationException("There are multiple literals. Literals need to be unambiguous.")
		} else {
			var element = entries.get(0).element
			if (element instanceof Literal) {
				var literal = element as Literal
				literal.name
			} else {
				throw new UnsupportedOperationException("Trace element is faulty: Expected element from type Literal.")
			}
		}
	}

	override String convertQueryType(QueryTypes queryType, String variableId) {
		switch (queryType) {
			case INPUT_PIN: "input"
			case OUTPUT_PIN: "output"
		}
	}

	protected static def getStack(Iterable<AssemblyContext> assemblyHierarchy) {
		val stack = new Stack<Identifier>
		assemblyHierarchy.forEach[a|stack.add(a)]
		stack
	}

	protected static def toPrologStrings(Iterable<String> strings) {
		strings.map[s|AtomicQuotedString(s)].toList
	}
}
