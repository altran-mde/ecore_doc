/**
 */
package com.altran.general.ecoredoc.generator.config;

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
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EAttributeConfig#getTargetEAttribute <em>Target EAttribute</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEAttributeConfig()
 * @model
 * @generated
 */
public interface EAttributeConfig extends AEStructuralFeatureConfig {

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
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEAttributeConfig_TargetEAttribute()
	 * @model
	 * @generated
	 */
	EAttribute getTargetEAttribute();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EAttributeConfig#getTargetEAttribute <em>Target EAttribute</em>}' reference.
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTargetEAttribute();'"
	 * @generated
	 */
	ENamedElement getTarget();
} // EAttributeConfig
