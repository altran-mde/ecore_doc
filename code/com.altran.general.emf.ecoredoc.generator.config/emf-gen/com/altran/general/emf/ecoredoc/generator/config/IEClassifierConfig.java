/**
 */
package com.altran.general.emf.ecoredoc.generator.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IE Classifier Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig#isRenderUseCases <em>Render Use Cases</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.ConfigPackage#getIEClassifierConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IEClassifierConfig extends IENamedElementConfig, IDefaultValueConfig {
	/**
	 * Returns the value of the '<em><b>Render Use Cases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Render Use Cases</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Whether use cases (references to other usages of this element) should be rendered.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Render Use Cases</em>' attribute.
	 * @see #isSetRenderUseCases()
	 * @see #unsetRenderUseCases()
	 * @see #setRenderUseCases(boolean)
	 * @see com.altran.general.emf.ecoredoc.generator.config.ConfigPackage#getIEClassifierConfig_RenderUseCases()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRenderUseCases();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig#isRenderUseCases <em>Render Use Cases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Use Cases</em>' attribute.
	 * @see #isSetRenderUseCases()
	 * @see #unsetRenderUseCases()
	 * @see #isRenderUseCases()
	 * @generated
	 */
	void setRenderUseCases(boolean value);

	/**
	 * Unsets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig#isRenderUseCases <em>Render Use Cases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRenderUseCases()
	 * @see #isRenderUseCases()
	 * @see #setRenderUseCases(boolean)
	 * @generated
	 */
	void unsetRenderUseCases();

	/**
	 * Returns whether the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig#isRenderUseCases <em>Render Use Cases</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Render Use Cases</em>' attribute is set.
	 * @see #unsetRenderUseCases()
	 * @see #isRenderUseCases()
	 * @see #setRenderUseCases(boolean)
	 * @generated
	 */
	boolean isSetRenderUseCases();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Traverses the tree to find the most specific <tt>renderUseCases</tt> setting.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderUseCases = this.isSetRenderUseCases();\nif (_isSetRenderUseCases)\n{\n\t_xifexpression = this.isRenderUseCases();\n}\nelse\n{\n\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t_xifexpression = ((&lt;%com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig%&gt;) _eContainer).shouldRenderUseCases();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderUseCases();

} // IEClassifierConfig
