package co.tushar.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import co.tushar.stack.MaximumAreaHistogram.Pair;

public class MaximumAreaRectangleInBinaryMatrix {

	public static void main(String[] args) {

		int ar[][] = { { 1, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };

		int row = ar.length;
		int col = ar[0].length;

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < col; i++) {

			list.add(ar[0][i]);

		}

		int max = MAH(list);
		

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (ar[i][j] == 0) {
					list.set(j, 0);
				} else {

					list.set(j, list.get(j) + ar[i][j]);
				}
			}
			max = Math.max(max, MAH(list));
		}

		System.out.println(max);

	}

	public static int MAH(List<Integer> list) {

		List<Integer> left = getLeft(list);
		List<Integer> right = getRight(list);

		List<Integer> width = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {

			width.add(right.get(i) - left.get(i) - 1);

		}
		List<Integer> area = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			area.add(width.get(i) * list.get(i));
		}

		return Collections.max(area);

	}

	public static List<Integer> getLeft(List<Integer> ar) {

		List<Integer> list = new ArrayList<Integer>();

		Stack<Pair> st = new Stack<>();
		int pseudoIndex = -1;

		for (int i = 0; i < ar.size(); i++) {

			if (st.size() == 0) {
				list.add(pseudoIndex);
			} else if (st.size() > 0 && st.peek().first < ar.get(i)) {

				list.add(st.peek().second);

			}

			else if (st.size() > 0 && st.peek().first >= ar.get(i)) {
				while (st.size() > 0 && st.peek().first >= ar.get(i)) {
					st.pop();
				}

				if (st.size() == 0) {
					list.add(-1);
				} else {
					list.add(st.peek().second);
				}
			}

			st.push(new Pair(ar.get(i), i));

		}

		return list;

	}

	public static List<Integer> getRight(List<Integer> ar) {

		List<Integer> list = new ArrayList<Integer>();

		Stack<Pair> st = new Stack<>();
		int pseudoIndex = ar.size();

		for (int i = ar.size() - 1; i >= 0; i--) {

			if (st.size() == 0) {
				list.add(pseudoIndex);
			} else if (st.size() > 0 && st.peek().first < ar.get(i)) {

				list.add(st.peek().second);

			}

			else if (st.size() > 0 && st.peek().first >= ar.get(i)) {
				while (st.size() > 0 && st.peek().first >= ar.get(i)) {
					st.pop();
				}

				if (st.size() == 0) {
					list.add(ar.size());
					//list.add(-1);
				} else {
					list.add(st.peek().second);
				}
			}

			st.push(new Pair(ar.get(i), i));

		}

		Collections.reverse(list);

		return list;

	}

}
