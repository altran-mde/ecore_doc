/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.AEReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage;
import com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AE Reference Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.AEReferenceConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.AEReferenceConfigImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.AEReferenceConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.AEReferenceConfigImpl#isRenderBounds <em>Render Bounds</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AEReferenceConfigImpl extends MinimalEObjectImpl.Container implements AEReferenceConfig {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AEReferenceConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcoreDocConfigPackage.Literals.AE_REFERENCE_CONFIG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER, oldRender, render, !oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER, oldRender, RENDER_EDEFAULT, oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, renderDefaults, !oldRenderDefaultsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, RENDER_DEFAULTS_EDEFAULT, oldRenderDefaultsESet));
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
	public boolean isRenderBounds() {
		return renderBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderBounds(boolean newRenderBounds) {
		boolean oldRenderBounds = renderBounds;
		renderBounds = newRenderBounds;
		boolean oldRenderBoundsESet = renderBoundsESet;
		renderBoundsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_BOUNDS, oldRenderBounds, renderBounds, !oldRenderBoundsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRenderBounds() {
		boolean oldRenderBounds = renderBounds;
		boolean oldRenderBoundsESet = renderBoundsESet;
		renderBounds = RENDER_BOUNDS_EDEFAULT;
		renderBoundsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_BOUNDS, oldRenderBounds, RENDER_BOUNDS_EDEFAULT, oldRenderBoundsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRenderBounds() {
		return renderBoundsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
				_xifexpression_1 = ((IEStructuralFeatureConfig) _eContainer).shouldRenderBounds();
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
	public ENamedElement getTarget() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER:
				return isRender();
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__ID:
				return getId();
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_BOUNDS:
				return isRenderBounds();
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
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_BOUNDS:
				setRenderBounds((Boolean)newValue);
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
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER:
				unsetRender();
				return;
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_BOUNDS:
				unsetRenderBounds();
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
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER:
				return isSetRender();
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_BOUNDS:
				return isSetRenderBounds();
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
				case EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS;
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
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.AE_REFERENCE_CONFIG__RENDER_DEFAULTS;
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
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS: return EcoreDocConfigPackage.AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS;
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
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG___SHOULD_RENDER_BOUNDS:
				return shouldRenderBounds();
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG___SHOULD_RENDER:
				return shouldRender();
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG___GET_TARGET:
				return getTarget();
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
		result.append(" (render: ");
		if (renderESet) result.append(render); else result.append("<unset>");
		result.append(", renderDefaults: ");
		if (renderDefaultsESet) result.append(renderDefaults); else result.append("<unset>");
		result.append(", renderBounds: ");
		if (renderBoundsESet) result.append(renderBounds); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //AEReferenceConfigImpl
