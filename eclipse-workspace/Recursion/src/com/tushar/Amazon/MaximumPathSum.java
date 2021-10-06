package com.tushar.Amazon;

public class MaximumPathSum {

	// from any node to any node.

	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {

			this.data = data;
		}

	}

	// this will find max sum from any node to any node.
	// res will initially store the Integer.MIN.VALUE.
	public static int MaxPathSum(Node root, int res) {

		if (root == null) {
			return 0;
		}

		int left = MaxPathSum(root.left, res);
		int right = MaxPathSum(root.right, res);

		int temp = Math.max(Math.max(left, right) + root.data, root.data);
		int ans = Math.max(temp, left + right + root.data);
		res = Math.max(res, ans);

		return res;

	}

	// this will find max sum from any leaf to any leaf.
	// res will initially store the Integer.MIN.VALUE.
	public static int MaxPathSum2(Node root, int res) {

		if (root == null) {
			return 0;
		}

		int left = MaxPathSum(root.left, res);
		int right = MaxPathSum(root.right, res);

		int temp = Math.max(left, right) + root.data;
		if (root.left == null && root.right == null) {
			temp = Math.max(temp, root.data);
		}

		int ans = Math.max(temp, left + right + root.data);
		res = Math.max(res, ans);

		return res;

	}

	public static void main(String[] args) {

	}

}
