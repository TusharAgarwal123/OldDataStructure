package com.tushar.BitManipulation;

public class FindDuplicateNumberAndMissingNumber {

	/*
	 * you are given an array of length n containing number from 1 to n, one number
	 * is present twice in array and one is missing you have to find these two no.
	 */

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3, 2, 5, 6 };

		int xor = 0;
		for (int val : ar) {
			xor = xor ^ val;
		}
		for (int i = 1; i <= ar.length; i++) {
			xor = xor ^ i;
		}

		int rmsbm = xor & -xor;

		int x = 0;
		int y = 0;

		for (int val : ar) {

			if ((val & rmsbm) == 0) {
				x = x ^ val;
			} else {
				y = y ^ val;
			}

		}

		for (int i = 1; i <= ar.length; i++) {
			if ((i & rmsbm) == 0) {
				x = x ^ i;
			} else {
				y = y ^ i;
			}
		}

		// now check which is missing no.

		for (int val : ar) {

			if (val == x) {

				System.out.println("Missing No is: " + y);
				System.out.println("Duplicate No is: " + x);
				break;

			} else if (val == y) {
				System.out.println("Missing No is: " + x);
				System.out.println("Duplicate No is: " + y);
				break;
			}

		}

	}

}
