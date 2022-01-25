package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.tests

import java.util.Arrays
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.TransformPCMDFDWithConstraintsToPrologWorkflowFactory
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs.TransformPCMDFDWithConstraintsToPrologJobBuilder
import org.palladiosimulator.pcm.allocation.Allocation
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall
import org.palladiosimulator.pcm.usagemodel.UsageModel
import org.palladiosiumlator.dataflow.confidentiality.pcm.transformation.dcp.workflow.tests.util.PCMDCPDSLStandaloneUtil
import org.prolog4j.Prover
import org.prolog4j.swicli.DefaultSWIPrologExecutableProvider
import org.prolog4j.swicli.SWIPrologCLIProverFactory
import org.prolog4j.swicli.SWIPrologCLIProverFactory.SWIPrologExecutableProviderStandalone
import org.prolog4j.swicli.enabler.SWIPrologEmbeddedFallbackExecutableProvider
import org.apache.commons.lang3.mutable.MutableObject
import static org.junit.jupiter.api.Assertions.*

class RunDSLQueryTest {
	static SWIPrologCLIProverFactory proverFactory
	protected Prover prover
	protected ResourceSetImpl rs

	@BeforeAll
	static def void init() {
		PCMDCPDSLStandaloneUtil.init
		var factory = new SWIPrologCLIProverFactory(
			Arrays.asList(new SWIPrologExecutableProviderStandalone(new DefaultSWIPrologExecutableProvider(), 2),
				new SWIPrologExecutableProviderStandalone(new SWIPrologEmbeddedFallbackExecutableProvider(), 1)));
		proverFactory = factory;
	}

	@BeforeEach
	def void setup() {
		prover = proverFactory.createProver
		rs = new ResourceSetImpl
	}

	@Test
	def void testTravelPlannerRBAC() {
		val usageModelURI = PCMDCPDSLStandaloneUtil.getModelURI("newUsageModel.usagemodel")
		val usageModelResource = rs.getResource(usageModelURI, true)
		var UsageModel usageModel = usageModelResource.contents.get(0) as UsageModel

		val allocationModelURI = PCMDCPDSLStandaloneUtil.getModelURI("newAllocation.allocation")
		val allocationModelResource = rs.getResource(allocationModelURI, true)
		var Allocation allocationModel = allocationModelResource.contents.get(0) as Allocation
		EcoreUtil.resolveAll(rs)

		// modify usageModel
		val elsc = usageModel.usageScenario_UsageModel.get(1).scenarioBehaviour_UsageScenario.actions_ScenarioBehaviour.
			filter(EntryLevelSystemCall).findFirst[entityName.contains("User.bookFlight.bookFlight")]
		val outputCharacterisations = elsc.inputParameterUsages_EntryLevelSystemCall.get(0).
			variableCharacterisation_VariableUsage
		outputCharacterisations.remove(1)

		// prover factory	
		val MutableObject<String> actual = new MutableObject(null)
		var builder = new TransformPCMDFDWithConstraintsToPrologJobBuilder()
			.addSerializeModelToString
			.addSerializeDCPPrologToString
			.addUsageModels(usageModel)
			.addAllocationModel(allocationModel)
			.addDCPDSL(PCMDCPDSLStandaloneUtil.getModelURI("test.DCPDSL"))
			.addProverFactory(proverFactory)
			.setSerializeFlowTree(false)
			.serializeResultHandler = [result|actual.value = result]
		var job = builder.build
		val workflow = TransformPCMDFDWithConstraintsToPrologWorkflowFactory.createWorkflow(job)
		workflow.run

		assertEquals('''
			-------------- GENERAL ---------------
			Constraint count: 1
			------------ CONSTRAINT 1 ------------
			Constraint name: "RBAC"
			Violations found: 5
			--------- CONSTRAINT DETAILS ---------
			Data Characteristics: "allowedRoles" set to variable "authRoles"
			Condition: NEVER FLOWS
			Destination Characteristics: "ownedRoles" set to variable "compRoles"
			------- CONSTRAINT VIOLATIONS --------
			1. "ccd (1vdi5kq1lj0aox3a90paf7jgf)" is not allowed to be input in "SEFF Entry Assembly_AirlineLogic.bookFlight (9wiwpw8ljior6vql0wcws9eys)".
				- Characteristic Variables: set variable "authRoles" has value "User", set variable "compRoles" has value "Airline"
			
			2. "ccd (ab0eh30iicmcq89b0rx7vze00)" is not allowed to be input in "Action Entry AirlineLogic.bookFlight.callDB (bvbi6fnbjn119co5asc77rpus)".
				- Characteristic Variables: set variable "authRoles" has value "User", set variable "compRoles" has value "Airline"
			
			3. "booking (64bw8b418hk3rj05kju04ajp0)" is not allowed to be input in "SEFF Entry Assembly_BookingStorage.addBooking (7vvjl8uwklupp1i3f5zvu7v05)".
				- Characteristic Variables: set variable "authRoles" has value "User", set variable "compRoles" has value "Airline"
			
			4. "input (9mjx9mp47inwtvsw0s5x34j4v)" is not allowed to be input in "Store Assembly_BookingStorage.BookingStorage (60ngrmcaiwyfoxjav31glzrb8)".
				- Characteristic Variables: set variable "authRoles" has value "User", set variable "compRoles" has value "Airline", "Airline"
			
			5. "RETURN (2a5qrvwbanm0ehlawp9953af9)" is not allowed to be input in "SEFF Exit Assembly_BookingStorage.getBooking (bni5bxe53ae3qo1q60t311xo6)".
				- Characteristic Variables: set variable "authRoles" has value "User", set variable "compRoles" has value "Airline", "Airline"
		'''.toString.replaceAll("\\r\\n", "\\n"),
		actual.value.replaceAll("\\r\\n", "\\n"))
	}
}
