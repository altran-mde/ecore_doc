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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRender = this.isSetRender();\nif (_isSetRender)\n{\n\t_xifexpression = this.isRender();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderDefaults = this.isSetRenderDefaults();\nif (_isSetRenderDefaults)\n{\n\t_xifexpression = this.isRenderDefaults();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderUseCases = this.isSetRenderUseCases();\nif (_isSetRenderUseCases)\n{\n\t_xifexpression = this.isRenderUseCases();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRepeatInherited = this.isSetRepeatInherited();\nif (_isSetRepeatInherited)\n{\n\t_xifexpression = this.isRepeatInherited();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderSubTypes = this.isSetRenderSubTypes();\nif (_isSetRenderSubTypes)\n{\n\t_xifexpression = this.isRenderSubTypes();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderSuperTypes = this.isSetRenderSuperTypes();\nif (_isSetRenderSuperTypes)\n{\n\t_xifexpression = this.isRenderSuperTypes();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderBounds = this.isSetRenderBounds();\nif (_isSetRenderBounds)\n{\n\t_xifexpression = this.isRenderBounds();\n}\nelse\n{\n\t_xifexpression = this.shouldRenderDefaults();\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int _xifexpression = (int) 0;\nboolean _isSetPositionEDataTypes = this.isSetPositionEDataTypes();\nif (_isSetPositionEDataTypes)\n{\n\t_xifexpression = this.getPositionEDataTypes();\n}\nelse\n{\n\t_xifexpression = 1;\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int _xifexpression = (int) 0;\nboolean _isSetPositionEEnums = this.isSetPositionEEnums();\nif (_isSetPositionEEnums)\n{\n\t_xifexpression = this.getPositionEEnums();\n}\nelse\n{\n\t_xifexpression = 2;\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int _xifexpression = (int) 0;\nboolean _isSetPositionEClasses = this.isSetPositionEClasses();\nif (_isSetPositionEClasses)\n{\n\t_xifexpression = this.getPositionEClasses();\n}\nelse\n{\n\t_xifexpression = 3;\n}\nreturn _xifexpression;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;&gt; _ePackages = this.getEPackages();\n&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;&gt;addAll(_ePackages, ePackageConfig);'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.Iterable%&gt;&lt;? extends &lt;%com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig%&gt;&gt; _switchResult = null;\nboolean _matched = false;\nif (element instanceof &lt;%org.eclipse.emf.ecore.EPackage%&gt;)\n{\n\t_matched=true;\n\t_switchResult = this.getEPackages();\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EEnum%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEEnums();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt;map(this.getEPackages(), _function));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EDataType%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEDataTypes();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt;&gt;map(this.getEPackages(), _function));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EEnumLiteral%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEEnums();\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEEnumLiterals();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EClass%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEClasses();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EAttribute%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEClasses();\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEAttributes();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EReference%&gt;)\n\t{\n\t\tboolean _isContainment = ((&lt;%org.eclipse.emf.ecore.EReference%&gt;)element).isContainment();\n\t\tif (_isContainment)\n\t\t{\n\t\t\t_matched=true;\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn it.getEClasses();\n\t\t\t\t}\n\t\t\t};\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn it.getEContainments();\n\t\t\t\t}\n\t\t\t};\n\t\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1));\n\t\t}\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EReference%&gt;)\n\t{\n\t\tboolean _isContainment = ((&lt;%org.eclipse.emf.ecore.EReference%&gt;)element).isContainment();\n\t\tboolean _not = (!_isContainment);\n\t\tif (_not)\n\t\t{\n\t\t\t_matched=true;\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn it.getEClasses();\n\t\t\t\t}\n\t\t\t};\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn it.getEReferences();\n\t\t\t\t}\n\t\t\t};\n\t\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1));\n\t\t}\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EOperation%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEClasses();\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEOperations();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EParameter%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEClasses();\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEOperations();\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EParameterConfig%&gt;&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EParameterConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EParameterConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEParameters();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EParameterConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EParameterConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1)), _function_2));\n\t}\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig%&gt; it)\n\t{\n\t\t&lt;%org.eclipse.emf.ecore.ENamedElement%&gt; _target = it.getTarget();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(_target, element));\n\t}\n};\nreturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.findFirst(_switchResult, _function);'"
	 * @generated
	 */
	IENamedElementConfig findConfig(ENamedElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;'"
	 * @generated
	 */
	ENamedElement getTarget();

} // EcoreDocGeneratorConfig
