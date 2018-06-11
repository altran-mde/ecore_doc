/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPackage Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getTargetEPackage <em>Target EPackage</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getEDataTypes <em>EData Types</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getEEnums <em>EEnums</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getEClasses <em>EClasses</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.ConfigPackage#getEPackageConfig()
 * @model
 * @generated
 */
public interface EPackageConfig extends IEPackageConfig, IEEnumConfig, IEEnumLiteralConfig, IEClassConfig, IEAttributeConfig, IEReferenceConfig {
	/**
	 * Returns the value of the '<em><b>Target EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EPackage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EPackage</em>' reference.
	 * @see #setTargetEPackage(EPackage)
	 * @see com.altran.general.emf.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_TargetEPackage()
	 * @model
	 * @generated
	 */
	EPackage getTargetEPackage();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig#getTargetEPackage <em>Target EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EPackage</em>' reference.
	 * @see #getTargetEPackage()
	 * @generated
	 */
	void setTargetEPackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>EData Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EData Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EData Types</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_EDataTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EDataTypeConfig> getEDataTypes();

	/**
	 * Returns the value of the '<em><b>EEnums</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EEnums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EEnums</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_EEnums()
	 * @model containment="true"
	 * @generated
	 */
	EList<EEnumConfig> getEEnums();

	/**
	 * Returns the value of the '<em><b>EClasses</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClasses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClasses</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_EClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<EClassConfig> getEClasses();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTargetEPackage();'"
	 * @generated
	 */
	ENamedElement getTarget();

} // EPackageConfig
