/**
 */
package com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl;

import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration;
import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionFactory;
import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoredocExtensionPackageImpl extends EPackageImpl implements EcoredocExtensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecoreDocGenerationEClass = null;

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
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EcoredocExtensionPackageImpl() {
		super(eNS_URI, EcoredocExtensionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EcoredocExtensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EcoredocExtensionPackage init() {
		if (isInited)
			return (EcoredocExtensionPackage) EPackage.Registry.INSTANCE.getEPackage(EcoredocExtensionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEcoredocExtensionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EcoredocExtensionPackageImpl theEcoredocExtensionPackage = registeredEcoredocExtensionPackage instanceof EcoredocExtensionPackageImpl
				? (EcoredocExtensionPackageImpl) registeredEcoredocExtensionPackage
				: new EcoredocExtensionPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		GenerationChainPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEcoredocExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theEcoredocExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEcoredocExtensionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EcoredocExtensionPackage.eNS_URI, theEcoredocExtensionPackage);
		return theEcoredocExtensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEcoreDocGeneration() {
		return ecoreDocGenerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEcoreDocGeneration_ProjectName() {
		return (EAttribute) ecoreDocGenerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEcoreDocGeneration_OutputFolder() {
		return (EAttribute) ecoreDocGenerationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEcoreDocGeneration_Resolve() {
		return (EAttribute) ecoreDocGenerationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EcoredocExtensionFactory getEcoredocExtensionFactory() {
		return (EcoredocExtensionFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		ecoreDocGenerationEClass = createEClass(ECORE_DOC_GENERATION);
		createEAttribute(ecoreDocGenerationEClass, ECORE_DOC_GENERATION__PROJECT_NAME);
		createEAttribute(ecoreDocGenerationEClass, ECORE_DOC_GENERATION__OUTPUT_FOLDER);
		createEAttribute(ecoreDocGenerationEClass, ECORE_DOC_GENERATION__RESOLVE);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GenerationChainPackage theGenerationChainPackage = (GenerationChainPackage) EPackage.Registry.INSTANCE
				.getEPackage(GenerationChainPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ecoreDocGenerationEClass.getESuperTypes().add(theGenerationChainPackage.getEcoreElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(ecoreDocGenerationEClass, EcoreDocGeneration.class, "EcoreDocGeneration", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEcoreDocGeneration_ProjectName(), ecorePackage.getEString(), "projectName", null, 1, 1,
				EcoreDocGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcoreDocGeneration_OutputFolder(), ecorePackage.getEString(), "outputFolder", null, 1, 1,
				EcoreDocGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcoreDocGeneration_Resolve(), ecorePackage.getEBoolean(), "resolve", null, 1, 1,
				EcoreDocGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EcoredocExtensionPackageImpl
