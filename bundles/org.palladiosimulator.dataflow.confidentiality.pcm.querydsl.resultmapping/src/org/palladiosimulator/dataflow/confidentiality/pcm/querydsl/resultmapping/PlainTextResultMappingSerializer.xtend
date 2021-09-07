package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.resultmapping

import com.google.inject.Injector
import java.util.List
import org.eclipse.xtext.serializer.ISerializer
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.PCMDFDConstraintLanguageStandaloneSetup
import org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.internal.QuerydslActivator
import org.palladiosimulator.dataflow.confidentiality.transformation.dcp.resultmapping.Violation

class PlainTextResultMappingSerializer extends org.palladiosimulator.dataflow.confidentiality.transformation.dcp.resultmapping.serialize.PlainTextResultMappingSerializer {

	protected new(boolean serializeFlowTree) {
		super(serializeFlowTree)
	}

    override ISerializer createDSLSerializer() {
        var Injector injector = null;
        try {
            injector = QuerydslActivator.getInstance().getInjector(QuerydslActivator.ORG_PALLADIOSIMULATOR_DATAFLOW_CONFIDENTIALITY_PCM_QUERYDSL_PCMDFDCONSTRAINTLANGUAGE);
        } catch (NoClassDefFoundError e) {
            injector = new PCMDFDConstraintLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
        }
        return injector.getInstance(ISerializer);
    }

    override serializeViolations(List<Violation> violations) {
        '''
        «FOR i : 0..(violations.size - 1) SEPARATOR "\n"»
            «i+1». «escape(crossPlatformConverter.convertVariable(getParameterOrCallState(violations.get(i))))» is not allowed to be «highlight(mapQueryType(violations.get(i)))» in «escape(crossPlatformConverter.resolveQualifiedName(violations.get(i).operation, false))».
            «serializeViolationClassVariables(violations.get(i).classVariables)»
            «serializeViolationCharacteristicVariables(violations.get(i).characteristicVariables)»
            «IF serializeFlowTree»
                «serializeViolationCallStack(violations.get(i).callStack)»
            «ENDIF»
        «ENDFOR»
        '''
    }

}