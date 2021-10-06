package com.AdvanceRec2;

public class KnightsTour {

	/*
	 * you have a grid and position in grid,that indicate the starting position of a
	 * knights you have to print the way in which knight travel at each position in
	 * grid.
	 */

	public static void main(String[] args) {

		int ar[][] = new int[3][3];
		int r = 2;
		int c = 2; // starting position of knights

		printKnightsTour(ar, r, c, 1);

	}

	public static void printKnightsTour(int ar[][], int r, int c, int move) {

		if (r < 0 || c < 0 || r >= ar.length || c >= ar.length || ar[r][c] > 0) {
			return;
		} else if (move == ar.length * ar.length) {
			ar[r][c] = move;
			print(ar);
			ar[r][c] = 0;
			return;
		}

		ar[r][c] = move;
		printKnightsTour(ar, r - 2, c + 1, move + 1);
		printKnightsTour(ar, r - 2, c - 1, move + 1);
		printKnightsTour(ar, r + 2, c + 1, move + 1);
		printKnightsTour(ar, r + 2, c - 1, move + 1);
		printKnightsTour(ar, r - 1, c + 2, move + 1);
		printKnightsTour(ar, r + 1, c + 2, move + 1);
		printKnightsTour(ar, r - 1, c - 2, move + 1);
		printKnightsTour(ar, r + 1, c - 2, move + 1);

	}

	public static void print(int ar[][]) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
