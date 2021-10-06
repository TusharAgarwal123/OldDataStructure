package com.tushar.DP2;

import java.util.Arrays;

public class LongestCommonSubstring {

	public static void main(String[] args) {

		String s1 = "abdgh";
		String s2 = "abdgjdgh";
		int n = s1.length();
		int m = s2.length();

		int dp[][] = new int[n + 1][m + 1];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(find(s1, s2, n, m));

		System.out.println(find_DP(s1, s2, n, m, dp));

	}

	
	//fine solution
	static int find_DP(String s1, String s2, int n, int m, int[][] dp) {

		int N = n;
		int M = m;

		int lcs = 0;

		for (n = 0; n < N + 1; n++) {
			for (m = 0; m < M + 1; m++) {
				if (n == 0 || m == 0) {
					dp[n][m] = 0;
					continue;
				}

				if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
					dp[n][m] = 1 + dp[n - 1][m - 1];
					lcs = Math.max(lcs, dp[n][m]);
				} else {
					dp[n][m] = 0;

				}
			}
		}
		return lcs;

	}

	static int find(String s1, String s2, int n, int m) {

		if (n == 0 || m == 0) {
			return 0;
		}

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return 1 + find(s1, s2, n - 1, m - 1);
		} else {
			return 0;
		}

	}
}
