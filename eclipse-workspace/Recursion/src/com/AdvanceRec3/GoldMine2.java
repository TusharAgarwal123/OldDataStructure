package com.AdvanceRec3;

import java.util.ArrayList;

/*
 * 1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are allowed to take one step left, right, up or down from your current position.
5. You can't visit a cell with 0 gold and the same cell more than once. 
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine if 
you start and stop collecting gold from any position in the grid that has some gold.
 */

public class GoldMine2 {

	public static void main(String[] args) {

		int ar[][] = { { 0, 1, 4, 2, 8, 2 }, { 4, 3, 6, 5, 0, 4 }, { 1, 2, 4, 1, 4, 6 }, { 2, 0, 7, 3, 2, 2 },
				{ 3, 1, 5, 9, 2, 4 }, { 2, 7, 0, 8, 5, 1 } };
		
		getMaxGold(ar);
		System.out.println(max);

	}

	static int max = 0;

	public static void getMaxGold(int ar[][]) {

		boolean visit[][] = new boolean[ar.length][ar[0].length];

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {

				if (ar[i][j] != 0 && visit[i][j] == false) {
					ArrayList<Integer> bag = new ArrayList<>();
					travelAndCollectGold(ar, i, j, bag, visit);

					int sum = 0;
					for (int val : bag) {
						sum += val;
					}

					if (sum > max) {
						max = sum;
					}
				}

			}
		}

	}

	public static void travelAndCollectGold(int[][] ar, int i, int j, ArrayList<Integer> bag, boolean[][] visit) {

		if (i < 0 || i >= ar.length || j < 0 || j >= ar[0].length || ar[i][j] == 0 || visit[i][j] == true) {
			return;
		}

		visit[i][j] = true;
		bag.add(ar[i][j]);
		travelAndCollectGold(ar, i - 1, j, bag, visit);
		travelAndCollectGold(ar, i + 1, j, bag, visit);
		travelAndCollectGold(ar, i, j - 1, bag, visit);
		travelAndCollectGold(ar, i, j + 1, bag, visit);

	}

}
