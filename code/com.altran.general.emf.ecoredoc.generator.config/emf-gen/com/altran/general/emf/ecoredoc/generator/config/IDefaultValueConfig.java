/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IDefault Value Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig#isRenderDefaults <em>Render Defaults</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIDefaultValueConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IDefaultValueConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether properties should be rendered at their default values.
	 * 
	 * <p>
	 * Example: If <tt>EReference.ordered = true</tt> (the default value),
	 * the <i>ordered</i> property of that <tt>EReference</tt> will not be rendered
	 * if <tt>renderDefaults = false</tt>.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Render Defaults</em>' attribute.
	 * @see #isSetRenderDefaults()
	 * @see #unsetRenderDefaults()
	 * @see #setRenderDefaults(boolean)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIDefaultValueConfig_RenderDefaults()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRenderDefaults();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig#isRenderDefaults <em>Render Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Defaults</em>' attribute.
	 * @see #isSetRenderDefaults()
	 * @see #unsetRenderDefaults()
	 * @see #isRenderDefaults()
	 * @generated
	 */
	void setRenderDefaults(boolean value);

	/**
	 * Unsets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig#isRenderDefaults <em>Render Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRenderDefaults()
	 * @see #isRenderDefaults()
	 * @see #setRenderDefaults(boolean)
	 * @generated
	 */
	void unsetRenderDefaults();

	/**
	 * Returns whether the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig#isRenderDefaults <em>Render Defaults</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Render Defaults</em>' attribute is set.
	 * @see #unsetRenderDefaults()
	 * @see #isRenderDefaults()
	 * @see #setRenderDefaults(boolean)
	 * @generated
	 */
	boolean isSetRenderDefaults();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Traverses the tree to find the most specific <tt>renderDefaults</tt> setting.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderDefaults = this.isSetRenderDefaults();\nif (_isSetRenderDefaults)\n{\n\t_xifexpression = this.isRenderDefaults();\n}\nelse\n{\n\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t_xifexpression = ((&lt;%com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig%&gt;) _eContainer).shouldRenderDefaults();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderDefaults();

} // IDefaultValueConfig
