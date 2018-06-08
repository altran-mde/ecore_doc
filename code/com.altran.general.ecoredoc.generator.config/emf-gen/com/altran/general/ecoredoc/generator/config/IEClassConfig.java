/**
 */
package com.altran.general.ecoredoc.generator.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IE Class Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getIEClassConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IEClassConfig extends IEcoreDocGeneratorConfig {
	/**
	 * Returns the value of the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeat Inherited</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat Inherited</em>' attribute.
	 * @see #isSetRepeatInherited()
	 * @see #unsetRepeatInherited()
	 * @see #setRepeatInherited(boolean)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getIEClassConfig_RepeatInherited()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRepeatInherited();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat Inherited</em>' attribute.
	 * @see #isSetRepeatInherited()
	 * @see #unsetRepeatInherited()
	 * @see #isRepeatInherited()
	 * @generated
	 */
	void setRepeatInherited(boolean value);

	/**
	 * Unsets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepeatInherited()
	 * @see #isRepeatInherited()
	 * @see #setRepeatInherited(boolean)
	 * @generated
	 */
	void unsetRepeatInherited();

	/**
	 * Returns whether the value of the '{@link com.altran.general.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Repeat Inherited</em>' attribute is set.
	 * @see #unsetRepeatInherited()
	 * @see #isRepeatInherited()
	 * @see #setRepeatInherited(boolean)
	 * @generated
	 */
	boolean isSetRepeatInherited();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRepeatInherited = this.isSetRepeatInherited();\nif (_isSetRepeatInherited)\n{\n\t_xifexpression = this.isRepeatInherited();\n}\nelse\n{\n\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t_xifexpression = ((&lt;%com.altran.general.ecoredoc.generator.config.IEClassConfig%&gt;) _eContainer).shouldRepeatInherited();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRepeatInherited();

} // IEClassConfig
