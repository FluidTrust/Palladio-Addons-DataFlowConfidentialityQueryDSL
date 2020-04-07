/**
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.dSL.impl;

import de.sebinside.dcp.dsl.dSL.DSLPackage;
import de.sebinside.dcp.dsl.dSL.NodeIdentitiySelector;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

import org.palladiosimulator.pcm.repository.BasicComponent;

import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Identitiy Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.impl.NodeIdentitiySelectorImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.impl.NodeIdentitiySelectorImpl#getAssembly <em>Assembly</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.impl.NodeIdentitiySelectorImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.impl.NodeIdentitiySelectorImpl#getSeff <em>Seff</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeIdentitiySelectorImpl extends DestinationSelectorImpl implements NodeIdentitiySelector
{
  /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected static final String NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected String name = NAME_EDEFAULT;

  /**
	 * The cached value of the '{@link #getAssembly() <em>Assembly</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAssembly()
	 * @generated
	 * @ordered
	 */
  protected AssemblyContext assembly;

  /**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
  protected BasicComponent component;

  /**
	 * The cached value of the '{@link #getSeff() <em>Seff</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSeff()
	 * @generated
	 * @ordered
	 */
  protected ServiceEffectSpecification seff;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected NodeIdentitiySelectorImpl()
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
		return DSLPackage.Literals.NODE_IDENTITIY_SELECTOR;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String getName()
  {
		return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setName(String newName)
  {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DSLPackage.NODE_IDENTITIY_SELECTOR__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public AssemblyContext getAssembly()
  {
		if (assembly != null && ((EObject)assembly).eIsProxy()) {
			InternalEObject oldAssembly = (InternalEObject)assembly;
			assembly = (AssemblyContext)eResolveProxy(oldAssembly);
			if (assembly != oldAssembly) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DSLPackage.NODE_IDENTITIY_SELECTOR__ASSEMBLY, oldAssembly, assembly));
			}
		}
		return assembly;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AssemblyContext basicGetAssembly()
  {
		return assembly;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setAssembly(AssemblyContext newAssembly)
  {
		AssemblyContext oldAssembly = assembly;
		assembly = newAssembly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DSLPackage.NODE_IDENTITIY_SELECTOR__ASSEMBLY, oldAssembly, assembly));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public BasicComponent getComponent()
  {
		if (component != null && ((EObject)component).eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (BasicComponent)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DSLPackage.NODE_IDENTITIY_SELECTOR__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BasicComponent basicGetComponent()
  {
		return component;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setComponent(BasicComponent newComponent)
  {
		BasicComponent oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DSLPackage.NODE_IDENTITIY_SELECTOR__COMPONENT, oldComponent, component));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public ServiceEffectSpecification getSeff()
  {
		if (seff != null && ((EObject)seff).eIsProxy()) {
			InternalEObject oldSeff = (InternalEObject)seff;
			seff = (ServiceEffectSpecification)eResolveProxy(oldSeff);
			if (seff != oldSeff) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DSLPackage.NODE_IDENTITIY_SELECTOR__SEFF, oldSeff, seff));
			}
		}
		return seff;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ServiceEffectSpecification basicGetSeff()
  {
		return seff;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setSeff(ServiceEffectSpecification newSeff)
  {
		ServiceEffectSpecification oldSeff = seff;
		seff = newSeff;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DSLPackage.NODE_IDENTITIY_SELECTOR__SEFF, oldSeff, seff));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case DSLPackage.NODE_IDENTITIY_SELECTOR__NAME:
				return getName();
			case DSLPackage.NODE_IDENTITIY_SELECTOR__ASSEMBLY:
				if (resolve) return getAssembly();
				return basicGetAssembly();
			case DSLPackage.NODE_IDENTITIY_SELECTOR__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case DSLPackage.NODE_IDENTITIY_SELECTOR__SEFF:
				if (resolve) return getSeff();
				return basicGetSeff();
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
		switch (featureID) {
			case DSLPackage.NODE_IDENTITIY_SELECTOR__NAME:
				setName((String)newValue);
				return;
			case DSLPackage.NODE_IDENTITIY_SELECTOR__ASSEMBLY:
				setAssembly((AssemblyContext)newValue);
				return;
			case DSLPackage.NODE_IDENTITIY_SELECTOR__COMPONENT:
				setComponent((BasicComponent)newValue);
				return;
			case DSLPackage.NODE_IDENTITIY_SELECTOR__SEFF:
				setSeff((ServiceEffectSpecification)newValue);
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
		switch (featureID) {
			case DSLPackage.NODE_IDENTITIY_SELECTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DSLPackage.NODE_IDENTITIY_SELECTOR__ASSEMBLY:
				setAssembly((AssemblyContext)null);
				return;
			case DSLPackage.NODE_IDENTITIY_SELECTOR__COMPONENT:
				setComponent((BasicComponent)null);
				return;
			case DSLPackage.NODE_IDENTITIY_SELECTOR__SEFF:
				setSeff((ServiceEffectSpecification)null);
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
		switch (featureID) {
			case DSLPackage.NODE_IDENTITIY_SELECTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DSLPackage.NODE_IDENTITIY_SELECTOR__ASSEMBLY:
				return assembly != null;
			case DSLPackage.NODE_IDENTITIY_SELECTOR__COMPONENT:
				return component != null;
			case DSLPackage.NODE_IDENTITIY_SELECTOR__SEFF:
				return seff != null;
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NodeIdentitiySelectorImpl