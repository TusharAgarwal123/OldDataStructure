package co.tushar.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import co.tushar.stack.NearestSmallestToLeftIndex.Pair;

public class MaximumAreaHistogram {

	static class Pair {

		int first; // store value.

		int second; // store index.

		Pair(int i, int j) {

			this.first = i;
			this.second = j;

		}

	}

	public static void main(String[] args) {

		int ar[] = { 6, 2, 5, 4, 5, 1, 6 };

		List<Integer> left = getLeft(ar);
		List<Integer> right = getRight(ar);

		List<Integer> width = new ArrayList<Integer>();
		for (int i = 0; i < ar.length; i++) {

			width.add(right.get(i) - left.get(i) - 1);

		}
		List<Integer> area = new ArrayList<Integer>();
		for (int i = 0; i < ar.length; i++) {
			area.add(width.get(i) * ar[i]);
		}

		System.out.println(Collections.max(area));

	}

	public static List<Integer> getLeft(int[] ar) {

		List<Integer> list = new ArrayList<Integer>();

		Stack<Pair> st = new Stack<>();
		int pseudoIndex = -1;

		for (int i = 0; i < ar.length; i++) {

			if (st.size() == 0) {
				list.add(pseudoIndex);
			} else if (st.size() > 0 && st.peek().first < ar[i]) {

				list.add(st.peek().second);

			}

			else if (st.size() > 0 && st.peek().first >= ar[i]) {
				while (st.size() > 0 && st.peek().first >= ar[i]) {
					st.pop();
				}

				if (st.size() == 0) {
					list.add(-1);
				} else {
					list.add(st.peek().second);
				}
			}

			st.push(new Pair(ar[i], i));

		}

		return list;

	}

	public static List<Integer> getRight(int[] ar) {

		List<Integer> list = new ArrayList<Integer>();

		Stack<Pair> st = new Stack<>();
		int pseudoIndex = ar.length;

		for (int i = ar.length - 1; i >= 0; i--) {

			if (st.size() == 0) {
				list.add(pseudoIndex);
			} else if (st.size() > 0 && st.peek().first < ar[i]) {

				list.add(st.peek().second);

			}

			else if (st.size() > 0 && st.peek().first >= ar[i]) {
				while (st.size() > 0 && st.peek().first >= ar[i]) {
					st.pop();
				}

				if (st.size() == 0) {
					list.add(ar.length);
					// list.add(-1);
				} else {
					list.add(st.peek().second);
				}
			}

			st.push(new Pair(ar[i], i));

		}

		Collections.reverse(list);

		return list;

	}

}
