package com.tushar.BitManipulation;

public class JosephusProblem {

	public static void main(String[] args) {

		int n = 5;

		/*
		 * you have n person ,you have to kill alternatively,find the remaining one.
		 * like n=3(1,2,3) ,1 will not be killed,2 will be kill,then leave 3 kill 1. so
		 * answer is 3.
		 */

		int hp = powerof2(n);
		int l = n - hp;

		int ans = 2 * l + 1; // this is formula of finding.

		System.out.println(ans);

	}

	// find the highest power of 2 for n.
	public static int powerof2(int n) {

		int i = 1;
		while (i * 2 <= n) {
			i = i * 2;
		}
		return i;

	}

}
