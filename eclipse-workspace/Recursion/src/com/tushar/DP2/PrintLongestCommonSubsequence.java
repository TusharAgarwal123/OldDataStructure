package com.tushar.DP2;

import java.util.Arrays;
import java.util.Stack;

public class PrintLongestCommonSubsequence {

	public static void main(String[] args) {

		String s1 = "ablcrksd";
		String s2 = "abcghd";
		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		find(s1, s2, n, m, dp); // it will fill your dp.

		String ss = "";

		while (n > 0 && m > 0) {
			if (s1.charAt(n - 1) == s2.charAt(m - 1)) {

				ss = s1.charAt(n - 1) + ss;
				n--;
				m--;
			} else {
				if (dp[n][m - 1] > dp[n - 1][m]) {
					m--;
				} else {
					n--;
				}
			}
		}

		System.out.println(ss);

	}

	static void find(String s1, String s2, int n, int m, int[][] dp) {

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

	}

}
