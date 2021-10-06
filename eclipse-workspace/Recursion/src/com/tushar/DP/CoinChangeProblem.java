package com.tushar.DP;

import java.util.Arrays;

public class CoinChangeProblem {

	// find maximum no of ways.
	//we can use one coin any  no of times

	public static void main(String[] args) {

		int coin[] = {2,3,5};
		int sum = 7;

		int n = coin.length;

		int dp[][] = new int[n + 1][sum + 1];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(findWays(coin, sum, n));
		System.out.println(findWaysDP(coin, sum, n, dp));

	}

	static int findWaysDP(int[] coin, int sum, int n, int[][] dp) {

		int N = n;
		int SUM = sum;
		for (n = 0; n < N + 1; n++) {
			for (sum = 0; sum < SUM + 1; sum++) {
				if (sum == 0) {
					dp[n][sum] = 1;
					continue;
				}

				if (n == 0 && sum != 0) {
					dp[n][sum] = 0;
					continue;
				}
				if (coin[n - 1] <= sum) {
					int add = dp[n][sum - coin[n - 1]];
					int notAdd = dp[n - 1][sum];

					dp[n][sum] = add + notAdd;

				} else {
					dp[n][sum] = dp[n - 1][sum];
				}
			}
		}

		return dp[N][SUM];

	}

	static int findWays(int[] coin, int sum, int n) {

		if (sum == 0) {
			return 1;
		}

		if (n == 0 && sum != 0) {
			return 0;
		}
		if (coin[n - 1] <= sum) {
			int add = findWays(coin, sum - coin[n - 1], n);
			int notAdd = findWays(coin, sum, n - 1);

			return add + notAdd;

		} else {
			return findWays(coin, sum, n - 1);
		}

	}

}
