package com.tushar.DP2;

import java.util.Arrays;

public class LongestRepeatingSubsequence {

	/*
	 * in this ques you have given a string ,you have to return the length of
	 * longest common repeating subsequence.
	 * 
	 */

	public static void main(String[] args) {

		String s1 = "AABEBCDD";

		// make another string s2,which will be same as s1.

		String s2 = "AABEBCDD";

		int n = s1.length();
		int m = s2.length();

		int dp[][] = new int[n + 1][m + 1];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		int len = find(s1, s2, n, m, dp);

		System.out.println(len);
	}

	static int find(String s1, String s2, int n, int m, int dp[][]) {

		int N = n;
		int M = m;

		for (n = 0; n < N + 1; n++) {
			for (m = 0; m < M + 1; m++) {
				if (n == 0 || m == 0) {
					dp[n][m] = 0;
					continue;
				}

				if (s1.charAt(n - 1) == s2.charAt(m - 1) && n != m) {
					dp[n][m]= 1 + dp[n - 1][m - 1];
				} else {
					dp[n][m]= Math.max(dp[n][m - 1], dp[n - 1][m]);
				}
			}
		}

		return dp[N][M];

	}

}
