package com.tushar.DP5;

public class PaintFence {

	public static void main(String[] args) {

		/*
		 * you have n fence and k colors ,you have to find the total ways that you can
		 * paint each fence such that no more than two consecutive fence have same
		 * color.
		 */

		int n = 3;
		int k = 2;

		int same = k * 1;
		int diff = k * (k - 1);
		int total = same + diff;

		for (int i = 3; i <= n; i++) {
			same = diff;
			diff = total * (k - 1);
			total = same + diff;
		}

		System.out.println(total);

	}

}
