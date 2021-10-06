package com.AdvanceRec3;

import java.util.ArrayList;
import java.util.List;

public class PartitionIntoKSubSets {

	public static void main(String[] args) {

		int n = 3;
		int k = 2;
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		
		

		solve(1, n, k, 0, ans);
		

	}

	// nos means no of set.
	static int c = 0;

	public static void solve(int i, int n, int k, int nos, List<List<Integer>> ans) {

		if (i > n) {
			if (nos == k) {
				c++;
				System.out.print(c + ".");
				for (List<Integer> set : ans) {
					System.out.println(set + " ");
				}
				System.out.println();
			}
			return;
		}

		for (int j = 0; j < ans.size(); j++) {

			if (ans.get(j).size() > 0) {
				ans.get(j).add(i);
				solve(i + 1, n, k, nos, ans);
				ans.get(j).remove(ans.get(j).size() - 1);
			} else {
				ans.get(j).add(i);
				solve(i + 1, n, k, nos + 1, ans);
				ans.get(j).remove(ans.get(j).size() - 1);
				break;
			}

		}

	}

}
