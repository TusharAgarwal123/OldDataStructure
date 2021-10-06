package com.AdvanceRec3;

public class AllPalindromicPartitions {

	/*
	 * 1. You are given a string of length n. 2. You have to partition the given
	 * string in such a way that every partition is a palindrome.
	 */

	public static void main(String[] args) {

		String str = "ababa";
		solution(str, "");

	}

	public static void solution(String str, String ans) {

		if (str.isEmpty()) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String ss = str.substring(0, i + 1);
			if (isPalindrome(ss)) {
				solution(str.substring(i + 1), ans + "(" + ss + ")");
			}
		}

	}

	public static boolean isPalindrome(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i < j) {

			char c1 = str.charAt(i);
			char c2 = str.charAt(j);
			if (c1 != c2) {
				return false;
			}
			i++;
			j--;

		}
		return true;

	}

}
