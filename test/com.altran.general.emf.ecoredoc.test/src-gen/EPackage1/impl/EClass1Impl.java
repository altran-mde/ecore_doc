/**
 */
package EPackage1.impl;

import EPackage1.EClass1;
import EPackage1.EPackage1Package;
import EPackage1.MyEClass;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EClass1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EPackage1.impl.EClass1Impl#getName <em>Name</em>}</li>
 *   <li>{@link EPackage1.impl.EClass1Impl#getId <em>Id</em>}</li>
 *   <li>{@link EPackage1.impl.EClass1Impl#getSpecialNumber <em>Special Number</em>}</li>
 *   <li>{@link EPackage1.impl.EClass1Impl#getSomeStringAttr <em>Some String Attr</em>}</li>
 *   <li>{@link EPackage1.impl.EClass1Impl#getMyRelation <em>My Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EClass1Impl extends MinimalEObjectImpl.Container implements EClass1 {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EList<String> name;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpecialNumber() <em>Special Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecialNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int SPECIAL_NUMBER_EDEFAULT = 23;

	/**
	 * The cached value of the '{@link #getSpecialNumber() <em>Special Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecialNumber()
	 * @generated
	 * @ordered
	 */
	protected int specialNumber = SPECIAL_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSomeStringAttr() <em>Some String Attr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSomeStringAttr()
	 * @generated
	 * @ordered
	 */
	protected static final String SOME_STRING_ATTR_EDEFAULT = "Hello, World!";

	/**
	 * The cached value of the '{@link #getSomeStringAttr() <em>Some String Attr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSomeStringAttr()
	 * @generated
	 * @ordered
	 */
	protected String someStringAttr = SOME_STRING_ATTR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMyRelation() <em>My Relation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyRelation()
	 * @generated
	 * @ordered
	 */
	protected EList<MyEClass> myRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EPackage1Package.Literals.ECLASS1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getName() {
		if (name == null) {
			name = new EDataTypeEList<String>(String.class, this, EPackage1Package.ECLASS1__NAME);
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EPackage1Package.ECLASS1__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSpecialNumber() {
		return specialNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecialNumber(int newSpecialNumber) {
		int oldSpecialNumber = specialNumber;
		specialNumber = newSpecialNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EPackage1Package.ECLASS1__SPECIAL_NUMBER, oldSpecialNumber, specialNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSomeStringAttr() {
		return someStringAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSomeStringAttr(String newSomeStringAttr) {
		String oldSomeStringAttr = someStringAttr;
		someStringAttr = newSomeStringAttr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EPackage1Package.ECLASS1__SOME_STRING_ATTR, oldSomeStringAttr, someStringAttr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MyEClass> getMyRelation() {
		if (myRelation == null) {
			myRelation = new EObjectWithInverseResolvingEList<MyEClass>(MyEClass.class, this, EPackage1Package.ECLASS1__MY_RELATION, EPackage1Package.MY_ECLASS__BACKWARDS);
		}
		return myRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EPackage1Package.ECLASS1__MY_RELATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMyRelation()).basicAdd(otherEnd, msgs);
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
			case EPackage1Package.ECLASS1__MY_RELATION:
				return ((InternalEList<?>)getMyRelation()).basicRemove(otherEnd, msgs);
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
			case EPackage1Package.ECLASS1__NAME:
				return getName();
			case EPackage1Package.ECLASS1__ID:
				return getId();
			case EPackage1Package.ECLASS1__SPECIAL_NUMBER:
				return getSpecialNumber();
			case EPackage1Package.ECLASS1__SOME_STRING_ATTR:
				return getSomeStringAttr();
			case EPackage1Package.ECLASS1__MY_RELATION:
				return getMyRelation();
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
			case EPackage1Package.ECLASS1__NAME:
				getName().clear();
				getName().addAll((Collection<? extends String>)newValue);
				return;
			case EPackage1Package.ECLASS1__ID:
				setId((Integer)newValue);
				return;
			case EPackage1Package.ECLASS1__SPECIAL_NUMBER:
				setSpecialNumber((Integer)newValue);
				return;
			case EPackage1Package.ECLASS1__SOME_STRING_ATTR:
				setSomeStringAttr((String)newValue);
				return;
			case EPackage1Package.ECLASS1__MY_RELATION:
				getMyRelation().clear();
				getMyRelation().addAll((Collection<? extends MyEClass>)newValue);
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
			case EPackage1Package.ECLASS1__NAME:
				getName().clear();
				return;
			case EPackage1Package.ECLASS1__ID:
				setId(ID_EDEFAULT);
				return;
			case EPackage1Package.ECLASS1__SPECIAL_NUMBER:
				setSpecialNumber(SPECIAL_NUMBER_EDEFAULT);
				return;
			case EPackage1Package.ECLASS1__SOME_STRING_ATTR:
				setSomeStringAttr(SOME_STRING_ATTR_EDEFAULT);
				return;
			case EPackage1Package.ECLASS1__MY_RELATION:
				getMyRelation().clear();
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
			case EPackage1Package.ECLASS1__NAME:
				return name != null && !name.isEmpty();
			case EPackage1Package.ECLASS1__ID:
				return id != ID_EDEFAULT;
			case EPackage1Package.ECLASS1__SPECIAL_NUMBER:
				return specialNumber != SPECIAL_NUMBER_EDEFAULT;
			case EPackage1Package.ECLASS1__SOME_STRING_ATTR:
				return SOME_STRING_ATTR_EDEFAULT == null ? someStringAttr != null : !SOME_STRING_ATTR_EDEFAULT.equals(someStringAttr);
			case EPackage1Package.ECLASS1__MY_RELATION:
				return myRelation != null && !myRelation.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", specialNumber: ");
		result.append(specialNumber);
		result.append(", someStringAttr: ");
		result.append(someStringAttr);
		result.append(')');
		return result.toString();
	}

} //EClass1Impl
