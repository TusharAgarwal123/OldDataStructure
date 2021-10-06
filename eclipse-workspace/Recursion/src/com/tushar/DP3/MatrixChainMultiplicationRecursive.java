package com.tushar.DP3;

public class MatrixChainMultiplicationRecursive {

	public static void main(String[] args) {

		int ar[] = { 10, 50, 50, 60, 60, 30 };
		int i = 1;
		int j = ar.length-1;
		System.out.println(solve(ar, i, j));

	}

	static int solve(int[] ar, int i, int j) {

		if (i >= j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solve(ar, i, k) + solve(ar, k + 1, j) + ar[i - 1] + ar[k] + ar[j];
			if (temp < min) {
				min = temp;
			}
		}

		return min;

	}

}
