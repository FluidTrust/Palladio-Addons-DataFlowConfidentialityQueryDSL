/**
 * generated by Xtext 2.25.0
 */
package org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.PCMDFDConstraintLanguagePackage;
import org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.TargetModelTypeDef;

import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.characteristics.CharacteristicTypeDictionary;

import org.palladiosimulator.pcm.repository.Repository;

import org.palladiosimulator.pcm.usagemodel.UsageModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Model Type Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.impl.TargetModelTypeDefImpl#getPcmTypeContainer <em>Pcm Type Container</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.impl.TargetModelTypeDefImpl#getUsageModel <em>Usage Model</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.confidentiality.dcp.dsl.pcm.pCMDFDConstraintLanguage.impl.TargetModelTypeDefImpl#getRepositoryModel <em>Repository Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetModelTypeDefImpl extends de.sebinside.dcp.dsl.dSL.impl.TargetModelTypeDefImpl implements TargetModelTypeDef
{
  /**
   * The cached value of the '{@link #getPcmTypeContainer() <em>Pcm Type Container</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPcmTypeContainer()
   * @generated
   * @ordered
   */
  protected CharacteristicTypeDictionary pcmTypeContainer;

  /**
   * The cached value of the '{@link #getUsageModel() <em>Usage Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsageModel()
   * @generated
   * @ordered
   */
  protected UsageModel usageModel;

  /**
   * The cached value of the '{@link #getRepositoryModel() <em>Repository Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepositoryModel()
   * @generated
   * @ordered
   */
  protected Repository repositoryModel;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TargetModelTypeDefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PCMDFDConstraintLanguagePackage.Literals.TARGET_MODEL_TYPE_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CharacteristicTypeDictionary getPcmTypeContainer()
  {
    if (pcmTypeContainer != null && ((EObject)pcmTypeContainer).eIsProxy())
    {
      InternalEObject oldPcmTypeContainer = (InternalEObject)pcmTypeContainer;
      pcmTypeContainer = (CharacteristicTypeDictionary)eResolveProxy(oldPcmTypeContainer);
      if (pcmTypeContainer != oldPcmTypeContainer)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__PCM_TYPE_CONTAINER, oldPcmTypeContainer, pcmTypeContainer));
      }
    }
    return pcmTypeContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CharacteristicTypeDictionary basicGetPcmTypeContainer()
  {
    return pcmTypeContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPcmTypeContainer(CharacteristicTypeDictionary newPcmTypeContainer)
  {
    CharacteristicTypeDictionary oldPcmTypeContainer = pcmTypeContainer;
    pcmTypeContainer = newPcmTypeContainer;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__PCM_TYPE_CONTAINER, oldPcmTypeContainer, pcmTypeContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UsageModel getUsageModel()
  {
    if (usageModel != null && ((EObject)usageModel).eIsProxy())
    {
      InternalEObject oldUsageModel = (InternalEObject)usageModel;
      usageModel = (UsageModel)eResolveProxy(oldUsageModel);
      if (usageModel != oldUsageModel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__USAGE_MODEL, oldUsageModel, usageModel));
      }
    }
    return usageModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UsageModel basicGetUsageModel()
  {
    return usageModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUsageModel(UsageModel newUsageModel)
  {
    UsageModel oldUsageModel = usageModel;
    usageModel = newUsageModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__USAGE_MODEL, oldUsageModel, usageModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Repository getRepositoryModel()
  {
    if (repositoryModel != null && ((EObject)repositoryModel).eIsProxy())
    {
      InternalEObject oldRepositoryModel = (InternalEObject)repositoryModel;
      repositoryModel = (Repository)eResolveProxy(oldRepositoryModel);
      if (repositoryModel != oldRepositoryModel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__REPOSITORY_MODEL, oldRepositoryModel, repositoryModel));
      }
    }
    return repositoryModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Repository basicGetRepositoryModel()
  {
    return repositoryModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRepositoryModel(Repository newRepositoryModel)
  {
    Repository oldRepositoryModel = repositoryModel;
    repositoryModel = newRepositoryModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__REPOSITORY_MODEL, oldRepositoryModel, repositoryModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__PCM_TYPE_CONTAINER:
        if (resolve) return getPcmTypeContainer();
        return basicGetPcmTypeContainer();
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__USAGE_MODEL:
        if (resolve) return getUsageModel();
        return basicGetUsageModel();
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__REPOSITORY_MODEL:
        if (resolve) return getRepositoryModel();
        return basicGetRepositoryModel();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__PCM_TYPE_CONTAINER:
        setPcmTypeContainer((CharacteristicTypeDictionary)newValue);
        return;
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__USAGE_MODEL:
        setUsageModel((UsageModel)newValue);
        return;
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__REPOSITORY_MODEL:
        setRepositoryModel((Repository)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__PCM_TYPE_CONTAINER:
        setPcmTypeContainer((CharacteristicTypeDictionary)null);
        return;
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__USAGE_MODEL:
        setUsageModel((UsageModel)null);
        return;
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__REPOSITORY_MODEL:
        setRepositoryModel((Repository)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__PCM_TYPE_CONTAINER:
        return pcmTypeContainer != null;
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__USAGE_MODEL:
        return usageModel != null;
      case PCMDFDConstraintLanguagePackage.TARGET_MODEL_TYPE_DEF__REPOSITORY_MODEL:
        return repositoryModel != null;
    }
    return super.eIsSet(featureID);
  }

} //TargetModelTypeDefImpl
