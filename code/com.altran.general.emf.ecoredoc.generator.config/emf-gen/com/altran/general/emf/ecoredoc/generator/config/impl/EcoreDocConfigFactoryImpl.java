/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoreDocConfigFactoryImpl extends EFactoryImpl implements EcoreDocConfigFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EcoreDocConfigFactory init() {
		try {
			EcoreDocConfigFactory theEcoreDocConfigFactory = (EcoreDocConfigFactory)EPackage.Registry.INSTANCE.getEFactory(EcoreDocConfigPackage.eNS_URI);
			if (theEcoreDocConfigFactory != null) {
				return theEcoreDocConfigFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EcoreDocConfigFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreDocConfigFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG: return createEcoreDocGeneratorConfig();
			case EcoreDocConfigPackage.EPACKAGE_CONFIG: return createEPackageConfig();
			case EcoreDocConfigPackage.EDATA_TYPE_CONFIG: return createEDataTypeConfig();
			case EcoreDocConfigPackage.EENUM_CONFIG: return createEEnumConfig();
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG: return createEEnumLiteralConfig();
			case EcoreDocConfigPackage.ECLASS_CONFIG: return createEClassConfig();
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG: return createEAttributeConfig();
			case EcoreDocConfigPackage.ECONTAINMENT_CONFIG: return createEContainmentConfig();
			case EcoreDocConfigPackage.EREFERENCE_CONFIG: return createEReferenceConfig();
			case EcoreDocConfigPackage.EOPERATION_CONFIG: return createEOperationConfig();
			case EcoreDocConfigPackage.EPARAMETER_CONFIG: return createEParameterConfig();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreDocGeneratorConfig createEcoreDocGeneratorConfig() {
		EcoreDocGeneratorConfigImpl ecoreDocGeneratorConfig = new EcoreDocGeneratorConfigImpl();
		return ecoreDocGeneratorConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackageConfig createEPackageConfig() {
		EPackageConfigImpl ePackageConfig = new EPackageConfigImpl();
		return ePackageConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataTypeConfig createEDataTypeConfig() {
		EDataTypeConfigImpl eDataTypeConfig = new EDataTypeConfigImpl();
		return eDataTypeConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumConfig createEEnumConfig() {
		EEnumConfigImpl eEnumConfig = new EEnumConfigImpl();
		return eEnumConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteralConfig createEEnumLiteralConfig() {
		EEnumLiteralConfigImpl eEnumLiteralConfig = new EEnumLiteralConfigImpl();
		return eEnumLiteralConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassConfig createEClassConfig() {
		EClassConfigImpl eClassConfig = new EClassConfigImpl();
		return eClassConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttributeConfig createEAttributeConfig() {
		EAttributeConfigImpl eAttributeConfig = new EAttributeConfigImpl();
		return eAttributeConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EContainmentConfig createEContainmentConfig() {
		EContainmentConfigImpl eContainmentConfig = new EContainmentConfigImpl();
		return eContainmentConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReferenceConfig createEReferenceConfig() {
		EReferenceConfigImpl eReferenceConfig = new EReferenceConfigImpl();
		return eReferenceConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperationConfig createEOperationConfig() {
		EOperationConfigImpl eOperationConfig = new EOperationConfigImpl();
		return eOperationConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EParameterConfig createEParameterConfig() {
		EParameterConfigImpl eParameterConfig = new EParameterConfigImpl();
		return eParameterConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreDocConfigPackage getEcoreDocConfigPackage() {
		return (EcoreDocConfigPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EcoreDocConfigPackage getPackage() {
		return EcoreDocConfigPackage.eINSTANCE;
	}

} //EcoreDocConfigFactoryImpl
