/**
 */
package EPackage1;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1__ID = 1;

	/**
	 * The feature id for the '<em><b>Special Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1__SPECIAL_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Some String Attr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1__SOME_STRING_ATTR = 3;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1__D = 4;

	/**
	 * The feature id for the '<em><b>My Relation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1__MY_RELATION = 5;

	/**
	 * The number of structural features of the '<em>EClass1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>EClass1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EPackage1.impl.MyEClassImpl <em>My EClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EPackage1.impl.MyEClassImpl
	 * @see EPackage1.impl.EPackage1PackageImpl#getMyEClass()
	 * @generated
	 */
	int MY_ECLASS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__NAME = ECLASS1__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__ID = ECLASS1__ID;

	/**
	 * The feature id for the '<em><b>Special Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__SPECIAL_NUMBER = ECLASS1__SPECIAL_NUMBER;

	/**
	 * The feature id for the '<em><b>Some String Attr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__SOME_STRING_ATTR = ECLASS1__SOME_STRING_ATTR;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__D = ECLASS1__D;

	/**
	 * The feature id for the '<em><b>My Relation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__MY_RELATION = ECLASS1__MY_RELATION;

	/**
	 * The feature id for the '<em><b>Attr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__ATTR = ECLASS1_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__REF = ECLASS1_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Clazzes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__CLAZZES = ECLASS1_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Eeeenum</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__EEEENUM = ECLASS1_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Other Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__OTHER_CLASSES = ECLASS1_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Backwards</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS__BACKWARDS = ECLASS1_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>My EClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS_FEATURE_COUNT = ECLASS1_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>My EClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_ECLASS_OPERATION_COUNT = ECLASS1_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EPackage1.impl.Class3Impl <em>Class3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EPackage1.impl.Class3Impl
	 * @see EPackage1.impl.EPackage1PackageImpl#getClass3()
	 * @generated
	 */
	int CLASS3 = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3__NAME = ECLASS1__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3__ID = ECLASS1__ID;

	/**
	 * The feature id for the '<em><b>Special Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3__SPECIAL_NUMBER = ECLASS1__SPECIAL_NUMBER;

	/**
	 * The feature id for the '<em><b>Some String Attr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3__SOME_STRING_ATTR = ECLASS1__SOME_STRING_ATTR;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3__D = ECLASS1__D;

	/**
	 * The feature id for the '<em><b>My Relation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3__MY_RELATION = ECLASS1__MY_RELATION;

	/**
	 * The feature id for the '<em><b>Something</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3__SOMETHING = ECLASS1_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Special Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3__SPECIAL_PARENT = ECLASS1_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Class3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3_FEATURE_COUNT = ECLASS1_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Class3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS3_OPERATION_COUNT = ECLASS1_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EPackage1.Iface <em>Iface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EPackage1.Iface
	 * @see EPackage1.impl.EPackage1PackageImpl#getIface()
	 * @generated
	 */
	int IFACE = 3;

	/**
	 * The number of structural features of the '<em>Iface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFACE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Iface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EPackage1.Enum1 <em>Enum1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EPackage1.Enum1
	 * @see EPackage1.impl.EPackage1PackageImpl#getEnum1()
	 * @generated
	 */
	int ENUM1 = 4;

	/**
	 * The meta object id for the '<em>Special Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see EPackage1.impl.EPackage1PackageImpl#getSpecialDataType()
	 * @generated
	 */
	int SPECIAL_DATA_TYPE = 5;


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
	 * Returns the meta object for the attribute list '{@link EPackage1.EClass1#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Name</em>'.
	 * @see EPackage1.EClass1#getName()
	 * @see #getEClass1()
	 * @generated
	 */
	EAttribute getEClass1_Name();

	/**
	 * Returns the meta object for the attribute '{@link EPackage1.EClass1#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see EPackage1.EClass1#getId()
	 * @see #getEClass1()
	 * @generated
	 */
	EAttribute getEClass1_Id();

	/**
	 * Returns the meta object for the attribute '{@link EPackage1.EClass1#getSpecialNumber <em>Special Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Special Number</em>'.
	 * @see EPackage1.EClass1#getSpecialNumber()
	 * @see #getEClass1()
	 * @generated
	 */
	EAttribute getEClass1_SpecialNumber();

	/**
	 * Returns the meta object for the attribute '{@link EPackage1.EClass1#getSomeStringAttr <em>Some String Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Some String Attr</em>'.
	 * @see EPackage1.EClass1#getSomeStringAttr()
	 * @see #getEClass1()
	 * @generated
	 */
	EAttribute getEClass1_SomeStringAttr();

	/**
	 * Returns the meta object for the attribute '{@link EPackage1.EClass1#getD <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see EPackage1.EClass1#getD()
	 * @see #getEClass1()
	 * @generated
	 */
	EAttribute getEClass1_D();

	/**
	 * Returns the meta object for the reference list '{@link EPackage1.EClass1#getMyRelation <em>My Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>My Relation</em>'.
	 * @see EPackage1.EClass1#getMyRelation()
	 * @see #getEClass1()
	 * @generated
	 */
	EReference getEClass1_MyRelation();

	/**
	 * Returns the meta object for class '{@link EPackage1.MyEClass <em>My EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My EClass</em>'.
	 * @see EPackage1.MyEClass
	 * @generated
	 */
	EClass getMyEClass();

	/**
	 * Returns the meta object for the attribute '{@link EPackage1.MyEClass#getAttr <em>Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attr</em>'.
	 * @see EPackage1.MyEClass#getAttr()
	 * @see #getMyEClass()
	 * @generated
	 */
	EAttribute getMyEClass_Attr();

	/**
	 * Returns the meta object for the reference '{@link EPackage1.MyEClass#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see EPackage1.MyEClass#getRef()
	 * @see #getMyEClass()
	 * @generated
	 */
	EReference getMyEClass_Ref();

	/**
	 * Returns the meta object for the containment reference list '{@link EPackage1.MyEClass#getClazzes <em>Clazzes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clazzes</em>'.
	 * @see EPackage1.MyEClass#getClazzes()
	 * @see #getMyEClass()
	 * @generated
	 */
	EReference getMyEClass_Clazzes();

	/**
	 * Returns the meta object for the attribute list '{@link EPackage1.MyEClass#getEeeenum <em>Eeeenum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Eeeenum</em>'.
	 * @see EPackage1.MyEClass#getEeeenum()
	 * @see #getMyEClass()
	 * @generated
	 */
	EAttribute getMyEClass_Eeeenum();

	/**
	 * Returns the meta object for the containment reference list '{@link EPackage1.MyEClass#getOtherClasses <em>Other Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Other Classes</em>'.
	 * @see EPackage1.MyEClass#getOtherClasses()
	 * @see #getMyEClass()
	 * @generated
	 */
	EReference getMyEClass_OtherClasses();

	/**
	 * Returns the meta object for the reference '{@link EPackage1.MyEClass#getBackwards <em>Backwards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Backwards</em>'.
	 * @see EPackage1.MyEClass#getBackwards()
	 * @see #getMyEClass()
	 * @generated
	 */
	EReference getMyEClass_Backwards();

	/**
	 * Returns the meta object for class '{@link EPackage1.Class3 <em>Class3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class3</em>'.
	 * @see EPackage1.Class3
	 * @generated
	 */
	EClass getClass3();

	/**
	 * Returns the meta object for the attribute list '{@link EPackage1.Class3#getSomething <em>Something</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Something</em>'.
	 * @see EPackage1.Class3#getSomething()
	 * @see #getClass3()
	 * @generated
	 */
	EAttribute getClass3_Something();

	/**
	 * Returns the meta object for the container reference '{@link EPackage1.Class3#getSpecialParent <em>Special Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Special Parent</em>'.
	 * @see EPackage1.Class3#getSpecialParent()
	 * @see #getClass3()
	 * @generated
	 */
	EReference getClass3_SpecialParent();

	/**
	 * Returns the meta object for class '{@link EPackage1.Iface <em>Iface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iface</em>'.
	 * @see EPackage1.Iface
	 * @generated
	 */
	EClass getIface();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASS1__NAME = eINSTANCE.getEClass1_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASS1__ID = eINSTANCE.getEClass1_Id();

		/**
		 * The meta object literal for the '<em><b>Special Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASS1__SPECIAL_NUMBER = eINSTANCE.getEClass1_SpecialNumber();

		/**
		 * The meta object literal for the '<em><b>Some String Attr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASS1__SOME_STRING_ATTR = eINSTANCE.getEClass1_SomeStringAttr();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASS1__D = eINSTANCE.getEClass1_D();

		/**
		 * The meta object literal for the '<em><b>My Relation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS1__MY_RELATION = eINSTANCE.getEClass1_MyRelation();

		/**
		 * The meta object literal for the '{@link EPackage1.impl.MyEClassImpl <em>My EClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EPackage1.impl.MyEClassImpl
		 * @see EPackage1.impl.EPackage1PackageImpl#getMyEClass()
		 * @generated
		 */
		EClass MY_ECLASS = eINSTANCE.getMyEClass();

		/**
		 * The meta object literal for the '<em><b>Attr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MY_ECLASS__ATTR = eINSTANCE.getMyEClass_Attr();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MY_ECLASS__REF = eINSTANCE.getMyEClass_Ref();

		/**
		 * The meta object literal for the '<em><b>Clazzes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MY_ECLASS__CLAZZES = eINSTANCE.getMyEClass_Clazzes();

		/**
		 * The meta object literal for the '<em><b>Eeeenum</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MY_ECLASS__EEEENUM = eINSTANCE.getMyEClass_Eeeenum();

		/**
		 * The meta object literal for the '<em><b>Other Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MY_ECLASS__OTHER_CLASSES = eINSTANCE.getMyEClass_OtherClasses();

		/**
		 * The meta object literal for the '<em><b>Backwards</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MY_ECLASS__BACKWARDS = eINSTANCE.getMyEClass_Backwards();

		/**
		 * The meta object literal for the '{@link EPackage1.impl.Class3Impl <em>Class3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EPackage1.impl.Class3Impl
		 * @see EPackage1.impl.EPackage1PackageImpl#getClass3()
		 * @generated
		 */
		EClass CLASS3 = eINSTANCE.getClass3();

		/**
		 * The meta object literal for the '<em><b>Something</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS3__SOMETHING = eINSTANCE.getClass3_Something();

		/**
		 * The meta object literal for the '<em><b>Special Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS3__SPECIAL_PARENT = eINSTANCE.getClass3_SpecialParent();

		/**
		 * The meta object literal for the '{@link EPackage1.Iface <em>Iface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EPackage1.Iface
		 * @see EPackage1.impl.EPackage1PackageImpl#getIface()
		 * @generated
		 */
		EClass IFACE = eINSTANCE.getIface();

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
