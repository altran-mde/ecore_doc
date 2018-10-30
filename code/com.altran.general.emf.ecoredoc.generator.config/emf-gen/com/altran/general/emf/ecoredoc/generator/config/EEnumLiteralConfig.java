/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEnum Literal Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig#getTargetEEnumLiteral <em>Target EEnum Literal</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEEnumLiteralConfig()
 * @model
 * @generated
 */
public interface EEnumLiteralConfig extends IEEnumLiteralConfig {
	/**
	 * Returns the value of the '<em><b>Target EEnum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EEnum Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EEnum Literal</em>' reference.
	 * @see #setTargetEEnumLiteral(EEnumLiteral)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEEnumLiteralConfig_TargetEEnumLiteral()
	 * @model
	 * @generated
	 */
	EEnumLiteral getTargetEEnumLiteral();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig#getTargetEEnumLiteral <em>Target EEnum Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EEnum Literal</em>' reference.
	 * @see #getTargetEEnumLiteral()
	 * @generated
	 */
	void setTargetEEnumLiteral(EEnumLiteral value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	ENamedElement getTarget();

} // EEnumLiteralConfig
