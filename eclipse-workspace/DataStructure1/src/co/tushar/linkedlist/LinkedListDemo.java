package co.tushar.linkedlist;

import javax.print.attribute.standard.Sides;

public class LinkedListDemo {

	private Node head;
	private Node tail;
	private int size = 0;

	LinkedListDemo() {
		this.size = 0;
	}

	class Node {

		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void insertFirst(int value) {

		Node nd = new Node(value);

		nd.next = head;
		head = nd;
		size++;
		if (tail == null) {
			tail = head;
		}
	}

	public void insertLast(int value) {
		if (size == 0) {
			insertFirst(value);
			return;
		}
		Node nd = new Node(value);
		tail.next = nd;
		tail = nd;
		size++;
	}

	public int deleteFirst() throws Exception {
		if (size == 0) {
			throw new Exception("Empty LinkedList!!");
		}
		int value = head.data;
		head = head.next;
		size--;
		return value;
	}

	public int deleteLast() throws Exception {
		if (size == 0) {
			throw new Exception("Empty LinkedList!!");
		}
		if (size < 2) {
			return deleteFirst();
		}

		int value = tail.data;
		Node temp = head;
		while (temp.next != tail) {
			temp = temp.next;
		}
		tail = temp;
		tail.next = null;
		size--;
		return value;
	}

	public int deleteLast2() throws Exception {
		if (size == 0) {
			throw new Exception("Empty LinkedList!!");
		}
		if (size < 2) {
			return deleteFirst();
		}
		Node temp = get(size - 2);
		int value = temp.next.data;
		tail = temp;
		tail.next = null;
		size--;
		return value;

	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("END");
	}

	private Node get(int index) throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty!!");
		}
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index!!");
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void insertBetween(int value, int index) throws Exception {
		if (index == 0) {
			insertFirst(value);
			return;
		}
		if (index == size) {
			insertLast(value);
			return;
		}
		if (index > size || index < 0) {
			throw new Exception("You cannot insert at this position");
		}
		Node nd = new Node(value);
		Node temp = get(index - 1);
		nd.next = temp.next;
		temp.next = nd;
		size++;
	}

	public int deleteBetween(int index) throws Exception {
		if (index == 0) {
			return deleteFirst();
		}
		if (index == size - 1) {
			return deleteLast();
		}
		if (index >= size || index < 0) {
			throw new Exception("Error");
		}
		Node temp = get(index - 1);
		int value = temp.next.data;
		temp.next = temp.next.next;
		size--;
		return value;

	}

	public void find(int value) {
		Node temp = head;
		int c = 0;
		while (temp != null) {
			if (temp.data == value) {
				System.out.println(value + " is present in the list");
				c++;
				return;
			}
			temp = temp.next;
		}
		if (c == 0) {
			System.out.println(value + " is not present in the list");
		}

	}

	public int mid() {
		Node fast = head;
		Node slow = head;

		if (head == null) {
			return -1;
		}

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

	public Node mid2() {
		Node fast = head;
		Node slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public void reverse() {
		reverse(head);
	}

	private void reverse(Node node) {
		if (node == tail) {
			head = tail;
			return;
		}
		reverse(node.next);
		tail.next = node;
		tail = node;
		tail.next = null;
	}

	public void reverse2() {
		reverse2(head);
	}

	private void reverse2(Node node) {
		Node curr = node;
		Node pre = null;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		node = pre;
	}
	
	

	public void removeDuplicate() throws Exception {
		if (size == 0) {
			throw new Exception("Empty List!!");
		}
		if (size == 1) {
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == temp.next.data) {
				temp.next = temp.next.next;
				size--;
			} else {
				temp = temp.next;
			}
		}
		tail = temp;
	}

	public boolean check_loop() {
		return check_loop(head);
	}

	private boolean check_loop(Node head) {

		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;

	}

	public boolean compareLists(Node head1, Node head2) {

		while (head1 != null && head2 != null) {
			if (head1.data == head2.data) {
				head1 = head1.next;
				head2 = head2.next;
			} else {
				return false;
			}
		}
		return (head1 == null && head2 == null);

	}

	public void reverseItretively(Node head) throws Exception {

		int li = 0;
		int ri = size - 1;

		while (li < ri) {
			Node left = get(li);
			Node right = get(ri);
			int t = left.data;
			left.data = right.data;
			right.data = t;
			li++;
			ri--;
		}

	}

	public int kthFromLast(int k) {
		Node fast = head;
		Node slow = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast.next != null) { // when u count indexing from 0
			fast = fast.next;
			slow = slow.next;
		}
//		while(fast!=null) {  //when u count indexing from 1
//			fast=fast.next;
//			slow=slow.next;
//		}
		return slow.data;

	}

	public LinkedListDemo mergerLinkedList(LinkedListDemo first, LinkedListDemo second) {

		Node f = first.head;
		Node s = second.head;
		LinkedListDemo l = new LinkedListDemo();

		while (f != null && s != null) {
			if (f.data < s.data) {
				l.insertLast(f.data);
				f = f.next;
			}
			if (f.data == s.data) {
				l.insertLast(f.data);
				f = f.next;
			} else {
				l.insertLast(s.data);
				s = s.next;
			}
		}
		while (f != null) {
			l.insertLast(f.data);
			f = f.next;
		}
		while (s != null) {
			l.insertLast(s.data);
			s = s.next;
		}

		return l;
	}

	public LinkedListDemo mergeSort(LinkedListDemo list) {

		if (list.size == 1) {
			return list;
		}
		LinkedListDemo f = new LinkedListDemo();
		f.head = list.head;
		f.tail = list.mid2();
		f.size = (list.size) / 2;

		LinkedListDemo s = new LinkedListDemo();
		s.head = list.mid2().next;
		s.tail = list.tail;
		s.size = (list.size) / 2;

		list.mid2().next = null;

		f = mergeSort(f);
		s = mergeSort(s);

		return mergerLinkedList(f, s);

	}

	public static void main(String[] args) throws Exception {
		LinkedListDemo ln = new LinkedListDemo();
		ln.insertFirst(10);
		ln.insertFirst(20);
		ln.insertFirst(30);
		ln.insertLast(40);
		ln.insertLast(50);

		ln.insertLast(60);
		ln.display();
		ln.insertBetween(80, 3);
		ln.display();
		System.out.println(ln.kthFromLast(4));
		System.out.println(ln.size);

////		System.out.println(ln.deleteFirst());
////		System.out.println(ln.deleteFirst());
////		System.out.println(ln.deleteLast());
////		System.out.println(ln.deleteLast2());
////		System.out.println(ln.deleteLast());
//		ln.insertBetween(70, 0);
//		ln.display();
//		ln.insertBetween(80, 3);
//		ln.display();
//		ln.insertBetween(90, 5);
//		
//		ln.display();
//		ln.insertBetween(100, 9);
//		ln.display();
//	//	ln.insertBetween(110, 11);
//		System.out.println(ln.deleteBetween(4));
//	//	System.out.println(ln.deleteBetween(9));
//		ln.find(100);
//		ln.find(16);
//		ln.display();
//		ln.reverse();
//		ln.display();
//		System.out.println(ln.mid());
//		ln.insertBetween(100, 1);
//		ln.insertBetween(50, 3);
//		ln.insertLast(70);
//		ln.display();
//		ln.removeDuplicate();
//		ln.display();
//		System.out.println(ln.kthFromLast(4));

//		ln.insertLast(2);
//		ln.insertLast(4);
//		ln.insertLast(6);
//		ln.insertLast(8);
//		ln.display();
//
//		LinkedListDemo ln2 = new LinkedListDemo();
//
//		ln2.insertLast(1);
//		ln2.insertLast(3);
//		ln2.insertLast(5);
//		ln2.insertLast(6);
//		ln2.display();
//
//		ln2.mergerLinkedList(ln, ln2).display();
//		// LinkedListDemo ln3=ln2.mergerLinkedList(ln,ln2);
//		// ln3.display();
//
//		LinkedListDemo ln4 = new LinkedListDemo();
//		LinkedListDemo ln5 = new LinkedListDemo();
//		ln4.insertLast(2);
//		ln4.insertLast(6);
//		ln4.insertLast(3);
//		ln4.insertLast(1);
//		ln4.insertLast(5);
//		ln4.insertLast(4);
//		ln4.insertLast(7);
//
//		ln5.mergeSort(ln4).display();

	}

}
