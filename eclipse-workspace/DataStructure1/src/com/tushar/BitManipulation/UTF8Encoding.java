package com.tushar.BitManipulation;

public class UTF8Encoding {

	/*
	 * 1. You are given an array of integers. 2. You are required to test whether
	 * the array represents a valid sequence of UTF-8 characters or not. 3. A
	 * character in UTF-8 can be from 1 to 4 bytes long and follows some rules - (i)
	 * For 1-byte long character, first bit will be 0 and rest represents its
	 * unicode code. (ii) For n-bytes long character, first n-bits will be 1's, the
	 * n+1th bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
	 * 
	 * Note -> Only the least significant 8 bits of each element in array is used
	 * for data. 
	 */

	public static void main(String[] args) {

		int ar[] = { 7, 5, 4 };

		System.out.println(solution(ar));

	}

	public static boolean solution(int[] ar) {

		int rBytes = 0;

		for (int val : ar) {
			if (rBytes == 0) {
				if ((val >> 7) == 0b0) { // 1st byte of 1 length char.
					rBytes = 0;
				} else if ((val >> 5) == 0b110) { // 1st byte of 2 length char.
					rBytes = 1;
				} else if ((val >> 4) == 0b1110) { // 1st byte of 3 length char.
					rBytes = 2;
				} else if ((val >> 3) == 0b11110) { // 1st byte of 4 length char.
					rBytes = 3;
				}
			} else {
				if ((val >> 6) == 0b10) {
					rBytes--;
				} else {
					return false;
				}
			}
		}

		return rBytes == 0 ? true : false;

	}

}
