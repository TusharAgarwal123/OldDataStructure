package co.tushar.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestNumbers {

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {

			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {

		// we have an array and k and x,we have to find the k closest number to x.

		int ar[] = { 5, 6, 7, 8, 9 };
		int k = 3;
		int x = 7;

		PriorityQueue<Pair> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < ar.length; i++) {

			int diff = Math.abs(ar[i] - x);
			Pair p = new Pair(diff, ar[i]);
			q.add(p);
			if (q.size() > k) {
				q.remove();
			}

		}

		while (q.size() != 0) {
			System.out.println(q.remove().y);
		}

	}

}
