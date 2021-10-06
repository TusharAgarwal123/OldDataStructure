package com.tushar.BitManipulation;

import java.util.Scanner;

public class SameNumberOfSetBitsAsThatOfN {

	/*
	 * Given a positive integer N, find out how many positive integers strictly less
	 * than N have the same number of set bits as N.
	 */

	public static void main(String[] args) {

		System.out.println("++++++++");
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		int k = countSetBits(n);

		System.out.println(solution(n, k, 63));

		// 63 denotes the 64 bits of long from 0 to 63.

	}

	// kernighan algorithm.
	public static int countSetBits(long n) {

		int c = 0;
		while (n != 0) {
			long rsmbm = n & -n;
			n = n - rsmbm;
			c++;
		}
		return c;

	}

	public static long solution(long n, int k, int i) {

		if (i == 0) {
			return 0;
		}

		long mask = 1L << i;
		long rs = 0;

		if ((n & mask) == 0) {
			rs = solution(n, k, i - 1);
		} else {
			long addOne = solution(n, k - 1, i - 1);
			long addZero = ncr(i, k);

			rs = addOne + addZero;
		}

		return rs;

	}

	public static long ncr(long n, long r) {

		if (n < r) {
			return 0L;
		} else if (n == r || r == 0) {
			return 1L;
		}

		long res = 1L;

		for (long i = 0L; i < r; i++) {
			res = res * (n - i);
			res = res / (i + 1);
		}

		return res;

	}

}
