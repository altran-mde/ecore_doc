/**
 */
package com.altran.general.ecoredoc.generator.config;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EReference Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EReferenceConfig#getTargetEReference <em>Target EReference</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEReferenceConfig()
 * @model
 * @generated
 */
public interface EReferenceConfig extends AEReferenceConfig {
	/**
	 * Returns the value of the '<em><b>Target EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EReference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EReference</em>' reference.
	 * @see #setTargetEReference(EReference)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEReferenceConfig_TargetEReference()
	 * @model
	 * @generated
	 */
	EReference getTargetEReference();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EReferenceConfig#getTargetEReference <em>Target EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EReference</em>' reference.
	 * @see #getTargetEReference()
	 * @generated
	 */
	void setTargetEReference(EReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTargetEReference();'"
	 * @generated
	 */
	ENamedElement getTarget();

} // EReferenceConfig
