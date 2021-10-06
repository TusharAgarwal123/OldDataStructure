package com.tushar.DP5;

public class TilingWithM1Tiles {

	public static void main(String[] args) {

		/*
		 * you are given n number and m number representing the length and breadth of a
		 * n*m floor . you have an infinite supply of m^1 tiles.
		 * 
		 * you are required to calculate and print the number of ways floor can be
		 * filled using tiles.
		 * 
		 */

		int m = 3;
		int n = 8;

		int dp[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i < m) {
				dp[i] = 1;
			} else if (i == m) {
				dp[i] = 2;
			} else {
				dp[i] = dp[i - 1] + dp[i - m];
			}
		}

		System.out.println(dp[n]);

	}

}
