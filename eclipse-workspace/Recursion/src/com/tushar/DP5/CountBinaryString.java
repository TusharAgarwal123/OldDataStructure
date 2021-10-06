package com.tushar.DP5;

public class CountBinaryString {

	public static void main(String[] args) {

		/*
		 * we have an n that denotes the length of binary string,we have to count the
		 * total no of the string with no consequtive zero's.
		 */

		int n = 6;

		int dp0[] = new int[n + 1]; // dp for zero.
		int dp1[] = new int[n + 1]; // dp for one.

		System.out.println(find(dp0, dp1, n));
		System.out.println(find2(n));

	}

	private static int find2(int n) {

		int ocones = 1; // for 1 length
		int oczeros = 1;

		for (int i = 2; i <= n; i++) {
			int ncones = ocones + oczeros;
			int nczeros = ocones;

			ocones = ncones;
			oczeros = nczeros;
		}

		return ocones + oczeros;

	}

	public static int find(int dp0[], int dp1[], int n) {

		dp0[1] = 1; // for 1 length no of 0 that end with 0.
		dp1[1] = 1; // for 1 length no of one that end with 1.

		for (int i = 2; i <= n; i++) {
			dp1[i] = dp1[i - 1] + dp0[i - 1];
			dp0[i] = dp1[i - 1];
		}

		return dp1[n] + dp0[n];

	}

}
