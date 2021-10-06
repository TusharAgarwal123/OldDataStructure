package com.tushar.DP;

public class CoinChange2 {

	// count minimum no coins .
	public static void main(String[] args) {

		int coin[] = { 1, 2, 3 };
		int sum = 5;
		int n = coin.length;

		int dp[][] = new int[n + 1][sum + 1];

		System.out.println(countCoin(coin, sum, n));
		System.out.println(countCoinDP(coin, sum, n, dp));

	}

	static int countCoinDP(int[] coin, int sum, int n, int[][] dp) {

		int N = n;
		int SUM = sum;

		for (n = 0; n < N + 1; n++) {
			for (sum = 0; sum < SUM + 1; sum++) {
				if (sum == 0) {
					dp[n][sum] = 0;
					continue;
				}
				if (n == 0 && sum != 0) {
					dp[n][sum] = Integer.MAX_VALUE - 1;
					continue;
				}

				if (coin[n - 1] <= sum) {
					int add = dp[n][sum - coin[n - 1]] + 1;
					int notAdd = dp[n - 1][sum];
					dp[n][sum] = Math.min(add, notAdd);

				} else {
					dp[n][sum] = dp[n - 1][sum];
				}
			}
		}

		return dp[N][SUM];

	}

	static int countCoin(int[] coin, int sum, int n) {

		if (sum == 0) {
			return 0;
		}
		if (n == 0 && sum != 0) {
			return Integer.MAX_VALUE - 1;
		}

		if (coin[n - 1] <= sum) {
			int add = countCoin(coin, sum - coin[n - 1], n) + 1;
			int notAdd = countCoin(coin, sum, n - 1);
			return Math.min(add, notAdd);

		} else {
			return countCoin(coin, sum, n - 1);
		}

	}

}
