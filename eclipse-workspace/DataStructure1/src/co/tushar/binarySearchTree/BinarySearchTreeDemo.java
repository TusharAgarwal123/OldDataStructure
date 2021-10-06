package co.tushar.binarySearchTree;

public class BinarySearchTreeDemo {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node insert(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}

		if (val < root.data) {
			root.left = insert(root.left, val);
		} else if (val > root.data) {
			root.right = insert(root.right, val);
		}

		return root;
	}

	public static Node delete(Node root, int val) {

		if (root == null) {
			return null;
		}

		if (val < root.data) {
			root.left = delete(root.left, val);
		} else if (val > root.data) {
			root.right = delete(root.right, val);
		} else {
			if (root.left == null || root.right == null) {
				Node temp = null;
				temp = root.left == null ? root.right : root.left;

				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successor = getSuccessor(root); // inorder successor
				root.data = successor.data;
				root.right = delete(root.right, successor.data);
				return root;
			}
		}

		return root;

	}

	public static Node getSuccessor(Node root) {

		if (root == null) {
			return null;
		}
		Node temp = root.right;
		while (temp.left != null) {
			temp = temp.left;
		}

		return temp;

	}

	public static void print(Node root) {
		if (root == null) {
			return;
		}

		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);
	}

	public static void main(String[] args) {

		Node root = null;
		root = insert(root, 10);
		root = insert(root, 15);
		root = insert(root, 5);
		root = insert(root, 18);
		print(root);
		

	}

}
