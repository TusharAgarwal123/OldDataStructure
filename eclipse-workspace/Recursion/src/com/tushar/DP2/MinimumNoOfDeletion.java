package com.tushar.DP2;

public class MinimumNoOfDeletion {

	// you have given a string ,you have to find MinimumNoOfDeletion require to
	// convert the string in palindrome string.

	// if you asked to find the no of the insertion,then do the same thing.
	public static void main(String[] args) {

		String s1 = "agbcba";
		StringBuffer sf = new StringBuffer();
		sf.append(s1);
		sf = sf.reverse();
		String s2 = sf.toString();

		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[n + 1][m + 1];

		int len = find(s1, s2, n, m, dp);
		System.out.println(len);

		int deletionRequire = s1.length() - len;
		System.out.println(deletionRequire);

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
					dp[n][m] = Math.max(dp[n][m - 1], dp[n - 1][m]);
				}
			}
		}
		return dp[N][M];

	}

}
