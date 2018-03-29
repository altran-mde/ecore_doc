/**
 */
package com.altran.general.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EStructural Feature Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EStructuralFeatureConfig#isOrdered <em>Ordered</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEStructuralFeatureConfig()
 * @model abstract="true"
 * @generated
 */
public interface EStructuralFeatureConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered</em>' attribute.
	 * @see #setOrdered(boolean)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEStructuralFeatureConfig_Ordered()
	 * @model unique="false"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EStructuralFeatureConfig#isOrdered <em>Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordered</em>' attribute.
	 * @see #isOrdered()
	 * @generated
	 */
	void setOrdered(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.isOrdered();'"
	 * @generated
	 */
	boolean renderOrdered();

} // EStructuralFeatureConfig
