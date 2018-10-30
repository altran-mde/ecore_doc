/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EOperation Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getTargetEOperation <em>Target EOperation</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getEParameters <em>EParameters</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEOperationConfig()
 * @model
 * @generated
 */
public interface EOperationConfig extends AEReferenceConfig {
	/**
	 * Returns the value of the '<em><b>Target EOperation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EOperation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EOperation</em>' reference.
	 * @see #setTargetEOperation(EOperation)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEOperationConfig_TargetEOperation()
	 * @model
	 * @generated
	 */
	EOperation getTargetEOperation();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getTargetEOperation <em>Target EOperation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EOperation</em>' reference.
	 * @see #getTargetEOperation()
	 * @generated
	 */
	void setTargetEOperation(EOperation value);

	/**
	 * Returns the value of the '<em><b>EParameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EParameterConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EParameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EParameters</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEOperationConfig_EParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<EParameterConfig> getEParameters();

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
	 * @model eParameterConfigType="com.altran.general.emf.ecoredoc.generator.config.List&lt;com.altran.general.emf.ecoredoc.generator.config.EParameterConfig&gt;" eParameterConfigUnique="false" eParameterConfigMany="false"
	 * @generated
	 */
	void addEParameters(List<EParameterConfig> eParameterConfig);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	String getId();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" eOperationUnique="false"
	 * @generated
	 */
	String joinId(EOperation eOperation);

} // EOperationConfig
