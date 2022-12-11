package com.sda.testingadvanced.parametrized;

public class PalindromeChecker {

	/**
	 * @return true if text is null or empty or a palindrome
	 */
	public static boolean isPalindrome(String text) {
		if(text == null) {
			return false;
		}
		return new StringBuilder(text).reverse().toString().equalsIgnoreCase(text);
	}
}
