
package com.tushar.DP;

import java.util.Arrays;

public class UnboundedKnapSack {

	public static void main(String[] args) {

		int ar[] = { 2, 5, 8, 5 };
		int vol[] = { 10, 40, 34, 16 };

		int w = 14;
		int n = ar.length;

		int dp[][] = new int[n + 1][w + 1];
		
		for(int[]row:dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(unboundedKnap(ar, vol, w, n));
		System.out.println(unboundedKnapDP(ar, vol, w, n, dp));

	}

	static int unboundedKnapDP(int[] ar, int[] vol, int w, int n, int[][] dp) {

		int N = n;
		int W = w;

		for (n = 0; n < N + 1; n++) {
			for (w = 0; w < W + 1; w++) {
				if (w == 0 || n == 0) {
					dp[n][w] = 0;
					continue;
				}

				if (ar[n - 1] <= w) {
					int add = dp[n][w - ar[n - 1]]+vol[n-1];
					int notAdd = dp[n - 1][w];

					dp[n][w] = Math.max(add, notAdd);
				} else {
					dp[n][w] = dp[n - 1][w];
				}

			}
		}
		return dp[N][W];

	}

	static int unboundedKnap(int[] ar, int[] vol, int w, int n) {

		if (w == 0 || n == 0) {
			return 0;
		}

		if (ar[n - 1] <= w) {
			int add = unboundedKnap(ar, vol, w - ar[n - 1], n) + vol[n - 1];
			int notAdd = unboundedKnap(ar, vol, w, n - 1);

			return Math.max(add, notAdd);
		} else {
			return unboundedKnap(ar, vol, w, n - 1);
		}

	}

}
