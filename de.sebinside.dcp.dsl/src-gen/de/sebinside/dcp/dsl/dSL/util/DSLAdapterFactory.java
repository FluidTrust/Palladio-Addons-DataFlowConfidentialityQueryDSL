/**
 * generated by Xtext 2.21.0
 */
package de.sebinside.dcp.dsl.dSL.util;

import de.sebinside.dcp.dsl.dSL.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.sebinside.dcp.dsl.dSL.DSLPackage
 * @generated
 */
public class DSLAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static DSLPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DSLAdapterFactory()
  {
		if (modelPackage == null) {
			modelPackage = DSLPackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object)
  {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DSLSwitch<Adapter> modelSwitch =
    new DSLSwitch<Adapter>() {
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseTargetModelTypeDef(TargetModelTypeDef object) {
				return createTargetModelTypeDefAdapter();
			}
			@Override
			public Adapter caseAbstractElement(AbstractElement object) {
				return createAbstractElementAdapter();
			}
			@Override
			public Adapter caseCharacteristicType(CharacteristicType object) {
				return createCharacteristicTypeAdapter();
			}
			@Override
			public Adapter caseCharacteristicClass(CharacteristicClass object) {
				return createCharacteristicClassAdapter();
			}
			@Override
			public Adapter caseCharacteristicTypeSelector(CharacteristicTypeSelector object) {
				return createCharacteristicTypeSelectorAdapter();
			}
			@Override
			public Adapter caseCharacteristicVariableType(CharacteristicVariableType object) {
				return createCharacteristicVariableTypeAdapter();
			}
			@Override
			public Adapter caseCharacteristicVariable(CharacteristicVariable object) {
				return createCharacteristicVariableAdapter();
			}
			@Override
			public Adapter caseCharacteristicSet(CharacteristicSet object) {
				return createCharacteristicSetAdapter();
			}
			@Override
			public Adapter caseInclude(Include object) {
				return createIncludeAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseDataSelector(DataSelector object) {
				return createDataSelectorAdapter();
			}
			@Override
			public Adapter caseCharacteristicSelector(CharacteristicSelector object) {
				return createCharacteristicSelectorAdapter();
			}
			@Override
			public Adapter caseCharacteristicClassSelector(CharacteristicClassSelector object) {
				return createCharacteristicClassSelectorAdapter();
			}
			@Override
			public Adapter caseAttributeSelector(AttributeSelector object) {
				return createAttributeSelectorAdapter();
			}
			@Override
			public Adapter caseAttributeClassSelector(AttributeClassSelector object) {
				return createAttributeClassSelectorAdapter();
			}
			@Override
			public Adapter caseDestinationSelector(DestinationSelector object) {
				return createDestinationSelectorAdapter();
			}
			@Override
			public Adapter casePropertySelector(PropertySelector object) {
				return createPropertySelectorAdapter();
			}
			@Override
			public Adapter casePropertyClassSelector(PropertyClassSelector object) {
				return createPropertyClassSelectorAdapter();
			}
			@Override
			public Adapter caseNodeIdentitiySelector(NodeIdentitiySelector object) {
				return createNodeIdentitiySelectorAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter caseStatementType(StatementType object) {
				return createStatementTypeAdapter();
			}
			@Override
			public Adapter caseStatementModality(StatementModality object) {
				return createStatementModalityAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseReference(Reference object) {
				return createReferenceAdapter();
			}
			@Override
			public Adapter caseCharacteristicReference(CharacteristicReference object) {
				return createCharacteristicReferenceAdapter();
			}
			@Override
			public Adapter caseCharacteristicSetReference(CharacteristicSetReference object) {
				return createCharacteristicSetReferenceAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseBooleanOperation(BooleanOperation object) {
				return createBooleanOperationAdapter();
			}
			@Override
			public Adapter caseCharacteristsicSetOperation(CharacteristsicSetOperation object) {
				return createCharacteristsicSetOperationAdapter();
			}
			@Override
			public Adapter caseSimpleBooleanOperation(SimpleBooleanOperation object) {
				return createSimpleBooleanOperationAdapter();
			}
			@Override
			public Adapter caseVariableEqualityOperation(VariableEqualityOperation object) {
				return createVariableEqualityOperationAdapter();
			}
			@Override
			public Adapter caseVariableInequalityOperation(VariableInequalityOperation object) {
				return createVariableInequalityOperationAdapter();
			}
			@Override
			public Adapter caseEmptySetOperation(EmptySetOperation object) {
				return createEmptySetOperationAdapter();
			}
			@Override
			public Adapter caseIntersectionOperation(IntersectionOperation object) {
				return createIntersectionOperationAdapter();
			}
			@Override
			public Adapter caseUnionOperation(UnionOperation object) {
				return createUnionOperationAdapter();
			}
			@Override
			public Adapter caseSubtractOperation(SubtractOperation object) {
				return createSubtractOperationAdapter();
			}
			@Override
			public Adapter caseElementOfOperation(ElementOfOperation object) {
				return createElementOfOperationAdapter();
			}
			@Override
			public Adapter caseCreateSetOperation(CreateSetOperation object) {
				return createCreateSetOperationAdapter();
			}
			@Override
			public Adapter caseLogicalOrOperation(LogicalOrOperation object) {
				return createLogicalOrOperationAdapter();
			}
			@Override
			public Adapter caseLogicalAndOperation(LogicalAndOperation object) {
				return createLogicalAndOperationAdapter();
			}
			@Override
			public Adapter caseLogicalNegationOperation(LogicalNegationOperation object) {
				return createLogicalNegationOperationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target)
  {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.Model
	 * @generated
	 */
  public Adapter createModelAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.TargetModelTypeDef <em>Target Model Type Def</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.TargetModelTypeDef
	 * @generated
	 */
  public Adapter createTargetModelTypeDefAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.AbstractElement <em>Abstract Element</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.AbstractElement
	 * @generated
	 */
  public Adapter createAbstractElementAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicType <em>Characteristic Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicType
	 * @generated
	 */
  public Adapter createCharacteristicTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicClass <em>Characteristic Class</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicClass
	 * @generated
	 */
  public Adapter createCharacteristicClassAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicTypeSelector <em>Characteristic Type Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicTypeSelector
	 * @generated
	 */
  public Adapter createCharacteristicTypeSelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicVariableType <em>Characteristic Variable Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicVariableType
	 * @generated
	 */
  public Adapter createCharacteristicVariableTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicVariable <em>Characteristic Variable</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicVariable
	 * @generated
	 */
  public Adapter createCharacteristicVariableAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicSet <em>Characteristic Set</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicSet
	 * @generated
	 */
  public Adapter createCharacteristicSetAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.Include <em>Include</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.Include
	 * @generated
	 */
  public Adapter createIncludeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.Constraint
	 * @generated
	 */
  public Adapter createConstraintAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.Rule
	 * @generated
	 */
  public Adapter createRuleAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.DataSelector <em>Data Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.DataSelector
	 * @generated
	 */
  public Adapter createDataSelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicSelector <em>Characteristic Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicSelector
	 * @generated
	 */
  public Adapter createCharacteristicSelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicClassSelector <em>Characteristic Class Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicClassSelector
	 * @generated
	 */
  public Adapter createCharacteristicClassSelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.AttributeSelector <em>Attribute Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.AttributeSelector
	 * @generated
	 */
  public Adapter createAttributeSelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.AttributeClassSelector <em>Attribute Class Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.AttributeClassSelector
	 * @generated
	 */
  public Adapter createAttributeClassSelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.DestinationSelector <em>Destination Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.DestinationSelector
	 * @generated
	 */
  public Adapter createDestinationSelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.PropertySelector <em>Property Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.PropertySelector
	 * @generated
	 */
  public Adapter createPropertySelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.PropertyClassSelector <em>Property Class Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.PropertyClassSelector
	 * @generated
	 */
  public Adapter createPropertyClassSelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector <em>Node Identitiy Selector</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector
	 * @generated
	 */
  public Adapter createNodeIdentitiySelectorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.Statement
	 * @generated
	 */
  public Adapter createStatementAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.StatementType <em>Statement Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.StatementType
	 * @generated
	 */
  public Adapter createStatementTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.StatementModality <em>Statement Modality</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.StatementModality
	 * @generated
	 */
  public Adapter createStatementModalityAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.Condition
	 * @generated
	 */
  public Adapter createConditionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.Reference
	 * @generated
	 */
  public Adapter createReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicReference <em>Characteristic Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicReference
	 * @generated
	 */
  public Adapter createCharacteristicReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristicSetReference <em>Characteristic Set Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristicSetReference
	 * @generated
	 */
  public Adapter createCharacteristicSetReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.Operation
	 * @generated
	 */
  public Adapter createOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.BooleanOperation <em>Boolean Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.BooleanOperation
	 * @generated
	 */
  public Adapter createBooleanOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CharacteristsicSetOperation <em>Characteristsic Set Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CharacteristsicSetOperation
	 * @generated
	 */
  public Adapter createCharacteristsicSetOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.SimpleBooleanOperation <em>Simple Boolean Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.SimpleBooleanOperation
	 * @generated
	 */
  public Adapter createSimpleBooleanOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.VariableEqualityOperation <em>Variable Equality Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.VariableEqualityOperation
	 * @generated
	 */
  public Adapter createVariableEqualityOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.VariableInequalityOperation <em>Variable Inequality Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.VariableInequalityOperation
	 * @generated
	 */
  public Adapter createVariableInequalityOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.EmptySetOperation <em>Empty Set Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.EmptySetOperation
	 * @generated
	 */
  public Adapter createEmptySetOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.IntersectionOperation <em>Intersection Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.IntersectionOperation
	 * @generated
	 */
  public Adapter createIntersectionOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.UnionOperation <em>Union Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.UnionOperation
	 * @generated
	 */
  public Adapter createUnionOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.SubtractOperation <em>Subtract Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.SubtractOperation
	 * @generated
	 */
  public Adapter createSubtractOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.ElementOfOperation <em>Element Of Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.ElementOfOperation
	 * @generated
	 */
  public Adapter createElementOfOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.CreateSetOperation <em>Create Set Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.CreateSetOperation
	 * @generated
	 */
  public Adapter createCreateSetOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.LogicalOrOperation <em>Logical Or Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.LogicalOrOperation
	 * @generated
	 */
  public Adapter createLogicalOrOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.LogicalAndOperation <em>Logical And Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.LogicalAndOperation
	 * @generated
	 */
  public Adapter createLogicalAndOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link de.sebinside.dcp.dsl.dSL.LogicalNegationOperation <em>Logical Negation Operation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.sebinside.dcp.dsl.dSL.LogicalNegationOperation
	 * @generated
	 */
  public Adapter createLogicalNegationOperationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter()
  {
		return null;
	}

} //DSLAdapterFactory
