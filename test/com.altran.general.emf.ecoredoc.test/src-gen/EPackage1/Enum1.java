/**
 */
package EPackage1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Enum1</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see EPackage1.EPackage1Package#getEnum1()
 * @model
 * @generated
 */
public enum Enum1 implements Enumerator {
	/**
	 * The '<em><b>Literal1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LITERAL1_VALUE
	 * @generated
	 * @ordered
	 */
	LITERAL1(0, "Literal1", "Literal1"),

	/**
	 * The '<em><b>Literal2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LITERAL2_VALUE
	 * @generated
	 * @ordered
	 */
	LITERAL2(1, "Literal2", "Literal2"),

	/**
	 * The '<em><b>Literal3</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LITERAL3_VALUE
	 * @generated
	 * @ordered
	 */
	LITERAL3(5, "Literal3", "Literal3");

	/**
	 * The '<em><b>Literal1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Literal1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LITERAL1
	 * @model name="Literal1"
	 * @generated
	 * @ordered
	 */
	public static final int LITERAL1_VALUE = 0;

	/**
	 * The '<em><b>Literal2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Literal2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LITERAL2
	 * @model name="Literal2"
	 * @generated
	 * @ordered
	 */
	public static final int LITERAL2_VALUE = 1;

	/**
	 * The '<em><b>Literal3</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Literal3</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LITERAL3
	 * @model name="Literal3"
	 * @generated
	 * @ordered
	 */
	public static final int LITERAL3_VALUE = 5;

	/**
	 * An array of all the '<em><b>Enum1</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Enum1[] VALUES_ARRAY =
		new Enum1[] {
			LITERAL1,
			LITERAL2,
			LITERAL3,
		};

	/**
	 * A public read-only list of all the '<em><b>Enum1</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Enum1> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Enum1</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Enum1 get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Enum1 result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enum1</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Enum1 getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Enum1 result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enum1</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Enum1 get(int value) {
		switch (value) {
			case LITERAL1_VALUE: return LITERAL1;
			case LITERAL2_VALUE: return LITERAL2;
			case LITERAL3_VALUE: return LITERAL3;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Enum1(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Enum1
