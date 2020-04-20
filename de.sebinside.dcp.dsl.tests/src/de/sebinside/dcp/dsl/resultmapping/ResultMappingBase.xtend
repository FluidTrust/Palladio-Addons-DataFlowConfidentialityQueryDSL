package de.sebinside.dcp.dsl.resultmapping

import de.sebinside.dcp.dsl.tests.DSLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.^extension.ExtendWith
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.prolog4j.IProverFactory
import org.prolog4j.Prover
import org.prolog4j.tuprolog.TuPrologProverFactory
import javax.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import de.sebinside.dcp.dsl.dSL.Model
import java.nio.file.Files
import java.nio.file.Paths
import org.prolog4j.Solution
import de.sebinside.dcp.dsl.resultmapping.serialize.ResultMappingSerializer
import de.sebinside.dcp.dsl.resultmapping.serialize.PlainTextSerializer
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import java.io.File
import java.io.FileInputStream
import org.eclipse.emf.ecore.resource.Resource
import java.util.Map
import java.util.HashMap

@ExtendWith(InjectionExtension)
@InjectWith(DSLInjectorProvider)
class ResultMappingBase {

	@Inject
	ParseHelper<Model> parseHelper

	static IProverFactory proverFactory;
	protected Prover prover;
	protected ResultMappingSerializer serializer;

	@BeforeAll
	static def void init() {
		proverFactory = new TuPrologProverFactory()
	}

	@BeforeEach
	def void setup() {
		prover = proverFactory.createProver();
		serializer = new PlainTextSerializer()
	}

	protected def Solution<Object> createSolution(String caseName, String query) {
		val theory = loadCombinedPrologTheory(caseName);
		prover.loadTheory(theory);
		prover.query(query).solve();
	}

	private def String loadCombinedPrologTheory(String caseName) {
		val model = readResultMappingFile('''«caseName»/model.pl''')
		val constraint = readResultMappingFile('''«caseName»/constraint.pl''')
		model + "\n" + constraint
	}

	protected def Model loadDSLModel(String caseName) {
		val dslPath = '''«caseName»/dsl/input.DCPDSL'''

		val resourceSet = new ResourceSetImpl
		//val res = resourceSet.createResource(createPlatformURI(createResultMappingPath("shop-class/dsl/shop.xmi")))
		//val uriMap = new HashMap<URI, Resource>;
		//uriMap.put(URI.createPlatformResourceURI("/de.sebinside.dcp.dsl.tests/resultmapping/shop-class/dsl/shop.xmi", false), res)
		//uriMap.put(URI.createURI("/de.sebinside.dcp.dsl.tests/resultmapping/shop-class/dsl/shop.xmi"), res)
		//resourceSet.URIResourceMap = uriMap
		val inputStream = new FileInputStream(new File(createResultMappingPath(dslPath)))

		parseHelper.parse(inputStream, createPlatformURI(createResultMappingPath(dslPath)), null, resourceSet)
	}

	private def readResultMappingFile(String relativePath) {
		new String(Files.readAllBytes(Paths.get(createResultMappingPath(relativePath))));
	}

	private static def String createResultMappingPath(String relativePath) {
		'''resultmapping/«relativePath»'''
	}

	private static def createPlatformURI(String relativePath) {
		URI.createPlatformResourceURI("/de.sebinside.dcp.dsl.tests/" + relativePath, false)
	}

}
