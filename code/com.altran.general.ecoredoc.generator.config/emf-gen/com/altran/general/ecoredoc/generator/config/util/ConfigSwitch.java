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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG: {
				EcoreDocGeneratorConfig ecoreDocGeneratorConfig = (EcoreDocGeneratorConfig)theEObject;
				T result = caseEcoreDocGeneratorConfig(ecoreDocGeneratorConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.IECORE_DOC_GENERATOR_PART_CONFIG: {
				IEcoreDocGeneratorPartConfig iEcoreDocGeneratorPartConfig = (IEcoreDocGeneratorPartConfig)theEObject;
				T result = caseIEcoreDocGeneratorPartConfig(iEcoreDocGeneratorPartConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EDATA_TYPE_CONFIG: {
				EDataTypeConfig eDataTypeConfig = (EDataTypeConfig)theEObject;
				T result = caseEDataTypeConfig(eDataTypeConfig);
				if (result == null) result = caseIEcoreDocGeneratorPartConfig(eDataTypeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EENUM_CONFIG: {
				EEnumConfig eEnumConfig = (EEnumConfig)theEObject;
				T result = caseEEnumConfig(eEnumConfig);
				if (result == null) result = caseIEcoreDocGeneratorPartConfig(eEnumConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ECLASS_CONFIG: {
				EClassConfig eClassConfig = (EClassConfig)theEObject;
				T result = caseEClassConfig(eClassConfig);
				if (result == null) result = caseIEcoreDocGeneratorPartConfig(eClassConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ESTRUCTURAL_FEATURE_CONFIG: {
				EStructuralFeatureConfig eStructuralFeatureConfig = (EStructuralFeatureConfig)theEObject;
				T result = caseEStructuralFeatureConfig(eStructuralFeatureConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EATTRIBUTE_CONFIG: {
				EAttributeConfig eAttributeConfig = (EAttributeConfig)theEObject;
				T result = caseEAttributeConfig(eAttributeConfig);
				if (result == null) result = caseEStructuralFeatureConfig(eAttributeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>IEcore Doc Generator Part Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEcore Doc Generator Part Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEcoreDocGeneratorPartConfig(IEcoreDocGeneratorPartConfig object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>EStructural Feature Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EStructural Feature Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStructuralFeatureConfig(EStructuralFeatureConfig object) {
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
