/**
 */
package com.altran.general.ecoredoc.generator.config;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEcore Doc Generator Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRender <em>Render</em>}</li>
 * </ul>
 *
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getIEcoreDocGeneratorConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IEcoreDocGeneratorConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Render Defaults</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Render Defaults</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Render Defaults</em>' attribute.
	 * @see #isSetRenderDefaults()
	 * @see #unsetRenderDefaults()
	 * @see #setRenderDefaults(boolean)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getIEcoreDocGeneratorConfig_RenderDefaults()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRenderDefaults();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRenderDefaults <em>Render Defaults</em>}' attribute.
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
	 * Unsets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRenderDefaults <em>Render Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRenderDefaults()
	 * @see #isRenderDefaults()
	 * @see #setRenderDefaults(boolean)
	 * @generated
	 */
	void unsetRenderDefaults();

	/**
	 * Returns whether the value of the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRenderDefaults <em>Render Defaults</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Render</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Render</em>' attribute.
	 * @see #isSetRender()
	 * @see #unsetRender()
	 * @see #setRender(boolean)
	 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage#getIEcoreDocGeneratorConfig_Render()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRender();

	/**
	 * Sets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRender <em>Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render</em>' attribute.
	 * @see #isSetRender()
	 * @see #unsetRender()
	 * @see #isRender()
	 * @generated
	 */
	void setRender(boolean value);

	/**
	 * Unsets the value of the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRender <em>Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRender()
	 * @see #isRender()
	 * @see #setRender(boolean)
	 * @generated
	 */
	void unsetRender();

	/**
	 * Returns whether the value of the '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig#isRender <em>Render</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Render</em>' attribute is set.
	 * @see #unsetRender()
	 * @see #isRender()
	 * @see #setRender(boolean)
	 * @generated
	 */
	boolean isSetRender();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderDefaults = this.isSetRenderDefaults();\nif (_isSetRenderDefaults)\n{\n\t_xifexpression = this.isRenderDefaults();\n}\nelse\n{\n\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t_xifexpression = ((&lt;%com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig%&gt;) _eContainer).shouldRenderDefaults();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderDefaults();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRender = this.isSetRender();\nif (_isSetRender)\n{\n\t_xifexpression = this.isRender();\n}\nelse\n{\n\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n\t_xifexpression = ((&lt;%com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig%&gt;) _eContainer).shouldRender();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRender();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	ENamedElement getTarget();

} // IEcoreDocGeneratorConfig
