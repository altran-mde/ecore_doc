/**
 */
package com.altran.general.ecoredoc.generator.config.impl;

import com.altran.general.ecoredoc.generator.config.ConfigPackage;
import com.altran.general.ecoredoc.generator.config.EClassConfig;
import com.altran.general.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EPackage Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl#getTargetEPackage <em>Target EPackage</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl#getEDataTypes <em>EData Types</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl#getEEnums <em>EEnums</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl#getEClasses <em>EClasses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EPackageConfigImpl extends MinimalEObjectImpl.Container implements EPackageConfig {
	/**
	 * The default value of the '{@link #isRenderDefaults() <em>Render Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderDefaults()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_DEFAULTS_EDEFAULT = false;

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
	 * This is true if the Render Defaults attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderDefaultsESet;

	/**
	 * The default value of the '{@link #isRender() <em>Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRender()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRender() <em>Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRender()
	 * @generated
	 * @ordered
	 */
	protected boolean render = RENDER_EDEFAULT;

	/**
	 * This is true if the Render attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderESet;

	/**
	 * The cached value of the '{@link #getTargetEPackage() <em>Target EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage targetEPackage;

	/**
	 * The cached value of the '{@link #getEDataTypes() <em>EData Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDataTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EDataTypeConfig> eDataTypes;

	/**
	 * The cached value of the '{@link #getEEnums() <em>EEnums</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEEnums()
	 * @generated
	 * @ordered
	 */
	protected EList<EEnumConfig> eEnums;

	/**
	 * The cached value of the '{@link #getEClasses() <em>EClasses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<EClassConfig> eClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPackageConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.EPACKAGE_CONFIG;
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
		boolean oldRenderDefaultsESet = renderDefaultsESet;
		renderDefaultsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, renderDefaults, !oldRenderDefaultsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRenderDefaults() {
		boolean oldRenderDefaults = renderDefaults;
		boolean oldRenderDefaultsESet = renderDefaultsESet;
		renderDefaults = RENDER_DEFAULTS_EDEFAULT;
		renderDefaultsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, RENDER_DEFAULTS_EDEFAULT, oldRenderDefaultsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRenderDefaults() {
		return renderDefaultsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRender() {
		return render;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRender(boolean newRender) {
		boolean oldRender = render;
		render = newRender;
		boolean oldRenderESet = renderESet;
		renderESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EPACKAGE_CONFIG__RENDER, oldRender, render, !oldRenderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRender() {
		boolean oldRender = render;
		boolean oldRenderESet = renderESet;
		render = RENDER_EDEFAULT;
		renderESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.EPACKAGE_CONFIG__RENDER, oldRender, RENDER_EDEFAULT, oldRenderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRender() {
		return renderESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getTargetEPackage() {
		if (targetEPackage != null && targetEPackage.eIsProxy()) {
			InternalEObject oldTargetEPackage = (InternalEObject)targetEPackage;
			targetEPackage = (EPackage)eResolveProxy(oldTargetEPackage);
			if (targetEPackage != oldTargetEPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.EPACKAGE_CONFIG__TARGET_EPACKAGE, oldTargetEPackage, targetEPackage));
			}
		}
		return targetEPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetTargetEPackage() {
		return targetEPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEPackage(EPackage newTargetEPackage) {
		EPackage oldTargetEPackage = targetEPackage;
		targetEPackage = newTargetEPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EPACKAGE_CONFIG__TARGET_EPACKAGE, oldTargetEPackage, targetEPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDataTypeConfig> getEDataTypes() {
		if (eDataTypes == null) {
			eDataTypes = new EObjectContainmentEList<EDataTypeConfig>(EDataTypeConfig.class, this, ConfigPackage.EPACKAGE_CONFIG__EDATA_TYPES);
		}
		return eDataTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EEnumConfig> getEEnums() {
		if (eEnums == null) {
			eEnums = new EObjectContainmentEList<EEnumConfig>(EEnumConfig.class, this, ConfigPackage.EPACKAGE_CONFIG__EENUMS);
		}
		return eEnums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClassConfig> getEClasses() {
		if (eClasses == null) {
			eClasses = new EObjectContainmentEList<EClassConfig>(EClassConfig.class, this, ConfigPackage.EPACKAGE_CONFIG__ECLASSES);
		}
		return eClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENamedElement getTarget() {
		return this.getTargetEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean shouldRenderDefaults() {
		boolean _xifexpression = false;
		boolean _isSetRenderDefaults = this.isSetRenderDefaults();
		if (_isSetRenderDefaults) {
			_xifexpression = this.isRenderDefaults();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEcoreDocGeneratorConfig) _eContainer).shouldRenderDefaults();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean shouldRender() {
		boolean _xifexpression = false;
		boolean _isSetRender = this.isSetRender();
		if (_isSetRender) {
			_xifexpression = this.isRender();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEcoreDocGeneratorConfig) _eContainer).shouldRender();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.EPACKAGE_CONFIG__EDATA_TYPES:
				return ((InternalEList<?>)getEDataTypes()).basicRemove(otherEnd, msgs);
			case ConfigPackage.EPACKAGE_CONFIG__EENUMS:
				return ((InternalEList<?>)getEEnums()).basicRemove(otherEnd, msgs);
			case ConfigPackage.EPACKAGE_CONFIG__ECLASSES:
				return ((InternalEList<?>)getEClasses()).basicRemove(otherEnd, msgs);
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
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case ConfigPackage.EPACKAGE_CONFIG__RENDER:
				return isRender();
			case ConfigPackage.EPACKAGE_CONFIG__TARGET_EPACKAGE:
				if (resolve) return getTargetEPackage();
				return basicGetTargetEPackage();
			case ConfigPackage.EPACKAGE_CONFIG__EDATA_TYPES:
				return getEDataTypes();
			case ConfigPackage.EPACKAGE_CONFIG__EENUMS:
				return getEEnums();
			case ConfigPackage.EPACKAGE_CONFIG__ECLASSES:
				return getEClasses();
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
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__TARGET_EPACKAGE:
				setTargetEPackage((EPackage)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__EDATA_TYPES:
				getEDataTypes().clear();
				getEDataTypes().addAll((Collection<? extends EDataTypeConfig>)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__EENUMS:
				getEEnums().clear();
				getEEnums().addAll((Collection<? extends EEnumConfig>)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__ECLASSES:
				getEClasses().clear();
				getEClasses().addAll((Collection<? extends EClassConfig>)newValue);
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
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__RENDER:
				unsetRender();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__TARGET_EPACKAGE:
				setTargetEPackage((EPackage)null);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__EDATA_TYPES:
				getEDataTypes().clear();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__EENUMS:
				getEEnums().clear();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__ECLASSES:
				getEClasses().clear();
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
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case ConfigPackage.EPACKAGE_CONFIG__RENDER:
				return isSetRender();
			case ConfigPackage.EPACKAGE_CONFIG__TARGET_EPACKAGE:
				return targetEPackage != null;
			case ConfigPackage.EPACKAGE_CONFIG__EDATA_TYPES:
				return eDataTypes != null && !eDataTypes.isEmpty();
			case ConfigPackage.EPACKAGE_CONFIG__EENUMS:
				return eEnums != null && !eEnums.isEmpty();
			case ConfigPackage.EPACKAGE_CONFIG__ECLASSES:
				return eClasses != null && !eClasses.isEmpty();
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
			case ConfigPackage.EPACKAGE_CONFIG___GET_TARGET:
				return getTarget();
			case ConfigPackage.EPACKAGE_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case ConfigPackage.EPACKAGE_CONFIG___SHOULD_RENDER:
				return shouldRender();
		}
		return super.eInvoke(operationID, arguments);
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
		if (renderDefaultsESet) result.append(renderDefaults); else result.append("<unset>");
		result.append(", render: ");
		if (renderESet) result.append(render); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EPackageConfigImpl
