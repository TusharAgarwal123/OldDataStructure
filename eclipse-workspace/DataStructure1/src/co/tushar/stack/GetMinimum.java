package co.tushar.stack;

import java.util.Stack;

public class GetMinimum {

	static Stack<Integer> s=new Stack<Integer>();
	static Stack<Integer> ss=new Stack<Integer>(); //it will store minimum ele.
	
	public static void main(String[] args) {
		
		
		push(1);
		push(4);
		push(7);
		System.out.println(getMin());
		pop();
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		push(6);
		push(8);
		System.out.println(getMin());
		push(3);
		System.out.println(getMin());
	}
	
	public static void push(int x) {
		
		s.push(x);
		if(ss.size()==0 || x<=ss.peek()) {
			ss.push(x);
		}
		
	}
	public static int pop() {
		
		if(s.size()==0) {
			return -1;
		}
		
		int y=s.peek();
		s.pop();
		if(ss.peek()==y) {
			ss.pop();
		}
		return y;
		
	}
	
	public static int getMin() {
		if(ss.size()==0) {
			return -1;
		}
		return ss.peek();
	}
	
}
