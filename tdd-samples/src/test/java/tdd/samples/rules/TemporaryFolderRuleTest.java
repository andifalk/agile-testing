package tdd.samples.rules;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class TemporaryFolderRuleTest {
	
	@Mock
	private MyService cut;
	
	@Rule
	public Timeout timeout = new Timeout(200);

	@Test
	public final void verifyOperationA() throws MyExceptionA {
		when(cut.operationA(anyString())).thenAnswer(new Answer<String>() {
			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				Thread.sleep(300);
				return invocation.getArgumentAt(0, String.class);
			}
		});

		cut.operationA("testA");
	}

	@Test
	public final void verifyOperationB() throws MyExceptionB {
		when(cut.operationB(anyString())).thenAnswer(new Answer<String>() {
			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				Thread.sleep(100);
				return invocation.getArgumentAt(0, String.class);
			}
		});

		cut.operationB("testB");
	}

}
