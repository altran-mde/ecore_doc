/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage;
import com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig;
import com.altran.general.emf.ecoredoc.generator.config.IDiagramConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;

import com.google.common.collect.Iterables;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EEnum Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl#isRenderDiagrams <em>Render Diagrams</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl#isRenderUseCases <em>Render Use Cases</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl#getTargetEEnum <em>Target EEnum</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl#getEEnumLiterals <em>EEnum Literals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EEnumConfigImpl extends MinimalEObjectImpl.Container implements EEnumConfig {
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
	 * The default value of the '{@link #isRenderDiagrams() <em>Render Diagrams</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderDiagrams()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_DIAGRAMS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRenderDiagrams() <em>Render Diagrams</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderDiagrams()
	 * @generated
	 * @ordered
	 */
	protected boolean renderDiagrams = RENDER_DIAGRAMS_EDEFAULT;

	/**
	 * This is true if the Render Diagrams attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderDiagramsESet;

	/**
	 * The default value of the '{@link #isRenderUseCases() <em>Render Use Cases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderUseCases()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_USE_CASES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRenderUseCases() <em>Render Use Cases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderUseCases()
	 * @generated
	 * @ordered
	 */
	protected boolean renderUseCases = RENDER_USE_CASES_EDEFAULT;

	/**
	 * This is true if the Render Use Cases attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderUseCasesESet;

	/**
	 * The cached value of the '{@link #getTargetEEnum() <em>Target EEnum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEEnum()
	 * @generated
	 * @ordered
	 */
	protected EEnum targetEEnum;

	/**
	 * The cached value of the '{@link #getEEnumLiterals() <em>EEnum Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEEnumLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EEnumLiteralConfig> eEnumLiterals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EEnumConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcoreDocConfigPackage.Literals.EENUM_CONFIG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EENUM_CONFIG__RENDER, oldRender, render, !oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.EENUM_CONFIG__RENDER, oldRender, RENDER_EDEFAULT, oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, renderDefaults, !oldRenderDefaultsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, RENDER_DEFAULTS_EDEFAULT, oldRenderDefaultsESet));
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
	public boolean isRenderDiagrams() {
		return renderDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenderDiagrams(boolean newRenderDiagrams) {
		boolean oldRenderDiagrams = renderDiagrams;
		renderDiagrams = newRenderDiagrams;
		boolean oldRenderDiagramsESet = renderDiagramsESet;
		renderDiagramsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DIAGRAMS, oldRenderDiagrams, renderDiagrams, !oldRenderDiagramsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRenderDiagrams() {
		boolean oldRenderDiagrams = renderDiagrams;
		boolean oldRenderDiagramsESet = renderDiagramsESet;
		renderDiagrams = RENDER_DIAGRAMS_EDEFAULT;
		renderDiagramsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DIAGRAMS, oldRenderDiagrams, RENDER_DIAGRAMS_EDEFAULT, oldRenderDiagramsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRenderDiagrams() {
		return renderDiagramsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRenderUseCases() {
		return renderUseCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenderUseCases(boolean newRenderUseCases) {
		boolean oldRenderUseCases = renderUseCases;
		renderUseCases = newRenderUseCases;
		boolean oldRenderUseCasesESet = renderUseCasesESet;
		renderUseCasesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EENUM_CONFIG__RENDER_USE_CASES, oldRenderUseCases, renderUseCases, !oldRenderUseCasesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRenderUseCases() {
		boolean oldRenderUseCases = renderUseCases;
		boolean oldRenderUseCasesESet = renderUseCasesESet;
		renderUseCases = RENDER_USE_CASES_EDEFAULT;
		renderUseCasesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.EENUM_CONFIG__RENDER_USE_CASES, oldRenderUseCases, RENDER_USE_CASES_EDEFAULT, oldRenderUseCasesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRenderUseCases() {
		return renderUseCasesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTargetEEnum() {
		if (targetEEnum != null && targetEEnum.eIsProxy()) {
			InternalEObject oldTargetEEnum = (InternalEObject)targetEEnum;
			targetEEnum = (EEnum)eResolveProxy(oldTargetEEnum);
			if (targetEEnum != oldTargetEEnum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcoreDocConfigPackage.EENUM_CONFIG__TARGET_EENUM, oldTargetEEnum, targetEEnum));
			}
		}
		return targetEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum basicGetTargetEEnum() {
		return targetEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetEEnum(EEnum newTargetEEnum) {
		EEnum oldTargetEEnum = targetEEnum;
		targetEEnum = newTargetEEnum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EENUM_CONFIG__TARGET_EENUM, oldTargetEEnum, targetEEnum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EEnumLiteralConfig> getEEnumLiterals() {
		if (eEnumLiterals == null) {
			eEnumLiterals = new EObjectContainmentEList<EEnumLiteralConfig>(EEnumLiteralConfig.class, this, EcoreDocConfigPackage.EENUM_CONFIG__EENUM_LITERALS);
		}
		return eEnumLiterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ENamedElement getTarget() {
		return this.getTargetEEnum();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addEEnumLiterals(final List<EEnumLiteralConfig> eEnumLiteralConfig) {
		EList<EEnumLiteralConfig> _eEnumLiterals = this.getEEnumLiterals();
		Iterables.<EEnumLiteralConfig>addAll(_eEnumLiterals, eEnumLiteralConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean shouldRenderUseCases() {
		boolean _xifexpression = false;
		boolean _isSetRenderUseCases = this.isSetRenderUseCases();
		if (_isSetRenderUseCases) {
			_xifexpression = this.isRenderUseCases();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEClassifierConfig) _eContainer).shouldRenderUseCases();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean shouldRenderDiagrams() {
		boolean _xifexpression = false;
		boolean _isSetRenderDiagrams = this.isSetRenderDiagrams();
		if (_isSetRenderDiagrams) {
			_xifexpression = this.isRenderDiagrams();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IDiagramConfig) _eContainer).shouldRenderDiagrams();
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcoreDocConfigPackage.EENUM_CONFIG__EENUM_LITERALS:
				return ((InternalEList<?>)getEEnumLiterals()).basicRemove(otherEnd, msgs);
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
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER:
				return isRender();
			case EcoreDocConfigPackage.EENUM_CONFIG__ID:
				return getId();
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DIAGRAMS:
				return isRenderDiagrams();
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_USE_CASES:
				return isRenderUseCases();
			case EcoreDocConfigPackage.EENUM_CONFIG__TARGET_EENUM:
				if (resolve) return getTargetEEnum();
				return basicGetTargetEEnum();
			case EcoreDocConfigPackage.EENUM_CONFIG__EENUM_LITERALS:
				return getEEnumLiterals();
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
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DIAGRAMS:
				setRenderDiagrams((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_USE_CASES:
				setRenderUseCases((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__TARGET_EENUM:
				setTargetEEnum((EEnum)newValue);
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__EENUM_LITERALS:
				getEEnumLiterals().clear();
				getEEnumLiterals().addAll((Collection<? extends EEnumLiteralConfig>)newValue);
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
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER:
				unsetRender();
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DIAGRAMS:
				unsetRenderDiagrams();
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_USE_CASES:
				unsetRenderUseCases();
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__TARGET_EENUM:
				setTargetEEnum((EEnum)null);
				return;
			case EcoreDocConfigPackage.EENUM_CONFIG__EENUM_LITERALS:
				getEEnumLiterals().clear();
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
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER:
				return isSetRender();
			case EcoreDocConfigPackage.EENUM_CONFIG__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DIAGRAMS:
				return isSetRenderDiagrams();
			case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_USE_CASES:
				return isSetRenderUseCases();
			case EcoreDocConfigPackage.EENUM_CONFIG__TARGET_EENUM:
				return targetEEnum != null;
			case EcoreDocConfigPackage.EENUM_CONFIG__EENUM_LITERALS:
				return eEnumLiterals != null && !eEnumLiterals.isEmpty();
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
				case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IDiagramConfig.class) {
			switch (derivedFeatureID) {
				case EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DIAGRAMS: return EcoreDocConfigPackage.IDIAGRAM_CONFIG__RENDER_DIAGRAMS;
				default: return -1;
			}
		}
		if (baseClass == IEEnumLiteralConfig.class) {
			switch (derivedFeatureID) {
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
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IDiagramConfig.class) {
			switch (baseFeatureID) {
				case EcoreDocConfigPackage.IDIAGRAM_CONFIG__RENDER_DIAGRAMS: return EcoreDocConfigPackage.EENUM_CONFIG__RENDER_DIAGRAMS;
				default: return -1;
			}
		}
		if (baseClass == IEEnumLiteralConfig.class) {
			switch (baseFeatureID) {
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
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS: return EcoreDocConfigPackage.EENUM_CONFIG___SHOULD_RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IDiagramConfig.class) {
			switch (baseOperationID) {
				case EcoreDocConfigPackage.IDIAGRAM_CONFIG___SHOULD_RENDER_DIAGRAMS: return EcoreDocConfigPackage.EENUM_CONFIG___SHOULD_RENDER_DIAGRAMS;
				default: return -1;
			}
		}
		if (baseClass == IEEnumLiteralConfig.class) {
			switch (baseOperationID) {
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EcoreDocConfigPackage.EENUM_CONFIG___GET_TARGET:
				return getTarget();
			case EcoreDocConfigPackage.EENUM_CONFIG___ADD_EENUM_LITERALS__LIST:
				addEEnumLiterals((List<EEnumLiteralConfig>)arguments.get(0));
				return null;
			case EcoreDocConfigPackage.EENUM_CONFIG___SHOULD_RENDER_USE_CASES:
				return shouldRenderUseCases();
			case EcoreDocConfigPackage.EENUM_CONFIG___SHOULD_RENDER_DIAGRAMS:
				return shouldRenderDiagrams();
			case EcoreDocConfigPackage.EENUM_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case EcoreDocConfigPackage.EENUM_CONFIG___SHOULD_RENDER:
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
		result.append(", renderDiagrams: ");
		if (renderDiagramsESet) result.append(renderDiagrams); else result.append("<unset>");
		result.append(", renderUseCases: ");
		if (renderUseCasesESet) result.append(renderUseCases); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EEnumConfigImpl
