package com.AdvanceRec3;

public class Combination2 {

	public static void main(String[] args) {

		int n = 4;
		int k = 3;
		combination(new int[n], 1, k, -1);

	}

	public static void combination(int[] is, int i, int k, int j) {

		if (i > k) {
			for (int j2 = 0; j2 < is.length; j2++) {
				if (is[j2] == 1) {
					System.out.print("i");
				} else {
					System.out.print("-");
				}
			}
			System.out.println();
			return;
		}

		for (int j2 = j + 1; j2 < is.length; j2++) {

			if (is[j2] == 0) {
				is[j2] = 1;
				combination(is, i + 1, k, j2);
				is[j2] = 0;
			}

		}

	}

}
