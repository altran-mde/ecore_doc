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
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig <em>IEcore Doc Generator Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getIEcoreDocGeneratorConfig()
	 * @generated
	 */
	int IECORE_DOC_GENERATOR_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS = 0;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_CONFIG__RENDER = 1;

	/**
	 * The number of structural features of the '<em>IEcore Doc Generator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS = 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER = 1;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_CONFIG___GET_TARGET = 2;

	/**
	 * The number of operations of the '<em>IEcore Doc Generator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl <em>Ecore Doc Generator Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEcoreDocGeneratorConfig()
	 * @generated
	 */
	int ECORE_DOC_GENERATOR_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__RENDER = IECORE_DOC_GENERATOR_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>EPackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__EPACKAGES = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecore Doc Generator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Find Config</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___FIND_CONFIG__ENAMEDELEMENT = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___GET_TARGET = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Ecore Doc Generator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl <em>EPackage Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEPackageConfig()
	 * @generated
	 */
	int EPACKAGE_CONFIG = 2;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__RENDER = IECORE_DOC_GENERATOR_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Target EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__TARGET_EPACKAGE = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EData Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__EDATA_TYPES = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>EEnums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__EENUMS = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>EClasses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__ECLASSES = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>EPackage Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___SHOULD_RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___SHOULD_RENDER = IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___GET_TARGET = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EPackage Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig <em>IEcore Doc Generator Part Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getIEcoreDocGeneratorPartConfig()
	 * @generated
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG = 3;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG__RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG__RENDER = IECORE_DOC_GENERATOR_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG__POSITION = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IEcore Doc Generator Part Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG___SHOULD_RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG___SHOULD_RENDER = IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG___GET_TARGET = IECORE_DOC_GENERATOR_CONFIG___GET_TARGET;

	/**
	 * The number of operations of the '<em>IEcore Doc Generator Part Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.IEDataTypeConfig <em>IE Data Type Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.IEDataTypeConfig
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getIEDataTypeConfig()
	 * @generated
	 */
	int IE_DATA_TYPE_CONFIG = 4;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG__RENDER_DEFAULTS = IECORE_DOC_GENERATOR_PART_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG__RENDER = IECORE_DOC_GENERATOR_PART_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG__POSITION = IECORE_DOC_GENERATOR_PART_CONFIG__POSITION;

	/**
	 * The number of structural features of the '<em>IE Data Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG___SHOULD_RENDER_DEFAULTS = IECORE_DOC_GENERATOR_PART_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG___SHOULD_RENDER = IECORE_DOC_GENERATOR_PART_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG___GET_TARGET = IECORE_DOC_GENERATOR_PART_CONFIG___GET_TARGET;

	/**
	 * The number of operations of the '<em>IE Data Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EDataTypeConfigImpl <em>EData Type Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EDataTypeConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEDataTypeConfig()
	 * @generated
	 */
	int EDATA_TYPE_CONFIG = 5;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG__RENDER_DEFAULTS = IE_DATA_TYPE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG__RENDER = IE_DATA_TYPE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG__POSITION = IE_DATA_TYPE_CONFIG__POSITION;

	/**
	 * The feature id for the '<em><b>Target EData Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG__TARGET_EDATA_TYPE = IE_DATA_TYPE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EData Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG_FEATURE_COUNT = IE_DATA_TYPE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_DATA_TYPE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG___SHOULD_RENDER = IE_DATA_TYPE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG___GET_TARGET = IE_DATA_TYPE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG___GET_POSITION = IE_DATA_TYPE_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>EData Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG_OPERATION_COUNT = IE_DATA_TYPE_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EEnumConfigImpl <em>EEnum Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EEnumConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEEnumConfig()
	 * @generated
	 */
	int EENUM_CONFIG = 6;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__RENDER_DEFAULTS = IE_DATA_TYPE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__RENDER = IE_DATA_TYPE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__POSITION = IE_DATA_TYPE_CONFIG__POSITION;

	/**
	 * The feature id for the '<em><b>Target EEnum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__TARGET_EENUM = IE_DATA_TYPE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EEnum Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__EENUM_LITERALS = IE_DATA_TYPE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EEnum Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG_FEATURE_COUNT = IE_DATA_TYPE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG___SHOULD_RENDER_DEFAULTS = IE_DATA_TYPE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG___SHOULD_RENDER = IE_DATA_TYPE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG___GET_TARGET = IE_DATA_TYPE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG___GET_POSITION = IE_DATA_TYPE_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>EEnum Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG_OPERATION_COUNT = IE_DATA_TYPE_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl <em>EEnum Literal Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEEnumLiteralConfig()
	 * @generated
	 */
	int EENUM_LITERAL_CONFIG = 7;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG__RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG__RENDER = IECORE_DOC_GENERATOR_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Target EEnum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EEnum Literal Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG___SHOULD_RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG___SHOULD_RENDER = IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG___GET_TARGET = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EEnum Literal Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.IEClassConfig <em>IE Class Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.IEClassConfig
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getIEClassConfig()
	 * @generated
	 */
	int IE_CLASS_CONFIG = 8;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__RENDER = IECORE_DOC_GENERATOR_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__REPEAT_INHERITED = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IE Class Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___SHOULD_RENDER_DEFAULTS = IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___SHOULD_RENDER = IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___GET_TARGET = IECORE_DOC_GENERATOR_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>IE Class Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EClassConfigImpl <em>EClass Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EClassConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEClassConfig()
	 * @generated
	 */
	int ECLASS_CONFIG = 9;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__RENDER_DEFAULTS = IECORE_DOC_GENERATOR_PART_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__RENDER = IECORE_DOC_GENERATOR_PART_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__POSITION = IECORE_DOC_GENERATOR_PART_CONFIG__POSITION;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__REPEAT_INHERITED = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__TARGET_ECLASS = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>EAttributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__EATTRIBUTES = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>EContainments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__ECONTAINMENTS = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>EReferences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__EREFERENCES = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>EClass Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG_FEATURE_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_RENDER_DEFAULTS = IECORE_DOC_GENERATOR_PART_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_RENDER = IECORE_DOC_GENERATOR_PART_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___GET_TARGET = IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___GET_POSITION = IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_REPEAT_INHERITED = IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>EClass Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG_OPERATION_COUNT = IECORE_DOC_GENERATOR_PART_CONFIG_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.AEStructuralFeatureConfigImpl <em>AE Structural Feature Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.AEStructuralFeatureConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getAEStructuralFeatureConfig()
	 * @generated
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG = 10;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG__RENDER_DEFAULTS = IE_CLASS_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG__RENDER = IE_CLASS_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG__REPEAT_INHERITED = IE_CLASS_CONFIG__REPEAT_INHERITED;

	/**
	 * The number of structural features of the '<em>AE Structural Feature Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG_FEATURE_COUNT = IE_CLASS_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_CLASS_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER = IE_CLASS_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG___GET_TARGET = IE_CLASS_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG___SHOULD_REPEAT_INHERITED = IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED;

	/**
	 * The number of operations of the '<em>AE Structural Feature Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_STRUCTURAL_FEATURE_CONFIG_OPERATION_COUNT = IE_CLASS_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.AEReferenceConfigImpl <em>AE Reference Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.AEReferenceConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getAEReferenceConfig()
	 * @generated
	 */
	int AE_REFERENCE_CONFIG = 12;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EAttributeConfigImpl <em>EAttribute Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EAttributeConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEAttributeConfig()
	 * @generated
	 */
	int EATTRIBUTE_CONFIG = 11;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__RENDER_DEFAULTS = AE_STRUCTURAL_FEATURE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__RENDER = AE_STRUCTURAL_FEATURE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__REPEAT_INHERITED = AE_STRUCTURAL_FEATURE_CONFIG__REPEAT_INHERITED;

	/**
	 * The feature id for the '<em><b>Target EAttribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE = AE_STRUCTURAL_FEATURE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EAttribute Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG_FEATURE_COUNT = AE_STRUCTURAL_FEATURE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG___SHOULD_RENDER_DEFAULTS = AE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG___SHOULD_RENDER = AE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG___SHOULD_REPEAT_INHERITED = AE_STRUCTURAL_FEATURE_CONFIG___SHOULD_REPEAT_INHERITED;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG___GET_TARGET = AE_STRUCTURAL_FEATURE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EAttribute Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG_OPERATION_COUNT = AE_STRUCTURAL_FEATURE_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG__RENDER_DEFAULTS = AE_STRUCTURAL_FEATURE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG__RENDER = AE_STRUCTURAL_FEATURE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG__REPEAT_INHERITED = AE_STRUCTURAL_FEATURE_CONFIG__REPEAT_INHERITED;

	/**
	 * The number of structural features of the '<em>AE Reference Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG_FEATURE_COUNT = AE_STRUCTURAL_FEATURE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS = AE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG___SHOULD_RENDER = AE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG___GET_TARGET = AE_STRUCTURAL_FEATURE_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG___SHOULD_REPEAT_INHERITED = AE_STRUCTURAL_FEATURE_CONFIG___SHOULD_REPEAT_INHERITED;

	/**
	 * The number of operations of the '<em>AE Reference Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG_OPERATION_COUNT = AE_STRUCTURAL_FEATURE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EContainmentConfigImpl <em>EContainment Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EContainmentConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEContainmentConfig()
	 * @generated
	 */
	int ECONTAINMENT_CONFIG = 13;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG__RENDER_DEFAULTS = AE_REFERENCE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG__RENDER = AE_REFERENCE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG__REPEAT_INHERITED = AE_REFERENCE_CONFIG__REPEAT_INHERITED;

	/**
	 * The feature id for the '<em><b>Target EContainment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG__TARGET_ECONTAINMENT = AE_REFERENCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EContainment Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG_FEATURE_COUNT = AE_REFERENCE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG___SHOULD_RENDER_DEFAULTS = AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG___SHOULD_RENDER = AE_REFERENCE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG___SHOULD_REPEAT_INHERITED = AE_REFERENCE_CONFIG___SHOULD_REPEAT_INHERITED;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG___GET_TARGET = AE_REFERENCE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EContainment Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG_OPERATION_COUNT = AE_REFERENCE_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.altran.general.ecoredoc.generator.config.impl.EReferenceConfigImpl <em>EReference Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.ecoredoc.generator.config.impl.EReferenceConfigImpl
	 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEReferenceConfig()
	 * @generated
	 */
	int EREFERENCE_CONFIG = 14;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG__RENDER_DEFAULTS = AE_REFERENCE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG__RENDER = AE_REFERENCE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG__REPEAT_INHERITED = AE_REFERENCE_CONFIG__REPEAT_INHERITED;

	/**
	 * The feature id for the '<em><b>Target EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG__TARGET_EREFERENCE = AE_REFERENCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EReference Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG_FEATURE_COUNT = AE_REFERENCE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS = AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG___SHOULD_RENDER = AE_REFERENCE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG___SHOULD_REPEAT_INHERITED = AE_REFERENCE_CONFIG___SHOULD_REPEAT_INHERITED;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG___GET_TARGET = AE_REFERENCE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EReference Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG_OPERATION_COUNT = AE_REFERENCE_CONFIG_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig <em>IEcore Doc Generator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEcore Doc Generator Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig
	 * @generated
	 */
	EClass getIEcoreDocGeneratorConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRenderDefaults <em>Render Defaults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render Defaults</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRenderDefaults()
	 * @see #getIEcoreDocGeneratorConfig()
	 * @generated
	 */
	EAttribute getIEcoreDocGeneratorConfig_RenderDefaults();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRender <em>Render</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRender()
	 * @see #getIEcoreDocGeneratorConfig()
	 * @generated
	 */
	EAttribute getIEcoreDocGeneratorConfig_Render();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#shouldRenderDefaults() <em>Should Render Defaults</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Defaults</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#shouldRenderDefaults()
	 * @generated
	 */
	EOperation getIEcoreDocGeneratorConfig__ShouldRenderDefaults();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#shouldRender() <em>Should Render</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#shouldRender()
	 * @generated
	 */
	EOperation getIEcoreDocGeneratorConfig__ShouldRender();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#getTarget()
	 * @generated
	 */
	EOperation getIEcoreDocGeneratorConfig__GetTarget();

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
	 * Returns the meta object for the containment reference list '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEPackages <em>EPackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EPackages</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEPackages()
	 * @see #getEcoreDocGeneratorConfig()
	 * @generated
	 */
	EReference getEcoreDocGeneratorConfig_EPackages();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderDefaults() <em>Should Render Defaults</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Defaults</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderDefaults()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__ShouldRenderDefaults();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRender() <em>Should Render</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRender()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__ShouldRender();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#findConfig(org.eclipse.emf.ecore.ENamedElement) <em>Find Config</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Config</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#findConfig(org.eclipse.emf.ecore.ENamedElement)
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__FindConfig__ENamedElement();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getTarget()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig <em>EPackage Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPackage Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EPackageConfig
	 * @generated
	 */
	EClass getEPackageConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getTargetEPackage <em>Target EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EPackage</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EPackageConfig#getTargetEPackage()
	 * @see #getEPackageConfig()
	 * @generated
	 */
	EReference getEPackageConfig_TargetEPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getEDataTypes <em>EData Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EData Types</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EPackageConfig#getEDataTypes()
	 * @see #getEPackageConfig()
	 * @generated
	 */
	EReference getEPackageConfig_EDataTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getEEnums <em>EEnums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EEnums</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EPackageConfig#getEEnums()
	 * @see #getEPackageConfig()
	 * @generated
	 */
	EReference getEPackageConfig_EEnums();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getEClasses <em>EClasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EClasses</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EPackageConfig#getEClasses()
	 * @see #getEPackageConfig()
	 * @generated
	 */
	EReference getEPackageConfig_EClasses();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EPackageConfig#getTarget()
	 * @generated
	 */
	EOperation getEPackageConfig__GetTarget();

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
	 * Returns the meta object for the attribute '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig#getPosition()
	 * @see #getIEcoreDocGeneratorPartConfig()
	 * @generated
	 */
	EAttribute getIEcoreDocGeneratorPartConfig_Position();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.IEDataTypeConfig <em>IE Data Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Data Type Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.IEDataTypeConfig
	 * @generated
	 */
	EClass getIEDataTypeConfig();

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
	 * Returns the meta object for the reference '{@link com.altran.general.ecoredoc.generator.config.EDataTypeConfig#getTargetEDataType <em>Target EData Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EData Type</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EDataTypeConfig#getTargetEDataType()
	 * @see #getEDataTypeConfig()
	 * @generated
	 */
	EReference getEDataTypeConfig_TargetEDataType();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EDataTypeConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EDataTypeConfig#getTarget()
	 * @generated
	 */
	EOperation getEDataTypeConfig__GetTarget();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EDataTypeConfig#getPosition() <em>Get Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Position</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EDataTypeConfig#getPosition()
	 * @generated
	 */
	EOperation getEDataTypeConfig__GetPosition();

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
	 * Returns the meta object for the reference '{@link com.altran.general.ecoredoc.generator.config.EEnumConfig#getTargetEEnum <em>Target EEnum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EEnum</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumConfig#getTargetEEnum()
	 * @see #getEEnumConfig()
	 * @generated
	 */
	EReference getEEnumConfig_TargetEEnum();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.ecoredoc.generator.config.EEnumConfig#getEEnumLiterals <em>EEnum Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EEnum Literals</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumConfig#getEEnumLiterals()
	 * @see #getEEnumConfig()
	 * @generated
	 */
	EReference getEEnumConfig_EEnumLiterals();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EEnumConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumConfig#getTarget()
	 * @generated
	 */
	EOperation getEEnumConfig__GetTarget();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EEnumConfig#getPosition() <em>Get Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Position</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumConfig#getPosition()
	 * @generated
	 */
	EOperation getEEnumConfig__GetPosition();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig <em>EEnum Literal Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEnum Literal Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig
	 * @generated
	 */
	EClass getEEnumLiteralConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig#getTargetEEnumLiteral <em>Target EEnum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EEnum Literal</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig#getTargetEEnumLiteral()
	 * @see #getEEnumLiteralConfig()
	 * @generated
	 */
	EReference getEEnumLiteralConfig_TargetEEnumLiteral();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig#getTarget()
	 * @generated
	 */
	EOperation getEEnumLiteralConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.IEClassConfig <em>IE Class Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Class Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.IEClassConfig
	 * @generated
	 */
	EClass getIEClassConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repeat Inherited</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.IEClassConfig#isRepeatInherited()
	 * @see #getIEClassConfig()
	 * @generated
	 */
	EAttribute getIEClassConfig_RepeatInherited();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.IEClassConfig#shouldRepeatInherited() <em>Should Repeat Inherited</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Repeat Inherited</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.IEClassConfig#shouldRepeatInherited()
	 * @generated
	 */
	EOperation getIEClassConfig__ShouldRepeatInherited();

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
	 * Returns the meta object for the reference '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getTargetEClass <em>Target EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EClass</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig#getTargetEClass()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_TargetEClass();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getEAttributes <em>EAttributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EAttributes</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig#getEAttributes()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_EAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getEContainments <em>EContainments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EContainments</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig#getEContainments()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_EContainments();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getEReferences <em>EReferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EReferences</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig#getEReferences()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_EReferences();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig#getTarget()
	 * @generated
	 */
	EOperation getEClassConfig__GetTarget();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getPosition() <em>Get Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Position</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig#getPosition()
	 * @generated
	 */
	EOperation getEClassConfig__GetPosition();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#shouldRepeatInherited() <em>Should Repeat Inherited</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Repeat Inherited</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig#shouldRepeatInherited()
	 * @generated
	 */
	EOperation getEClassConfig__ShouldRepeatInherited();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.AEStructuralFeatureConfig <em>AE Structural Feature Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AE Structural Feature Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.AEStructuralFeatureConfig
	 * @generated
	 */
	EClass getAEStructuralFeatureConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.AEReferenceConfig <em>AE Reference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AE Reference Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.AEReferenceConfig
	 * @generated
	 */
	EClass getAEReferenceConfig();

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
	 * Returns the meta object for the reference '{@link com.altran.general.ecoredoc.generator.config.EAttributeConfig#getTargetEAttribute <em>Target EAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EAttribute</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EAttributeConfig#getTargetEAttribute()
	 * @see #getEAttributeConfig()
	 * @generated
	 */
	EReference getEAttributeConfig_TargetEAttribute();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EAttributeConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EAttributeConfig#getTarget()
	 * @generated
	 */
	EOperation getEAttributeConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EContainmentConfig <em>EContainment Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EContainment Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EContainmentConfig
	 * @generated
	 */
	EClass getEContainmentConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.ecoredoc.generator.config.EContainmentConfig#getTargetEContainment <em>Target EContainment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EContainment</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EContainmentConfig#getTargetEContainment()
	 * @see #getEContainmentConfig()
	 * @generated
	 */
	EReference getEContainmentConfig_TargetEContainment();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EContainmentConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EContainmentConfig#getTarget()
	 * @generated
	 */
	EOperation getEContainmentConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.ecoredoc.generator.config.EReferenceConfig <em>EReference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EReference Config</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EReferenceConfig
	 * @generated
	 */
	EClass getEReferenceConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.ecoredoc.generator.config.EReferenceConfig#getTargetEReference <em>Target EReference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EReference</em>'.
	 * @see com.altran.general.ecoredoc.generator.config.EReferenceConfig#getTargetEReference()
	 * @see #getEReferenceConfig()
	 * @generated
	 */
	EReference getEReferenceConfig_TargetEReference();

	/**
	 * Returns the meta object for the '{@link com.altran.general.ecoredoc.generator.config.EReferenceConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.ecoredoc.generator.config.EReferenceConfig#getTarget()
	 * @generated
	 */
	EOperation getEReferenceConfig__GetTarget();

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
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig <em>IEcore Doc Generator Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getIEcoreDocGeneratorConfig()
		 * @generated
		 */
		EClass IECORE_DOC_GENERATOR_CONFIG = eINSTANCE.getIEcoreDocGeneratorConfig();

		/**
		 * The meta object literal for the '<em><b>Render Defaults</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS = eINSTANCE.getIEcoreDocGeneratorConfig_RenderDefaults();

		/**
		 * The meta object literal for the '<em><b>Render</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IECORE_DOC_GENERATOR_CONFIG__RENDER = eINSTANCE.getIEcoreDocGeneratorConfig_Render();

		/**
		 * The meta object literal for the '<em><b>Should Render Defaults</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS = eINSTANCE.getIEcoreDocGeneratorConfig__ShouldRenderDefaults();

		/**
		 * The meta object literal for the '<em><b>Should Render</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER = eINSTANCE.getIEcoreDocGeneratorConfig__ShouldRender();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IECORE_DOC_GENERATOR_CONFIG___GET_TARGET = eINSTANCE.getIEcoreDocGeneratorConfig__GetTarget();

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
		 * The meta object literal for the '<em><b>EPackages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_DOC_GENERATOR_CONFIG__EPACKAGES = eINSTANCE.getEcoreDocGeneratorConfig_EPackages();

		/**
		 * The meta object literal for the '<em><b>Should Render Defaults</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS = eINSTANCE.getEcoreDocGeneratorConfig__ShouldRenderDefaults();

		/**
		 * The meta object literal for the '<em><b>Should Render</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER = eINSTANCE.getEcoreDocGeneratorConfig__ShouldRender();

		/**
		 * The meta object literal for the '<em><b>Find Config</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___FIND_CONFIG__ENAMEDELEMENT = eINSTANCE.getEcoreDocGeneratorConfig__FindConfig__ENamedElement();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___GET_TARGET = eINSTANCE.getEcoreDocGeneratorConfig__GetTarget();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl <em>EPackage Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EPackageConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEPackageConfig()
		 * @generated
		 */
		EClass EPACKAGE_CONFIG = eINSTANCE.getEPackageConfig();

		/**
		 * The meta object literal for the '<em><b>Target EPackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPACKAGE_CONFIG__TARGET_EPACKAGE = eINSTANCE.getEPackageConfig_TargetEPackage();

		/**
		 * The meta object literal for the '<em><b>EData Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPACKAGE_CONFIG__EDATA_TYPES = eINSTANCE.getEPackageConfig_EDataTypes();

		/**
		 * The meta object literal for the '<em><b>EEnums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPACKAGE_CONFIG__EENUMS = eINSTANCE.getEPackageConfig_EEnums();

		/**
		 * The meta object literal for the '<em><b>EClasses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPACKAGE_CONFIG__ECLASSES = eINSTANCE.getEPackageConfig_EClasses();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPACKAGE_CONFIG___GET_TARGET = eINSTANCE.getEPackageConfig__GetTarget();

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
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IECORE_DOC_GENERATOR_PART_CONFIG__POSITION = eINSTANCE.getIEcoreDocGeneratorPartConfig_Position();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.IEDataTypeConfig <em>IE Data Type Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.IEDataTypeConfig
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getIEDataTypeConfig()
		 * @generated
		 */
		EClass IE_DATA_TYPE_CONFIG = eINSTANCE.getIEDataTypeConfig();

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
		 * The meta object literal for the '<em><b>Target EData Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDATA_TYPE_CONFIG__TARGET_EDATA_TYPE = eINSTANCE.getEDataTypeConfig_TargetEDataType();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDATA_TYPE_CONFIG___GET_TARGET = eINSTANCE.getEDataTypeConfig__GetTarget();

		/**
		 * The meta object literal for the '<em><b>Get Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDATA_TYPE_CONFIG___GET_POSITION = eINSTANCE.getEDataTypeConfig__GetPosition();

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
		 * The meta object literal for the '<em><b>Target EEnum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_CONFIG__TARGET_EENUM = eINSTANCE.getEEnumConfig_TargetEEnum();

		/**
		 * The meta object literal for the '<em><b>EEnum Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_CONFIG__EENUM_LITERALS = eINSTANCE.getEEnumConfig_EEnumLiterals();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EENUM_CONFIG___GET_TARGET = eINSTANCE.getEEnumConfig__GetTarget();

		/**
		 * The meta object literal for the '<em><b>Get Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EENUM_CONFIG___GET_POSITION = eINSTANCE.getEEnumConfig__GetPosition();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl <em>EEnum Literal Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEEnumLiteralConfig()
		 * @generated
		 */
		EClass EENUM_LITERAL_CONFIG = eINSTANCE.getEEnumLiteralConfig();

		/**
		 * The meta object literal for the '<em><b>Target EEnum Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL = eINSTANCE.getEEnumLiteralConfig_TargetEEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EENUM_LITERAL_CONFIG___GET_TARGET = eINSTANCE.getEEnumLiteralConfig__GetTarget();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.IEClassConfig <em>IE Class Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.IEClassConfig
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getIEClassConfig()
		 * @generated
		 */
		EClass IE_CLASS_CONFIG = eINSTANCE.getIEClassConfig();

		/**
		 * The meta object literal for the '<em><b>Repeat Inherited</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_CLASS_CONFIG__REPEAT_INHERITED = eINSTANCE.getIEClassConfig_RepeatInherited();

		/**
		 * The meta object literal for the '<em><b>Should Repeat Inherited</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED = eINSTANCE.getIEClassConfig__ShouldRepeatInherited();

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
		 * The meta object literal for the '<em><b>Target EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_CONFIG__TARGET_ECLASS = eINSTANCE.getEClassConfig_TargetEClass();

		/**
		 * The meta object literal for the '<em><b>EAttributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_CONFIG__EATTRIBUTES = eINSTANCE.getEClassConfig_EAttributes();

		/**
		 * The meta object literal for the '<em><b>EContainments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_CONFIG__ECONTAINMENTS = eINSTANCE.getEClassConfig_EContainments();

		/**
		 * The meta object literal for the '<em><b>EReferences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_CONFIG__EREFERENCES = eINSTANCE.getEClassConfig_EReferences();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECLASS_CONFIG___GET_TARGET = eINSTANCE.getEClassConfig__GetTarget();

		/**
		 * The meta object literal for the '<em><b>Get Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECLASS_CONFIG___GET_POSITION = eINSTANCE.getEClassConfig__GetPosition();

		/**
		 * The meta object literal for the '<em><b>Should Repeat Inherited</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECLASS_CONFIG___SHOULD_REPEAT_INHERITED = eINSTANCE.getEClassConfig__ShouldRepeatInherited();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.AEStructuralFeatureConfigImpl <em>AE Structural Feature Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.AEStructuralFeatureConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getAEStructuralFeatureConfig()
		 * @generated
		 */
		EClass AE_STRUCTURAL_FEATURE_CONFIG = eINSTANCE.getAEStructuralFeatureConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.AEReferenceConfigImpl <em>AE Reference Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.AEReferenceConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getAEReferenceConfig()
		 * @generated
		 */
		EClass AE_REFERENCE_CONFIG = eINSTANCE.getAEReferenceConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EAttributeConfigImpl <em>EAttribute Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EAttributeConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEAttributeConfig()
		 * @generated
		 */
		EClass EATTRIBUTE_CONFIG = eINSTANCE.getEAttributeConfig();

		/**
		 * The meta object literal for the '<em><b>Target EAttribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE = eINSTANCE.getEAttributeConfig_TargetEAttribute();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EATTRIBUTE_CONFIG___GET_TARGET = eINSTANCE.getEAttributeConfig__GetTarget();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EContainmentConfigImpl <em>EContainment Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EContainmentConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEContainmentConfig()
		 * @generated
		 */
		EClass ECONTAINMENT_CONFIG = eINSTANCE.getEContainmentConfig();

		/**
		 * The meta object literal for the '<em><b>Target EContainment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECONTAINMENT_CONFIG__TARGET_ECONTAINMENT = eINSTANCE.getEContainmentConfig_TargetEContainment();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECONTAINMENT_CONFIG___GET_TARGET = eINSTANCE.getEContainmentConfig__GetTarget();

		/**
		 * The meta object literal for the '{@link com.altran.general.ecoredoc.generator.config.impl.EReferenceConfigImpl <em>EReference Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.ecoredoc.generator.config.impl.EReferenceConfigImpl
		 * @see com.altran.general.ecoredoc.generator.config.impl.ConfigPackageImpl#getEReferenceConfig()
		 * @generated
		 */
		EClass EREFERENCE_CONFIG = eINSTANCE.getEReferenceConfig();

		/**
		 * The meta object literal for the '<em><b>Target EReference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_CONFIG__TARGET_EREFERENCE = eINSTANCE.getEReferenceConfig_TargetEReference();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EREFERENCE_CONFIG___GET_TARGET = eINSTANCE.getEReferenceConfig__GetTarget();

	}

} //ConfigPackage
