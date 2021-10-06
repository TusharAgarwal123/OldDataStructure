package com.tushar.hashMap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {

	public static void main(String[] args) {

		MedianPriorityQueueImplementation q=new MedianPriorityQueueImplementation();
		q.add(12);
		q.add(6);
		q.add(8);
		q.add(14);
		
		System.out.println(q.peek());
		q.add(89);
		System.out.println(q.peek());
		System.out.println(q.size());
		
	}

}

class MedianPriorityQueueImplementation {

	PriorityQueue<Integer> l = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> r = new PriorityQueue<>();

	public void add(int val) {

		if (r.size() > 0 && val > r.peek()) {
			r.add(val);
		} else {
			l.add(val);
		}
		
		if(l.size()-r.size()==2) {
			r.add(l.remove());
		}else if(r.size()-l.size()==2) {
			l.add(r.remove());
		}

	}

	public int remove() {

		if (this.size() == 0) {
			System.out.println("UnderFlow");
			return -1;
		} else if (l.size() >= r.size()) {
			return l.remove();
		} else {
			return r.remove();
		}

	}

	public int peek() {

		if (this.size() == 0) {
			System.out.println("UnderFlow");
			return -1;
		} else if (l.size() >= r.size()) {
			return l.peek();

		} else {
			return r.peek();
		}

	}

	public int size() {
		return l.size() + r.size();
	}

}
