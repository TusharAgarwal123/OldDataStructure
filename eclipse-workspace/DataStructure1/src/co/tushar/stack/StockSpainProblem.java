package co.tushar.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import co.tushar.stack.NearestGreaterToLeftIndex.Pair;

//consecutive small or equal before it.
public class StockSpainProblem {

	static class Pair {

		int first; // store value.

		int second; // store index.

		Pair(int i, int j) {

			this.first = i;
			this.second = j;

		}

	}

	public static void main(String[] args) {

		int ar[] = {34,65,12,56,30,59};

		List<Integer> list = new ArrayList<Integer>();

		Stack<Pair> st = new Stack<>();

		for (int i = 0; i < ar.length; i++) {

			if (st.size() == 0) {
				list.add(-1);
			} else if (st.size() > 0 && st.peek().first > ar[i]) {

				list.add(st.peek().second);

			}

			else if (st.size() > 0 && st.peek().first <= ar[i]) {
				while (st.size() > 0 && st.peek().first <= ar[i]) {
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

		List<Integer> ans=new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			ans.add(i-list.get(i));
		}
		
		System.out.println(ans);
		
	}

}
