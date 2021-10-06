package com.tushar.DP2;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {

		String s1 = "geek";
		String s2 = "eke";

		// we have to merge these two string in one string ,so that in new string
		// we can find the subsequence "geek" and "eke" ,we have to find the length
		// of new string but it should be minimum.

		int n = s1.length();
		int m = s2.length();

		int dp[][] = new int[n + 1][m + 1];

		int len = find(s1, s2, n, m, dp);

		// length of ShortestCommonSuperSequence

		System.out.println(s1.length() + s2.length() - len);

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

				if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
					dp[n][m] = 1 + dp[n - 1][m - 1];
				} else {
					dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
				}
			}
		}

		return dp[N][M];

	}

}
