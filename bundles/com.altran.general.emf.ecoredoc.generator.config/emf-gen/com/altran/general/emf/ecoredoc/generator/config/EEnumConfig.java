/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEnum Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#getTargetEEnum <em>Target EEnum</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#getEEnumLiterals <em>EEnum Literals</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEEnumConfig()
 * @model
 * @generated
 */
public interface EEnumConfig extends IEEnumConfig, IEEnumLiteralConfig {
	/**
	 * Returns the value of the '<em><b>Target EEnum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EEnum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EEnum</em>' reference.
	 * @see #setTargetEEnum(EEnum)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEEnumConfig_TargetEEnum()
	 * @model
	 * @generated
	 */
	EEnum getTargetEEnum();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig#getTargetEEnum <em>Target EEnum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EEnum</em>' reference.
	 * @see #getTargetEEnum()
	 * @generated
	 */
	void setTargetEEnum(EEnum value);

	/**
	 * Returns the value of the '<em><b>EEnum Literals</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EEnum Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EEnum Literals</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEEnumConfig_EEnumLiterals()
	 * @model containment="true"
	 * @generated
	 */
	EList<EEnumLiteralConfig> getEEnumLiterals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	ENamedElement getTarget();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method for {@linkplain org.eclipse.sisu.plexus.CompositeBeanHelper#setProperty()} to handle ELists correctly.
	 * <!-- end-model-doc -->
	 * @model eEnumLiteralConfigType="com.altran.general.emf.ecoredoc.generator.config.List&lt;com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig&gt;" eEnumLiteralConfigUnique="false" eEnumLiteralConfigMany="false"
	 * @generated
	 */
	void addEEnumLiterals(List<EEnumLiteralConfig> eEnumLiteralConfig);

} // EEnumConfig
