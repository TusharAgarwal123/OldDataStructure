package com.tushar.BitManipulation;

public class ReverseBit {

	/*
	 * you are given the no. you have to print the binary representation you also
	 * have to reverse the bit of n and print the no obtained by reversing the bit.
	 */

	public static void main(String[] args) {

		int n = 11;
		boolean flag = false;

		int rev = 0;
		int j = 0;

		for (int i = 31; i >= 0; i--) {

			int mask = (1 << i);

			if (flag) { // means we have encounter first 1.

				if ((n & mask) != 0) {
					int mm = (1 << j);
					rev = rev | mm;
					System.out.print(1);
				} else {
					System.out.print(0);
				}
				j++;

			} else {
				if ((n & mask) != 0) {
					flag = true;
					System.out.print(1);
					int mm = (1 << j);
					rev = rev | mm;
					j++;

				}
			}

		}
		System.out.println();

		System.out.println(rev);
		System.out.println(Integer.toBinaryString(rev));

	}

}
