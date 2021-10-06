package com.tushar.BitManipulation;

public class triplets1 {

	/*
	 * 1. You are given an array(arr) of N numbers. 2. You have to select three
	 * indices i,j,k following this condition -> 0 <= i < j <= k < arr.length 3. Two
	 * numbers X and Y as defined as : X = arr[i] ^ arr[i+1] ^ ... ^ arr[j - 1] Y =
	 * arr[j] ^ arr[j+1] ^ ... ^ arr[k] 4. You have to print the number of triplets
	 * where X is equal to Y.
	 */

	public static void main(String[] args) {

		int ar[] = { 1, 3, 2, 5, 7, 2, 7, 5, 6, 4 };
		int c = 0;

		for (int i = 0; i < ar.length; i++) {

			int val = ar[i];

			for (int k = i + 1; k < ar.length; k++) {

				val = val ^ ar[k];

				if (val == 0) {
					c += (k - i);
				}

			}

		}

		System.out.println(c);

	}

}
