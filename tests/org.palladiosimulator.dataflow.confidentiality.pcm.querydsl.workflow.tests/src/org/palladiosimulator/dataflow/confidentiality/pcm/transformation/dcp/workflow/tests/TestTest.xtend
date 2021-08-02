package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.tests

import org.prolog4j.swicli.SWIPrologCLIProverFactory
import org.prolog4j.Prover
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import java.util.Arrays
import org.prolog4j.swicli.SWIPrologCLIProverFactory.SWIPrologExecutableProviderStandalone
import org.prolog4j.swicli.enabler.SWIPrologEmbeddedFallbackExecutableProvider
import org.prolog4j.swicli.DefaultSWIPrologExecutableProvider
import org.palladiosimulator.pcm.usagemodel.UsageModel
import org.palladiosimulator.pcm.allocation.Allocation
import org.eclipse.emf.ecore.util.EcoreUtil
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs.TransformPCMDFDWithConstraintsToPrologJobBuilder
import org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.TransformPCMDFDWithConstraintsToPrologWorkflowFactory
import org.eclipse.emf.common.util.URI
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage
import org.palladiosiumlator.dataflow.confidentiality.pcm.transformation.dcp.workflow.tests.util.PCMDCPDSLStandaloneUtil

class TestTest {
	static SWIPrologCLIProverFactory proverFactory
	
	def static void main(String[] args) {
		PCMDCPDSLStandaloneUtil.init
		var Prover prover
		var ResourceSetImpl rs
		
		var factory = new SWIPrologCLIProverFactory(
			Arrays.asList(new SWIPrologExecutableProviderStandalone(new DefaultSWIPrologExecutableProvider(), 2),
				new SWIPrologExecutableProviderStandalone(new SWIPrologEmbeddedFallbackExecutableProvider(), 1)));
		proverFactory = factory;
		prover = proverFactory.createProver
		rs = new ResourceSetImpl
		
		var path = "/home/nicolas/Dokumente/Uni/FluidTrust/Palladio-Addons-DataFlowConfidentiality/tests/org.palladiosimulator.dataflow.confidentiality.pcm.testmodels/models/TravelPlanner_CallReturn_RBAC"
		
		val usageModelURI = URI.createFileURI(path + "/newUsageModel.usagemodel")
		val usageModelResource = rs.getResource(usageModelURI, true)
		var UsageModel usageModel = usageModelResource as UsageModel
		
		val allocationModelURI = URI.createFileURI(path + "/newAllocation.allocation")
		val allocationModelResource = rs.getResource(allocationModelURI, true)
		var Allocation allocationModel = allocationModelResource as Allocation
		EcoreUtil.resolveAll(rs)
		
		var builder = new TransformPCMDFDWithConstraintsToPrologJobBuilder()
			.addSerializeModelToString
			.addSerializeDCPPrologToString
			.addUsageModels(usageModel)
			.addAllocationModel(allocationModel)
			.addDCPDSL(URI.createFileURI(path + "/test.DCPDSL"))
		var job = builder.build
		val workflow = TransformPCMDFDWithConstraintsToPrologWorkflowFactory.createWorkflow(job)
		workflow.run
		
		val program = workflow.prologProgram
		val constraints = workflow.prologConstraints
		
		prover.loadTheory(program.get)
		prover.addTheory(constraints.get)
		
		val query = prover.query("")
		val solution = query.solve()
		println(solution.size)
	}
}