package co.tushar.stack;

import java.util.Stack;

public class EvaluationOfPostfix {

	public static void main(String[] args) {

		System.out.println(solve("23+1-"));

	}

	public static int solve(String s) {

		Stack<Integer> st = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch >= '0' && ch <= '9') {
				st.push((int) (ch - '0'));
			} else {
				int x = st.pop();
				int y = st.pop();
				switch (ch) {
				case '+':
					st.push(x + y);
					break;

				case '-':
					st.push(x - y);
					break;

				case '*':
					st.push(x * y);
					break;

				case '/':
					st.push(x / y);
					break;
				}
			}
		}
		return st.pop();

	}

}
