package com.tushar.DP2;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String s1 = "acbcf";
		String s2 = "abcdaf";
		int n = s1.length();
		int m = s2.length();

		int dp[][] = new int[n + 1][m + 1];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(find(s1, s2, n, m));
		System.out.println(find_Memorization(s1, s2, n, m, dp));
		System.out.println(find_DP(s1, s2, n, m, dp));

	}

	static int find_DP(String s1, String s2, int n, int m, int[][] dp) {

		int N = n;
		int M = m;

		for (n = 0; n < N + 1; n++) {
			for (m = 0; m < M + 1; m++) {
				if (n == 0 || m == 0) {
					dp[n][m] = 0;
					continue;
				}

				if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
					dp[n][m] = 1 + dp[n - 1][m - 1];
				} else {
					dp[n][m] = Math.max(dp[n][m - 1], dp[n - 1][m]);

				}
			}
		}

		return dp[N][M];

	}

	static int find(String s1, String s2, int n, int m) {

		if (n == 0 || m == 0) {
			return 0;
		}

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return 1 + find(s1, s2, n - 1, m - 1);
		} else {
			return Math.max(find(s1, s2, n, m - 1), find(s1, s2, n - 1, m));
		}

	}

	static int find_Memorization(String s1, String s2, int n, int m, int dp[][]) {

		if (n == 0 || m == 0) {
			return dp[n][m] = 0;
		}

		if (dp[n][m] != -1) {
			return dp[n][m];
		}

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return dp[n][m] = 1 + find_Memorization(s1, s2, n - 1, m - 1, dp);
		} else {
			return dp[n][m] = Math.max(find_Memorization(s1, s2, n, m - 1, dp),
					find_Memorization(s1, s2, n - 1, m, dp));
		}

	}

}
