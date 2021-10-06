package co.tushar.linkedlist;

public class PepLinkedList {

	public static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
			next = null;
		}
	}

	public static class LinkedList {

		Node head;
		Node tail;
		int size;

		public int getFirst() {

			if (size == 0) {
				System.out.println("List is Empty");
				return -1;
			} else {
				return head.val;
			}

		}

		public int getLast() {

			if (size == 0) {
				System.out.println("List is Empty");
				return -1;
			} else {
				return tail.val;
			}

		}

		public int getAt(int idx) { // perticular index

			if (size == 0) {
				System.out.println("List is Empty");
				return -1;
			} else if (idx < 0 || idx >= size) {
				System.out.println("Invaid Index");
				return -1;
			} else {
				Node temp = head;
				for (int i = 0; i < idx; i++) {
					temp = temp.next;
				}
				return temp.val;
			}

		}

		public Node getAt2(int idx) {

			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;

		}

		public void addFirst(int val) {

			Node node = new Node(val);

			if (size == 0) {
				head = tail = node;
			} else {
				node.next = head;
				head = node;
			}
			size++;

		}

		public void addAtIndex(int val, int idx) {

			Node node = new Node(val);

			if (idx < 0 || idx > size) {
				System.out.println("Invalid Position!!");
			} else if (idx == 0) {
				addFirst(val);
			} else if (idx == size) {
				addLast(val);
			} else {
				Node temp = getAt2(idx - 1);
				node.next = temp.next;
				temp.next = node;
				size++;
			}

		}

		public void addLast(int val) {

			Node node = new Node(val);

			if (size == 0) {
				head = tail = node;
			} else {
				tail.next = node;
				tail = node;
				tail.next = null;
			}
			size++;

		}

		public void removeFirst() {

			if (size == 0) {
				System.out.println("List is Empty");

			} else if (size == 1) {
				head = tail = null;
				size--;
			} else {
				head = head.next;
				size--;
			}

		}

		public void removeAtIndex(int idx) {

			if (idx < 0 || idx >= size) {
				System.out.println("Invalid Position!!");
			} else if (idx == 0) {
				removeFirst();
			} else if (idx == size - 1) {
				removeLast();
			} else {
				Node temp = getAt2(idx - 1);
				temp.next = temp.next.next;
				size--;

			}

		}

		public void removeLast() {

			if (size == 0) {
				System.out.println("List is Empty");

			} else if (size == 1) {
				head = tail = null;
				size--;
			} else {

				Node temp = head;
				while (temp.next != tail) {
					temp = temp.next;
				}
				tail = temp;
				temp.next = null;

				size--;
			}

		}

		public void removeDuplicates() {

			if (size == 1) {
				return;
			}

			Node temp = head;
			while (temp.next != null) {
				if (temp.val == temp.next.val) {
					temp.next = temp.next.next;
					size--;
				} else {
					temp = temp.next;
				}
			}

			tail = temp;

		}

		public int kthFromLast(int k) {

			Node fast = head;
			Node slow = head;
			for (int i = 0; i < k; i++) {
				fast = fast.next;
			}
			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}

			return slow.val;

		}

		// arrange all odd elements first then even.
		public void oddEven() {

			Node i = head;
			Node j = head;

			while (i != null) {

				if (i.val % 2 == 0) {
					i = i.next;
				} else {
					int temp = i.val;
					i.val = j.val;
					j.val = temp;
					i = i.next;
					j = j.next;

				}

			}

		}

		public void oddEven2() {

			LinkedList odd = new LinkedList();
			LinkedList even = new LinkedList();

			while (this.size > 0) {
				int data = this.getFirst();
				this.removeFirst();
				if (data % 2 == 0) {
					even.addLast(data);
				} else {
					odd.addLast(data);
				}
			}

			if (odd.size > 0 && even.size > 0) {
				odd.tail.next = even.head;
				this.head = odd.head;
				this.tail = even.tail;
				this.size = odd.size + even.size;
			} else if (odd.size > 0) {
				this.head = odd.head;
				this.tail = odd.tail;
				this.size = odd.size;
			} else if (even.size > 0) {
				this.head = even.head;
				this.tail = even.tail;
				this.size = even.size;
			}

		}

		public int getMid() {

			Node fast = head;
			Node slow = head;

			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}

			return slow.val;

		}

		public void kReverse(int k) {

			LinkedList pre = null;
			while (this.size > 0) {

				LinkedList curr = new LinkedList();

				if (this.size >= k) {
					for (int i = 0; i < k; i++) {
						int data = this.getFirst();
						this.removeFirst();
						curr.addFirst(data);
					}
				} else {
					int os = this.getSize();
					for (int i = 0; i < os; i++) {
						int data = this.getFirst();
						this.removeFirst();
						curr.addLast(data);
					}

				}

				if (pre == null) {
					pre = curr;
				} else {
					pre.tail.next = curr.head;
					pre.tail = curr.tail;
					pre.size += curr.size;
				}

			}
			this.head = pre.head;
			this.tail = pre.tail;
			this.size = pre.size;

		}

		public void reverseIterative() {
			int l = 0;
			int h = size - 1;
			while (l < h) {

				Node first = getAt2(l);
				Node second = getAt2(h);

				int temp = first.val;
				first.val = second.val;
				second.val = temp;
				l++;
				h--;
			}
		}

		public void reverse2() {

			Node pre = null;
			Node curr = head;
			Node next = null;
			while (curr != null) {
				next = curr.next;
				curr.next = pre;
				pre = curr;
				curr = next;
			}

			// making head to tail and vice-versa.
			Node temp = head;
			head = tail;
			tail = temp;

		}

		// recursive.
		public void reverse3(Node node) {

			if (node == null) {
				return;
			}

			reverse3(node.next);
			if (node == tail) {

			} else {
				node.next.next = node;
			}

		}

		public void reverse3() {

			reverse3(head);
			head.next = null;
			Node temp = head;
			head = tail;
			tail = temp;
		}

		Node rleft;

		public void reverse4() {
			rleft = head;
			reverse4(head, 0);

		}

		private void reverse4(Node right, int floor) {

			if (right == null) {
				return;
			}

			reverse4(right.next, floor + 1);

			if (floor >= size / 2) {
				int temp = right.val;
				right.val = rleft.val;
				rleft.val = temp;

				rleft = rleft.next;
			}

		}

		Node left;

		public boolean checkPalindrome() {

			left = head;
			return checkPalindrome(head);

		}

		private boolean checkPalindrome(Node node) {

			if (node == null) {
				return true;
			}

			boolean res = checkPalindrome(node.next);

			if (res == false) {
				return false;
			} else if (left.val != node.val) {
				return false;
			} else {
				left = left.next;
				return true;

			}

		}

		Node lNode;

		public void fold() {
			lNode = head;
			fold(head, 0);
		}

		private void fold(Node node, int i) {

			if (node == null) {
				return;
			}

			fold(node.next, i + 1);

			if (i > size / 2) {

				Node temp = lNode.next;
				lNode.next = node;
				node.next = temp;
				lNode = temp;

			} else if (i == size / 2) {
				tail = node;
				tail.next = null;
			}

		}

		public LinkedList addTwoList(LinkedList one, LinkedList two) {

			LinkedList res = new LinkedList();

			int oldCarray = helper(one.head, one.size, two.head, two.size, res);
			if (oldCarray > 0) {
				res.addFirst(oldCarray);
			}

			return res;

		}

		private int helper(Node one, int v1, Node two, int v2, LinkedList res) {

			if (one == null && two == null) {
				return 0; // return carry
			}

			if (v1 > v2) {
				int oldCarry = helper(one.next, v1 - 1, two, v2, res);
				int data = one.val + oldCarry;

				int newData = data % 10;
				int newCarray = data / 10;
				res.addFirst(newData);
				return newCarray;

			} else if (v2 > v1) {
				int oldCarry = helper(one, v1, two.next, v2 - 1, res);
				int data = two.val + oldCarry;

				int newData = data % 10;
				int newCarray = data / 10;
				res.addFirst(newData);
				return newCarray;
			} else {
				int oldCarry = helper(one.next, v1 - 1, two.next, v2 - 1, res);
				int data = one.val + two.val + oldCarry;

				int newData = data % 10;
				int newCarray = data / 10;
				res.addFirst(newData);
				return newCarray;
			}

		}

		// multiply each node by 3.
		public void multiplyBy3() {

			// Node rr = head;

			int Oldcarry = multiplyBy3(head);
			if (Oldcarry > 0) {

				Node node = new Node(Oldcarry);
				node.next = head;
				head = node;

			}

			// this.head = rr;

		}

		public int multiplyBy3(Node head) {

			if (head == null) {
				return 0;
			}

			int carry = multiplyBy3(head.next);
			int t = head.val * 3;
			head.val = (carry + t) % 10;
			carry = (carry + t) / 10;
			return carry;

		}

		public int findIntersection(LinkedList one, LinkedList two) {

			Node t1 = one.head;
			Node t2 = two.head;

			int diff = Math.abs(one.size - two.size);
			if (one.size > two.size) {
				for (int i = 0; i < diff; i++) {
					t1 = t1.next;
				}
			} else {
				for (int i = 0; i < diff; i++) {
					t2 = t2.next;
				}
			}

			while (t1 != t2) {
				t1 = t1.next;
				t2 = t2.next;
			}
			return t1.val;

		}

		public int getSize() {
			return this.size;
		}

		public void display() {

			Node temp = head;
			while (temp != null) {
				System.out.print(temp.val + " ");
				temp = temp.next;
			}
			System.out.println();

		}

		// delete node without head pointer.
		public static void deleteNode(Node node) {

			// you have given the node ,not the head you have to delete that node from
			// list.

			// we will copy the data of next node into the given node.
			// then we will delete the next node.

			node.val = node.next.val;
			node.next = node.next.next;

		}

		public static Node pairwiseSwap(Node head) {

			Node temp = head;

			while (temp != null && temp.next != null) {
				int tm = temp.val;
				temp.val = temp.next.val;
				temp.next.val = tm;

				temp = temp.next.next;
			}

			return head;

		}

		/*
		 * in a given linked list replaces the value of every kth element with the sum
		 * of it's own value and (n-(k-1))th elements value k=1,2,3..
		 */
		Node rr;

		public void updateList() {

			rr = head;
			updateList(head, 0);
			

			slow.next = null;

			System.out.println(head.next.val);
			Node tm = rev(head);

			slow.next = tm;

		}

		public Node rev(Node root) {

			Node pre = null;
			Node next = null;
			while (root != null) {
				next = root.next;
				root.next = pre;
				pre = root;
				root = next;
			}

			return pre;

		}

		Node slow;

		public void updateList(Node head, int i) {

			if (head == null) {
				return;
			}

			updateList(head.next, i + 1);

			if (i >= size / 2) {
				rr.val = rr.val + head.val;
				slow = rr;
				rr = rr.next;
			}

		}

	}

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(5);
		ll.addLast(11);
		ll.addLast(13);
		ll.addLast(14);
		ll.display();

		// ll.multiplyBy3();

		ll.updateList();

		ll.display();

//		ll.addAtIndex(70, 4);
//		ll.display();
//		ll.removeLast();
//		ll.display();
//		System.out.println(ll.getSize());
//		ll.removeFirst();
//		ll.display();
//		System.out.println(ll.getFirst());
//		System.out.println(ll.getLast());
//		System.out.println(ll.getSize());
//		System.out.println(ll.getAt(2));
//		ll.display();
//		ll.reverseIterative();
//		ll.display();
//		ll.reverse2();
//		ll.display();
//		ll.addFirst(90);
//		ll.addLast(47);
//		ll.display();
//		System.out.println(ll.getSize());
//		ll.removeAtIndex(3);
//		ll.display();
//		System.out.println(ll.kthFromLast(3));
//		ll.removeFirst();
//		System.out.println(ll.getMid());
//		ll.display();
//		ll.oddEven();
//		ll.display();
//		ll.addFirst(40);
//		ll.display();
//		ll.addAtIndex(67, 4);
//		ll.display();
//		ll.oddEven();
//		ll.display();
//		ll.kReverse(3);
//		ll.display();
//		ll.reverse3();
//		ll.display();
//		ll.reverse4();
//		ll.display();
//		System.out.println(ll.checkPalindrome());
//		ll.display();
//		ll.fold();
//		ll.display();
//
//		LinkedList l1 = new LinkedList();
//		l1.addFirst(9);
//		l1.addFirst(2);
//		l1.addFirst(4);
//		l1.addFirst(3);
//
//		LinkedList l2 = new LinkedList();
//		l2.addFirst(9);
//		l2.addFirst(2);
//		l2.addFirst(6);
//
//		LinkedList l3 = new LinkedList();
//
//		LinkedList l4 = l3.addTwoList(l1, l2);
//		l4.display();

	}

}
