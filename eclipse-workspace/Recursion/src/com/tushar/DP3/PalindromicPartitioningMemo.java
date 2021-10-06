package com.tushar.DP3;

import java.util.Arrays;

public class PalindromicPartitioningMemo {

	static int left;
	static int right;

	public static void main(String[] args) {

		String s = "nitik";
		int i = 0;
		int j = s.length() - 1;

		int dp[][] = new int[1001][1001];

		for (int row[] : dp) {
			Arrays.fill(row, -1);

		}

		System.out.println(solve(s, i, j, dp));

	}

	public static int solve(String s, int i, int j, int dp[][]) {

		if (i >= j) {
			return 0;
		}

		if (isPalindrome(s, i, j)) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {

			if (dp[i][k] != -1) {
				left = dp[i][k];
			} else {
				left = solve(s, i, k, dp);
				dp[i][k] = left;
			}

			if (dp[k + 1][j] != -1) {
				right = dp[k + 1][j];
			} else {
				right = solve(s, k + 1, j, dp);
				dp[k + 1][j] = right;
			}

			int temp = left + right + 1;

			min = Math.min(min, temp);

		}

		return dp[i][j] = min;

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
