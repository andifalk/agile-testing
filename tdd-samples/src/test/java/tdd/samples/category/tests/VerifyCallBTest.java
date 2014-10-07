package tdd.samples.category.tests;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import tdd.samples.category.ContinuousIntegration;
import tdd.samples.verification.VerifyObject;

@RunWith(MockitoJUnitRunner.class)
@Category (ContinuousIntegration.class)
public class VerifyCallBTest {
	
	@Spy
	private VerifyObject cut = new VerifyObject();
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCallA() {
		System.out.println("-----> VerifyCallBTest#testCallA");

		cut.callB();
		
		verify(cut,atLeastOnce()).callB();
		verify(cut).callC();
		
		verify(cut, never()).callA();
		verify(cut, never()).callD();

	}

}
