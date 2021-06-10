/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IE Named Element Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIENamedElementConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IENamedElementConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element should be rendered at all.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Render</em>' attribute.
	 * @see #isSetRender()
	 * @see #unsetRender()
	 * @see #setRender(boolean)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIENamedElementConfig_Render()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	boolean isRender();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#isRender <em>Render</em>}' attribute.
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
	 * Unsets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#isRender <em>Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRender()
	 * @see #isRender()
	 * @see #setRender(boolean)
	 * @generated
	 */
	void unsetRender();

	/**
	 * Returns whether the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#isRender <em>Render</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Enables proper merging in {@link com.altran.general.emf.ecoredoc.util.EcoreMerger}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getIENamedElementConfig_Id()
	 * @model unique="false" id="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://altran.com/general/emf/ecoredoc/generator/config/0.1 render='false'"
	 * @generated
	 */
	String getId();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Traverses the tree to find the most specific <tt>render</tt> setting.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	boolean shouldRender();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Link to the configured element.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	ENamedElement getTarget();

} // IENamedElementConfig
