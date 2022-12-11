package com.sda.testingadvanced.parametrized.romannumeral.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import com.sda.testingadvanced.parametrized.romannumeral.ArabicToRoman;
import com.sda.testingadvanced.parametrized.romannumeral.RomanNumeralConverter;

class RomanNumeralConverterTest {

	@ParameterizedTest
	@EnumSource
	void testSimpleConversions(ArabicToRoman arabicToRoman) {
		String actualRoman = RomanNumeralConverter.romanFor(arabicToRoman.getArabic());
		assertEquals(arabicToRoman.getRoman(), actualRoman);
	}

}