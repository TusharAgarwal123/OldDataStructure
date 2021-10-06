package com.tushar.DP;

import java.util.Arrays;

public class KnapSackDP {

	public static void main(String[] args) {

		int wt[] = { 3, 6, 2, 8, 5 };
		int vol[] = { 15, 17, 20, 26, 20 };

		int w = 14;

		int n = wt.length;

		int dp[][] = new int[n + 1][w + 1];

		for (int row[] : dp) {

			Arrays.fill(row, -1);
		}

		System.out.println(knapsack(wt, vol, w, n, dp));

	}

	static int knapsack(int[] wt, int[] vol, int w, int n, int dp[][]) {

		int N = n + 1;
		int W = w + 1;

		for (n = 0; n < N; n++) {
			for (w = 0; w < W; w++) {
				if (n == 0 || w == 0) {
					dp[n][w] = 0;
					continue;
				}

				if (wt[n - 1] <= w) {
					int add = dp[n - 1][w - wt[n - 1]] + vol[n - 1];
					int notAdd = dp[n - 1][w];

					dp[n][w] = Math.max(add, notAdd);

				}

				// if(wt[n-1]>w)
				else {
					dp[n][w] = dp[n - 1][w];
				}
			}
		}

		return dp[N - 1][W - 1];

	}

}
