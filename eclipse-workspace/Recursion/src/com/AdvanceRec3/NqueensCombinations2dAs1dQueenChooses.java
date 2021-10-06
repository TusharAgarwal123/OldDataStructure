package com.AdvanceRec3;

public class NqueensCombinations2dAs1dQueenChooses {

	/*
	 * 1. You are given a number n, representing the size of a n * n chess board. 2.
	 * You are required to calculate and print the combinations in which n queens
	 * can be placed on the n * n chess-board. 3. No queen shall be able to kill
	 * another.
	 */

	public static void main(String[] args) {

		int n = 4;
		boolean chess[][] = new boolean[n][n];
		solve(0, n, chess, -1);

	}

	public static void solve(int qpsf, int n, boolean[][] chess, int j) {

		if (qpsf == n) {
			for (int i = 0; i < chess.length; i++) {
				for (int k = 0; k < chess.length; k++) {
					System.out.print(chess[i][k] ? "q\t" : "-\t");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int cell = j + 1; cell < n * n; cell++) {

			int row = cell / n;
			int col = cell % n;

			if (isSafe(chess, row, col)) {

				chess[row][col] = true;
				solve(qpsf + 1, n, chess, cell);
				chess[row][col] = false;
			}

		}

	}

	public static boolean isSafe(boolean[][] chess, int row, int col) {

		for (int i = 0; i <= row; i++) { // vertically.
			if (chess[i][col] == true) {
				return false;
			}
		}

		for (int i = 0; i <= col; i++) { // horizontally.
			if (chess[row][i] == true) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j]) {
				return false;
			}
		}

		return true;

	}

}
