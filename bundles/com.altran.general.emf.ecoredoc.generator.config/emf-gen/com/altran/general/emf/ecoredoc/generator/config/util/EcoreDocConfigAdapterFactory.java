/**
 */
package com.altran.general.emf.ecoredoc.generator.config.util;

import com.altran.general.emf.ecoredoc.generator.config.*;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage
 * @generated
 */
public class EcoreDocConfigAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EcoreDocConfigPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreDocConfigAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EcoreDocConfigPackage.eINSTANCE;
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
	protected EcoreDocConfigSwitch<Adapter> modelSwitch =
		new EcoreDocConfigSwitch<Adapter>() {
			@Override
			public Adapter caseIENamedElementConfig(IENamedElementConfig object) {
				return createIENamedElementConfigAdapter();
			}
			@Override
			public Adapter caseIDefaultValueConfig(IDefaultValueConfig object) {
				return createIDefaultValueConfigAdapter();
			}
			@Override
			public Adapter caseIEClassifierConfig(IEClassifierConfig object) {
				return createIEClassifierConfigAdapter();
			}
			@Override
			public Adapter caseIEDataTypeConfig(IEDataTypeConfig object) {
				return createIEDataTypeConfigAdapter();
			}
			@Override
			public Adapter caseIEEnumConfig(IEEnumConfig object) {
				return createIEEnumConfigAdapter();
			}
			@Override
			public Adapter caseIEClassConfig(IEClassConfig object) {
				return createIEClassConfigAdapter();
			}
			@Override
			public Adapter caseIETypedElementConfig(IETypedElementConfig object) {
				return createIETypedElementConfigAdapter();
			}
			@Override
			public Adapter caseIEStructuralFeatureConfig(IEStructuralFeatureConfig object) {
				return createIEStructuralFeatureConfigAdapter();
			}
			@Override
			public Adapter caseIEAttributeConfig(IEAttributeConfig object) {
				return createIEAttributeConfigAdapter();
			}
			@Override
			public Adapter caseIEReferenceConfig(IEReferenceConfig object) {
				return createIEReferenceConfigAdapter();
			}
			@Override
			public Adapter caseIEOperationConfig(IEOperationConfig object) {
				return createIEOperationConfigAdapter();
			}
			@Override
			public Adapter caseIEParameterConfig(IEParameterConfig object) {
				return createIEParameterConfigAdapter();
			}
			@Override
			public Adapter caseIEPackageConfig(IEPackageConfig object) {
				return createIEPackageConfigAdapter();
			}
			@Override
			public Adapter caseIEEnumLiteralConfig(IEEnumLiteralConfig object) {
				return createIEEnumLiteralConfigAdapter();
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
			public Adapter caseEClassConfig(EClassConfig object) {
				return createEClassConfigAdapter();
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
			public Adapter caseEOperationConfig(EOperationConfig object) {
				return createEOperationConfigAdapter();
			}
			@Override
			public Adapter caseEParameterConfig(EParameterConfig object) {
				return createEParameterConfigAdapter();
			}
			@Override
			public <T> Adapter caseList(List<T> object) {
				return createListAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig <em>IE Named Element Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig
	 * @generated
	 */
	public Adapter createIENamedElementConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig <em>IDefault Value Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IDefaultValueConfig
	 * @generated
	 */
	public Adapter createIDefaultValueConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig <em>IE Classifier Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig
	 * @generated
	 */
	public Adapter createIEClassifierConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig <em>IE Data Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig
	 * @generated
	 */
	public Adapter createIEDataTypeConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig <em>IE Enum Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEEnumConfig
	 * @generated
	 */
	public Adapter createIEEnumConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEClassConfig <em>IE Class Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEClassConfig
	 * @generated
	 */
	public Adapter createIEClassConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig <em>IE Typed Element Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig
	 * @generated
	 */
	public Adapter createIETypedElementConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig <em>IE Structural Feature Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig
	 * @generated
	 */
	public Adapter createIEStructuralFeatureConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig <em>IE Attribute Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEAttributeConfig
	 * @generated
	 */
	public Adapter createIEAttributeConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig <em>IE Reference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEReferenceConfig
	 * @generated
	 */
	public Adapter createIEReferenceConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig <em>IE Operation Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEOperationConfig
	 * @generated
	 */
	public Adapter createIEOperationConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig <em>IE Parameter Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEParameterConfig
	 * @generated
	 */
	public Adapter createIEParameterConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig <em>IE Package Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEPackageConfig
	 * @generated
	 */
	public Adapter createIEPackageConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig <em>IE Enum Literal Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.IEEnumLiteralConfig
	 * @generated
	 */
	public Adapter createIEEnumLiteralConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig <em>Ecore Doc Generator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
	 * @generated
	 */
	public Adapter createEcoreDocGeneratorConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EPackageConfig <em>EPackage Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EPackageConfig
	 * @generated
	 */
	public Adapter createEPackageConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig <em>EData Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig
	 * @generated
	 */
	public Adapter createEDataTypeConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumConfig <em>EEnum Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumConfig
	 * @generated
	 */
	public Adapter createEEnumConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig <em>EEnum Literal Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig
	 * @generated
	 */
	public Adapter createEEnumLiteralConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EClassConfig <em>EClass Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EClassConfig
	 * @generated
	 */
	public Adapter createEClassConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig <em>EAttribute Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig
	 * @generated
	 */
	public Adapter createEAttributeConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.AEReferenceConfig <em>AE Reference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.AEReferenceConfig
	 * @generated
	 */
	public Adapter createAEReferenceConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig <em>EContainment Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig
	 * @generated
	 */
	public Adapter createEContainmentConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig <em>EReference Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig
	 * @generated
	 */
	public Adapter createEReferenceConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EOperationConfig <em>EOperation Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EOperationConfig
	 * @generated
	 */
	public Adapter createEOperationConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.altran.general.emf.ecoredoc.generator.config.EParameterConfig <em>EParameter Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.altran.general.emf.ecoredoc.generator.config.EParameterConfig
	 * @generated
	 */
	public Adapter createEParameterConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.List
	 * @generated
	 */
	public Adapter createListAdapter() {
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

} //EcoreDocConfigAdapterFactory
