/**
 */
package EPackage1.impl;

import EPackage1.Class3;
import EPackage1.EPackage1Package;
import EPackage1.Enum1;
import EPackage1.MyEClass;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EPackage1.impl.Class3Impl#getSomething <em>Something</em>}</li>
 *   <li>{@link EPackage1.impl.Class3Impl#getSpecialParent <em>Special Parent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Class3Impl extends EClass1Impl implements Class3 {
	/**
	 * The cached value of the '{@link #getSomething() <em>Something</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSomething()
	 * @generated
	 * @ordered
	 */
	protected EList<Enum1> something;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Class3Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EPackage1Package.Literals.CLASS3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Enum1> getSomething() {
		if (something == null) {
			something = new EDataTypeEList<Enum1>(Enum1.class, this, EPackage1Package.CLASS3__SOMETHING);
		}
		return something;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MyEClass getSpecialParent() {
		if (eContainerFeatureID() != EPackage1Package.CLASS3__SPECIAL_PARENT) return null;
		return (MyEClass)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MyEClass basicGetSpecialParent() {
		if (eContainerFeatureID() != EPackage1Package.CLASS3__SPECIAL_PARENT) return null;
		return (MyEClass)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecialParent(MyEClass newSpecialParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSpecialParent, EPackage1Package.CLASS3__SPECIAL_PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecialParent(MyEClass newSpecialParent) {
		if (newSpecialParent != eInternalContainer() || (eContainerFeatureID() != EPackage1Package.CLASS3__SPECIAL_PARENT && newSpecialParent != null)) {
			if (EcoreUtil.isAncestor(this, newSpecialParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecialParent != null)
				msgs = ((InternalEObject)newSpecialParent).eInverseAdd(this, EPackage1Package.MY_ECLASS__CLAZZES, MyEClass.class, msgs);
			msgs = basicSetSpecialParent(newSpecialParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EPackage1Package.CLASS3__SPECIAL_PARENT, newSpecialParent, newSpecialParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EPackage1Package.CLASS3__SPECIAL_PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSpecialParent((MyEClass)otherEnd, msgs);
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
			case EPackage1Package.CLASS3__SPECIAL_PARENT:
				return basicSetSpecialParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EPackage1Package.CLASS3__SPECIAL_PARENT:
				return eInternalContainer().eInverseRemove(this, EPackage1Package.MY_ECLASS__CLAZZES, MyEClass.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EPackage1Package.CLASS3__SOMETHING:
				return getSomething();
			case EPackage1Package.CLASS3__SPECIAL_PARENT:
				if (resolve) return getSpecialParent();
				return basicGetSpecialParent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EPackage1Package.CLASS3__SOMETHING:
				getSomething().clear();
				getSomething().addAll((Collection<? extends Enum1>)newValue);
				return;
			case EPackage1Package.CLASS3__SPECIAL_PARENT:
				setSpecialParent((MyEClass)newValue);
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
			case EPackage1Package.CLASS3__SOMETHING:
				getSomething().clear();
				return;
			case EPackage1Package.CLASS3__SPECIAL_PARENT:
				setSpecialParent((MyEClass)null);
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
			case EPackage1Package.CLASS3__SOMETHING:
				return something != null && !something.isEmpty();
			case EPackage1Package.CLASS3__SPECIAL_PARENT:
				return basicGetSpecialParent() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (something: ");
		result.append(something);
		result.append(')');
		return result.toString();
	}

} //Class3Impl
