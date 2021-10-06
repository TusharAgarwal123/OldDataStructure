package co.tushar.stack;

public class StackUsingLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
		}
	}

	static Node front = null;

	public static void push(int data) {
		if (front == null) {
			front = new Node(data);
			return;
		}

		Node temp = new Node(data);
		temp.next = front;
		front = temp;

	}

	public static int pop() {
		if (front == null) {
			return -1;
		}
		int val = front.data;
		front = front.next;
		return val;
	}

	public static int peek() {
		if (front == null) {
			return -1;
		}
		return front.data;
	}

	public static void main(String[] args) {

		push(10);
		push(20);
		push(30);
		push(40);
		System.out.println(peek());
		push(50);
		push(60);

		System.out.println(pop());
		System.out.println(pop());
		System.out.println(peek());
		System.out.println(pop());
		System.out.println(peek());

	}

}
