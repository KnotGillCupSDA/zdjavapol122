package com.sda.testingadvanced.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	void shouldAddTwoPositiveNumbers() {
		//given
		Calculator calculator = new Calculator();

		//when
		double sum = calculator.add(2.0, 3.0);

		//then
		assertEquals(5.0, sum);
	}
}
