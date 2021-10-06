package com.tushar.BitManipulation;

public class CountSetBitsInFirstNNaturalNumbers {

	public static void main(String[] args) {

		/*
		 * 8 is 2^3,so till 0 to 7 we have 12 set bits. for 16 is 2^4,so till 0 to 15 we
		 * have 32 set bits.
		 * 
		 */

		int n = 11;
		System.out.println(solution(n));

	}

	public static int solution(int n) {

		if (n == 0) {
			return 0;
		}

		int x = largestPowerOf2(n);

		int bitUpTo2Raisex = x * (1 << (x - 1)); // (2^(x-1))*x;
		int msbFrom2rXtoN = n - (1 << x) + 1;

		int ans = bitUpTo2Raisex + msbFrom2rXtoN + solution(n - (1 << x));
		return ans;

	}

	public static int largestPowerOf2(int n) {

		int c = 0;
		while ((1 << c) <= n) {
			c++;

		}

		return c - 1;

	}

}
