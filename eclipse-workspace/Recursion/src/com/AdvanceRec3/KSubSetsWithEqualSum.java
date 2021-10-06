package com.AdvanceRec3;

import java.util.ArrayList;

public class KSubSetsWithEqualSum {

	/*
	 * 1. You are given an array of n distinct integers. 2. You have to divide these
	 * n integers into k non-empty subsets such that sum of integers of every subset
	 * is same. 3. If it is not possible to divide, then print "-1".
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3, 4, 5, 6 };
		int k = 3;

		int sum = 0;
		for (int x : ar) {
			sum += x;
		}

		if (k == 1) {
			System.out.print("[");
			for (int x : ar) {
				System.out.print(x + " ");
			}
			System.out.println("]");
			return;

		}

		if (k > ar.length || sum % k != 0) {
			System.out.println(-1);
			return;
		}

		int subSetSum[] = new int[k]; // it will store each subset sum.
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}

		solution(ar, 0, k, subSetSum, 0, ans);

	}

	// nms means = no of non empty sets.
	public static void solution(int[] ar, int i, int k, int[] subSetSum, int nms, ArrayList<ArrayList<Integer>> ans) {

		if (i == ar.length) {
			if (nms == k) { // this check number partition into same no sets.

				boolean flag = true;
				for (int z = 0; z < subSetSum.length - 1; z++) {
					if (subSetSum[z] != subSetSum[z + 1]) {
						flag = false;
						break;
					}
				}

				if (flag) {
					for (ArrayList<Integer> ll : ans) {
						System.out.print(ll + " ");
					}
					System.out.println();
				}

			}
			return;
		}

		for (int j = 0; j < ans.size(); j++) {

			if (ans.get(j).size() > 0) { // existing non empty set.

				ans.get(j).add(ar[i]);
				subSetSum[j] += ar[i];
				solution(ar, i + 1, k, subSetSum, nms, ans);
				ans.get(j).remove(ans.get(j).size() - 1);
				subSetSum[j] -= ar[i];

			} else { // inserting in existing empty set.
				ans.get(j).add(ar[i]);
				subSetSum[j] += ar[i];
				solution(ar, i + 1, k, subSetSum, nms + 1, ans); // this time we will increase no of non empty set bocz
																	// we use one empty set and it become non empty set.
				ans.get(j).remove(ans.get(j).size() - 1);
				subSetSum[j] -= ar[i];
				break;
			}

		}

	}

}
