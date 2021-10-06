package com.tushar.BitManipulation;

public class SumOfBitDifferenceAmongAllPair {

	/*
	 * you are given an array of n number. you have to find the sum of bit
	 * difference in all pairs that can be formed from n number
	 * 
	 * bit difference of two no is defined as the count of different bit at same
	 * position in binary representation of two no.
	 */

	public static void main(String[] args) {

		int ar[] = { 2, 4, 6, 8 };
		System.out.println(solution(ar));

	}

	public static long solution(int[] ar) {

		long res = 0;
		for (int i = 0; i < 32; i++) { // traverse all 32 bits

			long cOn = 0;
			for (int val : ar) {
				if ((val & (1 << i)) != 0) {
					cOn++;
				}
			}

			long cOff = ar.length - cOn;
			long diff = cOn * cOff * 2;
			res += diff;

		}
		return res;

	}

}
