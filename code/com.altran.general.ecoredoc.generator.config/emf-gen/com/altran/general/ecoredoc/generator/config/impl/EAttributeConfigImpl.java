/**
 */
package com.altran.general.ecoredoc.generator.config.impl;

import com.altran.general.ecoredoc.generator.config.ConfigPackage;
import com.altran.general.ecoredoc.generator.config.EAttributeConfig;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EAttribute Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EAttributeConfigImpl#getTargetEAttribute <em>Target EAttribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EAttributeConfigImpl extends AEStructuralFeatureConfigImpl implements EAttributeConfig {
	/**
	 * The cached value of the '{@link #getTargetEAttribute() <em>Target EAttribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute targetEAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAttributeConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.EATTRIBUTE_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTargetEAttribute() {
		if (targetEAttribute != null && targetEAttribute.eIsProxy()) {
			InternalEObject oldTargetEAttribute = (InternalEObject)targetEAttribute;
			targetEAttribute = (EAttribute)eResolveProxy(oldTargetEAttribute);
			if (targetEAttribute != oldTargetEAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE, oldTargetEAttribute, targetEAttribute));
			}
		}
		return targetEAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetTargetEAttribute() {
		return targetEAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEAttribute(EAttribute newTargetEAttribute) {
		EAttribute oldTargetEAttribute = targetEAttribute;
		targetEAttribute = newTargetEAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE, oldTargetEAttribute, targetEAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENamedElement getTarget() {
		return this.getTargetEAttribute();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE:
				if (resolve) return getTargetEAttribute();
				return basicGetTargetEAttribute();
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
			case ConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE:
				setTargetEAttribute((EAttribute)newValue);
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
			case ConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE:
				setTargetEAttribute((EAttribute)null);
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
			case ConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE:
				return targetEAttribute != null;
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
			case ConfigPackage.EATTRIBUTE_CONFIG___GET_TARGET:
				return getTarget();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EAttributeConfigImpl
