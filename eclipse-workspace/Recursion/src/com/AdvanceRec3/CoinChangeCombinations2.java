package com.AdvanceRec3;

public class CoinChangeCombinations2 {
	/*
	 * 1. You are given a number n, representing the count of coins. 2. You are
	 * given n numbers, representing the denominations of n coins. 3. You are given
	 * a number "amt". 4. You are required to calculate and print the combinations
	 * of the n coins (same coin can be used again any number of times) using which
	 * the amount "amt" can be paid.
	 * 
	 */
	public static void main(String[] args) {

		int n = 5;
		int ar[] = { 2, 3, 5, 6, 7 };
		int tar = 12;

		solve(0, ar, 0, tar, "");

	}

	public static void solve(int i, int[] ar, int amtsf, int tar, String ans) {

		if (i == ar.length) {
			if (amtsf == tar) {
				System.out.println(ans);

			}
			return;
		}

		for (int j = tar / ar[i]; j >= 1; j--) {
			String str = "";
			for (int k = 0; k < j; k++) {
				str += ar[i] + "-";
			}
			solve(i + 1, ar, amtsf + ar[i] * j, tar, ans + str);
		}

		solve(i + 1, ar, amtsf, tar, ans); // not taking

	}

}
