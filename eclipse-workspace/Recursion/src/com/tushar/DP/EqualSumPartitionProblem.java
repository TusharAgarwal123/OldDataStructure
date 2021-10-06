package com.tushar.DP;

public class EqualSumPartitionProblem {

	/*
	 * in this problem you have given an array , you have to check wheather we can
	 * partition the array into two subset array with equal sum or not. if we can
	 * then return true otherwise return false.
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 1, 5,11, 5 };

		int sum = 0;
		for (int x : ar) {
			sum += x;
		}

		if ((sum & 1) == 1) {
			System.out.println("False");
		} else {
			sum = sum / 2;
			int n=ar.length;
			
			boolean dp[][]=new boolean[n+1][sum+1];
			
			System.out.println(findSubset(ar, ar.length, sum));
			System.out.println(findSubSetDP(ar, sum, n, dp));

		}

	}

	static boolean findSubset(int[] ar, int n, int sum) {

		if (sum == 0) {
			return true;
		}
		if (n == 0 && sum != 0) {
			return false;
		}
		if (ar[n - 1] <= sum) {
			return findSubset(ar, n - 1, sum - ar[n - 1]) || findSubset(ar, n - 1, sum);
		} else {
			return findSubset(ar, n - 1, sum);
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
