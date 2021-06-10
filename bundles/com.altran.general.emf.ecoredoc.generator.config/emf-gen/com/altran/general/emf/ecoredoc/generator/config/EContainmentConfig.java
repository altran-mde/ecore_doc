/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EContainment Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig#getTargetEContainment <em>Target EContainment</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEContainmentConfig()
 * @model
 * @generated
 */
public interface EContainmentConfig extends AEReferenceConfig {
	/**
	 * Returns the value of the '<em><b>Target EContainment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EContainment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EContainment</em>' reference.
	 * @see #setTargetEContainment(EReference)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEContainmentConfig_TargetEContainment()
	 * @model
	 * @generated
	 */
	EReference getTargetEContainment();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig#getTargetEContainment <em>Target EContainment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EContainment</em>' reference.
	 * @see #getTargetEContainment()
	 * @generated
	 */
	void setTargetEContainment(EReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	ENamedElement getTarget();

} // EContainmentConfig
