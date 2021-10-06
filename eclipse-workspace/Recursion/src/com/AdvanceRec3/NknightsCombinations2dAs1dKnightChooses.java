package com.AdvanceRec3;

public class NknightsCombinations2dAs1dKnightChooses {

	/*
	 * 1. You are given a number n, representing the size of a n * n chess board. 2.
	 * You are required to calculate and print the combinations in which n knights
	 * can be placed on the n * n chess-board. 3. No knight shall be able to kill
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

		if (row - 2 >= 0 && col - 1 >= 0 && chess[row - 2][col - 1]) {
			return false;
		}

		if (row - 2 >= 0 && col + 1 < chess.length && chess[row - 2][col + 1]) {
			return false;
		}
		if (row - 1 >= 0 && col - 2 >= 0 && chess[row - 1][col - 2]) {
			return false;
		}
		if (row - 1 >= 0 && col + 2 < chess.length && chess[row - 1][col + 2]) {
			return false;
		}

		return true;

	}

}
