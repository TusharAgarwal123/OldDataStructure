package com.tushar.BitManipulation;

public class IsAPowerOf2 {

	public static void main(String[] args) {

		/*
		 * you have a number, you have to check whether it's a power of 2 or not.
		 */

		int a = 9;

		// if we do AND of number with (number-1) and we get 0 then it is power of 2.

		int ans = a & (a - 1);
		if (ans == 0) {
			System.out.println("It is power of 2");
		} else {
			System.out.println("It is not power of 2");
		}

	}

	public static boolean find(int n) {

		if (n == 0) {
			return false;
		}

		while (n != 1) {

			if (n % 2 != 0) {
				return false;
			}

			n = n / 2;

		}

		return true;

	}

}
