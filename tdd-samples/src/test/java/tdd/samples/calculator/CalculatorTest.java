package tdd.samples.calculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest {
	private Calculator cut = new Calculator();
	
	@Test
	public final void verifySum() {
		BigInteger sum = cut
							.sum(new BigInteger("2"))
							.sum(new BigInteger("3"))
							.sum(new BigInteger("4"))
							.result();
		assertThat("Should have calculated expected sum", sum, is(new BigInteger("9")));
	}

	@Test
	public final void verifySub() {
		BigInteger sub = cut
							.set(new BigInteger("10"))
							.sub(new BigInteger("3"))
							.sub(new BigInteger("4"))
							.result();
		assertThat("Should have calculated expected subtraction", sub, is(new BigInteger("3")));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void verifySubErrorWithZero() {
		cut.
			set(null)
			.sub(new BigInteger("3"))
			.result();
	}

}
