/**
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.dSL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.sebinside.dcp.dsl.dSL.DSLPackage
 * @generated
 */
public interface DSLFactory extends EFactory
{
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  DSLFactory eINSTANCE = de.sebinside.dcp.dsl.dSL.impl.DSLFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
  Model createModel();

  /**
	 * Returns a new object of class '<em>Abstract Element</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Element</em>'.
	 * @generated
	 */
  AbstractElement createAbstractElement();

  /**
	 * Returns a new object of class '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type</em>'.
	 * @generated
	 */
  DataType createDataType();

  /**
	 * Returns a new object of class '<em>Value Set</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Set</em>'.
	 * @generated
	 */
  ValueSet createValueSet();

  /**
	 * Returns a new object of class '<em>Characteristics Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characteristics Type</em>'.
	 * @generated
	 */
  CharacteristicsType createCharacteristicsType();

  /**
	 * Returns a new object of class '<em>Attribute Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Type</em>'.
	 * @generated
	 */
  AttributeType createAttributeType();

  /**
	 * Returns a new object of class '<em>Property Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Type</em>'.
	 * @generated
	 */
  PropertyType createPropertyType();

  /**
	 * Returns a new object of class '<em>Characteristic Class</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characteristic Class</em>'.
	 * @generated
	 */
  CharacteristicClass createCharacteristicClass();

  /**
	 * Returns a new object of class '<em>Characteristic Selector</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characteristic Selector</em>'.
	 * @generated
	 */
  CharacteristicSelector createCharacteristicSelector();

  /**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
  Constraint createConstraint();

  /**
	 * Returns a new object of class '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule</em>'.
	 * @generated
	 */
  Rule createRule();

  /**
	 * Returns a new object of class '<em>Data Selector</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Selector</em>'.
	 * @generated
	 */
  DataSelector createDataSelector();

  /**
	 * Returns a new object of class '<em>Attribute Selector</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Selector</em>'.
	 * @generated
	 */
  AttributeSelector createAttributeSelector();

  /**
	 * Returns a new object of class '<em>Attribute Class Selector</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Class Selector</em>'.
	 * @generated
	 */
  AttributeClassSelector createAttributeClassSelector();

  /**
	 * Returns a new object of class '<em>Destination Selector</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Destination Selector</em>'.
	 * @generated
	 */
  DestinationSelector createDestinationSelector();

  /**
	 * Returns a new object of class '<em>Property Selector</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Selector</em>'.
	 * @generated
	 */
  PropertySelector createPropertySelector();

  /**
	 * Returns a new object of class '<em>Property Class Selector</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Class Selector</em>'.
	 * @generated
	 */
  PropertyClassSelector createPropertyClassSelector();

  /**
	 * Returns a new object of class '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement</em>'.
	 * @generated
	 */
  Statement createStatement();

  /**
	 * Returns a new object of class '<em>Statement Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement Type</em>'.
	 * @generated
	 */
  StatementType createStatementType();

  /**
	 * Returns a new object of class '<em>Statement Modality</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement Modality</em>'.
	 * @generated
	 */
  StatementModality createStatementModality();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  DSLPackage getDSLPackage();

} //DSLFactory