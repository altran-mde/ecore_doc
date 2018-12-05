/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EEnum Literal Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl#getTargetEEnumLiteral <em>Target EEnum Literal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EEnumLiteralConfigImpl extends MinimalEObjectImpl.Container implements EEnumLiteralConfig {
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
	 * The cached value of the '{@link #getTargetEEnumLiteral() <em>Target EEnum Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEEnumLiteral()
	 * @generated
	 * @ordered
	 */
	protected EEnumLiteral targetEEnumLiteral;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EEnumLiteralConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcoreDocConfigPackage.Literals.EENUM_LITERAL_CONFIG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__RENDER, oldRender, render, !oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__RENDER, oldRender, RENDER_EDEFAULT, oldRenderESet));
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
	public EEnumLiteral getTargetEEnumLiteral() {
		if (targetEEnumLiteral != null && targetEEnumLiteral.eIsProxy()) {
			InternalEObject oldTargetEEnumLiteral = (InternalEObject)targetEEnumLiteral;
			targetEEnumLiteral = (EEnumLiteral)eResolveProxy(oldTargetEEnumLiteral);
			if (targetEEnumLiteral != oldTargetEEnumLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL, oldTargetEEnumLiteral, targetEEnumLiteral));
			}
		}
		return targetEEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteral basicGetTargetEEnumLiteral() {
		return targetEEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEEnumLiteral(EEnumLiteral newTargetEEnumLiteral) {
		EEnumLiteral oldTargetEEnumLiteral = targetEEnumLiteral;
		targetEEnumLiteral = newTargetEEnumLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL, oldTargetEEnumLiteral, targetEEnumLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENamedElement getTarget() {
		return this.getTargetEEnumLiteral();
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__RENDER:
				return isRender();
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__ID:
				return getId();
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL:
				if (resolve) return getTargetEEnumLiteral();
				return basicGetTargetEEnumLiteral();
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
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL:
				setTargetEEnumLiteral((EEnumLiteral)newValue);
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
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__RENDER:
				unsetRender();
				return;
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL:
				setTargetEEnumLiteral((EEnumLiteral)null);
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
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__RENDER:
				return isSetRender();
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL:
				return targetEEnumLiteral != null;
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
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG___GET_TARGET:
				return getTarget();
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG___SHOULD_RENDER:
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
		result.append(" (render: ");
		if (renderESet) result.append(render); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EEnumLiteralConfigImpl
