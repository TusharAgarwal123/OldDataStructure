package com.tushar.BitManipulation;

public class XOROfSumOfAllPairs {

	public static void main(String[] args) {

		/*
		 * given array of integer you have to find the xor of sum of all pairs in array.
		 * 
		 * eg find for [a,b,c,d] once you write all pair and do xor,so only 2a^2b^2c^2d
		 * xor will be remain.
		 * 
		 * for this question just do double of all elements and find xor. or find the
		 * xor of all element then multiply by 2.
		 */

		int ar[] = { 1, 2, 3, 4 };
		int xor = 0;
		for (int val : ar) {
			xor = xor ^ (2 * val);
		}

		System.out.println(xor);

	}

}
