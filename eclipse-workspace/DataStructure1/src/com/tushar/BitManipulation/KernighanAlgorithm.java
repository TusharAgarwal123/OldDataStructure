package com.tushar.BitManipulation;

public class KernighanAlgorithm {

	/*
	 * this algorithm is use to find the no of set bits.
	 */

	public static void main(String[] args) {

		int n = 15;

		int c = 0;
		while (n != 0) {
			int rmsb = n & -n;
			n = n - rmsb;
			c++;
		}
		System.out.println(c);

	}

	// this is not efficient.
	public static int find(int n) {
		int c = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				c++;
			}
			n = n >> 1;
		}
		return c;
	}

}
