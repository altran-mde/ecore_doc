/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig;

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EContainment Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EContainmentConfigImpl#getTargetEContainment <em>Target EContainment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EContainmentConfigImpl extends AEReferenceConfigImpl implements EContainmentConfig {
	/**
	 * The cached value of the '{@link #getTargetEContainment() <em>Target EContainment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEContainment()
	 * @generated
	 * @ordered
	 */
	protected EReference targetEContainment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EContainmentConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcoreDocConfigPackage.Literals.ECONTAINMENT_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetEContainment() {
		if (targetEContainment != null && targetEContainment.eIsProxy()) {
			InternalEObject oldTargetEContainment = (InternalEObject)targetEContainment;
			targetEContainment = (EReference)eResolveProxy(oldTargetEContainment);
			if (targetEContainment != oldTargetEContainment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcoreDocConfigPackage.ECONTAINMENT_CONFIG__TARGET_ECONTAINMENT, oldTargetEContainment, targetEContainment));
			}
		}
		return targetEContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetTargetEContainment() {
		return targetEContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEContainment(EReference newTargetEContainment) {
		EReference oldTargetEContainment = targetEContainment;
		targetEContainment = newTargetEContainment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECONTAINMENT_CONFIG__TARGET_ECONTAINMENT, oldTargetEContainment, targetEContainment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENamedElement getTarget() {
		return this.getTargetEContainment();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcoreDocConfigPackage.ECONTAINMENT_CONFIG__TARGET_ECONTAINMENT:
				if (resolve) return getTargetEContainment();
				return basicGetTargetEContainment();
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
			case EcoreDocConfigPackage.ECONTAINMENT_CONFIG__TARGET_ECONTAINMENT:
				setTargetEContainment((EReference)newValue);
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
			case EcoreDocConfigPackage.ECONTAINMENT_CONFIG__TARGET_ECONTAINMENT:
				setTargetEContainment((EReference)null);
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
			case EcoreDocConfigPackage.ECONTAINMENT_CONFIG__TARGET_ECONTAINMENT:
				return targetEContainment != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EcoreDocConfigPackage.ECONTAINMENT_CONFIG___GET_TARGET:
				return getTarget();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EContainmentConfigImpl
