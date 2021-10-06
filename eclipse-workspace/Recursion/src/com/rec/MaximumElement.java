package com.rec;

public class MaximumElement {

	public static void main(String[] args) {

		int ar[] = { 3, 7, 5, 9, 1, 4 };
		System.out.println(maximum(ar, 0));
		System.out.println(minimum(ar, 0));

	}

	static int maximum(int[] ar, int i) {

		if (i == ar.length - 1) {
			return ar[i];
		}

		int subpro = maximum(ar, i + 1);
		return Math.max(subpro, ar[i]);

	}

	static int minimum(int[] ar, int i) {

		if (i == ar.length - 1) {
			return ar[i];
		}

		int subpro = minimum(ar, i + 1);
		return Math.min(subpro, ar[i]);

	}

}
