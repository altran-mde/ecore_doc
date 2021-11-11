/**
 */
package com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl;

import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.*;

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
public class EcoredocExtensionFactoryImpl extends EFactoryImpl implements EcoredocExtensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EcoredocExtensionFactory init() {
		try {
			EcoredocExtensionFactory theEcoredocExtensionFactory = (EcoredocExtensionFactory) EPackage.Registry.INSTANCE
					.getEFactory(EcoredocExtensionPackage.eNS_URI);
			if (theEcoredocExtensionFactory != null) {
				return theEcoredocExtensionFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EcoredocExtensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoredocExtensionFactoryImpl() {
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
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION:
			return createEcoreDocGeneration();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EcoreDocGeneration createEcoreDocGeneration() {
		EcoreDocGenerationImpl ecoreDocGeneration = new EcoreDocGenerationImpl();
		return ecoreDocGeneration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EcoredocExtensionPackage getEcoredocExtensionPackage() {
		return (EcoredocExtensionPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EcoredocExtensionPackage getPackage() {
		return EcoredocExtensionPackage.eINSTANCE;
	}

} //EcoredocExtensionFactoryImpl
