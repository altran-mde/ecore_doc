/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig;
import com.altran.general.emf.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.lang.Iterable;
import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecore Doc Generator Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getPositionEDataTypes <em>Position EData Types</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getPositionEEnums <em>Position EEnums</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getPositionEClasses <em>Position EClasses</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRenderUseCases <em>Render Use Cases</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRepeatInherited <em>Repeat Inherited</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRenderSubTypes <em>Render Sub Types</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRenderSuperTypes <em>Render Super Types</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRenderBounds <em>Render Bounds</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getDocumentTitle <em>Document Title</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getEPackages <em>EPackages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EcoreDocGeneratorConfigImpl extends MinimalEObjectImpl.Container implements EcoreDocGeneratorConfig {
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
	 * The default value of the '{@link #getPositionEDataTypes() <em>Position EData Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionEDataTypes()
	 * @generated
	 * @ordered
	 */
	protected static final int POSITION_EDATA_TYPES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPositionEDataTypes() <em>Position EData Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionEDataTypes()
	 * @generated
	 * @ordered
	 */
	protected int positionEDataTypes = POSITION_EDATA_TYPES_EDEFAULT;

	/**
	 * This is true if the Position EData Types attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean positionEDataTypesESet;

	/**
	 * The default value of the '{@link #getPositionEEnums() <em>Position EEnums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionEEnums()
	 * @generated
	 * @ordered
	 */
	protected static final int POSITION_EENUMS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPositionEEnums() <em>Position EEnums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionEEnums()
	 * @generated
	 * @ordered
	 */
	protected int positionEEnums = POSITION_EENUMS_EDEFAULT;

	/**
	 * This is true if the Position EEnums attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean positionEEnumsESet;

	/**
	 * The default value of the '{@link #getPositionEClasses() <em>Position EClasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionEClasses()
	 * @generated
	 * @ordered
	 */
	protected static final int POSITION_ECLASSES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPositionEClasses() <em>Position EClasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionEClasses()
	 * @generated
	 * @ordered
	 */
	protected int positionEClasses = POSITION_ECLASSES_EDEFAULT;

	/**
	 * This is true if the Position EClasses attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean positionEClassesESet;

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
	 * The default value of the '{@link #getDocumentTitle() <em>Document Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENT_TITLE_EDEFAULT = "Ecore Documentation";

	/**
	 * The cached value of the '{@link #getDocumentTitle() <em>Document Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentTitle()
	 * @generated
	 * @ordered
	 */
	protected String documentTitle = DOCUMENT_TITLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEPackages() <em>EPackages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackageConfig> ePackages;

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
		return EcoreDocConfigPackage.Literals.ECORE_DOC_GENERATOR_CONFIG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER, oldRender, render, !oldRenderESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER, oldRender, RENDER_EDEFAULT, oldRenderESet));
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
	public int getPositionEDataTypes() {
		return positionEDataTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositionEDataTypes(int newPositionEDataTypes) {
		int oldPositionEDataTypes = positionEDataTypes;
		positionEDataTypes = newPositionEDataTypes;
		boolean oldPositionEDataTypesESet = positionEDataTypesESet;
		positionEDataTypesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EDATA_TYPES, oldPositionEDataTypes, positionEDataTypes, !oldPositionEDataTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPositionEDataTypes() {
		int oldPositionEDataTypes = positionEDataTypes;
		boolean oldPositionEDataTypesESet = positionEDataTypesESet;
		positionEDataTypes = POSITION_EDATA_TYPES_EDEFAULT;
		positionEDataTypesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EDATA_TYPES, oldPositionEDataTypes, POSITION_EDATA_TYPES_EDEFAULT, oldPositionEDataTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPositionEDataTypes() {
		return positionEDataTypesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPositionEEnums() {
		return positionEEnums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositionEEnums(int newPositionEEnums) {
		int oldPositionEEnums = positionEEnums;
		positionEEnums = newPositionEEnums;
		boolean oldPositionEEnumsESet = positionEEnumsESet;
		positionEEnumsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EENUMS, oldPositionEEnums, positionEEnums, !oldPositionEEnumsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPositionEEnums() {
		int oldPositionEEnums = positionEEnums;
		boolean oldPositionEEnumsESet = positionEEnumsESet;
		positionEEnums = POSITION_EENUMS_EDEFAULT;
		positionEEnumsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EENUMS, oldPositionEEnums, POSITION_EENUMS_EDEFAULT, oldPositionEEnumsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPositionEEnums() {
		return positionEEnumsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPositionEClasses() {
		return positionEClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositionEClasses(int newPositionEClasses) {
		int oldPositionEClasses = positionEClasses;
		positionEClasses = newPositionEClasses;
		boolean oldPositionEClassesESet = positionEClassesESet;
		positionEClassesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_ECLASSES, oldPositionEClasses, positionEClasses, !oldPositionEClassesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPositionEClasses() {
		int oldPositionEClasses = positionEClasses;
		boolean oldPositionEClassesESet = positionEClassesESet;
		positionEClasses = POSITION_ECLASSES_EDEFAULT;
		positionEClassesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_ECLASSES, oldPositionEClasses, POSITION_ECLASSES_EDEFAULT, oldPositionEClassesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPositionEClasses() {
		return positionEClassesESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, renderDefaults, !oldRenderDefaultsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, RENDER_DEFAULTS_EDEFAULT, oldRenderDefaultsESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES, oldRenderUseCases, renderUseCases, !oldRenderUseCasesESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES, oldRenderUseCases, RENDER_USE_CASES_EDEFAULT, oldRenderUseCasesESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED, oldRepeatInherited, repeatInherited, !oldRepeatInheritedESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED, oldRepeatInherited, REPEAT_INHERITED_EDEFAULT, oldRepeatInheritedESet));
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
	public boolean isRenderSubTypes() {
		return renderSubTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderSubTypes(boolean newRenderSubTypes) {
		boolean oldRenderSubTypes = renderSubTypes;
		renderSubTypes = newRenderSubTypes;
		boolean oldRenderSubTypesESet = renderSubTypesESet;
		renderSubTypesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUB_TYPES, oldRenderSubTypes, renderSubTypes, !oldRenderSubTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRenderSubTypes() {
		boolean oldRenderSubTypes = renderSubTypes;
		boolean oldRenderSubTypesESet = renderSubTypesESet;
		renderSubTypes = RENDER_SUB_TYPES_EDEFAULT;
		renderSubTypesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUB_TYPES, oldRenderSubTypes, RENDER_SUB_TYPES_EDEFAULT, oldRenderSubTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRenderSubTypes() {
		return renderSubTypesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRenderSuperTypes() {
		return renderSuperTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderSuperTypes(boolean newRenderSuperTypes) {
		boolean oldRenderSuperTypes = renderSuperTypes;
		renderSuperTypes = newRenderSuperTypes;
		boolean oldRenderSuperTypesESet = renderSuperTypesESet;
		renderSuperTypesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUPER_TYPES, oldRenderSuperTypes, renderSuperTypes, !oldRenderSuperTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRenderSuperTypes() {
		boolean oldRenderSuperTypes = renderSuperTypes;
		boolean oldRenderSuperTypesESet = renderSuperTypesESet;
		renderSuperTypes = RENDER_SUPER_TYPES_EDEFAULT;
		renderSuperTypesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUPER_TYPES, oldRenderSuperTypes, RENDER_SUPER_TYPES_EDEFAULT, oldRenderSuperTypesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRenderSuperTypes() {
		return renderSuperTypesESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_BOUNDS, oldRenderBounds, renderBounds, !oldRenderBoundsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_BOUNDS, oldRenderBounds, RENDER_BOUNDS_EDEFAULT, oldRenderBoundsESet));
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
	public String getDocumentTitle() {
		return documentTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentTitle(String newDocumentTitle) {
		String oldDocumentTitle = documentTitle;
		documentTitle = newDocumentTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__DOCUMENT_TITLE, oldDocumentTitle, documentTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackageConfig> getEPackages() {
		if (ePackages == null) {
			ePackages = new EObjectContainmentEList<EPackageConfig>(EPackageConfig.class, this, EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES);
		}
		return ePackages;
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
			_xifexpression = true;
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
			_xifexpression = true;
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
			_xifexpression = true;
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
			_xifexpression = true;
		}
		return _xifexpression;
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
			_xifexpression = this.shouldRenderDefaults();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEDataTypesPosition() {
		int _xifexpression = (int) 0;
		boolean _isSetPositionEDataTypes = this.isSetPositionEDataTypes();
		if (_isSetPositionEDataTypes) {
			_xifexpression = this.getPositionEDataTypes();
		}
		else {
			_xifexpression = 1;
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEEnumsPosition() {
		int _xifexpression = (int) 0;
		boolean _isSetPositionEEnums = this.isSetPositionEEnums();
		if (_isSetPositionEEnums) {
			_xifexpression = this.getPositionEEnums();
		}
		else {
			_xifexpression = 2;
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEClassesPosition() {
		int _xifexpression = (int) 0;
		boolean _isSetPositionEClasses = this.isSetPositionEClasses();
		if (_isSetPositionEClasses) {
			_xifexpression = this.getPositionEClasses();
		}
		else {
			_xifexpression = 3;
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addEPackages(final List<EPackageConfig> ePackageConfig) {
		EList<EPackageConfig> _ePackages = this.getEPackages();
		Iterables.<EPackageConfig>addAll(_ePackages, ePackageConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IENamedElementConfig findConfig(final ENamedElement element) {
		Iterable<? extends IENamedElementConfig> _switchResult = null;
		boolean _matched = false;
		if (element instanceof EPackage) {
			_matched=true;
			_switchResult = this.getEPackages();
		}
		if (!_matched) {
			if (element instanceof EEnum) {
				_matched=true;
				final Function1<EPackageConfig, EList<EEnumConfig>> _function = new Function1<EPackageConfig, EList<EEnumConfig>>() {
					public EList<EEnumConfig> apply(final EPackageConfig it) {
						return it.getEEnums();
					}
				};
				_switchResult = Iterables.<EEnumConfig>concat(XcoreEListExtensions.<EPackageConfig, EList<EEnumConfig>>map(this.getEPackages(), _function));
			}
		}
		if (!_matched) {
			if (element instanceof EDataType) {
				_matched=true;
				final Function1<EPackageConfig, EList<EDataTypeConfig>> _function = new Function1<EPackageConfig, EList<EDataTypeConfig>>() {
					public EList<EDataTypeConfig> apply(final EPackageConfig it) {
						return it.getEDataTypes();
					}
				};
				_switchResult = Iterables.<EDataTypeConfig>concat(XcoreEListExtensions.<EPackageConfig, EList<EDataTypeConfig>>map(this.getEPackages(), _function));
			}
		}
		if (!_matched) {
			if (element instanceof EEnumLiteral) {
				_matched=true;
				final Function1<EPackageConfig, EList<EEnumConfig>> _function = new Function1<EPackageConfig, EList<EEnumConfig>>() {
					public EList<EEnumConfig> apply(final EPackageConfig it) {
						return it.getEEnums();
					}
				};
				final Function1<EEnumConfig, EList<EEnumLiteralConfig>> _function_1 = new Function1<EEnumConfig, EList<EEnumLiteralConfig>>() {
					public EList<EEnumLiteralConfig> apply(final EEnumConfig it) {
						return it.getEEnumLiterals();
					}
				};
				_switchResult = Iterables.<EEnumLiteralConfig>concat(IterableExtensions.<EEnumConfig, EList<EEnumLiteralConfig>>map(Iterables.<EEnumConfig>concat(XcoreEListExtensions.<EPackageConfig, EList<EEnumConfig>>map(this.getEPackages(), _function)), _function_1));
			}
		}
		if (!_matched) {
			if (element instanceof EClass) {
				_matched=true;
				final Function1<EPackageConfig, EList<EClassConfig>> _function = new Function1<EPackageConfig, EList<EClassConfig>>() {
					public EList<EClassConfig> apply(final EPackageConfig it) {
						return it.getEClasses();
					}
				};
				_switchResult = Iterables.<EClassConfig>concat(XcoreEListExtensions.<EPackageConfig, EList<EClassConfig>>map(this.getEPackages(), _function));
			}
		}
		if (!_matched) {
			if (element instanceof EAttribute) {
				_matched=true;
				final Function1<EPackageConfig, EList<EClassConfig>> _function = new Function1<EPackageConfig, EList<EClassConfig>>() {
					public EList<EClassConfig> apply(final EPackageConfig it) {
						return it.getEClasses();
					}
				};
				final Function1<EClassConfig, EList<EAttributeConfig>> _function_1 = new Function1<EClassConfig, EList<EAttributeConfig>>() {
					public EList<EAttributeConfig> apply(final EClassConfig it) {
						return it.getEAttributes();
					}
				};
				_switchResult = Iterables.<EAttributeConfig>concat(IterableExtensions.<EClassConfig, EList<EAttributeConfig>>map(Iterables.<EClassConfig>concat(XcoreEListExtensions.<EPackageConfig, EList<EClassConfig>>map(this.getEPackages(), _function)), _function_1));
			}
		}
		if (!_matched) {
			if (element instanceof EReference) {
				boolean _isContainment = ((EReference)element).isContainment();
				if (_isContainment) {
					_matched=true;
					final Function1<EPackageConfig, EList<EClassConfig>> _function = new Function1<EPackageConfig, EList<EClassConfig>>() {
						public EList<EClassConfig> apply(final EPackageConfig it) {
							return it.getEClasses();
						}
					};
					final Function1<EClassConfig, EList<EContainmentConfig>> _function_1 = new Function1<EClassConfig, EList<EContainmentConfig>>() {
						public EList<EContainmentConfig> apply(final EClassConfig it) {
							return it.getEContainments();
						}
					};
					_switchResult = Iterables.<EContainmentConfig>concat(IterableExtensions.<EClassConfig, EList<EContainmentConfig>>map(Iterables.<EClassConfig>concat(XcoreEListExtensions.<EPackageConfig, EList<EClassConfig>>map(this.getEPackages(), _function)), _function_1));
				}
			}
		}
		if (!_matched) {
			if (element instanceof EReference) {
				boolean _isContainment = ((EReference)element).isContainment();
				boolean _not = (!_isContainment);
				if (_not) {
					_matched=true;
					final Function1<EPackageConfig, EList<EClassConfig>> _function = new Function1<EPackageConfig, EList<EClassConfig>>() {
						public EList<EClassConfig> apply(final EPackageConfig it) {
							return it.getEClasses();
						}
					};
					final Function1<EClassConfig, EList<EReferenceConfig>> _function_1 = new Function1<EClassConfig, EList<EReferenceConfig>>() {
						public EList<EReferenceConfig> apply(final EClassConfig it) {
							return it.getEReferences();
						}
					};
					_switchResult = Iterables.<EReferenceConfig>concat(IterableExtensions.<EClassConfig, EList<EReferenceConfig>>map(Iterables.<EClassConfig>concat(XcoreEListExtensions.<EPackageConfig, EList<EClassConfig>>map(this.getEPackages(), _function)), _function_1));
				}
			}
		}
		final Function1<IENamedElementConfig, Boolean> _function = new Function1<IENamedElementConfig, Boolean>() {
			public Boolean apply(final IENamedElementConfig it) {
				ENamedElement _target = it.getTarget();
				return Boolean.valueOf(Objects.equal(_target, element));
			}
		};
		return IterableExtensions.findFirst(_switchResult, _function);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENamedElement getTarget() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean shouldRenderSubTypes() {
		boolean _xifexpression = false;
		boolean _isSetRenderSubTypes = this.isSetRenderSubTypes();
		if (_isSetRenderSubTypes) {
			_xifexpression = this.isRenderSubTypes();
		}
		else {
			_xifexpression = true;
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean shouldRenderSuperTypes() {
		boolean _xifexpression = false;
		boolean _isSetRenderSuperTypes = this.isSetRenderSuperTypes();
		if (_isSetRenderSuperTypes) {
			_xifexpression = this.isRenderSuperTypes();
		}
		else {
			_xifexpression = true;
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
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				return ((InternalEList<?>)getEPackages()).basicRemove(otherEnd, msgs);
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
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				return isRender();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ID:
				return getId();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EDATA_TYPES:
				return getPositionEDataTypes();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EENUMS:
				return getPositionEEnums();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_ECLASSES:
				return getPositionEClasses();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES:
				return isRenderUseCases();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED:
				return isRepeatInherited();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUB_TYPES:
				return isRenderSubTypes();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUPER_TYPES:
				return isRenderSuperTypes();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_BOUNDS:
				return isRenderBounds();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__DOCUMENT_TITLE:
				return getDocumentTitle();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				return getEPackages();
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
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EDATA_TYPES:
				setPositionEDataTypes((Integer)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EENUMS:
				setPositionEEnums((Integer)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_ECLASSES:
				setPositionEClasses((Integer)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES:
				setRenderUseCases((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED:
				setRepeatInherited((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUB_TYPES:
				setRenderSubTypes((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUPER_TYPES:
				setRenderSuperTypes((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_BOUNDS:
				setRenderBounds((Boolean)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__DOCUMENT_TITLE:
				setDocumentTitle((String)newValue);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				getEPackages().clear();
				getEPackages().addAll((Collection<? extends EPackageConfig>)newValue);
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
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				unsetRender();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EDATA_TYPES:
				unsetPositionEDataTypes();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EENUMS:
				unsetPositionEEnums();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_ECLASSES:
				unsetPositionEClasses();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES:
				unsetRenderUseCases();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED:
				unsetRepeatInherited();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUB_TYPES:
				unsetRenderSubTypes();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUPER_TYPES:
				unsetRenderSuperTypes();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_BOUNDS:
				unsetRenderBounds();
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__DOCUMENT_TITLE:
				setDocumentTitle(DOCUMENT_TITLE_EDEFAULT);
				return;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				getEPackages().clear();
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
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				return isSetRender();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EDATA_TYPES:
				return isSetPositionEDataTypes();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_EENUMS:
				return isSetPositionEEnums();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__POSITION_ECLASSES:
				return isSetPositionEClasses();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES:
				return isSetRenderUseCases();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED:
				return isSetRepeatInherited();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUB_TYPES:
				return isSetRenderSubTypes();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUPER_TYPES:
				return isSetRenderSuperTypes();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_BOUNDS:
				return isSetRenderBounds();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__DOCUMENT_TITLE:
				return DOCUMENT_TITLE_EDEFAULT == null ? documentTitle != null : !DOCUMENT_TITLE_EDEFAULT.equals(documentTitle);
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				return ePackages != null && !ePackages.isEmpty();
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
				case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEClassifierConfig.class) {
			switch (derivedFeatureID) {
				case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES: return EcoreDocConfigPackage.IE_CLASSIFIER_CONFIG__RENDER_USE_CASES;
				default: return -1;
			}
		}
		if (baseClass == IEDataTypeConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumLiteralConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEClassConfig.class) {
			switch (derivedFeatureID) {
				case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED: return EcoreDocConfigPackage.IE_CLASS_CONFIG__REPEAT_INHERITED;
				case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUB_TYPES: return EcoreDocConfigPackage.IE_CLASS_CONFIG__RENDER_SUB_TYPES;
				case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUPER_TYPES: return EcoreDocConfigPackage.IE_CLASS_CONFIG__RENDER_SUPER_TYPES;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (derivedFeatureID) {
				case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_BOUNDS: return EcoreDocConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG__RENDER_BOUNDS;
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
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEClassifierConfig.class) {
			switch (baseFeatureID) {
				case EcoreDocConfigPackage.IE_CLASSIFIER_CONFIG__RENDER_USE_CASES: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES;
				default: return -1;
			}
		}
		if (baseClass == IEDataTypeConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumLiteralConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEClassConfig.class) {
			switch (baseFeatureID) {
				case EcoreDocConfigPackage.IE_CLASS_CONFIG__REPEAT_INHERITED: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED;
				case EcoreDocConfigPackage.IE_CLASS_CONFIG__RENDER_SUB_TYPES: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUB_TYPES;
				case EcoreDocConfigPackage.IE_CLASS_CONFIG__RENDER_SUPER_TYPES: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_SUPER_TYPES;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseFeatureID) {
				case EcoreDocConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG__RENDER_BOUNDS: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_BOUNDS;
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
				case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEClassifierConfig.class) {
			switch (baseOperationID) {
				case EcoreDocConfigPackage.IE_CLASSIFIER_CONFIG___SHOULD_RENDER_USE_CASES: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_USE_CASES;
				default: return -1;
			}
		}
		if (baseClass == IEDataTypeConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumLiteralConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEClassConfig.class) {
			switch (baseOperationID) {
				case EcoreDocConfigPackage.IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_REPEAT_INHERITED;
				case EcoreDocConfigPackage.IE_CLASS_CONFIG___SHOULD_RENDER_SUB_TYPES: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUB_TYPES;
				case EcoreDocConfigPackage.IE_CLASS_CONFIG___SHOULD_RENDER_SUPER_TYPES: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUPER_TYPES;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseOperationID) {
				case EcoreDocConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_BOUNDS: return EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_BOUNDS;
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
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER:
				return shouldRender();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_USE_CASES:
				return shouldRenderUseCases();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_REPEAT_INHERITED:
				return shouldRepeatInherited();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUB_TYPES:
				return shouldRenderSubTypes();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUPER_TYPES:
				return shouldRenderSuperTypes();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_BOUNDS:
				return shouldRenderBounds();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___GET_EDATA_TYPES_POSITION:
				return getEDataTypesPosition();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___GET_EENUMS_POSITION:
				return getEEnumsPosition();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___GET_ECLASSES_POSITION:
				return getEClassesPosition();
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___ADD_EPACKAGES__LIST:
				addEPackages((List<EPackageConfig>)arguments.get(0));
				return null;
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___FIND_CONFIG__ENAMEDELEMENT:
				return findConfig((ENamedElement)arguments.get(0));
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG___GET_TARGET:
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
		result.append(", positionEDataTypes: ");
		if (positionEDataTypesESet) result.append(positionEDataTypes); else result.append("<unset>");
		result.append(", positionEEnums: ");
		if (positionEEnumsESet) result.append(positionEEnums); else result.append("<unset>");
		result.append(", positionEClasses: ");
		if (positionEClassesESet) result.append(positionEClasses); else result.append("<unset>");
		result.append(", renderDefaults: ");
		if (renderDefaultsESet) result.append(renderDefaults); else result.append("<unset>");
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
		result.append(", documentTitle: ");
		result.append(documentTitle);
		result.append(')');
		return result.toString();
	}

} //EcoreDocGeneratorConfigImpl
