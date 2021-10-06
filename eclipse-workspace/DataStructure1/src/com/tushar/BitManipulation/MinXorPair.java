package com.tushar.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class MinXorPair {

	/*
	 * you are given array of distinct no you have to print all pairs of integer in
	 * the array whose xor is minimum.
	 */

	public static void main(String[] args) {

		int ar[] = { 2, 7, 5, 3, 9, 1, 4 };

		// we know that if a<=b<=c, then a^b is less than a^c and b^c is also less than
		// a^c.

		Arrays.sort(ar);
		int min = Integer.MAX_VALUE;
		ArrayList<String> ans = new ArrayList<>();

		for (int i = 0; i < ar.length - 1; i++) {
			int xor = ar[i] ^ ar[i + 1];
			if (xor < min) {
				min = xor;
				ans = new ArrayList<String>();
				ans.add(ar[i] + "," + ar[i + 1]);
			} else if (xor == min) {
				ans.add(ar[i] + "," + ar[i + 1]);
			}
		}

		System.out.println(ans);

	}

}
