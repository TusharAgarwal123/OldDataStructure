package com.AdvanceRec2;

import java.util.Stack;

public class DeleteMidEleOfStack {

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<>();
		st.push(2);
		st.push(6);
		st.push(1);
		st.push(16);
		st.push(4);
		st.push(15);

		System.out.println(st);

		int mid = (st.size() / 2) + 1;

		deleteMidEle(st, mid);
		System.out.println(st);

	}

	static void deleteMidEle(Stack<Integer> st, int mid) {

		if(mid==1) {
			st.pop();
			return;
		}
		
		int t=st.pop();
		deleteMidEle(st, mid-1);
		st.push(t);
		
	}

}
