package com.AdvanceRec2;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBalancedParenthesis {

	// you will be given an n,you have to generate n balanced parenthesis.
	// n=2,{()(),(())}
	public static void main(String[] args) {

		System.out.println(generateParenthesis(3));

	}

	static List<String> generateParenthesis(int n) {

		List<String> list = new ArrayList<>();

		int open = n;
		int close = n;

		String ans = "";

		solve(open, close, ans, list);
		return list;

	}

	static void solve(int open, int close, String ans, List<String> list) {

		if (open == 0 && close == 0) {
			list.add(ans);
			return;
		}

		if (open != 0) {

			solve(open - 1, close, ans + "(", list);

		}
		if (close > open) {
			solve(open, close - 1, ans + ")", list);
		}

	}

}
