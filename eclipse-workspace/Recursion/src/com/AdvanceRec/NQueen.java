package com.AdvanceRec;

public class NQueen {

	public static void main(String[] args) {

		boolean board[][] = new boolean[4][4];
		nQueenSolution(board, 0);
		System.out.println(countnQueen(board, 0));

	}

	static int countnQueen(boolean[][] board, int row) {

		if (row == board.length) {
			return 1;
		}
		int c = 0;
		for (int col = 0; col < board.length; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = true;
				c = c + countnQueen(board, row + 1);
				board[row][col] = false;

			}
		}
		return c;

	}

	static void nQueenSolution(boolean[][] board, int row) {

		if (row == board.length) {
			printMat(board);
			System.out.println();
			return;
		}

		for (int col = 0; col < board.length; col++) {

			if (isSafe(board, row, col)) {

				board[row][col] = true;
				nQueenSolution(board, row + 1);
				board[row][col] = false; // backtracking

			}

		}

	}

	static boolean isSafe(boolean[][] board, int row, int col) {

		for (int i = 0; i < row; i++) {
			if (board[i][col] == true) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == true) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == true) {
				return false;
			}
		}

		return true;

	}

	static void printMat(boolean[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

}
