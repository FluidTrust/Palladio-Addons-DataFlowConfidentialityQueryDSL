/**
 * generated by Xtext 2.25.0
 */
package org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.impl;

import de.sebinside.dcp.dsl.dSL.DSLPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.Model;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.NodeIdentitiySelector;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.PCMDFDConstraintLanguageFactory;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.PCMDFDConstraintLanguagePackage;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.PropertyClassSelector;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.PropertySelector;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.TargetModelTypeDef;

import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.characteristics.CharacteristicsPackage;

import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.repository.RepositoryPackage;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramPackage;

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage;

import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataDictionaryPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage;

import org.palladiosimulator.pcm.core.CorePackage;

import org.palladiosimulator.pcm.core.composition.CompositionPackage;

import org.palladiosimulator.pcm.core.entity.EntityPackage;

import org.palladiosimulator.pcm.parameter.ParameterPackage;

import org.palladiosimulator.pcm.protocol.ProtocolPackage;

import org.palladiosimulator.pcm.qosannotations.QosannotationsPackage;

import org.palladiosimulator.pcm.qosannotations.qos_performance.QosPerformancePackage;

import org.palladiosimulator.pcm.qosannotations.qos_reliability.QosReliabilityPackage;

import org.palladiosimulator.pcm.reliability.ReliabilityPackage;

import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;

import org.palladiosimulator.pcm.seff.SeffPackage;

import org.palladiosimulator.pcm.system.SystemPackage;

import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PCMDFDConstraintLanguagePackageImpl extends EPackageImpl implements PCMDFDConstraintLanguagePackage
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
  private EClass targetModelTypeDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertySelectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyClassSelectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeIdentitiySelectorEClass = null;

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
   * @see org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.PCMDFDConstraintLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PCMDFDConstraintLanguagePackageImpl()
  {
    super(eNS_URI, PCMDFDConstraintLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link PCMDFDConstraintLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PCMDFDConstraintLanguagePackage init()
  {
    if (isInited) return (PCMDFDConstraintLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(PCMDFDConstraintLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Object registeredPCMDFDConstraintLanguagePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    PCMDFDConstraintLanguagePackageImpl thePCMDFDConstraintLanguagePackage = registeredPCMDFDConstraintLanguagePackage instanceof PCMDFDConstraintLanguagePackageImpl ? (PCMDFDConstraintLanguagePackageImpl)registeredPCMDFDConstraintLanguagePackage : new PCMDFDConstraintLanguagePackageImpl();

    isInited = true;

    // Initialize simple dependencies
    DSLPackage.eINSTANCE.eClass();
    CharacteristicsPackage.eINSTANCE.eClass();
    RepositoryPackage.eINSTANCE.eClass();
    CompositionPackage.eINSTANCE.eClass();
    org.palladiosimulator.pcm.repository.RepositoryPackage.eINSTANCE.eClass();
    SeffPackage.eINSTANCE.eClass();
    UsagemodelPackage.eINSTANCE.eClass();
    EcorePackage.eINSTANCE.eClass();
    DataDictionaryCharacterizedPackage.eINSTANCE.eClass();
    DataFlowDiagramCharacterizedPackage.eINSTANCE.eClass();
    IdentifierPackage.eINSTANCE.eClass();
    EntityPackage.eINSTANCE.eClass();
    CorePackage.eINSTANCE.eClass();
    ParameterPackage.eINSTANCE.eClass();
    ReliabilityPackage.eINSTANCE.eClass();
    ResourcetypePackage.eINSTANCE.eClass();
    ProtocolPackage.eINSTANCE.eClass();
    DataDictionaryPackage.eINSTANCE.eClass();
    ExpressionsPackage.eINSTANCE.eClass();
    DataFlowDiagramPackage.eINSTANCE.eClass();
    StoexPackage.eINSTANCE.eClass();
    QosPerformancePackage.eINSTANCE.eClass();
    ResourceenvironmentPackage.eINSTANCE.eClass();
    QosannotationsPackage.eINSTANCE.eClass();
    QosReliabilityPackage.eINSTANCE.eClass();
    UnitsPackage.eINSTANCE.eClass();
    ProbfunctionPackage.eINSTANCE.eClass();
    SystemPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    thePCMDFDConstraintLanguagePackage.createPackageContents();

    // Initialize created meta-data
    thePCMDFDConstraintLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePCMDFDConstraintLanguagePackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PCMDFDConstraintLanguagePackage.eNS_URI, thePCMDFDConstraintLanguagePackage);
    return thePCMDFDConstraintLanguagePackage;
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
  public EClass getTargetModelTypeDef()
  {
    return targetModelTypeDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTargetModelTypeDef_PcmTypeContainer()
  {
    return (EReference)targetModelTypeDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTargetModelTypeDef_UsageModel()
  {
    return (EReference)targetModelTypeDefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTargetModelTypeDef_RepositoryModel()
  {
    return (EReference)targetModelTypeDefEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertySelector()
  {
    return propertySelectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyClassSelector()
  {
    return propertyClassSelectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNodeIdentitiySelector()
  {
    return nodeIdentitiySelectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNodeIdentitiySelector_Assembly()
  {
    return (EReference)nodeIdentitiySelectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNodeIdentitiySelector_Component()
  {
    return (EReference)nodeIdentitiySelectorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNodeIdentitiySelector_Action()
  {
    return (EReference)nodeIdentitiySelectorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNodeIdentitiySelector_Signature()
  {
    return (EReference)nodeIdentitiySelectorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNodeIdentitiySelector_UserAction()
  {
    return (EReference)nodeIdentitiySelectorEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNodeIdentitiySelector_Store()
  {
    return (EReference)nodeIdentitiySelectorEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PCMDFDConstraintLanguageFactory getPCMDFDConstraintLanguageFactory()
  {
    return (PCMDFDConstraintLanguageFactory)getEFactoryInstance();
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

    targetModelTypeDefEClass = createEClass(TARGET_MODEL_TYPE_DEF);
    createEReference(targetModelTypeDefEClass, TARGET_MODEL_TYPE_DEF__PCM_TYPE_CONTAINER);
    createEReference(targetModelTypeDefEClass, TARGET_MODEL_TYPE_DEF__USAGE_MODEL);
    createEReference(targetModelTypeDefEClass, TARGET_MODEL_TYPE_DEF__REPOSITORY_MODEL);

    propertySelectorEClass = createEClass(PROPERTY_SELECTOR);

    propertyClassSelectorEClass = createEClass(PROPERTY_CLASS_SELECTOR);

    nodeIdentitiySelectorEClass = createEClass(NODE_IDENTITIY_SELECTOR);
    createEReference(nodeIdentitiySelectorEClass, NODE_IDENTITIY_SELECTOR__ASSEMBLY);
    createEReference(nodeIdentitiySelectorEClass, NODE_IDENTITIY_SELECTOR__COMPONENT);
    createEReference(nodeIdentitiySelectorEClass, NODE_IDENTITIY_SELECTOR__ACTION);
    createEReference(nodeIdentitiySelectorEClass, NODE_IDENTITIY_SELECTOR__SIGNATURE);
    createEReference(nodeIdentitiySelectorEClass, NODE_IDENTITIY_SELECTOR__USER_ACTION);
    createEReference(nodeIdentitiySelectorEClass, NODE_IDENTITIY_SELECTOR__STORE);
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

    // Obtain other dependent packages
    DSLPackage theDSLPackage = (DSLPackage)EPackage.Registry.INSTANCE.getEPackage(DSLPackage.eNS_URI);
    CharacteristicsPackage theCharacteristicsPackage = (CharacteristicsPackage)EPackage.Registry.INSTANCE.getEPackage(CharacteristicsPackage.eNS_URI);
    UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage)EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI);
    org.palladiosimulator.pcm.repository.RepositoryPackage theRepositoryPackage_1 = (org.palladiosimulator.pcm.repository.RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(org.palladiosimulator.pcm.repository.RepositoryPackage.eNS_URI);
    CompositionPackage theCompositionPackage = (CompositionPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
    SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
    RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    modelEClass.getESuperTypes().add(theDSLPackage.getModel());
    targetModelTypeDefEClass.getESuperTypes().add(theDSLPackage.getTargetModelTypeDef());
    propertySelectorEClass.getESuperTypes().add(theDSLPackage.getPropertySelector());
    propertyClassSelectorEClass.getESuperTypes().add(theDSLPackage.getPropertyClassSelector());
    nodeIdentitiySelectorEClass.getESuperTypes().add(theDSLPackage.getNodeIdentitiySelector());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(targetModelTypeDefEClass, TargetModelTypeDef.class, "TargetModelTypeDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTargetModelTypeDef_PcmTypeContainer(), theCharacteristicsPackage.getCharacteristicTypeDictionary(), null, "pcmTypeContainer", null, 0, 1, TargetModelTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTargetModelTypeDef_UsageModel(), theUsagemodelPackage.getUsageModel(), null, "usageModel", null, 0, 1, TargetModelTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTargetModelTypeDef_RepositoryModel(), theRepositoryPackage_1.getRepository(), null, "repositoryModel", null, 0, 1, TargetModelTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertySelectorEClass, PropertySelector.class, "PropertySelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(propertyClassSelectorEClass, PropertyClassSelector.class, "PropertyClassSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nodeIdentitiySelectorEClass, NodeIdentitiySelector.class, "NodeIdentitiySelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNodeIdentitiySelector_Assembly(), theCompositionPackage.getAssemblyContext(), null, "assembly", null, 0, 1, NodeIdentitiySelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeIdentitiySelector_Component(), theRepositoryPackage_1.getBasicComponent(), null, "component", null, 0, 1, NodeIdentitiySelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeIdentitiySelector_Action(), theSeffPackage.getAbstractAction(), null, "action", null, 0, 1, NodeIdentitiySelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeIdentitiySelector_Signature(), theRepositoryPackage_1.getOperationSignature(), null, "signature", null, 0, 1, NodeIdentitiySelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeIdentitiySelector_UserAction(), theUsagemodelPackage.getEntryLevelSystemCall(), null, "userAction", null, 0, 1, NodeIdentitiySelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeIdentitiySelector_Store(), theRepositoryPackage.getOperationalDataStoreComponent(), null, "store", null, 0, 1, NodeIdentitiySelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //PCMDFDConstraintLanguagePackageImpl