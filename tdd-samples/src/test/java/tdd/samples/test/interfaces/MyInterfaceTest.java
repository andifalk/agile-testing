package tdd.samples.test.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tdd.samples.test.interfaces.impl.MyInterfaceImplFirst;
import tdd.samples.test.interfaces.impl.MyInterfaceImplSecond;
import tdd.samples.test.interfaces.impl.MyInterfaceImplThird;

@RunWith(Parameterized.class)
public class MyInterfaceTest {

	private Class<MyInterface> myInterfaceImplClass;
	private MyInterface cut;
	
	public MyInterfaceTest(Class<MyInterface> myInterfaceImplClass) {
		this.myInterfaceImplClass = myInterfaceImplClass;
	}
	
	@Before
	public void setUp() throws InstantiationException, IllegalAccessException {
		cut = myInterfaceImplClass.newInstance();
	}

	@Parameters
	public static Collection<Object[]> myInterfaceImplementations() {
		List<Object[]> impls = new ArrayList<>();
		impls.add(new Object[] {MyInterfaceImplFirst.class});
		impls.add(new Object[] {MyInterfaceImplSecond.class});
		impls.add(new Object[] {MyInterfaceImplThird.class});
		return impls;
	}
	
	@Test
	public final void testMyOperation() {
		cut.myOperation();
	}

}
