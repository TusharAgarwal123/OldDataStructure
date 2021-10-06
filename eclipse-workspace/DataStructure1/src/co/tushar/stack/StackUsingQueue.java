package co.tushar.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	static Queue<Integer> q1 = new LinkedList<>();
	static Queue<Integer> q2 = new LinkedList<>();

	public static void push(int ele) {
		q1.add(ele);
	}

	public static int pop() {

		if (q1.isEmpty()) {
			return -1;
		}

		while (q1.size() != 1) {
			q2.add(q1.remove());
		}
		int t = q1.remove();

		Queue<Integer> q3 = q1;
		q1 = q2;
		q2 = q3;

		return t;

	}

	public static void main(String[] args) {

		push(10);
		push(20);
		push(30);
		System.out.println(pop());
		push(40);
		push(50);
		System.out.println(pop());
		push(60);

	}

}
