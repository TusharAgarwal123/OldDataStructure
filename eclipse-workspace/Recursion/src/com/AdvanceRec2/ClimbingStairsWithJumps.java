package com.AdvanceRec2;

public class ClimbingStairsWithJumps {

	public static void main(String[] args) {

		/*
		 * you have an array whose size denotes the no of stairs,you have to go to nth
		 * stairs from 0th stairs.the value at each index of array denotes the jumps,you
		 * have to count the no ways.
		 * 
		 */

		int ar[] = { 3, 3, 0, 2, 2, 3, 9 };
		int n = ar.length;

		System.out.println(find(ar, 0));
		System.out.println(find_Memo(ar, 0, new int[ar.length + 1]));
		System.out.println(find_DP(ar));

	}

	public static int find(int[] ar, int i) {

		if (i == ar.length) {
			return 1;
		}
		if (i > ar.length) {
			return 0;
		}

		int c = 0;
		for (int j = 1; j <= ar[i]; j++) {
			c += find(ar, i + j);
		}
		return c;

	}

	public static int find_Memo(int[] ar, int i, int dp[]) {

		if (i == ar.length) {
			return dp[i] = 1;
		} else if (i > ar.length) {
			return 0;
		}

		if (dp[i] != 0) {
			return dp[i];
		}

		int c = 0;
		for (int j = 1; j <= ar[i]; j++) {
			c += find(ar, i + j);
		}
		return dp[i] = c;

	}

	public static int find_DP(int[] ar) {

		int dp[] = new int[ar.length + 1];

		for (int j = ar.length; j >= 0; j--) {
			if (j == ar.length) {
				dp[j] = 1;
				continue;
			}
			int c = 0;
			for (int k = 1; k <= ar[j] && j + k < dp.length; k++) {
				c += dp[j + k];
			}
			dp[j] = c;

		}
		return dp[0];

	}

}
