package co.tushar.Important;

import java.util.Arrays;
import java.util.Collections;

public class Candies {

	/*
	 * You are given an array A of size N where A[i] denotes the number of candies
	 * of ith type you have.you can satisfy a student by giving him N-1 candies of
	 * different types.what is the maximum number of students you can satisfy by
	 * distributing the candies optimally.
	 */

	public static void main(String[] args) {

		int ar[] = { 9264, 5927, 5213, 2597, 2564, 2506, 2504, 1515, 1465 };
		int n = ar.length;

		// sort the array in descending order.

		int ans = ar[n - 2];
		for (int i = 0; i < n - 2; i++) {
			ar[i] -= ar[n - 2];
		}
		int t = ar[n - 1];
		for (int i = 0; i < n; i++) {
			t = Math.min(ar[i], t);
		}

		ans += t;

		System.out.println(ans);
	}

}
