package com.tushar.DP4;

public class LongestPalindromicSubString {

	public static void main(String[] args) {

		String str = "abccbc";
		boolean dp[][] = new boolean[str.length()][str.length()];

		int longestSubString = 0;

		for (int gap = 0; gap < dp.length; gap++) {
			for (int i = 0, j = gap; j < dp.length; i++, j++) {
				if (gap == 0) {
					dp[i][j] = true;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				} else {
					if (str.charAt(i) != str.charAt(j)) {
						dp[i][j] = false;
					} else {
						dp[i][j] = dp[i + 1][j - 1];
					}
				}

				if (dp[i][j]) {
					// longestSubString = Math.max(longestSubString, gap + 1);
					longestSubString = gap + 1;
				}
			}

		}

		System.out.println("Length Of Longest SubString is: " + longestSubString);

	}

}
