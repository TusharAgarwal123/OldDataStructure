package com.tushar.hashMap;

import java.util.PriorityQueue;

public class printKLargestElement {

	public static void main(String[] args) {

		int ar[] = { 2, 10, 5, 17, 7, 18, 6, 4 };
		int k = 3;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int x : ar) {
			q.add(x);
			if (q.size() > k) {
				q.remove();
			}
		}

		while (q.size() > 0) {
			System.out.println(q.remove());
		}

	}

}
