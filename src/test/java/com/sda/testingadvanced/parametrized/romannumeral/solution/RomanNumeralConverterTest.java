package com.sda.testingadvanced.parametrized.romannumeral.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.sda.testingadvanced.parametrized.romannumeral.ArabicToRoman;
import com.sda.testingadvanced.parametrized.romannumeral.RomanNumeralConverter;

class RomanNumeralConverterTest {

	@ParameterizedTest
	@EnumSource
	void testSimpleConversions(ArabicToRoman arabicToRoman) {
		String actualRoman = RomanNumeralConverter.romanFor(arabicToRoman.getArabic());
		assertEquals(arabicToRoman.getRoman(), actualRoman);
	}

	@ParameterizedTest
	//@CsvSource(value = {"2022, MMXXII", "4587, MMMMDLXXXVII"})
	@MethodSource("complexNumbers")
	void testComplexConversions(int arabic, String expectedRoman) {
		String actualRoman = RomanNumeralConverter.romanFor(arabic);
		assertEquals(expectedRoman, actualRoman);
	}

	public static Stream<Arguments> complexNumbers() {
		return Stream.of(
				arguments(2022, "MMXXII"),
				arguments(4587, "MMMMDLXXXVII")
		);
	}
}