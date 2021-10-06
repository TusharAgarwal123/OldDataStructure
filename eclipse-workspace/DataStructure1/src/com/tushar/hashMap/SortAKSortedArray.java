package com.tushar.hashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortAKSortedArray {

	/*
	 * in this array each element is either at the k position before or k position
	 * you have to sort that.
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 2, 3, 1, 4, 6, 7, 5, 8, 9 };
		int k = 2;

		List<Integer> list = new ArrayList<>();

		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int x : ar) {
			q.add(x);
			if (q.size() > k) {
				list.add(q.remove());
			}
		}

		while (q.size() > 0) {
			list.add(q.remove());
		}

		System.out.println(list);

	}

}
