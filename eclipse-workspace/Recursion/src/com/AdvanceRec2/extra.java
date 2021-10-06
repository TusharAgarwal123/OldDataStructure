package com.AdvanceRec2;

public class extra {

	public static void main(String[] args) {

		int ar[] = { 3, 3, 0, 2, 2, 3, 9 };
		int n = ar.length;

		Integer dp[] = new Integer[n + 1];

		dp[n] = 0;
		for (int i = n - 1; i >= 0; i--) {

			if (ar[i] > 0) {

				int min = Integer.MAX_VALUE;

				for (int j = 1; j <= ar[i] && i + j < dp.length; j++) {
					if (dp[i + j] != null) {
						min = Math.min(min, dp[i + j]);
					}

				}

				if (min != Integer.MAX_VALUE) {
					dp[i] = min + 1;
				}

			}

		}

		System.out.println(dp[0]); // if null comes than there is no way.

	}
}
