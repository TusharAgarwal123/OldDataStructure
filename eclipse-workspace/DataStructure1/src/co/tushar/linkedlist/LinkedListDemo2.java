package co.tushar.linkedlist;

public class LinkedListDemo2 {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		Node head = null;
		head = insert(2, head);
		head = insert(4, head);
		head = insert(7, head);
		head = insert(1, head);
		head = insert(9, head);
		head = insert(3, head);

		print(head);
		System.out.println();

		System.out.println(size(head));

		head = rotateClockWise(3, head);
		print(head);

		System.out.println();

		head = rotateAntiClockWise(2, head);
		print(head);
		System.out.println();

		head = reverse(head);
		print(head);
		System.out.println();

		System.out.println(getMid(head).data);

		head = mergeSort(head);
		print(head);
		System.out.println();

	}

	// given two lists find the common element in both.
	public Node getIntersection(Node a, Node b) {

		a = mergeSort(a);
		b = mergeSort(b);

		return mergeWithIntersection(a, b);

	}

	Node mergeWithIntersection(Node a, Node b) {

		Node temp = new Node(0);
		Node finalList = temp;

		while (a != null && b != null) {

			if (a.data < b.data) {

				a = a.next;
			} else if (a.data > b.data) {

				b = b.next;
			} else {

				temp.next = a;
				temp = temp.next;
				a = a.next;
				b = b.next;

			}

		}

		temp.next = null;

		return finalList.next;
	}

	public Node getUnion(Node a, Node b) {

		a = mergeSort(a);
		b = mergeSort(b);

		return mergeWithUnion(a, b);

	}

	public Node mergeWithUnion(Node a, Node b) {

		Node temp = new Node(0);
		Node finalList = temp;

		while (a != null && b != null) {

			if (a.data < b.data) {
				temp.next = a;
				a = a.next;
			} else if (a.data > b.data) {
				temp.next = b;
				b = b.next;
			} else {

				temp.next = a;
				a = a.next;
				b = b.next;

			}

			temp = temp.next;

		}

		if (a != null) {
			temp.next = a;
			a = a.next;
		}
		if (b != null) {
			temp.next = b;
			b = b.next;
		}

		return finalList.next;
	}

	public static Node mergeSort(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node middle = getMid(head);
		Node secondHalf = middle.next;
		middle.next = null;

		return merge(mergeSort(head), mergeSort(secondHalf));

	}

	static Node merge(Node a, Node b) { // work on sorted lists.

		Node temp = new Node(0);
		Node finalList = temp;

		while (a != null && b != null) {

			if (a.data < b.data) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;

		}

		if (a != null) {
			temp.next = a;
			a = a.next;
		}
		if (b != null) {
			temp.next = b;
			b = b.next;
		}

		return finalList.next;
	}

	public static Node getMid(Node head) {

		if (head == null) {
			return head;
		}

		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	public static Node reverse(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node temp = reverse(head.next);
		head.next.next = head;
		head.next = null;

		return temp;

	}

	public static Node rotateClockWise(int k, Node head) {

		if (head == null || k < 0) {
			return head;
		}

		int size = size(head);
		k = k % size;
		if (k == 0) {
			return head;
		}

		int i = 1;
		Node temp = head;

		while (i < size - k) {

			temp = temp.next;
			i++;

		}

		Node root = temp.next;
		temp.next = null;

		Node work = root;

		while (work.next != null) {
			work = work.next;
		}

		work.next = head;

		return root;

	}

	public static Node rotateAntiClockWise(int k, Node head) {

		if (head == null || k < 0) {
			return head;
		}

		int size = size(head);
		k = k % size;
		if (k == 0) {
			return head;
		}

		int i = 1;
		Node temp = head;

		while (i < k) {

			temp = temp.next;
			i++;

		}

		Node root = temp.next;
		temp.next = null;
		Node work = root;

		while (work.next != null) {
			work = work.next;
		}

		work.next = head;

		return root;

	}

	public static void print(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		print(head.next);

	}

	public static int size(Node head) {
		if (head == null) {
			return 0;
		}

		return size(head.next) + 1;

	}

	public static Node insert(int data, Node head) {

		Node node = new Node(data);
		if (head == null) {
			return node;
		}

		node.next = head;
		head = node;
		return head;

	}

}
