/**
 */
package EPackage2.impl;

import EPackage2.EPackage2Factory;
import EPackage2.EPackage2Package;
import EPackage2.Enum1;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EPackage2PackageImpl extends EPackageImpl implements EPackage2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enum1EEnum = null;

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
	 * @see EPackage2.EPackage2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EPackage2PackageImpl() {
		super(eNS_URI, EPackage2Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EPackage2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EPackage2Package init() {
		if (isInited) return (EPackage2Package)EPackage.Registry.INSTANCE.getEPackage(EPackage2Package.eNS_URI);

		// Obtain or create and register package
		EPackage2PackageImpl theEPackage2Package = (EPackage2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EPackage2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EPackage2PackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEPackage2Package.createPackageContents();

		// Initialize created meta-data
		theEPackage2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEPackage2Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EPackage2Package.eNS_URI, theEPackage2Package);
		return theEPackage2Package;
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
	public EPackage2Factory getEPackage2Factory() {
		return (EPackage2Factory)getEFactoryInstance();
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

		// Create enums
		enum1EEnum = createEEnum(ENUM1);
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

		// Initialize enums and add enum literals
		initEEnum(enum1EEnum, Enum1.class, "Enum1");
		addEEnumLiteral(enum1EEnum, Enum1.LITERAL1);
		addEEnumLiteral(enum1EEnum, Enum1.LITERAL2);

		// Create resource
		createResource(eNS_URI);
	}

} //EPackage2PackageImpl
