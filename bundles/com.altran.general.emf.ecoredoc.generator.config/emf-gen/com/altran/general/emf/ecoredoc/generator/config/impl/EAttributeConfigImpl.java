/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage;
import com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EAttribute Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EAttributeConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EAttributeConfigImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EAttributeConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EAttributeConfigImpl#isRenderBounds <em>Render Bounds</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EAttributeConfigImpl#getTargetEAttribute <em>Target EAttribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EAttributeConfigImpl extends MinimalEObjectImpl.Container implements EAttributeConfig {
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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

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
	 * The default value of the '{@link #isRenderBounds() <em>Render Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderBounds()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_BOUNDS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRenderBounds() <em>Render Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderBounds()
	 * @generated
	 * @ordered
	 */
	protected boolean renderBounds = RENDER_BOUNDS_EDEFAULT;

	/**
	 * This is true if the Render Bounds attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderBoundsESet;

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
		return EcoreDocConfigPackage.Literals.EATTRIBUTE_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRender() {
		return render;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRender(boolean newRender) {
		boolean oldRender = render;
		render = newRender;
		boolean oldRenderESet = renderESet;
		renderESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER, oldRender, render, !oldRenderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRender() {
		boolean oldRender = render;
		boolean oldRenderESet = renderESet;
		render = RENDER_EDEFAULT;
		renderESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER, oldRender, RENDER_EDEFAULT, oldRenderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRender() {
		return renderESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		ENamedElement _target = this.getTarget();
		String _name = null;
		if (_target!=null) {
			_name=_target.getName();
		}
		return _name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRenderDefaults() {
		return renderDefaults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenderDefaults(boolean newRenderDefaults) {
		boolean oldRenderDefaults = renderDefaults;
		renderDefaults = newRenderDefaults;
		boolean oldRenderDefaultsESet = renderDefaultsESet;
		renderDefaultsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, renderDefaults, !oldRenderDefaultsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRenderDefaults() {
		boolean oldRenderDefaults = renderDefaults;
		boolean oldRenderDefaultsESet = renderDefaultsESet;
		renderDefaults = RENDER_DEFAULTS_EDEFAULT;
		renderDefaultsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, RENDER_DEFAULTS_EDEFAULT, oldRenderDefaultsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRenderDefaults() {
		return renderDefaultsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRenderBounds() {
		return renderBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenderBounds(boolean newRenderBounds) {
		boolean oldRenderBounds = renderBounds;
		renderBounds = newRenderBounds;
		boolean oldRenderBoundsESet = renderBoundsESet;
		renderBoundsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_BOUNDS, oldRenderBounds, renderBounds, !oldRenderBoundsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRenderBounds() {
		boolean oldRenderBounds = renderBounds;
		boolean oldRenderBoundsESet = renderBoundsESet;
		renderBounds = RENDER_BOUNDS_EDEFAULT;
		renderBoundsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_BOUNDS, oldRenderBounds, RENDER_BOUNDS_EDEFAULT, oldRenderBoundsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRenderBounds() {
		return renderBoundsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTargetEAttribute() {
		if (targetEAttribute != null && targetEAttribute.eIsProxy()) {
			InternalEObject oldTargetEAttribute = (InternalEObject)targetEAttribute;
			targetEAttribute = (EAttribute)eResolveProxy(oldTargetEAttribute);
			if (targetEAttribute != oldTargetEAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcoreDocConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE, oldTargetEAttribute, targetEAttribute));
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
	@Override
	public void setTargetEAttribute(EAttribute newTargetEAttribute) {
		EAttribute oldTargetEAttribute = targetEAttribute;
		targetEAttribute = newTargetEAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE, oldTargetEAttribute, targetEAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ENamedElement getTarget() {
		return this.getTargetEAttribute();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean shouldRenderBounds() {
		boolean _xifexpression = false;
		boolean _isSetRenderBounds = this.isSetRenderBounds();
		if (_isSetRenderBounds) {
			_xifexpression = this.isRenderBounds();
		}
		else {
			boolean _xifexpression_1 = false;
			boolean _isSetRenderDefaults = this.isSetRenderDefaults();
			if (_isSetRenderDefaults) {
				_xifexpression_1 = this.isRenderDefaults();
			}
			else {
				EObject _eContainer = this.eContainer();
				_xifexpression_1 = ((IETypedElementConfig) _eContainer).shouldRenderBounds();
			}
			_xifexpression = _xifexpression_1;
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean shouldRenderDefaults() {
		boolean _xifexpression = false;
		boolean _isSetRenderDefaults = this.isSetRenderDefaults();
		if (_isSetRenderDefaults) {
			_xifexpression = this.isRenderDefaults();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IDefaultValueConfig) _eContainer).shouldRenderDefaults();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean shouldRender() {
		boolean _xifexpression = false;
		boolean _isSetRender = this.isSetRender();
		if (_isSetRender) {
			_xifexpression = this.isRender();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IENamedElementConfig) _eContainer).shouldRender();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER:
				return isRender();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__ID:
				return getId();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_BOUNDS:
				return isRenderBounds();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE:
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
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_BOUNDS:
				setRenderBounds((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE:
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
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER:
				unsetRender();
				return;
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_BOUNDS:
				unsetRenderBounds();
				return;
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE:
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
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER:
				return isSetRender();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_BOUNDS:
				return isSetRenderBounds();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IDefaultValueConfig.class) {
			switch (derivedFeatureID) {
				case EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IDefaultValueConfig.class) {
			switch (baseFeatureID) {
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.EATTRIBUTE_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == IDefaultValueConfig.class) {
			switch (baseOperationID) {
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS: return EcoreDocConfigPackage.EATTRIBUTE_CONFIG___SHOULD_RENDER_DEFAULTS;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG___GET_TARGET:
				return getTarget();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG___SHOULD_RENDER_BOUNDS:
				return shouldRenderBounds();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG___SHOULD_RENDER:
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (render: ");
		if (renderESet) result.append(render); else result.append("<unset>");
		result.append(", renderDefaults: ");
		if (renderDefaultsESet) result.append(renderDefaults); else result.append("<unset>");
		result.append(", renderBounds: ");
		if (renderBoundsESet) result.append(renderBounds); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EAttributeConfigImpl
