package co.tushar.stack;

import java.util.Stack;

public class GetMin2 {

	// without using extra space.

	static Stack<Integer> st = new Stack<Integer>();
	static int minEle = 0;

	public static void main(String[] args) {

		push(5);
		push(7);
		System.out.println(getMin());
		System.out.println(top());
		pop();
		System.out.println(top());
		System.out.println(minEle);
		push(3);
		System.out.println(minEle);
		System.out.println(top());
		pop();
		System.out.println(minEle);
		System.out.println(top());

	}

	public static int top() {
		if (st.size() == 0) {
			return -1;
		} else {
			if (st.peek() >= minEle) {
				return st.peek();
			} else {
				return minEle;
			}
		}
	}

	public static int pop() {

		if (st.size() == 0) {
			return -1;
		} else {
			if (st.peek() >= minEle) {
				return st.pop();
			} else {
				minEle = 2 * minEle - st.peek();
				return top();
			}
		}

	}

	public static void push(int x) {
		if (st.size() == 0) {
			st.push(x);
			minEle = x;
		} else {
			if (x >= minEle) {
				st.push(x);
			} else {
				st.push(x * 2 - minEle);
				minEle = x;
			}
		}
	}

	public static int getMin() {
		if (st.size() == 0) {
			return -1;
		}
		return minEle;
	}

}
