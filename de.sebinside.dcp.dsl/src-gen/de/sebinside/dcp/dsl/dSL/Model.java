/**
 * generated by Xtext 2.21.0
 */
package de.sebinside.dcp.dsl.dSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.Model#getTargetModelType <em>Target Model Type</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.Model#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
	 * Returns the value of the '<em><b>Target Model Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Model Type</em>' containment reference.
	 * @see #setTargetModelType(TargetModelTypeDef)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getModel_TargetModelType()
	 * @model containment="true"
	 * @generated
	 */
  TargetModelTypeDef getTargetModelType();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.Model#getTargetModelType <em>Target Model Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Model Type</em>' containment reference.
	 * @see #getTargetModelType()
	 * @generated
	 */
  void setTargetModelType(TargetModelTypeDef value);

  /**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link de.sebinside.dcp.dsl.dSL.AbstractElement}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getModel_Elements()
	 * @model containment="true"
	 * @generated
	 */
  EList<AbstractElement> getElements();

} // Model
