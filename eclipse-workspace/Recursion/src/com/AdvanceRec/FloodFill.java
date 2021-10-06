package com.AdvanceRec;

public class FloodFill {

	public static void main(String[] args) {

		// System.out.println(floodFill(0, 0, 3, 3, new int[4][4], ""));

	}

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 1 } };

	static int floodFill(int cr, int cc, int er, int ec, int[][] board, String ans) {

		if (cr == er && cc == ec) {

			System.out.println(ans);
			return 1;

		}

		board[cr][cc] = 2;

		int c = 0;

		for (int i = 0; i < dir.length; i++) {
			int newRow = cr + dir[i][0];
			int newCol = cc + dir[i][1];

			if (isValid(newRow, newCol, board)) {
				c += floodFill(newRow, newCol, er, ec, board, ans + "d" + i);
			}
		}

		board[cr][cc] = 0;
		return c;

	}

	private static boolean isValid(int r, int c, int[][] board) {

		if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == 2) {
			return false;
		}
		return true;

	}

}
