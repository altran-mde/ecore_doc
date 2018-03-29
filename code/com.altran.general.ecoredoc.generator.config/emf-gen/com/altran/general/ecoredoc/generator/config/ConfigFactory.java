/**
 */
package com.altran.general.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage
 * @generated
 */
public interface ConfigFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigFactory eINSTANCE = com.altran.general.ecoredoc.generator.config.impl.ConfigFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ecore Doc Generator Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecore Doc Generator Config</em>'.
	 * @generated
	 */
	EcoreDocGeneratorConfig createEcoreDocGeneratorConfig();

	/**
	 * Returns a new object of class '<em>EData Type Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EData Type Config</em>'.
	 * @generated
	 */
	EDataTypeConfig createEDataTypeConfig();

	/**
	 * Returns a new object of class '<em>EEnum Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EEnum Config</em>'.
	 * @generated
	 */
	EEnumConfig createEEnumConfig();

	/**
	 * Returns a new object of class '<em>EClass Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClass Config</em>'.
	 * @generated
	 */
	EClassConfig createEClassConfig();

	/**
	 * Returns a new object of class '<em>EAttribute Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EAttribute Config</em>'.
	 * @generated
	 */
	EAttributeConfig createEAttributeConfig();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConfigPackage getConfigPackage();

} //ConfigFactory
