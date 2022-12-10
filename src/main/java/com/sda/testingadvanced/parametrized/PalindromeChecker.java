package com.sda.testingadvanced.parametrized;

public class PalindromeChecker {

	/**
	 * @return true if text is a palindrome
	 */
	public static boolean isPalindrome(String text) {
		if(text == null) {
			return false;
		}

		String lowered = text.toLowerCase();

		// abba, kajak
		int i = 0;
		int j = text.length() - 1;

		while (i < lowered.length() && j >= 0 && i <= j) {
			if (lowered.charAt(i++) != lowered.charAt(j--)) {
				return false;
			}
		}

		return true;
	}

	public static boolean isPalindromeIwo(String text) {
		if(text == null) {
			return false;
		}
		String reversedString = "";
		char ch;
		for (int i = 0; i < text.length(); i++) {
			ch = text.charAt(i);
			reversedString = ch + reversedString;
		}
		return reversedString.equalsIgnoreCase(text);
	}

	public static boolean isPalindromeDavid(String text) {
		if(text == null) {
			return false;
		}
		String palindrome = "";
		char charAt;
		for (int i = 1; i <= text.length(); i++) {
			charAt = text.charAt(text.length() - i);
			palindrome += charAt;
		}
		return text.equalsIgnoreCase(palindrome);
	}


	public static boolean isPalindromeStringBuilder(String text) {
		if(text == null) {
			return false;
		}
		return new StringBuilder(text).reverse().toString().equalsIgnoreCase(text);
	}
}
