package co.tushar.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeAdvance {

	public static class Node {

		int val;
		Node left;
		Node right;
		Node next;

		Node(int val) {
			this.val = val;
		}

	}

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, 8, 9, -1, -1, -1, -1 };
		Node root = constructTree(ar);
		verticalOrder(root);
		topView(root);

	}

	private static void topView(Node root) {

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		List<Integer> list = new ArrayList<>();
		while (!q.isEmpty()) {

			Node temp = q.remove();
			list.add(temp.val);
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}

		}

		Map<Integer, List<Integer>> map = verticalOrder(root);
		for (Entry<Integer, List<Integer>> en : map.entrySet()) {

			if (en.getValue().size() == 1) {
				System.out.print(en.getValue().get(0) + " ");
			} else {

				int min = Integer.MAX_VALUE;
				for (int i = 0; i < en.getValue().size(); i++) {
					int ele = en.getValue().get(i);
					int idx = list.indexOf(ele);
					min = Math.min(idx, min);
				}

				System.out.print(list.get(min) + " ");

			}
		}

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

	public static Map<Integer, List<Integer>> verticalOrder(Node root) {

		Map<Integer, List<Integer>> map = new HashMap<>();
		int hd = 0;

		verticalTraversal(root, map, hd);
		for (Entry<Integer, List<Integer>> en : map.entrySet()) {

			System.out.println(en.getValue());

		}

		return map;

	}

	private static void verticalTraversal(Node root, Map<Integer, List<Integer>> map, int hd) {

		if (root == null) {
			return;
		}

		List<Integer> ll = map.get(hd);
		if (ll == null) {
			ll = new ArrayList<Integer>();
			ll.add(root.val);
		} else {
			ll.add(root.val);
		}

		map.put(hd, ll);
		verticalTraversal(root.left, map, hd - 1);
		verticalTraversal(root.right, map, hd + 1);

	}

	// leetcode 105. tree from pre and in order

	int id = 0;

	public Node buildTree(int[] preorder, int[] inorder) {

		return build(preorder, inorder, 0, preorder.length - 1);

	}

	public Node build(int[] pre, int[] in, int s, int e) {

		if (s > e) {
			return null;
		}

		Node root = new Node(pre[id++]);

		if (s == e) {

			return root;

		}

		int index = search(in, s, e, root.val);

		root.left = build(pre, in, s, index - 1);
		root.right = build(pre, in, index + 1, e);
		return root;

	}

	public int search(int[] in, int s, int e, int val) {

		int i;
		for (i = s; i <= e; i++) {

			if (in[i] == val) {
				break;
			}

		}
		return i;

	}

	int idxx = 0;
	HashMap<Integer, Integer> map = new HashMap<>();

	public Node buildTree2(int[] preorder, int[] inorder) {

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return build2(preorder, inorder, 0, preorder.length - 1);

	}

	public Node build2(int[] pre, int[] in, int s, int e) {

		if (s > e) {
			return null;
		}

		Node root = new Node(pre[idxx++]);

		if (s == e) {

			return root;

		}

		int index = map.get(root.val);

		root.left = build(pre, in, s, index - 1);
		root.right = build(pre, in, index + 1, e);
		return root;

	}
	
	//leetcode pathSum2
	public List<List<Integer>> pathSum(Node root, int sum) {
        
	       List<List<Integer>> list=new ArrayList<>();
	       
	       findAllPath(root,sum,new ArrayList<Integer>(),list);
	        
	       return list;
	        
	    }
	    
	    public void findAllPath(Node root,int sum,List<Integer> cur,List<List<Integer>> list){
	        
	        if(root==null){
	            return;
	        }
	        
	        cur.add(root.val);
	        if(sum==root.val && (root.left==null && root.right==null)){
	            list.add(cur);
	            return;
	        }
	        
	        
	        findAllPath(root.left,sum-root.val,new ArrayList<Integer>(cur),list);
	         findAllPath(root.right,sum-root.val,new ArrayList<Integer>(cur),list);
	    }
	
	    
	    //leetcode 129
	    
	    public int sumNumbers(Node root) {
	        
	        int sum=0;
	       
	        List<String> list=new ArrayList<>();
	        
	        findPath(root,"",list);
	        
	        for(String s:list){
	            
	            sum+=Integer.parseInt(s);
	            
	        }
	        
	        
	        return sum;
	        
	    }
	    
	    public void findPath(Node root,String ans,List<String> list){
	        
	        if(root==null){
	            return;
	        }
	        
	        ans+=root.val;
	        if(root.left==null && root.right==null){
	            list.add(ans);
	            return;
	        }
	        
	        findPath(root.left,ans,list);
	        findPath(root.right,ans,list);
	        
	    }
	    
	    
	    //leetcode 114.
	    public void flatten(Node root) {
	        
	        if(root==null){

	           return;
	        
	        }
	        
	        Stack<Node > st=new Stack<>();
	        st.push(root);
	        while(!st.isEmpty()){
	            
	           Node temp=st.pop();
	            
	             if(temp.right!=null){
	                st.push(temp.right);
	            }
	            
	            if(temp.left!=null){
	                st.push(temp.left);
	            }
	            
	            if(!st.isEmpty()){
	                temp.right=st.peek();
	            }
	            
	            temp.left=null;
	           
	            
	        }
	        
	    }
	    
	    //leetcode 116
	    public Node connect(Node root) {
	        
	        if(root==null){
	            return null;
	        }
	       Queue<Node> q1=new LinkedList<>();
	       Queue<Node> q2=new LinkedList<>();
	        
	       q1.add(root);
	       while(!q1.isEmpty()){
	           
	           Node temp=q1.remove();
	           if(!q1.isEmpty()){
	               temp.next=q1.peek();
	           }else{
	              temp.next=null;
	           }
	           
	           if(temp.left!=null){
	               q2.add(temp.left);
	           }
	           
	           if(temp.right!=null){
	               q2.add(temp.right);
	           }
	           
	           if(q1.isEmpty()){
	               
	               Queue<Node> t=q1;
	               q1=q2;
	               q2=t;
	               
	           }
	       }
	        
	        return root;
	       
	    }
	    
	    //leetcode 230.
	    //kth smallest ele in bst.
	    List<Integer> list=new ArrayList<>();
	    public int kthSmallest(Node root, int k) {
	        
	        
	        if(root==null){
	            return 0;
	        }
	        
	        findInorder(root);
	        
	        return list.get(k-1);
	        
	    }
	    
	    public void findInorder(Node root){
	        
	        if(root==null){
	            return;
	        }
	        
	        findInorder(root.left);
	        list.add(root.val);
	         findInorder(root.right);
	        
	    }
	    
	    //leetcode 199
	    
	    
	    List<Integer> li=new ArrayList<>();
	    public List<Integer> rightSideView(Node root) {
	        
	        if(root==null){
	            return li;
	        }
	        
	        Queue<Node> q=new LinkedList<>();
	        Queue<Node> q2=new LinkedList<>();
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            
	            Node temp=q.remove();
	            if(q.isEmpty()){

	              li.add(temp.val);
	                
	            }
	            
	            if(temp.left!=null){
	                q2.add(temp.left);
	            }
	            
	            
	            if(temp.right!=null){
	                q2.add(temp.right);
	            }
	            
	            if(q.isEmpty()){
	                
	                Queue<Node> t=q;
	                q=q2;
	                q2=t;
	                
	            }
	            
	            
	        }
	        
	        return li;
	        
	    }
	    
	    //437.path sum 3.
	    
	    int c=0;
	    List<Integer> list1=new ArrayList<>();
	    public int pathSum3(Node root, int sum) {
	        
	        if(root==null){
	            return c;
	        }
	        
	        getSum(root,sum);
	        
	        return c;
	        
	    }
	    
	    public void getSum(Node root,int sum){
	        
	        if(root==null){
	            return;
	        }
	        
	        list1.add(root.val);
	        getSum(root.left,sum);
	        getSum(root.right,sum);
	        
	        int t=0;
	        for(int i=list1.size()-1;i>=0;i--){
	            
	            t+=list1.get(i);
	            if(t==sum){
	                c++;
	            }
	            
	        }
	        list1.remove(list1.size()-1);
	        
	    }
	

}
