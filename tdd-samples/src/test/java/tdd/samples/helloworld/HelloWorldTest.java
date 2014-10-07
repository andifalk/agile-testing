package tdd.samples.helloworld;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import tdd.samples.helloworld.HelloWorld;

public class HelloWorldTest {
	private HelloWorld cut;

	@Before
	public void setUp() {
		cut = new HelloWorld();
	}

	@Test
	public void verifySayHello() {
		String greeting = cut.sayHello("World");
		assertThat("Should have got expected greeting", greeting, is("Hallo World"));
	}
}
