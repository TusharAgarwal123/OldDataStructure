package com.tushar.DP5;

public class PathWithMaximumGold {

	/*
	 * you have a grid in which you can travel from left to right.you have to reach
	 * at last column.at any cell you have 3 choice to go in right,you have to find
	 * the path whose sum will be maximum just find sum.
	 */

	public static void main(String[] args) {

		int ar[][] = { { 0, 1, 4, 2, 8, 2 }, { 4, 3, 6, 5, 0, 4 }, { 1, 2, 4, 1, 4, 6 }, { 2, 0, 7, 3, 2, 2 },
				{ 3, 1, 5, 9, 2, 4 }, { 2, 7, 0, 8, 5, 1 } };

		int dp[][] = new int[ar.length][ar[0].length];

		for (int j = dp[0].length - 1; j >= 0; j--) { // column
			for (int i = dp.length - 1; i >= 0; i--) { // row
				if (j == dp.length - 1) {
					dp[i][j] = ar[i][j];
				} else if (i == 0) {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + ar[i][j];
				} else if (i == dp.length - 1) {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + ar[i][j];
				} else {
					dp[i][j] = Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1])) + ar[i][j];
				}
			}
		}

		int max = dp[0][0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i][0] > max) {
				max = dp[i][0];
			}
		}

		System.out.println("Max Sum is: " + max);

	}

}
