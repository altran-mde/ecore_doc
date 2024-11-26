/**
 */
package com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface EcoredocExtensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ecoredocExtension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.altran.com/egf/ecoredocExtension";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ecoredocExtension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcoredocExtensionPackage eINSTANCE = com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoredocExtensionPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoreDocGenerationImpl <em>Ecore Doc Generation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoreDocGenerationImpl
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoredocExtensionPackageImpl#getEcoreDocGeneration()
	 * @generated
	 */
	int ECORE_DOC_GENERATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATION__NAME = GenerationChainPackage.ECORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATION__CONTAINER = GenerationChainPackage.ECORE_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Model Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATION__MODEL_PATH = GenerationChainPackage.ECORE_ELEMENT__MODEL_PATH;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATION__PROJECT_NAME = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATION__OUTPUT_FOLDER = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATION__RESOLVE = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Ecore Doc Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DOC_GENERATION_FEATURE_COUNT = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Ecore Doc Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int ECORE_DOC_GENERATION_OPERATION_COUNT = 0; //GenerationChainPackage.ECORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration <em>Ecore Doc Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Doc Generation</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration
	 * @generated
	 */
	EClass getEcoreDocGeneration();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#getProjectName()
	 * @see #getEcoreDocGeneration()
	 * @generated
	 */
	EAttribute getEcoreDocGeneration_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#getOutputFolder <em>Output Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Folder</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#getOutputFolder()
	 * @see #getEcoreDocGeneration()
	 * @generated
	 */
	EAttribute getEcoreDocGeneration_OutputFolder();

	/**
	 * Returns the meta object for the attribute '{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#isResolve <em>Resolve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolve</em>'.
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#isResolve()
	 * @see #getEcoreDocGeneration()
	 * @generated
	 */
	EAttribute getEcoreDocGeneration_Resolve();

	/**
	 * The number of operations of the '<em>Ecore Doc Generator Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int ECORE_DOC_GENERATOR_ELEMENT_OPERATION_COUNT = 0; //GenerationChainPackage.ECORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ecore Doc Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int ECORE_DOC_ELEMENT_OPERATION_COUNT = 0; //GenerationChainPackage.ECORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EcoredocExtensionFactory getEcoredocExtensionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoreDocGenerationImpl <em>Ecore Doc Generation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoreDocGenerationImpl
		 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoredocExtensionPackageImpl#getEcoreDocGeneration()
		 * @generated
		 */
		EClass ECORE_DOC_GENERATION = eINSTANCE.getEcoreDocGeneration();
		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_DOC_GENERATION__PROJECT_NAME = eINSTANCE.getEcoreDocGeneration_ProjectName();
		/**
		 * The meta object literal for the '<em><b>Output Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_DOC_GENERATION__OUTPUT_FOLDER = eINSTANCE.getEcoreDocGeneration_OutputFolder();
		/**
		 * The meta object literal for the '<em><b>Resolve</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_DOC_GENERATION__RESOLVE = eINSTANCE.getEcoreDocGeneration_Resolve();

	}

} //EcoredocExtensionPackage
