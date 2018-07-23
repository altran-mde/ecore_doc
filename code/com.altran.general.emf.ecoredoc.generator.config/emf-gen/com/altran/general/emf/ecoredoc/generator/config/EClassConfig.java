/**
 */
package com.altran.general.emf.ecoredoc.generator.config;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EClass Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getTargetEClass <em>Target EClass</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEAttributes <em>EAttributes</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEContainments <em>EContainments</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEReferences <em>EReferences</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getEOperations <em>EOperations</em>}</li>
 * </ul>
 *
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEClassConfig()
 * @model
 * @generated
 */
public interface EClassConfig extends IEClassConfig, IEAttributeConfig, IEReferenceConfig, IEOperationConfig, IEParameterConfig {
	/**
	 * Returns the value of the '<em><b>Target EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target EClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target EClass</em>' reference.
	 * @see #setTargetEClass(EClass)
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEClassConfig_TargetEClass()
	 * @model
	 * @generated
	 */
	EClass getTargetEClass();

	/**
	 * Sets the value of the '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig#getTargetEClass <em>Target EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target EClass</em>' reference.
	 * @see #getTargetEClass()
	 * @generated
	 */
	void setTargetEClass(EClass value);

	/**
	 * Returns the value of the '<em><b>EAttributes</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EAttributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EAttributes</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEClassConfig_EAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EAttributeConfig> getEAttributes();

	/**
	 * Returns the value of the '<em><b>EContainments</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EContainments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EContainments</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEClassConfig_EContainments()
	 * @model containment="true"
	 * @generated
	 */
	EList<EContainmentConfig> getEContainments();

	/**
	 * Returns the value of the '<em><b>EReferences</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReferences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReferences</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEClassConfig_EReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<EReferenceConfig> getEReferences();

	/**
	 * Returns the value of the '<em><b>EOperations</b></em>' containment reference list.
	 * The list contents are of type {@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EOperations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EOperations</em>' containment reference list.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage#getEClassConfig_EOperations()
	 * @model containment="true"
	 * @generated
	 */
	EList<EOperationConfig> getEOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTargetEClass();'"
	 * @generated
	 */
	ENamedElement getTarget();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method for {@linkplain org.eclipse.sisu.plexus.CompositeBeanHelper#setProperty()} to handle ELists correctly.
	 * <!-- end-model-doc -->
	 * @model eAttributeConfigType="com.altran.general.emf.ecoredoc.generator.config.List&lt;com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig&gt;" eAttributeConfigUnique="false" eAttributeConfigMany="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt; _eAttributes = this.getEAttributes();\n&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig%&gt;&gt;addAll(_eAttributes, eAttributeConfig);'"
	 * @generated
	 */
	void addEAttributes(List<EAttributeConfig> eAttributeConfig);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method for {@linkplain org.eclipse.sisu.plexus.CompositeBeanHelper#setProperty()} to handle ELists correctly.
	 * <!-- end-model-doc -->
	 * @model eContainmentConfigType="com.altran.general.emf.ecoredoc.generator.config.List&lt;com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig&gt;" eContainmentConfigUnique="false" eContainmentConfigMany="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt; _eContainments = this.getEContainments();\n&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig%&gt;&gt;addAll(_eContainments, eContainmentConfig);'"
	 * @generated
	 */
	void addEContainments(List<EContainmentConfig> eContainmentConfig);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method for {@linkplain org.eclipse.sisu.plexus.CompositeBeanHelper#setProperty()} to handle ELists correctly.
	 * <!-- end-model-doc -->
	 * @model eReferenceConfigType="com.altran.general.emf.ecoredoc.generator.config.List&lt;com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig&gt;" eReferenceConfigUnique="false" eReferenceConfigMany="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt; _eReferences = this.getEReferences();\n&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig%&gt;&gt;addAll(_eReferences, eReferenceConfig);'"
	 * @generated
	 */
	void addEReferences(List<EReferenceConfig> eReferenceConfig);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method for {@linkplain org.eclipse.sisu.plexus.CompositeBeanHelper#setProperty()} to handle ELists correctly.
	 * <!-- end-model-doc -->
	 * @model eOperationConfigType="com.altran.general.emf.ecoredoc.generator.config.List&lt;com.altran.general.emf.ecoredoc.generator.config.EOperationConfig&gt;" eOperationConfigUnique="false" eOperationConfigMany="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt; _eOperations = this.getEOperations();\n&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%com.altran.general.emf.ecoredoc.generator.config.EOperationConfig%&gt;&gt;addAll(_eOperations, eOperationConfig);'"
	 * @generated
	 */
	void addEOperations(List<EOperationConfig> eOperationConfig);

} // EClassConfig
