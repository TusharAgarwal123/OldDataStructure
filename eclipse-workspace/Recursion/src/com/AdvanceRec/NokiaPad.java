
package com.AdvanceRec;

import java.util.ArrayList;

public class NokiaPad {

	public static void main(String[] args) {

//		System.out.println(nokiaPad2("013"));
		System.out.println(nokiaPad("012", ""));

	}

	static String[] keypad = { "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vw", "xyz" };

	static int nokiaPad(String s1, String ans) {

		if (s1.isEmpty()) {
			System.out.println(ans);
			return 1;
		}

		char ch = s1.charAt(0);
		int idx = ch - '0';
		String keyValues = keypad[idx];

		int c = 0;
		for (int i = 0; i < keyValues.length(); i++) {

			c += nokiaPad(s1.substring(1), ans + keyValues.charAt(i));
		}

		return c;

	}

	static ArrayList<String> nokiaPad2(String s1) {

		if (s1.isEmpty()) {

			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;

		}

		char ch = s1.charAt(0);
		int idx = ch - '0';
		String keyValues = keypad[idx];

		ArrayList<String> cur = nokiaPad2(s1.substring(1));
		ArrayList<String> my = new ArrayList<String>();

		for (String str : cur) {

			for (int i = 0; i < keyValues.length(); i++) {
				char chr = keyValues.charAt(i);
				my.add(chr + str);
			}

		}
		return my;

	}

}
