package com.tushar.DP3;

import java.util.Arrays;

public class PalindromicPartitioningRecursive {

	public static void main(String[] args) {

		String s = "nitik";
		int i = 0;
		int j = s.length() - 1;

		System.out.println(solve(s, i, j));

	}

	public static int solve(String s, int i, int j) {

		if (i >= j) {
			return 0;
		}

		if (isPalindrome(s, i, j)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {

			int temp = solve(s, i, k) + solve(s, k + 1, j) + 1;

			min = Math.min(min, temp);

		}

		return min;

	}

	public static boolean isPalindrome(String s, int i, int j) {

		if (i > j) {
			return true;
		}

		if (i == j) {
			return true;
		}

		if (s.charAt(i) != s.charAt(j)) {

			return false;

		}
		return isPalindrome(s, i + 1, j - 1);

	}

}
