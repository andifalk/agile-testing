package tdd.samples.category.tests;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import tdd.samples.category.Nightly;
import tdd.samples.verification.VerifyObject;

@RunWith(MockitoJUnitRunner.class)
@Category (Nightly.class)
public class VerifyCallDTest {
	
	@Spy
	private VerifyObject cut = new VerifyObject();
	
	@Test
	public void testCallA() {
		System.out.println("-----> VerifyCallDTest#testCallD");

		cut.callD();
		
		verify(cut).callD();
		
		verifyNoMoreInteractions(cut);
	}

}
