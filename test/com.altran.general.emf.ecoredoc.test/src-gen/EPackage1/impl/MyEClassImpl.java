/**
 */
package EPackage1.impl;

import EPackage1.Class3;
import EPackage1.EClass1;
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My EClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EPackage1.impl.MyEClassImpl#getAttr <em>Attr</em>}</li>
 *   <li>{@link EPackage1.impl.MyEClassImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link EPackage1.impl.MyEClassImpl#getClazzes <em>Clazzes</em>}</li>
 *   <li>{@link EPackage1.impl.MyEClassImpl#getEeeenum <em>Eeeenum</em>}</li>
 *   <li>{@link EPackage1.impl.MyEClassImpl#getOtherClasses <em>Other Classes</em>}</li>
 *   <li>{@link EPackage1.impl.MyEClassImpl#getBackwards <em>Backwards</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MyEClassImpl extends EClass1Impl implements MyEClass {
	/**
	 * The default value of the '{@link #getAttr() <em>Attr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttr()
	 * @generated
	 * @ordered
	 */
	protected static final Number ATTR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttr() <em>Attr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttr()
	 * @generated
	 * @ordered
	 */
	protected Number attr = ATTR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected EClass1 ref;

	/**
	 * The cached value of the '{@link #getClazzes() <em>Clazzes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClazzes()
	 * @generated
	 * @ordered
	 */
	protected EList<Class3> clazzes;

	/**
	 * The cached value of the '{@link #getEeeenum() <em>Eeeenum</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEeeenum()
	 * @generated
	 * @ordered
	 */
	protected EList<Enum1> eeeenum;

	/**
	 * The cached value of the '{@link #getOtherClasses() <em>Other Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<Class3> otherClasses;

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
	public Number getAttr() {
		return attr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttr(Number newAttr) {
		Number oldAttr = attr;
		attr = newAttr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EPackage1Package.MY_ECLASS__ATTR, oldAttr, attr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass1 getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (EClass1)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EPackage1Package.MY_ECLASS__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass1 basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(EClass1 newRef) {
		EClass1 oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EPackage1Package.MY_ECLASS__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Class3> getClazzes() {
		if (clazzes == null) {
			clazzes = new EObjectContainmentWithInverseEList<Class3>(Class3.class, this, EPackage1Package.MY_ECLASS__CLAZZES, EPackage1Package.CLASS3__SPECIAL_PARENT);
		}
		return clazzes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Enum1> getEeeenum() {
		if (eeeenum == null) {
			eeeenum = new EDataTypeEList<Enum1>(Enum1.class, this, EPackage1Package.MY_ECLASS__EEEENUM);
		}
		return eeeenum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Class3> getOtherClasses() {
		if (otherClasses == null) {
			otherClasses = new EObjectContainmentEList<Class3>(Class3.class, this, EPackage1Package.MY_ECLASS__OTHER_CLASSES);
		}
		return otherClasses;
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EPackage1Package.MY_ECLASS__CLAZZES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClazzes()).basicAdd(otherEnd, msgs);
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
			case EPackage1Package.MY_ECLASS__CLAZZES:
				return ((InternalEList<?>)getClazzes()).basicRemove(otherEnd, msgs);
			case EPackage1Package.MY_ECLASS__OTHER_CLASSES:
				return ((InternalEList<?>)getOtherClasses()).basicRemove(otherEnd, msgs);
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
			case EPackage1Package.MY_ECLASS__ATTR:
				return getAttr();
			case EPackage1Package.MY_ECLASS__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case EPackage1Package.MY_ECLASS__CLAZZES:
				return getClazzes();
			case EPackage1Package.MY_ECLASS__EEEENUM:
				return getEeeenum();
			case EPackage1Package.MY_ECLASS__OTHER_CLASSES:
				return getOtherClasses();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EPackage1Package.MY_ECLASS__ATTR:
				setAttr((Number)newValue);
				return;
			case EPackage1Package.MY_ECLASS__REF:
				setRef((EClass1)newValue);
				return;
			case EPackage1Package.MY_ECLASS__CLAZZES:
				getClazzes().clear();
				getClazzes().addAll((Collection<? extends Class3>)newValue);
				return;
			case EPackage1Package.MY_ECLASS__EEEENUM:
				getEeeenum().clear();
				getEeeenum().addAll((Collection<? extends Enum1>)newValue);
				return;
			case EPackage1Package.MY_ECLASS__OTHER_CLASSES:
				getOtherClasses().clear();
				getOtherClasses().addAll((Collection<? extends Class3>)newValue);
				return;
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
			case EPackage1Package.MY_ECLASS__ATTR:
				setAttr(ATTR_EDEFAULT);
				return;
			case EPackage1Package.MY_ECLASS__REF:
				setRef((EClass1)null);
				return;
			case EPackage1Package.MY_ECLASS__CLAZZES:
				getClazzes().clear();
				return;
			case EPackage1Package.MY_ECLASS__EEEENUM:
				getEeeenum().clear();
				return;
			case EPackage1Package.MY_ECLASS__OTHER_CLASSES:
				getOtherClasses().clear();
				return;
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
			case EPackage1Package.MY_ECLASS__ATTR:
				return ATTR_EDEFAULT == null ? attr != null : !ATTR_EDEFAULT.equals(attr);
			case EPackage1Package.MY_ECLASS__REF:
				return ref != null;
			case EPackage1Package.MY_ECLASS__CLAZZES:
				return clazzes != null && !clazzes.isEmpty();
			case EPackage1Package.MY_ECLASS__EEEENUM:
				return eeeenum != null && !eeeenum.isEmpty();
			case EPackage1Package.MY_ECLASS__OTHER_CLASSES:
				return otherClasses != null && !otherClasses.isEmpty();
			case EPackage1Package.MY_ECLASS__BACKWARDS:
				return backwards != null;
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
		result.append(" (attr: ");
		result.append(attr);
		result.append(", eeeenum: ");
		result.append(eeeenum);
		result.append(')');
		return result.toString();
	}

} //MyEClassImpl
