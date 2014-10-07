package tdd.samples.calculator;

import java.math.BigInteger;

/**
 * A calculator supporting a fluent interface.
 */
public class Calculator {
	BigInteger calculatedValue = new BigInteger("0");

	public Calculator set(BigInteger value) {
		if (value == null) {
			throw new IllegalArgumentException("No value has been set");
		}
		calculatedValue = value;
		return this;
	}

	public Calculator sum(BigInteger value) {
		if (value == null) {
			throw new IllegalArgumentException("No value has been given to sum");
		}
		calculatedValue = calculatedValue.add(value);
		return this;
	}

	public Calculator sub(BigInteger value) {
		if (value == null) {
			throw new IllegalArgumentException("No value has been given to subtract");
		}
		calculatedValue = calculatedValue.subtract(value);
		return this;
	}
	
	public BigInteger result() {
		return calculatedValue;
	}

}
