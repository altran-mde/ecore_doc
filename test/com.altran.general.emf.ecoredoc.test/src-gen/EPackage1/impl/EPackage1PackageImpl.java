/**
 */
package EPackage1.impl;

import EPackage1.Class3;
import EPackage1.EClass1;
import EPackage1.EPackage1Factory;
import EPackage1.EPackage1Package;
import EPackage1.Enum1;
import EPackage1.Iface;
import EPackage1.MyEClass;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EPackage1PackageImpl extends EPackageImpl implements EPackage1Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClass1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myEClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass class3EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enum1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType specialDataTypeEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see EPackage1.EPackage1Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EPackage1PackageImpl() {
		super(eNS_URI, EPackage1Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EPackage1Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EPackage1Package init() {
		if (isInited) return (EPackage1Package)EPackage.Registry.INSTANCE.getEPackage(EPackage1Package.eNS_URI);

		// Obtain or create and register package
		EPackage1PackageImpl theEPackage1Package = (EPackage1PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EPackage1PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EPackage1PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEPackage1Package.createPackageContents();

		// Initialize created meta-data
		theEPackage1Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEPackage1Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EPackage1Package.eNS_URI, theEPackage1Package);
		return theEPackage1Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClass1() {
		return eClass1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEClass1_Name() {
		return (EAttribute)eClass1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEClass1_Id() {
		return (EAttribute)eClass1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClass1_MyRelation() {
		return (EReference)eClass1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMyEClass() {
		return myEClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMyEClass_Backwards() {
		return (EReference)myEClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass3() {
		return class3EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIface() {
		return ifaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnum1() {
		return enum1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSpecialDataType() {
		return specialDataTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage1Factory getEPackage1Factory() {
		return (EPackage1Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eClass1EClass = createEClass(ECLASS1);
		createEAttribute(eClass1EClass, ECLASS1__NAME);
		createEAttribute(eClass1EClass, ECLASS1__ID);
		createEReference(eClass1EClass, ECLASS1__MY_RELATION);

		myEClassEClass = createEClass(MY_ECLASS);
		createEReference(myEClassEClass, MY_ECLASS__BACKWARDS);

		class3EClass = createEClass(CLASS3);

		ifaceEClass = createEClass(IFACE);

		// Create enums
		enum1EEnum = createEEnum(ENUM1);

		// Create data types
		specialDataTypeEDataType = createEDataType(SPECIAL_DATA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		myEClassEClass.getESuperTypes().add(this.getEClass1());
		class3EClass.getESuperTypes().add(this.getEClass1());

		// Initialize classes, features, and operations; add parameters
		initEClass(eClass1EClass, EClass1.class, "EClass1", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEClass1_Name(), theEcorePackage.getEString(), "name", null, 1, 1, EClass1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClass1_Id(), theEcorePackage.getEInt(), "id", null, 3, 5, EClass1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClass1_MyRelation(), this.getMyEClass(), this.getMyEClass_Backwards(), "myRelation", null, 0, -1, EClass1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(myEClassEClass, MyEClass.class, "MyEClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMyEClass_Backwards(), this.getEClass1(), this.getEClass1_MyRelation(), "backwards", null, 1, 1, MyEClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(class3EClass, Class3.class, "Class3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifaceEClass, Iface.class, "Iface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(enum1EEnum, Enum1.class, "Enum1");
		addEEnumLiteral(enum1EEnum, Enum1.LITERAL1);
		addEEnumLiteral(enum1EEnum, Enum1.LITERAL2);

		// Initialize data types
		initEDataType(specialDataTypeEDataType, Number.class, "SpecialDataType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EPackage1PackageImpl
