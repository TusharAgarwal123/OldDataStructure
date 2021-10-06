package com.AdvanceRec3;

public class LargestNumberPossibleAfterAtMostKSwaps {

	/*
	 * 1. You are given a string which represents digits of a number. 2. You have to
	 * create the maximum number by performing at-most k swap operations on its
	 * digits.
	 */

	public static void main(String[] args) {

		String str = "1234567";
		int k = 4;
		max = str;

		findMaximum(str, k);
		System.out.println(max);

	}

	static String max;

	public static void findMaximum(String str, int k) {

		if (Integer.parseInt(str) > Integer.parseInt(max)) {
			max = str;
		}
		if (k == 0) {
			return;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {

				if (str.charAt(j) > str.charAt(i)) {
					str = swap(str, i, j);
					findMaximum(str, k - 1);
					str=swap(str,i,j);
				}

			}
		}

	}

	public static String swap(String str, int i, int j) {

		char ch1 = str.charAt(i);
		char ch2 = str.charAt(j);

		String left = str.substring(0, i);
		String rigth = str.substring(j + 1);
		String middle = str.substring(i + 1, j);

		String ans = left + ch2 + middle + ch1 + rigth;
		return ans;

	}

}
