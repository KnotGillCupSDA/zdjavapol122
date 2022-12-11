package com.sda.testingadvanced.parametrized.solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.sda.testingadvanced.parametrized.DivisibilityChecker;

class DivisibilityCheckerTest {
	@ParameterizedTest
	@ValueSource(ints = { -9, 0, 9, 27 })
	void shouldBeDivisibleBy3(Integer number) {
		assertTrue(DivisibilityChecker.isDivisibleBy3(number));
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(ints = { 2, -8, 4, 61 })
	void shouldNotBeDivisibleBy3(Integer number) {
		//when
		boolean notDivisibleBy3 = DivisibilityChecker.isDivisibleBy3(number);

		//then
		assertFalse(notDivisibleBy3);
	}
}