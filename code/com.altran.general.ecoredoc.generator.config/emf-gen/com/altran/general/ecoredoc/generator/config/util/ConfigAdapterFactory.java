/**
 */
package com.altran.general.ecoredoc.generator.config.util;

import com.altran.general.ecoredoc.generator.config.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.altran.general.ecoredoc.generator.config.ConfigPackage
 * @generated
 */
public class ConfigAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConfigPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigSwitch<Adapter> modelSwitch =
		new ConfigSwitch<Adapter>() {
			@Override
			public Adapter caseIEcoreDocGeneratorConfig(IEcoreDocGeneratorConfig object) {
				return createIEcoreDocGeneratorConfigAdapter();
			}
			@Override
			public Adapter caseEcoreDocGeneratorConfig(EcoreDocGeneratorConfig object) {
				return createEcoreDocGeneratorConfigAdapter();
			}
			@Override
			public Adapter caseEPackageConfig(EPackageConfig object) {
				return createEPackageConfigAdapter();
			}
			@Override
			public Adapter caseIEcoreDocGeneratorPartConfig(IEcoreDocGeneratorPartConfig object) {
				return createIEcoreDocGeneratorPartConfigAdapter();
			}
			@Override
			public Adapter caseIEDataTypeConfig(IEDataTypeConfig object) {
				return createIEDataTypeConfigAdapter();
			}
			@Override
			public Adapter caseEDataTypeConfig(EDataTypeConfig object) {
				return createEDataTypeConfigAdapter();
			}
			@Override
			public Adapter caseEEnumConfig(EEnumConfig object) {
				return createEEnumConfigAdapter();
			}
			@Override
			public Adapter caseEEnumLiteralConfig(EEnumLiteralConfig object) {
				return createEEnumLiteralConfigAdapter();
			}
			@Override
			public Adapter caseIEClassConfig(IEClassConfig object) {
				return createIEClassConfigAdapter();
			}
			@Override
			public Adapter caseEClassConfig(EClassConfig object) {
				return createEClassConfigAdapter();
			}
			@Override
			public Adapter caseAEStructuralFeatureConfig(AEStructuralFeatureConfig object) {
				return createAEStructuralFeatureConfigAdapter();
			}
			@Override
			public Adapter caseEAttributeConfig(EAttributeConfig object) {
				return createEAttributeConfigAdapter();
			}
			@Override
			public Adapter caseAEReferenceConfig(AEReferenceConfig object) {
				return createAEReferenceConfigAdapter();
			}
			@Override
			public Adapter caseEContainmentConfig(EContainmentConfig object) {
				return createEContainmentConfigAdapter();
			}
			@Override
			public Adapter caseEReferenceConfig(EReferenceConfig object) {
				return createEReferenceConfigAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig <em>IEcore Doc Generator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig
	 * @generated
	 */
	public Adapter createIEcoreDocGeneratorConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig <em>Ecore Doc Generator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig
	 * @generated
	 */
	public Adapter createEcoreDocGeneratorConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.EPackageConfig <em>EPackage Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.EPackageConfig
	 * @generated
	 */
	public Adapter createEPackageConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig <em>IEcore Doc Generator Part Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig
	 * @generated
	 */
	public Adapter createIEcoreDocGeneratorPartConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.IEDataTypeConfig <em>IE Data Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.IEDataTypeConfig
	 * @generated
	 */
	public Adapter createIEDataTypeConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.EDataTypeConfig <em>EData Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.EDataTypeConfig
	 * @generated
	 */
	public Adapter createEDataTypeConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.EEnumConfig <em>EEnum Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumConfig
	 * @generated
	 */
	public Adapter createEEnumConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig <em>EEnum Literal Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig
	 * @generated
	 */
	public Adapter createEEnumLiteralConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.IEClassConfig <em>IE Class Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.IEClassConfig
	 * @generated
	 */
	public Adapter createIEClassConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.EClassConfig <em>EClass Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.EClassConfig
	 * @generated
	 */
	public Adapter createEClassConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.AEStructuralFeatureConfig <em>AE Structural Feature Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.AEStructuralFeatureConfig
	 * @generated
	 */
	public Adapter createAEStructuralFeatureConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.AEReferenceConfig <em>AE Reference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.AEReferenceConfig
	 * @generated
	 */
	public Adapter createAEReferenceConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.EAttributeConfig <em>EAttribute Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.EAttributeConfig
	 * @generated
	 */
	public Adapter createEAttributeConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.EContainmentConfig <em>EContainment Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.EContainmentConfig
	 * @generated
	 */
	public Adapter createEContainmentConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.ecoredoc.generator.config.EReferenceConfig <em>EReference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.ecoredoc.generator.config.EReferenceConfig
	 * @generated
	 */
	public Adapter createEReferenceConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ConfigAdapterFactory
