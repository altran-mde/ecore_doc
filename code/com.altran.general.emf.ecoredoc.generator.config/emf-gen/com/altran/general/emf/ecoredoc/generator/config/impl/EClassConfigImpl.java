/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.ConfigPackage;
import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig;

import com.google.common.collect.Iterables;
import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EClass Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRenderUseCases <em>Render Use Cases</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRepeatInherited <em>Repeat Inherited</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRenderBounds <em>Render Bounds</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getTargetEClass <em>Target EClass</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getEAttributes <em>EAttributes</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getEContainments <em>EContainments</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getEReferences <em>EReferences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EClassConfigImpl extends MinimalEObjectImpl.Container implements EClassConfig {
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
	 * The default value of the '{@link #isRepeatInherited() <em>Repeat Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRepeatInherited()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REPEAT_INHERITED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRepeatInherited() <em>Repeat Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRepeatInherited()
	 * @generated
	 * @ordered
	 */
	protected boolean repeatInherited = REPEAT_INHERITED_EDEFAULT;

	/**
	 * This is true if the Repeat Inherited attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean repeatInheritedESet;

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
	 * The cached value of the '{@link #getTargetEClass() <em>Target EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass targetEClass;

	/**
	 * The cached value of the '{@link #getEAttributes() <em>EAttributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<EAttributeConfig> eAttributes;

	/**
	 * The cached value of the '{@link #getEContainments() <em>EContainments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEContainments()
	 * @generated
	 * @ordered
	 */
	protected EList<EContainmentConfig> eContainments;

	/**
	 * The cached value of the '{@link #getEReferences() <em>EReferences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<EReferenceConfig> eReferences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClassConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.ECLASS_CONFIG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECLASS_CONFIG__RENDER, oldRender, render, !oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.ECLASS_CONFIG__RENDER, oldRender, RENDER_EDEFAULT, oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, renderDefaults, !oldRenderDefaultsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, RENDER_DEFAULTS_EDEFAULT, oldRenderDefaultsESet));
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
	public boolean isRenderUseCases() {
		return renderUseCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderUseCases(boolean newRenderUseCases) {
		boolean oldRenderUseCases = renderUseCases;
		renderUseCases = newRenderUseCases;
		boolean oldRenderUseCasesESet = renderUseCasesESet;
		renderUseCasesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES, oldRenderUseCases, renderUseCases, !oldRenderUseCasesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRenderUseCases() {
		boolean oldRenderUseCases = renderUseCases;
		boolean oldRenderUseCasesESet = renderUseCasesESet;
		renderUseCases = RENDER_USE_CASES_EDEFAULT;
		renderUseCasesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES, oldRenderUseCases, RENDER_USE_CASES_EDEFAULT, oldRenderUseCasesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRenderUseCases() {
		return renderUseCasesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRepeatInherited() {
		return repeatInherited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeatInherited(boolean newRepeatInherited) {
		boolean oldRepeatInherited = repeatInherited;
		repeatInherited = newRepeatInherited;
		boolean oldRepeatInheritedESet = repeatInheritedESet;
		repeatInheritedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED, oldRepeatInherited, repeatInherited, !oldRepeatInheritedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepeatInherited() {
		boolean oldRepeatInherited = repeatInherited;
		boolean oldRepeatInheritedESet = repeatInheritedESet;
		repeatInherited = REPEAT_INHERITED_EDEFAULT;
		repeatInheritedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED, oldRepeatInherited, REPEAT_INHERITED_EDEFAULT, oldRepeatInheritedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepeatInherited() {
		return repeatInheritedESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS, oldRenderBounds, renderBounds, !oldRenderBoundsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS, oldRenderBounds, RENDER_BOUNDS_EDEFAULT, oldRenderBoundsESet));
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
	public EClass getTargetEClass() {
		if (targetEClass != null && targetEClass.eIsProxy()) {
			InternalEObject oldTargetEClass = (InternalEObject)targetEClass;
			targetEClass = (EClass)eResolveProxy(oldTargetEClass);
			if (targetEClass != oldTargetEClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.ECLASS_CONFIG__TARGET_ECLASS, oldTargetEClass, targetEClass));
			}
		}
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetTargetEClass() {
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEClass(EClass newTargetEClass) {
		EClass oldTargetEClass = targetEClass;
		targetEClass = newTargetEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECLASS_CONFIG__TARGET_ECLASS, oldTargetEClass, targetEClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAttributeConfig> getEAttributes() {
		if (eAttributes == null) {
			eAttributes = new EObjectContainmentEList<EAttributeConfig>(EAttributeConfig.class, this, ConfigPackage.ECLASS_CONFIG__EATTRIBUTES);
		}
		return eAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EContainmentConfig> getEContainments() {
		if (eContainments == null) {
			eContainments = new EObjectContainmentEList<EContainmentConfig>(EContainmentConfig.class, this, ConfigPackage.ECLASS_CONFIG__ECONTAINMENTS);
		}
		return eContainments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReferenceConfig> getEReferences() {
		if (eReferences == null) {
			eReferences = new EObjectContainmentEList<EReferenceConfig>(EReferenceConfig.class, this, ConfigPackage.ECLASS_CONFIG__EREFERENCES);
		}
		return eReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENamedElement getTarget() {
		return this.getTargetEClass();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addEAttributes(final List<EAttributeConfig> eAttributeConfig) {
		EList<EAttributeConfig> _eAttributes = this.getEAttributes();
		Iterables.<EAttributeConfig>addAll(_eAttributes, eAttributeConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addEContainments(final List<EContainmentConfig> eContainmentConfig) {
		EList<EContainmentConfig> _eContainments = this.getEContainments();
		Iterables.<EContainmentConfig>addAll(_eContainments, eContainmentConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addEReferences(final List<EReferenceConfig> eReferenceConfig) {
		EList<EReferenceConfig> _eReferences = this.getEReferences();
		Iterables.<EReferenceConfig>addAll(_eReferences, eReferenceConfig);
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
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEStructuralFeatureConfig) _eContainer).shouldRenderBounds();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean shouldRepeatInherited() {
		boolean _xifexpression = false;
		boolean _isSetRepeatInherited = this.isSetRepeatInherited();
		if (_isSetRepeatInherited) {
			_xifexpression = this.isRepeatInherited();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEClassConfig) _eContainer).shouldRepeatInherited();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				return ((InternalEList<?>)getEAttributes()).basicRemove(otherEnd, msgs);
			case ConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				return ((InternalEList<?>)getEContainments()).basicRemove(otherEnd, msgs);
			case ConfigPackage.ECLASS_CONFIG__EREFERENCES:
				return ((InternalEList<?>)getEReferences()).basicRemove(otherEnd, msgs);
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
			case ConfigPackage.ECLASS_CONFIG__RENDER:
				return isRender();
			case ConfigPackage.ECLASS_CONFIG__ID:
				return getId();
			case ConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case ConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES:
				return isRenderUseCases();
			case ConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED:
				return isRepeatInherited();
			case ConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS:
				return isRenderBounds();
			case ConfigPackage.ECLASS_CONFIG__TARGET_ECLASS:
				if (resolve) return getTargetEClass();
				return basicGetTargetEClass();
			case ConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				return getEAttributes();
			case ConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				return getEContainments();
			case ConfigPackage.ECLASS_CONFIG__EREFERENCES:
				return getEReferences();
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
			case ConfigPackage.ECLASS_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case ConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case ConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES:
				setRenderUseCases((Boolean)newValue);
				return;
			case ConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED:
				setRepeatInherited((Boolean)newValue);
				return;
			case ConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS:
				setRenderBounds((Boolean)newValue);
				return;
			case ConfigPackage.ECLASS_CONFIG__TARGET_ECLASS:
				setTargetEClass((EClass)newValue);
				return;
			case ConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				getEAttributes().clear();
				getEAttributes().addAll((Collection<? extends EAttributeConfig>)newValue);
				return;
			case ConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				getEContainments().clear();
				getEContainments().addAll((Collection<? extends EContainmentConfig>)newValue);
				return;
			case ConfigPackage.ECLASS_CONFIG__EREFERENCES:
				getEReferences().clear();
				getEReferences().addAll((Collection<? extends EReferenceConfig>)newValue);
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
			case ConfigPackage.ECLASS_CONFIG__RENDER:
				unsetRender();
				return;
			case ConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case ConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES:
				unsetRenderUseCases();
				return;
			case ConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED:
				unsetRepeatInherited();
				return;
			case ConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS:
				unsetRenderBounds();
				return;
			case ConfigPackage.ECLASS_CONFIG__TARGET_ECLASS:
				setTargetEClass((EClass)null);
				return;
			case ConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				getEAttributes().clear();
				return;
			case ConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				getEContainments().clear();
				return;
			case ConfigPackage.ECLASS_CONFIG__EREFERENCES:
				getEReferences().clear();
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
			case ConfigPackage.ECLASS_CONFIG__RENDER:
				return isSetRender();
			case ConfigPackage.ECLASS_CONFIG__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case ConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case ConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES:
				return isSetRenderUseCases();
			case ConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED:
				return isSetRepeatInherited();
			case ConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS:
				return isSetRenderBounds();
			case ConfigPackage.ECLASS_CONFIG__TARGET_ECLASS:
				return targetEClass != null;
			case ConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				return eAttributes != null && !eAttributes.isEmpty();
			case ConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				return eContainments != null && !eContainments.isEmpty();
			case ConfigPackage.ECLASS_CONFIG__EREFERENCES:
				return eReferences != null && !eReferences.isEmpty();
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
				case ConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS: return ConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (derivedFeatureID) {
				case ConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS: return ConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG__RENDER_BOUNDS;
				default: return -1;
			}
		}
		if (baseClass == IEAttributeConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEReferenceConfig.class) {
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
				case ConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS: return ConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseFeatureID) {
				case ConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG__RENDER_BOUNDS: return ConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS;
				default: return -1;
			}
		}
		if (baseClass == IEAttributeConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEReferenceConfig.class) {
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
				case ConfigPackage.IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS: return ConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseOperationID) {
				case ConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_BOUNDS: return ConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_BOUNDS;
				default: return -1;
			}
		}
		if (baseClass == IEAttributeConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEReferenceConfig.class) {
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
			case ConfigPackage.ECLASS_CONFIG___GET_TARGET:
				return getTarget();
			case ConfigPackage.ECLASS_CONFIG___ADD_EATTRIBUTES__LIST:
				addEAttributes((List<EAttributeConfig>)arguments.get(0));
				return null;
			case ConfigPackage.ECLASS_CONFIG___ADD_ECONTAINMENTS__LIST:
				addEContainments((List<EContainmentConfig>)arguments.get(0));
				return null;
			case ConfigPackage.ECLASS_CONFIG___ADD_EREFERENCES__LIST:
				addEReferences((List<EReferenceConfig>)arguments.get(0));
				return null;
			case ConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_BOUNDS:
				return shouldRenderBounds();
			case ConfigPackage.ECLASS_CONFIG___SHOULD_REPEAT_INHERITED:
				return shouldRepeatInherited();
			case ConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_USE_CASES:
				return shouldRenderUseCases();
			case ConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case ConfigPackage.ECLASS_CONFIG___SHOULD_RENDER:
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
		result.append(", renderDefaults: ");
		if (renderDefaultsESet) result.append(renderDefaults); else result.append("<unset>");
		result.append(", renderUseCases: ");
		if (renderUseCasesESet) result.append(renderUseCases); else result.append("<unset>");
		result.append(", repeatInherited: ");
		if (repeatInheritedESet) result.append(repeatInherited); else result.append("<unset>");
		result.append(", renderBounds: ");
		if (renderBoundsESet) result.append(renderBounds); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EClassConfigImpl
