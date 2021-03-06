/**
 * generated by Xtext 2.21.0
 */
package de.sebinside.dcp.dsl.dSL;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.allocation.Allocation;

import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer;

import org.palladiosimulator.pcm.usagemodel.UsageModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Model Type Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.TargetModelTypeDef#getType <em>Type</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.TargetModelTypeDef#getTypeContainer <em>Type Container</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.TargetModelTypeDef#getAllocationModel <em>Allocation Model</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.TargetModelTypeDef#getUsageModel <em>Usage Model</em>}</li>
 * </ul>
 *
 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getTargetModelTypeDef()
 * @model
 * @generated
 */
public interface TargetModelTypeDef extends EObject
{
  /**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.sebinside.dcp.dsl.dSL.TargetModelType}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.sebinside.dcp.dsl.dSL.TargetModelType
	 * @see #setType(TargetModelType)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getTargetModelTypeDef_Type()
	 * @model
	 * @generated
	 */
  TargetModelType getType();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.TargetModelTypeDef#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.sebinside.dcp.dsl.dSL.TargetModelType
	 * @see #getType()
	 * @generated
	 */
  void setType(TargetModelType value);

  /**
	 * Returns the value of the '<em><b>Type Container</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Container</em>' reference.
	 * @see #setTypeContainer(CharacteristicTypeContainer)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getTargetModelTypeDef_TypeContainer()
	 * @model
	 * @generated
	 */
  CharacteristicTypeContainer getTypeContainer();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.TargetModelTypeDef#getTypeContainer <em>Type Container</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Container</em>' reference.
	 * @see #getTypeContainer()
	 * @generated
	 */
  void setTypeContainer(CharacteristicTypeContainer value);

  /**
	 * Returns the value of the '<em><b>Allocation Model</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Model</em>' reference.
	 * @see #setAllocationModel(Allocation)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getTargetModelTypeDef_AllocationModel()
	 * @model
	 * @generated
	 */
  Allocation getAllocationModel();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.TargetModelTypeDef#getAllocationModel <em>Allocation Model</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation Model</em>' reference.
	 * @see #getAllocationModel()
	 * @generated
	 */
  void setAllocationModel(Allocation value);

  /**
	 * Returns the value of the '<em><b>Usage Model</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Model</em>' reference.
	 * @see #setUsageModel(UsageModel)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getTargetModelTypeDef_UsageModel()
	 * @model
	 * @generated
	 */
  UsageModel getUsageModel();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.TargetModelTypeDef#getUsageModel <em>Usage Model</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Model</em>' reference.
	 * @see #getUsageModel()
	 * @generated
	 */
  void setUsageModel(UsageModel value);

} // TargetModelTypeDef
