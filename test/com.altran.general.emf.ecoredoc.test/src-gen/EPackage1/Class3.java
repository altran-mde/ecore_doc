/**
 */
package EPackage1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class3</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EPackage1.Class3#getSomething <em>Something</em>}</li>
 *   <li>{@link EPackage1.Class3#getSpecialParent <em>Special Parent</em>}</li>
 * </ul>
 *
 * @see EPackage1.EPackage1Package#getClass3()
 * @model
 * @generated
 */
public interface Class3 extends EClass1 {
	/**
	 * Returns the value of the '<em><b>Something</b></em>' attribute list.
	 * The list contents are of type {@link EPackage1.Enum1}.
	 * The literals are from the enumeration {@link EPackage1.Enum1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Something</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Something</em>' attribute list.
	 * @see EPackage1.Enum1
	 * @see EPackage1.EPackage1Package#getClass3_Something()
	 * @model unique="false" upper="6"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='Something.'"
	 * @generated
	 */
	EList<Enum1> getSomething();

	/**
	 * Returns the value of the '<em><b>Special Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EPackage1.MyEClass#getClazzes <em>Clazzes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Special Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special Parent</em>' container reference.
	 * @see #setSpecialParent(MyEClass)
	 * @see EPackage1.EPackage1Package#getClass3_SpecialParent()
	 * @see EPackage1.MyEClass#getClazzes
	 * @model opposite="clazzes" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='Bla'"
	 * @generated
	 */
	MyEClass getSpecialParent();

	/**
	 * Sets the value of the '{@link EPackage1.Class3#getSpecialParent <em>Special Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Special Parent</em>' container reference.
	 * @see #getSpecialParent()
	 * @generated
	 */
	void setSpecialParent(MyEClass value);

} // Class3
