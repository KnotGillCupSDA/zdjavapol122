package com.sda.testingadvanced.parametrized;

public class DivisibilityChecker {

	public static boolean isDivisibleBy3(Integer number) {
		if(number == null) {
			return false;
		}
		return number % 3 == 0;
	}

}
