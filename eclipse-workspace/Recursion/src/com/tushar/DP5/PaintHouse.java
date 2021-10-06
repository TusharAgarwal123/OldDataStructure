package com.tushar.DP5;

import java.util.Scanner;

public class PaintHouse {

	public static void main(String[] args) {

		/*
		 * you are given number n,representing the no of house. in the next n rows, you
		 * are given 3 space seperated numbers representing the cost of painting nth
		 * house with red,blue and green. you are required to calculate and print the
		 * minimum cost of painting all houses without painting any consecutive house
		 * with same color.
		 */

		int n = 4;
		System.out.println("---");
		Scanner sc = new Scanner(System.in);
		int ar[][] = new int[n][3];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		// System.out.println(find(ar));
		System.out.println(find2(ar, n));

	}

	public static int find(int ar[][]) {

		int r = ar[0][0];
		int b = ar[0][1];
		int g = ar[0][2];

		for (int i = 1; i < ar.length; i++) {

			int nr = ar[i][0] + Math.min(b, g);
			int nb = ar[i][1] + Math.min(r, g);
			int ng = ar[i][2] + Math.min(r, b);

			r = nr;
			b = nb;
			g = ng;

		}

		int ans = Math.min(r, Math.min(b, g));
		return ans;

	}

	public static int find2(int ar[][], int n) {

		int dp[][] = new int[n][3];
		dp[0][0] = ar[0][0];
		dp[0][1] = ar[0][1];
		dp[0][2] = ar[0][2];

		for (int i = 1; i < dp.length; i++) {

			dp[i][0] = ar[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = ar[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = ar[i][2] + Math.min(dp[i - 1][0], dp[i - 1][2]);
		}

		return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

	}

}
