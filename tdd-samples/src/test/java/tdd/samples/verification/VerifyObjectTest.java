package tdd.samples.verification;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class VerifyObjectTest {
	
	@Spy
	private VerifyObject cut = new VerifyObject();
	
	@Test
	public void testCallA() {
		System.out.println("-----> testCallA");

		cut.callA();
		
		verify(cut).callA();
		verify(cut).callB();
		verify(cut).callC();
		
		verify(cut, never()).callD();

	}

	@Test
	public void testCallAInOrder() {
		System.out.println("-----> testCallB");
		
		cut.callA();
		
		InOrder order = inOrder(cut);
		order.verify(cut).callA();
		order.verify(cut).callB();
		order.verify(cut).callC();
		
		verify(cut, never()).callD();

	}
	
	@Test
	public void testCallModifiedA() {
		System.out.println("-----> testCallB");
		
		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				System.out.println("-----> Stubbed callA()");
				return null;
			}
		}).when(cut).callA();
		
		cut.callA();
		
		InOrder order = inOrder(cut);
		order.verify(cut, times(1)).callA();
		
		verify(cut, never()).callB();
		verify(cut, never()).callC();
		verify(cut, never()).callD();

	}

}
