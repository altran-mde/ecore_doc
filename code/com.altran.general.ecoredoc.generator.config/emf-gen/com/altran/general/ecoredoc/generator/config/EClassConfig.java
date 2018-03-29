/**
 */
package com.altran.general.ecoredoc.generator.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EClass Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getEAttribute <em>EAttribute</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEClassConfig()
 * @model
 * @generated
 */
public interface EClassConfig extends IEcoreDocGeneratorPartConfig {
	/**
	 * Returns the value of the '<em><b>EAttribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EAttribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EAttribute</em>' containment reference.
	 * @see #setEAttribute(EAttributeConfig)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEClassConfig_EAttribute()
	 * @model containment="true"
	 * @generated
	 */
	EAttributeConfig getEAttribute();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getEAttribute <em>EAttribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EAttribute</em>' containment reference.
	 * @see #getEAttribute()
	 * @generated
	 */
	void setEAttribute(EAttributeConfig value);

} // EClassConfig
