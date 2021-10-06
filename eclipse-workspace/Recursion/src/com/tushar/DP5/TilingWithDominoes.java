package com.tushar.DP5;

public class TilingWithDominoes {

	public static void main(String[] args) {

		/*
		 * you are given n number representing the length of floor space which is 2m
		 * wide it's a 2^n board. you have an infinite supply of 2^1 tiles.
		 * 
		 * you are required to calculate and print the number of ways floor can be
		 * filled using tiles.
		 * 
		 */

		int n = 4;
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[n]);

	}

}
