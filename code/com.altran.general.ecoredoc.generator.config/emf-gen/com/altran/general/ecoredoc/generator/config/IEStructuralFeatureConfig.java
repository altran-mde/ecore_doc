/**
 */
package com.altran.general.ecoredoc.generator.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IE Structural Feature Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.IEStructuralFeatureConfig#isRenderBounds <em>Render Bounds</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getIEStructuralFeatureConfig()
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
	 * @return the value of the '<em>Render Bounds</em>' attribute.
	 * @see #isSetRenderBounds()
	 * @see #unsetRenderBounds()
	 * @see #setRenderBounds(boolean)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getIEStructuralFeatureConfig_RenderBounds()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRenderBounds();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEStructuralFeatureConfig#isRenderBounds <em>Render Bounds</em>}' attribute.
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
	 * Unsets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEStructuralFeatureConfig#isRenderBounds <em>Render Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRenderBounds()
	 * @see #isRenderBounds()
	 * @see #setRenderBounds(boolean)
	 * @generated
	 */
	void unsetRenderBounds();

	/**
	 * Returns whether the value of the '{@link com.altran.general.ecoredoc.generator.config.IEStructuralFeatureConfig#isRenderBounds <em>Render Bounds</em>}' attribute is set.
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
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderBounds = this.isSetRenderBounds();\nif (_isSetRenderBounds)\n{\n\t_xifexpression = this.isRenderBounds();\n}\nelse\n{\n\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t_xifexpression = ((&lt;%com.altran.general.ecoredoc.generator.config.IEStructuralFeatureConfig%&gt;) _eContainer).shouldRenderBounds();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderBounds();

} // IEStructuralFeatureConfig
