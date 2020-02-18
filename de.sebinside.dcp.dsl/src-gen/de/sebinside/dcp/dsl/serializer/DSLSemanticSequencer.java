/*
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.serializer;

import com.google.inject.Inject;
import de.sebinside.dcp.dsl.dSL.AttributeClassSelector;
import de.sebinside.dcp.dsl.dSL.AttributeSelector;
import de.sebinside.dcp.dsl.dSL.AttributeType;
import de.sebinside.dcp.dsl.dSL.CharacteristicClass;
import de.sebinside.dcp.dsl.dSL.CharacteristicSelector;
import de.sebinside.dcp.dsl.dSL.Constraint;
import de.sebinside.dcp.dsl.dSL.DSLPackage;
import de.sebinside.dcp.dsl.dSL.DataType;
import de.sebinside.dcp.dsl.dSL.Model;
import de.sebinside.dcp.dsl.dSL.PropertyClassSelector;
import de.sebinside.dcp.dsl.dSL.PropertySelector;
import de.sebinside.dcp.dsl.dSL.PropertyType;
import de.sebinside.dcp.dsl.dSL.Rule;
import de.sebinside.dcp.dsl.dSL.Statement;
import de.sebinside.dcp.dsl.dSL.StatementModality;
import de.sebinside.dcp.dsl.dSL.StatementType;
import de.sebinside.dcp.dsl.dSL.ValueSet;
import de.sebinside.dcp.dsl.services.DSLGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class DSLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private DSLGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == DSLPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case DSLPackage.ATTRIBUTE_CLASS_SELECTOR:
				sequence_AttributeClassSelector(context, (AttributeClassSelector) semanticObject); 
				return; 
			case DSLPackage.ATTRIBUTE_SELECTOR:
				sequence_AttributeSelector(context, (AttributeSelector) semanticObject); 
				return; 
			case DSLPackage.ATTRIBUTE_TYPE:
				sequence_AttributeType(context, (AttributeType) semanticObject); 
				return; 
			case DSLPackage.CHARACTERISTIC_CLASS:
				sequence_CharacteristicClass(context, (CharacteristicClass) semanticObject); 
				return; 
			case DSLPackage.CHARACTERISTIC_SELECTOR:
				sequence_CharacteristicSelector(context, (CharacteristicSelector) semanticObject); 
				return; 
			case DSLPackage.CONSTRAINT:
				sequence_Constraint(context, (Constraint) semanticObject); 
				return; 
			case DSLPackage.DATA_TYPE:
				sequence_DataType(context, (DataType) semanticObject); 
				return; 
			case DSLPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case DSLPackage.PROPERTY_CLASS_SELECTOR:
				sequence_PropertyClassSelector(context, (PropertyClassSelector) semanticObject); 
				return; 
			case DSLPackage.PROPERTY_SELECTOR:
				sequence_PropertySelector(context, (PropertySelector) semanticObject); 
				return; 
			case DSLPackage.PROPERTY_TYPE:
				sequence_PropertyType(context, (PropertyType) semanticObject); 
				return; 
			case DSLPackage.RULE:
				sequence_Rule(context, (Rule) semanticObject); 
				return; 
			case DSLPackage.STATEMENT:
				sequence_Statement(context, (Statement) semanticObject); 
				return; 
			case DSLPackage.STATEMENT_MODALITY:
				sequence_StatementModality(context, (StatementModality) semanticObject); 
				return; 
			case DSLPackage.STATEMENT_TYPE:
				sequence_StatementType(context, (StatementType) semanticObject); 
				return; 
			case DSLPackage.VALUE_SET:
				sequence_ValueSet(context, (ValueSet) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     DataSelector returns AttributeClassSelector
	 *     AttributeClassSelector returns AttributeClassSelector
	 *
	 * Constraint:
	 *     (negated?='!'? ref=[CharacteristicClass|ID])
	 */
	protected void sequence_AttributeClassSelector(ISerializationContext context, AttributeClassSelector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataSelector returns AttributeSelector
	 *     AttributeSelector returns AttributeSelector
	 *
	 * Constraint:
	 *     ref=CharacteristicSelector
	 */
	protected void sequence_AttributeSelector(ISerializationContext context, AttributeSelector semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.ATTRIBUTE_SELECTOR__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.ATTRIBUTE_SELECTOR__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAttributeSelectorAccess().getRefCharacteristicSelectorParserRuleCall_1_0(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AbstractElement returns AttributeType
	 *     CharacteristicsType returns AttributeType
	 *     AttributeType returns AttributeType
	 *
	 * Constraint:
	 *     (name=ID valueset=[ValueSet|ID])
	 */
	protected void sequence_AttributeType(ISerializationContext context, AttributeType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.ABSTRACT_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.ABSTRACT_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.CHARACTERISTICS_TYPE__VALUESET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.CHARACTERISTICS_TYPE__VALUESET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAttributeTypeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAttributeTypeAccess().getValuesetValueSetIDTerminalRuleCall_3_0_1(), semanticObject.eGet(DSLPackage.Literals.CHARACTERISTICS_TYPE__VALUESET, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AbstractElement returns CharacteristicClass
	 *     CharacteristicClass returns CharacteristicClass
	 *
	 * Constraint:
	 *     (name=ID members+=CharacteristicSelector members+=CharacteristicSelector*)
	 */
	protected void sequence_CharacteristicClass(ISerializationContext context, CharacteristicClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     CharacteristicSelector returns CharacteristicSelector
	 *
	 * Constraint:
	 *     (ref=[CharacteristicsType|ID] ((negated?='!'? literals+=ID) | (literals+=ID (literals+=ID+ | (conjuncted?='&' literals+=ID)+)?)))
	 */
	protected void sequence_CharacteristicSelector(ISerializationContext context, CharacteristicSelector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AbstractElement returns Constraint
	 *     Constraint returns Constraint
	 *
	 * Constraint:
	 *     (name=STRING rule=Rule)
	 */
	protected void sequence_Constraint(ISerializationContext context, Constraint semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.ABSTRACT_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.ABSTRACT_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.CONSTRAINT__RULE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.CONSTRAINT__RULE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConstraintAccess().getNameSTRINGTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getConstraintAccess().getRuleRuleParserRuleCall_3_0(), semanticObject.getRule());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AbstractElement returns DataType
	 *     DataType returns DataType
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_DataType(ISerializationContext context, DataType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.ABSTRACT_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.ABSTRACT_ELEMENT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     elements+=AbstractElement+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DestinationSelector returns PropertyClassSelector
	 *     PropertyClassSelector returns PropertyClassSelector
	 *
	 * Constraint:
	 *     (negated?='!'? ref=[CharacteristicClass|ID])
	 */
	protected void sequence_PropertyClassSelector(ISerializationContext context, PropertyClassSelector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DestinationSelector returns PropertySelector
	 *     PropertySelector returns PropertySelector
	 *
	 * Constraint:
	 *     ref=CharacteristicSelector
	 */
	protected void sequence_PropertySelector(ISerializationContext context, PropertySelector semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.PROPERTY_SELECTOR__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.PROPERTY_SELECTOR__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPropertySelectorAccess().getRefCharacteristicSelectorParserRuleCall_1_0(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AbstractElement returns PropertyType
	 *     CharacteristicsType returns PropertyType
	 *     PropertyType returns PropertyType
	 *
	 * Constraint:
	 *     (name=ID valueset=[ValueSet|ID])
	 */
	protected void sequence_PropertyType(ISerializationContext context, PropertyType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.ABSTRACT_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.ABSTRACT_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.CHARACTERISTICS_TYPE__VALUESET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.CHARACTERISTICS_TYPE__VALUESET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPropertyTypeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPropertyTypeAccess().getValuesetValueSetIDTerminalRuleCall_3_0_1(), semanticObject.eGet(DSLPackage.Literals.CHARACTERISTICS_TYPE__VALUESET, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Rule returns Rule
	 *
	 * Constraint:
	 *     (
	 *         dataSelectors+=DataSelector 
	 *         dataSelectors+=DataSelector* 
	 *         statement=Statement 
	 *         destinationSelectors+=DestinationSelector 
	 *         destinationSelectors+=DestinationSelector*
	 *     )
	 */
	protected void sequence_Rule(ISerializationContext context, Rule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     StatementModality returns StatementModality
	 *
	 * Constraint:
	 *     name='NEVER'
	 */
	protected void sequence_StatementModality(ISerializationContext context, StatementModality semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.STATEMENT_MODALITY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.STATEMENT_MODALITY__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStatementModalityAccess().getNameNEVERKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     StatementType returns StatementType
	 *
	 * Constraint:
	 *     name='FLOWS'
	 */
	protected void sequence_StatementType(ISerializationContext context, StatementType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.STATEMENT_TYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.STATEMENT_TYPE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStatementTypeAccess().getNameFLOWSKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns Statement
	 *
	 * Constraint:
	 *     (modality=StatementModality type=StatementType)
	 */
	protected void sequence_Statement(ISerializationContext context, Statement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.STATEMENT__MODALITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.STATEMENT__MODALITY));
			if (transientValues.isValueTransient(semanticObject, DSLPackage.Literals.STATEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DSLPackage.Literals.STATEMENT__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStatementAccess().getModalityStatementModalityParserRuleCall_0_0(), semanticObject.getModality());
		feeder.accept(grammarAccess.getStatementAccess().getTypeStatementTypeParserRuleCall_1_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AbstractElement returns ValueSet
	 *     ValueSet returns ValueSet
	 *
	 * Constraint:
	 *     (name=ID members+=ID members+=ID*)
	 */
	protected void sequence_ValueSet(ISerializationContext context, ValueSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}