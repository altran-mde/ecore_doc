/**
 */
package com.altran.general.ecoredoc.generator.config;

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
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEDataTypes <em>Position EData Types</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEEnums <em>Position EEnums</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEClasses <em>Position EClasses</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getTargetEPackage <em>Target EPackage</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getEDataTypes <em>EData Types</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getEEnums <em>EEnums</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getEClasses <em>EClasses</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEPackageConfig()
 * @model
 * @generated
 */
public interface EPackageConfig extends IEPackageConfig, IEEnumConfig, IEEnumLiteralConfig, IEClassConfig, IEAttributeConfig, IEReferenceConfig {
	/**
	 * Returns the value of the '<em><b>Position EData Types</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position EData Types</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position EData Types</em>' attribute.
	 * @see #isSetPositionEDataTypes()
	 * @see #unsetPositionEDataTypes()
	 * @see #setPositionEDataTypes(int)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_PositionEDataTypes()
	 * @model default="1" unique="false" unsettable="true"
	 * @generated
	 */
	int getPositionEDataTypes();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEDataTypes <em>Position EData Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position EData Types</em>' attribute.
	 * @see #isSetPositionEDataTypes()
	 * @see #unsetPositionEDataTypes()
	 * @see #getPositionEDataTypes()
	 * @generated
	 */
	void setPositionEDataTypes(int value);

	/**
	 * Unsets the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEDataTypes <em>Position EData Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPositionEDataTypes()
	 * @see #getPositionEDataTypes()
	 * @see #setPositionEDataTypes(int)
	 * @generated
	 */
	void unsetPositionEDataTypes();

	/**
	 * Returns whether the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEDataTypes <em>Position EData Types</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Position EData Types</em>' attribute is set.
	 * @see #unsetPositionEDataTypes()
	 * @see #getPositionEDataTypes()
	 * @see #setPositionEDataTypes(int)
	 * @generated
	 */
	boolean isSetPositionEDataTypes();

	/**
	 * Returns the value of the '<em><b>Position EEnums</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position EEnums</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position EEnums</em>' attribute.
	 * @see #isSetPositionEEnums()
	 * @see #unsetPositionEEnums()
	 * @see #setPositionEEnums(int)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_PositionEEnums()
	 * @model default="2" unique="false" unsettable="true"
	 * @generated
	 */
	int getPositionEEnums();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEEnums <em>Position EEnums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position EEnums</em>' attribute.
	 * @see #isSetPositionEEnums()
	 * @see #unsetPositionEEnums()
	 * @see #getPositionEEnums()
	 * @generated
	 */
	void setPositionEEnums(int value);

	/**
	 * Unsets the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEEnums <em>Position EEnums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPositionEEnums()
	 * @see #getPositionEEnums()
	 * @see #setPositionEEnums(int)
	 * @generated
	 */
	void unsetPositionEEnums();

	/**
	 * Returns whether the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEEnums <em>Position EEnums</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Position EEnums</em>' attribute is set.
	 * @see #unsetPositionEEnums()
	 * @see #getPositionEEnums()
	 * @see #setPositionEEnums(int)
	 * @generated
	 */
	boolean isSetPositionEEnums();

	/**
	 * Returns the value of the '<em><b>Position EClasses</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position EClasses</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position EClasses</em>' attribute.
	 * @see #isSetPositionEClasses()
	 * @see #unsetPositionEClasses()
	 * @see #setPositionEClasses(int)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_PositionEClasses()
	 * @model default="3" unique="false" unsettable="true"
	 * @generated
	 */
	int getPositionEClasses();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEClasses <em>Position EClasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position EClasses</em>' attribute.
	 * @see #isSetPositionEClasses()
	 * @see #unsetPositionEClasses()
	 * @see #getPositionEClasses()
	 * @generated
	 */
	void setPositionEClasses(int value);

	/**
	 * Unsets the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEClasses <em>Position EClasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPositionEClasses()
	 * @see #getPositionEClasses()
	 * @see #setPositionEClasses(int)
	 * @generated
	 */
	void unsetPositionEClasses();

	/**
	 * Returns whether the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getPositionEClasses <em>Position EClasses</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Position EClasses</em>' attribute is set.
	 * @see #unsetPositionEClasses()
	 * @see #getPositionEClasses()
	 * @see #setPositionEClasses(int)
	 * @generated
	 */
	boolean isSetPositionEClasses();

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
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_TargetEPackage()
	 * @model
	 * @generated
	 */
	EPackage getTargetEPackage();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig#getTargetEPackage <em>Target EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EPackage</em>' reference.
	 * @see #getTargetEPackage()
	 * @generated
	 */
	void setTargetEPackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>EData Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.ecoredoc.generator.config.EDataTypeConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EData Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EData Types</em>' containment reference list.
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_EDataTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EDataTypeConfig> getEDataTypes();

	/**
	 * Returns the value of the '<em><b>EEnums</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.ecoredoc.generator.config.EEnumConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EEnums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EEnums</em>' containment reference list.
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_EEnums()
	 * @model containment="true"
	 * @generated
	 */
	EList<EEnumConfig> getEEnums();

	/**
	 * Returns the value of the '<em><b>EClasses</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.ecoredoc.generator.config.EClassConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClasses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClasses</em>' containment reference list.
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getEPackageConfig_EClasses()
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
