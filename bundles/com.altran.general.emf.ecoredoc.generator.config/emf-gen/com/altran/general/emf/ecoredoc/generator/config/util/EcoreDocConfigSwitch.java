/**
 */
package com.altran.general.emf.ecoredoc.generator.config.util;

import com.altran.general.emf.ecoredoc.generator.config.*;

import java.util.List;

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
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage
 * @generated
 */
public class EcoreDocConfigSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EcoreDocConfigPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreDocConfigSwitch() {
		if (modelPackage == null) {
			modelPackage = EcoreDocConfigPackage.eINSTANCE;
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
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EcoreDocConfigPackage.IE_NAMED_ELEMENT_CONFIG: {
				IENamedElementConfig ieNamedElementConfig = (IENamedElementConfig)theEObject;
				T1 result = caseIENamedElementConfig(ieNamedElementConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IDEFAULT_VALUE_CONFIG: {
				IDefaultValueConfig iDefaultValueConfig = (IDefaultValueConfig)theEObject;
				T1 result = caseIDefaultValueConfig(iDefaultValueConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IDIAGRAM_CONFIG: {
				IDiagramConfig iDiagramConfig = (IDiagramConfig)theEObject;
				T1 result = caseIDiagramConfig(iDiagramConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_CLASSIFIER_CONFIG: {
				IEClassifierConfig ieClassifierConfig = (IEClassifierConfig)theEObject;
				T1 result = caseIEClassifierConfig(ieClassifierConfig);
				if (result == null) result = caseIENamedElementConfig(ieClassifierConfig);
				if (result == null) result = caseIDefaultValueConfig(ieClassifierConfig);
				if (result == null) result = caseIDiagramConfig(ieClassifierConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_DATA_TYPE_CONFIG: {
				IEDataTypeConfig ieDataTypeConfig = (IEDataTypeConfig)theEObject;
				T1 result = caseIEDataTypeConfig(ieDataTypeConfig);
				if (result == null) result = caseIEClassifierConfig(ieDataTypeConfig);
				if (result == null) result = caseIENamedElementConfig(ieDataTypeConfig);
				if (result == null) result = caseIDefaultValueConfig(ieDataTypeConfig);
				if (result == null) result = caseIDiagramConfig(ieDataTypeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_ENUM_CONFIG: {
				IEEnumConfig ieEnumConfig = (IEEnumConfig)theEObject;
				T1 result = caseIEEnumConfig(ieEnumConfig);
				if (result == null) result = caseIEDataTypeConfig(ieEnumConfig);
				if (result == null) result = caseIEClassifierConfig(ieEnumConfig);
				if (result == null) result = caseIENamedElementConfig(ieEnumConfig);
				if (result == null) result = caseIDefaultValueConfig(ieEnumConfig);
				if (result == null) result = caseIDiagramConfig(ieEnumConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_CLASS_CONFIG: {
				IEClassConfig ieClassConfig = (IEClassConfig)theEObject;
				T1 result = caseIEClassConfig(ieClassConfig);
				if (result == null) result = caseIEClassifierConfig(ieClassConfig);
				if (result == null) result = caseIENamedElementConfig(ieClassConfig);
				if (result == null) result = caseIDefaultValueConfig(ieClassConfig);
				if (result == null) result = caseIDiagramConfig(ieClassConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_TYPED_ELEMENT_CONFIG: {
				IETypedElementConfig ieTypedElementConfig = (IETypedElementConfig)theEObject;
				T1 result = caseIETypedElementConfig(ieTypedElementConfig);
				if (result == null) result = caseIENamedElementConfig(ieTypedElementConfig);
				if (result == null) result = caseIDefaultValueConfig(ieTypedElementConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_STRUCTURAL_FEATURE_CONFIG: {
				IEStructuralFeatureConfig ieStructuralFeatureConfig = (IEStructuralFeatureConfig)theEObject;
				T1 result = caseIEStructuralFeatureConfig(ieStructuralFeatureConfig);
				if (result == null) result = caseIETypedElementConfig(ieStructuralFeatureConfig);
				if (result == null) result = caseIENamedElementConfig(ieStructuralFeatureConfig);
				if (result == null) result = caseIDefaultValueConfig(ieStructuralFeatureConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_ATTRIBUTE_CONFIG: {
				IEAttributeConfig ieAttributeConfig = (IEAttributeConfig)theEObject;
				T1 result = caseIEAttributeConfig(ieAttributeConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(ieAttributeConfig);
				if (result == null) result = caseIETypedElementConfig(ieAttributeConfig);
				if (result == null) result = caseIENamedElementConfig(ieAttributeConfig);
				if (result == null) result = caseIDefaultValueConfig(ieAttributeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_REFERENCE_CONFIG: {
				IEReferenceConfig ieReferenceConfig = (IEReferenceConfig)theEObject;
				T1 result = caseIEReferenceConfig(ieReferenceConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(ieReferenceConfig);
				if (result == null) result = caseIETypedElementConfig(ieReferenceConfig);
				if (result == null) result = caseIENamedElementConfig(ieReferenceConfig);
				if (result == null) result = caseIDefaultValueConfig(ieReferenceConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_OPERATION_CONFIG: {
				IEOperationConfig ieOperationConfig = (IEOperationConfig)theEObject;
				T1 result = caseIEOperationConfig(ieOperationConfig);
				if (result == null) result = caseIETypedElementConfig(ieOperationConfig);
				if (result == null) result = caseIENamedElementConfig(ieOperationConfig);
				if (result == null) result = caseIDefaultValueConfig(ieOperationConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_PARAMETER_CONFIG: {
				IEParameterConfig ieParameterConfig = (IEParameterConfig)theEObject;
				T1 result = caseIEParameterConfig(ieParameterConfig);
				if (result == null) result = caseIETypedElementConfig(ieParameterConfig);
				if (result == null) result = caseIENamedElementConfig(ieParameterConfig);
				if (result == null) result = caseIDefaultValueConfig(ieParameterConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_PACKAGE_CONFIG: {
				IEPackageConfig iePackageConfig = (IEPackageConfig)theEObject;
				T1 result = caseIEPackageConfig(iePackageConfig);
				if (result == null) result = caseIENamedElementConfig(iePackageConfig);
				if (result == null) result = caseIDiagramConfig(iePackageConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.IE_ENUM_LITERAL_CONFIG: {
				IEEnumLiteralConfig ieEnumLiteralConfig = (IEEnumLiteralConfig)theEObject;
				T1 result = caseIEEnumLiteralConfig(ieEnumLiteralConfig);
				if (result == null) result = caseIENamedElementConfig(ieEnumLiteralConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.ECORE_DOC_GENERATOR_CONFIG: {
				EcoreDocGeneratorConfig ecoreDocGeneratorConfig = (EcoreDocGeneratorConfig)theEObject;
				T1 result = caseEcoreDocGeneratorConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEPackageConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEEnumConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEEnumLiteralConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEClassConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEAttributeConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEReferenceConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEOperationConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEParameterConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEDataTypeConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIEClassifierConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIETypedElementConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIENamedElementConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIDiagramConfig(ecoreDocGeneratorConfig);
				if (result == null) result = caseIDefaultValueConfig(ecoreDocGeneratorConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.EPACKAGE_CONFIG: {
				EPackageConfig ePackageConfig = (EPackageConfig)theEObject;
				T1 result = caseEPackageConfig(ePackageConfig);
				if (result == null) result = caseIEPackageConfig(ePackageConfig);
				if (result == null) result = caseIEEnumConfig(ePackageConfig);
				if (result == null) result = caseIEEnumLiteralConfig(ePackageConfig);
				if (result == null) result = caseIEClassConfig(ePackageConfig);
				if (result == null) result = caseIEAttributeConfig(ePackageConfig);
				if (result == null) result = caseIEReferenceConfig(ePackageConfig);
				if (result == null) result = caseIEOperationConfig(ePackageConfig);
				if (result == null) result = caseIEParameterConfig(ePackageConfig);
				if (result == null) result = caseIEDataTypeConfig(ePackageConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(ePackageConfig);
				if (result == null) result = caseIEClassifierConfig(ePackageConfig);
				if (result == null) result = caseIETypedElementConfig(ePackageConfig);
				if (result == null) result = caseIENamedElementConfig(ePackageConfig);
				if (result == null) result = caseIDiagramConfig(ePackageConfig);
				if (result == null) result = caseIDefaultValueConfig(ePackageConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.EDATA_TYPE_CONFIG: {
				EDataTypeConfig eDataTypeConfig = (EDataTypeConfig)theEObject;
				T1 result = caseEDataTypeConfig(eDataTypeConfig);
				if (result == null) result = caseIEDataTypeConfig(eDataTypeConfig);
				if (result == null) result = caseIEClassifierConfig(eDataTypeConfig);
				if (result == null) result = caseIENamedElementConfig(eDataTypeConfig);
				if (result == null) result = caseIDefaultValueConfig(eDataTypeConfig);
				if (result == null) result = caseIDiagramConfig(eDataTypeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.EENUM_CONFIG: {
				EEnumConfig eEnumConfig = (EEnumConfig)theEObject;
				T1 result = caseEEnumConfig(eEnumConfig);
				if (result == null) result = caseIEEnumConfig(eEnumConfig);
				if (result == null) result = caseIEEnumLiteralConfig(eEnumConfig);
				if (result == null) result = caseIEDataTypeConfig(eEnumConfig);
				if (result == null) result = caseIEClassifierConfig(eEnumConfig);
				if (result == null) result = caseIENamedElementConfig(eEnumConfig);
				if (result == null) result = caseIDefaultValueConfig(eEnumConfig);
				if (result == null) result = caseIDiagramConfig(eEnumConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.EENUM_LITERAL_CONFIG: {
				EEnumLiteralConfig eEnumLiteralConfig = (EEnumLiteralConfig)theEObject;
				T1 result = caseEEnumLiteralConfig(eEnumLiteralConfig);
				if (result == null) result = caseIEEnumLiteralConfig(eEnumLiteralConfig);
				if (result == null) result = caseIENamedElementConfig(eEnumLiteralConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.ECLASS_CONFIG: {
				EClassConfig eClassConfig = (EClassConfig)theEObject;
				T1 result = caseEClassConfig(eClassConfig);
				if (result == null) result = caseIEClassConfig(eClassConfig);
				if (result == null) result = caseIEAttributeConfig(eClassConfig);
				if (result == null) result = caseIEReferenceConfig(eClassConfig);
				if (result == null) result = caseIEOperationConfig(eClassConfig);
				if (result == null) result = caseIEParameterConfig(eClassConfig);
				if (result == null) result = caseIEClassifierConfig(eClassConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eClassConfig);
				if (result == null) result = caseIDiagramConfig(eClassConfig);
				if (result == null) result = caseIETypedElementConfig(eClassConfig);
				if (result == null) result = caseIENamedElementConfig(eClassConfig);
				if (result == null) result = caseIDefaultValueConfig(eClassConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.EATTRIBUTE_CONFIG: {
				EAttributeConfig eAttributeConfig = (EAttributeConfig)theEObject;
				T1 result = caseEAttributeConfig(eAttributeConfig);
				if (result == null) result = caseIEAttributeConfig(eAttributeConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eAttributeConfig);
				if (result == null) result = caseIETypedElementConfig(eAttributeConfig);
				if (result == null) result = caseIENamedElementConfig(eAttributeConfig);
				if (result == null) result = caseIDefaultValueConfig(eAttributeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.AE_REFERENCE_CONFIG: {
				AEReferenceConfig aeReferenceConfig = (AEReferenceConfig)theEObject;
				T1 result = caseAEReferenceConfig(aeReferenceConfig);
				if (result == null) result = caseIEReferenceConfig(aeReferenceConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(aeReferenceConfig);
				if (result == null) result = caseIETypedElementConfig(aeReferenceConfig);
				if (result == null) result = caseIENamedElementConfig(aeReferenceConfig);
				if (result == null) result = caseIDefaultValueConfig(aeReferenceConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.ECONTAINMENT_CONFIG: {
				EContainmentConfig eContainmentConfig = (EContainmentConfig)theEObject;
				T1 result = caseEContainmentConfig(eContainmentConfig);
				if (result == null) result = caseAEReferenceConfig(eContainmentConfig);
				if (result == null) result = caseIEReferenceConfig(eContainmentConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eContainmentConfig);
				if (result == null) result = caseIETypedElementConfig(eContainmentConfig);
				if (result == null) result = caseIENamedElementConfig(eContainmentConfig);
				if (result == null) result = caseIDefaultValueConfig(eContainmentConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.EREFERENCE_CONFIG: {
				EReferenceConfig eReferenceConfig = (EReferenceConfig)theEObject;
				T1 result = caseEReferenceConfig(eReferenceConfig);
				if (result == null) result = caseAEReferenceConfig(eReferenceConfig);
				if (result == null) result = caseIEReferenceConfig(eReferenceConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eReferenceConfig);
				if (result == null) result = caseIETypedElementConfig(eReferenceConfig);
				if (result == null) result = caseIENamedElementConfig(eReferenceConfig);
				if (result == null) result = caseIDefaultValueConfig(eReferenceConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.EOPERATION_CONFIG: {
				EOperationConfig eOperationConfig = (EOperationConfig)theEObject;
				T1 result = caseEOperationConfig(eOperationConfig);
				if (result == null) result = caseAEReferenceConfig(eOperationConfig);
				if (result == null) result = caseIEReferenceConfig(eOperationConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eOperationConfig);
				if (result == null) result = caseIETypedElementConfig(eOperationConfig);
				if (result == null) result = caseIENamedElementConfig(eOperationConfig);
				if (result == null) result = caseIDefaultValueConfig(eOperationConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.EPARAMETER_CONFIG: {
				EParameterConfig eParameterConfig = (EParameterConfig)theEObject;
				T1 result = caseEParameterConfig(eParameterConfig);
				if (result == null) result = caseAEReferenceConfig(eParameterConfig);
				if (result == null) result = caseIEReferenceConfig(eParameterConfig);
				if (result == null) result = caseIEStructuralFeatureConfig(eParameterConfig);
				if (result == null) result = caseIETypedElementConfig(eParameterConfig);
				if (result == null) result = caseIENamedElementConfig(eParameterConfig);
				if (result == null) result = caseIDefaultValueConfig(eParameterConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoreDocConfigPackage.LIST: {
				List<?> list = (List<?>)theEObject;
				T1 result = caseList(list);
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
	public T1 caseIENamedElementConfig(IENamedElementConfig object) {
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
	public T1 caseIDefaultValueConfig(IDefaultValueConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDiagram Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDiagram Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIDiagramConfig(IDiagramConfig object) {
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
	public T1 caseIEClassifierConfig(IEClassifierConfig object) {
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
	public T1 caseIEDataTypeConfig(IEDataTypeConfig object) {
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
	public T1 caseIEEnumConfig(IEEnumConfig object) {
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
	public T1 caseIEClassConfig(IEClassConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Typed Element Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Typed Element Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIETypedElementConfig(IETypedElementConfig object) {
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
	public T1 caseIEStructuralFeatureConfig(IEStructuralFeatureConfig object) {
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
	public T1 caseIEAttributeConfig(IEAttributeConfig object) {
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
	public T1 caseIEReferenceConfig(IEReferenceConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Operation Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Operation Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIEOperationConfig(IEOperationConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Parameter Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Parameter Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIEParameterConfig(IEParameterConfig object) {
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
	public T1 caseIEPackageConfig(IEPackageConfig object) {
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
	public T1 caseIEEnumLiteralConfig(IEEnumLiteralConfig object) {
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
	public T1 caseEcoreDocGeneratorConfig(EcoreDocGeneratorConfig object) {
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
	public T1 caseEPackageConfig(EPackageConfig object) {
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
	public T1 caseEDataTypeConfig(EDataTypeConfig object) {
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
	public T1 caseEEnumConfig(EEnumConfig object) {
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
	public T1 caseEEnumLiteralConfig(EEnumLiteralConfig object) {
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
	public T1 caseEClassConfig(EClassConfig object) {
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
	public T1 caseEAttributeConfig(EAttributeConfig object) {
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
	public T1 caseAEReferenceConfig(AEReferenceConfig object) {
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
	public T1 caseEContainmentConfig(EContainmentConfig object) {
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
	public T1 caseEReferenceConfig(EReferenceConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EOperation Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EOperation Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEOperationConfig(EOperationConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EParameter Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EParameter Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEParameterConfig(EParameterConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseList(List<T> object) {
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
	public T1 defaultCase(EObject object) {
		return null;
	}

} //EcoreDocConfigSwitch
