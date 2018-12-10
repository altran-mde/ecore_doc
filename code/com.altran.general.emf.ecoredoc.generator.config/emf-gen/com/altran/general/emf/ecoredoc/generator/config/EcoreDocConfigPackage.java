/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

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
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel prefix='EcoreDocConfig' modelDirectory='/com.altran.general.emf.ecoredoc.generator.config/emf-gen' bundleManifest='false' modelPluginID='' modelPluginVariables='' updateClasspath='false' runtimeVersion='2.12' complianceLevel='8.0' basePackage='com.altran.general.emf.ecoredoc.generator'"
 *        annotation="http://www.eclipse.org/emf/2011/Xcore Ecore='http://www.eclipse.org/emf/2002/Ecore' GenModel='http://www.eclipse.org/emf/2002/GenModel' EcoreDoc='http://altran.com/general/emf/ecoredoc/generator/config/0.1'"
 * @generated
 */
public interface EcoreDocConfigPackage extends EPackage {
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
	String eNS_URI = "http://altran.com/general/emf/ecoredoc/generator/config/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EcoreDocConfigNs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcoreDocConfigPackage eINSTANCE = com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig <em>IE Named Element Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIENamedElementConfig()
	 * @generated
	 */
	int IE_NAMED_ELEMENT_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_NAMED_ELEMENT_CONFIG__RENDER = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_NAMED_ELEMENT_CONFIG__ID = 1;

	/**
	 * The number of structural features of the '<em>IE Named Element Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_NAMED_ELEMENT_CONFIG___SHOULD_RENDER = 0;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_NAMED_ELEMENT_CONFIG___GET_TARGET = 1;

	/**
	 * The number of operations of the '<em>IE Named Element Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig <em>IDefault Value Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIDefaultValueConfig()
	 * @generated
	 */
	int IDEFAULT_VALUE_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS = 0;

	/**
	 * The number of structural features of the '<em>IDefault Value Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEFAULT_VALUE_CONFIG_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS = 0;

	/**
	 * The number of operations of the '<em>IDefault Value Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEFAULT_VALUE_CONFIG_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig <em>IE Classifier Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEClassifierConfig()
	 * @generated
	 */
	int IE_CLASSIFIER_CONFIG = 2;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG__RENDER = IE_NAMED_ELEMENT_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG__ID = IE_NAMED_ELEMENT_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG__RENDER_DEFAULTS = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG__RENDER_USE_CASES = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IE Classifier Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG_FEATURE_COUNT = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG___SHOULD_RENDER = IE_NAMED_ELEMENT_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG___GET_TARGET = IE_NAMED_ELEMENT_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG___SHOULD_RENDER_DEFAULTS = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render Use Cases</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG___SHOULD_RENDER_USE_CASES = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>IE Classifier Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_CONFIG_OPERATION_COUNT = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig <em>IE Data Type Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEDataTypeConfig()
	 * @generated
	 */
	int IE_DATA_TYPE_CONFIG = 3;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG__RENDER = IE_CLASSIFIER_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG__ID = IE_CLASSIFIER_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG__RENDER_DEFAULTS = IE_CLASSIFIER_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG__RENDER_USE_CASES = IE_CLASSIFIER_CONFIG__RENDER_USE_CASES;

	/**
	 * The number of structural features of the '<em>IE Data Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG_FEATURE_COUNT = IE_CLASSIFIER_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG___SHOULD_RENDER = IE_CLASSIFIER_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG___GET_TARGET = IE_CLASSIFIER_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_CLASSIFIER_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Use Cases</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG___SHOULD_RENDER_USE_CASES = IE_CLASSIFIER_CONFIG___SHOULD_RENDER_USE_CASES;

	/**
	 * The number of operations of the '<em>IE Data Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_DATA_TYPE_CONFIG_OPERATION_COUNT = IE_CLASSIFIER_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig <em>IE Enum Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEEnumConfig()
	 * @generated
	 */
	int IE_ENUM_CONFIG = 4;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG__RENDER = IE_DATA_TYPE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG__ID = IE_DATA_TYPE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG__RENDER_DEFAULTS = IE_DATA_TYPE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG__RENDER_USE_CASES = IE_DATA_TYPE_CONFIG__RENDER_USE_CASES;

	/**
	 * The number of structural features of the '<em>IE Enum Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG_FEATURE_COUNT = IE_DATA_TYPE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG___SHOULD_RENDER = IE_DATA_TYPE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG___GET_TARGET = IE_DATA_TYPE_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG___SHOULD_RENDER_DEFAULTS = IE_DATA_TYPE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Use Cases</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG___SHOULD_RENDER_USE_CASES = IE_DATA_TYPE_CONFIG___SHOULD_RENDER_USE_CASES;

	/**
	 * The number of operations of the '<em>IE Enum Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_CONFIG_OPERATION_COUNT = IE_DATA_TYPE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig <em>IE Class Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEClassConfig()
	 * @generated
	 */
	int IE_CLASS_CONFIG = 5;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__RENDER = IE_CLASSIFIER_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__ID = IE_CLASSIFIER_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__RENDER_DEFAULTS = IE_CLASSIFIER_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__RENDER_USE_CASES = IE_CLASSIFIER_CONFIG__RENDER_USE_CASES;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__REPEAT_INHERITED = IE_CLASSIFIER_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Render Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__RENDER_SUB_TYPES = IE_CLASSIFIER_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Render Super Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG__RENDER_SUPER_TYPES = IE_CLASSIFIER_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>IE Class Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG_FEATURE_COUNT = IE_CLASSIFIER_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___SHOULD_RENDER = IE_CLASSIFIER_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___GET_TARGET = IE_CLASSIFIER_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___SHOULD_RENDER_DEFAULTS = IE_CLASSIFIER_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Use Cases</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___SHOULD_RENDER_USE_CASES = IE_CLASSIFIER_CONFIG___SHOULD_RENDER_USE_CASES;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED = IE_CLASSIFIER_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render Sub Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___SHOULD_RENDER_SUB_TYPES = IE_CLASSIFIER_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render Super Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG___SHOULD_RENDER_SUPER_TYPES = IE_CLASSIFIER_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>IE Class Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASS_CONFIG_OPERATION_COUNT = IE_CLASSIFIER_CONFIG_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig <em>IE Typed Element Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIETypedElementConfig()
	 * @generated
	 */
	int IE_TYPED_ELEMENT_CONFIG = 6;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG__RENDER = IE_NAMED_ELEMENT_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG__ID = IE_NAMED_ELEMENT_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG__RENDER_DEFAULTS = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG__RENDER_BOUNDS = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IE Typed Element Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG_FEATURE_COUNT = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER = IE_NAMED_ELEMENT_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG___GET_TARGET = IE_NAMED_ELEMENT_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_DEFAULTS = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_BOUNDS = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>IE Typed Element Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_TYPED_ELEMENT_CONFIG_OPERATION_COUNT = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig <em>IE Structural Feature Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEStructuralFeatureConfig()
	 * @generated
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG = 7;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG__RENDER = IE_TYPED_ELEMENT_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG__ID = IE_TYPED_ELEMENT_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG__RENDER_DEFAULTS = IE_TYPED_ELEMENT_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG__RENDER_BOUNDS = IE_TYPED_ELEMENT_CONFIG__RENDER_BOUNDS;

	/**
	 * The number of structural features of the '<em>IE Structural Feature Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG_FEATURE_COUNT = IE_TYPED_ELEMENT_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER = IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG___GET_TARGET = IE_TYPED_ELEMENT_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_BOUNDS = IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_BOUNDS;

	/**
	 * The number of operations of the '<em>IE Structural Feature Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_STRUCTURAL_FEATURE_CONFIG_OPERATION_COUNT = IE_TYPED_ELEMENT_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig <em>IE Attribute Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEAttributeConfig()
	 * @generated
	 */
	int IE_ATTRIBUTE_CONFIG = 8;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG__RENDER = IE_STRUCTURAL_FEATURE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG__ID = IE_STRUCTURAL_FEATURE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG__RENDER_DEFAULTS = IE_STRUCTURAL_FEATURE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG__RENDER_BOUNDS = IE_STRUCTURAL_FEATURE_CONFIG__RENDER_BOUNDS;

	/**
	 * The number of structural features of the '<em>IE Attribute Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG_FEATURE_COUNT = IE_STRUCTURAL_FEATURE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG___SHOULD_RENDER = IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG___GET_TARGET = IE_STRUCTURAL_FEATURE_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG___SHOULD_RENDER_BOUNDS = IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_BOUNDS;

	/**
	 * The number of operations of the '<em>IE Attribute Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTRIBUTE_CONFIG_OPERATION_COUNT = IE_STRUCTURAL_FEATURE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig <em>IE Reference Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEReferenceConfig()
	 * @generated
	 */
	int IE_REFERENCE_CONFIG = 9;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG__RENDER = IE_STRUCTURAL_FEATURE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG__ID = IE_STRUCTURAL_FEATURE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG__RENDER_DEFAULTS = IE_STRUCTURAL_FEATURE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG__RENDER_BOUNDS = IE_STRUCTURAL_FEATURE_CONFIG__RENDER_BOUNDS;

	/**
	 * The number of structural features of the '<em>IE Reference Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG_FEATURE_COUNT = IE_STRUCTURAL_FEATURE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG___SHOULD_RENDER = IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG___GET_TARGET = IE_STRUCTURAL_FEATURE_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG___SHOULD_RENDER_BOUNDS = IE_STRUCTURAL_FEATURE_CONFIG___SHOULD_RENDER_BOUNDS;

	/**
	 * The number of operations of the '<em>IE Reference Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_REFERENCE_CONFIG_OPERATION_COUNT = IE_STRUCTURAL_FEATURE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig <em>IE Operation Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEOperationConfig()
	 * @generated
	 */
	int IE_OPERATION_CONFIG = 10;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG__RENDER = IE_TYPED_ELEMENT_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG__ID = IE_TYPED_ELEMENT_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG__RENDER_DEFAULTS = IE_TYPED_ELEMENT_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG__RENDER_BOUNDS = IE_TYPED_ELEMENT_CONFIG__RENDER_BOUNDS;

	/**
	 * The number of structural features of the '<em>IE Operation Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG_FEATURE_COUNT = IE_TYPED_ELEMENT_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG___SHOULD_RENDER = IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG___GET_TARGET = IE_TYPED_ELEMENT_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG___SHOULD_RENDER_DEFAULTS = IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG___SHOULD_RENDER_BOUNDS = IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_BOUNDS;

	/**
	 * The number of operations of the '<em>IE Operation Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_OPERATION_CONFIG_OPERATION_COUNT = IE_TYPED_ELEMENT_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig <em>IE Parameter Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEParameterConfig()
	 * @generated
	 */
	int IE_PARAMETER_CONFIG = 11;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG__RENDER = IE_TYPED_ELEMENT_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG__ID = IE_TYPED_ELEMENT_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG__RENDER_DEFAULTS = IE_TYPED_ELEMENT_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG__RENDER_BOUNDS = IE_TYPED_ELEMENT_CONFIG__RENDER_BOUNDS;

	/**
	 * The number of structural features of the '<em>IE Parameter Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG_FEATURE_COUNT = IE_TYPED_ELEMENT_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG___SHOULD_RENDER = IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG___GET_TARGET = IE_TYPED_ELEMENT_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG___SHOULD_RENDER_DEFAULTS = IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG___SHOULD_RENDER_BOUNDS = IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_BOUNDS;

	/**
	 * The number of operations of the '<em>IE Parameter Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PARAMETER_CONFIG_OPERATION_COUNT = IE_TYPED_ELEMENT_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig <em>IE Package Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEPackageConfig()
	 * @generated
	 */
	int IE_PACKAGE_CONFIG = 12;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG__RENDER = IE_NAMED_ELEMENT_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG__ID = IE_NAMED_ELEMENT_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Position EData Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG__POSITION_EDATA_TYPES = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Position EEnums</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG__POSITION_EENUMS = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Position EClasses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG__POSITION_ECLASSES = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>IE Package Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG_FEATURE_COUNT = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG___SHOULD_RENDER = IE_NAMED_ELEMENT_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG___GET_TARGET = IE_NAMED_ELEMENT_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Get EData Types Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG___GET_EDATA_TYPES_POSITION = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EEnums Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG___GET_EENUMS_POSITION = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EClasses Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG___GET_ECLASSES_POSITION = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>IE Package Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_PACKAGE_CONFIG_OPERATION_COUNT = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig <em>IE Enum Literal Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEEnumLiteralConfig()
	 * @generated
	 */
	int IE_ENUM_LITERAL_CONFIG = 13;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_LITERAL_CONFIG__RENDER = IE_NAMED_ELEMENT_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_LITERAL_CONFIG__ID = IE_NAMED_ELEMENT_CONFIG__ID;

	/**
	 * The number of structural features of the '<em>IE Enum Literal Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_LITERAL_CONFIG_FEATURE_COUNT = IE_NAMED_ELEMENT_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_LITERAL_CONFIG___SHOULD_RENDER = IE_NAMED_ELEMENT_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_LITERAL_CONFIG___GET_TARGET = IE_NAMED_ELEMENT_CONFIG___GET_TARGET;

	/**
	 * The number of operations of the '<em>IE Enum Literal Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ENUM_LITERAL_CONFIG_OPERATION_COUNT = IE_NAMED_ELEMENT_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl <em>Ecore Doc Generator Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEcoreDocGeneratorConfig()
	 * @generated
	 */
	int ECORE_DOC_GENERATOR_CONFIG = 14;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__RENDER = IE_PACKAGE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__ID = IE_PACKAGE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Position EData Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__POSITION_EDATA_TYPES = IE_PACKAGE_CONFIG__POSITION_EDATA_TYPES;

	/**
	 * The feature id for the '<em><b>Position EEnums</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__POSITION_EENUMS = IE_PACKAGE_CONFIG__POSITION_EENUMS;

	/**
	 * The feature id for the '<em><b>Position EClasses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__POSITION_ECLASSES = IE_PACKAGE_CONFIG__POSITION_ECLASSES;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS = IE_PACKAGE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES = IE_PACKAGE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED = IE_PACKAGE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Render Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__RENDER_SUB_TYPES = IE_PACKAGE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Render Super Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__RENDER_SUPER_TYPES = IE_PACKAGE_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__RENDER_BOUNDS = IE_PACKAGE_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Document Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__DOCUMENT_TITLE = IE_PACKAGE_CONFIG_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>EPackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG__EPACKAGES = IE_PACKAGE_CONFIG_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Ecore Doc Generator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG_FEATURE_COUNT = IE_PACKAGE_CONFIG_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER = IE_PACKAGE_CONFIG_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS = IE_PACKAGE_CONFIG_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Should Render Use Cases</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_USE_CASES = IE_PACKAGE_CONFIG_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___SHOULD_REPEAT_INHERITED = IE_PACKAGE_CONFIG_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Should Render Sub Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUB_TYPES = IE_PACKAGE_CONFIG_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Should Render Super Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUPER_TYPES = IE_PACKAGE_CONFIG_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_BOUNDS = IE_PACKAGE_CONFIG_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Get EData Types Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___GET_EDATA_TYPES_POSITION = IE_PACKAGE_CONFIG_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Get EEnums Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___GET_EENUMS_POSITION = IE_PACKAGE_CONFIG_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Get EClasses Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___GET_ECLASSES_POSITION = IE_PACKAGE_CONFIG_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Add EPackages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___ADD_EPACKAGES__LIST = IE_PACKAGE_CONFIG_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Find Config</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___FIND_CONFIG__ENAMEDELEMENT = IE_PACKAGE_CONFIG_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG___GET_TARGET = IE_PACKAGE_CONFIG_OPERATION_COUNT + 18;

	/**
	 * The number of operations of the '<em>Ecore Doc Generator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_CONFIG_OPERATION_COUNT = IE_PACKAGE_CONFIG_OPERATION_COUNT + 19;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl <em>EPackage Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEPackageConfig()
	 * @generated
	 */
	int EPACKAGE_CONFIG = 15;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__RENDER = IE_PACKAGE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__ID = IE_PACKAGE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Position EData Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__POSITION_EDATA_TYPES = IE_PACKAGE_CONFIG__POSITION_EDATA_TYPES;

	/**
	 * The feature id for the '<em><b>Position EEnums</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__POSITION_EENUMS = IE_PACKAGE_CONFIG__POSITION_EENUMS;

	/**
	 * The feature id for the '<em><b>Position EClasses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__POSITION_ECLASSES = IE_PACKAGE_CONFIG__POSITION_ECLASSES;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__RENDER_DEFAULTS = IE_PACKAGE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__RENDER_USE_CASES = IE_PACKAGE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__REPEAT_INHERITED = IE_PACKAGE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Render Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__RENDER_SUB_TYPES = IE_PACKAGE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Render Super Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__RENDER_SUPER_TYPES = IE_PACKAGE_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__RENDER_BOUNDS = IE_PACKAGE_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Target EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__TARGET_EPACKAGE = IE_PACKAGE_CONFIG_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>EData Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__EDATA_TYPES = IE_PACKAGE_CONFIG_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>EEnums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__EENUMS = IE_PACKAGE_CONFIG_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>EClasses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG__ECLASSES = IE_PACKAGE_CONFIG_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>EPackage Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG_FEATURE_COUNT = IE_PACKAGE_CONFIG_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___SHOULD_RENDER = IE_PACKAGE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get EData Types Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___GET_EDATA_TYPES_POSITION = IE_PACKAGE_CONFIG___GET_EDATA_TYPES_POSITION;

	/**
	 * The operation id for the '<em>Get EEnums Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___GET_EENUMS_POSITION = IE_PACKAGE_CONFIG___GET_EENUMS_POSITION;

	/**
	 * The operation id for the '<em>Get EClasses Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___GET_ECLASSES_POSITION = IE_PACKAGE_CONFIG___GET_ECLASSES_POSITION;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_PACKAGE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render Use Cases</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___SHOULD_RENDER_USE_CASES = IE_PACKAGE_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___SHOULD_REPEAT_INHERITED = IE_PACKAGE_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Should Render Sub Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___SHOULD_RENDER_SUB_TYPES = IE_PACKAGE_CONFIG_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Should Render Super Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___SHOULD_RENDER_SUPER_TYPES = IE_PACKAGE_CONFIG_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___SHOULD_RENDER_BOUNDS = IE_PACKAGE_CONFIG_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___GET_TARGET = IE_PACKAGE_CONFIG_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Add EData Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___ADD_EDATA_TYPES__LIST = IE_PACKAGE_CONFIG_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Add EEnums</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___ADD_EENUMS__LIST = IE_PACKAGE_CONFIG_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Add EClasses</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG___ADD_ECLASSES__LIST = IE_PACKAGE_CONFIG_OPERATION_COUNT + 9;

	/**
	 * The number of operations of the '<em>EPackage Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPACKAGE_CONFIG_OPERATION_COUNT = IE_PACKAGE_CONFIG_OPERATION_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EDataTypeConfigImpl <em>EData Type Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EDataTypeConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEDataTypeConfig()
	 * @generated
	 */
	int EDATA_TYPE_CONFIG = 16;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG__RENDER = IE_DATA_TYPE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG__ID = IE_DATA_TYPE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG__RENDER_DEFAULTS = IE_DATA_TYPE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG__RENDER_USE_CASES = IE_DATA_TYPE_CONFIG__RENDER_USE_CASES;

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
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG___SHOULD_RENDER = IE_DATA_TYPE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_DATA_TYPE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Use Cases</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG___SHOULD_RENDER_USE_CASES = IE_DATA_TYPE_CONFIG___SHOULD_RENDER_USE_CASES;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG___GET_TARGET = IE_DATA_TYPE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EData Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_CONFIG_OPERATION_COUNT = IE_DATA_TYPE_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl <em>EEnum Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEEnumConfig()
	 * @generated
	 */
	int EENUM_CONFIG = 17;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__RENDER = IE_ENUM_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__ID = IE_ENUM_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__RENDER_DEFAULTS = IE_ENUM_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__RENDER_USE_CASES = IE_ENUM_CONFIG__RENDER_USE_CASES;

	/**
	 * The feature id for the '<em><b>Target EEnum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__TARGET_EENUM = IE_ENUM_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EEnum Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG__EENUM_LITERALS = IE_ENUM_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EEnum Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG_FEATURE_COUNT = IE_ENUM_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG___SHOULD_RENDER = IE_ENUM_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG___SHOULD_RENDER_DEFAULTS = IE_ENUM_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Use Cases</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG___SHOULD_RENDER_USE_CASES = IE_ENUM_CONFIG___SHOULD_RENDER_USE_CASES;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG___GET_TARGET = IE_ENUM_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Add EEnum Literals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG___ADD_EENUM_LITERALS__LIST = IE_ENUM_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>EEnum Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_CONFIG_OPERATION_COUNT = IE_ENUM_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl <em>EEnum Literal Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEEnumLiteralConfig()
	 * @generated
	 */
	int EENUM_LITERAL_CONFIG = 18;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG__RENDER = IE_ENUM_LITERAL_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG__ID = IE_ENUM_LITERAL_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Target EEnum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL = IE_ENUM_LITERAL_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EEnum Literal Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG_FEATURE_COUNT = IE_ENUM_LITERAL_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG___SHOULD_RENDER = IE_ENUM_LITERAL_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG___GET_TARGET = IE_ENUM_LITERAL_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EEnum Literal Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_CONFIG_OPERATION_COUNT = IE_ENUM_LITERAL_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl <em>EClass Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEClassConfig()
	 * @generated
	 */
	int ECLASS_CONFIG = 19;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__RENDER = IE_CLASS_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__ID = IE_CLASS_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__RENDER_DEFAULTS = IE_CLASS_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__RENDER_USE_CASES = IE_CLASS_CONFIG__RENDER_USE_CASES;

	/**
	 * The feature id for the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__REPEAT_INHERITED = IE_CLASS_CONFIG__REPEAT_INHERITED;

	/**
	 * The feature id for the '<em><b>Render Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__RENDER_SUB_TYPES = IE_CLASS_CONFIG__RENDER_SUB_TYPES;

	/**
	 * The feature id for the '<em><b>Render Super Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__RENDER_SUPER_TYPES = IE_CLASS_CONFIG__RENDER_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__RENDER_BOUNDS = IE_CLASS_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__TARGET_ECLASS = IE_CLASS_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>EAttributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__EATTRIBUTES = IE_CLASS_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>EContainments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__ECONTAINMENTS = IE_CLASS_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>EReferences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__EREFERENCES = IE_CLASS_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG__EOPERATIONS = IE_CLASS_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>EClass Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG_FEATURE_COUNT = IE_CLASS_CONFIG_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_RENDER = IE_CLASS_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_RENDER_DEFAULTS = IE_CLASS_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Use Cases</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_RENDER_USE_CASES = IE_CLASS_CONFIG___SHOULD_RENDER_USE_CASES;

	/**
	 * The operation id for the '<em>Should Repeat Inherited</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_REPEAT_INHERITED = IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED;

	/**
	 * The operation id for the '<em>Should Render Sub Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_RENDER_SUB_TYPES = IE_CLASS_CONFIG___SHOULD_RENDER_SUB_TYPES;

	/**
	 * The operation id for the '<em>Should Render Super Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_RENDER_SUPER_TYPES = IE_CLASS_CONFIG___SHOULD_RENDER_SUPER_TYPES;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___SHOULD_RENDER_BOUNDS = IE_CLASS_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___GET_TARGET = IE_CLASS_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Add EAttributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___ADD_EATTRIBUTES__LIST = IE_CLASS_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Add EContainments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___ADD_ECONTAINMENTS__LIST = IE_CLASS_CONFIG_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Add EReferences</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___ADD_EREFERENCES__LIST = IE_CLASS_CONFIG_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Add EOperations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG___ADD_EOPERATIONS__LIST = IE_CLASS_CONFIG_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>EClass Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_CONFIG_OPERATION_COUNT = IE_CLASS_CONFIG_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EAttributeConfigImpl <em>EAttribute Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EAttributeConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEAttributeConfig()
	 * @generated
	 */
	int EATTRIBUTE_CONFIG = 20;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__RENDER = IE_ATTRIBUTE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__ID = IE_ATTRIBUTE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__RENDER_DEFAULTS = IE_ATTRIBUTE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__RENDER_BOUNDS = IE_ATTRIBUTE_CONFIG__RENDER_BOUNDS;

	/**
	 * The feature id for the '<em><b>Target EAttribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG__TARGET_EATTRIBUTE = IE_ATTRIBUTE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EAttribute Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG_FEATURE_COUNT = IE_ATTRIBUTE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG___SHOULD_RENDER = IE_ATTRIBUTE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_ATTRIBUTE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG___SHOULD_RENDER_BOUNDS = IE_ATTRIBUTE_CONFIG___SHOULD_RENDER_BOUNDS;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG___GET_TARGET = IE_ATTRIBUTE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EAttribute Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_CONFIG_OPERATION_COUNT = IE_ATTRIBUTE_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.AEReferenceConfigImpl <em>AE Reference Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.AEReferenceConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getAEReferenceConfig()
	 * @generated
	 */
	int AE_REFERENCE_CONFIG = 21;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG__RENDER = IE_REFERENCE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG__ID = IE_REFERENCE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG__RENDER_DEFAULTS = IE_REFERENCE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG__RENDER_BOUNDS = IE_REFERENCE_CONFIG__RENDER_BOUNDS;

	/**
	 * The number of structural features of the '<em>AE Reference Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG_FEATURE_COUNT = IE_REFERENCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG___SHOULD_RENDER = IE_REFERENCE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG___GET_TARGET = IE_REFERENCE_CONFIG___GET_TARGET;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS = IE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG___SHOULD_RENDER_BOUNDS = IE_REFERENCE_CONFIG___SHOULD_RENDER_BOUNDS;

	/**
	 * The number of operations of the '<em>AE Reference Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AE_REFERENCE_CONFIG_OPERATION_COUNT = IE_REFERENCE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EContainmentConfigImpl <em>EContainment Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EContainmentConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEContainmentConfig()
	 * @generated
	 */
	int ECONTAINMENT_CONFIG = 22;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG__RENDER = AE_REFERENCE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG__ID = AE_REFERENCE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG__RENDER_DEFAULTS = AE_REFERENCE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG__RENDER_BOUNDS = AE_REFERENCE_CONFIG__RENDER_BOUNDS;

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
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG___SHOULD_RENDER = AE_REFERENCE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG___SHOULD_RENDER_DEFAULTS = AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTAINMENT_CONFIG___SHOULD_RENDER_BOUNDS = AE_REFERENCE_CONFIG___SHOULD_RENDER_BOUNDS;

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
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EReferenceConfigImpl <em>EReference Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EReferenceConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEReferenceConfig()
	 * @generated
	 */
	int EREFERENCE_CONFIG = 23;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG__RENDER = AE_REFERENCE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG__ID = AE_REFERENCE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG__RENDER_DEFAULTS = AE_REFERENCE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG__RENDER_BOUNDS = AE_REFERENCE_CONFIG__RENDER_BOUNDS;

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
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG___SHOULD_RENDER = AE_REFERENCE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS = AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_CONFIG___SHOULD_RENDER_BOUNDS = AE_REFERENCE_CONFIG___SHOULD_RENDER_BOUNDS;

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
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EOperationConfigImpl <em>EOperation Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EOperationConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEOperationConfig()
	 * @generated
	 */
	int EOPERATION_CONFIG = 24;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG__RENDER = AE_REFERENCE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG__ID = AE_REFERENCE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG__RENDER_DEFAULTS = AE_REFERENCE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG__RENDER_BOUNDS = AE_REFERENCE_CONFIG__RENDER_BOUNDS;

	/**
	 * The feature id for the '<em><b>Target EOperation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG__TARGET_EOPERATION = AE_REFERENCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EParameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG__EPARAMETERS = AE_REFERENCE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EOperation Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG_FEATURE_COUNT = AE_REFERENCE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG___SHOULD_RENDER = AE_REFERENCE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG___SHOULD_RENDER_DEFAULTS = AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG___SHOULD_RENDER_BOUNDS = AE_REFERENCE_CONFIG___SHOULD_RENDER_BOUNDS;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG___GET_TARGET = AE_REFERENCE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Add EParameters</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG___ADD_EPARAMETERS__LIST = AE_REFERENCE_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG___GET_ID = AE_REFERENCE_CONFIG_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Join Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG___JOIN_ID__EOPERATION = AE_REFERENCE_CONFIG_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>EOperation Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATION_CONFIG_OPERATION_COUNT = AE_REFERENCE_CONFIG_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EParameterConfigImpl <em>EParameter Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EParameterConfigImpl
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEParameterConfig()
	 * @generated
	 */
	int EPARAMETER_CONFIG = 25;

	/**
	 * The feature id for the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG__RENDER = AE_REFERENCE_CONFIG__RENDER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG__ID = AE_REFERENCE_CONFIG__ID;

	/**
	 * The feature id for the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG__RENDER_DEFAULTS = AE_REFERENCE_CONFIG__RENDER_DEFAULTS;

	/**
	 * The feature id for the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG__RENDER_BOUNDS = AE_REFERENCE_CONFIG__RENDER_BOUNDS;

	/**
	 * The feature id for the '<em><b>Target EParameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG__TARGET_EPARAMETER = AE_REFERENCE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EParameter Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG_FEATURE_COUNT = AE_REFERENCE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Should Render</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG___SHOULD_RENDER = AE_REFERENCE_CONFIG___SHOULD_RENDER;

	/**
	 * The operation id for the '<em>Should Render Defaults</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG___SHOULD_RENDER_DEFAULTS = AE_REFERENCE_CONFIG___SHOULD_RENDER_DEFAULTS;

	/**
	 * The operation id for the '<em>Should Render Bounds</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG___SHOULD_RENDER_BOUNDS = AE_REFERENCE_CONFIG___SHOULD_RENDER_BOUNDS;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG___GET_TARGET = AE_REFERENCE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EParameter Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPARAMETER_CONFIG_OPERATION_COUNT = AE_REFERENCE_CONFIG_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link java.util.List <em>List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getList()
	 * @generated
	 */
	int LIST = 26;

	/**
	 * The number of structural features of the '<em>List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig <em>IE Named Element Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Named Element Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig
	 * @generated
	 */
	EClass getIENamedElementConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#isRender <em>Render</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#isRender()
	 * @see #getIENamedElementConfig()
	 * @generated
	 */
	EAttribute getIENamedElementConfig_Render();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#getId()
	 * @see #getIENamedElementConfig()
	 * @generated
	 */
	EAttribute getIENamedElementConfig_Id();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#shouldRender() <em>Should Render</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#shouldRender()
	 * @generated
	 */
	EOperation getIENamedElementConfig__ShouldRender();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#getTarget()
	 * @generated
	 */
	EOperation getIENamedElementConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig <em>IDefault Value Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDefault Value Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig
	 * @generated
	 */
	EClass getIDefaultValueConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig#isRenderDefaults <em>Render Defaults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render Defaults</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig#isRenderDefaults()
	 * @see #getIDefaultValueConfig()
	 * @generated
	 */
	EAttribute getIDefaultValueConfig_RenderDefaults();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig#shouldRenderDefaults() <em>Should Render Defaults</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Defaults</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig#shouldRenderDefaults()
	 * @generated
	 */
	EOperation getIDefaultValueConfig__ShouldRenderDefaults();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig <em>IE Classifier Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Classifier Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig
	 * @generated
	 */
	EClass getIEClassifierConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig#isRenderUseCases <em>Render Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render Use Cases</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig#isRenderUseCases()
	 * @see #getIEClassifierConfig()
	 * @generated
	 */
	EAttribute getIEClassifierConfig_RenderUseCases();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig#shouldRenderUseCases() <em>Should Render Use Cases</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Use Cases</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig#shouldRenderUseCases()
	 * @generated
	 */
	EOperation getIEClassifierConfig__ShouldRenderUseCases();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig <em>IE Data Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Data Type Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig
	 * @generated
	 */
	EClass getIEDataTypeConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig <em>IE Enum Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Enum Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig
	 * @generated
	 */
	EClass getIEEnumConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig <em>IE Class Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Class Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig
	 * @generated
	 */
	EClass getIEClassConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repeat Inherited</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRepeatInherited()
	 * @see #getIEClassConfig()
	 * @generated
	 */
	EAttribute getIEClassConfig_RepeatInherited();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSubTypes <em>Render Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render Sub Types</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSubTypes()
	 * @see #getIEClassConfig()
	 * @generated
	 */
	EAttribute getIEClassConfig_RenderSubTypes();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSuperTypes <em>Render Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render Super Types</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSuperTypes()
	 * @see #getIEClassConfig()
	 * @generated
	 */
	EAttribute getIEClassConfig_RenderSuperTypes();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#shouldRepeatInherited() <em>Should Repeat Inherited</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Repeat Inherited</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#shouldRepeatInherited()
	 * @generated
	 */
	EOperation getIEClassConfig__ShouldRepeatInherited();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#shouldRenderSubTypes() <em>Should Render Sub Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Sub Types</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#shouldRenderSubTypes()
	 * @generated
	 */
	EOperation getIEClassConfig__ShouldRenderSubTypes();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#shouldRenderSuperTypes() <em>Should Render Super Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Super Types</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#shouldRenderSuperTypes()
	 * @generated
	 */
	EOperation getIEClassConfig__ShouldRenderSuperTypes();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig <em>IE Typed Element Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Typed Element Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig
	 * @generated
	 */
	EClass getIETypedElementConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig#isRenderBounds <em>Render Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render Bounds</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig#isRenderBounds()
	 * @see #getIETypedElementConfig()
	 * @generated
	 */
	EAttribute getIETypedElementConfig_RenderBounds();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig#shouldRenderBounds() <em>Should Render Bounds</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Bounds</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig#shouldRenderBounds()
	 * @generated
	 */
	EOperation getIETypedElementConfig__ShouldRenderBounds();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig <em>IE Structural Feature Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Structural Feature Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig
	 * @generated
	 */
	EClass getIEStructuralFeatureConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig <em>IE Attribute Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Attribute Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig
	 * @generated
	 */
	EClass getIEAttributeConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig <em>IE Reference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Reference Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig
	 * @generated
	 */
	EClass getIEReferenceConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig <em>IE Operation Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Operation Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig
	 * @generated
	 */
	EClass getIEOperationConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig <em>IE Parameter Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Parameter Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig
	 * @generated
	 */
	EClass getIEParameterConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig <em>IE Package Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Package Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig
	 * @generated
	 */
	EClass getIEPackageConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getPositionEDataTypes <em>Position EData Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position EData Types</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getPositionEDataTypes()
	 * @see #getIEPackageConfig()
	 * @generated
	 */
	EAttribute getIEPackageConfig_PositionEDataTypes();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getPositionEEnums <em>Position EEnums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position EEnums</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getPositionEEnums()
	 * @see #getIEPackageConfig()
	 * @generated
	 */
	EAttribute getIEPackageConfig_PositionEEnums();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getPositionEClasses <em>Position EClasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position EClasses</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getPositionEClasses()
	 * @see #getIEPackageConfig()
	 * @generated
	 */
	EAttribute getIEPackageConfig_PositionEClasses();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getEDataTypesPosition() <em>Get EData Types Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EData Types Position</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getEDataTypesPosition()
	 * @generated
	 */
	EOperation getIEPackageConfig__GetEDataTypesPosition();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getEEnumsPosition() <em>Get EEnums Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EEnums Position</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getEEnumsPosition()
	 * @generated
	 */
	EOperation getIEPackageConfig__GetEEnumsPosition();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getEClassesPosition() <em>Get EClasses Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EClasses Position</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig#getEClassesPosition()
	 * @generated
	 */
	EOperation getIEPackageConfig__GetEClassesPosition();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig <em>IE Enum Literal Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Enum Literal Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig
	 * @generated
	 */
	EClass getIEEnumLiteralConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig <em>Ecore Doc Generator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Doc Generator Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
	 * @generated
	 */
	EClass getEcoreDocGeneratorConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getDocumentTitle <em>Document Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Document Title</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getDocumentTitle()
	 * @see #getEcoreDocGeneratorConfig()
	 * @generated
	 */
	EAttribute getEcoreDocGeneratorConfig_DocumentTitle();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEPackages <em>EPackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EPackages</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEPackages()
	 * @see #getEcoreDocGeneratorConfig()
	 * @generated
	 */
	EReference getEcoreDocGeneratorConfig_EPackages();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRender() <em>Should Render</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRender()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__ShouldRender();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderDefaults() <em>Should Render Defaults</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Defaults</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderDefaults()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__ShouldRenderDefaults();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderUseCases() <em>Should Render Use Cases</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Use Cases</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderUseCases()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__ShouldRenderUseCases();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRepeatInherited() <em>Should Repeat Inherited</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Repeat Inherited</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRepeatInherited()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__ShouldRepeatInherited();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderSubTypes() <em>Should Render Sub Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Sub Types</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderSubTypes()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__ShouldRenderSubTypes();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderSuperTypes() <em>Should Render Super Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Super Types</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderSuperTypes()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__ShouldRenderSuperTypes();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderBounds() <em>Should Render Bounds</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Should Render Bounds</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#shouldRenderBounds()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__ShouldRenderBounds();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEDataTypesPosition() <em>Get EData Types Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EData Types Position</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEDataTypesPosition()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__GetEDataTypesPosition();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEEnumsPosition() <em>Get EEnums Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EEnums Position</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEEnumsPosition()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__GetEEnumsPosition();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEClassesPosition() <em>Get EClasses Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EClasses Position</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEClassesPosition()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__GetEClassesPosition();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#addEPackages(java.util.List) <em>Add EPackages</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EPackages</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#addEPackages(java.util.List)
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__AddEPackages__List();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#findConfig(org.eclipse.emf.ecore.ENamedElement) <em>Find Config</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Config</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#findConfig(org.eclipse.emf.ecore.ENamedElement)
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__FindConfig__ENamedElement();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getTarget()
	 * @generated
	 */
	EOperation getEcoreDocGeneratorConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig <em>EPackage Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPackage Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig
	 * @generated
	 */
	EClass getEPackageConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getTargetEPackage <em>Target EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EPackage</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getTargetEPackage()
	 * @see #getEPackageConfig()
	 * @generated
	 */
	EReference getEPackageConfig_TargetEPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getEDataTypes <em>EData Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EData Types</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getEDataTypes()
	 * @see #getEPackageConfig()
	 * @generated
	 */
	EReference getEPackageConfig_EDataTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getEEnums <em>EEnums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EEnums</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getEEnums()
	 * @see #getEPackageConfig()
	 * @generated
	 */
	EReference getEPackageConfig_EEnums();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getEClasses <em>EClasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EClasses</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getEClasses()
	 * @see #getEPackageConfig()
	 * @generated
	 */
	EReference getEPackageConfig_EClasses();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getTarget()
	 * @generated
	 */
	EOperation getEPackageConfig__GetTarget();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#addEDataTypes(java.util.List) <em>Add EData Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EData Types</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#addEDataTypes(java.util.List)
	 * @generated
	 */
	EOperation getEPackageConfig__AddEDataTypes__List();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#addEEnums(java.util.List) <em>Add EEnums</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EEnums</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#addEEnums(java.util.List)
	 * @generated
	 */
	EOperation getEPackageConfig__AddEEnums__List();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#addEClasses(java.util.List) <em>Add EClasses</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EClasses</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#addEClasses(java.util.List)
	 * @generated
	 */
	EOperation getEPackageConfig__AddEClasses__List();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig <em>EData Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EData Type Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig
	 * @generated
	 */
	EClass getEDataTypeConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig#getTargetEDataType <em>Target EData Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EData Type</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig#getTargetEDataType()
	 * @see #getEDataTypeConfig()
	 * @generated
	 */
	EReference getEDataTypeConfig_TargetEDataType();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig#getTarget()
	 * @generated
	 */
	EOperation getEDataTypeConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig <em>EEnum Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEnum Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumConfig
	 * @generated
	 */
	EClass getEEnumConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#getTargetEEnum <em>Target EEnum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EEnum</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#getTargetEEnum()
	 * @see #getEEnumConfig()
	 * @generated
	 */
	EReference getEEnumConfig_TargetEEnum();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#getEEnumLiterals <em>EEnum Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EEnum Literals</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#getEEnumLiterals()
	 * @see #getEEnumConfig()
	 * @generated
	 */
	EReference getEEnumConfig_EEnumLiterals();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#getTarget()
	 * @generated
	 */
	EOperation getEEnumConfig__GetTarget();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#addEEnumLiterals(java.util.List) <em>Add EEnum Literals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EEnum Literals</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#addEEnumLiterals(java.util.List)
	 * @generated
	 */
	EOperation getEEnumConfig__AddEEnumLiterals__List();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig <em>EEnum Literal Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEnum Literal Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig
	 * @generated
	 */
	EClass getEEnumLiteralConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig#getTargetEEnumLiteral <em>Target EEnum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EEnum Literal</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig#getTargetEEnumLiteral()
	 * @see #getEEnumLiteralConfig()
	 * @generated
	 */
	EReference getEEnumLiteralConfig_TargetEEnumLiteral();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig#getTarget()
	 * @generated
	 */
	EOperation getEEnumLiteralConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig <em>EClass Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClass Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig
	 * @generated
	 */
	EClass getEClassConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getTargetEClass <em>Target EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EClass</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getTargetEClass()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_TargetEClass();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEAttributes <em>EAttributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EAttributes</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEAttributes()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_EAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEContainments <em>EContainments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EContainments</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEContainments()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_EContainments();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEReferences <em>EReferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EReferences</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEReferences()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_EReferences();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEOperations <em>EOperations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EOperations</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEOperations()
	 * @see #getEClassConfig()
	 * @generated
	 */
	EReference getEClassConfig_EOperations();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getTarget()
	 * @generated
	 */
	EOperation getEClassConfig__GetTarget();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#addEAttributes(java.util.List) <em>Add EAttributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EAttributes</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#addEAttributes(java.util.List)
	 * @generated
	 */
	EOperation getEClassConfig__AddEAttributes__List();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#addEContainments(java.util.List) <em>Add EContainments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EContainments</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#addEContainments(java.util.List)
	 * @generated
	 */
	EOperation getEClassConfig__AddEContainments__List();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#addEReferences(java.util.List) <em>Add EReferences</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EReferences</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#addEReferences(java.util.List)
	 * @generated
	 */
	EOperation getEClassConfig__AddEReferences__List();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#addEOperations(java.util.List) <em>Add EOperations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EOperations</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig#addEOperations(java.util.List)
	 * @generated
	 */
	EOperation getEClassConfig__AddEOperations__List();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig <em>EAttribute Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAttribute Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig
	 * @generated
	 */
	EClass getEAttributeConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig#getTargetEAttribute <em>Target EAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EAttribute</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig#getTargetEAttribute()
	 * @see #getEAttributeConfig()
	 * @generated
	 */
	EReference getEAttributeConfig_TargetEAttribute();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig#getTarget()
	 * @generated
	 */
	EOperation getEAttributeConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.AEReferenceConfig <em>AE Reference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AE Reference Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.AEReferenceConfig
	 * @generated
	 */
	EClass getAEReferenceConfig();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig <em>EContainment Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EContainment Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig
	 * @generated
	 */
	EClass getEContainmentConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig#getTargetEContainment <em>Target EContainment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EContainment</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig#getTargetEContainment()
	 * @see #getEContainmentConfig()
	 * @generated
	 */
	EReference getEContainmentConfig_TargetEContainment();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig#getTarget()
	 * @generated
	 */
	EOperation getEContainmentConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig <em>EReference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EReference Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig
	 * @generated
	 */
	EClass getEReferenceConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig#getTargetEReference <em>Target EReference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EReference</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig#getTargetEReference()
	 * @see #getEReferenceConfig()
	 * @generated
	 */
	EReference getEReferenceConfig_TargetEReference();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig#getTarget()
	 * @generated
	 */
	EOperation getEReferenceConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig <em>EOperation Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EOperation Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EOperationConfig
	 * @generated
	 */
	EClass getEOperationConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getTargetEOperation <em>Target EOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EOperation</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getTargetEOperation()
	 * @see #getEOperationConfig()
	 * @generated
	 */
	EReference getEOperationConfig_TargetEOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getEParameters <em>EParameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EParameters</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getEParameters()
	 * @see #getEOperationConfig()
	 * @generated
	 */
	EReference getEOperationConfig_EParameters();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getTarget()
	 * @generated
	 */
	EOperation getEOperationConfig__GetTarget();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#addEParameters(java.util.List) <em>Add EParameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add EParameters</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#addEParameters(java.util.List)
	 * @generated
	 */
	EOperation getEOperationConfig__AddEParameters__List();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getId() <em>Get Id</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Id</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getId()
	 * @generated
	 */
	EOperation getEOperationConfig__GetId();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#joinId(org.eclipse.emf.ecore.EOperation) <em>Join Id</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Join Id</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#joinId(org.eclipse.emf.ecore.EOperation)
	 * @generated
	 */
	EOperation getEOperationConfig__JoinId__EOperation();

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.config.EParameterConfig <em>EParameter Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EParameter Config</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EParameterConfig
	 * @generated
	 */
	EClass getEParameterConfig();

	/**
	 * Returns the meta object for the reference '{@link com.altran.general.emf.ecoredoc.generator.config.EParameterConfig#getTargetEParameter <em>Target EParameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EParameter</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EParameterConfig#getTargetEParameter()
	 * @see #getEParameterConfig()
	 * @generated
	 */
	EReference getEParameterConfig_TargetEParameter();

	/**
	 * Returns the meta object for the '{@link com.altran.general.emf.ecoredoc.generator.config.EParameterConfig#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EParameterConfig#getTarget()
	 * @generated
	 */
	EOperation getEParameterConfig__GetTarget();

	/**
	 * Returns the meta object for class '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List" typeParameters="T"
	 *        annotation="http://altran.com/general/emf/ecoredoc/generator/config/0.1 render='false'"
	 * @generated
	 */
	EClass getList();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EcoreDocConfigFactory getEcoreDocConfigFactory();

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
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig <em>IE Named Element Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIENamedElementConfig()
		 * @generated
		 */
		EClass IE_NAMED_ELEMENT_CONFIG = eINSTANCE.getIENamedElementConfig();

		/**
		 * The meta object literal for the '<em><b>Render</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_NAMED_ELEMENT_CONFIG__RENDER = eINSTANCE.getIENamedElementConfig_Render();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_NAMED_ELEMENT_CONFIG__ID = eINSTANCE.getIENamedElementConfig_Id();

		/**
		 * The meta object literal for the '<em><b>Should Render</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_NAMED_ELEMENT_CONFIG___SHOULD_RENDER = eINSTANCE.getIENamedElementConfig__ShouldRender();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_NAMED_ELEMENT_CONFIG___GET_TARGET = eINSTANCE.getIENamedElementConfig__GetTarget();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig <em>IDefault Value Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIDefaultValueConfig()
		 * @generated
		 */
		EClass IDEFAULT_VALUE_CONFIG = eINSTANCE.getIDefaultValueConfig();

		/**
		 * The meta object literal for the '<em><b>Render Defaults</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS = eINSTANCE.getIDefaultValueConfig_RenderDefaults();

		/**
		 * The meta object literal for the '<em><b>Should Render Defaults</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS = eINSTANCE.getIDefaultValueConfig__ShouldRenderDefaults();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig <em>IE Classifier Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEClassifierConfig()
		 * @generated
		 */
		EClass IE_CLASSIFIER_CONFIG = eINSTANCE.getIEClassifierConfig();

		/**
		 * The meta object literal for the '<em><b>Render Use Cases</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_CLASSIFIER_CONFIG__RENDER_USE_CASES = eINSTANCE.getIEClassifierConfig_RenderUseCases();

		/**
		 * The meta object literal for the '<em><b>Should Render Use Cases</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_CLASSIFIER_CONFIG___SHOULD_RENDER_USE_CASES = eINSTANCE.getIEClassifierConfig__ShouldRenderUseCases();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig <em>IE Data Type Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEDataTypeConfig()
		 * @generated
		 */
		EClass IE_DATA_TYPE_CONFIG = eINSTANCE.getIEDataTypeConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig <em>IE Enum Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEEnumConfig()
		 * @generated
		 */
		EClass IE_ENUM_CONFIG = eINSTANCE.getIEEnumConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig <em>IE Class Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEClassConfig()
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
		 * The meta object literal for the '<em><b>Render Sub Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_CLASS_CONFIG__RENDER_SUB_TYPES = eINSTANCE.getIEClassConfig_RenderSubTypes();

		/**
		 * The meta object literal for the '<em><b>Render Super Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_CLASS_CONFIG__RENDER_SUPER_TYPES = eINSTANCE.getIEClassConfig_RenderSuperTypes();

		/**
		 * The meta object literal for the '<em><b>Should Repeat Inherited</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED = eINSTANCE.getIEClassConfig__ShouldRepeatInherited();

		/**
		 * The meta object literal for the '<em><b>Should Render Sub Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_CLASS_CONFIG___SHOULD_RENDER_SUB_TYPES = eINSTANCE.getIEClassConfig__ShouldRenderSubTypes();

		/**
		 * The meta object literal for the '<em><b>Should Render Super Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_CLASS_CONFIG___SHOULD_RENDER_SUPER_TYPES = eINSTANCE.getIEClassConfig__ShouldRenderSuperTypes();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig <em>IE Typed Element Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIETypedElementConfig()
		 * @generated
		 */
		EClass IE_TYPED_ELEMENT_CONFIG = eINSTANCE.getIETypedElementConfig();

		/**
		 * The meta object literal for the '<em><b>Render Bounds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_TYPED_ELEMENT_CONFIG__RENDER_BOUNDS = eINSTANCE.getIETypedElementConfig_RenderBounds();

		/**
		 * The meta object literal for the '<em><b>Should Render Bounds</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_BOUNDS = eINSTANCE.getIETypedElementConfig__ShouldRenderBounds();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig <em>IE Structural Feature Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEStructuralFeatureConfig()
		 * @generated
		 */
		EClass IE_STRUCTURAL_FEATURE_CONFIG = eINSTANCE.getIEStructuralFeatureConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig <em>IE Attribute Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEAttributeConfig()
		 * @generated
		 */
		EClass IE_ATTRIBUTE_CONFIG = eINSTANCE.getIEAttributeConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig <em>IE Reference Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEReferenceConfig()
		 * @generated
		 */
		EClass IE_REFERENCE_CONFIG = eINSTANCE.getIEReferenceConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig <em>IE Operation Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEOperationConfig()
		 * @generated
		 */
		EClass IE_OPERATION_CONFIG = eINSTANCE.getIEOperationConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig <em>IE Parameter Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEParameterConfig()
		 * @generated
		 */
		EClass IE_PARAMETER_CONFIG = eINSTANCE.getIEParameterConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig <em>IE Package Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEPackageConfig()
		 * @generated
		 */
		EClass IE_PACKAGE_CONFIG = eINSTANCE.getIEPackageConfig();

		/**
		 * The meta object literal for the '<em><b>Position EData Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_PACKAGE_CONFIG__POSITION_EDATA_TYPES = eINSTANCE.getIEPackageConfig_PositionEDataTypes();

		/**
		 * The meta object literal for the '<em><b>Position EEnums</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_PACKAGE_CONFIG__POSITION_EENUMS = eINSTANCE.getIEPackageConfig_PositionEEnums();

		/**
		 * The meta object literal for the '<em><b>Position EClasses</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IE_PACKAGE_CONFIG__POSITION_ECLASSES = eINSTANCE.getIEPackageConfig_PositionEClasses();

		/**
		 * The meta object literal for the '<em><b>Get EData Types Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_PACKAGE_CONFIG___GET_EDATA_TYPES_POSITION = eINSTANCE.getIEPackageConfig__GetEDataTypesPosition();

		/**
		 * The meta object literal for the '<em><b>Get EEnums Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_PACKAGE_CONFIG___GET_EENUMS_POSITION = eINSTANCE.getIEPackageConfig__GetEEnumsPosition();

		/**
		 * The meta object literal for the '<em><b>Get EClasses Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IE_PACKAGE_CONFIG___GET_ECLASSES_POSITION = eINSTANCE.getIEPackageConfig__GetEClassesPosition();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig <em>IE Enum Literal Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getIEEnumLiteralConfig()
		 * @generated
		 */
		EClass IE_ENUM_LITERAL_CONFIG = eINSTANCE.getIEEnumLiteralConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl <em>Ecore Doc Generator Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEcoreDocGeneratorConfig()
		 * @generated
		 */
		EClass ECORE_DOC_GENERATOR_CONFIG = eINSTANCE.getEcoreDocGeneratorConfig();

		/**
		 * The meta object literal for the '<em><b>Document Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_DOC_GENERATOR_CONFIG__DOCUMENT_TITLE = eINSTANCE.getEcoreDocGeneratorConfig_DocumentTitle();

		/**
		 * The meta object literal for the '<em><b>EPackages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_DOC_GENERATOR_CONFIG__EPACKAGES = eINSTANCE.getEcoreDocGeneratorConfig_EPackages();

		/**
		 * The meta object literal for the '<em><b>Should Render</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER = eINSTANCE.getEcoreDocGeneratorConfig__ShouldRender();

		/**
		 * The meta object literal for the '<em><b>Should Render Defaults</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS = eINSTANCE.getEcoreDocGeneratorConfig__ShouldRenderDefaults();

		/**
		 * The meta object literal for the '<em><b>Should Render Use Cases</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_USE_CASES = eINSTANCE.getEcoreDocGeneratorConfig__ShouldRenderUseCases();

		/**
		 * The meta object literal for the '<em><b>Should Repeat Inherited</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___SHOULD_REPEAT_INHERITED = eINSTANCE.getEcoreDocGeneratorConfig__ShouldRepeatInherited();

		/**
		 * The meta object literal for the '<em><b>Should Render Sub Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUB_TYPES = eINSTANCE.getEcoreDocGeneratorConfig__ShouldRenderSubTypes();

		/**
		 * The meta object literal for the '<em><b>Should Render Super Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUPER_TYPES = eINSTANCE.getEcoreDocGeneratorConfig__ShouldRenderSuperTypes();

		/**
		 * The meta object literal for the '<em><b>Should Render Bounds</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_BOUNDS = eINSTANCE.getEcoreDocGeneratorConfig__ShouldRenderBounds();

		/**
		 * The meta object literal for the '<em><b>Get EData Types Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___GET_EDATA_TYPES_POSITION = eINSTANCE.getEcoreDocGeneratorConfig__GetEDataTypesPosition();

		/**
		 * The meta object literal for the '<em><b>Get EEnums Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___GET_EENUMS_POSITION = eINSTANCE.getEcoreDocGeneratorConfig__GetEEnumsPosition();

		/**
		 * The meta object literal for the '<em><b>Get EClasses Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___GET_ECLASSES_POSITION = eINSTANCE.getEcoreDocGeneratorConfig__GetEClassesPosition();

		/**
		 * The meta object literal for the '<em><b>Add EPackages</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECORE_DOC_GENERATOR_CONFIG___ADD_EPACKAGES__LIST = eINSTANCE.getEcoreDocGeneratorConfig__AddEPackages__List();

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
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl <em>EPackage Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EPackageConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEPackageConfig()
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
		 * The meta object literal for the '<em><b>Add EData Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPACKAGE_CONFIG___ADD_EDATA_TYPES__LIST = eINSTANCE.getEPackageConfig__AddEDataTypes__List();

		/**
		 * The meta object literal for the '<em><b>Add EEnums</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPACKAGE_CONFIG___ADD_EENUMS__LIST = eINSTANCE.getEPackageConfig__AddEEnums__List();

		/**
		 * The meta object literal for the '<em><b>Add EClasses</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPACKAGE_CONFIG___ADD_ECLASSES__LIST = eINSTANCE.getEPackageConfig__AddEClasses__List();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EDataTypeConfigImpl <em>EData Type Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EDataTypeConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEDataTypeConfig()
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
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl <em>EEnum Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EEnumConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEEnumConfig()
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
		 * The meta object literal for the '<em><b>Add EEnum Literals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EENUM_CONFIG___ADD_EENUM_LITERALS__LIST = eINSTANCE.getEEnumConfig__AddEEnumLiterals__List();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl <em>EEnum Literal Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EEnumLiteralConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEEnumLiteralConfig()
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
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl <em>EClass Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EClassConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEClassConfig()
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
		 * The meta object literal for the '<em><b>EOperations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_CONFIG__EOPERATIONS = eINSTANCE.getEClassConfig_EOperations();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECLASS_CONFIG___GET_TARGET = eINSTANCE.getEClassConfig__GetTarget();

		/**
		 * The meta object literal for the '<em><b>Add EAttributes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECLASS_CONFIG___ADD_EATTRIBUTES__LIST = eINSTANCE.getEClassConfig__AddEAttributes__List();

		/**
		 * The meta object literal for the '<em><b>Add EContainments</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECLASS_CONFIG___ADD_ECONTAINMENTS__LIST = eINSTANCE.getEClassConfig__AddEContainments__List();

		/**
		 * The meta object literal for the '<em><b>Add EReferences</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECLASS_CONFIG___ADD_EREFERENCES__LIST = eINSTANCE.getEClassConfig__AddEReferences__List();

		/**
		 * The meta object literal for the '<em><b>Add EOperations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ECLASS_CONFIG___ADD_EOPERATIONS__LIST = eINSTANCE.getEClassConfig__AddEOperations__List();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EAttributeConfigImpl <em>EAttribute Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EAttributeConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEAttributeConfig()
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
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.AEReferenceConfigImpl <em>AE Reference Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.AEReferenceConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getAEReferenceConfig()
		 * @generated
		 */
		EClass AE_REFERENCE_CONFIG = eINSTANCE.getAEReferenceConfig();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EContainmentConfigImpl <em>EContainment Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EContainmentConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEContainmentConfig()
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
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EReferenceConfigImpl <em>EReference Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EReferenceConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEReferenceConfig()
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

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EOperationConfigImpl <em>EOperation Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EOperationConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEOperationConfig()
		 * @generated
		 */
		EClass EOPERATION_CONFIG = eINSTANCE.getEOperationConfig();

		/**
		 * The meta object literal for the '<em><b>Target EOperation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOPERATION_CONFIG__TARGET_EOPERATION = eINSTANCE.getEOperationConfig_TargetEOperation();

		/**
		 * The meta object literal for the '<em><b>EParameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOPERATION_CONFIG__EPARAMETERS = eINSTANCE.getEOperationConfig_EParameters();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EOPERATION_CONFIG___GET_TARGET = eINSTANCE.getEOperationConfig__GetTarget();

		/**
		 * The meta object literal for the '<em><b>Add EParameters</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EOPERATION_CONFIG___ADD_EPARAMETERS__LIST = eINSTANCE.getEOperationConfig__AddEParameters__List();

		/**
		 * The meta object literal for the '<em><b>Get Id</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EOPERATION_CONFIG___GET_ID = eINSTANCE.getEOperationConfig__GetId();

		/**
		 * The meta object literal for the '<em><b>Join Id</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EOPERATION_CONFIG___JOIN_ID__EOPERATION = eINSTANCE.getEOperationConfig__JoinId__EOperation();

		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.config.impl.EParameterConfigImpl <em>EParameter Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EParameterConfigImpl
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getEParameterConfig()
		 * @generated
		 */
		EClass EPARAMETER_CONFIG = eINSTANCE.getEParameterConfig();

		/**
		 * The meta object literal for the '<em><b>Target EParameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPARAMETER_CONFIG__TARGET_EPARAMETER = eINSTANCE.getEParameterConfig_TargetEParameter();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPARAMETER_CONFIG___GET_TARGET = eINSTANCE.getEParameterConfig__GetTarget();

		/**
		 * The meta object literal for the '{@link java.util.List <em>List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see com.altran.general.emf.ecoredoc.generator.config.impl.EcoreDocConfigPackageImpl#getList()
		 * @generated
		 */
		EClass LIST = eINSTANCE.getList();

	}

} //EcoreDocConfigPackage
