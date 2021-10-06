package com.tushar.DP3;

import java.util.HashMap;

public class ScrambleString {

	// leetcode 87.
	public static void main(String[] args) {

		String s1 = "great";
		String s2 = "rgeat";

		HashMap<String, Boolean> dp = new HashMap<>();

		System.out.println(isScramble(s1, s2, dp));

	}

	public static boolean isScramble(String s1, String s2, HashMap<String, Boolean> dp) {

		if (s1.length() != s2.length()) {

			return false;

		}

		if (s1.length() == 0 && s2.length() == 0) {

			return true;

		}

		if (s1.equals(s2)) {

			return true;

		}

		return solve(s1, s2, dp);

	}

	public static boolean solve(String s1, String s2, HashMap<String, Boolean> dp) {

		if (s1.equals(s2)) {

			return true;

		}

		if (s1.length() == 0 && s2.length() != 0) {
			return false;
		}

		if (s2.length() == 0 && s1.length() != 0) {
			return false;
		}

		String key = s1 + "_" + s2;

		if (dp.containsKey(key)) {
			return dp.get(key);
		}

		int n = s1.length();
		boolean flag = false;

		for (int i = 1; i <= n - 1; i++) {

			if (solve(s1.substring(0, i), s2.substring(n - i), dp)
					&& solve(s1.substring(i), s2.substring(0, n - i), dp)) {

				flag = true;
				break;

			}
			if (solve(s1.substring(0, i), s2.substring(0, i), dp) && solve(s1.substring(i), s2.substring(i), dp)) {

				flag = true;
				break;

			}

		}

		dp.put(key, flag);
		return flag;

	}

}
