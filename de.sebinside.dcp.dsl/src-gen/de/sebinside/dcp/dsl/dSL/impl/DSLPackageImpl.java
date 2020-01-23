/**
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.dSL.impl;

import de.sebinside.dcp.dsl.dSL.AbstractElement;
import de.sebinside.dcp.dsl.dSL.AttributeType;
import de.sebinside.dcp.dsl.dSL.CharacteristicClass;
import de.sebinside.dcp.dsl.dSL.CharacteristicSelector;
import de.sebinside.dcp.dsl.dSL.CharacteristicsType;
import de.sebinside.dcp.dsl.dSL.DSLFactory;
import de.sebinside.dcp.dsl.dSL.DSLPackage;
import de.sebinside.dcp.dsl.dSL.DataType;
import de.sebinside.dcp.dsl.dSL.Model;
import de.sebinside.dcp.dsl.dSL.PropertyType;
import de.sebinside.dcp.dsl.dSL.ValueSet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DSLPackageImpl extends EPackageImpl implements DSLPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass characteristicsTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass characteristicClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass characteristicSelectorEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see de.sebinside.dcp.dsl.dSL.DSLPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DSLPackageImpl()
  {
    super(eNS_URI, DSLFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link DSLPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DSLPackage init()
  {
    if (isInited) return (DSLPackage)EPackage.Registry.INSTANCE.getEPackage(DSLPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredDSLPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    DSLPackageImpl theDSLPackage = registeredDSLPackage instanceof DSLPackageImpl ? (DSLPackageImpl)registeredDSLPackage : new DSLPackageImpl();

    isInited = true;

    // Create package meta-data objects
    theDSLPackage.createPackageContents();

    // Initialize created meta-data
    theDSLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDSLPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DSLPackage.eNS_URI, theDSLPackage);
    return theDSLPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModel_Elements()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAbstractElement()
  {
    return abstractElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAbstractElement_Name()
  {
    return (EAttribute)abstractElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDataType()
  {
    return dataTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValueSet()
  {
    return valueSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getValueSet_Members()
  {
    return (EAttribute)valueSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCharacteristicsType()
  {
    return characteristicsTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCharacteristicsType_Valueset()
  {
    return (EReference)characteristicsTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttributeType()
  {
    return attributeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyType()
  {
    return propertyTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCharacteristicClass()
  {
    return characteristicClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCharacteristicClass_Name()
  {
    return (EAttribute)characteristicClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCharacteristicClass_Members()
  {
    return (EReference)characteristicClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCharacteristicSelector()
  {
    return characteristicSelectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCharacteristicSelector_Name()
  {
    return (EReference)characteristicSelectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCharacteristicSelector_Literal()
  {
    return (EAttribute)characteristicSelectorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLFactory getDSLFactory()
  {
    return (DSLFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__ELEMENTS);

    abstractElementEClass = createEClass(ABSTRACT_ELEMENT);
    createEAttribute(abstractElementEClass, ABSTRACT_ELEMENT__NAME);

    dataTypeEClass = createEClass(DATA_TYPE);

    valueSetEClass = createEClass(VALUE_SET);
    createEAttribute(valueSetEClass, VALUE_SET__MEMBERS);

    characteristicsTypeEClass = createEClass(CHARACTERISTICS_TYPE);
    createEReference(characteristicsTypeEClass, CHARACTERISTICS_TYPE__VALUESET);

    attributeTypeEClass = createEClass(ATTRIBUTE_TYPE);

    propertyTypeEClass = createEClass(PROPERTY_TYPE);

    characteristicClassEClass = createEClass(CHARACTERISTIC_CLASS);
    createEAttribute(characteristicClassEClass, CHARACTERISTIC_CLASS__NAME);
    createEReference(characteristicClassEClass, CHARACTERISTIC_CLASS__MEMBERS);

    characteristicSelectorEClass = createEClass(CHARACTERISTIC_SELECTOR);
    createEReference(characteristicSelectorEClass, CHARACTERISTIC_SELECTOR__NAME);
    createEAttribute(characteristicSelectorEClass, CHARACTERISTIC_SELECTOR__LITERAL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    dataTypeEClass.getESuperTypes().add(this.getAbstractElement());
    valueSetEClass.getESuperTypes().add(this.getAbstractElement());
    characteristicsTypeEClass.getESuperTypes().add(this.getAbstractElement());
    attributeTypeEClass.getESuperTypes().add(this.getCharacteristicsType());
    propertyTypeEClass.getESuperTypes().add(this.getCharacteristicsType());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Elements(), this.getAbstractElement(), null, "elements", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractElementEClass, AbstractElement.class, "AbstractElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valueSetEClass, ValueSet.class, "ValueSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueSet_Members(), ecorePackage.getEString(), "members", null, 0, -1, ValueSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(characteristicsTypeEClass, CharacteristicsType.class, "CharacteristicsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCharacteristicsType_Valueset(), this.getValueSet(), null, "valueset", null, 0, 1, CharacteristicsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeTypeEClass, AttributeType.class, "AttributeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(propertyTypeEClass, PropertyType.class, "PropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(characteristicClassEClass, CharacteristicClass.class, "CharacteristicClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCharacteristicClass_Name(), ecorePackage.getEString(), "name", null, 0, 1, CharacteristicClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCharacteristicClass_Members(), this.getCharacteristicSelector(), null, "members", null, 0, -1, CharacteristicClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(characteristicSelectorEClass, CharacteristicSelector.class, "CharacteristicSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCharacteristicSelector_Name(), this.getCharacteristicsType(), null, "name", null, 0, 1, CharacteristicSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCharacteristicSelector_Literal(), ecorePackage.getEString(), "literal", null, 0, 1, CharacteristicSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //DSLPackageImpl
