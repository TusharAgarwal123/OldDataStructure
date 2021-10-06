package com.tushar.Amazon;

public class MergeTwoSortedList {

	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
			next = null;
		}
	}

	public static Node merge(Node a, Node b) {

		Node tm = new Node(0);
		Node finalList = tm;

		while (a != null && b != null) {

			if (a.val < b.val) {
				tm.next = a;
				a = a.next;
			} else {
				tm.next = b;
				b = b.next;
			}
			tm = tm.next;

		}

		if (a != null) {
			tm.next = a;
			a = a.next;
			tm = tm.next;
		}

		if (b != null) {
			tm.next = b;
			b = b.next;
			tm = tm.next;
		}

		return finalList.next;

	}

	public static void main(String[] args) {

	}

}
