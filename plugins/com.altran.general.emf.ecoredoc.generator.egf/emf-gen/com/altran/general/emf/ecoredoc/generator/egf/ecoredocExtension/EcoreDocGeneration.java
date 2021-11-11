/**
 */
package com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension;

import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecore Doc Generation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#getOutputFolder <em>Output Folder</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#isResolve <em>Resolve</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage#getEcoreDocGeneration()
 * @model
 * @generated
 */
public interface EcoreDocGeneration extends EcoreElement {
	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage#getEcoreDocGeneration_ProjectName()
	 * @model required="true"
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Output Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Folder</em>' attribute.
	 * @see #setOutputFolder(String)
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage#getEcoreDocGeneration_OutputFolder()
	 * @model required="true"
	 * @generated
	 */
	String getOutputFolder();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#getOutputFolder <em>Output Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Folder</em>' attribute.
	 * @see #getOutputFolder()
	 * @generated
	 */
	void setOutputFolder(String value);

	/**
	 * Returns the value of the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolve</em>' attribute.
	 * @see #setResolve(boolean)
	 * @see com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage#getEcoreDocGeneration_Resolve()
	 * @model required="true"
	 * @generated
	 */
	boolean isResolve();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration#isResolve <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolve</em>' attribute.
	 * @see #isResolve()
	 * @generated
	 */
	void setResolve(boolean value);

} // EcoreDocGeneration
