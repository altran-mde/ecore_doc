/**
 */
package com.altran.general.ecoredoc.generator.config.impl;

import com.altran.general.ecoredoc.generator.config.*;

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
public class ConfigFactoryImpl extends EFactoryImpl implements ConfigFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfigFactory init() {
		try {
			ConfigFactory theConfigFactory = (ConfigFactory)EPackage.Registry.INSTANCE.getEFactory(ConfigPackage.eNS_URI);
			if (theConfigFactory != null) {
				return theConfigFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConfigFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigFactoryImpl() {
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG: return createEcoreDocGeneratorConfig();
			case ConfigPackage.EPACKAGE_CONFIG: return createEPackageConfig();
			case ConfigPackage.EDATA_TYPE_CONFIG: return createEDataTypeConfig();
			case ConfigPackage.EENUM_CONFIG: return createEEnumConfig();
			case ConfigPackage.EENUM_LITERAL_CONFIG: return createEEnumLiteralConfig();
			case ConfigPackage.ECLASS_CONFIG: return createEClassConfig();
			case ConfigPackage.EATTRIBUTE_CONFIG: return createEAttributeConfig();
			case ConfigPackage.ECONTAINMENT_CONFIG: return createEContainmentConfig();
			case ConfigPackage.EREFERENCE_CONFIG: return createEReferenceConfig();
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
	public ConfigPackage getConfigPackage() {
		return (ConfigPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConfigPackage getPackage() {
		return ConfigPackage.eINSTANCE;
	}

} //ConfigFactoryImpl
