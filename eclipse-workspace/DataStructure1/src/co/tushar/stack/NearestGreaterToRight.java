package co.tushar.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToRight {

	public static void main(String[] args) {

		int ar[] = { 1, 2, 4, 3, 6 };

		List<Integer> list = new ArrayList<>();

		Stack<Integer> st = new Stack<>();

		for (int i = ar.length - 1; i >= 0; i--) {

			if (st.isEmpty()) {
				list.add(-1);
			}

			else if (st.size() > 0 && st.peek() > ar[i]) {

				list.add(st.peek());
			}

			else if (st.size() > 0 && st.peek() <= ar[i]) {

				while (st.size() > 0 && st.peek() <= ar[i]) {
					st.pop();
				}
				if (st.size() == 0) {
					list.add(-1);
				}

				else {
				list.add(st.peek());
				}

			}

			st.push(ar[i]);

		}
		
		
		Collections.reverse(list);
		System.out.println(list);

	}

}
