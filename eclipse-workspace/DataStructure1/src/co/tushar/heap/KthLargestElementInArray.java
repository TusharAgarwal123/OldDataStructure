package co.tushar.heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

	public static void main(String[] args) {

		//whenever ask for kth largest use min heap.priorityQueue provides the implementation
		//of min heap.for max heap use Collections.reverse().

		int ar[]= {2,6,9,5,1,7};
		int k=3;
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		for(int x:ar) {
			q.add(x);
			if(q.size()>k) {
				q.remove();
			}
		}
		System.out.println(q.remove());

	}

}
