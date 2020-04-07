/*
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicType;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicLiteral;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicType;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.Enumeration;

import de.sebinside.dcp.dsl.dSL.CharacteristicTypeSelector;
import de.sebinside.dcp.dsl.dSL.DSLPackage;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class DSLScopeProvider extends AbstractDSLScopeProvider {
	@Override
	public IScope getScope(EObject context, EReference reference) {

		if (context instanceof CharacteristicTypeSelector
						&& reference == DSLPackage.Literals.CHARACTERISTIC_TYPE_SELECTOR__LITERALS) {

			CharacteristicType type = ((CharacteristicTypeSelector) context).getRef().getRef();

			// The DSL is intended to only work with EnumCharacteristicType
			if (type instanceof EnumCharacteristicType) {
				EnumCharacteristicType enumType = (EnumCharacteristicType) type;
				Enumeration literalEnumeration = enumType.getEnum();

				// This is the case if the characteristic type is invalid referenced
				if (literalEnumeration != null) {
					List<EnumCharacteristicLiteral> literals = literalEnumeration.getLiterals();

					IScope scope = Scopes.scopeFor(literals, literal -> QualifiedName.create(literal.getEntityName()),
							IScope.NULLSCOPE);

					return scope;
				}
			}
			return super.getScope(context, reference);
		}
		
		return super.getScope(context, reference);
	}
}
