package tdd.samples.category.tests;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import tdd.samples.category.ContinuousIntegration;
import tdd.samples.verification.VerifyObject;
import tdd.samples.verification.VerifyOtherObject;

@RunWith(MockitoJUnitRunner.class)
@Category (ContinuousIntegration.class)
public class VerifyCallATest {
	
	@Spy
	private VerifyObject cut1 = new VerifyObject();

	@Mock
	private VerifyOtherObject cut2;

	@Test
	public void testCallA() {
		System.out.println("-----> VerifyCallATest#testCallA");

		cut1.callA();
		
		verify(cut1).callA();
		verify(cut1).callB();
		verify(cut1).callC();
		verify(cut1).callCWithParam(anyString(), eq(5));
		
		verify(cut1, never()).callD();

	}
	
	@Test
	public void testCallAInOrder() {
		System.out.println("-----> VerifyCallATest#testCallB");
		
		cut1.callA();
		
		InOrder order = inOrder(cut1);
		order.verify(cut1).callA();
		order.verify(cut1).callB();
		order.verify(cut1).callC();
		
		verify(cut1, never()).callD();

	}

	@Test
	public void testCallAAndCallEInOrder() {
		System.out.println("-----> VerifyCallATest#testCallAAndCallD");
		
		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				System.out.println("-----> Stubbed callE()");
				cut2.callF();
				return null;
			}
		}).when(cut2).callE();
		
		cut1.callA();
		cut2.callE();
		
		InOrder order = inOrder(cut1,cut2);
		order.verify(cut1).callA();
		order.verify(cut1).callB();
		order.verify(cut1).callC();
		order.verify(cut2).callE();
		order.verify(cut2).callF();
		
		verify(cut1, never()).callD();

	}
	
	@Test
	public void testCallModifiedA() {
		System.out.println("-----> VerifyCallATest#testCallB");
		
		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				System.out.println("-----> Stubbed callA()");
				return null;
			}
		}).when(cut1).callA();
		
		cut1.callA();
		
		InOrder order = inOrder(cut1);
		order.verify(cut1, atLeast(1)).callA();
		
		verify(cut1, never()).callB();
		verify(cut1, never()).callC();
		verify(cut1, never()).callD();

	}

}
