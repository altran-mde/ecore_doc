/**
 */
package com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage
 * @generated
 */
public interface EcoredocExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcoredocExtensionFactory eINSTANCE = com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoredocExtensionFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Ecore Doc Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecore Doc Generation</em>'.
	 * @generated
	 */
	EcoreDocGeneration createEcoreDocGeneration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EcoredocExtensionPackage getEcoredocExtensionPackage();

} //EcoredocExtensionFactory
