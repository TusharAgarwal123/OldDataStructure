package com.tushar.BitManipulation;

public class FlipBitsToConvertAToB {

	/*
	 * You are given two number A and B. you have to print the count of bits needed
	 * to be flipped to convert a to b.
	 */

	public static void main(String[] args) {

		int a = 3;
		int b = 8;

		int xor = a ^ b;
		// now count set bits in that xor.

		int c = 0;
		while (xor != 0) {
			int rmsbm = xor & -xor;
			xor = xor - rmsbm;
			c++;
		}

		System.out.println(c);

	}

}
