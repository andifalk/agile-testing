package tdd.samples.category.tests;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import tdd.samples.category.Nightly;
import tdd.samples.verification.VerifyObject;

@RunWith(MockitoJUnitRunner.class)
@Category (Nightly.class)
public class VerifyCallCTest {
	
	@Spy
	private VerifyObject cut = new VerifyObject();
	
	@Test
	public void testCallA() {
		System.out.println("-----> VerifyCallCTest#testCallC");

		cut.callC();
		
		verify(cut).callC();
		
		verify(cut, never()).callA();
		verify(cut, never()).callB();
		verify(cut, never()).callD();

	}

}
