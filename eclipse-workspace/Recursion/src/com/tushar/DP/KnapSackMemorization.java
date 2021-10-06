package com.tushar.DP;

import java.util.Arrays;

public class KnapSackMemorization {

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

		if (w == 0 || n == 0) {
			return 0;
		}

		if (dp[n][w] != -1) {
			return dp[n][w];
		}

		if (wt[n - 1] <= w) {
			int add = knapsack(wt, vol, w - wt[n - 1], n - 1, dp) + vol[n - 1];
			int notAdd = knapsack(wt, vol, w, n - 1, dp);

			return dp[n][w] = Math.max(add, notAdd);

		}

		// if(wt[n-1]>w)
		else {
			return dp[n][w] = knapsack(wt, vol, w, n - 1, dp);
		}

	}

}
