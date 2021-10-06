package com.AdvanceRec3;

public class Sudoku {

	public static void main(String[] args) {

		int boar[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		solve(boar, 0, 0);
		display(boar);

	}

	public static void solve(int ar[][], int i, int j) {

		if (i == ar.length) {
			return;
		}

		int ni = 0;
		int nj = 0;

		if (j == ar[0].length - 1) {
			ni = i + 1;
			nj = 0;
		} else {
			ni = i;
			nj = nj + 1;
		}

		if (ar[i][j] != 0) {
			solve(ar, ni, nj);
		} else {
			for (int k = 1; k <= 9; k++) {
				if (isValid(ar, i, j, k)) {
					ar[i][j] = k;
					solve(ar, ni, nj);
					ar[i][j] = 0;
				}
			}
		}

	}

	public static void display(int[][] ar) {

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static boolean isValid(int[][] ar, int i, int j, int k) {

		for (int z = 0; z < ar.length; z++) { // for rows.
			if (ar[z][j] == k) {
				return false;
			}
		}

		for (int z = 0; z < ar[0].length; z++) { // for columns
			if (ar[i][z] == k) {
				return false;
			}
		}

		/*
		 * now check for submatrixes divide row by 3 and then multiply by 3 divide
		 * column by 3 and then multiply by 3 to get the starting point of submatrix
		 */

		int subi = (i / 3) * 3;
		int subj = (j / 3) * 3;

		for (int z = 0; z < 3; z++) {
			for (int y = 0; y < 3; y++) {
				if (ar[subi + z][subj + y] == k) {
					return false;
				}
			}
		}

		return true;

	}

}
