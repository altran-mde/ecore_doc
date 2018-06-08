/**
 */
package EPackage1;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see EPackage1.EPackage1Package
 * @generated
 */
public interface EPackage1Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EPackage1Factory eINSTANCE = EPackage1.impl.EPackage1FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>My EClass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>My EClass</em>'.
	 * @generated
	 */
	MyEClass createMyEClass();

	/**
	 * Returns a new object of class '<em>Class3</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class3</em>'.
	 * @generated
	 */
	Class3 createClass3();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EPackage1Package getEPackage1Package();

} //EPackage1Factory
