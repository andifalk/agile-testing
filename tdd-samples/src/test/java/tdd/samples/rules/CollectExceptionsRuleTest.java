package tdd.samples.rules;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CollectExceptionsRuleTest {
	
	@Mock
	private MyService cut;
	
	@Rule
	public ErrorCollector errorCollector = new ErrorCollector(); 

	@Test
	public final void verifyExpectedException() throws MyExceptionA, MyExceptionB, MyExceptionC {
		when(cut.operationA(anyString())).thenThrow(new MyExceptionA("InvalidA"));
		when(cut.operationB(anyString())).thenThrow(new MyExceptionB("InvalidB"));
		when(cut.operationC(anyString())).thenThrow(new MyExceptionC("InvalidC"));

		try {
			cut.operationA("testA");
		} catch (MyExceptionA ex) {
			errorCollector.addError(ex);
		}
		try {
			cut.operationB("testB");
		} catch (MyExceptionB ex) {
			errorCollector.addError(ex);
		}
		try {
			cut.operationC("testC");
		} catch (MyExceptionC ex) {
			errorCollector.addError(ex);
		}

	}

}
