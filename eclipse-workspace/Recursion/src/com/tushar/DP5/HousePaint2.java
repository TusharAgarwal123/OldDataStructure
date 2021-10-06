package com.tushar.DP5;

import java.util.Scanner;

public class HousePaint2 {

	public static void main(String[] args) {

		/*
		 * you are given number n and a number k representing the no of house and number
		 * of colors. in the next n rows, you are given k space seperated numbers
		 * representing the cost of painting nth house with one of the k. you are
		 * required to calculate and print the minimum cost of painting all houses
		 * without painting any consecutive house with same color.
		 * 
		 * question is same as painthouse but this time we have many no of colors.
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("--");
		int n = sc.nextInt();
		int k = sc.nextInt();

		int ar[][] = new int[n][k];

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		System.out.println(find2(ar));

	}

	public static int find(int ar[][]) {

		int n = ar.length;

		int dp[][] = new int[ar.length][ar[0].length];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = ar[0][i];
		}

		for (int i = 1; i < dp.length; i++) {

			for (int j = 0; j < dp[0].length; j++) {

				int min = Integer.MAX_VALUE;
				for (int l = 0; l < dp[0].length; l++) {
					if (j != l) {
						if (dp[i - 1][l] < min) {
							min = dp[i - 1][l];
						}
					}
				}

				dp[i][j] = ar[i][j] + min;

			}

		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < dp[0].length; i++) {
			if (dp[n - 1][i] < min) {
				min = dp[n - 1][i];
			}
		}

		return min;

	}

	// this is better solution.
	public static int find2(int ar[][]) {

		int n = ar.length;

		int dp[][] = new int[ar.length][ar[0].length];
		int least = Integer.MAX_VALUE;
		int secondLeast = Integer.MAX_VALUE;

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = ar[0][i];
			if (ar[0][i] <= least) {
				secondLeast = least;
				least = ar[0][i];
			} else if (ar[0][i] <= secondLeast) {
				secondLeast = ar[0][i];
			}

		}

		for (int i = 1; i < dp.length; i++) {

			int nleast = Integer.MAX_VALUE;
			int nsecondLeast = Integer.MAX_VALUE;

			for (int j = 0; j < dp[0].length; j++) {

				if (least == dp[i - 1][j]) {
					dp[i][j] = secondLeast + ar[i][j];
				} else {
					dp[i][j] = least + ar[i][j];
				}

				if (dp[i][j] <= nleast) {
					nsecondLeast = nleast;
					nleast = dp[i][j];
				} else if (dp[i][j] <= nsecondLeast) {
					nsecondLeast = dp[i][j];
				}

			}

			least = nleast;
			secondLeast = nsecondLeast;

		}

		return least;

	}

}
