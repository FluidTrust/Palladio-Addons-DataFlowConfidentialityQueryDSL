package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.tests

import com.google.inject.Inject
import com.google.inject.Provider
import de.sebinside.dcp.dsl.dSL.DSLFactory
import java.io.ByteArrayOutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.characteristics.CharacteristicTypeDictionary
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.PCMDFDConstraintLanguageFactory
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertNotNull

@ExtendWith(InjectionExtension)
@InjectWith(PCMDFDConstraintLanguageInjectorProvider)
class FormatterTest {

	static extension val PCMDFDConstraintLanguageFactory factory = PCMDFDConstraintLanguageFactory.eINSTANCE
	static extension val DSLFactory factory2 = DSLFactory.eINSTANCE
	static val TEST_PROJECT_NAME = "org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.tests"

	@Inject
	var Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	var FileExtensionProvider fileExtensionProvider;

	CharacteristicTypeDictionary characteristicTypeDict
	ResourceSet rs;
	Resource r;

	@BeforeAll
	static def void init() {
		StandaloneInitializerBuilder.builder.registerProjectURI(FormatterTest, TEST_PROJECT_NAME).build.init
	}

	@BeforeEach
	def void setup() {
		rs = resourceSetProvider.get
		val baseURI = URI.createPlatformPluginURI("/" + TEST_PROJECT_NAME + "/models", false)
		val characteristicTypeURI = baseURI.appendSegment("EnumCharacteristicTypes.xmi")
		val characteristicTypeResource = rs.getResource(characteristicTypeURI, true)
		characteristicTypeDict = characteristicTypeResource.contents.filter(CharacteristicTypeDictionary).findFirst [
			true
		]
		val resourceURI = baseURI.appendSegment("foo." + fileExtensionProvider.primaryFileExtension)
		r = rs.createResource(resourceURI)
	}

	@Test
	def void testModelContainingOneImport() {
		minimalModel.assertFormatting('''import "«characteristicTypeDict.eResource.URI.lastSegment»"''')
	}
	
	protected def getMinimalModel() {
		return factory.createModel => [
			elements += createInclude => [
				importURI = characteristicTypeDict.eResource.URI.lastSegment
			]
		]
	}

	protected def assertFormatting(EObject model, String expected) {
		val actual = model.serialize
		assertNotNull(actual)
		assertEquals(expected, actual)
	}

	protected def serialize(EObject eobject) {
		r.contents.add(eobject)
		val serializationOptions = SaveOptions.newBuilder.format.options.toOptionsMap
		try (var baos = new ByteArrayOutputStream) {
			r.save(baos, serializationOptions)
			return baos.toString
		}
	}
}
