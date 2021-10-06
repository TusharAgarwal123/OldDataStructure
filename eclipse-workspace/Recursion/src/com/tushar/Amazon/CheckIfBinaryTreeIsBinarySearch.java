package com.tushar.Amazon;

import java.util.ArrayList;

import com.tushar.Amazon.MaximumPathSum.Node;

public class CheckIfBinaryTreeIsBinarySearch {

	/*
	 * check weather a binary tree is binary search tree.
	 */

	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {

			this.data = data;
		}

	}

	public static boolean check(Node root) {

		ArrayList<Integer> list = new ArrayList<>();

		findInOrder(root, list);

		return isSorted(list, 0);

	}

	private static boolean isSorted(ArrayList<Integer> list, int i) {

		if (i == list.size()) {
			return true;
		}

		if (list.get(i) > list.get(i + 1)) {
			return false;
		}
		return isSorted(list, i + 1);

	}

	private static void findInOrder(Node root, ArrayList<Integer> list) {

		if (root == null) {
			return;
		}

		findInOrder(root.left, list);
		list.add(root.data);
		findInOrder(root.right, list);

	}

	public static void main(String[] args) {

	}

}
