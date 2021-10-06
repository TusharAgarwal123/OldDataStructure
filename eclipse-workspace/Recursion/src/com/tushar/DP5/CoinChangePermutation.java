package com.tushar.DP5;

public class CoinChangePermutation {

	/*
	 * you have a coin array and target ,you have to find no of subsets whose sum is
	 * equal to target,it can contain permutation of sunsets.
	 */

	public static void main(String[] args) {

		int ar[] = { 2, 3, 5 };
		int sum = 7;

		int dp[] = new int[sum + 1];

		dp[0] = 1;
		for (int t = 1; t <= sum; t++) {
			for (int coin : ar) {
				if (coin <= t) {
					int rmt = t - coin;
					dp[t] += dp[rmt];
				}
			}
		}

		System.out.println(dp[sum]);

	}

}
