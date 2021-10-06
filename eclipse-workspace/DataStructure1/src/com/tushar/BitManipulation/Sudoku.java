package com.tushar.BitManipulation;

import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {

		System.out.println("Enter");
		Scanner sc = new Scanner(System.in);
		int ar[][] = new int[9][9];
		int row[] = new int[9];
		int col[] = new int[9];
		int grid[][] = new int[3][3];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int dg = sc.nextInt();
				ar[i][j] = dg;
				row[i] = row[i] | (1 << dg);
				col[j] = col[j] | (1 << dg);
				grid[i / 3][j / 3] = grid[i / 3][j / 3] | (1 << dg);
			}
		}

		solve(ar, row, col, grid, 0, 0);
		print(ar);

	}

	private static void print(int[][] ar) {

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void solve(int[][] ar, int[] row, int[] col, int[][] grid, int i, int j) {

		if (i == ar.length) {
			return;
		}

		if (ar[i][j] != 0) {
			solve(ar, row, col, grid, j == ar[0].length - 1 ? i + 1 : i, j == ar[0].length - 1 ? 0 : j + 1);
		} else {
			for (int k = 1; k <= 9; k++) {

				if ((row[i] & (1 << k)) == 0 && (col[j] & (1 << k)) == 0 && (grid[i / 3][j / 3] & (1 << k)) == 0

				) {

					ar[i][j] = k;
					row[i] = row[i] ^ (1 << k);
					col[j] = col[j] ^ (1 << k);
					grid[i / 3][j / 3] = grid[i / 3][j / 3] ^ (i << k);
					solve(ar, row, col, grid, j == ar[0].length - 1 ? i + 1 : i, j == ar[0].length - 1 ? 0 : j + 1);
					row[i] = row[i] ^ (1 << k);
					col[j] = col[j] ^ (1 << k);
					grid[i / 3][j / 3] = grid[i / 3][j / 3] ^ (i << k);
					ar[i][j] = 0;

				}

			}
		}

	}

}
