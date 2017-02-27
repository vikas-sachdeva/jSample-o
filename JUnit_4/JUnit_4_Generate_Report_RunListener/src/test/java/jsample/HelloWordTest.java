package jsample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import jsample.junit.report.TestCase;

/**
 * <pre>
 * Flow of execution of methods -
 * 
 * Method annotated by BeforeClass annotation
 * Method annotated by Before annotation
 * Method annotated by Test annotation
 * Method annotated by After annotation 
 * Method annotated by Before annotation
 * Method annotated by Test annotation
 * Method annotated by After annotation
 * ...
 * ...
 * Method annotated by AfterClass annotation
 * 
 * </pre>
 */
public class HelloWordTest {

	private HelloWorld helloWorld;

	/**
	 * BeforeClass annotation is used to initialize some data only once. Method
	 * annotated by this annotation is called first in the test class.
	 */
	@BeforeClass
	public static void setUpClass() {
		System.out.println("BeforeClass annotation");
	}

	/**
	 * AfterClass annotation is used to clean up data after execution of all
	 * test cases. Method annotated by this annotation is called last in the
	 * test class.
	 */
	@AfterClass
	public static void tearDownClass() {
		System.out.println("AfterClass annotation");
	}

	/**
	 * Before annotation is used to initialize same data for each test. Method
	 * annotated by this annotation is called before each test case.
	 */
	@Before
	public void setUp() {
		System.out.println("Before annotation");
		helloWorld = new HelloWorld();

	}

	/**
	 * After annotation is used to clean up data after execution of a test case.
	 * Method annotated by this annotation is called after each test case.
	 */
	@After
	public void tearDown() {
		System.out.println("After annotation");
		helloWorld = null;
	}

	/**
	 * Test annotation is used for marking method as JUnit test case.
	 */

	@TestCase(id = "testSetName1", category = "hello World")
	@Test
	public void testSetName() {
		System.out.println("Test annotation");
		String name = "JUnit Test";
		helloWorld.setName(name);
		Assert.assertEquals(name, helloWorld.getName());
	}

	@TestCase(id = "testGetName1", category = "hello World")
	@Test
	public void testGetName() {
		System.out.println("Test annotation");
		Assert.assertEquals("", helloWorld.getName());
	}

	@TestCase(id = "testGetMessage1", category = "hello World")
	@Test
	public void testGetMessage1() {
		System.out.println("Test annotation");
		Assert.assertEquals("Hello ", helloWorld.getMessage());
	}

	@TestCase(id = "testGetMessage2", category = "hello World")
	@Test
	@Ignore
	public void testGetMessage2() {
		System.out.println("Test annotation");
		helloWorld.setName("Test");
		Assert.assertEquals("Hello Test", helloWorld.getMessage());
	}
}