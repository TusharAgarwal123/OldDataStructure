package com.tushar.DP4;

public class MinimumCostPath {

	/*
	 * you have a 2D matrix you have to travel from top left to bottom right and you
	 * can go either in the vertical or horizontal direction.and you have to find
	 * the minimum cost to reach till bottom right.
	 */

	public static void main(String[] args) {

		// int ar[][]= {{1,2,3},{5,4,1},{8,6,2}};
		int ar[][] = { { 2, 8, 4, 1, 6, 4, 2 }, { 6, 0, 9, 5, 3, 8, 5 }, { 1, 4, 3, 4, 0, 6, 5 },
				{ 6, 4, 7, 2, 4, 6, 1 }, { 1, 0, 3, 7, 1, 2, 7 }, { 1, 5, 3, 2, 3, 0, 9 }, { 2, 2, 5, 1, 9, 8, 2 } };
		int dp[][] = new int[ar.length][ar.length];

		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (i == dp.length - 1 && j == dp[0].length - 1) {
					dp[i][j] = ar[i][j];
				} else if (i == dp.length - 1) { // last row
					dp[i][j] = dp[i][j + 1] + ar[i][j];
				} else if (j == dp[0].length - 1) { // last col
					dp[i][j] = dp[i + 1][j] + ar[i][j];
				} else {
					dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + ar[i][j];
				}
			}
		}

		System.out.println(dp[0][0]);

	}

}
