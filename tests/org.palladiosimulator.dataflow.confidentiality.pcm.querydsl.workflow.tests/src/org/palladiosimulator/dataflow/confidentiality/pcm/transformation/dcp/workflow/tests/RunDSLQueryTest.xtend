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

		assertTrue(actual.value.startsWith('''
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
		'''))
	}
}
