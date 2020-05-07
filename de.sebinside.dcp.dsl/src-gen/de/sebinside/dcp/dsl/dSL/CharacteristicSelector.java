/**
 * generated by Xtext 2.21.0
 */
package de.sebinside.dcp.dsl.dSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characteristic Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.CharacteristicSelector#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getCharacteristicSelector()
 * @model
 * @generated
 */
public interface CharacteristicSelector extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(CharacteristicTypeSelector)
   * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getCharacteristicSelector_Ref()
   * @model containment="true"
   * @generated
   */
  CharacteristicTypeSelector getRef();

  /**
   * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.CharacteristicSelector#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(CharacteristicTypeSelector value);

} // CharacteristicSelector