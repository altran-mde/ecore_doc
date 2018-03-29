/**
 */
package com.altran.general.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.altran.general.ecoredoc.generator.config.ConfigFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/com.altran.general.ecoredoc.generator.config/emf-gen' basePackage='com.altran.general.ecoredoc.generator'"
 * @generated
 */
public interface ConfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "config";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "com.altran.general.ecoredoc.generator.config";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "config";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigPackage eINSTANCE = com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl <em>Ecore Doc Generator Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEcoreDocGeneratorConfig()
	 * @generated
	 */
	int ECORE_DOC_GENERATOR_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS = 0;

	/**
	 * The feature id for the '<em><b>EData Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>EEnum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__EENUM = 2;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__ECLASS = 3;

	/**
	 * The number of structural features of the '<em>Ecore Doc Generator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Ecore Doc Generator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig <em>IEcore Doc Generator Part Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getIEcoreDocGeneratorPartConfig()
	 * @generated
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG = 1;

	/**
	 * The number of structural features of the '<em>IEcore Doc Generator Part Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IEcore Doc Generator Part Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EDataTypeConfigImpl <em>EData Type Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EDataTypeConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEDataTypeConfig()
	 * @generated
	 */
	int EDATA_TYPE_CONFIG = 2;

	/**
	 * The number of structural features of the '<em>EData Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>EData Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EEnumConfigImpl <em>EEnum Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EEnumConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEEnumConfig()
	 * @generated
	 */
	int EENUM_CONFIG = 3;

	/**
	 * The number of structural features of the '<em>EEnum Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>EEnum Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EClassConfigImpl <em>EClass Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EClassConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEClassConfig()
	 * @generated
	 */
	int ECLASS_CONFIG = 4;

	/**
	 * The feature id for the '<em><b>EAttribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__EATTRIBUTE = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EClass Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>EClass Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EStructuralFeatureConfigImpl <em>EStructural Feature Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EStructuralFeatureConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEStructuralFeatureConfig()
	 * @generated
	 */
	int ESTRUCTURAL_FEATURE_CONFIG = 5;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_CONFIG__ORDERED = 0;

	/**
	 * The number of structural features of the '<em>EStructural Feature Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_CONFIG_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Render Ordered</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_CONFIG___RENDER_ORDERED = 0;

	/**
	 * The number of operations of the '<em>EStructural Feature Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_CONFIG_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EAttributeConfigImpl <em>EAttribute Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EAttributeConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEAttributeConfig()
	 * @generated
	 */
	int EATTRIBUTE_CONFIG = 6;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__ORDERED = ESTRUCTURAL_FEATURE_CONFIG__ORDERED;

	/**
	 * The number of structural features of the '<em>EAttribute Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG_FEATURE_COUNT = ESTRUCTURAL_FEATURE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Render Ordered</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG___RENDER_ORDERED = ESTRUCTURAL_FEATURE_CONFIG___RENDER_ORDERED;

	/**
	 * The number of operations of the '<em>EAttribute Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG_OPERATION_COUNT = ESTRUCTURAL_FEATURE_CONFIG_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig <em>Ecore Doc Generator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Doc Generator Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig
	 * @generated
	 */
	EClass getEcoreDocGeneratorConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#isRenderDefaults <em>Render Defaults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render Defaults</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#isRenderDefaults()
	 * @see #getEcoreDocGeneratorConfig()
	 * @generated
	 */
	EAttribute getEcoreDocGeneratorConfig_RenderDefaults();

	/**
	 * Returns the meta object for the containment reference '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEDataType <em>EData Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EData Type</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEDataType()
	 * @see #getEcoreDocGeneratorConfig()
	 * @generated
	 */
	EReference getEcoreDocGeneratorConfig_EDataType();

	/**
	 * Returns the meta object for the containment reference '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEEnum <em>EEnum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EEnum</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEEnum()
	 * @see #getEcoreDocGeneratorConfig()
	 * @generated
	 */
	EReference getEcoreDocGeneratorConfig_EEnum();

	/**
	 * Returns the meta object for the containment reference '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EClass</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEClass()
	 * @see #getEcoreDocGeneratorConfig()
	 * @generated
	 */
	EReference getEcoreDocGeneratorConfig_EClass();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig <em>IEcore Doc Generator Part Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEcore Doc Generator Part Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig
	 * @generated
	 */
	EClass getIEcoreDocGeneratorPartConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EDataTypeConfig <em>EData Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EData Type Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EDataTypeConfig
	 * @generated
	 */
	EClass getEDataTypeConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EEnumConfig <em>EEnum Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEnum Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumConfig
	 * @generated
	 */
	EClass getEEnumConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EClassConfig <em>EClass Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClass Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig
	 * @generated
	 */
	EClass getEClassConfig();

	/**
	 * Returns the meta object for the containment reference '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getEAttribute <em>EAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EAttribute</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig#getEAttribute()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_EAttribute();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EStructuralFeatureConfig <em>EStructural Feature Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EStructural Feature Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EStructuralFeatureConfig
	 * @generated
	 */
	EClass getEStructuralFeatureConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.ecoredoc.generator.config.EStructuralFeatureConfig#isOrdered <em>Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordered</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EStructuralFeatureConfig#isOrdered()
	 * @see #getEStructuralFeatureConfig()
	 * @generated
	 */
	EAttribute getEStructuralFeatureConfig_Ordered();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EStructuralFeatureConfig#renderOrdered() <em>Render Ordered</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Render Ordered</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EStructuralFeatureConfig#renderOrdered()
	 * @generated
	 */
	EOperation getEStructuralFeatureConfig__RenderOrdered();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EAttributeConfig <em>EAttribute Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAttribute Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EAttributeConfig
	 * @generated
	 */
	EClass getEAttributeConfig();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigFactory getConfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl <em>Ecore Doc Generator Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEcoreDocGeneratorConfig()
		 * @generated
		 */
		EClass ECORE_DOC_GENERATOR_CONFIG = eINSTANCE.getEcoreDocGeneratorConfig();

		/**
		 * The meta object literal for the '<em><b>Render Defaults</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS = eINSTANCE.getEcoreDocGeneratorConfig_RenderDefaults();

		/**
		 * The meta object literal for the '<em><b>EData Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_DOC_GENERATOR_CONFIG__EDATA_TYPE = eINSTANCE.getEcoreDocGeneratorConfig_EDataType();

		/**
		 * The meta object literal for the '<em><b>EEnum</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_DOC_GENERATOR_CONFIG__EENUM = eINSTANCE.getEcoreDocGeneratorConfig_EEnum();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_DOC_GENERATOR_CONFIG__ECLASS = eINSTANCE.getEcoreDocGeneratorConfig_EClass();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig <em>IEcore Doc Generator Part Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getIEcoreDocGeneratorPartConfig()
		 * @generated
		 */
		EClass IECORE_DOC_GENERATOR_PART_CONFIG = eINSTANCE.getIEcoreDocGeneratorPartConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EDataTypeConfigImpl <em>EData Type Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EDataTypeConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEDataTypeConfig()
		 * @generated
		 */
		EClass EDATA_TYPE_CONFIG = eINSTANCE.getEDataTypeConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EEnumConfigImpl <em>EEnum Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EEnumConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEEnumConfig()
		 * @generated
		 */
		EClass EENUM_CONFIG = eINSTANCE.getEEnumConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EClassConfigImpl <em>EClass Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EClassConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEClassConfig()
		 * @generated
		 */
		EClass ECLASS_CONFIG = eINSTANCE.getEClassConfig();

		/**
		 * The meta object literal for the '<em><b>EAttribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_CONFIG__EATTRIBUTE = eINSTANCE.getEClassConfig_EAttribute();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EStructuralFeatureConfigImpl <em>EStructural Feature Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EStructuralFeatureConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEStructuralFeatureConfig()
		 * @generated
		 */
		EClass ESTRUCTURAL_FEATURE_CONFIG = eINSTANCE.getEStructuralFeatureConfig();

		/**
		 * The meta object literal for the '<em><b>Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRUCTURAL_FEATURE_CONFIG__ORDERED = eINSTANCE.getEStructuralFeatureConfig_Ordered();

		/**
		 * The meta object literal for the '<em><b>Render Ordered</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ESTRUCTURAL_FEATURE_CONFIG___RENDER_ORDERED = eINSTANCE.getEStructuralFeatureConfig__RenderOrdered();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EAttributeConfigImpl <em>EAttribute Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EAttributeConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEAttributeConfig()
		 * @generated
		 */
		EClass EATTRIBUTE_CONFIG = eINSTANCE.getEAttributeConfig();

	}

} //ConfigPackage
