package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl

import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription
import org.eclipse.xtext.util.IAcceptor
import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.characteristics.CharacteristicTypeDictionary
import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.characteristics.CharacteristicsPackage
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.Model
import org.palladiosimulator.dataflow.confidentiality.pcm.queryutils.ModelQueryUtils
import org.palladiosimulator.pcm.allocation.Allocation
import org.palladiosimulator.pcm.allocation.AllocationPackage
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.core.composition.ComposedStructure
import org.palladiosimulator.pcm.core.composition.CompositionPackage
import org.palladiosimulator.pcm.core.entity.Entity
import org.palladiosimulator.pcm.repository.CollectionDataType
import org.palladiosimulator.pcm.repository.CompositeDataType
import org.palladiosimulator.pcm.repository.OperationSignature
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import org.palladiosimulator.pcm.repository.Repository
import org.palladiosimulator.pcm.repository.RepositoryPackage
import org.palladiosimulator.pcm.seff.AbstractAction
import org.palladiosimulator.pcm.seff.SeffPackage
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour
import org.palladiosimulator.pcm.usagemodel.UsageModel
import org.palladiosimulator.pcm.usagemodel.UsageScenario
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF

class ExtendedResourceDescriptionStrategy extends de.sebinside.dcp.dsl.ExtendedResourceDescriptionStrategy {

	val extension ModelQueryUtils modelQueryUtils = new ModelQueryUtils

	override createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (eObject instanceof Model) {
			createEObjectDescriptionForModel(eObject, acceptor)
			return true
		}
		
		if (eObject.eClass === CharacteristicsPackage.eINSTANCE.characteristicTypeDictionary) {
			createEObjectDescriptionForPCMCharacteristicTypeContainer(eObject, acceptor)
			return true
		}

		if (eObject.eClass === AllocationPackage.eINSTANCE.allocation) {
			createEObjectDescriptionForAllocation(eObject, acceptor)
			return false
		}

		if (eObject.eClass == CompositionPackage.eINSTANCE.assemblyContext) {
			createEObjectDescriptionForAssemblyContext(eObject, acceptor)
			return false
		}
		
		if (eObject.eClass == RepositoryPackage.eINSTANCE.operationSignature) {
			createEObjectDescriptionForOperationSignature(eObject as OperationSignature, acceptor)
			return false
		}
		
		if (eObject.eClass == UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL) {
			createEObjectDescriptionForAbstractUserAction(eObject as AbstractUserAction, acceptor)
			return true // actions might be nested
		}
		
		if (eObject.eClass == UsagemodelPackage.Literals.USAGE_SCENARIO) {
			createEObjectDescriptionForUsageScenario(eObject as UsageScenario, acceptor)
			return true // nested actions are interesting
		}
		
		if (SeffPackage.Literals.ABSTRACT_ACTION.isInstance(eObject)) {
			createEObjectDescriptionForAbstractAction(eObject as AbstractAction, acceptor)
			return true // actions might be nested
		}

		super.createEObjectDescriptions(eObject, acceptor)
	}
	
	protected def createEObjectDescriptionForAbstractAction(AbstractAction action, IAcceptor<IEObjectDescription> acceptor) {
		// assumption: name of action is unique within SEFF
		val seff = action.findParentOfType(ResourceDemandingSEFF, false)
		val qualifiedName = QualifiedName.create(seff.id, action.entityName)
		val description = EObjectDescription.create(qualifiedName, action)
		val aliasedDescription = createAliasedDescription(description)
		acceptor.accept(aliasedDescription)
	}
	
	protected def createEObjectDescriptionForUsageScenario(UsageScenario scenario, IAcceptor<IEObjectDescription> acceptor) {
		val description = EObjectDescription.create(QualifiedName.create(scenario.entityName), scenario)
		acceptor.accept(description)
	}
	
	protected def createEObjectDescriptionForAbstractUserAction(AbstractUserAction action, IAcceptor<IEObjectDescription> acceptor) {
		val entityHierarchy = new ArrayList<Entity>
		var EObject currentElement = action
		while (currentElement instanceof AbstractUserAction) {
			entityHierarchy += currentElement
			currentElement = currentElement.eContainer
		}
		if (!(currentElement instanceof ScenarioBehaviour)) {
			throw new IllegalStateException("A user action always has to be contained in a scenario behaviour.");
		}
		val scenarioBehavior = currentElement as ScenarioBehaviour
		entityHierarchy += scenarioBehavior.usageScenario_SenarioBehaviour

		val nameSegments = entityHierarchy.reverseView.map[entityName].toList
		val qualifiedName = QualifiedName.create(nameSegments)
		val description = EObjectDescription.create(qualifiedName, action)
		val aliasedDescription = createAliasedDescription(description)

		acceptor.accept(aliasedDescription)
	}
	
	protected def createAliasedDescription(IEObjectDescription description) {
		val estimatedSegments = description.name.toString.split("\\.")
		val estimatedQualifiedName = QualifiedName.create(estimatedSegments)
		return new AliasedEObjectDescription(estimatedQualifiedName, description)
	}
	
	protected def createEObjectDescriptionForOperationSignature(OperationSignature signature, IAcceptor<IEObjectDescription> acceptor) {
		val signatureName = signature.entityName
		val interfaceName = signature.interface__OperationSignature.entityName
		val qualifiedName = QualifiedName.create(interfaceName, signatureName);
		acceptor.accept(EObjectDescription.create(qualifiedName, signature))
	}
	
	protected def dispatch getName(PrimitiveDataType dt) {
		dt.type.getName
	}
	
	protected def dispatch getName(CompositeDataType dt) {
		dt.entityName
	}
	
	protected def dispatch getName(CollectionDataType dt) {
		dt.entityName
	}
	
	protected def createEObjectDescriptionForRepository(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		val repository = eObject as Repository
		acceptor.accept(
			EObjectDescription.create(QualifiedName.create(getEResourceFileName(repository.eResource)), repository))
	}
	
	protected def createEObjectDescriptionForPCMCharacteristicTypeContainer(EObject eObject,
		IAcceptor<IEObjectDescription> acceptor) {
		val typeContainer = eObject as CharacteristicTypeDictionary
		acceptor.accept(
			EObjectDescription.create(QualifiedName.create(getEResourceFileName(typeContainer.eResource)),
				typeContainer));
	}

	protected def createEObjectDescriptionForAssemblyContext(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		val assemblyContext = eObject as AssemblyContext
		createEObjectDescriptionForAssemblyContextNested(assemblyContext, QualifiedName.EMPTY, acceptor)
	}
	
	protected def void createEObjectDescriptionForAssemblyContextNested(AssemblyContext assemblyContext, QualifiedName previousName, IAcceptor<IEObjectDescription> acceptor) {
		val qualifiedName = previousName.append(assemblyContext.entityName)
		acceptor.accept(EObjectDescription.create(qualifiedName, assemblyContext))
		val encapsulatedComponent = assemblyContext.encapsulatedComponent__AssemblyContext
		if (encapsulatedComponent instanceof ComposedStructure) {
			val encapsulatedAssemblyContexts = encapsulatedComponent.assemblyContexts__ComposedStructure
			encapsulatedAssemblyContexts.forEach[ac|ac.createEObjectDescriptionForAssemblyContextNested(qualifiedName, acceptor)]
		}
	}

	protected def createEObjectDescriptionForUsageModel(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		val usageModel = eObject as UsageModel
		acceptor.accept(
			EObjectDescription.create(QualifiedName.create(getEResourceFileName(usageModel.eResource)), usageModel))
	}

	protected def createEObjectDescriptionForAllocation(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		val allocation = eObject as Allocation
		acceptor.accept(
			EObjectDescription.create(QualifiedName.create(getEResourceFileName(allocation.eResource)), allocation))
	}

}
