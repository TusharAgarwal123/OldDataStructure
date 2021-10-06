package com.AdvanceRec3;

public class QueensCombinations2dAs2dBoxChooses {

	/*
	 * 1. You are given a number n, representing the size of a n * n chess board. 2.
	 * You are required to calculate and print the combinations in which n queens
	 * can be placed on the n * n chess-board.
	 */

	public static void main(String[] args) {

		int n = 3;
		// solve(0, n, 0, 0, "");

		boolean chess[][] = new boolean[n][n];
		// solve2(0, n, chess, 0, -1);

		solve3(0, n, chess, -1);

	}

	public static void solve3(int qpsf, int n, boolean[][] chess, int j) {

		if (qpsf == n) {

			for (int i = 0; i < chess.length; i++) {
				for (int k = 0; k < chess.length; k++) {
					if (chess[i][k]) {
						System.out.print("q\t");
					} else {
						System.out.print("-\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;

		}

		for (int cell = j + 1; cell < n * n; cell++) {

			int row = cell / n;
			int col = cell % n;

			chess[row][col] = true;
			solve3(qpsf + 1, n, chess, cell);
			chess[row][col] = false;

		}

	}

	public static void solve2(int qpsf, int n, boolean[][] chess, int i, int j) {

		if (i == n) {

			for (int j2 = 0; j2 < chess.length; j2++) {
				for (int k = 0; k < chess.length; k++) {
					if (chess[j2][k]) {
						System.out.print("q\t");
					} else {
						System.out.print("-\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;

		}

		for (int col = j + 1; col < chess.length; col++) {
			chess[i][col] = true;
			solve2(qpsf + 1, n, chess, i, col);
			chess[i][col] = false;
		}

		for (int row = i + 1; row < chess.length; row++) {
			for (int k = 0; k < chess.length; k++) {
				chess[row][k] = true;
				solve2(qpsf + 1, n, chess, row, k);
				chess[row][k] = false;
			}
		}

	}

	public static void solve(int qpsf, int n, int row, int col, String ans) {

		if (row == n) {
			if (qpsf == n) {
				System.out.println(ans);
			}
			return;
		}

		int nr = 0;
		int nc = 0;

		String yes = "";
		String no = "";

		if (col == n - 1) {
			nr = row + 1;
			nc = 0;
			yes = ans + "q\n";
			no = ans + "-\n";
		} else {
			nr = row;
			nc = col + 1;
			yes = ans + "q";
			no = ans + "-";
		}

		solve(qpsf + 1, n, nr, nc, ans + yes);
		solve(qpsf, n, nr, nc, ans + no);

	}

}
