/**
 * generated by Xtext 2.20.0
 */
package de.sebinside.dcp.dsl.dSL.tests;

import de.sebinside.dcp.dsl.dSL.DSLFactory;
import de.sebinside.dcp.dsl.dSL.PropertySelector;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Property Selector</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertySelectorTest extends CharacteristicSelectorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PropertySelectorTest.class);
	}

	/**
	 * Constructs a new Property Selector test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySelectorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Property Selector test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PropertySelector getFixture() {
		return (PropertySelector)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DSLFactory.eINSTANCE.createPropertySelector());
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

} //PropertySelectorTest
