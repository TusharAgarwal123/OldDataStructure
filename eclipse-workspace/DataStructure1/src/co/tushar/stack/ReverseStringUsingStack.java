package co.tushar.stack;

import java.util.Stack;

public class ReverseStringUsingStack {

	public static String reverseString(String str) {

		Stack<Character> st = new Stack<>();
		String ss = "";

		for (char c : str.toCharArray()) {
			st.push(c);
		}

		while (!st.isEmpty()) {
			ss = ss + st.pop();
		}
		return ss;

	}

	public static void main(String[] args) {

		System.out.println(reverseString("abcde"));

	}

}
