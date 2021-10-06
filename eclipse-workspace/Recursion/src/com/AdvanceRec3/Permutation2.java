package com.AdvanceRec3;

public class Permutation2 {

	/*
	 * 1. You are give a number of boxes (nboxes) and number of non-identical items
	 * (ritems). 2. You are required to place the items in those boxes and print all
	 * such configurations possible.
	 * 
	 * Items are numbered from 1 to ritems. Note 1 -> Number of boxes is greater
	 * than number of items, hence some of the boxes may remain empty.
	 */

	public static void main(String[] args) {

		int n = 3; // boxes
		int k = 2; // items

		permutation(1, n, new int[k], 0, k, "");

	}

	public static void permutation(int i, int n, int[] item, int ssf, int k, String ans) {

		if (i > n) {
			if (ssf == k) {
				System.out.println(ans);
			}
			return;
		}

		for (int j = 0; j < k; j++) {

			if (item[j] == 0) {
				item[j] = 1;
				permutation(i + 1, n, item, ssf + 1, k, ans + (j + 1));
				item[j] = 0;
			}

		}

		permutation(i + 1, n, item, ssf, k, ans + 0); // putting nothing.

	}

}
