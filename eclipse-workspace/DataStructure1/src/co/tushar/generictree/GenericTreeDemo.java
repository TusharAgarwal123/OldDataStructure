package co.tushar.generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTreeDemo {
	private Node root;

	 class Node{
		private int data;
		private ArrayList<Node> children;
		Node(int value){
			this.data=value;
			this.children=new ArrayList<Node>();
		}
	}
	
	public void insert(Scanner sc) {
		System.out.println("Enter the value of root node");
		int val=sc.nextInt();
		this.root=new Node(val);
		insert(sc,root);
	}
	
	private void insert(Scanner sc,Node node) {
		while(true) {
		System.out.println("Do you want to add the child of node "+node.data);
		boolean val=sc.nextBoolean();
		if(val) {
			System.out.println("Enter the value");
			int n=sc.nextInt();
			Node child=new Node(n);
			node.children.add(child);
			insert(sc,child);
			
		}else {
			break;
		}
	}
	}
	
	public void display() {
		display(this.root," ");
	}
	private void display(Node node,String spc) {
		System.out.println(spc+node.data);
		for (int i = 0; i < node.children.size(); i++) {
			display(node.children.get(i),spc+"\t");
		}
	}
	
	public void preorder() {
		preorder(this.root);
	}
	private void preorder(Node node) {
		System.out.print(node.data+" ");
		for (int i = 0; i <node.children.size(); i++) {
			preorder(node.children.get(i));
		}
	}
	
	public void postorder() {
		postorder(this.root);
	}
	private void postorder(Node node) {
		
		for (int i = 0; i <node.children.size(); i++) {
			postorder(node.children.get(i));
		}
		System.out.print(node.data+" ");
	}
	
	public void levelorder() {
		levelorder(root);
	}
	private void levelorder(Node node) {
		
		Queue<Node> q=new LinkedList();
		q.add(node);
		while(!q.isEmpty()) {
			Node temp=q.remove();
			System.out.print(temp.data+",");
			
			for (int i = 0; i <temp.children.size(); i++) {
				q.add(temp.children.get(i));
			}
		}
		
	}
	
	public int count() {
		return count(root);
	}
	private int count(Node node) {
		
		int c=1;
		for (int i = 0; i < node.children.size(); i++) {
			c+=count(node.children.get(i));
		}
		return c;
		
	}
	
	public int maxValue() {
		return maxValue(root,root.data);
	}

	private int maxValue(Node node,int m) {
		
		for (int i = 0; i < node.children.size(); i++) {
			if(m<node.children.get(i).data) {
				m=maxValue(node.children.get(i),node.children.get(i).data);
			}
		}
		return m;
	}
	
	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int maxheight=0;
		for (int i = 0; i <node.children.size();i++) {
			int height=height(node.children.get(i));
			maxheight=Math.max(height, maxheight);
		}
		return maxheight+1;
	}

	public void eleAtdepthk(int k) {
		 eleAtdepthk(root,k);
	}
	private void eleAtdepthk(Node node, int k) {
		
		if(k==0) {
			System.out.println(node.data);
			return;
		}
		for (int i = 0; i < node.children.size(); i++) {
			eleAtdepthk(node.children.get(i), k-1);
		}
		
	}

	public static void main(String[] args) {
		
		GenericTreeDemo gt=new GenericTreeDemo();
		Scanner sc=new Scanner(System.in);
		gt.insert(sc);
		gt.display();
		gt.preorder();
		System.out.println();
		gt.postorder();
		System.out.println();
		gt.levelorder();
		System.out.println();
		System.out.println("No of node in tree is: "+gt.count());
		System.out.println("Max value in tree is: "+gt.maxValue());
		System.out.println("Height of tree is: "+gt.height());
		gt.eleAtdepthk(2);
		
	}

}
