/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecore Doc Generator Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Root for the detailed EcoreDocGenerator configuration.
 * 
 * <p>
 * The configuration allows to specify configuration options for each element and all its contained elements.
 * It always chooses the most specific configuration setting.
 * </p>
 * 
 * <p>Example:</p>
 * 
 * <pre>
 * EcoreDocGeneratorConfig
 * 	 * renderDefaults: {unset, defaults to true}
 *   * repeatInherited: false
 *   + EPackage1
 *     * renderDefaults: false
 *     + EClass1
 *       + EAttribute1
 *         * renderDefaults: true
 *       + EAttribute2
 *         {no custom config}
 *     + EClass2 extends EClass1
 *   + EPackage2
 *     * repeatInherited: true
 *     + EClass3 extends EClass1
 *     + EClass4
 *       + EAttribute3
 *         * renderDefaults: true
 *         * repeatInherited: false
 * </pre>
 * 
 * <p>Result:</p>
 * 
 * <dl>
 *   <dt>EPackage1</dt>
 *   <dd>
 *     <dl class="compact">
 *       <dt>renderDefaults</dt><dd>false</dd>
 *       <dt>repeatInherited</dt><dd>false</dd>
 *     </dl>
 *   </dd>
 *   <dt>EClass1</dt>
 *   <dd>
 *     <dl class="compact">
 *       <dt>renderDefaults</dt><dd>false</dd>
 *       <dt>repeatInherited</dt><dd>false</dd>
 *     </dl>
 *   </dd>
 *   <dt>EAttribute1</dt>
 *   <dd>
 *     <dl class="compact">
 *       <dt>renderDefaults</dt><dd>true</dd>
 *       <dt>repeatInherited</dt><dd>false</dd>
 *     </dl>
 *   </dd>
 *   <dt>EAttribute2</dt>
 *   <dd>
 *     <dl class="compact">
 *       <dt>renderDefaults</dt><dd>false</dd>
 *       <dt>repeatInherited</dt><dd>false</dd>
 *     </dl>
 *   </dd>
 *   <dt>EClass2</dt>
 *   <dd>
 *     <dl class="compact">
 *       <dt>renderDefaults</dt><dd>false</dd>
 *       <dt>repeatInherited</dt><dd>false</dd>
 *     </dl>
 *   </dd>
 *   <dt>EPackage2</dt>
 *   <dd>
 *     <dl class="compact">
 *       <dt>renderDefaults</dt><dd>true</dd>
 *       <dt>repeatInherited</dt><dd>true</dd>
 *     </dl>
 *   </dd>
 *   <dt>EClass3</dt>
 *   <dd>
 *     <dl class="compact">
 *       <dt>renderDefaults</dt><dd>true</dd>
 *       <dt>repeatInherited</dt><dd>true</dd>
 *     </dl>
 *   </dd>
 *   <dt>EClass4</dt>
 *   <dd>
 *     <dl class="compact">
 *       <dt>renderDefaults</dt><dd>true</dd>
 *       <dt>repeatInherited</dt><dd>true</dd>
 *     </dl>
 *   </dd>
 *   <dt>EAttribute3</dt>
 *   <dd>
 *     <dl class="compact">
 *       <dt>renderDefaults</dt><dd>true</dd>
 *       <dt>repeatInherited</dt><dd>false</dd>
 *     </dl>
 *   </dd>
 * </dl>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getDocumentTitle <em>Document Title</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEPackages <em>EPackages</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEcoreDocGeneratorConfig()
 * @model
 * @generated
 */
public interface EcoreDocGeneratorConfig extends IEPackageConfig, IEEnumConfig, IEEnumLiteralConfig, IEClassConfig, IEAttributeConfig, IEReferenceConfig, IEOperationConfig, IEParameterConfig {
	/**
	 * Returns the value of the '<em><b>Document Title</b></em>' attribute.
	 * The default value is <code>"Ecore Documentation"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Title of the generated document.
	 * 
	 * <p>defaults to <b>Ecore Documentation</b>.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Document Title</em>' attribute.
	 * @see #setDocumentTitle(String)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEcoreDocGeneratorConfig_DocumentTitle()
	 * @model default="Ecore Documentation" unique="false"
	 * @generated
	 */
	String getDocumentTitle();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getDocumentTitle <em>Document Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document Title</em>' attribute.
	 * @see #getDocumentTitle()
	 * @generated
	 */
	void setDocumentTitle(String value);

	/**
	 * Returns the value of the '<em><b>EPackages</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EPackages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EPackages</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEcoreDocGeneratorConfig_EPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<EPackageConfig> getEPackages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>render = true</tt>.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	boolean shouldRender();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>renderDefaults = true</tt>.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	boolean shouldRenderDefaults();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>renderUseCases = true</tt>.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	boolean shouldRenderUseCases();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>repeatInherited = true</tt>.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	boolean shouldRepeatInherited();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>renderSubTypes = true</tt>.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	boolean shouldRenderSubTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>RenderSuperTypes = true</tt>.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	boolean shouldRenderSuperTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>renderBounds = shouldRenderDefaults()</tt>.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	boolean shouldRenderBounds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>positionEDataTypes = 1</tt>.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	int getEDataTypesPosition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>positionEEnums = 2</tt>.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	int getEEnumsPosition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets default for <tt>positionEClasses = 3</tt>.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	int getEClassesPosition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method for {@linkplain org.eclipse.sisu.plexus.CompositeBeanHelper#setProperty()} to handle ELists correctly.
	 * <!-- end-model-doc -->
	 * @model ePackageConfigType="com.altran.general.emf.ecoredoc.generator.config.List&lt;com.altran.general.emf.ecoredoc.generator.config.EPackageConfig&gt;" ePackageConfigUnique="false" ePackageConfigMany="false"
	 * @generated
	 */
	void addEPackages(List<EPackageConfig> ePackageConfig);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Convenience method to map ENamedElement -> config.
	 * <!-- end-model-doc -->
	 * @model unique="false" elementUnique="false"
	 * @generated
	 */
	IENamedElementConfig findConfig(ENamedElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	ENamedElement getTarget();

} // EcoreDocGeneratorConfig
