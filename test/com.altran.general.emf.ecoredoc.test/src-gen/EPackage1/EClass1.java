/**
 */
package EPackage1;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EClass1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: Find a good way to show class attributes like abstract.
 * 
 * Description of EClass1
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EPackage1.EClass1#getName <em>Name</em>}</li>
 *   <li>{@link EPackage1.EClass1#getId <em>Id</em>}</li>
 *   <li>{@link EPackage1.EClass1#getMyRelation <em>My Relation</em>}</li>
 * </ul>
 *
 * @see EPackage1.EPackage1Package#getEClass1()
 * @model abstract="true"
 * @generated
 */
public interface EClass1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name desc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute list.
	 * @see EPackage1.EPackage1Package#getEClass1_Name()
	 * @model unique="false" lower="3" upper="5"
	 * @generated
	 */
	EList<String> getName();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description of id.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see EPackage1.EPackage1Package#getEClass1_Id()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link EPackage1.EClass1#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>My Relation</b></em>' reference list.
	 * The list contents are of type {@link EPackage1.MyEClass}.
	 * It is bidirectional and its opposite is '{@link EPackage1.MyEClass#getBackwards <em>Backwards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>My Relation</em>' reference list.
	 * @see EPackage1.EPackage1Package#getEClass1_MyRelation()
	 * @see EPackage1.MyEClass#getBackwards
	 * @model opposite="backwards" ordered="false"
	 * @generated
	 */
	EList<MyEClass> getMyRelation();

} // EClass1
