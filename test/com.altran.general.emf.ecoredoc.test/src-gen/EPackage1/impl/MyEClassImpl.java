/**
 */
package EPackage1.impl;

import EPackage1.EClass1;
import EPackage1.EPackage1Package;
import EPackage1.MyEClass;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My EClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EPackage1.impl.MyEClassImpl#getBackwards <em>Backwards</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MyEClassImpl extends EClass1Impl implements MyEClass {
	/**
	 * The cached value of the '{@link #getBackwards() <em>Backwards</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackwards()
	 * @generated
	 * @ordered
	 */
	protected EClass1 backwards;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MyEClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EPackage1Package.Literals.MY_ECLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass1 getBackwards() {
		if (backwards != null && backwards.eIsProxy()) {
			InternalEObject oldBackwards = (InternalEObject)backwards;
			backwards = (EClass1)eResolveProxy(oldBackwards);
			if (backwards != oldBackwards) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EPackage1Package.MY_ECLASS__BACKWARDS, oldBackwards, backwards));
			}
		}
		return backwards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass1 basicGetBackwards() {
		return backwards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackwards(EClass1 newBackwards, NotificationChain msgs) {
		EClass1 oldBackwards = backwards;
		backwards = newBackwards;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EPackage1Package.MY_ECLASS__BACKWARDS, oldBackwards, newBackwards);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackwards(EClass1 newBackwards) {
		if (newBackwards != backwards) {
			NotificationChain msgs = null;
			if (backwards != null)
				msgs = ((InternalEObject)backwards).eInverseRemove(this, EPackage1Package.ECLASS1__MY_RELATION, EClass1.class, msgs);
			if (newBackwards != null)
				msgs = ((InternalEObject)newBackwards).eInverseAdd(this, EPackage1Package.ECLASS1__MY_RELATION, EClass1.class, msgs);
			msgs = basicSetBackwards(newBackwards, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EPackage1Package.MY_ECLASS__BACKWARDS, newBackwards, newBackwards));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EPackage1Package.MY_ECLASS__BACKWARDS:
				if (backwards != null)
					msgs = ((InternalEObject)backwards).eInverseRemove(this, EPackage1Package.ECLASS1__MY_RELATION, EClass1.class, msgs);
				return basicSetBackwards((EClass1)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EPackage1Package.MY_ECLASS__BACKWARDS:
				return basicSetBackwards(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EPackage1Package.MY_ECLASS__BACKWARDS:
				if (resolve) return getBackwards();
				return basicGetBackwards();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EPackage1Package.MY_ECLASS__BACKWARDS:
				setBackwards((EClass1)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case EPackage1Package.MY_ECLASS__BACKWARDS:
				setBackwards((EClass1)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EPackage1Package.MY_ECLASS__BACKWARDS:
				return backwards != null;
		}
		return super.eIsSet(featureID);
	}

} //MyEClassImpl
