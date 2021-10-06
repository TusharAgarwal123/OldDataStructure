package com.tushar.DP;

import java.util.Arrays;

public class RodCuttingProblem {

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8 }; // if this array is not given then make it on the basis of length of rod.
		int vol[] = { 5, 8, 2, 9, 4, 9, 16, 3 };
		int len = 8; // length of rod.
		int n = ar.length;

		int dp[][] = new int[n + 1][len + 1];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(findProfit(ar, vol, len, n));
		System.out.println(findProfitDP(ar, vol, len, n, dp));

	}

	static int findProfitDP(int[] ar, int[] vol, int len, int n, int[][] dp) {

		int N = n;
		int LEN = len;

		for (n = 0; n < N + 1; n++) {
			for (len = 0; len < LEN + 1; len++) {
				if (len == 0 || n == 0) {
					dp[n][len] = 0;
					continue;
				}

				if (ar[n - 1] <= len) {
					int cut = dp[n][len - ar[n - 1]] + vol[n - 1];
					int notCut = dp[n - 1][len];
					dp[n][len] = Math.max(cut, notCut);

				} else {
					dp[n][len] = dp[n - 1][len];
				}
			}
		}

		return dp[N][LEN];

	}

	static int findProfit(int[] ar, int[] vol, int len, int n) {

		if (len == 0 || n == 0) {
			return 0;
		}

		if (ar[n - 1] <= len) {
			int cut = findProfit(ar, vol, len - ar[n - 1], n) + vol[n - 1];
			int notCut = findProfit(ar, vol, len, n - 1);
			return Math.max(cut, notCut);

		} else {
			return findProfit(ar, vol, len, n - 1);
		}

	}

}
