package com.tushar.DP;

import java.util.Arrays;

public class CountTheNumberOfSubset {

	/*
	 * you have given an array and a difference ,you have to count the no of
	 * subarray whose difference will be equal to given difference.
	 * 
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 1, 1, 2, 3 };
		int diff = 1;

		/*
		 * sumOf(subSet1)-sumOf(subSet2)=diff -----1 this is given
		 * sumOf(subSet1)+sumOf(subSet2)=sumOf(arr) -----2
		 * 
		 * adding these two equation.
		 * 
		 * sumOf(subSet1)=(diff+sumOf(arr))/2; for this question.
		 * 
		 * sumOf(subSet1)=(1+7)/2 sumOf(subSet1)=4.
		 * 
		 * so just count the no of subset in array whose sum is 4.
		 * 
		 * 
		 */

		int sum = 0;
		for (int x : ar) {
			sum += x;
		}

		int val = (diff + sum) / 2;
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
					int add = dp[n-1][val-ar[n-1]];
					int notAdd = dp[n-1][val];
					 dp[n][val] = add + notAdd;
				} else {
					 dp[n][val] = dp[n-1][val];
				}
			}
		}
		
		return dp[N][VAL];

	}

}
