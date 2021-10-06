package com.tushar.DP;

public class MinimumSubsetSumProblem {

	/*
	 * in this qstn you have given an array ,you have to partition the array into
	 * two subarray such that their sum of difference will be minimum.
	 * 
	 * 
	 */
	public static void main(String[] args) {

		int ar[] = {1,2,7};
		int sum = 0;
		int n = ar.length;
		
		
		
		for (int x : ar) {
			sum += x;

		}
		
		
		
		int min = Integer.MAX_VALUE;
		int diff = 0;
		for (int i = 0; i <= sum/2; i++) {

			boolean dp[][] = new boolean[n + 1][i+ 1];
			
			if (isPresentDP(ar, i, n,dp)) {

			//	diff = Math.abs(i - (sum - i));   if you use this then use i<=sum.
				diff=(sum-i)-i;

				min = Math.min(min, diff);

			}

		}

		System.out.println(min);

	}

	public static boolean isPresent(int ar[], int sum, int n) {

		if (sum == 0) {
			return true;
		}

		
		if (n == 0 && sum != 0) {
			return false;
		}

		if (ar[n - 1] <= sum) {

			return isPresent(ar, sum - ar[n - 1], n - 1) || isPresent(ar, sum, n - 1);

		} else {
			return isPresent(ar, sum, n - 1);
		}

	}
	
	static boolean isPresentDP(int[] ar, int sum, int n, boolean dp[][]) {

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
