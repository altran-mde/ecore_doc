/**
 */
package com.altran.general.emf.ecoredoc.generator.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IE Structural Feature Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig#isRenderBounds <em>Render Bounds</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIEStructuralFeatureConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IEStructuralFeatureConfig extends IENamedElementConfig, IDefaultValueConfig {
	/**
	 * Returns the value of the '<em><b>Render Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Render Bounds</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether multiplicity bounds should be rendered,
	 * even if they are at their default values and <tt>renderDefaults = false</tt>.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Render Bounds</em>' attribute.
	 * @see #isSetRenderBounds()
	 * @see #unsetRenderBounds()
	 * @see #setRenderBounds(boolean)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIEStructuralFeatureConfig_RenderBounds()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRenderBounds();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig#isRenderBounds <em>Render Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Bounds</em>' attribute.
	 * @see #isSetRenderBounds()
	 * @see #unsetRenderBounds()
	 * @see #isRenderBounds()
	 * @generated
	 */
	void setRenderBounds(boolean value);

	/**
	 * Unsets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig#isRenderBounds <em>Render Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRenderBounds()
	 * @see #isRenderBounds()
	 * @see #setRenderBounds(boolean)
	 * @generated
	 */
	void unsetRenderBounds();

	/**
	 * Returns whether the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig#isRenderBounds <em>Render Bounds</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Render Bounds</em>' attribute is set.
	 * @see #unsetRenderBounds()
	 * @see #isRenderBounds()
	 * @see #setRenderBounds(boolean)
	 * @generated
	 */
	boolean isSetRenderBounds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Traverses the tree to find the most specific <tt>renderBounds</tt> setting.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderBounds = this.isSetRenderBounds();\nif (_isSetRenderBounds)\n{\n\t_xifexpression = this.isRenderBounds();\n}\nelse\n{\n\tboolean _xifexpression_1 = false;\n\tboolean _isSetRenderDefaults = this.isSetRenderDefaults();\n\tif (_isSetRenderDefaults)\n\t{\n\t\t_xifexpression_1 = this.isRenderDefaults();\n\t}\n\telse\n\t{\n\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t\t_xifexpression_1 = ((&lt;%com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig%&gt;) _eContainer).shouldRenderBounds();\n\t}\n\t_xifexpression = _xifexpression_1;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderBounds();

} // IEStructuralFeatureConfig
