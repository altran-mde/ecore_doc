/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EParameter Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EParameterConfig#getTargetEParameter <em>Target EParameter</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEParameterConfig()
 * @model
 * @generated
 */
public interface EParameterConfig extends AEReferenceConfig {
	/**
	 * Returns the value of the '<em><b>Target EParameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EParameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EParameter</em>' reference.
	 * @see #setTargetEParameter(EParameter)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEParameterConfig_TargetEParameter()
	 * @model
	 * @generated
	 */
	EParameter getTargetEParameter();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EParameterConfig#getTargetEParameter <em>Target EParameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EParameter</em>' reference.
	 * @see #getTargetEParameter()
	 * @generated
	 */
	void setTargetEParameter(EParameter value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTargetEParameter();'"
	 * @generated
	 */
	ENamedElement getTarget();

} // EParameterConfig
