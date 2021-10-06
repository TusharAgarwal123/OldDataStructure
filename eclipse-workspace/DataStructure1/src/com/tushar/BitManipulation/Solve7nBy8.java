package com.tushar.BitManipulation;

public class Solve7nBy8 {

	/*
	 * you have a number n, you have to calculate the value of 7n/8 without using
	 * division and multiplication.
	 */

	// when we do n<<5, it's mean we are multiplying no with 2^5.
	// when we do n>>5, it's mean we are dividing no with 2^5.

	public static void main(String[] args) {

		int n = 8;

		// (7n/8)==(8n-n)/8.
		
		//(8n-n)==(n<<3)-n

		int ans = ((n << 3) - n) >> 3;

		System.out.println(ans);

	}

}
