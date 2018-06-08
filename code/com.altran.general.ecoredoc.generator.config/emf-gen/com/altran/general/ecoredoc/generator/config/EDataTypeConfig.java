/**
 */
package com.altran.general.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EData Type Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EDataTypeConfig#getTargetEDataType <em>Target EData Type</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEDataTypeConfig()
 * @model
 * @generated
 */
public interface EDataTypeConfig extends IEDataTypeConfig {
	/**
	 * Returns the value of the '<em><b>Target EData Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EData Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EData Type</em>' reference.
	 * @see #setTargetEDataType(EDataType)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEDataTypeConfig_TargetEDataType()
	 * @model
	 * @generated
	 */
	EDataType getTargetEDataType();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EDataTypeConfig#getTargetEDataType <em>Target EData Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EData Type</em>' reference.
	 * @see #getTargetEDataType()
	 * @generated
	 */
	void setTargetEDataType(EDataType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTargetEDataType();'"
	 * @generated
	 */
	ENamedElement getTarget();

} // EDataTypeConfig
