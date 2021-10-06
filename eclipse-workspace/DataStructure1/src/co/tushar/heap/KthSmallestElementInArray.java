package co.tushar.heap;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElementInArray {

	public static void main(String[] args) {

		// when ask for kth smallest element use max heap ,we create max heap in java
		// like that.

		// Collections.reverseOrder() provides the comparator that would sort the
		// element
		// of priorityQueue in a opposite direction to their natural order.

		int ar[] = { 2, 6, 9, 5, 1, 7 };
		int k = 3;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int x : ar) {
			q.add(x);
			if (q.size() > k) {
				q.remove();
			}
		}
		System.out.println(q.remove());

	}

}
