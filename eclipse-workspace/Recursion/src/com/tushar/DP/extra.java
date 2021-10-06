package com.tushar.DP;

import java.util.Arrays;

public class extra {

	public static void main(String[] args) {
		int ar[] = { 1, 1, 2, 3 };
		int diff = 1;

		int sum = 0;
		for (int x : ar) {
			sum += x;
		}
		int n = ar.length;

		int val = (diff + sum) / 2;

		int dp[][] = new int[n + 1][val + 1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}

		System.out.println(find(ar, val, n,dp));

	}

	private static int find(int[] ar, int val, int n, int dp[][]) {

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
