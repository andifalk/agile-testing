package tdd.samples.sequence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Shows the execution sequence of JUnit methods.
 */
public class JUnitSequenceTest {
	
	public JUnitSequenceTest() {
		System.out.println("StructureTest()");
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println(this + " -> @Before");
	}

	@Test
	public void test1() {
		System.out.println(this + " -> @Test: test1()");
	}

	@Test
	public void test2() {
		System.out.println(this + " -> @Test: test2()");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(this + " -> @After");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

}
