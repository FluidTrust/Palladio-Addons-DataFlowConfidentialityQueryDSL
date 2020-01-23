/**
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.dSL.tests;

import de.sebinside.dcp.dsl.dSL.DSLFactory;
import de.sebinside.dcp.dsl.dSL.PropertyType;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Property Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertyTypeTest extends CharacteristicsTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PropertyTypeTest.class);
	}

	/**
	 * Constructs a new Property Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Property Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PropertyType getFixture() {
		return (PropertyType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DSLFactory.eINSTANCE.createPropertyType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PropertyTypeTest
