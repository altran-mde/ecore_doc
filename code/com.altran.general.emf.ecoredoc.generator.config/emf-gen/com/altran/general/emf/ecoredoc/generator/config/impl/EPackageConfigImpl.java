/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.ConfigPackage;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.emf.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig;
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
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#getPositionEDataTypes <em>Position EData Types</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#getPositionEEnums <em>Position EEnums</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#getPositionEClasses <em>Position EClasses</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#isRenderUseCases <em>Render Use Cases</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#isRepeatInherited <em>Repeat Inherited</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#isRenderBounds <em>Render Bounds</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#getTargetEPackage <em>Target EPackage</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#getEDataTypes <em>EData Types</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#getEEnums <em>EEnums</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl#getEClasses <em>EClasses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EPackageConfigImpl extends MinimalEObjectImpl.Container implements EPackageConfig {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EPACKAGE_CONFIG__POSITION_EDATA_TYPES, oldPositionEDataTypes, positionEDataTypes, !oldPositionEDataTypesESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.EPACKAGE_CONFIG__POSITION_EDATA_TYPES, oldPositionEDataTypes, POSITION_EDATA_TYPES_EDEFAULT, oldPositionEDataTypesESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EPACKAGE_CONFIG__POSITION_EENUMS, oldPositionEEnums, positionEEnums, !oldPositionEEnumsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.EPACKAGE_CONFIG__POSITION_EENUMS, oldPositionEEnums, POSITION_EENUMS_EDEFAULT, oldPositionEEnumsESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EPACKAGE_CONFIG__POSITION_ECLASSES, oldPositionEClasses, positionEClasses, !oldPositionEClassesESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.EPACKAGE_CONFIG__POSITION_ECLASSES, oldPositionEClasses, POSITION_ECLASSES_EDEFAULT, oldPositionEClassesESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EPACKAGE_CONFIG__RENDER_USE_CASES, oldRenderUseCases, renderUseCases, !oldRenderUseCasesESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.EPACKAGE_CONFIG__RENDER_USE_CASES, oldRenderUseCases, RENDER_USE_CASES_EDEFAULT, oldRenderUseCasesESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EPACKAGE_CONFIG__REPEAT_INHERITED, oldRepeatInherited, repeatInherited, !oldRepeatInheritedESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.EPACKAGE_CONFIG__REPEAT_INHERITED, oldRepeatInherited, REPEAT_INHERITED_EDEFAULT, oldRepeatInheritedESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EPACKAGE_CONFIG__RENDER_BOUNDS, oldRenderBounds, renderBounds, !oldRenderBoundsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.EPACKAGE_CONFIG__RENDER_BOUNDS, oldRenderBounds, RENDER_BOUNDS_EDEFAULT, oldRenderBoundsESet));
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
	public void addEDataTypes(final List<EDataTypeConfig> eDataTypeConfig) {
		EList<EDataTypeConfig> _eDataTypes = this.getEDataTypes();
		Iterables.<EDataTypeConfig>addAll(_eDataTypes, eDataTypeConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addEEnums(final List<EEnumConfig> eEnumConfig) {
		EList<EEnumConfig> _eEnums = this.getEEnums();
		Iterables.<EEnumConfig>addAll(_eEnums, eEnumConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addEClasses(final List<EClassConfig> eClassConfig) {
		EList<EClassConfig> _eClasses = this.getEClasses();
		Iterables.<EClassConfig>addAll(_eClasses, eClassConfig);
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
	public int getEDataTypesPosition() {
		int _xifexpression = (int) 0;
		boolean _isSetPositionEDataTypes = this.isSetPositionEDataTypes();
		if (_isSetPositionEDataTypes) {
			_xifexpression = this.getPositionEDataTypes();
		}
		else {
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEPackageConfig) _eContainer).getEDataTypesPosition();
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
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEPackageConfig) _eContainer).getEEnumsPosition();
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
			EObject _eContainer = this.eContainer();
			_xifexpression = ((IEPackageConfig) _eContainer).getEClassesPosition();
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
			case ConfigPackage.EPACKAGE_CONFIG__RENDER:
				return isRender();
			case ConfigPackage.EPACKAGE_CONFIG__ID:
				return getId();
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_EDATA_TYPES:
				return getPositionEDataTypes();
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_EENUMS:
				return getPositionEEnums();
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_ECLASSES:
				return getPositionEClasses();
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_USE_CASES:
				return isRenderUseCases();
			case ConfigPackage.EPACKAGE_CONFIG__REPEAT_INHERITED:
				return isRepeatInherited();
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_BOUNDS:
				return isRenderBounds();
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
			case ConfigPackage.EPACKAGE_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_EDATA_TYPES:
				setPositionEDataTypes((Integer)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_EENUMS:
				setPositionEEnums((Integer)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_ECLASSES:
				setPositionEClasses((Integer)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_USE_CASES:
				setRenderUseCases((Boolean)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__REPEAT_INHERITED:
				setRepeatInherited((Boolean)newValue);
				return;
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_BOUNDS:
				setRenderBounds((Boolean)newValue);
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
			case ConfigPackage.EPACKAGE_CONFIG__RENDER:
				unsetRender();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_EDATA_TYPES:
				unsetPositionEDataTypes();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_EENUMS:
				unsetPositionEEnums();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_ECLASSES:
				unsetPositionEClasses();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_USE_CASES:
				unsetRenderUseCases();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__REPEAT_INHERITED:
				unsetRepeatInherited();
				return;
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_BOUNDS:
				unsetRenderBounds();
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
			case ConfigPackage.EPACKAGE_CONFIG__RENDER:
				return isSetRender();
			case ConfigPackage.EPACKAGE_CONFIG__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_EDATA_TYPES:
				return isSetPositionEDataTypes();
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_EENUMS:
				return isSetPositionEEnums();
			case ConfigPackage.EPACKAGE_CONFIG__POSITION_ECLASSES:
				return isSetPositionEClasses();
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_USE_CASES:
				return isSetRenderUseCases();
			case ConfigPackage.EPACKAGE_CONFIG__REPEAT_INHERITED:
				return isSetRepeatInherited();
			case ConfigPackage.EPACKAGE_CONFIG__RENDER_BOUNDS:
				return isSetRenderBounds();
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IDefaultValueConfig.class) {
			switch (derivedFeatureID) {
				case ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS: return ConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEClassifierConfig.class) {
			switch (derivedFeatureID) {
				case ConfigPackage.EPACKAGE_CONFIG__RENDER_USE_CASES: return ConfigPackage.IE_CLASSIFIER_CONFIG__RENDER_USE_CASES;
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
				case ConfigPackage.EPACKAGE_CONFIG__REPEAT_INHERITED: return ConfigPackage.IE_CLASS_CONFIG__REPEAT_INHERITED;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (derivedFeatureID) {
				case ConfigPackage.EPACKAGE_CONFIG__RENDER_BOUNDS: return ConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG__RENDER_BOUNDS;
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
				case ConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS: return ConfigPackage.EPACKAGE_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEClassifierConfig.class) {
			switch (baseFeatureID) {
				case ConfigPackage.IE_CLASSIFIER_CONFIG__RENDER_USE_CASES: return ConfigPackage.EPACKAGE_CONFIG__RENDER_USE_CASES;
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
				case ConfigPackage.IE_CLASS_CONFIG__REPEAT_INHERITED: return ConfigPackage.EPACKAGE_CONFIG__REPEAT_INHERITED;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseFeatureID) {
				case ConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG__RENDER_BOUNDS: return ConfigPackage.EPACKAGE_CONFIG__RENDER_BOUNDS;
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
				case ConfigPackage.IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS: return ConfigPackage.EPACKAGE_CONFIG___SHOULD_RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEClassifierConfig.class) {
			switch (baseOperationID) {
				case ConfigPackage.IE_CLASSIFIER_CONFIG___SHOULD_RENDER_USE_CASES: return ConfigPackage.EPACKAGE_CONFIG___SHOULD_RENDER_USE_CASES;
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
				case ConfigPackage.IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED: return ConfigPackage.EPACKAGE_CONFIG___SHOULD_REPEAT_INHERITED;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseOperationID) {
				case ConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_BOUNDS: return ConfigPackage.EPACKAGE_CONFIG___SHOULD_RENDER_BOUNDS;
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
			case ConfigPackage.EPACKAGE_CONFIG___GET_TARGET:
				return getTarget();
			case ConfigPackage.EPACKAGE_CONFIG___ADD_EDATA_TYPES__LIST:
				addEDataTypes((List<EDataTypeConfig>)arguments.get(0));
				return null;
			case ConfigPackage.EPACKAGE_CONFIG___ADD_EENUMS__LIST:
				addEEnums((List<EEnumConfig>)arguments.get(0));
				return null;
			case ConfigPackage.EPACKAGE_CONFIG___ADD_ECLASSES__LIST:
				addEClasses((List<EClassConfig>)arguments.get(0));
				return null;
			case ConfigPackage.EPACKAGE_CONFIG___SHOULD_RENDER_BOUNDS:
				return shouldRenderBounds();
			case ConfigPackage.EPACKAGE_CONFIG___SHOULD_REPEAT_INHERITED:
				return shouldRepeatInherited();
			case ConfigPackage.EPACKAGE_CONFIG___SHOULD_RENDER_USE_CASES:
				return shouldRenderUseCases();
			case ConfigPackage.EPACKAGE_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case ConfigPackage.EPACKAGE_CONFIG___GET_EDATA_TYPES_POSITION:
				return getEDataTypesPosition();
			case ConfigPackage.EPACKAGE_CONFIG___GET_EENUMS_POSITION:
				return getEEnumsPosition();
			case ConfigPackage.EPACKAGE_CONFIG___GET_ECLASSES_POSITION:
				return getEClassesPosition();
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
		result.append(", renderBounds: ");
		if (renderBoundsESet) result.append(renderBounds); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EPackageConfigImpl
