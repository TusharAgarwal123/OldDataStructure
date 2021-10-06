package com.tushar.DP4;

import java.util.Arrays;

public class LongestIncreasingSubsequence2 {

	public static void main(String[] args) {

		int ar[] = { 10, 20, 9, 33, 40, 60, 50, 80 };

		int dp[] = new int[ar.length];

		System.out.println(find(ar, dp));
		

	}

	
	//O(n^2)
	public static int find(int ar[], int dp[]) {

		int overAllMax = 0;
		for (int i = 0; i < dp.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (ar[j] < ar[i]) {
					if (dp[j] > max) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			overAllMax = Math.max(overAllMax, dp[i]);
		}
		return overAllMax;

//		int max = 0;
//		for (int i = 1; i < ar.length; i++) {
//			for (int j = 0; j < i; j++) {
//				if (ar[j] < ar[i] && dp[j] + 1 > dp[i]) {
//					dp[i] = dp[j] + 1;
//					max = Math.max(max, dp[i]);
//				}
//			}
//		}
//
//		System.out.println(max);

	}

}
