/**
 */
package com.altran.general.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecore Doc Generator Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEDataType <em>EData Type</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEEnum <em>EEnum</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEClass <em>EClass</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEcoreDocGeneratorConfig()
 * @model
 * @generated
 */
public interface EcoreDocGeneratorConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Render Defaults</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Render Defaults</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Render Defaults</em>' attribute.
	 * @see #setRenderDefaults(boolean)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEcoreDocGeneratorConfig_RenderDefaults()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isRenderDefaults();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#isRenderDefaults <em>Render Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Defaults</em>' attribute.
	 * @see #isRenderDefaults()
	 * @generated
	 */
	void setRenderDefaults(boolean value);

	/**
	 * Returns the value of the '<em><b>EData Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EData Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EData Type</em>' containment reference.
	 * @see #setEDataType(EDataTypeConfig)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEcoreDocGeneratorConfig_EDataType()
	 * @model containment="true"
	 * @generated
	 */
	EDataTypeConfig getEDataType();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEDataType <em>EData Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EData Type</em>' containment reference.
	 * @see #getEDataType()
	 * @generated
	 */
	void setEDataType(EDataTypeConfig value);

	/**
	 * Returns the value of the '<em><b>EEnum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EEnum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EEnum</em>' containment reference.
	 * @see #setEEnum(EEnumConfig)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEcoreDocGeneratorConfig_EEnum()
	 * @model containment="true"
	 * @generated
	 */
	EEnumConfig getEEnum();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEEnum <em>EEnum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EEnum</em>' containment reference.
	 * @see #getEEnum()
	 * @generated
	 */
	void setEEnum(EEnumConfig value);

	/**
	 * Returns the value of the '<em><b>EClass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClass</em>' containment reference.
	 * @see #setEClass(EClassConfig)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEcoreDocGeneratorConfig_EClass()
	 * @model containment="true"
	 * @generated
	 */
	EClassConfig getEClass();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEClass <em>EClass</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass</em>' containment reference.
	 * @see #getEClass()
	 * @generated
	 */
	void setEClass(EClassConfig value);

} // EcoreDocGeneratorConfig
