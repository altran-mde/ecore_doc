/**
 */
package com.altran.general.ecoredoc.generator.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EClass Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getTargetEClass <em>Target EClass</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getEAttributes <em>EAttributes</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getEContainments <em>EContainments</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getEReferences <em>EReferences</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEClassConfig()
 * @model
 * @generated
 */
public interface EClassConfig extends IEClassConfig, IEAttributeConfig, IEReferenceConfig {
	/**
	 * Returns the value of the '<em><b>Target EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EClass</em>' reference.
	 * @see #setTargetEClass(EClass)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEClassConfig_TargetEClass()
	 * @model
	 * @generated
	 */
	EClass getTargetEClass();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EClassConfig#getTargetEClass <em>Target EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EClass</em>' reference.
	 * @see #getTargetEClass()
	 * @generated
	 */
	void setTargetEClass(EClass value);

	/**
	 * Returns the value of the '<em><b>EAttributes</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.ecoredoc.generator.config.EAttributeConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EAttributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EAttributes</em>' containment reference list.
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEClassConfig_EAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EAttributeConfig> getEAttributes();

	/**
	 * Returns the value of the '<em><b>EContainments</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.ecoredoc.generator.config.EContainmentConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EContainments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EContainments</em>' containment reference list.
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEClassConfig_EContainments()
	 * @model containment="true"
	 * @generated
	 */
	EList<EContainmentConfig> getEContainments();

	/**
	 * Returns the value of the '<em><b>EReferences</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.ecoredoc.generator.config.EReferenceConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReferences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReferences</em>' containment reference list.
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEClassConfig_EReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<EReferenceConfig> getEReferences();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTargetEClass();'"
	 * @generated
	 */
	ENamedElement getTarget();

} // EClassConfig
