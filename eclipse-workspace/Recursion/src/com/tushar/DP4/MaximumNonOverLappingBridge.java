package com.tushar.DP4;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumNonOverLappingBridge {

	// bridge will be nonOverlapping if north of first bridge are smaller than
	// second.
	// same for south.

	static class Bridge implements Comparable<Bridge> {

		int n; // north
		int s; // soutn

		public Bridge(int n, int s) {

			this.n = n;
			this.s = s;
		}

		@Override
		public int compareTo(Bridge o) {

			if (this.n != o.n) {
				return this.n - o.n;
			} else {
				return this.s - o.s; // if north end are equal than sort on basis on south end.
			}

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		Bridge[] br = new Bridge[n];

		for (int i = 0; i < n; i++) {

			String line = sc.nextLine();
			String[] parts = line.split(" ");
			int north = Integer.parseInt(parts[0]);
			int south = Integer.parseInt(parts[1]);

			br[i] = new Bridge(north, south);

		}
		Arrays.sort(br);

		int dp[] = new int[n];
		int omax = 0;
		for (int i = 0; i < dp.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (br[j].s <= br[i].s) {
					if (dp[j] > max) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			omax = Math.max(omax, dp[i]);
		}

		System.out.println(omax);

	}

}
