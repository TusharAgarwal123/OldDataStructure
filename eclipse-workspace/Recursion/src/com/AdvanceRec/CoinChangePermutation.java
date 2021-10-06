package com.AdvanceRec;

public class CoinChangePermutation {

	public static void main(String[] args) {

		coinChangePermutation(new int[] { 2, 3, 4, 5, 6 }, 10, "");

		coinChangeCombination(new int[] { 2, 3, 4, 5, 6 }, 10, "", 0);

	}

	static void coinChangeCombination(int[] ar, int amnt, String ans, int index) {

		if (amnt == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = index; i < ar.length; i++) {
			if (amnt >= ar[i]) {
				coinChangeCombination(ar, amnt - ar[i], ans + ar[i], i);
			}
		}

	}

	static void coinChangePermutation(int[] ar, int amnt, String ans) {

		if (amnt == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ar.length; i++) {
			if (amnt >= ar[i]) {
				coinChangePermutation(ar, amnt - ar[i], ans + ar[i]);
			}
		}

	}

}
