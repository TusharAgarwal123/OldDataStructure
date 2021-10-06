package com.tushar.DP;

import java.util.ArrayList;

public class MinimumSubsetSumProblem2 {

	public static void main(String[] args) {

		int ar[] = { 1, 5, 6, 11 };

		int sum = 0;
		for (int x : ar) {
			sum += x;
		}

		int n = ar.length;

		boolean dp[][] = new boolean[n + 1][sum + 1];

		isPresentDP(ar, sum, n, dp);
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i <= sum / 2; i++) {

			if (dp[n][i]) {
				list.add(i);
			}

		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {

			min = Math.min(min, sum - 2 * list.get(i));

		}

		System.out.println(min);

	}

	// basically it will fill our matrix.
	static void isPresentDP(int[] ar, int sum, int n, boolean dp[][]) {

		int N = n;
		int SUM = sum;

		for (n = 0; n < N + 1; n++) {
			for (sum = 0; sum < SUM + 1; sum++) {

				if (sum == 0) {
					dp[n][sum] = true;
					continue;
				}

				if (n == 0 && sum != 0) {
					dp[n][sum] = false;
					continue;
				}

				if (ar[n - 1] <= sum) {
					dp[n][sum] = dp[n - 1][sum - ar[n - 1]] || dp[n - 1][sum];

				}

				else {
					dp[n][sum] = dp[n - 1][sum];
				}

			}
		}

	}

}
