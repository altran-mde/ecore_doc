/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecore Doc Generator Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig#getEPackages <em>EPackages</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.ConfigPackage#getEcoreDocGeneratorConfig()
 * @model
 * @generated
 */
public interface EcoreDocGeneratorConfig extends IEPackageConfig, IEEnumConfig, IEEnumLiteralConfig, IEClassConfig, IEAttributeConfig, IEReferenceConfig {
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
	 * @see com.altran.general.emf.ecoredoc.generator.config.ConfigPackage#getEcoreDocGeneratorConfig_EPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<EPackageConfig> getEPackages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRender = this.isSetRender();\nif (_isSetRender)\n{\n\t_xifexpression = this.isRender();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRender();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderDefaults = this.isSetRenderDefaults();\nif (_isSetRenderDefaults)\n{\n\t_xifexpression = this.isRenderDefaults();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderDefaults();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderUseCases = this.isSetRenderUseCases();\nif (_isSetRenderUseCases)\n{\n\t_xifexpression = this.isRenderUseCases();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderUseCases();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRepeatInherited = this.isSetRepeatInherited();\nif (_isSetRepeatInherited)\n{\n\t_xifexpression = this.isRepeatInherited();\n}\nelse\n{\n\t_xifexpression = true;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRepeatInherited();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _xifexpression = false;\nboolean _isSetRenderBounds = this.isSetRenderBounds();\nif (_isSetRenderBounds)\n{\n\t_xifexpression = this.isRenderBounds();\n}\nelse\n{\n\t_xifexpression = this.shouldRenderDefaults();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	boolean shouldRenderBounds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int _xifexpression = (int) 0;\nboolean _isSetPositionEDataTypes = this.isSetPositionEDataTypes();\nif (_isSetPositionEDataTypes)\n{\n\t_xifexpression = this.getPositionEDataTypes();\n}\nelse\n{\n\t_xifexpression = 1;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	int getEDataTypesPosition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int _xifexpression = (int) 0;\nboolean _isSetPositionEEnums = this.isSetPositionEEnums();\nif (_isSetPositionEEnums)\n{\n\t_xifexpression = this.getPositionEEnums();\n}\nelse\n{\n\t_xifexpression = 2;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	int getEEnumsPosition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int _xifexpression = (int) 0;\nboolean _isSetPositionEClasses = this.isSetPositionEClasses();\nif (_isSetPositionEClasses)\n{\n\t_xifexpression = this.getPositionEClasses();\n}\nelse\n{\n\t_xifexpression = 3;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	int getEClassesPosition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" elementUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.Iterable%&gt;&lt;? extends &lt;%com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig%&gt;&gt; _switchResult = null;\nboolean _matched = false;\nif (element instanceof &lt;%org.eclipse.emf.ecore.EPackage%&gt;)\n{\n\t_matched=true;\n\t_switchResult = this.getEPackages();\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EEnum%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEEnums();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt;map(this.getEPackages(), _function));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EDataType%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEDataTypes();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig%&gt;&gt;&gt;map(this.getEPackages(), _function));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EEnumLiteral%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEEnums();\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEEnumLiterals();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EEnumConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EClass%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEClasses();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EAttribute%&gt;)\n\t{\n\t\t_matched=true;\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEClasses();\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt; it)\n\t\t\t{\n\t\t\t\treturn it.getEAttributes();\n\t\t\t}\n\t\t};\n\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1));\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EReference%&gt;)\n\t{\n\t\tboolean _isContainment = ((&lt;%org.eclipse.emf.ecore.EReference%&gt;)element).isContainment();\n\t\tif (_isContainment)\n\t\t{\n\t\t\t_matched=true;\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn it.getEClasses();\n\t\t\t\t}\n\t\t\t};\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn it.getEContainments();\n\t\t\t\t}\n\t\t\t};\n\t\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1));\n\t\t}\n\t}\n}\nif (!_matched)\n{\n\tif (element instanceof &lt;%org.eclipse.emf.ecore.EReference%&gt;)\n\t{\n\t\tboolean _isContainment = ((&lt;%org.eclipse.emf.ecore.EReference%&gt;)element).isContainment();\n\t\tboolean _not = (!_isContainment);\n\t\tif (_not)\n\t\t{\n\t\t\t_matched=true;\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn it.getEClasses();\n\t\t\t\t}\n\t\t\t};\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn it.getEReferences();\n\t\t\t\t}\n\t\t\t};\n\t\t\t_switchResult = &lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EPackageConfig%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EClassConfig%&gt;&gt;&gt;map(this.getEPackages(), _function)), _function_1));\n\t\t}\n\t}\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig%&gt; it)\n\t{\n\t\t&lt;%org.eclipse.emf.ecore.ENamedElement%&gt; _target = it.getTarget();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(_target, element));\n\t}\n};\nreturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.findFirst(_switchResult, _function);'"
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
