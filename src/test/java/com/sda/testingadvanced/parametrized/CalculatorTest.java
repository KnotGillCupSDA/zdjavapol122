package com.sda.testingadvanced.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private Calculator calculator;

	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}

	@BeforeEach
	void setUp() {
		System.out.println("beforeEach");
		calculator = new Calculator();
	}

	@AfterEach
	void tearDown() {
		System.out.println("afterEach");
	}

	@Test
	void shouldAddTwoPositiveNumbers() {
		System.out.println("shouldAddTwoPositiveNumbers");
		//given
		//Calculator calculator = new Calculator();

		//when
		double sum = calculator.add(2.0, 3.0);

		//then
		assertEquals(5.0, sum);
	}

	@Test
	void shouldAddTwoNegativeNumbers() {
		System.out.println("shouldAddTwoNegativeNumbers");
		//given
		//Calculator calculator = new Calculator();

		//when
		double sum = calculator.add(-2.0, -1.0);

		//then
		assertEquals(-3.0, sum);
	}
}
