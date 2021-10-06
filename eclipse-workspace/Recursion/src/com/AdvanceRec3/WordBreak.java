package com.AdvanceRec3;

import java.util.ArrayList;
import java.util.Scanner;

public class WordBreak {

	/*
	 * 1. You are given n space separated strings, which represents a dictionary of
	 * words. 2. You are given another string which represents a sentence. 3. You
	 * have to print all possible sentences from the string, such that words of the
	 * sentence are present in dictionary.
	 */

	public static void main(String[] args) {

		int n = 11;
		ArrayList<String> list = new ArrayList<>();
		list.add("i");
		list.add("like");
		list.add("pep");
		list.add("coding");
		list.add("pepper");
		list.add("eating");
		list.add("mango");
		list.add("man");
		list.add("go");
		list.add("in");
		list.add("pepcoding");
		String str = "ilikepeppereatingmangoinpepcoding";
		solve(list, str, "");

	}

	public static void solve(ArrayList<String> list, String str, String ans) {

		if (str.isEmpty()) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i + 1);

			if (list.contains(left)) {
				String right = str.substring(i + 1);
				solve(list, right, ans + left + " ");
			}

		}

	}

}
