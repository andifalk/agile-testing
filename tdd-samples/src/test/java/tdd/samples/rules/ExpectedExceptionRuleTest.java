package tdd.samples.rules;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpectedExceptionRuleTest {
	
	@Mock
	private MyService cut;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none(); 

	@Test
	public final void verifyNoExpectedException() throws MyExceptionA {
		when(cut.operationA(anyString())).thenReturn("result");
		String result = cut.operationA("test");
		assertThat("Got expected result", result, is("result"));
	}

	@Test
	public final void verifyExpectedException() throws MyExceptionA {
		when(cut.operationA(anyString())).thenThrow(new MyExceptionA("Invalid"));
		
		expectedException.expect(MyExceptionA.class);
		expectedException.expectMessage(is("Invalid"));
		
		cut.operationA("test");
	}

}
