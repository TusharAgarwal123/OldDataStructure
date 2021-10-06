package com.tushar.DP4;

public class MaximumSumIncreasingSubsequence {

	// you have to find the maximum sum of increasing subsequence.

	public static void main(String[] args) {

		int ar[] = { 10, 20, 9, 33, 40, 60, 50, 80 };

		int dp[] = new int[ar.length];

		System.out.println(find(ar, dp));

	}

	private static int find(int[] ar, int[] dp) {

		int overAllSum = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			Integer max = null; // value can be nagative.if we take 0 so answer can be wrong.
			for (int j = 0; j < i; j++) {
				if (ar[j] < ar[i]) {
					if (max == null) {
						max = dp[j];
					} else if (dp[j] > max) {
						max = dp[j];
					}

				}
			}
			if (max == null) {
				dp[i] = ar[i];
			} else {
				dp[i] = max + ar[i];
			}
			overAllSum = Math.max(overAllSum, dp[i]);
		}

		return overAllSum;

	}

}
