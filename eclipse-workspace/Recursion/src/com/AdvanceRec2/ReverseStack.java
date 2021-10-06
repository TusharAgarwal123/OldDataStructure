package com.AdvanceRec2;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<>();
		st.push(2);
		st.push(6);
		st.push(1);
		st.push(16);
		st.push(4);
		st.push(15);

		System.out.println(st);

		reverse(st);
		System.out.println(st);

	}

	static void reverse(Stack<Integer> st) {

		if(st.size()==0) {
			return;
		}
		
		int t=st.pop();
		reverse(st);
		insertAtLast(st,t);
		
	}

	static void insertAtLast(Stack<Integer> st, int k) {
		
		if(st.size()==0) {
			st.push(k);
			return;
		}
		
		int t=st.pop();
		insertAtLast(st, k);
		st.push(t);
		
	}

}
