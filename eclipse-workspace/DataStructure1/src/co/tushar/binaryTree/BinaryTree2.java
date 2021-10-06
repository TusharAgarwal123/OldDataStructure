package co.tushar.binaryTree;

public class BinaryTree2 {

	static class Node {

		int val;
		Node left;
		Node right;

		Node(int data) {
			this.val = data;
			left = null;
			right = null;
		}

	}

	public static void main(String[] args) {

	}

	// we can do it using postorder traversal.
	public static Node deleteTree(Node root) {

		if (root == null) {
			return null;
		}

		root.left = deleteTree(root.left);
		root.right = deleteTree(root.right);
		
		System.out.println("Deleting Node " + root.val);
		root=null;
		return root;

	}

}
