package co.tushar.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class BinaryTreeDemo {

	public static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

		int[] ar = { 1, 2, 4, -1, -1, -1, 3, -1, -1 };
		Node root = constructTree(ar);
		display(root);
		System.out.println(size(root));
		System.out.println(maximumElement(root));
		System.out.println(minimumElement(root));

		System.out.println(find(root, 2));
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		System.out.println(RootToNode(root, 8));
		for (Node e : list) {
			System.out.print(e.val + " ");
		}
		System.out.println("Diameter is: " + diameter(root));
		levelOrder(root);
		System.out.println();
		levelOrder2(root);
		System.out.println();
		System.out.println(countLeaves(root));
		System.out.println(height(root));
		deepestNode(root);
		mirrorTree(root);
		display(root);
		System.out.println(levelOrder3(root));
	}

	static int idx = 0;

	public static Node constructTree(int ar[]) {

		if (ar[idx] == -1 || idx >= ar.length) {
			idx++;
			return null;

		}

		Node root = new Node(ar[idx]);
		idx++;
		root.left = constructTree(ar);
		root.right = constructTree(ar);

		return root;

	}

	public static void display(Node root) {

		if (root == null) {
			return;
		}

		String ans = "";

		if (root.left != null) {
			ans += root.left.val;
		}
		ans += " <----";
		ans += root.val;
		ans += " ---->";
		if (root.right != null) {
			ans += root.right.val;
		}
		System.out.println(ans);
		display(root.left);
		display(root.right);

	}

	public static int size(Node root) {

		if (root == null) {
			return 0;
		}

		int leftSize = size(root.left);
		int rightSize = size(root.right);

		return leftSize + rightSize + 1;
	}

	public static int maximumElement(Node root) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int leftMaxEle = maximumElement(root.left);
		int rightMaxEle = maximumElement(root.right);

		return Math.max(leftMaxEle, Math.max(rightMaxEle, root.val));

	}

	public static int minimumElement(Node root) {

		if (root == null) {
			return Integer.MAX_VALUE;
		}

		int leftMinEle = minimumElement(root.left);
		int rightMinEle = minimumElement(root.right);

		return Math.min(leftMinEle, Math.min(rightMinEle, root.val));

	}

	public static int height(Node root) {

		if (root == null) {
			return -1; // on basis of edges.
			// return 0; on basis of nodes.
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return Math.max(leftHeight, rightHeight) + 1;

	}

	public static boolean find(Node root, int ele) {

		if (root == null)
			return false;

		return root.val == ele || find(root.left, ele) || find(root.right, ele);

	}

	public static void preOrder(Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	public static void preOrderWithoutUsingRecusion(Node root) {

		if (root == null) {
			return;
		}

		Stack<Node> st = new Stack<>();
		st.push(root);

		while (st.size() > 0) {

			Node t = st.pop();
			System.out.print(t.val + " ");

			if (t.right != null) {
				st.push(t.right);
			}

			if (t.left != null) {
				st.push(t.left);
			}

		}

	}

	public static void postOrder(Node root) {

		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");

	}

	public static void postOrderWithoutRecursion(Node root) {

		if (root == null) {
			return;
		}

		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();

		st1.push(root);

		while (st1.size() > 0) {

			Node t = st1.pop();

			if (t.left != null) {
				st1.push(t.left);
			}

			if (t.right != null) {
				st1.push(t.right);
			}

			st2.push(t);

		}

		while (st2.size() > 0) {
			System.out.print(st2.pop().val + " ");
		}

	}

	public static void inOrder(Node root) {

		if (root == null) {
			return;
		}

		preOrder(root.left);
		System.out.print(root.val + " ");
		preOrder(root.right);

	}

	public static void inOrderWithoutRecursion(Node root) {

		if (root == null) {
			return;
		}

		Stack<Node> st = new Stack<>();
		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (st.size() > 0) {

			Node t = st.pop();
			System.out.print(t.val + " ");

			if (t.right != null) {
				Node temp = t.right;
				while (temp != null) {
					st.push(temp);
					temp = temp.left;
				}
			}

		}

	}

	static ArrayList<Node> list = new ArrayList<>();

	public static boolean RootToNode(Node root, int destinationVal) {

		if (root == null) {
			return false;
		}
		if (root.val == destinationVal) {
			list.add(root);
			return true;
		}
		boolean res = RootToNode(root.left, destinationVal) || RootToNode(root.right, destinationVal);
		if (res) {
			list.add(root);
		}

		return res;
	}

	public static int diameter(Node root) {

		if (root == null) {
			return 0;
		}

		int leftDia = diameter(root.left);
		int rightDia = diameter(root.right);

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int myDia = leftHeight + rightHeight + 2;

		return Math.max(leftDia, Math.max(rightDia, myDia));
	}

	public static void levelOrder(Node root) {

		ArrayList<Node> pque = new ArrayList<>();
		ArrayList<Node> sque = new ArrayList<>();

		pque.add(root);
		while (pque.size() != 0) {

			Node frnt = pque.remove(0);
			System.out.print(frnt.val + " ");
			if (frnt.left != null) {
				sque.add(frnt.left);
			}
			if (frnt.right != null) {
				sque.add(frnt.right);
			}

			if (pque.size() == 0 && sque.size() != 0) {
				ArrayList<Node> temp = pque;
				pque = sque;
				sque = temp;
			}

		}

	}

	public static void levelOrder2(Node root) {

		Queue q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = (Node) q.remove();
			System.out.print(temp.val + " ");
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}

		}

	}

	public static List<List<Integer>> levelOrder3(Node root) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Queue q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {

			int size = q.size();
			List<Integer> ll = new ArrayList<>();

			for (int i = 0; i < size; i++) {

				Node temp = (Node) q.remove();
				ll.add(temp.val);

				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}

			result.add(ll);

		}
		return result;

	}

	public static int countLeaves(Node root) {

		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		int leftLeaves = countLeaves(root.left);
		int rightLeaves = countLeaves(root.right);
		return leftLeaves + rightLeaves;

	}

	public static void deepestNode(Node root) {

		int value = height(root);
		deepestNode(root, value);
	}

	private static void deepestNode(Node root, int value) {

		if (root == null) {
			return;
		}

		if (value >= 1) {
			deepestNode(root.left, value - 1);
			deepestNode(root.right, value - 1);
		} else if (value == 0) {
			System.out.println("Deepest Node is: " + root.val);
		}

	}

	public static void mirrorTree(Node root) {

		if (root == null) {
			return;
		}

		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTree(root.left);
		mirrorTree(root.right);

	}

	public static Node mirrorTree2(Node root) {

		if (root == null) {
			return null;
		}

		Node leftNode = mirrorTree2(root.left);
		Node rightNode = mirrorTree2(root.right);
		root.left = rightNode;
		root.right = leftNode;
		return root;

	}

	public static Node mergeTrees(Node t1, Node t2) {

		if (t1 != null && t2 == null) {

			return t1;

		}
		if (t1 == null && t2 != null) {

			return t2;

		}
		if (t1 == null && t2 == null) {

			return null;

		} else {
			t1.val = t1.val + t2.val;
		}

		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;

	}

	// mirror image of itself.
	public static boolean symmetric(Node root) {
		if (root == null) {
			return true;
		}
		return isMirrorImage(root, root);
	}

	public static boolean isMirrorImage(Node root1, Node root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (root1.val != root2.val)
			return false;

		return isMirrorImage(root1.left, root2.right) && isMirrorImage(root1.right, root2.left);

	}

	static int sum = 0;

	public static int sumOfLeftLeaves(Node root) {
		sumOfLeaves(root);
		return sum;
	}

	public static void sumOfLeaves(Node root) {

		if (root == null) {
			return;
		}

		if (isLeaf(root.left)) {
			sum += root.left.val;
		}

		sumOfLeaves(root.left);
		sumOfLeaves(root.right);

	}

	public static boolean isLeaf(Node root) {

		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {

			return true;

		}

		return false;

	}

	public static boolean hasPathSum(Node root, int sum) {

		if (root == null) {
			return false;
		}

		if (sum - root.val == 0) {
			if (root.left == null && root.right == null) {
				return true;
			}

		}

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

	}

	public Node lowestCommonAncestor(Node root, Node p, Node q) {

		if (root == null) {
			return null;
		}

		if (root.val > q.val && root.val > p.val) {

			return lowestCommonAncestor(root.left, p, q);

		}

		if (root.val < q.val && root.val < p.val) {

			return lowestCommonAncestor(root.right, p, q);

		}

		return root;

	}

	// all path from root to leaf.
	public List<String> binaryTreePaths(Node root) {

		List<String> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		process(root, "", list);

		return list;

	}

	public void process(Node root, String ans, List<String> list) {

		ans += root.val;
		if (root.left == null && root.right == null) {
			list.add(ans);
			return;
		}

		if (root.left != null) {
			process(root.left, ans + "->", list);
		}

		if (root.right != null) {
			process(root.right, ans + "->", list);
		}

	}

	// binary tree tilt
	int tilt = 0;

	public int findTilt(Node root) {

		traverse(root);
		return tilt;
	}

	public int traverse(Node root) {

		if (root == null) {
			return 0;
		}

		int left = traverse(root.left);
		int right = traverse(root.right);

		tilt += Math.abs(left - right);
		return left + right + root.val;

	}

	public boolean isSubtree(Node s, Node t) {

		if (t == null) {
			return false;
		}
		if (s == null) {
			return false;
		}

		if (isIdentical(s, t)) {
			return true;
		}

		return isSubtree(s.left, t) || isSubtree(s.right, t);

	}

	public boolean isIdentical(Node s, Node t) {

		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null) {
			return false;
		}

		if (s.val != t.val) {
			return false;
		}

		return isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
	}

	public List<Double> averageOfLevels(Node root) {
		List<Double> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		process(root, list);
		return list;
	}

	public List<Double> process(Node root, List<Double> list) {

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {

			int size = q.size();

			List<Integer> my = new ArrayList<>();

			for (int i = 0; i < size; i++) {

				Node temp = q.remove();
				my.add(temp.val);
				if (temp.left != null) {
					q.add(temp.left);
				}

				if (temp.right != null) {
					q.add(temp.right);
				}

			}

			double sum = 0;

			for (int i = 0; i < my.size(); i++) {
				sum += my.get(i);
			}

			sum = sum / my.size();

			list.add(sum);

		}

		return list;

	}

	// leetcode 993
	public boolean isCousins(Node root, int x, int y) {

		int l1 = depth(root, x, 0);
		int l2 = depth(root, y, 0);

		if (l1 != l2) {
			return false;
		}

		Node ans = LCA(root, x, y);

		if ((ans.left.val == x && ans.right.val == y) || (ans.left.val == y && ans.right.val == x)) {
			return false;
		}

		return true;

	}

	public Node LCA(Node root, int x, int y) {

		if (root == null) {
			return null;
		}

		if (root.val == x || root.val == y) {
			return root;
		}

		Node left = LCA(root.left, x, y);
		Node right = LCA(root.right, x, y);

		if (left != null && right != null) {
			return root;
		}

		return (left != null ? left : right);

	}

	public int depth(Node root, int x, int dis) {

		if (root == null) {
			return -1;
		}

		if (root.val == x) {
			return dis;
		}

		int d = depth(root.left, x, dis + 1);
		if (d != -1) {
			return d;
		}

		d = depth(root.right, x, dis + 1);

		return d;

	}

	// 1022 leetcode ,sum of root to leaf binary no.

	public int sumRootToLeaf(Node root) {

		List<String> list = new ArrayList<>();

		if (root == null) {
			return 0;
		}
		work(root, "", list);

		int sum = 0;

		for (String s : list) {

			int deci = Integer.parseInt(s, 2); // it will convert string to int and then in decimal.
			sum += deci;

		}

		return sum;

	}

	public void work(Node root, String ans, List<String> list) {

		ans += root.val;

		if (root.left == null && root.right == null) {
			list.add(ans);
			return;
		}

		if (root.left != null) {

			process(root.left, ans, list);

		}

		if (root.right != null) {

			process(root.right, ans, list);

		}

	}

	public boolean isUnivalTree(Node root) {

		if (root == null) {
			return true;
		}

		work2(root);

		if (set.size() > 1) {
			return false;
		}
		return true;

	}

	HashSet<Integer> set = new HashSet<>();

	public void work2(Node root) {

		if (root == null) {
			return;
		}

		set.add(root.val);

		work2(root.left);
		work2(root.right);

	}

	public boolean isUnivalTree2(Node root) {
		boolean l = root.left == null || root.left.val == root.val && isUnivalTree(root.left);
		boolean r = root.right == null || root.right.val == root.val && isUnivalTree(root.right);

		return l && r;
	}

	// leetcode 938.
	public int rangeSumBST(Node root, int L, int R) {

		if (root == null) {
			return 0;
		}

		Node newNode = Trim(root, L, R);
		int s = findSum(newNode);

		return s;

	}

	public int findSum(Node root) {

		if (root == null) {
			return 0;
		}

		int l = findSum(root.left);
		int r = findSum(root.right);

		return root.val + l + r;

	}

	public Node Trim(Node root, int L, int R) {

		if (root == null) {
			return null;
		}

		if (root.val > R) {
			return Trim(root.left, L, R);
		} else if (root.val < L) {
			return Trim(root.right, L, R);
		} else {

			root.left = Trim(root.left, L, R);
			root.right = Trim(root.right, L, R);
			return root;
		}

	}

	public int rangeSumBST2(Node root, int L, int R) {

		int sum = 0;
		if (root == null) {
			return sum;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {

			Node temp = q.remove();
			if (temp.val >= L && temp.val <= R) {
				sum += temp.val;
			}

			if (temp.left != null) {
				q.add(temp.left);
			}

			if (temp.right != null) {
				q.add(temp.right);
			}

		}

		return sum;
	}

	public Node increasingBST(Node root) {

		if (root == null) {
			return null;
		}

		Stack<Node> st = new Stack<>();

		Node head = null;
		Node cutt = null;
		Node temp = root;

		while (temp != null) {
			st.push(temp);
			temp = temp.left;
		}

		while (!st.isEmpty()) {

			Node temp2 = st.pop();
			if (head == null) {
				head = new Node(temp2.val);
				cutt = head;
			} else {

				cutt.right = new Node(temp2.val);
				cutt = cutt.right;

			}
			if (temp2.right != null) {
				st.push(temp2.right);
				temp2 = temp2.right;
				while (temp2.left != null) {

					st.push(temp2.left);
					temp2 = temp2.left;
				}
			}

		}
		return head;
	}

	// 872 leetcode
	public boolean leafSimilar(Node root1, Node root2) {

		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();

		findLeaves(root1, l1);
		findLeaves(root2, l2);

		if (l1.equals(l2)) {
			return true;
		}

		return false;
	}

	public void findLeaves(Node root, List<Integer> l) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			l.add(root.val);
			return;
		}

		findLeaves(root.left, l);
		findLeaves(root.right, l);

	}

	// lettcode 783.

	List<Integer> l = new ArrayList<>();

	public int minDiffInBST(Node root) {

		if (root == null) {
			return 0;
		}

		inOrder2(root);

		int min = Integer.MAX_VALUE;

		for (int i = 1; i < l.size(); i++) {

			min = Math.min(l.get(i) - l.get(i - 1), min);

		}
		return min;

	}

	public void inOrder2(Node root) {

		if (root == null) {
			return;
		}

		inOrder2(root.left);
		l.add(root.val);
		inOrder2(root.right);

	}

	// leetcode 700 search in bst.
	public Node searchBST(Node root, int val) {

		if (!isFind(root, val)) {

			return null;
		}

		return search(root, val);

	}

	public Node search(Node root, int val) {

		if (root.val > val) {

			return search(root.left, val);

		} else if (root.val < val) {

			return search(root.right, val);

		} else if (root.val == val) {

			return root;

		}
		return null;

	}

	public boolean isFind(Node root, int val) {

		if (root == null) {
			return false;
		}

		if (root.val == val) {
			return true;
		}

		return isFind(root.left, val) || isFind(root.right, val);

	}

	public Node searchBST2(Node root, int val) {

		if (root == null)
			return null;

		if (root.val == val)
			return root;

		if (root.val > val) {

			return searchBST(root.left, val);
		} else {

			return searchBST(root.right, val);
		}

	}

	// leetcode 687 longest univalue path.
	int max = 0;

	public int longestUnivaluePath(Node root) {

		findPath(root);
		return max;

	}

	public int findPath(Node root) {

		if (root == null) {
			return 0;
		}

		int left = findPath(root.left);
		int right = findPath(root.right);

		if (root.left != null && root.val == root.left.val) {
			left += 1;
		} else {
			left = 0;
		}

		if (root.right != null && root.val == root.right.val) {
			right += 1;
		} else {
			right = 0;
		}

		max = Math.max(max, left + right);

		return Math.max(left, right);

	}

	// 671 leetcode second minimum node in binary tree.
	Set<Integer> set2 = new TreeSet<>();

	public int findSecondMinimumValue(Node root) {

		if (root == null) {
			return 0;
		}

		checkSecondMinimum(root);

		if (set2.size() == 1) {
			return -1;
		}
		int c = 0;
		for (int i : set2) {

			if (c == 1) {
				return i;
			}
			c++;

		}
		return -1;

	}

	public void checkSecondMinimum(Node root) {

		if (root == null) {
			return;
		}

		checkSecondMinimum(root.left);
		set2.add(root.val);
		checkSecondMinimum(root.right);

	}

	// leetcode 653.

	public boolean findTarget(Node root, int k) {

		if (root == null) {
			return false;
		}

		Set<Integer> set = new HashSet<>();

		return homeWork(root, k, set);

	}

	public boolean homeWork(Node root, int k, Set<Integer> set) {

		if (root == null) {
			return false;
		}

		if (set.contains(root.val)) {

			return true;

		}

		set.add(k - root.val);

		return homeWork(root.left, k, set) || homeWork(root.right, k, set);

	}

	// leetcode 538.
	int s = 0;

	public Node convertBST(Node root) {

		if (root == null) {

			return null;

		}

		convertBST(root.right);
		s += root.val;
		root.val = s;

		convertBST(root.left);

		return root;

	}

	// check if binary tree is binary search tree.
	public boolean checkBST(Node root) {

		if (root == null) {
			return true;
		}

		if (root.left != null && root.left.val > root.val) {
			return false;
		}

		if (root.right != null && root.right.val < root.val) {
			return false;
		}

		if (!checkBST(root.left) || !checkBST(root.right)) {
			return false;
		}

		return true;

	}

	// leetcode 108 convert sorted array to bst.
	public Node sortedArrayToBST(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}

		return constructBST(nums, 0, nums.length - 1);

	}

	private Node constructBST(int[] nums, int left, int right) {

		if (left > right) {

			return null;

		}

		int mid = left + (right - left) / 2;
		Node curr = new Node(nums[mid]);
		curr.left = constructBST(nums, left, mid - 1);
		curr.right = constructBST(nums, mid + 1, right);

		return curr;

	}

	// leetcode 111 minimum depth of binary tree.
	public int minDepth(Node root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		int left = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;

		int right = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

		return Math.min(left, right) + 1;

	}

	public void printAtGivenLevel(Node root, int level) {

		if (root == null) {
			return;
		}

		if (level == 0) {
			System.out.print(root.val + " ");
			return;
		}

		printAtGivenLevel(root.left, level - 1);
		printAtGivenLevel(root.right, level - 1);

	}

	// this is good approach ,becoz it takes O(n^2).
	public void levelOrderTraversalUsingRecursion(Node root) {

		if (root == null) {
			return;
		}

		int level = height(root);
		for (int i = 0; i <= level; i++) {

			printAtGivenLevel(root, i);
			System.out.println();

		}

	}

	public void reverseLevelOrderTraversalUsingRecursion(Node root) {

		if (root == null) {
			return;
		}

		int level = height(root);
		for (int i = level; i >= 0; i--) {

			printAtGivenLevel(root, i);
			System.out.println();

		}

	}

	public void reverseLevelOrderTraversal2(Node root) {

		if (root == null) {
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Stack<Node> st = new Stack<>();
		while (!q.isEmpty()) {

			Node t = q.remove();

			if (t.right != null) {
				q.add(t.right);
			}

			if (t.left != null) {
				q.add(t.left);
			}

			st.push(t);

		}

		while (st.size() > 0) {
			System.out.print(st.pop().val + " ");
		}

	}

	public void leftViewOfTree(Node root) {

		if (root == null) {
			return;
		}

		print(root, 0);

	}

	int m = 0;

	private void print(Node root, int i) {

		if (root == null) {
			return;
		}

		if (i >= m) {
			System.out.print(root.val + " ");
			m++;
		}
		print(root.left, i + 1);
		print(root.right, i + 1);

	}

	public void rightViewOfTree(Node root) {

		if (root == null) {
			return;
		}

		print2(root, 0);

	}

	int m2 = 0;

	private void print2(Node root, int i) {

		if (root == null) {
			return;
		}

		if (i >= m2) {
			System.out.print(root.val + " ");
			m2++;
		}
		print(root.right, i + 1);
		print(root.left, i + 1);

	}

}
