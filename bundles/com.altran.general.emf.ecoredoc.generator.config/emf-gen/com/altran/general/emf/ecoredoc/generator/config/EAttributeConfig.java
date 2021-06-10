/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EAttribute Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig#getTargetEAttribute <em>Target EAttribute</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEAttributeConfig()
 * @model
 * @generated
 */
public interface EAttributeConfig extends IEAttributeConfig {
	/**
	 * Returns the value of the '<em><b>Target EAttribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EAttribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EAttribute</em>' reference.
	 * @see #setTargetEAttribute(EAttribute)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEAttributeConfig_TargetEAttribute()
	 * @model
	 * @generated
	 */
	EAttribute getTargetEAttribute();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig#getTargetEAttribute <em>Target EAttribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EAttribute</em>' reference.
	 * @see #getTargetEAttribute()
	 * @generated
	 */
	void setTargetEAttribute(EAttribute value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	ENamedElement getTarget();

} // EAttributeConfig
