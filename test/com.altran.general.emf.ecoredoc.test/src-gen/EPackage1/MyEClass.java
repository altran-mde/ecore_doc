/**
 */
package EPackage1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My EClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Description
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EPackage1.MyEClass#getAttr <em>Attr</em>}</li>
 *   <li>{@link EPackage1.MyEClass#getRef <em>Ref</em>}</li>
 *   <li>{@link EPackage1.MyEClass#getClazzes <em>Clazzes</em>}</li>
 *   <li>{@link EPackage1.MyEClass#getEeeenum <em>Eeeenum</em>}</li>
 *   <li>{@link EPackage1.MyEClass#getOtherClasses <em>Other Classes</em>}</li>
 *   <li>{@link EPackage1.MyEClass#getBackwards <em>Backwards</em>}</li>
 * </ul>
 *
 * @see EPackage1.EPackage1Package#getMyEClass()
 * @model
 * @generated
 */
public interface MyEClass extends EClass1 {
	/**
	 * Returns the value of the '<em><b>Attr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description.
	 * 
	 * Second sentence.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attr</em>' attribute.
	 * @see #setAttr(Number)
	 * @see EPackage1.EPackage1Package#getMyEClass_Attr()
	 * @model unique="false" dataType="EPackage1.SpecialDataType"
	 * @generated
	 */
	Number getAttr();

	/**
	 * Sets the value of the '{@link EPackage1.MyEClass#getAttr <em>Attr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attr</em>' attribute.
	 * @see #getAttr()
	 * @generated
	 */
	void setAttr(Number value);

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whatever.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(EClass1)
	 * @see EPackage1.EPackage1Package#getMyEClass_Ref()
	 * @model
	 * @generated
	 */
	EClass1 getRef();

	/**
	 * Sets the value of the '{@link EPackage1.MyEClass#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(EClass1 value);

	/**
	 * Returns the value of the '<em><b>Clazzes</b></em>' containment reference list.
	 * The list contents are of type {@link EPackage1.Class3}.
	 * It is bidirectional and its opposite is '{@link EPackage1.Class3#getSpecialParent <em>Special Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Desc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Clazzes</em>' containment reference list.
	 * @see EPackage1.EPackage1Package#getMyEClass_Clazzes()
	 * @see EPackage1.Class3#getSpecialParent
	 * @model opposite="specialParent" containment="true" required="true"
	 * @generated
	 */
	EList<Class3> getClazzes();

	/**
	 * Returns the value of the '<em><b>Eeeenum</b></em>' attribute list.
	 * The list contents are of type {@link EPackage1.Enum1}.
	 * The literals are from the enumeration {@link EPackage1.Enum1}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Deschkriptschion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Eeeenum</em>' attribute list.
	 * @see EPackage1.Enum1
	 * @see EPackage1.EPackage1Package#getMyEClass_Eeeenum()
	 * @model default="Literal1" unique="false" upper="6"
	 * @generated
	 */
	EList<Enum1> getEeeenum();

	/**
	 * Returns the value of the '<em><b>Other Classes</b></em>' containment reference list.
	 * The list contents are of type {@link EPackage1.Class3}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Desc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Other Classes</em>' containment reference list.
	 * @see EPackage1.EPackage1Package#getMyEClass_OtherClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<Class3> getOtherClasses();

	/**
	 * Returns the value of the '<em><b>Backwards</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link EPackage1.EClass1#getMyRelation <em>My Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backwards</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backwards</em>' reference.
	 * @see #setBackwards(EClass1)
	 * @see EPackage1.EPackage1Package#getMyEClass_Backwards()
	 * @see EPackage1.EClass1#getMyRelation
	 * @model opposite="myRelation" required="true"
	 * @generated
	 */
	EClass1 getBackwards();

	/**
	 * Sets the value of the '{@link EPackage1.MyEClass#getBackwards <em>Backwards</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backwards</em>' reference.
	 * @see #getBackwards()
	 * @generated
	 */
	void setBackwards(EClass1 value);

} // MyEClass
