package com.tushar.DP2;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromicSubsequence {

	// in this question you will be having only one string, you have to return the
	// length of longest palindromic subsequence.

	// LPS(s)=LCS(s,reverseOf(s))
	public static void main(String[] args) {

		String s1 = "abcybaab";
		StringBuffer sf = new StringBuffer();
		sf.append(s1);
		sf = sf.reverse();
		String s2 = sf.toString();

		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[n + 1][m + 1];

		find(s1, s2, n, m, dp);

		String Palindrome = "";

		while (n > 0 && m > 0) {
			if (s1.charAt(n - 1) == s2.charAt(m - 1)) {

				Palindrome = s1.charAt(n - 1) + Palindrome;
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

		System.out.println(Palindrome);

	}

	static void find(String s1, String s2, int n, int m, int dp[][]) {

		int N = n;
		int M = m;

		for (n = 0; n < N; n++) {
			for (m = 0; m < M; m++) {
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
