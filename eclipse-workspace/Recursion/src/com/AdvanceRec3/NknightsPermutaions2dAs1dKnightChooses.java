package com.AdvanceRec3;

public class NknightsPermutaions2dAs1dKnightChooses {

	/*
	 * 1. You are given a number n, representing the size of a n * n chess board. 2.
	 * You are required to calculate and print the permutations in which n knights
	 * can be placed on the n * n chess-board. 3. No knight shall be able to kill
	 * another.
	 */

	public static void main(String[] args) {

		int n = 2;
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

		if (row - 2 >= 0 && col - 1 >= 0 && chess[row - 2][col - 1] != 0) {
			return false;
		}

		if (row - 2 >= 0 && col + 1 < chess.length && chess[row - 2][col + 1] != 0) {
			return false;
		}
		if (row - 1 >= 0 && col - 2 >= 0 && chess[row - 1][col - 2] != 0) {
			return false;
		}
		if (row - 1 >= 0 && col + 2 < chess.length && chess[row - 1][col + 2] != 0) {
			return false;
		}

		if (row + 2 < chess.length && col - 1 >= 0 && chess[row + 2][col - 1] != 0) {
			return false;
		}

		if (row + 2 < chess.length && col + 1 < chess.length && chess[row + 2][col + 1] != 0) {
			return false;
		}
		if (row + 1 < chess.length && col - 2 >= 0 && chess[row + 1][col - 2] != 0) {
			return false;
		}
		if (row + 1 < chess.length && col + 2 < chess.length && chess[row + 1][col + 2] != 0) {
			return false;
		}

		return true;

	}

}
