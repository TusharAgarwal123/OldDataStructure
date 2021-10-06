package com.AdvanceRec3;

public class QueensPermutations2dAs2dBoxChooses {

	/*
	 * 1. You are given a number n, representing the size of a n * n chess board. 2.
	 * You are required to calculate and print the permutations in which n queens
	 * can be placed on the n * n chess-board.
	 */

	public static void main(String[] args) {

		int n = 2;
		int[][] chess = new int[n][n];

		// solve(0, n, chess);
		boolean ar[] = new boolean[n];
		solve2(0, n, 0, 0, "", ar);

	}

	public static void solve2(int qpsf, int n, int row, int col, String ans, boolean[] ar) {

		if (row == n) {
			if (qpsf == n) {
				System.out.println(ans);

			}
			return;
		}

		int nr = 0;
		int nc = 0;

		char sep = '\0';

		if (col == n - 1) {
			nr = row + 1;
			nc = 0;
			sep = '\n';
		} else {
			nr = row;
			nc = col + 1;
			sep = '\t';
		}

		for (int i = 0; i < ar.length; i++) {

			if (ar[i] == false) {

				ar[i] = true;
				solve2(qpsf + 1, n, nr, nc, ans + "q" + (i + 1) + sep, ar);
				ar[i] = false;
			}

		}

		solve2(qpsf, n, nr, nc, ans + "-" + sep, ar);

	}

	public static void solve(int i, int n, int[][] chess) {

		if (i == n) {

			for (int j = 0; j < chess.length; j++) {
				for (int j2 = 0; j2 < chess[0].length; j2++) {
					if (chess[j][j2] == 0) {
						System.out.print("-\t");
					} else {
						System.out.print("q" + chess[j][j2] + "\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int j = 0; j < chess.length; j++) {
			for (int j2 = 0; j2 < chess[0].length; j2++) {
				if (chess[j][j2] == 0) {
					chess[j][j2] = (i + 1);
					solve(i + 1, n, chess);
					chess[j][j2] = 0;
				}
			}
		}

	}

}
