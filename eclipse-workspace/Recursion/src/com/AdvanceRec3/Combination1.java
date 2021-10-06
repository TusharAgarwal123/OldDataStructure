package com.AdvanceRec3;

public class Combination1 {

	/*
	 * 1. You are give a number of boxes (nboxes) and number of identical items
	 * (ritems). 2. You are required to place the items in those boxes and print all
	 * such configurations possible.
	 * 
	 * Items are identical and all of them are named 'i'. Note 1 -> Number of boxes
	 * is greater than number of items, hence some of the boxes may remain empty.
	 */

	public static void main(String[] args) {

		int n = 5; // boxes
		int k = 3; // item

		combination(1, n, 0, k, "");

	}

	public static void combination(int i, int n, int j, int k, String ans) {

		if (i > n) {
			if (j == k) {
				System.out.println(ans);
			}
			return;
		}

		combination(i + 1, n, j + 1, k, ans + "i" + " "); // putting element
		combination(i + 1, n, j, k, ans + "-");

	}

}
