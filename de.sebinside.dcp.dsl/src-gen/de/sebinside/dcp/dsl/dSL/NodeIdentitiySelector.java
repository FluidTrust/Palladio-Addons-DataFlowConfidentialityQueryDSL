/**
 * generated by Xtext 2.21.0
 */
package de.sebinside.dcp.dsl.dSL;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

import org.palladiosimulator.pcm.repository.BasicComponent;

import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Identitiy Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector#getName <em>Name</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector#getAssembly <em>Assembly</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector#getComponent <em>Component</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector#getSeff <em>Seff</em>}</li>
 * </ul>
 *
 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getNodeIdentitiySelector()
 * @model
 * @generated
 */
public interface NodeIdentitiySelector extends DestinationSelector
{
  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getNodeIdentitiySelector_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Assembly</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly</em>' reference.
	 * @see #setAssembly(AssemblyContext)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getNodeIdentitiySelector_Assembly()
	 * @model
	 * @generated
	 */
  AssemblyContext getAssembly();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector#getAssembly <em>Assembly</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly</em>' reference.
	 * @see #getAssembly()
	 * @generated
	 */
  void setAssembly(AssemblyContext value);

  /**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(BasicComponent)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getNodeIdentitiySelector_Component()
	 * @model
	 * @generated
	 */
  BasicComponent getComponent();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
  void setComponent(BasicComponent value);

  /**
	 * Returns the value of the '<em><b>Seff</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Seff</em>' reference.
	 * @see #setSeff(ServiceEffectSpecification)
	 * @see de.sebinside.dcp.dsl.dSL.DSLPackage#getNodeIdentitiySelector_Seff()
	 * @model
	 * @generated
	 */
  ServiceEffectSpecification getSeff();

  /**
	 * Sets the value of the '{@link de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector#getSeff <em>Seff</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seff</em>' reference.
	 * @see #getSeff()
	 * @generated
	 */
  void setSeff(ServiceEffectSpecification value);

} // NodeIdentitiySelector
