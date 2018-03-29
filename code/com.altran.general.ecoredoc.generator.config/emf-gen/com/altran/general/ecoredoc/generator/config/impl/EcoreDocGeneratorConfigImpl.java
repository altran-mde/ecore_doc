/**
 */
package com.altran.general.ecoredoc.generator.config.impl;

import com.altran.general.ecoredoc.generator.config.ConfigPackage;
import com.altran.general.ecoredoc.generator.config.EClassConfig;
import com.altran.general.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecore Doc Generator Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getEDataType <em>EData Type</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getEEnum <em>EEnum</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getEClass <em>EClass</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EcoreDocGeneratorConfigImpl extends MinimalEObjectImpl.Container implements EcoreDocGeneratorConfig {
	/**
	 * The default value of the '{@link #isRenderDefaults() <em>Render Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderDefaults()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_DEFAULTS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRenderDefaults() <em>Render Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderDefaults()
	 * @generated
	 * @ordered
	 */
	protected boolean renderDefaults = RENDER_DEFAULTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEDataType() <em>EData Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDataType()
	 * @generated
	 * @ordered
	 */
	protected EDataTypeConfig eDataType;

	/**
	 * The cached value of the '{@link #getEEnum() <em>EEnum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEEnum()
	 * @generated
	 * @ordered
	 */
	protected EEnumConfig eEnum;

	/**
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected EClassConfig eClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreDocGeneratorConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.ECORE_DOC_GENERATOR_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRenderDefaults() {
		return renderDefaults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderDefaults(boolean newRenderDefaults) {
		boolean oldRenderDefaults = renderDefaults;
		renderDefaults = newRenderDefaults;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, renderDefaults));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataTypeConfig getEDataType() {
		return eDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEDataType(EDataTypeConfig newEDataType, NotificationChain msgs) {
		EDataTypeConfig oldEDataType = eDataType;
		eDataType = newEDataType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE, oldEDataType, newEDataType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEDataType(EDataTypeConfig newEDataType) {
		if (newEDataType != eDataType) {
			NotificationChain msgs = null;
			if (eDataType != null)
				msgs = ((InternalEObject)eDataType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE, null, msgs);
			if (newEDataType != null)
				msgs = ((InternalEObject)newEDataType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE, null, msgs);
			msgs = basicSetEDataType(newEDataType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE, newEDataType, newEDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumConfig getEEnum() {
		return eEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEEnum(EEnumConfig newEEnum, NotificationChain msgs) {
		EEnumConfig oldEEnum = eEnum;
		eEnum = newEEnum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EENUM, oldEEnum, newEEnum);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEEnum(EEnumConfig newEEnum) {
		if (newEEnum != eEnum) {
			NotificationChain msgs = null;
			if (eEnum != null)
				msgs = ((InternalEObject)eEnum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EENUM, null, msgs);
			if (newEEnum != null)
				msgs = ((InternalEObject)newEEnum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EENUM, null, msgs);
			msgs = basicSetEEnum(newEEnum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EENUM, newEEnum, newEEnum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassConfig getEClass() {
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEClass(EClassConfig newEClass, NotificationChain msgs) {
		EClassConfig oldEClass = eClass;
		eClass = newEClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ECLASS, oldEClass, newEClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEClass(EClassConfig newEClass) {
		if (newEClass != eClass) {
			NotificationChain msgs = null;
			if (eClass != null)
				msgs = ((InternalEObject)eClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ECLASS, null, msgs);
			if (newEClass != null)
				msgs = ((InternalEObject)newEClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ECLASS, null, msgs);
			msgs = basicSetEClass(newEClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ECLASS, newEClass, newEClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE:
				return basicSetEDataType(null, msgs);
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EENUM:
				return basicSetEEnum(null, msgs);
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ECLASS:
				return basicSetEClass(null, msgs);
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE:
				return getEDataType();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EENUM:
				return getEEnum();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ECLASS:
				return getEClass();
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE:
				setEDataType((EDataTypeConfig)newValue);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EENUM:
				setEEnum((EEnumConfig)newValue);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ECLASS:
				setEClass((EClassConfig)newValue);
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults(RENDER_DEFAULTS_EDEFAULT);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE:
				setEDataType((EDataTypeConfig)null);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EENUM:
				setEEnum((EEnumConfig)null);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ECLASS:
				setEClass((EClassConfig)null);
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				return renderDefaults != RENDER_DEFAULTS_EDEFAULT;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE:
				return eDataType != null;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EENUM:
				return eEnum != null;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ECLASS:
				return eClass != null;
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
		result.append(" (renderDefaults: ");
		result.append(renderDefaults);
		result.append(')');
		return result.toString();
	}

} //EcoreDocGeneratorConfigImpl
