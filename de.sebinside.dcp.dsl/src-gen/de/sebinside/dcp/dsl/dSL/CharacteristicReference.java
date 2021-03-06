/**
 * generated by Xtext 2.21.0
 */
package de.sebinside.dcp.dsl.dSL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characteristic Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.CharacteristicReference#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getCharacteristicReference()
 * @model
 * @generated
 */
public interface CharacteristicReference extends Reference
{
  /**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(CharacteristicVariable)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getCharacteristicReference_Value()
	 * @model
	 * @generated
	 */
  CharacteristicVariable getValue();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.CharacteristicReference#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
  void setValue(CharacteristicVariable value);

} // CharacteristicReference
