/**
 */
package EPackage1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My EClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EPackage1.MyEClass#getBackwards <em>Backwards</em>}</li>
 * </ul>
 *
 * @see EPackage1.EPackage1Package#getMyEClass()
 * @model
 * @generated
 */
public interface MyEClass extends EClass1 {
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
