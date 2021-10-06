package com.tushar.hashMap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	/*
	 * you have k sorted list ,you have to merge all list in single list.
	 */

	static class Pair implements Comparable<Pair> {

		int li;
		int di;
		int val;

		public Pair(int li, int di, int val) {

			this.li = li;
			this.di = di;
			this.val = val;
		}

		public int compareTo(Pair o) {
			return this.val - o.val;
		}

	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(10);
		l1.add(20);
		l1.add(56);

		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(12);
		l2.add(22);
		l2.add(29);

		ArrayList<Integer> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(8);
		l3.add(9);

		list.add(l1);
		list.add(l2);
		list.add(l3);

		System.out.println(merge(list));

	}

	private static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> list) {

		ArrayList<Integer> ll = new ArrayList<Integer>();

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < list.size(); i++) {
			Pair p = new Pair(i, 0, list.get(i).get(0));
			pq.add(p);
		}

		while (pq.size() > 0) {
			Pair p = pq.remove();
			ll.add(p.val);
			p.di++;
			if (p.di < list.get(p.li).size()) {
				p.val = list.get(p.li).get(p.di);
				pq.add(p);
			}

		}
		return ll;

	}

}
