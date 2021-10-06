package com.AdvanceRec3;

import java.util.ArrayList;

public class TugOfWar {

	/*
	 * 1. You are given an array of n integers. 2. You have to divide these n
	 * integers into 2 subsets such that the difference of sum of two subsets is as
	 * minimum as possible. 3. If n is even, both set will contain exactly n/2
	 * elements. If is odd, one set will contain (n-1)/2 and other set will contain
	 * (n+1)/2 elements. 3. If it is not possible to divide, then print "-1".
	 */

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3, 4, 5, 6 };

		solve(ar, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println(mindiff);
		System.out.println(ans);

	}

	static int mindiff = Integer.MAX_VALUE;
	static String ans = "";

	public static void solve(int[] ar, int i, ArrayList set1, ArrayList set2, int soset1, int soset2) {

		if (i == ar.length) {

			int delta = Math.abs(soset1 - soset2);
			if (delta < mindiff) {
				mindiff = delta;
				ans = set1 + " " + set2;
			}

			return;
		}

		if (set1.size() < (ar.length + 1) / 2) {
			set1.add(ar[i]);
			solve(ar, i + 1, set1, set2, soset1 + ar[i], soset2);
			set1.remove(set1.size() - 1);
		}

		if (set2.size() < (ar.length + 1) / 2) {
			set2.add(ar[i]);
			solve(ar, i + 1, set1, set2, soset1, soset2 + ar[i]);
			set2.remove(set2.size() - 1);
		}
	}

}
