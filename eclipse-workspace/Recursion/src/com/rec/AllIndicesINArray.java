package com.rec;

public class AllIndicesINArray {

	public static void main(String[] args) {

		/*
		 * we have an array and an element we have to find all index of element in
		 * array.
		 */

		int ar[] = { 2, 5, 7, 3, 5, 3, 1, 5, 3, 9, 5 };
		int k = 5;

		int ans[] = allIndices(ar, k, 0, 0);
		for (int x : ans) {
			System.out.print(x + " ");
		}

	}

	// fsf =found so far

	private static int[] allIndices(int[] ar, int k, int i, int fsf) {

		if (i == ar.length) {
			int ans[] = new int[fsf];
			return ans;
		}

		if (ar[i] == k) {
			int[] iarr = allIndices(ar, k, i + 1, fsf + 1);

			iarr[fsf] = i;
			return iarr;

		} else {
			int[] iarr = allIndices(ar, k, i + 1, fsf);

			return iarr;
		}

	}

}
