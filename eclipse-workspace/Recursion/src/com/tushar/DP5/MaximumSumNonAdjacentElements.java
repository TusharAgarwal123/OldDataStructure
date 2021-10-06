package com.tushar.DP5;

public class MaximumSumNonAdjacentElements {

	public static void main(String[] args) {

		/*
		 * you have given a string ,you have to find the sum of subsequence,in which on
		 * adjacent element are there,you have to find the subsequence whose sum is
		 * maximum,you have to print sum.
		 */

		int ar[] = { 5, 10, 10, 100, 5, 6 };

		int inc = ar[0];
		int exc = 0;

		for (int i = 1; i < ar.length; i++) {

			int ninc = exc + ar[i];
			int nexc = Math.max(inc, exc);

			inc = ninc;
			exc = nexc;

		}

		System.out.println(Math.max(inc, exc));

	}

}
