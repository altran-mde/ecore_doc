/**
 */
package com.altran.general.ecoredoc.generator.config.util;

import com.altran.general.ecoredoc.generator.config.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage
 * @generated
 */
public class ConfigSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigSwitch() {
		if (modelPackage == null) {
			modelPackage = ConfigPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ConfigPackage.IE_NAMED_ELEMENT_CONFIG: {
				IENamedElementConfig ieNamedElementConfig = (IENamedElementConfig)theEObject;
				T result = caseIENamedElementConfig(ieNamedElementConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IDEFAULT_VALUE_CONFIG: {
				IDefaultValueConfig iDefaultValueConfig = (IDefaultValueConfig)theEObject;
				T result = caseIDefaultValueConfig(iDefaultValueConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IE_CLASSIFIER_CONFIG: {
				IEClassifierConfig ieClassifierConfig = (IEClassifierConfig)theEObject;
				T result = caseIEClassifierConfig(ieClassifierConfig);
				if (result == null) result = caseIENamedElementConfig(ieClassifierConfig);
				if (result == null) result = caseIDefaultValueConfig(ieClassifierConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IE_DATA_TYPE_CONFIG: {
				IEDataTypeConfig ieDataTypeConfig = (IEDataTypeConfig)theEObject;
				T result = caseIEDataTypeConfig(ieDataTypeConfig);
				if (result == null) result = caseIEClassifierConfig(ieDataTypeConfig);
				if (result == null) result = caseIENamedElementConfig(ieDataTypeConfig);
				if (result == null) result = caseIDefaultValueConfig(ieDataTypeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IE_ENUM_CONFIG: {
				IEEnumConfig ieEnumConfig = (IEEnumConfig)theEObject;
				T result = caseIEEnumConfig(ieEnumConfig);
				if (result == null) result = caseIEDataTypeConfig(ieEnumConfig);
				if (result == null) result = caseIEClassifierConfig(ieEnumConfig);
				if (result == null) result = caseIENamedElementConfig(ieEnumConfig);
				if (result == null) result = caseIDefaultValueConfig(ieEnumConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IE_CLASS_CONFIG: {
				IEClassConfig ieClassConfig = (IEClassConfig)theEObject;
				T result = caseIEClassConfig(ieClassConfig);
				if (result == null) result = caseIEClassifierConfig(ieClassConfig);
				if (result == null) result = caseIENamedElementConfig(ieClassConfig);
				if (result == null) result = caseIDefaultValueConfig(ieClassConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG: {
				IEStructuralFeatureConfig ieStructuralFeatureConfig = (IEStructuralFeatureConfig)theEObject;
				T result = caseIEStructuralFeatureConfig(ieStructuralFeatureConfig);
				if (result == null) result = caseIENamedElementConfig(ieStructuralFeatureConfig);
				if (result == null) result = caseIDefaultValueConfig(ieStructuralFeatureConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IE_ATTRIBUTE_CONFIG: {
				IEAttributeConfig ieAttributeConfig = (IEAttributeConfig)theEObject;
				T result = caseIEAttributeConfig(ieAttributeConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(ieAttributeConfig);
				if (result == null) result = caseIENamedElementConfig(ieAttributeConfig);
				if (result == null) result = caseIDefaultValueConfig(ieAttributeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IE_REFERENCE_CONFIG: {
				IEReferenceConfig ieReferenceConfig = (IEReferenceConfig)theEObject;
				T result = caseIEReferenceConfig(ieReferenceConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(ieReferenceConfig);
				if (result == null) result = caseIENamedElementConfig(ieReferenceConfig);
				if (result == null) result = caseIDefaultValueConfig(ieReferenceConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IE_PACKAGE_CONFIG: {
				IEPackageConfig iePackageConfig = (IEPackageConfig)theEObject;
				T result = caseIEPackageConfig(iePackageConfig);
				if (result == null) result = caseIENamedElementConfig(iePackageConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IE_ENUM_LITERAL_CONFIG: {
				IEEnumLiteralConfig ieEnumLiteralConfig = (IEEnumLiteralConfig)theEObject;
				T result = caseIEEnumLiteralConfig(ieEnumLiteralConfig);
				if (result == null) result = caseIENamedElementConfig(ieEnumLiteralConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG: {
				EcoreDocGeneratorConfig ecoreDocGeneratorConfig = (EcoreDocGeneratorConfig)theEObject;
				T result = caseEcoreDocGeneratorConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEPackageConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEEnumConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEEnumLiteralConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEClassConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEAttributeConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEReferenceConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEDataTypeConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEClassifierConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIENamedElementConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIDefaultValueConfig(ecoreDocGeneratorConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EPACKAGE_CONFIG: {
				EPackageConfig ePackageConfig = (EPackageConfig)theEObject;
				T result = caseEPackageConfig(ePackageConfig);
				if (result == null) result = caseIEPackageConfig(ePackageConfig);
				if (result == null) result = caseIEEnumConfig(ePackageConfig);
				if (result == null) result = caseIEEnumLiteralConfig(ePackageConfig);
				if (result == null) result = caseIEClassConfig(ePackageConfig);
				if (result == null) result = caseIEAttributeConfig(ePackageConfig);
				if (result == null) result = caseIEReferenceConfig(ePackageConfig);
				if (result == null) result = caseIEDataTypeConfig(ePackageConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(ePackageConfig);
				if (result == null) result = caseIEClassifierConfig(ePackageConfig);
				if (result == null) result = caseIENamedElementConfig(ePackageConfig);
				if (result == null) result = caseIDefaultValueConfig(ePackageConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EDATA_TYPE_CONFIG: {
				EDataTypeConfig eDataTypeConfig = (EDataTypeConfig)theEObject;
				T result = caseEDataTypeConfig(eDataTypeConfig);
				if (result == null) result = caseIEDataTypeConfig(eDataTypeConfig);
				if (result == null) result = caseIEClassifierConfig(eDataTypeConfig);
				if (result == null) result = caseIENamedElementConfig(eDataTypeConfig);
				if (result == null) result = caseIDefaultValueConfig(eDataTypeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EENUM_CONFIG: {
				EEnumConfig eEnumConfig = (EEnumConfig)theEObject;
				T result = caseEEnumConfig(eEnumConfig);
				if (result == null) result = caseIEEnumConfig(eEnumConfig);
				if (result == null) result = caseIEEnumLiteralConfig(eEnumConfig);
				if (result == null) result = caseIEDataTypeConfig(eEnumConfig);
				if (result == null) result = caseIEClassifierConfig(eEnumConfig);
				if (result == null) result = caseIENamedElementConfig(eEnumConfig);
				if (result == null) result = caseIDefaultValueConfig(eEnumConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EENUM_LITERAL_CONFIG: {
				EEnumLiteralConfig eEnumLiteralConfig = (EEnumLiteralConfig)theEObject;
				T result = caseEEnumLiteralConfig(eEnumLiteralConfig);
				if (result == null) result = caseIEEnumLiteralConfig(eEnumLiteralConfig);
				if (result == null) result = caseIENamedElementConfig(eEnumLiteralConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ECLASS_CONFIG: {
				EClassConfig eClassConfig = (EClassConfig)theEObject;
				T result = caseEClassConfig(eClassConfig);
				if (result == null) result = caseIEClassConfig(eClassConfig);
				if (result == null) result = caseIEAttributeConfig(eClassConfig);
				if (result == null) result = caseIEReferenceConfig(eClassConfig);
				if (result == null) result = caseIEClassifierConfig(eClassConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eClassConfig);
				if (result == null) result = caseIENamedElementConfig(eClassConfig);
				if (result == null) result = caseIDefaultValueConfig(eClassConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EATTRIBUTE_CONFIG: {
				EAttributeConfig eAttributeConfig = (EAttributeConfig)theEObject;
				T result = caseEAttributeConfig(eAttributeConfig);
				if (result == null) result = caseIEAttributeConfig(eAttributeConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eAttributeConfig);
				if (result == null) result = caseIENamedElementConfig(eAttributeConfig);
				if (result == null) result = caseIDefaultValueConfig(eAttributeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.AE_REFERENCE_CONFIG: {
				AEReferenceConfig aeReferenceConfig = (AEReferenceConfig)theEObject;
				T result = caseAEReferenceConfig(aeReferenceConfig);
				if (result == null) result = caseIEReferenceConfig(aeReferenceConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(aeReferenceConfig);
				if (result == null) result = caseIENamedElementConfig(aeReferenceConfig);
				if (result == null) result = caseIDefaultValueConfig(aeReferenceConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ECONTAINMENT_CONFIG: {
				EContainmentConfig eContainmentConfig = (EContainmentConfig)theEObject;
				T result = caseEContainmentConfig(eContainmentConfig);
				if (result == null) result = caseAEReferenceConfig(eContainmentConfig);
				if (result == null) result = caseIEReferenceConfig(eContainmentConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eContainmentConfig);
				if (result == null) result = caseIENamedElementConfig(eContainmentConfig);
				if (result == null) result = caseIDefaultValueConfig(eContainmentConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EREFERENCE_CONFIG: {
				EReferenceConfig eReferenceConfig = (EReferenceConfig)theEObject;
				T result = caseEReferenceConfig(eReferenceConfig);
				if (result == null) result = caseAEReferenceConfig(eReferenceConfig);
				if (result == null) result = caseIEReferenceConfig(eReferenceConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eReferenceConfig);
				if (result == null) result = caseIENamedElementConfig(eReferenceConfig);
				if (result == null) result = caseIDefaultValueConfig(eReferenceConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Named Element Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Named Element Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIENamedElementConfig(IENamedElementConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDefault Value Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDefault Value Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDefaultValueConfig(IDefaultValueConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Classifier Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Classifier Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEClassifierConfig(IEClassifierConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Data Type Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Data Type Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEDataTypeConfig(IEDataTypeConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Enum Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Enum Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEEnumConfig(IEEnumConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Class Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Class Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEClassConfig(IEClassConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Structural Feature Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Structural Feature Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEStructuralFeatureConfig(IEStructuralFeatureConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Attribute Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Attribute Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEAttributeConfig(IEAttributeConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Reference Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Reference Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEReferenceConfig(IEReferenceConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Package Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Package Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEPackageConfig(IEPackageConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Enum Literal Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Enum Literal Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEEnumLiteralConfig(IEEnumLiteralConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecore Doc Generator Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecore Doc Generator Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEcoreDocGeneratorConfig(EcoreDocGeneratorConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPackage Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPackage Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPackageConfig(EPackageConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EData Type Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EData Type Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDataTypeConfig(EDataTypeConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EEnum Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EEnum Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEEnumConfig(EEnumConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EEnum Literal Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EEnum Literal Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEEnumLiteralConfig(EEnumLiteralConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClass Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClass Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEClassConfig(EClassConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EAttribute Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EAttribute Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAttributeConfig(EAttributeConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AE Reference Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AE Reference Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAEReferenceConfig(AEReferenceConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EContainment Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EContainment Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEContainmentConfig(EContainmentConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EReference Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EReference Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEReferenceConfig(EReferenceConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ConfigSwitch
