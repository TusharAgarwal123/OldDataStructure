package com.tushar.BitManipulation;

public class Basic {

	public static void main(String[] args) {

		int n = 6;
		int i = 2;

		// to on the bit we use or operator.

		int onmask = (1 << i);

		System.out.println(n | onmask);

		// to off the bit we use and operator.

		int offmask = ~(1 << i);
		System.out.println(n & offmask);

		// to toggle the bit we use xor operator.

		int tmask = (1 << i);
		System.out.println(n ^ tmask);

		// to check if the any bit is on or not.
		int cmask = (1 << i);
		System.out.println((n & cmask) == 0 ? false : true);

	}

}
