package co.tushar.queue;

public class QueueUsingLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node front = null;

	public static void enQueue(int val) {

		if (front == null) {
			front = new Node(val);

			return;
		}

		Node node = new Node(val);
		Node temp = front;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		node.next = null;

	}

	public static int deQueue() {
		if (front == null) {
			return -1;
		}
		int t = front.data;
		front = front.next;
		return t;
	}

	public static void main(String[] args) {

		enQueue(10);
		enQueue(20);
		enQueue(30);
		System.out.println(deQueue());
		enQueue(40);
		System.out.println(deQueue());
		enQueue(70);
		enQueue(50);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());

	}

}
