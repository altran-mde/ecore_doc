/**
 */
package EPackage1;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see EPackage1.EPackage1Factory
 * @model kind="package"
 * @generated
 */
public interface EPackage1Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "EPackage1";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "EPackage1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EPackage1";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EPackage1Package eINSTANCE = EPackage1.impl.EPackage1PackageImpl.init();

	/**
	 * The meta object id for the '{@link EPackage1.impl.EClass1Impl <em>EClass1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EPackage1.impl.EClass1Impl
	 * @see EPackage1.impl.EPackage1PackageImpl#getEClass1()
	 * @generated
	 */
	int ECLASS1 = 0;

	/**
	 * The number of structural features of the '<em>EClass1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>EClass1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EPackage1.Enum1 <em>Enum1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EPackage1.Enum1
	 * @see EPackage1.impl.EPackage1PackageImpl#getEnum1()
	 * @generated
	 */
	int ENUM1 = 1;

	/**
	 * The meta object id for the '<em>Special Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see EPackage1.impl.EPackage1PackageImpl#getSpecialDataType()
	 * @generated
	 */
	int SPECIAL_DATA_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link EPackage1.EClass1 <em>EClass1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClass1</em>'.
	 * @see EPackage1.EClass1
	 * @generated
	 */
	EClass getEClass1();

	/**
	 * Returns the meta object for enum '{@link EPackage1.Enum1 <em>Enum1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum1</em>'.
	 * @see EPackage1.Enum1
	 * @generated
	 */
	EEnum getEnum1();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Special Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Special Data Type</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 * @generated
	 */
	EDataType getSpecialDataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EPackage1Factory getEPackage1Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link EPackage1.impl.EClass1Impl <em>EClass1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EPackage1.impl.EClass1Impl
		 * @see EPackage1.impl.EPackage1PackageImpl#getEClass1()
		 * @generated
		 */
		EClass ECLASS1 = eINSTANCE.getEClass1();

		/**
		 * The meta object literal for the '{@link EPackage1.Enum1 <em>Enum1</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EPackage1.Enum1
		 * @see EPackage1.impl.EPackage1PackageImpl#getEnum1()
		 * @generated
		 */
		EEnum ENUM1 = eINSTANCE.getEnum1();

		/**
		 * The meta object literal for the '<em>Special Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see EPackage1.impl.EPackage1PackageImpl#getSpecialDataType()
		 * @generated
		 */
		EDataType SPECIAL_DATA_TYPE = eINSTANCE.getSpecialDataType();

	}

} //EPackage1Package
