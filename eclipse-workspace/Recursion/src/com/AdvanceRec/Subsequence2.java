package com.AdvanceRec;

import java.util.ArrayList;

public class Subsequence2 {

	public static void main(String[] args) {

		System.out.println(subsequence2("abd"));

	}

	static ArrayList<String> subsequence(String s1) {

		if (s1.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		char ch = s1.charAt(0);
		s1 = s1.substring(1);

		ArrayList<String> my = new ArrayList<String>();
		ArrayList<String> cur = subsequence(s1);

		for (int i = 0; i < cur.size(); i++) {
			my.add(cur.get(i));
			my.add(ch + cur.get(i));
		}
		return my;

	}

	static ArrayList<String> subsequence2(String s1) {

		if (s1.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		char ch = s1.charAt(0);

		ArrayList<String> my = new ArrayList<String>();
		ArrayList<String> cur = subsequence2(s1.substring(1));

		for (String str : cur) {
			if (!my.contains(str)) {  //for uniqueness.
				my.add(str);
			}
			if (!my.contains(ch + str)) {
				my.add(ch + str);
			}
		}

		return my;

	}

}
