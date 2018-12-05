/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.AEReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig;
import com.altran.general.emf.ecoredoc.generator.config.EOperationConfig;
import com.altran.general.emf.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.emf.ecoredoc.generator.config.EParameterConfig;
import com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigFactory;
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
import com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig;
import com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
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
public class EcoreDocConfigPackageImpl extends EPackageImpl implements EcoreDocConfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieNamedElementConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDefaultValueConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieClassifierConfigEClass = null;

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
	private EClass ieEnumConfigEClass = null;

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
	private EClass ieTypedElementConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieStructuralFeatureConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieAttributeConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieReferenceConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieOperationConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieParameterConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iePackageConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ieEnumLiteralConfigEClass = null;

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
	private EClass eClassConfigEClass = null;

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
	private EClass aeReferenceConfigEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eOperationConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eParameterConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listEClass = null;

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
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EcoreDocConfigPackageImpl() {
		super(eNS_URI, EcoreDocConfigFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EcoreDocConfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EcoreDocConfigPackage init() {
		if (isInited) return (EcoreDocConfigPackage)EPackage.Registry.INSTANCE.getEPackage(EcoreDocConfigPackage.eNS_URI);

		// Obtain or create and register package
		EcoreDocConfigPackageImpl theEcoreDocConfigPackage = (EcoreDocConfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcoreDocConfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcoreDocConfigPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEcoreDocConfigPackage.createPackageContents();

		// Initialize created meta-data
		theEcoreDocConfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEcoreDocConfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EcoreDocConfigPackage.eNS_URI, theEcoreDocConfigPackage);
		return theEcoreDocConfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIENamedElementConfig() {
		return ieNamedElementConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIENamedElementConfig_Render() {
		return (EAttribute)ieNamedElementConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIENamedElementConfig_Id() {
		return (EAttribute)ieNamedElementConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIENamedElementConfig__ShouldRender() {
		return ieNamedElementConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIENamedElementConfig__GetTarget() {
		return ieNamedElementConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDefaultValueConfig() {
		return iDefaultValueConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDefaultValueConfig_RenderDefaults() {
		return (EAttribute)iDefaultValueConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIDefaultValueConfig__ShouldRenderDefaults() {
		return iDefaultValueConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEClassifierConfig() {
		return ieClassifierConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEClassifierConfig_RenderUseCases() {
		return (EAttribute)ieClassifierConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIEClassifierConfig__ShouldRenderUseCases() {
		return ieClassifierConfigEClass.getEOperations().get(0);
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
	public EClass getIEEnumConfig() {
		return ieEnumConfigEClass;
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
	public EAttribute getIEClassConfig_RenderSubTypes() {
		return (EAttribute)ieClassConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEClassConfig_RenderSuperTypes() {
		return (EAttribute)ieClassConfigEClass.getEStructuralFeatures().get(2);
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
	public EOperation getIEClassConfig__ShouldRenderSubTypes() {
		return ieClassConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIEClassConfig__ShouldRenderSuperTypes() {
		return ieClassConfigEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIETypedElementConfig() {
		return ieTypedElementConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIETypedElementConfig_RenderBounds() {
		return (EAttribute)ieTypedElementConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIETypedElementConfig__ShouldRenderBounds() {
		return ieTypedElementConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEStructuralFeatureConfig() {
		return ieStructuralFeatureConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEAttributeConfig() {
		return ieAttributeConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEReferenceConfig() {
		return ieReferenceConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEOperationConfig() {
		return ieOperationConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEParameterConfig() {
		return ieParameterConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEPackageConfig() {
		return iePackageConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEPackageConfig_PositionEDataTypes() {
		return (EAttribute)iePackageConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEPackageConfig_PositionEEnums() {
		return (EAttribute)iePackageConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEPackageConfig_PositionEClasses() {
		return (EAttribute)iePackageConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIEPackageConfig__GetEDataTypesPosition() {
		return iePackageConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIEPackageConfig__GetEEnumsPosition() {
		return iePackageConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIEPackageConfig__GetEClassesPosition() {
		return iePackageConfigEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEEnumLiteralConfig() {
		return ieEnumLiteralConfigEClass;
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
	public EAttribute getEcoreDocGeneratorConfig_DocumentTitle() {
		return (EAttribute)ecoreDocGeneratorConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcoreDocGeneratorConfig_EPackages() {
		return (EReference)ecoreDocGeneratorConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__ShouldRender() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__ShouldRenderDefaults() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__ShouldRenderUseCases() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__ShouldRepeatInherited() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__ShouldRenderSubTypes() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__ShouldRenderSuperTypes() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__ShouldRenderBounds() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__GetEDataTypesPosition() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__GetEEnumsPosition() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__GetEClassesPosition() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__AddEPackages__List() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__FindConfig__ENamedElement() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreDocGeneratorConfig__GetTarget() {
		return ecoreDocGeneratorConfigEClass.getEOperations().get(12);
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
	public EOperation getEPackageConfig__AddEDataTypes__List() {
		return ePackageConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEPackageConfig__AddEEnums__List() {
		return ePackageConfigEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEPackageConfig__AddEClasses__List() {
		return ePackageConfigEClass.getEOperations().get(3);
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
	public EOperation getEEnumConfig__AddEEnumLiterals__List() {
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
	public EReference getEClassConfig_EOperations() {
		return (EReference)eClassConfigEClass.getEStructuralFeatures().get(4);
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
	public EOperation getEClassConfig__AddEAttributes__List() {
		return eClassConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEClassConfig__AddEContainments__List() {
		return eClassConfigEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEClassConfig__AddEReferences__List() {
		return eClassConfigEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEClassConfig__AddEOperations__List() {
		return eClassConfigEClass.getEOperations().get(4);
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
	public EClass getAEReferenceConfig() {
		return aeReferenceConfigEClass;
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
	public EClass getEOperationConfig() {
		return eOperationConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEOperationConfig_TargetEOperation() {
		return (EReference)eOperationConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEOperationConfig_EParameters() {
		return (EReference)eOperationConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEOperationConfig__GetTarget() {
		return eOperationConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEOperationConfig__AddEParameters__List() {
		return eOperationConfigEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEOperationConfig__GetId() {
		return eOperationConfigEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEOperationConfig__JoinId__EOperation() {
		return eOperationConfigEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEParameterConfig() {
		return eParameterConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEParameterConfig_TargetEParameter() {
		return (EReference)eParameterConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEParameterConfig__GetTarget() {
		return eParameterConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getList() {
		return listEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreDocConfigFactory getEcoreDocConfigFactory() {
		return (EcoreDocConfigFactory)getEFactoryInstance();
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
		ieNamedElementConfigEClass = createEClass(IE_NAMED_ELEMENT_CONFIG);
		createEAttribute(ieNamedElementConfigEClass, IE_NAMED_ELEMENT_CONFIG__RENDER);
		createEAttribute(ieNamedElementConfigEClass, IE_NAMED_ELEMENT_CONFIG__ID);
		createEOperation(ieNamedElementConfigEClass, IE_NAMED_ELEMENT_CONFIG___SHOULD_RENDER);
		createEOperation(ieNamedElementConfigEClass, IE_NAMED_ELEMENT_CONFIG___GET_TARGET);

		iDefaultValueConfigEClass = createEClass(IDEFAULT_VALUE_CONFIG);
		createEAttribute(iDefaultValueConfigEClass, IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS);
		createEOperation(iDefaultValueConfigEClass, IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS);

		ieClassifierConfigEClass = createEClass(IE_CLASSIFIER_CONFIG);
		createEAttribute(ieClassifierConfigEClass, IE_CLASSIFIER_CONFIG__RENDER_USE_CASES);
		createEOperation(ieClassifierConfigEClass, IE_CLASSIFIER_CONFIG___SHOULD_RENDER_USE_CASES);

		ieDataTypeConfigEClass = createEClass(IE_DATA_TYPE_CONFIG);

		ieEnumConfigEClass = createEClass(IE_ENUM_CONFIG);

		ieClassConfigEClass = createEClass(IE_CLASS_CONFIG);
		createEAttribute(ieClassConfigEClass, IE_CLASS_CONFIG__REPEAT_INHERITED);
		createEAttribute(ieClassConfigEClass, IE_CLASS_CONFIG__RENDER_SUB_TYPES);
		createEAttribute(ieClassConfigEClass, IE_CLASS_CONFIG__RENDER_SUPER_TYPES);
		createEOperation(ieClassConfigEClass, IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED);
		createEOperation(ieClassConfigEClass, IE_CLASS_CONFIG___SHOULD_RENDER_SUB_TYPES);
		createEOperation(ieClassConfigEClass, IE_CLASS_CONFIG___SHOULD_RENDER_SUPER_TYPES);

		ieTypedElementConfigEClass = createEClass(IE_TYPED_ELEMENT_CONFIG);
		createEAttribute(ieTypedElementConfigEClass, IE_TYPED_ELEMENT_CONFIG__RENDER_BOUNDS);
		createEOperation(ieTypedElementConfigEClass, IE_TYPED_ELEMENT_CONFIG___SHOULD_RENDER_BOUNDS);

		ieStructuralFeatureConfigEClass = createEClass(IE_STRUCTURAL_FEATURE_CONFIG);

		ieAttributeConfigEClass = createEClass(IE_ATTRIBUTE_CONFIG);

		ieReferenceConfigEClass = createEClass(IE_REFERENCE_CONFIG);

		ieOperationConfigEClass = createEClass(IE_OPERATION_CONFIG);

		ieParameterConfigEClass = createEClass(IE_PARAMETER_CONFIG);

		iePackageConfigEClass = createEClass(IE_PACKAGE_CONFIG);
		createEAttribute(iePackageConfigEClass, IE_PACKAGE_CONFIG__POSITION_EDATA_TYPES);
		createEAttribute(iePackageConfigEClass, IE_PACKAGE_CONFIG__POSITION_EENUMS);
		createEAttribute(iePackageConfigEClass, IE_PACKAGE_CONFIG__POSITION_ECLASSES);
		createEOperation(iePackageConfigEClass, IE_PACKAGE_CONFIG___GET_EDATA_TYPES_POSITION);
		createEOperation(iePackageConfigEClass, IE_PACKAGE_CONFIG___GET_EENUMS_POSITION);
		createEOperation(iePackageConfigEClass, IE_PACKAGE_CONFIG___GET_ECLASSES_POSITION);

		ieEnumLiteralConfigEClass = createEClass(IE_ENUM_LITERAL_CONFIG);

		ecoreDocGeneratorConfigEClass = createEClass(ECORE_DOC_GENERATOR_CONFIG);
		createEAttribute(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG__DOCUMENT_TITLE);
		createEReference(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG__EPACKAGES);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_USE_CASES);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___SHOULD_REPEAT_INHERITED);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUB_TYPES);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_SUPER_TYPES);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_BOUNDS);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___GET_EDATA_TYPES_POSITION);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___GET_EENUMS_POSITION);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___GET_ECLASSES_POSITION);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___ADD_EPACKAGES__LIST);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___FIND_CONFIG__ENAMEDELEMENT);
		createEOperation(ecoreDocGeneratorConfigEClass, ECORE_DOC_GENERATOR_CONFIG___GET_TARGET);

		ePackageConfigEClass = createEClass(EPACKAGE_CONFIG);
		createEReference(ePackageConfigEClass, EPACKAGE_CONFIG__TARGET_EPACKAGE);
		createEReference(ePackageConfigEClass, EPACKAGE_CONFIG__EDATA_TYPES);
		createEReference(ePackageConfigEClass, EPACKAGE_CONFIG__EENUMS);
		createEReference(ePackageConfigEClass, EPACKAGE_CONFIG__ECLASSES);
		createEOperation(ePackageConfigEClass, EPACKAGE_CONFIG___GET_TARGET);
		createEOperation(ePackageConfigEClass, EPACKAGE_CONFIG___ADD_EDATA_TYPES__LIST);
		createEOperation(ePackageConfigEClass, EPACKAGE_CONFIG___ADD_EENUMS__LIST);
		createEOperation(ePackageConfigEClass, EPACKAGE_CONFIG___ADD_ECLASSES__LIST);

		eDataTypeConfigEClass = createEClass(EDATA_TYPE_CONFIG);
		createEReference(eDataTypeConfigEClass, EDATA_TYPE_CONFIG__TARGET_EDATA_TYPE);
		createEOperation(eDataTypeConfigEClass, EDATA_TYPE_CONFIG___GET_TARGET);

		eEnumConfigEClass = createEClass(EENUM_CONFIG);
		createEReference(eEnumConfigEClass, EENUM_CONFIG__TARGET_EENUM);
		createEReference(eEnumConfigEClass, EENUM_CONFIG__EENUM_LITERALS);
		createEOperation(eEnumConfigEClass, EENUM_CONFIG___GET_TARGET);
		createEOperation(eEnumConfigEClass, EENUM_CONFIG___ADD_EENUM_LITERALS__LIST);

		eEnumLiteralConfigEClass = createEClass(EENUM_LITERAL_CONFIG);
		createEReference(eEnumLiteralConfigEClass, EENUM_LITERAL_CONFIG__TARGET_EENUM_LITERAL);
		createEOperation(eEnumLiteralConfigEClass, EENUM_LITERAL_CONFIG___GET_TARGET);

		eClassConfigEClass = createEClass(ECLASS_CONFIG);
		createEReference(eClassConfigEClass, ECLASS_CONFIG__TARGET_ECLASS);
		createEReference(eClassConfigEClass, ECLASS_CONFIG__EATTRIBUTES);
		createEReference(eClassConfigEClass, ECLASS_CONFIG__ECONTAINMENTS);
		createEReference(eClassConfigEClass, ECLASS_CONFIG__EREFERENCES);
		createEReference(eClassConfigEClass, ECLASS_CONFIG__EOPERATIONS);
		createEOperation(eClassConfigEClass, ECLASS_CONFIG___GET_TARGET);
		createEOperation(eClassConfigEClass, ECLASS_CONFIG___ADD_EATTRIBUTES__LIST);
		createEOperation(eClassConfigEClass, ECLASS_CONFIG___ADD_ECONTAINMENTS__LIST);
		createEOperation(eClassConfigEClass, ECLASS_CONFIG___ADD_EREFERENCES__LIST);
		createEOperation(eClassConfigEClass, ECLASS_CONFIG___ADD_EOPERATIONS__LIST);

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

		eOperationConfigEClass = createEClass(EOPERATION_CONFIG);
		createEReference(eOperationConfigEClass, EOPERATION_CONFIG__TARGET_EOPERATION);
		createEReference(eOperationConfigEClass, EOPERATION_CONFIG__EPARAMETERS);
		createEOperation(eOperationConfigEClass, EOPERATION_CONFIG___GET_TARGET);
		createEOperation(eOperationConfigEClass, EOPERATION_CONFIG___ADD_EPARAMETERS__LIST);
		createEOperation(eOperationConfigEClass, EOPERATION_CONFIG___GET_ID);
		createEOperation(eOperationConfigEClass, EOPERATION_CONFIG___JOIN_ID__EOPERATION);

		eParameterConfigEClass = createEClass(EPARAMETER_CONFIG);
		createEReference(eParameterConfigEClass, EPARAMETER_CONFIG__TARGET_EPARAMETER);
		createEOperation(eParameterConfigEClass, EPARAMETER_CONFIG___GET_TARGET);

		listEClass = createEClass(LIST);
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
		addETypeParameter(listEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		ieClassifierConfigEClass.getESuperTypes().add(this.getIENamedElementConfig());
		ieClassifierConfigEClass.getESuperTypes().add(this.getIDefaultValueConfig());
		ieDataTypeConfigEClass.getESuperTypes().add(this.getIEClassifierConfig());
		ieEnumConfigEClass.getESuperTypes().add(this.getIEDataTypeConfig());
		ieClassConfigEClass.getESuperTypes().add(this.getIEClassifierConfig());
		ieTypedElementConfigEClass.getESuperTypes().add(this.getIENamedElementConfig());
		ieTypedElementConfigEClass.getESuperTypes().add(this.getIDefaultValueConfig());
		ieStructuralFeatureConfigEClass.getESuperTypes().add(this.getIETypedElementConfig());
		ieAttributeConfigEClass.getESuperTypes().add(this.getIEStructuralFeatureConfig());
		ieReferenceConfigEClass.getESuperTypes().add(this.getIEStructuralFeatureConfig());
		ieOperationConfigEClass.getESuperTypes().add(this.getIETypedElementConfig());
		ieParameterConfigEClass.getESuperTypes().add(this.getIETypedElementConfig());
		iePackageConfigEClass.getESuperTypes().add(this.getIENamedElementConfig());
		ieEnumLiteralConfigEClass.getESuperTypes().add(this.getIENamedElementConfig());
		ecoreDocGeneratorConfigEClass.getESuperTypes().add(this.getIEPackageConfig());
		ecoreDocGeneratorConfigEClass.getESuperTypes().add(this.getIEEnumConfig());
		ecoreDocGeneratorConfigEClass.getESuperTypes().add(this.getIEEnumLiteralConfig());
		ecoreDocGeneratorConfigEClass.getESuperTypes().add(this.getIEClassConfig());
		ecoreDocGeneratorConfigEClass.getESuperTypes().add(this.getIEAttributeConfig());
		ecoreDocGeneratorConfigEClass.getESuperTypes().add(this.getIEReferenceConfig());
		ecoreDocGeneratorConfigEClass.getESuperTypes().add(this.getIEOperationConfig());
		ecoreDocGeneratorConfigEClass.getESuperTypes().add(this.getIEParameterConfig());
		ePackageConfigEClass.getESuperTypes().add(this.getIEPackageConfig());
		ePackageConfigEClass.getESuperTypes().add(this.getIEEnumConfig());
		ePackageConfigEClass.getESuperTypes().add(this.getIEEnumLiteralConfig());
		ePackageConfigEClass.getESuperTypes().add(this.getIEClassConfig());
		ePackageConfigEClass.getESuperTypes().add(this.getIEAttributeConfig());
		ePackageConfigEClass.getESuperTypes().add(this.getIEReferenceConfig());
		ePackageConfigEClass.getESuperTypes().add(this.getIEOperationConfig());
		ePackageConfigEClass.getESuperTypes().add(this.getIEParameterConfig());
		eDataTypeConfigEClass.getESuperTypes().add(this.getIEDataTypeConfig());
		eEnumConfigEClass.getESuperTypes().add(this.getIEEnumConfig());
		eEnumConfigEClass.getESuperTypes().add(this.getIEEnumLiteralConfig());
		eEnumLiteralConfigEClass.getESuperTypes().add(this.getIEEnumLiteralConfig());
		eClassConfigEClass.getESuperTypes().add(this.getIEClassConfig());
		eClassConfigEClass.getESuperTypes().add(this.getIEAttributeConfig());
		eClassConfigEClass.getESuperTypes().add(this.getIEReferenceConfig());
		eClassConfigEClass.getESuperTypes().add(this.getIEOperationConfig());
		eClassConfigEClass.getESuperTypes().add(this.getIEParameterConfig());
		eAttributeConfigEClass.getESuperTypes().add(this.getIEAttributeConfig());
		aeReferenceConfigEClass.getESuperTypes().add(this.getIEReferenceConfig());
		eContainmentConfigEClass.getESuperTypes().add(this.getAEReferenceConfig());
		eReferenceConfigEClass.getESuperTypes().add(this.getAEReferenceConfig());
		eOperationConfigEClass.getESuperTypes().add(this.getAEReferenceConfig());
		eParameterConfigEClass.getESuperTypes().add(this.getAEReferenceConfig());

		// Initialize classes, features, and operations; add parameters
		initEClass(ieNamedElementConfigEClass, IENamedElementConfig.class, "IENamedElementConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIENamedElementConfig_Render(), theEcorePackage.getEBoolean(), "render", null, 0, 1, IENamedElementConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIENamedElementConfig_Id(), theEcorePackage.getEString(), "id", null, 0, 1, IENamedElementConfig.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getIENamedElementConfig__ShouldRender(), theEcorePackage.getEBoolean(), "shouldRender", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getIENamedElementConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(iDefaultValueConfigEClass, IDefaultValueConfig.class, "IDefaultValueConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIDefaultValueConfig_RenderDefaults(), theEcorePackage.getEBoolean(), "renderDefaults", null, 0, 1, IDefaultValueConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIDefaultValueConfig__ShouldRenderDefaults(), theEcorePackage.getEBoolean(), "shouldRenderDefaults", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ieClassifierConfigEClass, IEClassifierConfig.class, "IEClassifierConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIEClassifierConfig_RenderUseCases(), theEcorePackage.getEBoolean(), "renderUseCases", null, 0, 1, IEClassifierConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIEClassifierConfig__ShouldRenderUseCases(), theEcorePackage.getEBoolean(), "shouldRenderUseCases", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ieDataTypeConfigEClass, IEDataTypeConfig.class, "IEDataTypeConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ieEnumConfigEClass, IEEnumConfig.class, "IEEnumConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ieClassConfigEClass, IEClassConfig.class, "IEClassConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIEClassConfig_RepeatInherited(), theEcorePackage.getEBoolean(), "repeatInherited", null, 0, 1, IEClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIEClassConfig_RenderSubTypes(), theEcorePackage.getEBoolean(), "renderSubTypes", null, 0, 1, IEClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIEClassConfig_RenderSuperTypes(), theEcorePackage.getEBoolean(), "renderSuperTypes", null, 0, 1, IEClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIEClassConfig__ShouldRepeatInherited(), theEcorePackage.getEBoolean(), "shouldRepeatInherited", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getIEClassConfig__ShouldRenderSubTypes(), theEcorePackage.getEBoolean(), "shouldRenderSubTypes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getIEClassConfig__ShouldRenderSuperTypes(), theEcorePackage.getEBoolean(), "shouldRenderSuperTypes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ieTypedElementConfigEClass, IETypedElementConfig.class, "IETypedElementConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIETypedElementConfig_RenderBounds(), theEcorePackage.getEBoolean(), "renderBounds", null, 0, 1, IETypedElementConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIETypedElementConfig__ShouldRenderBounds(), theEcorePackage.getEBoolean(), "shouldRenderBounds", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ieStructuralFeatureConfigEClass, IEStructuralFeatureConfig.class, "IEStructuralFeatureConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ieAttributeConfigEClass, IEAttributeConfig.class, "IEAttributeConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ieReferenceConfigEClass, IEReferenceConfig.class, "IEReferenceConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ieOperationConfigEClass, IEOperationConfig.class, "IEOperationConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ieParameterConfigEClass, IEParameterConfig.class, "IEParameterConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iePackageConfigEClass, IEPackageConfig.class, "IEPackageConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIEPackageConfig_PositionEDataTypes(), theEcorePackage.getEInt(), "positionEDataTypes", null, 0, 1, IEPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIEPackageConfig_PositionEEnums(), theEcorePackage.getEInt(), "positionEEnums", null, 0, 1, IEPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIEPackageConfig_PositionEClasses(), theEcorePackage.getEInt(), "positionEClasses", null, 0, 1, IEPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIEPackageConfig__GetEDataTypesPosition(), theEcorePackage.getEInt(), "getEDataTypesPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getIEPackageConfig__GetEEnumsPosition(), theEcorePackage.getEInt(), "getEEnumsPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getIEPackageConfig__GetEClassesPosition(), theEcorePackage.getEInt(), "getEClassesPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ieEnumLiteralConfigEClass, IEEnumLiteralConfig.class, "IEEnumLiteralConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ecoreDocGeneratorConfigEClass, EcoreDocGeneratorConfig.class, "EcoreDocGeneratorConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEcoreDocGeneratorConfig_DocumentTitle(), theEcorePackage.getEString(), "documentTitle", "Ecore Documentation", 0, 1, EcoreDocGeneratorConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcoreDocGeneratorConfig_EPackages(), this.getEPackageConfig(), null, "ePackages", null, 0, -1, EcoreDocGeneratorConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__ShouldRender(), theEcorePackage.getEBoolean(), "shouldRender", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__ShouldRenderDefaults(), theEcorePackage.getEBoolean(), "shouldRenderDefaults", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__ShouldRenderUseCases(), theEcorePackage.getEBoolean(), "shouldRenderUseCases", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__ShouldRepeatInherited(), theEcorePackage.getEBoolean(), "shouldRepeatInherited", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__ShouldRenderSubTypes(), theEcorePackage.getEBoolean(), "shouldRenderSubTypes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__ShouldRenderSuperTypes(), theEcorePackage.getEBoolean(), "shouldRenderSuperTypes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__ShouldRenderBounds(), theEcorePackage.getEBoolean(), "shouldRenderBounds", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__GetEDataTypesPosition(), theEcorePackage.getEInt(), "getEDataTypesPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__GetEEnumsPosition(), theEcorePackage.getEInt(), "getEEnumsPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__GetEClassesPosition(), theEcorePackage.getEInt(), "getEClassesPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getEcoreDocGeneratorConfig__AddEPackages__List(), null, "addEPackages", 0, 1, !IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getList());
		EGenericType g2 = createEGenericType(this.getEPackageConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "ePackageConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEcoreDocGeneratorConfig__FindConfig__ENamedElement(), this.getIENamedElementConfig(), "findConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getENamedElement(), "element", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEcoreDocGeneratorConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ePackageConfigEClass, EPackageConfig.class, "EPackageConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEPackageConfig_TargetEPackage(), theEcorePackage.getEPackage(), null, "targetEPackage", null, 0, 1, EPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPackageConfig_EDataTypes(), this.getEDataTypeConfig(), null, "eDataTypes", null, 0, -1, EPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPackageConfig_EEnums(), this.getEEnumConfig(), null, "eEnums", null, 0, -1, EPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPackageConfig_EClasses(), this.getEClassConfig(), null, "eClasses", null, 0, -1, EPackageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEPackageConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEPackageConfig__AddEDataTypes__List(), null, "addEDataTypes", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getEDataTypeConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eDataTypeConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEPackageConfig__AddEEnums__List(), null, "addEEnums", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getEEnumConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eEnumConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEPackageConfig__AddEClasses__List(), null, "addEClasses", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getEClassConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eClassConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eDataTypeConfigEClass, EDataTypeConfig.class, "EDataTypeConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDataTypeConfig_TargetEDataType(), theEcorePackage.getEDataType(), null, "targetEDataType", null, 0, 1, EDataTypeConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEDataTypeConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eEnumConfigEClass, EEnumConfig.class, "EEnumConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEEnumConfig_TargetEEnum(), theEcorePackage.getEEnum(), null, "targetEEnum", null, 0, 1, EEnumConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEnumConfig_EEnumLiterals(), this.getEEnumLiteralConfig(), null, "eEnumLiterals", null, 0, -1, EEnumConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEEnumConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEEnumConfig__AddEEnumLiterals__List(), null, "addEEnumLiterals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getEEnumLiteralConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eEnumLiteralConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eEnumLiteralConfigEClass, EEnumLiteralConfig.class, "EEnumLiteralConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEEnumLiteralConfig_TargetEEnumLiteral(), theEcorePackage.getEEnumLiteral(), null, "targetEEnumLiteral", null, 0, 1, EEnumLiteralConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEEnumLiteralConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eClassConfigEClass, EClassConfig.class, "EClassConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEClassConfig_TargetEClass(), theEcorePackage.getEClass(), null, "targetEClass", null, 0, 1, EClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassConfig_EAttributes(), this.getEAttributeConfig(), null, "eAttributes", null, 0, -1, EClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassConfig_EContainments(), this.getEContainmentConfig(), null, "eContainments", null, 0, -1, EClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassConfig_EReferences(), this.getEReferenceConfig(), null, "eReferences", null, 0, -1, EClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassConfig_EOperations(), this.getEOperationConfig(), null, "eOperations", null, 0, -1, EClassConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEClassConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEClassConfig__AddEAttributes__List(), null, "addEAttributes", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getEAttributeConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eAttributeConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEClassConfig__AddEContainments__List(), null, "addEContainments", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getEContainmentConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eContainmentConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEClassConfig__AddEReferences__List(), null, "addEReferences", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getEReferenceConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eReferenceConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEClassConfig__AddEOperations__List(), null, "addEOperations", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getEOperationConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eOperationConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

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

		initEClass(eOperationConfigEClass, EOperationConfig.class, "EOperationConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEOperationConfig_TargetEOperation(), theEcorePackage.getEOperation(), null, "targetEOperation", null, 0, 1, EOperationConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEOperationConfig_EParameters(), this.getEParameterConfig(), null, "eParameters", null, 0, -1, EOperationConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEOperationConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEOperationConfig__AddEParameters__List(), null, "addEParameters", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getEParameterConfig());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eParameterConfig", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEOperationConfig__GetId(), theEcorePackage.getEString(), "getId", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEOperationConfig__JoinId__EOperation(), theEcorePackage.getEString(), "joinId", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEOperation(), "eOperation", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eParameterConfigEClass, EParameterConfig.class, "EParameterConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEParameterConfig_TargetEParameter(), theEcorePackage.getEParameter(), null, "targetEParameter", null, 0, 1, EParameterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEParameterConfig__GetTarget(), theEcorePackage.getENamedElement(), "getTarget", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(listEClass, List.class, "List", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
		// http://altran.com/general/emf/ecoredoc/generator/config/0.1
		create_0Annotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2011/Xcore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "Ecore", "http://www.eclipse.org/emf/2002/Ecore",
			 "GenModel", "http://www.eclipse.org/emf/2002/GenModel",
			 "EcoreDoc", "http://altran.com/general/emf/ecoredoc/generator/config/0.1"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://altran.com/general/emf/ecoredoc/generator/config/0.1</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void create_0Annotations() {
		String source = "http://altran.com/general/emf/ecoredoc/generator/config/0.1";	
		addAnnotation
		  (getIENamedElementConfig_Id(), 
		   source, 
		   new String[] {
			 "render", "false"
		   });	
		addAnnotation
		  (listEClass, 
		   source, 
		   new String[] {
			 "render", "false"
		   });
	}

} //EcoreDocConfigPackageImpl
