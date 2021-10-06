package com.tushar.BitManipulation;

public class AllRepeatingExceptTwo {

	/*
	 * you have an array of integer ,you have to find two number who are
	 * non-repeating in that array. like [1,2,3,2,1,6] for above answer is 3 and 6
	 */

	public static void main(String[] args) {

		int ar[] = { 5, 7, 6, 3, 7, 5 };
		solution(ar);

	}

	public static void solution(int[] ar) {

		int xxory = 0;
		for (int val : ar) {
			xxory = xxory ^ val;
		}

		int rmsbm = xxory & -xxory; // right most set bit mask

		int x = 0;
		int y = 0;

		for (int val : ar) {
			if ((val & rmsbm) == 0) {
				x = x ^ val;
			} else {
				y = y ^ val;
			}
		}

		if (x < y) {
			System.out.println(x);
			System.out.println(y);
		} else {
			System.out.println(y);
			System.out.println(x);
		}

	}

}
