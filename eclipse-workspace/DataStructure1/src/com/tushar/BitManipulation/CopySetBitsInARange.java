package com.tushar.BitManipulation;

public class CopySetBitsInARange {

	/*
	 * you have two no A and B and a left and right position ,you have to consider
	 * the all bits in number A from left to right, if you find 1 in this range you
	 * have to make 1 also in B at the same position.
	 */

	public static void main(String[] args) {

		int a = 13;
		int b = 17;

		int left = 2;
		int right = 4;

		int m1 = (1 << (right - left + 1));
		m1 = m1 - 1;
		m1 = (m1 << (left - 1));

		int m2 = a & m1;

		int ans = m2 | b;
		System.out.println(ans);
		System.out.println(Integer.toBinaryString(13));
		System.out.println(Integer.toBinaryString(17));
		System.out.println(Integer.toBinaryString(ans));

	}

}
