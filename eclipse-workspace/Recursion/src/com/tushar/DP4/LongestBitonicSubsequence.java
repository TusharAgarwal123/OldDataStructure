package com.tushar.DP4;

public class LongestBitonicSubsequence {

	/*
	 * first we fill find the longest increasing subsequence from left to right then
	 * we will find the longest decresing subsequence from right to left.
	 */

	public static void main(String[] args) {

		int ar[] = { 10, 20, 9, 33, 40, 60, 50, 80,3 };

		int lis[] = new int[ar.length]; // longest increasing subsequence
		int lds[] = new int[ar.length]; // longest decreasing subsequence

		findLIS(ar, lis);
		findLDS(ar, lds);

		int omax = 0;

		for (int i = 0; i < ar.length; i++) {
			if (lis[i] + lds[i] - 1 > omax) {
				omax = lis[i] + lds[i] - 1;
			}
		}

		System.out.println(omax);

	}

	public static void findLDS(int[] ar, int[] lds) {

		for (int i = lds.length - 1; i >= 0; i--) {
			int max = 0;
			for (int j = lds.length - 1; j > i; j--) {

				if (ar[j] < ar[i]) {
					if (lds[j] > max) {
						max = lds[j];
					}
				}

			}
			lds[i] = max + 1;
		}

	}

	public static void findLIS(int[] ar, int[] lis) {

		for (int i = 0; i < lis.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {

				if (ar[j] < ar[i]) {
					if (lis[j] > max) {
						max = lis[j];
					}
				}

			}
			lis[i] = max + 1;
		}

	}

}
