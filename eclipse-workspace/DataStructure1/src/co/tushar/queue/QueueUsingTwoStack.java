package co.tushar.queue;

import java.util.Stack;

public class QueueUsingTwoStack {

	static Stack<Integer> st1 = new Stack<>();
	static Stack<Integer> st2 = new Stack<>();

	public static void main(String[] args) {

		enQueue(10);
		enQueue(15);
		enQueue(13);
		
		System.out.println(deQueue());
		
		enQueue(19);
		enQueue(20);
		
		System.out.println(deQueue());
		
	}

	public static void enQueue(int val) {
		st1.push(val);
	}

	public static int deQueue() {

		if (st2.size() != 0) {
			return st2.pop();
		}

		if (st1.size() == 0) {
			return -1;
		}

		while (st1.size() != 0) {
			st2.push(st1.pop());
		}

		return st2.pop();

	}

}
