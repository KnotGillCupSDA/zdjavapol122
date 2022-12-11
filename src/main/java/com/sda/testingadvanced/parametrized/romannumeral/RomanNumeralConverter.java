package com.sda.testingadvanced.parametrized.romannumeral;

public class RomanNumeralConverter {

	public static String romanFor(int arabic) {
        StringBuilder roman = new StringBuilder();

        for (ArabicToRoman arabicToRoman : ArabicToRoman.values()) {
            while (arabic >= arabicToRoman.getArabic()) {
                roman.append(arabicToRoman.getRoman());
                arabic -= arabicToRoman.getArabic();
            }
        }
        return roman.toString();
    }

}