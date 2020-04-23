package de.sebinside.dcp.dsl.resultmapping.generate

import java.util.List
import java.util.Optional
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import de.sebinside.dcp.dsl.dSL.CharacteristicClass

class Violation {

	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) String queryType
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER)List<String> callStack
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) String operation
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) Optional<String> parameter
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) Optional<String> callState
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) Map<String, String> classVariableValueMap
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) Map<String, CharacteristicClass> classVariableClassMap

	new() {
	}

	new(String queryType, List<String> callStack, String operation, Optional<String> parameter,
		Optional<String> callState, Map<String, String> classVariableValueMap, Map<String, CharacteristicClass> classVariableClassMap) {
		this.queryType = queryType
		this.callStack = callStack
		this.operation = operation
		this.parameter = parameter
		this.callState = callState
		this.classVariableValueMap = classVariableValueMap
		this.classVariableClassMap = classVariableClassMap
	}

}
