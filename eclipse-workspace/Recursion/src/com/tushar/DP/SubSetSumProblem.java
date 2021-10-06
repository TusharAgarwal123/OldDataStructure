package com.tushar.DP;

public class SubSetSumProblem {

	/*
	 * in this problem you have given an array and a sum you have check wheather a
	 * subset with given sum is present or not,if present then return true otherwise
	 * return false.
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 3, 7, 8, 4 };
		int sum = 11;
		int n = ar.length;

		boolean dp[][] = new boolean[n + 1][sum + 1];

		System.out.println(findSubSet(ar, sum, n));
		System.out.println(findSubSetMemorization(ar, sum, n, dp));
		System.out.println(findSubSetDP(ar, sum, n, dp));

	}

	static boolean findSubSet(int[] ar, int sum, int n) {

		if (sum == 0) {
			return true;
		}

		if (n == 0 && sum != 0) {
			return false;
		}

		if (ar[n - 1] <= sum) {
			return findSubSet(ar, sum - ar[n - 1], n - 1) || findSubSet(ar, sum, n - 1);
		}

		else {
			return findSubSet(ar, sum, n - 1);
		}

	}

	static boolean findSubSetMemorization(int[] ar, int sum, int n, boolean dp[][]) {

		if (sum == 0) {
			return dp[n][sum] = true;
		}

		if (n == 0 && sum != 0) {
			return dp[n][sum] = false;
		}

		if (dp[n][sum] != false) {
			return dp[n][sum];
		}

		if (ar[n - 1] <= sum) {
			return dp[n][sum] = findSubSetMemorization(ar, sum - ar[n - 1], n - 1, dp)
					|| findSubSetMemorization(ar, sum, n - 1, dp);
		}

		else {
			return dp[n][sum] = findSubSetMemorization(ar, sum, n - 1, dp);
		}

	}

	//best solution.
	static boolean findSubSetDP(int[] ar, int sum, int n, boolean dp[][]) {

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
					dp[n][sum] = dp[n-1][sum];
				}

			}
		}
		
		return dp[N][SUM];

	}

}
