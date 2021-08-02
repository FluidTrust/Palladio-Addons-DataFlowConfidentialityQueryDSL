package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl

import com.google.inject.Inject
import de.sebinside.dcp.dsl.dSL.Include
import java.util.HashMap
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.scoping.impl.ImportUriResolver
import org.eclipse.xtext.util.IAcceptor
import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.characteristics.CharacteristicTypeDictionary
import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.characteristics.CharacteristicsPackage
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.Model
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType
import org.palladiosimulator.pcm.allocation.Allocation
import org.palladiosimulator.pcm.allocation.AllocationPackage
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.core.composition.CompositionPackage
import org.palladiosimulator.pcm.repository.Repository
import org.palladiosimulator.pcm.repository.RepositoryPackage
import org.palladiosimulator.pcm.usagemodel.UsageModel
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage

class ExtendedResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	public static final String INCLUDES = "includes"

	@Inject
	ImportUriResolver uriResolver

	override createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (eObject instanceof Model) {
			createEObjectDescriptionForModel(eObject, acceptor)
			return true
		}

		if (eObject.eClass === DataDictionaryCharacterizedPackage.eINSTANCE.enumCharacteristicType) {
			createEObjectDescriptionForEnumCharacteristicType(eObject, acceptor)
			return false
		}
		if (eObject.eClass === DataDictionaryCharacterizedPackage.eINSTANCE.dataDictionaryCharacterized) {
			createEObjectDescriptionForCharacteristicTypeContainer(eObject, acceptor)
			return false
		}
		
		if (eObject.eClass === CharacteristicsPackage.eINSTANCE.characteristicTypeDictionary) {
			createEObjectDescriptionForPCMCharacteristicTypeContainer(eObject, acceptor)
			return true
		}

		if (eObject.eClass === AllocationPackage.eINSTANCE.allocation) {
			createEObjectDescriptionForAllocation(eObject, acceptor)
			return false
		}
		if (eObject.eClass === UsagemodelPackage.eINSTANCE.usageModel) {
			createEObjectDescriptionForUsageModel(eObject, acceptor)
			return false
		}
				
		if(eObject.eClass === RepositoryPackage.eINSTANCE.repository) {
			createEObjectDescriptionForRepository(eObject, acceptor)
			return false
		}

		if (eObject.eClass == CompositionPackage.eINSTANCE.assemblyContext) {
			createEObjectDescriptionForAssemblyContext(eObject, acceptor)
			return false
		}

		super.createEObjectDescriptions(eObject, acceptor)
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
		acceptor.accept(EObjectDescription.create(QualifiedName.create(assemblyContext.entityName), assemblyContext))
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

	protected def createEObjectDescriptionForCharacteristicTypeContainer(EObject eObject,
		IAcceptor<IEObjectDescription> acceptor) {
		val typeContainer = eObject as DataDictionaryCharacterized
		acceptor.accept(
			EObjectDescription.create(QualifiedName.create(getEResourceFileName(typeContainer.eResource)),
				typeContainer));
	}

	private def getEResourceFileName(Resource eResource) {
		eResource.URI.lastSegment.substring(0, eResource.URI.lastSegment.lastIndexOf("."))
	}

	def void createEObjectDescriptionForModel(Model model, IAcceptor<IEObjectDescription> acceptor) {
		val uris = newArrayList()
		model.elements.filter[element|element instanceof Include].forEach[uris.add(uriResolver.apply(it))]
		val userData = new HashMap<String, String>
		userData.put(INCLUDES, uris.join(","))
		acceptor.accept(EObjectDescription.create(QualifiedName.create(model.eResource.URI.toString), model, userData))
	}

	protected def void createEObjectDescriptionForEnumCharacteristicType(EObject eObject,
		IAcceptor<IEObjectDescription> acceptor) {
		val characteristicType = eObject as EnumCharacteristicType
		acceptor.accept(
			EObjectDescription.create(QualifiedName.create(characteristicType.name), characteristicType))
		for (literal : characteristicType.type.literals) {
			acceptor.accept(
				EObjectDescription.create(QualifiedName.create(characteristicType.name, literal.name),
					literal))
		}
	}
}
