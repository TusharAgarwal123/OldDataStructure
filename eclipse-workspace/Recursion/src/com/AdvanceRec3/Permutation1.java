package com.AdvanceRec3;

public class Permutation1 {

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

		permutation(new int[n], 1, k);

	}

	public static void permutation(int[] ar, int i, int k) {

		if (i > k) {

			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[j] + " ");

			}

			System.out.println();
			return;
		}

		for (int j = 0; j < ar.length; j++) {
			if (ar[j] == 0) {
				ar[j] = i;
				permutation(ar, i + 1, k);
				ar[j] = 0;
			}
		}

	}

}
