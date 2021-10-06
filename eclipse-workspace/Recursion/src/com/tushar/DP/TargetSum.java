package com.tushar.DP;

import java.util.Arrays;

public class TargetSum {

	/*
	 * in this question we have given an array and a sum ,we have to add +/- in each
	 * element so that sum of array will be equal to given sum. we have to return
	 * the no ways differently we can modify.
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {

		int ar[] = { 1, 1, 2, 3 };
		int sum = 1;

		// same as countTheNumberOfSubsets.

		int sum1 = 0;
		for (int x : ar) {
			sum1 += x;
		}

		int val = (sum + sum1) / 2;
		int n = ar.length;

		int dp[][] = new int[n + 1][val + 1];

		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(countSubSet(ar, val, n));
		System.out.println(countSubSetDP(ar, val, n, dp));

	}

	static int countSubSet(int[] ar, int val, int n) {

		if (val == 0) {
			return 1;
		}

		if (n == 0 && val != 0) {
			return 0;
		}

		if (ar[n - 1] <= val) {
			int add = countSubSet(ar, val - ar[n - 1], n - 1);
			int notAdd = countSubSet(ar, val, n - 1);
			return add + notAdd;
		} else {
			return countSubSet(ar, val, n - 1);
		}

	}

	static int countSubSetDP(int[] ar, int val, int n, int dp[][]) {

		int N = n;
		int VAL = val;

		for (n = 0; n < N + 1; n++) {
			for (val = 0; val < VAL + 1; val++) {
				if (val == 0) {
					dp[n][val] = 1;
					continue;
				}

				if (n == 0 && val != 0) {
					dp[n][val] = 0;
					continue;
				}

				if (ar[n - 1] <= val) {
					int add = dp[n - 1][val - ar[n - 1]];
					int notAdd = dp[n - 1][val];
					dp[n][val] = add + notAdd;
				} else {
					dp[n][val] = dp[n - 1][val];
				}
			}
		}

		return dp[N][VAL];

	}

}
