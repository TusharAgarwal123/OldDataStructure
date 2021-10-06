package co.tushar.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxElementInRight {

	public static void main(String[] args) {

		int ar[] = { 5,4,10,26,6,16,9};
		Stack<Integer> st = new Stack<Integer>();
		List<Integer> list = new ArrayList<>();

		for (int i = ar.length - 1; i >= 0; i--) {

			if (st.isEmpty()) {
				list.add(ar[i]);
				st.push(ar[i]);
			}

			else if (st.size() > 0 && st.peek() <= ar[i]) {
				while (st.size() > 0 && st.peek() <= ar[i]) {
					st.pop();
				}
				if (st.size() == 0) {
					list.add(ar[i]);
					st.push(ar[i]);
				} else {
					list.add(st.peek());
				}
			} else if (st.size() > 0 && st.peek() > ar[i]) {

				list.add(st.peek());

			}

			if (st.peek() < ar[i]) {
				st.push(ar[i]);
			}

		}

		Collections.reverse(list);
		System.out.println(list);

	}

}
