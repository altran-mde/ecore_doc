/**
 */
package com.altran.general.ecoredoc.generator.config.impl;

import com.altran.general.ecoredoc.generator.config.AEReferenceConfig;
import com.altran.general.ecoredoc.generator.config.AEStructuralFeatureConfig;
import com.altran.general.ecoredoc.generator.config.ConfigFactory;
import com.altran.general.ecoredoc.generator.config.ConfigPackage;
import com.altran.general.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.ecoredoc.generator.config.EClassConfig;
import com.altran.general.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig;
import com.altran.general.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.ecoredoc.generator.config.IEClassConfig;
import com.altran.general.ecoredoc.generator.config.IEDataTypeConfig;
import com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig;
import com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigPackageImpl extends EPackageImpl implements ConfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEcoreDocGeneratorConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecoreDocGeneratorConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePackageConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEcoreDocGeneratorPartConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieDataTypeConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDataTypeConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEnumConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEnumLiteralConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieClassConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClassConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aeStructuralFeatureConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aeReferenceConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAttributeConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eContainmentConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eReferenceConfigEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConfigPackageImpl() {
		super(eNS_URI, ConfigFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ConfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConfigPackage init() {
		if (isInited) return (ConfigPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigPackage.eNS_URI);

		// Obtain or create and register package
		ConfigPackageImpl theConfigPackage = (ConfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConfigPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theConfigPackage.createPackageContents();

		// Initialize created meta-data
		theConfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConfigPackage.eNS_URI, theConfigPackage);
		return theConfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEcoreDocGeneratorConfig() {
		return iEcoreDocGeneratorConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEcoreDocGeneratorConfig_RenderDefaults() {
		return (EAttribute)iEcoreDocGeneratorConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEcoreDocGeneratorConfig_Render() {
		return (EAttribute)iEcoreDocGeneratorConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIEcoreDocGeneratorConfig__ShouldRenderDefaults() {
		return iEcoreDocGeneratorConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIEcoreDocGeneratorConfig__ShouldRender() {
		return iEcoreDocGeneratorConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIEcoreDocGeneratorConfig__GetTarget() {
		return iEcoreDocGeneratorConfigEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcoreDocGeneratorConfig() {
		return ecoreDocGeneratorConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcoreDocGeneratorConfig_EPackages() {
		return (EReference)ecoreDocGeneratorConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__ShouldRenderDefaults() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__ShouldRender() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__FindConfig__ENamedElement() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__GetTarget() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPackageConfig() {
		return ePackageConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEPackageConfig_TargetEPackage() {
		return (EReference)ePackageConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEPackageConfig_EDataTypes() {
		return (EReference)ePackageConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEPackageConfig_EEnums() {
		return (EReference)ePackageConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEPackageConfig_EClasses() {
		return (EReference)ePackageConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEPackageConfig__GetTarget() {
		return ePackageConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEcoreDocGeneratorPartConfig() {
		return iEcoreDocGeneratorPartConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEcoreDocGeneratorPartConfig_Position() {
		return (EAttribute)iEcoreDocGeneratorPartConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEDataTypeConfig() {
		return ieDataTypeConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDataTypeConfig() {
		return eDataTypeConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDataTypeConfig_TargetEDataType() {
		return (EReference)eDataTypeConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEDataTypeConfig__GetTarget() {
		return eDataTypeConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEDataTypeConfig__GetPosition() {
		return eDataTypeConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEEnumConfig() {
		return eEnumConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEnumConfig_TargetEEnum() {
		return (EReference)eEnumConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEnumConfig_EEnumLiterals() {
		return (EReference)eEnumConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEEnumConfig__GetTarget() {
		return eEnumConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEEnumConfig__GetPosition() {
		return eEnumConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEEnumLiteralConfig() {
		return eEnumLiteralConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEnumLiteralConfig_TargetEEnumLiteral() {
		return (EReference)eEnumLiteralConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEEnumLiteralConfig__GetTarget() {
		return eEnumLiteralConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEClassConfig() {
		return ieClassConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEClassConfig_RepeatInherited() {
		return (EAttribute)ieClassConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIEClassConfig__ShouldRepeatInherited() {
		return ieClassConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClassConfig() {
		return eClassConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassConfig_TargetEClass() {
		return (EReference)eClassConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassConfig_EAttributes() {
		return (EReference)eClassConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassConfig_EContainments() {
		return (EReference)eClassConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassConfig_EReferences() {
		return (EReference)eClassConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEClassConfig__GetTarget() {
		return eClassConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEClassConfig__GetPosition() {
		return eClassConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEClassConfig__ShouldRepeatInherited() {
		return eClassConfigEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAEStructuralFeatureConfig() {
		return aeStructuralFeatureConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAEReferenceConfig() {
		return aeReferenceConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAttributeConfig() {
		return eAttributeConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAttributeConfig_TargetEAttribute() {
		return (EReference)eAttributeConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEAttributeConfig__GetTarget() {
		return eAttributeConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEContainmentConfig() {
		return eContainmentConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEContainmentConfig_TargetEContainment() {
		return (EReference)eContainmentConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEContainmentConfig__GetTarget() {
		return eContainmentConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEReferenceConfig() {
		return eReferenceConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReferenceConfig_TargetEReference() {
		return (EReference)eReferenceConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEReferenceConfig__GetTarget() {
		return eReferenceConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigFactory getConfigFactory() {
		return (ConfigFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		iEcoreDocGeneratorConfigEClass = createEClass(IECORE_DOC_GENERATOR_CONFIG);
		createEAttribute(iEcoreDocGeneratorConfigEClass, IECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS);
		createEAttribute(iEcoreDocGeneratorConfigEClass, IECORE_DOC_GENERATOR_CONFIG__RENDER);
		createEOperation(iEcoreDocGeneratorConfigEClass, IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS);
		createEOperation(iEcoreDocGeneratorConfigEClass, IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER);
		createEOperation(iEcoreDocGeneratorConfigEClass, IECORE_DOC_GENERATOR_CONFIG___GET_TARGET);

		ecoreDocGeneratorConfigEClass = createEClass(ECORE_DOC_GENERATOR_CONFIG);
		createEReference(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG__EPACKAGES);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___FIND_CONFIG__ENAMEDELEMENT);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___GET_TARGET);

		ePackageConfigEClass = createEClass(EPACKAGE_CONFIG);
		createEReference(ePackageConfigEClass, EPACKAGE_CONFIG__TARGET_EPACKAGE);
		createEReference(ePackageConfigEClass, EPACKAGE_CONFIG__EDATA_TYPES);
		createEReference(ePackageConfigEClass, EPACKAGE_CONFIG__EENUMS);
		createEReference(ePackageConfigEClass, EPACKAGE_CONFIG__ECLASSES);
		createEOperation(ePackageConfigEClass, EPACKAGE_CONFIG___GET_TARGET);

		iEcoreDocGeneratorPartConfigEClass = createEClass(IECORE_DOC_GENERATOR_PART_CONFIG);
		createEAttribute(iEcoreDocGeneratorPartConfigEClass, IECORE_DOC_GENERATOR_PART_CONFIG__POSITION);

		ieDataTypeConfigEClass = createEClass(IE_DATA_TYPE_CONFIG);

		eDataTypeConfigEClass = createEClass(EDATA_TYPE_CONFIG);
		createEReference(eDataTypeConfigEClass, EDATA_TYPE_CONFIG__TARGET_EDATA_TYPE);
		createEOperation(eDataTypeConfigEClass, EDATA_TYPE_CONFIG___GET_TARGET);
		createEOperation(eDataTypeConfigEClass, EDATA_TYPE_CONFIG___GET_POSITION);

		eEnumConfigEClass = createEClass(EENUM_CONFIG);
		createEReference(eEnumConfigEClass, EENUM_CONFIG__TARGET_EENUM);
		createEReference(eEnumConfigEClass, EENUM_CONFIG__EENUM_LITERALS);
		createEOperation(eEnumConfigEClass, EENUM_CONFIG___GET_TARGET);
		createEOperation(eEnumConfigEClass, EENUM_CONFIG___GET_POSITION);

		eEnumLiteralConfigEClass = createEClass(EENUM_LITERAL_CONFIG);
		createEReference(eEnumLiteralConfigEClass, EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL);
		createEOperation(eEnumLiteralConfigEClass, EENUM_LITERAL_CONFIG___GET_TARGET);

		ieClassConfigEClass = createEClass(IE_CLASS_CONFIG);
		createEAttribute(ieClassConfigEClass, IE_CLASS_CONFIG__REPEAT_INHERITED);
		createEOperation(ieClassConfigEClass, IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED);

		eClassConfigEClass = createEClass(ECLASS_CONFIG);
		createEReference(eClassConfigEClass, ECLASS_CONFIG__TARGET_ECLASS);
		createEReference(eClassConfigEClass, ECLASS_CONFIG__EATTRIBUTES);
		createEReference(eClassConfigEClass, ECLASS_CONFIG__ECONTAINMENTS);
		createEReference(eClassConfigEClass, ECLASS_CONFIG__EREFERENCES);
		createEOperation(eClassConfigEClass, ECLASS_CONFIG___GET_TARGET);
		createEOperation(eClassConfigEClass, ECLASS_CONFIG___GET_POSITION);
		createEOperation(eClassConfigEClass, ECLASS_CONFIG___SHOULD_REPEAT_INHERITED);

		aeStructuralFeatureConfigEClass = createEClass(AE_STRUCTURAL_FEATURE_CONFIG);

		eAttributeConfigEClass = createEClass(EATTRIBUTE_CONFIG);
		createEReference(eAttributeConfigEClass, EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE);
		createEOperation(eAttributeConfigEClass, EATTRIBUTE_CONFIG___GET_TARGET);

		aeReferenceConfigEClass = createEClass(AE_REFERENCE_CONFIG);

		eContainmentConfigEClass = createEClass(ECONTAINMENT_CONFIG);
		createEReference(eContainmentConfigEClass, ECONTAINMENT_CONFIG__TARGET_ECONTAINMENT);
		createEOperation(eContainmentConfigEClass, ECONTAINMENT_CONFIG___GET_TARGET);

		eReferenceConfigEClass = createEClass(EREFERENCE_CONFIG);
		createEReference(eReferenceConfigEClass, EREFERENCE_CONFIG__TARGET_EREFERENCE);
		createEOperation(eReferenceConfigEClass, EREFERENCE_CONFIG___GET_TARGET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ecoreDocGeneratorConfigEClass.getESuperTypes().add(this.getIEcoreDocGeneratorConfig());
		ePackageConfigEClass.getESuperTypes().add(this.getIEcoreDocGeneratorConfig());
		iEcoreDocGeneratorPartConfigEClass.getESuperTypes().add(this.getIEcoreDocGeneratorConfig());
		ieDataTypeConfigEClass.getESuperTypes().add(this.getIEcoreDocGeneratorPartConfig());
		eDataTypeConfigEClass.getESuperTypes().add(this.getIEDataTypeConfig());
		eEnumConfigEClass.getESuperTypes().add(this.getIEDataTypeConfig());
		eEnumLiteralConfigEClass.getESuperTypes().add(this.getIEcoreDocGeneratorConfig());
		ieClassConfigEClass.getESuperTypes().add(this.getIEcoreDocGeneratorConfig());
		eClassConfigEClass.getESuperTypes().add(this.getIEcoreDocGeneratorPartConfig());
		eClassConfigEClass.getESuperTypes().add(this.getIEClassConfig());
		aeStructuralFeatureConfigEClass.getESuperTypes().add(this.getIEClassConfig());
		eAttributeConfigEClass.getESuperTypes().add(this.getAEStructuralFeatureConfig());
		aeReferenceConfigEClass.getESuperTypes().add(this.getAEStructuralFeatureConfig());
		eContainmentConfigEClass.getESuperTypes().add(this.getAEReferenceConfig());
		eReferenceConfigEClass.getESuperTypes().add(this.getAEReferenceConfig());

		// Initialize classes, features, and operations; add parameters
		initEClass(iEcoreDocGeneratorConfigEClass, IEcoreDocGeneratorConfig.class, "IEcoreDocGeneratorConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIEcoreDocGeneratorConfig_RenderDefaults(), theEcorePackage.getEBoolean(), "renderDefaults", null, 0, 1, IEcoreDocGeneratorConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIEcoreDocGeneratorConfig_Render(), theEcorePackage.getEBoolean(), "render", null, 0, 1, IEcoreDocGeneratorConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIEcoreDocGeneratorConfig__ShouldRenderDefaults(), theEcorePackage.getEBoolean(), "shouldRenderDefaults", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getIEcoreDocGeneratorConfig__ShouldRender(), theEcorePackage.getEBoolean(), "shouldRender", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getIEcoreDocGeneratorConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ecoreDocGeneratorConfigEClass, EcoreDocGeneratorConfig.class, "EcoreDocGeneratorConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEcoreDocGeneratorConfig_EPackages(), this.getEPackageConfig(), null, "ePackages", null, 0, -1, EcoreDocGeneratorConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__ShouldRenderDefaults(), theEcorePackage.getEBoolean(), "shouldRenderDefaults", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__ShouldRender(), theEcorePackage.getEBoolean(), "shouldRender", 0, 1, !IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getEcoreDocGeneratorConfig__FindConfig__ENamedElement(), this.getIEcoreDocGeneratorConfig(), "findConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getENamedElement(), "element", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ePackageConfigEClass, EPackageConfig.class, "EPackageConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEPackageConfig_TargetEPackage(), theEcorePackage.getEPackage(), null, "targetEPackage", null, 0, 1, EPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPackageConfig_EDataTypes(), this.getEDataTypeConfig(), null, "eDataTypes", null, 0, -1, EPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPackageConfig_EEnums(), this.getEEnumConfig(), null, "eEnums", null, 0, -1, EPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPackageConfig_EClasses(), this.getEClassConfig(), null, "eClasses", null, 0, -1, EPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEPackageConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(iEcoreDocGeneratorPartConfigEClass, IEcoreDocGeneratorPartConfig.class, "IEcoreDocGeneratorPartConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIEcoreDocGeneratorPartConfig_Position(), theEcorePackage.getEInt(), "position", null, 0, 1, IEcoreDocGeneratorPartConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ieDataTypeConfigEClass, IEDataTypeConfig.class, "IEDataTypeConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eDataTypeConfigEClass, EDataTypeConfig.class, "EDataTypeConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDataTypeConfig_TargetEDataType(), theEcorePackage.getEDataType(), null, "targetEDataType", null, 0, 1, EDataTypeConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEDataTypeConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEDataTypeConfig__GetPosition(), theEcorePackage.getEInt(), "getPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eEnumConfigEClass, EEnumConfig.class, "EEnumConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEEnumConfig_TargetEEnum(), theEcorePackage.getEEnum(), null, "targetEEnum", null, 0, 1, EEnumConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEnumConfig_EEnumLiterals(), this.getEEnumLiteralConfig(), null, "eEnumLiterals", null, 0, -1, EEnumConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEEnumConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEEnumConfig__GetPosition(), theEcorePackage.getEInt(), "getPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eEnumLiteralConfigEClass, EEnumLiteralConfig.class, "EEnumLiteralConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEEnumLiteralConfig_TargetEEnumLiteral(), theEcorePackage.getEEnumLiteral(), null, "targetEEnumLiteral", null, 0, 1, EEnumLiteralConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEEnumLiteralConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ieClassConfigEClass, IEClassConfig.class, "IEClassConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIEClassConfig_RepeatInherited(), theEcorePackage.getEBoolean(), "repeatInherited", null, 0, 1, IEClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIEClassConfig__ShouldRepeatInherited(), theEcorePackage.getEBoolean(), "shouldRepeatInherited", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eClassConfigEClass, EClassConfig.class, "EClassConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEClassConfig_TargetEClass(), theEcorePackage.getEClass(), null, "targetEClass", null, 0, 1, EClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassConfig_EAttributes(), this.getEAttributeConfig(), null, "eAttributes", null, 0, -1, EClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassConfig_EContainments(), this.getEContainmentConfig(), null, "eContainments", null, 0, -1, EClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassConfig_EReferences(), this.getEReferenceConfig(), null, "eReferences", null, 0, -1, EClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEClassConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEClassConfig__GetPosition(), theEcorePackage.getEInt(), "getPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEClassConfig__ShouldRepeatInherited(), theEcorePackage.getEBoolean(), "shouldRepeatInherited", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(aeStructuralFeatureConfigEClass, AEStructuralFeatureConfig.class, "AEStructuralFeatureConfig", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eAttributeConfigEClass, EAttributeConfig.class, "EAttributeConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAttributeConfig_TargetEAttribute(), theEcorePackage.getEAttribute(), null, "targetEAttribute", null, 0, 1, EAttributeConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEAttributeConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(aeReferenceConfigEClass, AEReferenceConfig.class, "AEReferenceConfig", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eContainmentConfigEClass, EContainmentConfig.class, "EContainmentConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEContainmentConfig_TargetEContainment(), theEcorePackage.getEReference(), null, "targetEContainment", null, 0, 1, EContainmentConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEContainmentConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eReferenceConfigEClass, EReferenceConfig.class, "EReferenceConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEReferenceConfig_TargetEReference(), theEcorePackage.getEReference(), null, "targetEReference", null, 0, 1, EReferenceConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEReferenceConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ConfigPackageImpl
