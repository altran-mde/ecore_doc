/**
 */
package com.altran.general.emf.ecoredoc.generator.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IE Class Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSubTypes <em>Render Sub Types</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSuperTypes <em>Render Super Types</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIEClassConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IEClassConfig extends IEClassifierConfig {
	/**
	 * Returns the value of the '<em><b>Repeat Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeat Inherited</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether inherited features should be repeated.
	 * 
	 * <p>
	 * Example:
	 * <tt>EClass1</tt> has an <tt>EAttribute name=attr1</tt>.
	 * <tt>EClass2 extends EClass1</tt>.
	 * If <tt>repeatInherited = true</tt> for <i>EClass2</i>,
	 * <i>attr1</i> will be listed in the section of <i>EClass1</i> and <i>EClass2</i>.
	 * Otherwise, <i>attr1</i> will only be listed in the section of <i>EClass1</i>.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Repeat Inherited</em>' attribute.
	 * @see #isSetRepeatInherited()
	 * @see #unsetRepeatInherited()
	 * @see #setRepeatInherited(boolean)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIEClassConfig_RepeatInherited()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRepeatInherited();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}' attribute.
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
	 * Unsets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepeatInherited()
	 * @see #isRepeatInherited()
	 * @see #setRepeatInherited(boolean)
	 * @generated
	 */
	void unsetRepeatInherited();

	/**
	 * Returns whether the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRepeatInherited <em>Repeat Inherited</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Render Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the list of sub-types should be rendered.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Render Sub Types</em>' attribute.
	 * @see #isSetRenderSubTypes()
	 * @see #unsetRenderSubTypes()
	 * @see #setRenderSubTypes(boolean)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIEClassConfig_RenderSubTypes()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRenderSubTypes();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSubTypes <em>Render Sub Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Sub Types</em>' attribute.
	 * @see #isSetRenderSubTypes()
	 * @see #unsetRenderSubTypes()
	 * @see #isRenderSubTypes()
	 * @generated
	 */
	void setRenderSubTypes(boolean value);

	/**
	 * Unsets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSubTypes <em>Render Sub Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRenderSubTypes()
	 * @see #isRenderSubTypes()
	 * @see #setRenderSubTypes(boolean)
	 * @generated
	 */
	void unsetRenderSubTypes();

	/**
	 * Returns whether the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSubTypes <em>Render Sub Types</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Render Sub Types</em>' attribute is set.
	 * @see #unsetRenderSubTypes()
	 * @see #isRenderSubTypes()
	 * @see #setRenderSubTypes(boolean)
	 * @generated
	 */
	boolean isSetRenderSubTypes();

	/**
	 * Returns the value of the '<em><b>Render Super Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the list of super-types should be rendered.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Render Super Types</em>' attribute.
	 * @see #isSetRenderSuperTypes()
	 * @see #unsetRenderSuperTypes()
	 * @see #setRenderSuperTypes(boolean)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIEClassConfig_RenderSuperTypes()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRenderSuperTypes();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSuperTypes <em>Render Super Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Super Types</em>' attribute.
	 * @see #isSetRenderSuperTypes()
	 * @see #unsetRenderSuperTypes()
	 * @see #isRenderSuperTypes()
	 * @generated
	 */
	void setRenderSuperTypes(boolean value);

	/**
	 * Unsets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSuperTypes <em>Render Super Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRenderSuperTypes()
	 * @see #isRenderSuperTypes()
	 * @see #setRenderSuperTypes(boolean)
	 * @generated
	 */
	void unsetRenderSuperTypes();

	/**
	 * Returns whether the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig#isRenderSuperTypes <em>Render Super Types</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Render Super Types</em>' attribute is set.
	 * @see #unsetRenderSuperTypes()
	 * @see #isRenderSuperTypes()
	 * @see #setRenderSuperTypes(boolean)
	 * @generated
	 */
	boolean isSetRenderSuperTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Traverses the tree to find the most specific <tt>repeatInherited</tt> setting.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRepeatInherited = this.isSetRepeatInherited();\nif (_isSetRepeatInherited)\n{\n\t_xifexpression = this.isRepeatInherited();\n}\nelse\n{\n\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t_xifexpression = ((&lt;%com.altran.general.emf.ecoredoc.generator.config.IEClassConfig%&gt;) _eContainer).shouldRepeatInherited();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRepeatInherited();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Traverses the tree to find the most specific <tt>renderSubTypes</tt> setting.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderSubTypes = this.isSetRenderSubTypes();\nif (_isSetRenderSubTypes)\n{\n\t_xifexpression = this.isRenderSubTypes();\n}\nelse\n{\n\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t_xifexpression = ((&lt;%com.altran.general.emf.ecoredoc.generator.config.IEClassConfig%&gt;) _eContainer).shouldRenderSubTypes();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderSubTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Traverses the tree to find the most specific <tt>renderSuperTypes</tt> setting.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderSuperTypes = this.isSetRenderSuperTypes();\nif (_isSetRenderSuperTypes)\n{\n\t_xifexpression = this.isRenderSuperTypes();\n}\nelse\n{\n\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t_xifexpression = ((&lt;%com.altran.general.emf.ecoredoc.generator.config.IEClassConfig%&gt;) _eContainer).shouldRenderSuperTypes();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderSuperTypes();

} // IEClassConfig
