package com.tushar.DP;

import java.util.Arrays;

public class CountSubsetWithSum {

	/*
	 * int this qstn you have given an array and a sum you have to count how many
	 * subsets are there in array whose sum is equal to given sum.
	 *
	 * 
	 * 
	 */
	public static void main(String[] args) {

		int ar[] = { 2, 3, 5, 6, 8, 10 };
		int sum = 10;
		int n = ar.length;

		int dp[][] = new int[n + 1][sum + 1];

		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(countSubset(ar, sum, n));
		System.out.println(countSubsetDP(ar, sum, n, dp));

	}

	//dp solution
	static int countSubsetDP(int[] ar, int sum, int n, int[][] dp) {

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

				if (ar[n - 1] <= sum) {
					int add = dp[n - 1][sum - ar[n - 1]];
					int notAdd = dp[n - 1][sum];

					dp[n][sum] = add + notAdd;

				} else {
					dp[n][sum] = dp[n - 1][sum];
				}
			}
		}
		return dp[N][SUM];

	}

	static int countSubset(int[] ar, int sum, int n) {

		if (sum == 0) {
			return 1;
		}
		if (n == 0 && sum != 0) {
			return 0;
		}

		if (ar[n - 1] <= sum) {
			int add = countSubset(ar, sum - ar[n - 1], n - 1);
			int notAdd = countSubset(ar, sum, n - 1);

			return add + notAdd;

		} else {
			return countSubset(ar, sum, n - 1);
		}

	}

}
