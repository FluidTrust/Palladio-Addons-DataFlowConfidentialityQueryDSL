/*
 * generated by Xtext 2.21.0
 */
package de.sebinside.dcp.dsl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.sebinside.dcp.dsl.ide.contentassist.antlr.internal.InternalDSLParser;
import de.sebinside.dcp.dsl.services.DSLGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class DSLParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(DSLGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, DSLGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getAbstractElementAccess().getAlternatives(), "rule__AbstractElement__Alternatives");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getAlternatives_2(), "rule__CharacteristicTypeSelector__Alternatives_2");
			builder.put(grammarAccess.getCharacteristicVariableTypeAccess().getAlternatives(), "rule__CharacteristicVariableType__Alternatives");
			builder.put(grammarAccess.getDataSelectorAccess().getAlternatives(), "rule__DataSelector__Alternatives");
			builder.put(grammarAccess.getCharacteristicSelectorAccess().getAlternatives(), "rule__CharacteristicSelector__Alternatives");
			builder.put(grammarAccess.getCharacteristicClassSelectorAccess().getAlternatives(), "rule__CharacteristicClassSelector__Alternatives");
			builder.put(grammarAccess.getDestinationSelectorAccess().getAlternatives(), "rule__DestinationSelector__Alternatives");
			builder.put(grammarAccess.getNodeIdentitiySelectorAccess().getAlternatives(), "rule__NodeIdentitiySelector__Alternatives");
			builder.put(grammarAccess.getReferenceAccess().getAlternatives(), "rule__Reference__Alternatives");
			builder.put(grammarAccess.getCharacteristicSetReferenceAccess().getAlternatives(), "rule__CharacteristicSetReference__Alternatives");
			builder.put(grammarAccess.getOperationAccess().getAlternatives(), "rule__Operation__Alternatives");
			builder.put(grammarAccess.getCharacteristsicSetOperationAccess().getAlternatives(), "rule__CharacteristsicSetOperation__Alternatives");
			builder.put(grammarAccess.getLogicalNegationOperationAccess().getAlternatives(), "rule__LogicalNegationOperation__Alternatives");
			builder.put(grammarAccess.getEncapsulatedLogicalOperationAccess().getAlternatives(), "rule__EncapsulatedLogicalOperation__Alternatives");
			builder.put(grammarAccess.getSimpleBooleanOperationAccess().getAlternatives(), "rule__SimpleBooleanOperation__Alternatives");
			builder.put(grammarAccess.getTargetModelTypeAccess().getAlternatives(), "rule__TargetModelType__Alternatives");
			builder.put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
			builder.put(grammarAccess.getTargetModelTypeDefAccess().getGroup(), "rule__TargetModelTypeDef__Group__0");
			builder.put(grammarAccess.getTargetModelTypeDefAccess().getGroup_2(), "rule__TargetModelTypeDef__Group_2__0");
			builder.put(grammarAccess.getTargetModelTypeDefAccess().getGroup_2_2(), "rule__TargetModelTypeDef__Group_2_2__0");
			builder.put(grammarAccess.getAbstractElementAccess().getGroup_4(), "rule__AbstractElement__Group_4__0");
			builder.put(grammarAccess.getCharacteristicTypeAccess().getGroup(), "rule__CharacteristicType__Group__0");
			builder.put(grammarAccess.getCharacteristicClassAccess().getGroup(), "rule__CharacteristicClass__Group__0");
			builder.put(grammarAccess.getCharacteristicClassAccess().getGroup_4(), "rule__CharacteristicClass__Group_4__0");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getGroup(), "rule__CharacteristicTypeSelector__Group__0");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getGroup_2_0(), "rule__CharacteristicTypeSelector__Group_2_0__0");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getGroup_2_1(), "rule__CharacteristicTypeSelector__Group_2_1__0");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getGroup_2_1_2(), "rule__CharacteristicTypeSelector__Group_2_1_2__0");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getGroup_2_2(), "rule__CharacteristicTypeSelector__Group_2_2__0");
			builder.put(grammarAccess.getCharacteristicSetAccess().getGroup(), "rule__CharacteristicSet__Group__0");
			builder.put(grammarAccess.getIncludeAccess().getGroup(), "rule__Include__Group__0");
			builder.put(grammarAccess.getConstraintAccess().getGroup(), "rule__Constraint__Group__0");
			builder.put(grammarAccess.getRuleAccess().getGroup(), "rule__Rule__Group__0");
			builder.put(grammarAccess.getRuleAccess().getGroup_1(), "rule__Rule__Group_1__0");
			builder.put(grammarAccess.getRuleAccess().getGroup_4(), "rule__Rule__Group_4__0");
			builder.put(grammarAccess.getAttributeSelectorAccess().getGroup(), "rule__AttributeSelector__Group__0");
			builder.put(grammarAccess.getAttributeClassSelectorAccess().getGroup(), "rule__AttributeClassSelector__Group__0");
			builder.put(grammarAccess.getPropertySelectorAccess().getGroup(), "rule__PropertySelector__Group__0");
			builder.put(grammarAccess.getPropertyClassSelectorAccess().getGroup(), "rule__PropertyClassSelector__Group__0");
			builder.put(grammarAccess.getNodeIdentitiySelectorAccess().getGroup_0(), "rule__NodeIdentitiySelector__Group_0__0");
			builder.put(grammarAccess.getNodeIdentitiySelectorAccess().getGroup_1(), "rule__NodeIdentitiySelector__Group_1__0");
			builder.put(grammarAccess.getStatementAccess().getGroup(), "rule__Statement__Group__0");
			builder.put(grammarAccess.getConditionAccess().getGroup(), "rule__Condition__Group__0");
			builder.put(grammarAccess.getLogicalOrOperationAccess().getGroup(), "rule__LogicalOrOperation__Group__0");
			builder.put(grammarAccess.getLogicalOrOperationAccess().getGroup_1(), "rule__LogicalOrOperation__Group_1__0");
			builder.put(grammarAccess.getLogicalAndOperationAccess().getGroup(), "rule__LogicalAndOperation__Group__0");
			builder.put(grammarAccess.getLogicalAndOperationAccess().getGroup_1(), "rule__LogicalAndOperation__Group_1__0");
			builder.put(grammarAccess.getLogicalNegationOperationAccess().getGroup_1(), "rule__LogicalNegationOperation__Group_1__0");
			builder.put(grammarAccess.getEncapsulatedLogicalOperationAccess().getGroup_1(), "rule__EncapsulatedLogicalOperation__Group_1__0");
			builder.put(grammarAccess.getVariableEqualityOperationAccess().getGroup(), "rule__VariableEqualityOperation__Group__0");
			builder.put(grammarAccess.getVariableInequalityOperationAccess().getGroup(), "rule__VariableInequalityOperation__Group__0");
			builder.put(grammarAccess.getEmptySetOperationAccess().getGroup(), "rule__EmptySetOperation__Group__0");
			builder.put(grammarAccess.getIntersectionOperationAccess().getGroup(), "rule__IntersectionOperation__Group__0");
			builder.put(grammarAccess.getUnionOperationAccess().getGroup(), "rule__UnionOperation__Group__0");
			builder.put(grammarAccess.getSubtractOperationAccess().getGroup(), "rule__SubtractOperation__Group__0");
			builder.put(grammarAccess.getElementOfOperationAccess().getGroup(), "rule__ElementOfOperation__Group__0");
			builder.put(grammarAccess.getCreateSetOperationAccess().getGroup(), "rule__CreateSetOperation__Group__0");
			builder.put(grammarAccess.getModelAccess().getTargetModelTypeAssignment_0(), "rule__Model__TargetModelTypeAssignment_0");
			builder.put(grammarAccess.getModelAccess().getElementsAssignment_1(), "rule__Model__ElementsAssignment_1");
			builder.put(grammarAccess.getTargetModelTypeDefAccess().getTypeAssignment_1(), "rule__TargetModelTypeDef__TypeAssignment_1");
			builder.put(grammarAccess.getTargetModelTypeDefAccess().getTypeContainerAssignment_2_1(), "rule__TargetModelTypeDef__TypeContainerAssignment_2_1");
			builder.put(grammarAccess.getTargetModelTypeDefAccess().getAllocationModelAssignment_2_2_1(), "rule__TargetModelTypeDef__AllocationModelAssignment_2_2_1");
			builder.put(grammarAccess.getTargetModelTypeDefAccess().getUsageModelAssignment_2_2_3(), "rule__TargetModelTypeDef__UsageModelAssignment_2_2_3");
			builder.put(grammarAccess.getCharacteristicTypeAccess().getNameAssignment_1(), "rule__CharacteristicType__NameAssignment_1");
			builder.put(grammarAccess.getCharacteristicTypeAccess().getRefAssignment_3(), "rule__CharacteristicType__RefAssignment_3");
			builder.put(grammarAccess.getCharacteristicClassAccess().getNameAssignment_1(), "rule__CharacteristicClass__NameAssignment_1");
			builder.put(grammarAccess.getCharacteristicClassAccess().getMembersAssignment_3(), "rule__CharacteristicClass__MembersAssignment_3");
			builder.put(grammarAccess.getCharacteristicClassAccess().getMembersAssignment_4_1(), "rule__CharacteristicClass__MembersAssignment_4_1");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getRefAssignment_0(), "rule__CharacteristicTypeSelector__RefAssignment_0");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getNegatedAssignment_2_0_0(), "rule__CharacteristicTypeSelector__NegatedAssignment_2_0_0");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getLiteralsAssignment_2_0_1(), "rule__CharacteristicTypeSelector__LiteralsAssignment_2_0_1");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getLiteralsAssignment_2_1_1(), "rule__CharacteristicTypeSelector__LiteralsAssignment_2_1_1");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getLiteralsAssignment_2_1_2_1(), "rule__CharacteristicTypeSelector__LiteralsAssignment_2_1_2_1");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getIsVariableSelectorAssignment_2_2_0(), "rule__CharacteristicTypeSelector__IsVariableSelectorAssignment_2_2_0");
			builder.put(grammarAccess.getCharacteristicTypeSelectorAccess().getVariableAssignment_2_2_1(), "rule__CharacteristicTypeSelector__VariableAssignment_2_2_1");
			builder.put(grammarAccess.getCharacteristicVariableAccess().getNameAssignment(), "rule__CharacteristicVariable__NameAssignment");
			builder.put(grammarAccess.getCharacteristicSetAccess().getNameAssignment_0(), "rule__CharacteristicSet__NameAssignment_0");
			builder.put(grammarAccess.getIncludeAccess().getImportURIAssignment_1(), "rule__Include__ImportURIAssignment_1");
			builder.put(grammarAccess.getConstraintAccess().getNameAssignment_1(), "rule__Constraint__NameAssignment_1");
			builder.put(grammarAccess.getConstraintAccess().getRuleAssignment_3(), "rule__Constraint__RuleAssignment_3");
			builder.put(grammarAccess.getRuleAccess().getDataSelectorsAssignment_0(), "rule__Rule__DataSelectorsAssignment_0");
			builder.put(grammarAccess.getRuleAccess().getDataSelectorsAssignment_1_1(), "rule__Rule__DataSelectorsAssignment_1_1");
			builder.put(grammarAccess.getRuleAccess().getStatementAssignment_2(), "rule__Rule__StatementAssignment_2");
			builder.put(grammarAccess.getRuleAccess().getDestinationSelectorsAssignment_3(), "rule__Rule__DestinationSelectorsAssignment_3");
			builder.put(grammarAccess.getRuleAccess().getDestinationSelectorsAssignment_4_1(), "rule__Rule__DestinationSelectorsAssignment_4_1");
			builder.put(grammarAccess.getRuleAccess().getConditionAssignment_5(), "rule__Rule__ConditionAssignment_5");
			builder.put(grammarAccess.getAttributeSelectorAccess().getRefAssignment_1(), "rule__AttributeSelector__RefAssignment_1");
			builder.put(grammarAccess.getAttributeClassSelectorAccess().getRefAssignment_1(), "rule__AttributeClassSelector__RefAssignment_1");
			builder.put(grammarAccess.getPropertySelectorAccess().getRefAssignment_1(), "rule__PropertySelector__RefAssignment_1");
			builder.put(grammarAccess.getPropertyClassSelectorAccess().getRefAssignment_1(), "rule__PropertyClassSelector__RefAssignment_1");
			builder.put(grammarAccess.getNodeIdentitiySelectorAccess().getNameAssignment_0_1(), "rule__NodeIdentitiySelector__NameAssignment_0_1");
			builder.put(grammarAccess.getNodeIdentitiySelectorAccess().getAssemblyAssignment_1_1(), "rule__NodeIdentitiySelector__AssemblyAssignment_1_1");
			builder.put(grammarAccess.getNodeIdentitiySelectorAccess().getComponentAssignment_1_3(), "rule__NodeIdentitiySelector__ComponentAssignment_1_3");
			builder.put(grammarAccess.getNodeIdentitiySelectorAccess().getSeffAssignment_1_5(), "rule__NodeIdentitiySelector__SeffAssignment_1_5");
			builder.put(grammarAccess.getStatementAccess().getModalityAssignment_0(), "rule__Statement__ModalityAssignment_0");
			builder.put(grammarAccess.getStatementAccess().getTypeAssignment_1(), "rule__Statement__TypeAssignment_1");
			builder.put(grammarAccess.getStatementTypeAccess().getNameAssignment(), "rule__StatementType__NameAssignment");
			builder.put(grammarAccess.getStatementModalityAccess().getNameAssignment(), "rule__StatementModality__NameAssignment");
			builder.put(grammarAccess.getConditionAccess().getOperationAssignment_1(), "rule__Condition__OperationAssignment_1");
			builder.put(grammarAccess.getCharacteristicReferenceAccess().getValueAssignment(), "rule__CharacteristicReference__ValueAssignment");
			builder.put(grammarAccess.getCharacteristicSetReferenceAccess().getValueAssignment_0(), "rule__CharacteristicSetReference__ValueAssignment_0");
			builder.put(grammarAccess.getCharacteristicSetReferenceAccess().getRefAssignment_1(), "rule__CharacteristicSetReference__RefAssignment_1");
			builder.put(grammarAccess.getLogicalOrOperationAccess().getRightAssignment_1_2(), "rule__LogicalOrOperation__RightAssignment_1_2");
			builder.put(grammarAccess.getLogicalAndOperationAccess().getRightAssignment_1_2(), "rule__LogicalAndOperation__RightAssignment_1_2");
			builder.put(grammarAccess.getLogicalNegationOperationAccess().getValueAssignment_1_2(), "rule__LogicalNegationOperation__ValueAssignment_1_2");
			builder.put(grammarAccess.getVariableEqualityOperationAccess().getLeftAssignment_0(), "rule__VariableEqualityOperation__LeftAssignment_0");
			builder.put(grammarAccess.getVariableEqualityOperationAccess().getRightAssignment_2(), "rule__VariableEqualityOperation__RightAssignment_2");
			builder.put(grammarAccess.getVariableInequalityOperationAccess().getLeftAssignment_0(), "rule__VariableInequalityOperation__LeftAssignment_0");
			builder.put(grammarAccess.getVariableInequalityOperationAccess().getRightAssignment_2(), "rule__VariableInequalityOperation__RightAssignment_2");
			builder.put(grammarAccess.getEmptySetOperationAccess().getValueAssignment_2(), "rule__EmptySetOperation__ValueAssignment_2");
			builder.put(grammarAccess.getIntersectionOperationAccess().getLeftAssignment_2(), "rule__IntersectionOperation__LeftAssignment_2");
			builder.put(grammarAccess.getIntersectionOperationAccess().getRightAssignment_4(), "rule__IntersectionOperation__RightAssignment_4");
			builder.put(grammarAccess.getUnionOperationAccess().getLeftAssignment_2(), "rule__UnionOperation__LeftAssignment_2");
			builder.put(grammarAccess.getUnionOperationAccess().getRightAssignment_4(), "rule__UnionOperation__RightAssignment_4");
			builder.put(grammarAccess.getSubtractOperationAccess().getLeftAssignment_2(), "rule__SubtractOperation__LeftAssignment_2");
			builder.put(grammarAccess.getSubtractOperationAccess().getRightAssignment_4(), "rule__SubtractOperation__RightAssignment_4");
			builder.put(grammarAccess.getElementOfOperationAccess().getLeftAssignment_2(), "rule__ElementOfOperation__LeftAssignment_2");
			builder.put(grammarAccess.getElementOfOperationAccess().getRightAssignment_4(), "rule__ElementOfOperation__RightAssignment_4");
			builder.put(grammarAccess.getCreateSetOperationAccess().getValueAssignment_1(), "rule__CreateSetOperation__ValueAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private DSLGrammarAccess grammarAccess;

	@Override
	protected InternalDSLParser createParser() {
		InternalDSLParser result = new InternalDSLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public DSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(DSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
