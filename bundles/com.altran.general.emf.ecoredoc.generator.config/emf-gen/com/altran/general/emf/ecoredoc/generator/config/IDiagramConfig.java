/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IDiagram Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.IDiagramConfig#isRenderDiagrams <em>Render Diagrams</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIDiagramConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IDiagramConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Render Diagrams</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether diagrams should be rendered.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Render Diagrams</em>' attribute.
	 * @see #isSetRenderDiagrams()
	 * @see #unsetRenderDiagrams()
	 * @see #setRenderDiagrams(boolean)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIDiagramConfig_RenderDiagrams()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRenderDiagrams();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IDiagramConfig#isRenderDiagrams <em>Render Diagrams</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Diagrams</em>' attribute.
	 * @see #isSetRenderDiagrams()
	 * @see #unsetRenderDiagrams()
	 * @see #isRenderDiagrams()
	 * @generated
	 */
	void setRenderDiagrams(boolean value);

	/**
	 * Unsets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IDiagramConfig#isRenderDiagrams <em>Render Diagrams</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRenderDiagrams()
	 * @see #isRenderDiagrams()
	 * @see #setRenderDiagrams(boolean)
	 * @generated
	 */
	void unsetRenderDiagrams();

	/**
	 * Returns whether the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IDiagramConfig#isRenderDiagrams <em>Render Diagrams</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Render Diagrams</em>' attribute is set.
	 * @see #unsetRenderDiagrams()
	 * @see #isRenderDiagrams()
	 * @see #setRenderDiagrams(boolean)
	 * @generated
	 */
	boolean isSetRenderDiagrams();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Traverses the tree to find the most specific <tt>renderDiagrams</tt> setting.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	boolean shouldRenderDiagrams();

} // IDiagramConfig
