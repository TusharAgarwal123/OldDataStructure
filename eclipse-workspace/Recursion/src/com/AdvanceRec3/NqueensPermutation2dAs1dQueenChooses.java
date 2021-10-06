package com.AdvanceRec3;

public class NqueensPermutation2dAs1dQueenChooses {

	/*
	 * 1. You are given a number n, representing the size of a n * n chess board. 2.
	 * You are required to calculate and print the permutations in which n queens
	 * (distinct) can be placed on the n * n chess-board. 3. No queen shall be able
	 * to kill another.
	 */

	public static void main(String[] args) {

		int n = 4;
		int chess[][] = new int[n][n];
		solve(0, n, chess);

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

		for (int cell = 0; cell < n * n; cell++) {

			int row = cell / n;
			int col = cell % n;

			if (chess[row][col] == 0 && isSafe(chess, row, col)) {

				chess[row][col] = i + 1;
				solve(i + 1, n, chess);
				chess[row][col] = 0;
			}

		}

	}

	public static boolean isSafe(int[][] chess, int row, int col) {

		for (int i = 0; i <= row; i++) { // vertically up
			if (chess[i][col] != 0) {
				return false;
			}
		}

		for (int i = row + 1; i < chess.length; i++) { // vertically down
			if (chess[i][col] != 0) {
				return false;
			}
		}

		for (int i = 0; i <= col; i++) { // horizontally left
			if (chess[row][i] != 0) {
				return false;
			}
		}

		for (int i = col + 1; i < chess.length; i++) { // horizontally right
			if (chess[row][i] != 0) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) { // diagonally top left
			if (chess[i][j] != 0) {
				return false;
			}
		}

		for (int i = row, j = col; i < chess.length && j < chess.length; i++, j++) { // diagonally bottom right
			if (chess[i][j] != 0) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) { // diagonally top right
			if (chess[i][j] != 0) {
				return false;
			}
		}

		for (int i = row, j = col; i < chess.length && j >= 0; i++, j--) { // diagonally bottom left
			if (chess[i][j] != 0) {
				return false;
			}
		}

		return true;

	}

}
