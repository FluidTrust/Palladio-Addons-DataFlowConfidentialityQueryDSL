package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.tests

import com.google.inject.Inject
import com.google.inject.Provider
import de.uka.ipd.sdq.identifier.Identifier
import java.io.ByteArrayOutputStream
import java.util.Collection
import java.util.Stack
import java.util.UUID
import java.util.function.Predicate
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource.Diagnostic
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.util.StringInputStream
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.characteristics.CharacteristicTypeDictionary
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.generator.PCMDFDConstraintLanguageGenerator
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.pCMDFDConstraintLanguage.Model
import org.palladiosimulator.dataflow.confidentiality.pcm.testmodels.Activator
import org.palladiosimulator.dataflow.confidentiality.pcm.workflow.TransitiveTransformationTrace
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal
import org.palladiosimulator.pcm.core.entity.Entity
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder
import tools.mdsd.library.standalone.initialization.emfprofiles.EMFProfileInitializationTask

import static org.junit.jupiter.api.Assertions.*
import static org.mockito.ArgumentMatchers.*
import static org.mockito.Mockito.*

@ExtendWith(InjectionExtension)
@InjectWith(PCMDFDConstraintLanguageInjectorProvider)
class PCMDFDConstraintLanguageGeneratorTest {

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	@Inject
	FileExtensionProvider fileExtensionProvider

	PCMDFDConstraintLanguageGenerator subject
	
	TransitiveTransformationTrace trace

	@BeforeAll
	static def void init() {
		StandaloneInitializerBuilder.builder
		.registerProjectURI(Activator, "org.palladiosimulator.dataflow.confidentiality.pcm.testmodels")
		.build
		.init
	}

	@BeforeEach
	def void setup() {
		// the injection extensions reset the package registry before every test run
		// because EMFProfiles do not register profiles as metamodels (despite the
		// fact that they are metamodels), we have to work around this problem
		new EMFProfileInitializationTask("org.palladiosimulator.dataflow.confidentiality.pcm.model.profile",
			"profile.emfprofile_diagram").initilizationWithoutPlatform
		
		// real @BeforeEach
		subject = new PCMDFDConstraintLanguageGenerator()
		trace = mock(TransitiveTransformationTrace)
		subject.transitiveTransformationTrace = trace
	}

	@Test
	def void testInformationFlowLowHigh() {		
		runTest('''
				type Clearance : Zone
				type Classification : Classification
				constraint Test {
					data.property.Classification.High NEVER FLOWS element.property.Clearance.Attack
				}
			''',
		"JPMail_CallReturn_2L/CharacteristicTypes.characteristics",
		'''
				constraint_Test(ConstraintName, QueryType, N, PIN, S) :-
					ConstraintName = 'Test',
					constraint_Test_InputPin(QueryType, N, PIN, S).
				constraint_Test_InputPin(QueryType, N, PIN, S) :-
					QueryType = 'InputPin',
					inputPin(N, PIN),
					flowTree(N, PIN, S),
					nodeCharacteristic(N, 'Zone (_f_WFwTy7EeuXmedn0l6p7g)', 'Attack (_do_5cDy7EeuXmedn0l6p7g)'),
					characteristic(N, PIN, 'Classification (_eX6N4Ty7EeuXmedn0l6p7g)', 'High (_34Xl0Dy6EeuXmedn0l6p7g)', S).
			'''
		)
	}

	@Test
	def void testInformationFlowLinearOrderedLattice() {		
		runTest('''
				type SecurityLevel : DataClassification
				type Clearance : NodeClearance
				constraint Test {
					data.attribute.SecurityLevel.$CLASS NEVER FLOWS element.property.Clearance.$CLEAR
					WHERE index(CLASS) > index(CLEAR)
				}
			''',
		"TravelPlanner_CallReturn_HL/CharacteristicTypeDictionary.xmi",
		'''
				constraint_Test(ConstraintName, QueryType, N, PIN, S, Var_CLEAR, Var_CLASS) :-
					ConstraintName = 'Test',
					constraint_Test_InputPin(QueryType, N, PIN, S, Var_CLEAR, Var_CLASS).
				constraint_Test_InputPin(QueryType, N, PIN, S, Var_CLEAR, Var_CLASS) :-
					QueryType = 'InputPin',
					inputPin(N, PIN),
					flowTree(N, PIN, S),
					nodeCharacteristic(N, 'NodeClearance (_voPsQQcQEeuCO_LUOeqqZQ)', Var_CLEAR),
					characteristic(N, PIN, 'DataClassification (_t51CoQcQEeuCO_LUOeqqZQ)', Var_CLASS, S),
					(
						characteristicTypeValue('DataClassification (_t51CoQcQEeuCO_LUOeqqZQ)', Var_CLASS, Temp_CLASS_INDEX),
						characteristicTypeValue('NodeClearance (_voPsQQcQEeuCO_LUOeqqZQ)', Var_CLEAR, Temp_CLEAR_INDEX),
						Temp_CLASS_INDEX > Temp_CLEAR_INDEX
					).
			'''
		)
	}
	
	@Test
	def void testDACStatic() {
		runTest('''
				type Identity : Identity
				type ReadAccess : ReadPermission
				type WriteAccess : WritePermission
				constraint ReadViolation {
					data.any NEVER FLOWS element.type.UserAction & element.property.Identity.$IDENT
					FROM element.type.Store & element.property.ReadAccess.$RA{}
					WHERE !elementOf(IDENT, RA)
				}
				constraint WriteViolation {
					data.any NEVER FLOWS element.type.Store & element.property.WriteAccess.$WA{}
					FROM element.type.UserAction & element.property.Identity.$IDENT
					WHERE !elementOf(IDENT, WA)
				}
			''',
		"ImageSharing_CallReturn_DAC/CharacteristicTypes.characteristics",
		'''
			constraint_ReadViolation(ConstraintName, QueryType, N, PIN, S, N_FROM, Var_IDENT, VarSet_RA) :-
				ConstraintName = 'ReadViolation',
				constraint_ReadViolation_InputPin(QueryType, N, PIN, S, N_FROM, Var_IDENT, VarSet_RA).
			constraint_ReadViolation_InputPin(QueryType, N, PIN, S, N_FROM, Var_IDENT, VarSet_RA) :-
				QueryType = 'InputPin',
				inputPin(N, PIN),
				flowTree(N, PIN, S),
				(
					containedInScenarioBehaviour(N),
					nodeCharacteristic(N, 'Identity (_2EyPcT1WEeuNWouTGsQ1xw)', Var_IDENT)
				),
				(
					isAStore(N_FROM),
					findall(R, nodeCharacteristic(N_FROM, 'ReadPermission (_0NogkT1WEeuNWouTGsQ1xw)', R), VarSet_RA),
					traversedNode(S, N_FROM)
				),
				\+ memberchk(Var_IDENT, VarSet_RA).
			constraint_WriteViolation(ConstraintName, QueryType, N, PIN, S, N_FROM, VarSet_WA, Var_IDENT) :-
				ConstraintName = 'WriteViolation',
				constraint_WriteViolation_InputPin(QueryType, N, PIN, S, N_FROM, VarSet_WA, Var_IDENT).
			constraint_WriteViolation_InputPin(QueryType, N, PIN, S, N_FROM, VarSet_WA, Var_IDENT) :-
				QueryType = 'InputPin',
				inputPin(N, PIN),
				flowTree(N, PIN, S),
				(
					isAStore(N),
					findall(R, nodeCharacteristic(N, 'WritePermission (_ynkhsT1WEeuNWouTGsQ1xw)', R), VarSet_WA)
				),
				(
					containedInScenarioBehaviour(N_FROM),
					nodeCharacteristic(N_FROM, 'Identity (_2EyPcT1WEeuNWouTGsQ1xw)', Var_IDENT),
					traversedNode(S, N_FROM)
				),
				\+ memberchk(Var_IDENT, VarSet_WA).
			'''
		)
	}
	
	@Test
	def void testMACNeedToKnow() {
		runTest('''
				type Compartment : Compartments
				type NeedToKnow : NeedsToKnow
				constraint ActorProcessTest {
					data.attribute.Compartment.$COMP{} NEVER FLOWS element.type.UserAction & element.property.NeedToKnow.$NTK{}
					WHERE !isEmpty(subtract(COMP, NTK))
				}
			''',
		"HealthRecord_CallReturn_MAC_NTK/characteristicTypes.characteristics",
		'''
			constraint_ActorProcessTest(ConstraintName, QueryType, N, PIN, S, VarSet_NTK, VarSet_COMP) :-
				ConstraintName = 'ActorProcessTest',
				constraint_ActorProcessTest_InputPin(QueryType, N, PIN, S, VarSet_NTK, VarSet_COMP).
			constraint_ActorProcessTest_InputPin(QueryType, N, PIN, S, VarSet_NTK, VarSet_COMP) :-
				QueryType = 'InputPin',
				inputPin(N, PIN),
				flowTree(N, PIN, S),
				(
					containedInScenarioBehaviour(N),
					findall(R, nodeCharacteristic(N, 'NeedsToKnow (_z02RgX1HEeySLaOi7Opbhw)', R), VarSet_NTK)
				),
				findall(V, characteristic(N, PIN, 'Compartments (_0R6oAX1HEeySLaOi7Opbhw)', V, S), VarSet_COMP),
				(
					subtract(VarSet_COMP, VarSet_NTK, Temp_0),
					\+ length(Temp_0, 0)
				).
		'''
		)
	}
	
	@Test
	def void testRBAC() {		
		runTest('''
				type AccessPermissions : AllowedRoles
				type Roles : OwnedRoles
				constraint Test {
					data.attribute.AccessPermissions.$PR{} NEVER FLOWS element.property.Roles.$AR{}
					WHERE isEmpty(intersection(PR, AR))
				}
			''',
		"TravelPlanner_CallReturn_RBAC/CharacteristicTypeDictionary.xmi",
		'''
				constraint_Test(ConstraintName, QueryType, N, PIN, S, VarSet_AR, VarSet_PR) :-
					ConstraintName = 'Test',
					constraint_Test_InputPin(QueryType, N, PIN, S, VarSet_AR, VarSet_PR).
				constraint_Test_InputPin(QueryType, N, PIN, S, VarSet_AR, VarSet_PR) :-
					QueryType = 'InputPin',
					inputPin(N, PIN),
					flowTree(N, PIN, S),
					findall(R, nodeCharacteristic(N, 'OwnedRoles (_voPsQQcQEeuCO_LUOeqqZQ)', R), VarSet_AR),
					findall(V, characteristic(N, PIN, 'AllowedRoles (_t51CoQcQEeuCO_LUOeqqZQ)', V, S), VarSet_PR),
					(
						intersection(VarSet_PR, VarSet_AR, Temp_0),
						length(Temp_0, 0)
					).
			'''
		)
	}
	
	@Test
	def void testABAC() {
		runTest('''
				type CustomerLocation : Origin
				type EmployeeLocation : Location
				type CustomerStatus : Status
				type EmployeeRole : Role
				
				const ER_CLERK{} = EmployeeRole.[Clerk]
				const ER_MANAGER{} = EmployeeRole.[Manager]
				const CS_CELEBRITY{} = CustomerStatus.[Celebrity]
				const CS_REGULAR{} = CustomerStatus.[Regular]
				
				constraint Test {
					data.attribute.CustomerLocation.$CL{} &
					data.attribute.CustomerStatus.$CS{}
						NEVER FLOWS
					element.property.EmployeeLocation.$EL{} &
					element.property.EmployeeRole.$ER{}
						WHERE
					!(
						(
							subset(ER, ER_MANAGER) & subset(ER_MANAGER, ER)
						) |	(
							subset(ER, ER_CLERK) & subset(ER_CLERK, ER) &
							subset(CS, CS_REGULAR) & subset(CS_REGULAR, CS) &
							subset(EL, CL) & subset(CL, EL)
						)
					)
				}
			''',
		"BankBranches_CallReturn_ABAC/CharacteristicTypes.characteristics",
		'''
				constraint_Test(ConstraintName, QueryType, N, PIN, S, VarSet_EL, VarSet_ER, VarSet_CL, VarSet_CS) :-
					ConstraintName = 'Test',
					constraint_Test_InputPin(QueryType, N, PIN, S, VarSet_EL, VarSet_ER, VarSet_CL, VarSet_CS).
				constraint_Test_InputPin(QueryType, N, PIN, S, VarSet_EL, VarSet_ER, VarSet_CL, VarSet_CS) :-
					QueryType = 'InputPin',
					VarSet_ER_CLERK = ['Clerk (_XOM9gD6uEeuVUal8mM_jUA)'],
					VarSet_ER_MANAGER = ['Manager (_Xd1U8D6uEeuVUal8mM_jUA)'],
					VarSet_CS_CELEBRITY = ['Celebrity (_a4A80D6uEeuVUal8mM_jUA)'],
					VarSet_CS_REGULAR = ['Regular (_amQecD6uEeuVUal8mM_jUA)'],
					inputPin(N, PIN),
					flowTree(N, PIN, S),
					(
						findall(R, nodeCharacteristic(N, 'Location (_RcmLQT6uEeuVUal8mM_jUA)', R), VarSet_EL),
						findall(R, nodeCharacteristic(N, 'Role (_dHgTMT6uEeuVUal8mM_jUA)', R), VarSet_ER)
					),
					(
						findall(V, characteristic(N, PIN, 'Origin (_R0RrcT6uEeuVUal8mM_jUA)', V, S), VarSet_CL),
						findall(V, characteristic(N, PIN, 'Status (_exwOgT6uEeuVUal8mM_jUA)', V, S), VarSet_CS)
					),
					\+ (
						subset(VarSet_ER, VarSet_ER_MANAGER),
						subset(VarSet_ER_MANAGER, VarSet_ER);
						subset(VarSet_ER, VarSet_ER_CLERK),
						subset(VarSet_ER_CLERK, VarSet_ER),
						subset(VarSet_CS, VarSet_CS_REGULAR),
						subset(VarSet_CS_REGULAR, VarSet_CS),
						subset(VarSet_EL, VarSet_CL),
						subset(VarSet_CL, VarSet_EL)
					).
			'''
		)
	}
	
	@Test
	def void testComplementOperator() {		
		runTest('''
				type AccessPermissions : AllowedRoles
				type Roles : OwnedRoles
				constraint Test {
					data.any NEVER FLOWS element.property.Roles.$AR{}
					WHERE isEmpty(complement[Roles,AccessPermissions](AR))
				}
			''',
		"TravelPlanner_CallReturn_RBAC/CharacteristicTypeDictionary.xmi",
		'''
				constraint_Test(ConstraintName, QueryType, N, PIN, S, VarSet_AR) :-
					ConstraintName = 'Test',
					constraint_Test_InputPin(QueryType, N, PIN, S, VarSet_AR).
				constraint_Test_InputPin(QueryType, N, PIN, S, VarSet_AR) :-
					QueryType = 'InputPin',
					inputPin(N, PIN),
					flowTree(N, PIN, S),
					findall(R, nodeCharacteristic(N, 'OwnedRoles (_voPsQQcQEeuCO_LUOeqqZQ)', R), VarSet_AR),
					(
						complement(['OwnedRoles (_voPsQQcQEeuCO_LUOeqqZQ)', 'AllowedRoles (_t51CoQcQEeuCO_LUOeqqZQ)'], VarSet_AR, Temp_0),
						length(Temp_0, 0)
					).
			'''
		)
	}
	
	@Test
	def void testGlobalSetConstants() {
		runTest('''
				type AccessPermissions : AllowedRoles
				type Roles : OwnedRoles
				const USER_LITERAL = Roles.User
				const ALL_LITERALS{} = Roles.*
				const EMPTY_LITERALS{} = []
				const SOME_LITERALS{} = Roles.[User, Airline]
				constraint Test {
					data.any NEVER FLOWS element.property.Roles.User
				}
			''',
		"TravelPlanner_CallReturn_RBAC/CharacteristicTypeDictionary.xmi",
		'''
				constraint_Test(ConstraintName, QueryType, N, PIN, S) :-
					ConstraintName = 'Test',
					constraint_Test_InputPin(QueryType, N, PIN, S).
				constraint_Test_InputPin(QueryType, N, PIN, S) :-
					QueryType = 'InputPin',
					Var_USER_LITERAL = 'User (_qmC9sAcQEeuCO_LUOeqqZQ)',
					VarSet_ALL_LITERALS = ['User (_qmC9sAcQEeuCO_LUOeqqZQ)', 'TravelAgency (_q6I-YAcQEeuCO_LUOeqqZQ)' , 'Airline (_rIUkUAcQEeuCO_LUOeqqZQ)'],
					VarSet_EMPTY_LITERALS = [],
					VarSet_SOME_LITERALS = ['User (_qmC9sAcQEeuCO_LUOeqqZQ)', 'Airline (_rIUkUAcQEeuCO_LUOeqqZQ)'],
					inputPin(N, PIN),
					flowTree(N, PIN, S),
					nodeCharacteristic(N, 'OwnedRoles (_voPsQQcQEeuCO_LUOeqqZQ)', 'User (_qmC9sAcQEeuCO_LUOeqqZQ)').
			'''
		)
	}
	
	@Test
	def void testIdentitySelectorStore() {
		runTest('''
			constraint Test {
				data.any NEVER FLOWS element.identity.Store.Assembly_Airline.Assembly_FlightDB
			}
			''',
		"TravelPlanner_CallReturn_RBAC/CharacteristicTypeDictionary.xmi",
		#["newSystem.system", "newRepository.repository"],
		'''
			constraint_Test(ConstraintName, QueryType, N, PIN, S) :-
				ConstraintName = 'Test',
				constraint_Test_InputPin(QueryType, N, PIN, S).
			constraint_Test_InputPin(QueryType, N, PIN, S) :-
				QueryType = 'InputPin',
				inputPin(N, PIN),
				flowTree(N, PIN, S),
				(
					N = 'Assembly_Airline.Assembly_FlightDB (_N-cZEDluEeunY9-OetIYyA)_0';
					N = 'Assembly_Airline.Assembly_FlightDB (_N-cZEDluEeunY9-OetIYyA)_1'
				).
			'''
		)
	}

	@Test
	def void testIdentitySelectorSEFF() {
		runTest('''
			constraint Test {
				data.any NEVER FLOWS element.identity.SEFF.Assembly_Airline.Assembly_AirlineLogic.addFlight
			}
			''',
		"TravelPlanner_CallReturn_RBAC/CharacteristicTypeDictionary.xmi",
		#["newSystem.system", "newRepository.repository"],
		'''
			constraint_Test(ConstraintName, QueryType, N, PIN, S) :-
				ConstraintName = 'Test',
				constraint_Test_InputPin(QueryType, N, PIN, S).
			constraint_Test_InputPin(QueryType, N, PIN, S) :-
				QueryType = 'InputPin',
				inputPin(N, PIN),
				flowTree(N, PIN, S),
				(
					N = 'Assembly_Airline.Assembly_AirlineLogic (_nVI7kDluEeunY9-OetIYyA)_0';
					N = 'Assembly_Airline.Assembly_AirlineLogic (_nVI7kDluEeunY9-OetIYyA)_1'
				).
			'''
		)
	}
	
	@Test
	def void testIdentitySelectorUserAction() {
		runTest('''
			constraint Test {
				data.any NEVER FLOWS element.identity.UserAction."User.User.bookFlight.findFlights"
			}
			''',
		"TravelPlanner_CallReturn_RBAC/CharacteristicTypeDictionary.xmi",
		#["newUsageModel.usagemodel"],
		'''
			constraint_Test(ConstraintName, QueryType, N, PIN, S) :-
				ConstraintName = 'Test',
				constraint_Test_InputPin(QueryType, N, PIN, S).
			constraint_Test_InputPin(QueryType, N, PIN, S) :-
				QueryType = 'InputPin',
				inputPin(N, PIN),
				flowTree(N, PIN, S),
				(
					N = 'User.bookFlight.findFlights (_I8izMDlzEeunY9-OetIYyA)_0';
					N = 'User.bookFlight.findFlights (_I8izMDlzEeunY9-OetIYyA)_1'
				).
			'''
		)
	}
	
	protected def runTest(String query, String dictionaryPath, String expected) {
		runTest(query, dictionaryPath, #[], expected)
	}
	
	protected def runTest(String query, String dictionaryPath, Iterable<String> furtherImports, String expected) {
		val actual = runGenerator(dictionaryPath, query, furtherImports)
		assertEquals(expected, actual)
	}

	protected def runGenerator(String dictionaryPath, CharSequence input, Iterable<String> furtherModelFiles) {
		val baseURI = URI.createPlatformPluginURI(
			"/org.palladiosimulator.dataflow.confidentiality.pcm.testmodels/models/", false);
		val relativeDictionaryURI = URI.createURI(dictionaryPath);
		val dictionaryURI = relativeDictionaryURI.resolve(baseURI)

		val rs = resourceSetProvider.get
		val rDictionary = rs.getResource(dictionaryURI, true)
		val dd = rDictionary.contents.get(0) as CharacteristicTypeDictionary
		
		when(trace.getFactId(any(Predicate))).thenAnswer(new Answer<Collection<String>>{
			override answer(InvocationOnMock invocation) throws Throwable {
				val predicate = invocation.getArgument(0) as Predicate<CharacteristicType>
				val matchingCts = dd.characteristicTypes.filter[ct|predicate.test(ct)]
				matchingCts.map[ct | '''«ct.name» («ct.id»)'''.toString].toList
			}
		})
		
		when(trace.getLiteralFactIds(any(EObject))).thenAnswer(new Answer<Collection<String>> {
			override answer(InvocationOnMock invocation) throws Throwable {
				val literal = invocation.getArgument(0) as Literal
				dd.characteristicEnumerations.flatMap[literals].filter[l|l.id == literal.id].map [ l |
					'''«l.name» («l.id»)'''
				].toList
			}
		})
		
		when(trace.getFactIds(any(EObject), any(Stack))).thenAnswer(new Answer<Collection<String>> {
			override answer(InvocationOnMock invocation) throws Throwable {
				val context = invocation.getArgument(1) as Stack<Entity>
				val element = invocation.getArgument(0) as Identifier
				val baseId = context.map[entityName].join(".") + ''' («element.id»)'''
				return #[baseId + "_0", baseId + "_1"]
			}
		})
		
		when(trace.getFactIds(any(EObject))).thenAnswer(new Answer<Collection<String>> {
			override answer(InvocationOnMock invocation) throws Throwable {
				val element = invocation.getArgument(0) as Entity
				val baseId = '''«element.entityName» («element.id»)'''
				return #[baseId + "_0", baseId + "_1"]
			}
		})
		
		val modelURI = dictionaryURI.trimSegments(1).appendSegment("query." +
			fileExtensionProvider.primaryFileExtension)
		val modelResource = rs.createResource(modelURI)
		var fullInput = '''
			import "«dictionaryURI.lastSegment»"
			«FOR file : furtherModelFiles»
				import "«file»"
			«ENDFOR»
			«input»
		'''
		try (var is = new StringInputStream(fullInput)) {
			modelResource.load(is, #{})
		}
		EcoreUtil.resolveAll(rs)
		assertTrue(modelResource.errors.isEmpty, serialize(modelResource.errors).toString)
		
		val model = modelResource.contents.iterator.next
		val program = subject.generateFromModel(model as Model)
		try (val baos = new ByteArrayOutputStream) {
			val r = rs.createResource(URI.createURI("virtual:/" + UUID.randomUUID.toString +  ".pl"))
			r.contents += program
			r.save(baos, #{})
			return baos.toString
		}
	}
	
	protected static def serialize(Collection<Diagnostic> diagnostics) '''
		«FOR diagnostic : diagnostics»
			«diagnostic.toString»
		«ENDFOR»
	'''

}
