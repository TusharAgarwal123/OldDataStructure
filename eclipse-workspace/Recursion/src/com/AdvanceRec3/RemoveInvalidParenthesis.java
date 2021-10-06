package com.AdvanceRec3;

import java.util.HashSet;
import java.util.Stack;

public class RemoveInvalidParenthesis {

	/*
	 * 1. You are given a string, which represents an expression having only opening
	 * and closing parenthesis. 2. You have to remove minimum number of parenthesis
	 * to make the given expression valid. 3. If there are multiple answers, you
	 * have to print all of them.
	 */

	public static void main(String[] args) {

		String str = "()(())))(()";

		int min = getMin(str);
		solve(str, min, new HashSet<>());

	}

	public static void solve(String str, int min, HashSet set) {

		if (min == 0) {
			int mno = getMin(str);
			if (mno == 0) {
				if (!set.contains(str)) {
					System.out.println(str);
					set.add(str);
				}
			}
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			String ros = str.substring(0, i) + str.substring(i + 1);
			solve(ros, min - 1, set);
		}

	}

	// return count of min no of parenthesis you have to remove.
	public static int getMin(String str) {

		Stack<Character> st = new Stack<>();
		for (char ch : str.toCharArray()) {

			if (ch == '(') {
				st.push(ch);
			} else if (ch == ')' && st.size() == 0) {
				st.push(ch);
			} else if (ch == ')' && st.peek() == ')') {
				st.push(ch);
			} else {
				st.pop();
			}

		}
		return st.size();

	}

}
