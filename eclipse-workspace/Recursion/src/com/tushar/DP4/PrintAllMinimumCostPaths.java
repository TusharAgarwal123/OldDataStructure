package com.tushar.DP4;

import java.util.LinkedList;
import java.util.Queue;

public class PrintAllMinimumCostPaths {

	static class Pair {
		String psf; // path so far
		int i;
		int j;

		public Pair(String psf, int i, int j) {

			this.psf = psf;
			this.i = i;
			this.j = j;
		}

	}

	public static void main(String[] args) {

		int ar[][] = { { 1, 2, 3 }, { 5, 4, 1 }, { 8, 6, 2 } };
		int dp[][] = new int[ar.length][ar.length];

		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp.length - 1; j >= 0; j--) {
				if (i == dp.length - 1 && j == dp.length - 1) {
					dp[i][j] = ar[i][j];

				} else if (i == dp.length - 1) {
					dp[i][j] = dp[i][j + 1] + ar[i][j];
				} else if (j == dp.length - 1) {
					dp[i][j] = dp[i + 1][j] + ar[i][j];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + ar[i][j];
				}
			}
		}

		// now we will apply BFS to find the path.

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair("", 0, 0)); // initially path so far is empty,and we are starting from first row and col.

		while (!q.isEmpty()) {

			Pair rem = q.remove();

			if (rem.i == dp.length - 1 && rem.j == dp.length - 1) { // means we reach to the destination

				System.out.println(rem.psf);

			} else if (rem.i == dp.length - 1) { // last row.

				q.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));

			} else if (rem.j == dp.length - 1) { // last col

				q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));

			} else {
				if (dp[rem.i][rem.j + 1] < dp[rem.i + 1][rem.j]) { // means horizaontal one are small.
					q.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
				} else if (dp[rem.i][rem.j + 1] > dp[rem.i + 1][rem.j]) { // means vertical one are small.
					q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
				} else { // if both are equal.
					q.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
					q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
				}
			}

		}

	}

}
