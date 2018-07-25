/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EOperation Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getTargetEOperation <em>Target EOperation</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getEParameters <em>EParameters</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEOperationConfig()
 * @model
 * @generated
 */
public interface EOperationConfig extends AEReferenceConfig {
	/**
	 * Returns the value of the '<em><b>Target EOperation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EOperation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EOperation</em>' reference.
	 * @see #setTargetEOperation(EOperation)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEOperationConfig_TargetEOperation()
	 * @model
	 * @generated
	 */
	EOperation getTargetEOperation();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig#getTargetEOperation <em>Target EOperation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EOperation</em>' reference.
	 * @see #getTargetEOperation()
	 * @generated
	 */
	void setTargetEOperation(EOperation value);

	/**
	 * Returns the value of the '<em><b>EParameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EParameterConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EParameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EParameters</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEOperationConfig_EParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<EParameterConfig> getEParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTargetEOperation();'"
	 * @generated
	 */
	ENamedElement getTarget();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method for {@linkplain org.eclipse.sisu.plexus.CompositeBeanHelper#setProperty()} to handle ELists correctly.
	 * <!-- end-model-doc -->
	 * @model eParameterConfigType="com.altran.general.emf.ecoredoc.generator.config.List&lt;com.altran.general.emf.ecoredoc.generator.config.EParameterConfig&gt;" eParameterConfigUnique="false" eParameterConfigMany="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EParameterConfig%&gt;&gt; _eParameters = this.getEParameters();\n&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EParameterConfig%&gt;&gt;addAll(_eParameters, eParameterConfig);'"
	 * @generated
	 */
	void addEParameters(List<EParameterConfig> eParameterConfig);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.ecore.EOperation%&gt; _targetEOperation = this.getTargetEOperation();\n&lt;%java.lang.String%&gt; _joinId = null;\nif (_targetEOperation!=null)\n{\n\t_joinId=this.joinId(_targetEOperation);\n}\nreturn _joinId;'"
	 * @generated
	 */
	String getId();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" eOperationUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _name = eOperation.getName();\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.eclipse.emf.ecore.EParameter%&gt;, &lt;%java.lang.String%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.eclipse.emf.ecore.EParameter%&gt;, &lt;%java.lang.String%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.String%&gt; apply(final &lt;%org.eclipse.emf.ecore.EParameter%&gt; it)\n\t{\n\t\t&lt;%org.eclipse.emf.ecore.EClassifier%&gt; _eType = it.getEType();\n\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = null;\n\t\tif (_eType!=null)\n\t\t{\n\t\t\t_eContainer=_eType.eContainer();\n\t\t}\n\t\t&lt;%java.lang.String%&gt; _name = null;\n\t\tif (((&lt;%org.eclipse.emf.ecore.ENamedElement%&gt;) _eContainer)!=null)\n\t\t{\n\t\t\t_name=((&lt;%org.eclipse.emf.ecore.ENamedElement%&gt;) _eContainer).getName();\n\t\t}\n\t\t&lt;%java.lang.String%&gt; _plus = (_name + \"_\");\n\t\t&lt;%org.eclipse.emf.ecore.EClassifier%&gt; _eType_1 = it.getEType();\n\t\t&lt;%java.lang.String%&gt; _name_1 = null;\n\t\tif (_eType_1!=null)\n\t\t{\n\t\t\t_name_1=_eType_1.getName();\n\t\t}\n\t\treturn (_plus + _name_1);\n\t}\n};\n&lt;%java.lang.String%&gt; _join = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.join(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%org.eclipse.emf.ecore.EParameter%&gt;, &lt;%java.lang.String%&gt;&gt;map(eOperation.getEParameters(), _function), \".\");\nreturn (_name + _join);'"
	 * @generated
	 */
	String joinId(EOperation eOperation);

} // EOperationConfig
