/**
 */
package com.altran.general.ecoredoc.generator.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEcore Doc Generator Part Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getIEcoreDocGeneratorPartConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IEcoreDocGeneratorPartConfig extends IEcoreDocGeneratorConfig {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #setPosition(int)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getIEcoreDocGeneratorPartConfig_Position()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	int getPosition();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(int value);

	/**
	 * Unsets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPosition()
	 * @see #getPosition()
	 * @see #setPosition(int)
	 * @generated
	 */
	void unsetPosition();

	/**
	 * Returns whether the value of the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig#getPosition <em>Position</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Position</em>' attribute is set.
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @see #setPosition(int)
	 * @generated
	 */
	boolean isSetPosition();

} // IEcoreDocGeneratorPartConfig
