/**
 * generated by Xtext 2.21.0
 */
package de.sebinside.dcp.dsl.dSL.impl;

import de.sebinside.dcp.dsl.dSL.BooleanOperation;
import de.sebinside.dcp.dsl.dSL.DSLPackage;
import de.sebinside.dcp.dsl.dSL.LogicalOrOperation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Or Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.impl.LogicalOrOperationImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link de.sebinside.dcp.dsl.dSL.impl.LogicalOrOperationImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LogicalOrOperationImpl extends BooleanOperationImpl implements LogicalOrOperation
{
  /**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
  protected BooleanOperation left;

  /**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
  protected BooleanOperation right;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LogicalOrOperationImpl()
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
		return DSLPackage.Literals.LOGICAL_OR_OPERATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public BooleanOperation getLeft()
  {
		return left;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLeft(BooleanOperation newLeft, NotificationChain msgs)
  {
		BooleanOperation oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DSLPackage.LOGICAL_OR_OPERATION__LEFT, oldLeft, newLeft);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setLeft(BooleanOperation newLeft)
  {
		if (newLeft != left) {
			NotificationChain msgs = null;
			if (left != null)
				msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DSLPackage.LOGICAL_OR_OPERATION__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DSLPackage.LOGICAL_OR_OPERATION__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DSLPackage.LOGICAL_OR_OPERATION__LEFT, newLeft, newLeft));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public BooleanOperation getRight()
  {
		return right;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetRight(BooleanOperation newRight, NotificationChain msgs)
  {
		BooleanOperation oldRight = right;
		right = newRight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DSLPackage.LOGICAL_OR_OPERATION__RIGHT, oldRight, newRight);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setRight(BooleanOperation newRight)
  {
		if (newRight != right) {
			NotificationChain msgs = null;
			if (right != null)
				msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DSLPackage.LOGICAL_OR_OPERATION__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DSLPackage.LOGICAL_OR_OPERATION__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DSLPackage.LOGICAL_OR_OPERATION__RIGHT, newRight, newRight));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case DSLPackage.LOGICAL_OR_OPERATION__LEFT:
				return basicSetLeft(null, msgs);
			case DSLPackage.LOGICAL_OR_OPERATION__RIGHT:
				return basicSetRight(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case DSLPackage.LOGICAL_OR_OPERATION__LEFT:
				return getLeft();
			case DSLPackage.LOGICAL_OR_OPERATION__RIGHT:
				return getRight();
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
			case DSLPackage.LOGICAL_OR_OPERATION__LEFT:
				setLeft((BooleanOperation)newValue);
				return;
			case DSLPackage.LOGICAL_OR_OPERATION__RIGHT:
				setRight((BooleanOperation)newValue);
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
			case DSLPackage.LOGICAL_OR_OPERATION__LEFT:
				setLeft((BooleanOperation)null);
				return;
			case DSLPackage.LOGICAL_OR_OPERATION__RIGHT:
				setRight((BooleanOperation)null);
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
			case DSLPackage.LOGICAL_OR_OPERATION__LEFT:
				return left != null;
			case DSLPackage.LOGICAL_OR_OPERATION__RIGHT:
				return right != null;
		}
		return super.eIsSet(featureID);
	}

} //LogicalOrOperationImpl
