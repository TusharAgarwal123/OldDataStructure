package co.tushar.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortAKSortedArray {

	public static void main(String[] args) {


		int ar[]= {6,5,3,2,8,10,9};
		int k=3;
		
		
		List<Integer> ll=new ArrayList<Integer>();
		
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		for(int x:ar) {
			q.add(x);
			if(q.size()>k) {
				ll.add(q.remove());
			}
		}
		
		while(q.size()!=0) {
			ll.add(q.poll());
		}
		
		System.out.println(ll);

	}

}
