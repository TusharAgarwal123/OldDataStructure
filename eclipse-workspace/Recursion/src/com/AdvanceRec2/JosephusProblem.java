package com.AdvanceRec2;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

	public static void main(String[] args) {

		int n = 5;
		int k = 3;

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		k--;
		solve(list, k, 0);

	}

	private static void solve(List<Integer> list, int k, int index) {

		if (list.size() == 1) {
			System.out.println(list.get(0));
			return;
		}

		index = (index + k) % list.size();

		list.remove(index);

		solve(list, k, index);

	}

}
