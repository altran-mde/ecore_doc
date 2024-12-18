/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.emf.ecoredoc.generator.config.EOperationConfig;
import com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage;
import com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig;
import com.altran.general.emf.ecoredoc.generator.config.IDiagramConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig;
import com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig;

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
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRenderDiagrams <em>Render Diagrams</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRenderUseCases <em>Render Use Cases</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRepeatInherited <em>Repeat Inherited</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRenderSubTypes <em>Render Sub Types</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRenderSuperTypes <em>Render Super Types</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#isRenderBounds <em>Render Bounds</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getTargetEClass <em>Target EClass</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getEAttributes <em>EAttributes</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getEContainments <em>EContainments</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getEReferences <em>EReferences</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl#getEOperations <em>EOperations</em>}</li>
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
	 * The default value of the '{@link #isRenderSubTypes() <em>Render Sub Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderSubTypes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_SUB_TYPES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRenderSubTypes() <em>Render Sub Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderSubTypes()
	 * @generated
	 * @ordered
	 */
	protected boolean renderSubTypes = RENDER_SUB_TYPES_EDEFAULT;

	/**
	 * This is true if the Render Sub Types attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderSubTypesESet;

	/**
	 * The default value of the '{@link #isRenderSuperTypes() <em>Render Super Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_SUPER_TYPES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRenderSuperTypes() <em>Render Super Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected boolean renderSuperTypes = RENDER_SUPER_TYPES_EDEFAULT;

	/**
	 * This is true if the Render Super Types attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderSuperTypesESet;

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
	 * The cached value of the '{@link #getEOperations() <em>EOperations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<EOperationConfig> eOperations;

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
		return EcoreDocConfigPackage.Literals.ECLASS_CONFIG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER, oldRender, render, !oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER, oldRender, RENDER_EDEFAULT, oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, renderDefaults, !oldRenderDefaultsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, RENDER_DEFAULTS_EDEFAULT, oldRenderDefaultsESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DIAGRAMS, oldRenderDiagrams, renderDiagrams, !oldRenderDiagramsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DIAGRAMS, oldRenderDiagrams, RENDER_DIAGRAMS_EDEFAULT, oldRenderDiagramsESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES, oldRenderUseCases, renderUseCases, !oldRenderUseCasesESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES, oldRenderUseCases, RENDER_USE_CASES_EDEFAULT, oldRenderUseCasesESet));
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
	public boolean isRepeatInherited() {
		return repeatInherited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepeatInherited(boolean newRepeatInherited) {
		boolean oldRepeatInherited = repeatInherited;
		repeatInherited = newRepeatInherited;
		boolean oldRepeatInheritedESet = repeatInheritedESet;
		repeatInheritedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED, oldRepeatInherited, repeatInherited, !oldRepeatInheritedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRepeatInherited() {
		boolean oldRepeatInherited = repeatInherited;
		boolean oldRepeatInheritedESet = repeatInheritedESet;
		repeatInherited = REPEAT_INHERITED_EDEFAULT;
		repeatInheritedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED, oldRepeatInherited, REPEAT_INHERITED_EDEFAULT, oldRepeatInheritedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRepeatInherited() {
		return repeatInheritedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRenderSubTypes() {
		return renderSubTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenderSubTypes(boolean newRenderSubTypes) {
		boolean oldRenderSubTypes = renderSubTypes;
		renderSubTypes = newRenderSubTypes;
		boolean oldRenderSubTypesESet = renderSubTypesESet;
		renderSubTypesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUB_TYPES, oldRenderSubTypes, renderSubTypes, !oldRenderSubTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRenderSubTypes() {
		boolean oldRenderSubTypes = renderSubTypes;
		boolean oldRenderSubTypesESet = renderSubTypesESet;
		renderSubTypes = RENDER_SUB_TYPES_EDEFAULT;
		renderSubTypesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUB_TYPES, oldRenderSubTypes, RENDER_SUB_TYPES_EDEFAULT, oldRenderSubTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRenderSubTypes() {
		return renderSubTypesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRenderSuperTypes() {
		return renderSuperTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenderSuperTypes(boolean newRenderSuperTypes) {
		boolean oldRenderSuperTypes = renderSuperTypes;
		renderSuperTypes = newRenderSuperTypes;
		boolean oldRenderSuperTypesESet = renderSuperTypesESet;
		renderSuperTypesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUPER_TYPES, oldRenderSuperTypes, renderSuperTypes, !oldRenderSuperTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRenderSuperTypes() {
		boolean oldRenderSuperTypes = renderSuperTypes;
		boolean oldRenderSuperTypesESet = renderSuperTypesESet;
		renderSuperTypes = RENDER_SUPER_TYPES_EDEFAULT;
		renderSuperTypesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUPER_TYPES, oldRenderSuperTypes, RENDER_SUPER_TYPES_EDEFAULT, oldRenderSuperTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRenderSuperTypes() {
		return renderSuperTypesESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS, oldRenderBounds, renderBounds, !oldRenderBoundsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS, oldRenderBounds, RENDER_BOUNDS_EDEFAULT, oldRenderBoundsESet));
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
	public EClass getTargetEClass() {
		if (targetEClass != null && targetEClass.eIsProxy()) {
			InternalEObject oldTargetEClass = (InternalEObject)targetEClass;
			targetEClass = (EClass)eResolveProxy(oldTargetEClass);
			if (targetEClass != oldTargetEClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcoreDocConfigPackage.ECLASS_CONFIG__TARGET_ECLASS, oldTargetEClass, targetEClass));
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
	@Override
	public void setTargetEClass(EClass newTargetEClass) {
		EClass oldTargetEClass = targetEClass;
		targetEClass = newTargetEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECLASS_CONFIG__TARGET_ECLASS, oldTargetEClass, targetEClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAttributeConfig> getEAttributes() {
		if (eAttributes == null) {
			eAttributes = new EObjectContainmentEList<EAttributeConfig>(EAttributeConfig.class, this, EcoreDocConfigPackage.ECLASS_CONFIG__EATTRIBUTES);
		}
		return eAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EContainmentConfig> getEContainments() {
		if (eContainments == null) {
			eContainments = new EObjectContainmentEList<EContainmentConfig>(EContainmentConfig.class, this, EcoreDocConfigPackage.ECLASS_CONFIG__ECONTAINMENTS);
		}
		return eContainments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EReferenceConfig> getEReferences() {
		if (eReferences == null) {
			eReferences = new EObjectContainmentEList<EReferenceConfig>(EReferenceConfig.class, this, EcoreDocConfigPackage.ECLASS_CONFIG__EREFERENCES);
		}
		return eReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EOperationConfig> getEOperations() {
		if (eOperations == null) {
			eOperations = new EObjectContainmentEList<EOperationConfig>(EOperationConfig.class, this, EcoreDocConfigPackage.ECLASS_CONFIG__EOPERATIONS);
		}
		return eOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ENamedElement getTarget() {
		return this.getTargetEClass();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addEAttributes(final List<EAttributeConfig> eAttributeConfig) {
		EList<EAttributeConfig> _eAttributes = this.getEAttributes();
		Iterables.<EAttributeConfig>addAll(_eAttributes, eAttributeConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addEContainments(final List<EContainmentConfig> eContainmentConfig) {
		EList<EContainmentConfig> _eContainments = this.getEContainments();
		Iterables.<EContainmentConfig>addAll(_eContainments, eContainmentConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addEReferences(final List<EReferenceConfig> eReferenceConfig) {
		EList<EReferenceConfig> _eReferences = this.getEReferences();
		Iterables.<EReferenceConfig>addAll(_eReferences, eReferenceConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addEOperations(final List<EOperationConfig> eOperationConfig) {
		EList<EOperationConfig> _eOperations = this.getEOperations();
		Iterables.<EOperationConfig>addAll(_eOperations, eOperationConfig);
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
	@Override
	public boolean shouldRenderSubTypes() {
		boolean _xifexpression = false;
		boolean _isSetRenderSubTypes = this.isSetRenderSubTypes();
		if (_isSetRenderSubTypes) {
			_xifexpression = this.isRenderSubTypes();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEClassConfig) _eContainer).shouldRenderSubTypes();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean shouldRenderSuperTypes() {
		boolean _xifexpression = false;
		boolean _isSetRenderSuperTypes = this.isSetRenderSuperTypes();
		if (_isSetRenderSuperTypes) {
			_xifexpression = this.isRenderSuperTypes();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEClassConfig) _eContainer).shouldRenderSuperTypes();
		}
		return _xifexpression;
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
			case EcoreDocConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				return ((InternalEList<?>)getEAttributes()).basicRemove(otherEnd, msgs);
			case EcoreDocConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				return ((InternalEList<?>)getEContainments()).basicRemove(otherEnd, msgs);
			case EcoreDocConfigPackage.ECLASS_CONFIG__EREFERENCES:
				return ((InternalEList<?>)getEReferences()).basicRemove(otherEnd, msgs);
			case EcoreDocConfigPackage.ECLASS_CONFIG__EOPERATIONS:
				return ((InternalEList<?>)getEOperations()).basicRemove(otherEnd, msgs);
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
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER:
				return isRender();
			case EcoreDocConfigPackage.ECLASS_CONFIG__ID:
				return getId();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DIAGRAMS:
				return isRenderDiagrams();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES:
				return isRenderUseCases();
			case EcoreDocConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED:
				return isRepeatInherited();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUB_TYPES:
				return isRenderSubTypes();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUPER_TYPES:
				return isRenderSuperTypes();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS:
				return isRenderBounds();
			case EcoreDocConfigPackage.ECLASS_CONFIG__TARGET_ECLASS:
				if (resolve) return getTargetEClass();
				return basicGetTargetEClass();
			case EcoreDocConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				return getEAttributes();
			case EcoreDocConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				return getEContainments();
			case EcoreDocConfigPackage.ECLASS_CONFIG__EREFERENCES:
				return getEReferences();
			case EcoreDocConfigPackage.ECLASS_CONFIG__EOPERATIONS:
				return getEOperations();
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
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DIAGRAMS:
				setRenderDiagrams((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES:
				setRenderUseCases((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED:
				setRepeatInherited((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUB_TYPES:
				setRenderSubTypes((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUPER_TYPES:
				setRenderSuperTypes((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS:
				setRenderBounds((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__TARGET_ECLASS:
				setTargetEClass((EClass)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				getEAttributes().clear();
				getEAttributes().addAll((Collection<? extends EAttributeConfig>)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				getEContainments().clear();
				getEContainments().addAll((Collection<? extends EContainmentConfig>)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__EREFERENCES:
				getEReferences().clear();
				getEReferences().addAll((Collection<? extends EReferenceConfig>)newValue);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__EOPERATIONS:
				getEOperations().clear();
				getEOperations().addAll((Collection<? extends EOperationConfig>)newValue);
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
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER:
				unsetRender();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DIAGRAMS:
				unsetRenderDiagrams();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES:
				unsetRenderUseCases();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED:
				unsetRepeatInherited();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUB_TYPES:
				unsetRenderSubTypes();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUPER_TYPES:
				unsetRenderSuperTypes();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS:
				unsetRenderBounds();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__TARGET_ECLASS:
				setTargetEClass((EClass)null);
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				getEAttributes().clear();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				getEContainments().clear();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__EREFERENCES:
				getEReferences().clear();
				return;
			case EcoreDocConfigPackage.ECLASS_CONFIG__EOPERATIONS:
				getEOperations().clear();
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
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER:
				return isSetRender();
			case EcoreDocConfigPackage.ECLASS_CONFIG__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DIAGRAMS:
				return isSetRenderDiagrams();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_USE_CASES:
				return isSetRenderUseCases();
			case EcoreDocConfigPackage.ECLASS_CONFIG__REPEAT_INHERITED:
				return isSetRepeatInherited();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUB_TYPES:
				return isSetRenderSubTypes();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_SUPER_TYPES:
				return isSetRenderSuperTypes();
			case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS:
				return isSetRenderBounds();
			case EcoreDocConfigPackage.ECLASS_CONFIG__TARGET_ECLASS:
				return targetEClass != null;
			case EcoreDocConfigPackage.ECLASS_CONFIG__EATTRIBUTES:
				return eAttributes != null && !eAttributes.isEmpty();
			case EcoreDocConfigPackage.ECLASS_CONFIG__ECONTAINMENTS:
				return eContainments != null && !eContainments.isEmpty();
			case EcoreDocConfigPackage.ECLASS_CONFIG__EREFERENCES:
				return eReferences != null && !eReferences.isEmpty();
			case EcoreDocConfigPackage.ECLASS_CONFIG__EOPERATIONS:
				return eOperations != null && !eOperations.isEmpty();
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
				case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IDiagramConfig.class) {
			switch (derivedFeatureID) {
				case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DIAGRAMS: return EcoreDocConfigPackage.IDIAGRAM_CONFIG__RENDER_DIAGRAMS;
				default: return -1;
			}
		}
		if (baseClass == IETypedElementConfig.class) {
			switch (derivedFeatureID) {
				case EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS: return EcoreDocConfigPackage.IE_TYPED_ELEMENT_CONFIG__RENDER_BOUNDS;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == IEOperationConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEParameterConfig.class) {
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
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IDiagramConfig.class) {
			switch (baseFeatureID) {
				case EcoreDocConfigPackage.IDIAGRAM_CONFIG__RENDER_DIAGRAMS: return EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_DIAGRAMS;
				default: return -1;
			}
		}
		if (baseClass == IETypedElementConfig.class) {
			switch (baseFeatureID) {
				case EcoreDocConfigPackage.IE_TYPED_ELEMENT_CONFIG__RENDER_BOUNDS: return EcoreDocConfigPackage.ECLASS_CONFIG__RENDER_BOUNDS;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseFeatureID) {
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
		if (baseClass == IEOperationConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEParameterConfig.class) {
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
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS: return EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IDiagramConfig.class) {
			switch (baseOperationID) {
				case EcoreDocConfigPackage.IDIAGRAM_CONFIG___SHOULD_RENDER_DIAGRAMS: return EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_DIAGRAMS;
				default: return -1;
			}
		}
		if (baseClass == IETypedElementConfig.class) {
			switch (baseOperationID) {
				case EcoreDocConfigPackage.IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_BOUNDS: return EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_BOUNDS;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseOperationID) {
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
		if (baseClass == IEOperationConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEParameterConfig.class) {
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
			case EcoreDocConfigPackage.ECLASS_CONFIG___GET_TARGET:
				return getTarget();
			case EcoreDocConfigPackage.ECLASS_CONFIG___ADD_EATTRIBUTES__LIST:
				addEAttributes((List<EAttributeConfig>)arguments.get(0));
				return null;
			case EcoreDocConfigPackage.ECLASS_CONFIG___ADD_ECONTAINMENTS__LIST:
				addEContainments((List<EContainmentConfig>)arguments.get(0));
				return null;
			case EcoreDocConfigPackage.ECLASS_CONFIG___ADD_EREFERENCES__LIST:
				addEReferences((List<EReferenceConfig>)arguments.get(0));
				return null;
			case EcoreDocConfigPackage.ECLASS_CONFIG___ADD_EOPERATIONS__LIST:
				addEOperations((List<EOperationConfig>)arguments.get(0));
				return null;
			case EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_BOUNDS:
				return shouldRenderBounds();
			case EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_REPEAT_INHERITED:
				return shouldRepeatInherited();
			case EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_SUB_TYPES:
				return shouldRenderSubTypes();
			case EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_SUPER_TYPES:
				return shouldRenderSuperTypes();
			case EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_USE_CASES:
				return shouldRenderUseCases();
			case EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_DIAGRAMS:
				return shouldRenderDiagrams();
			case EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case EcoreDocConfigPackage.ECLASS_CONFIG___SHOULD_RENDER:
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
		result.append(", repeatInherited: ");
		if (repeatInheritedESet) result.append(repeatInherited); else result.append("<unset>");
		result.append(", renderSubTypes: ");
		if (renderSubTypesESet) result.append(renderSubTypes); else result.append("<unset>");
		result.append(", renderSuperTypes: ");
		if (renderSuperTypesESet) result.append(renderSuperTypes); else result.append("<unset>");
		result.append(", renderBounds: ");
		if (renderBoundsESet) result.append(renderBounds); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EClassConfigImpl
