package com.tushar.Amazon;

import java.util.ArrayList;

public class StringSegmentation {

	/*
	 * you are given a list of string and a large string.you gave to find out
	 * whether the input string can be segmented into the words of given list.
	 */

	public static void main(String[] args) {

		ArrayList<String> ll = new ArrayList<>();
		String s = "hellonow";

		ll.add("hello");
		ll.add("hell");
		ll.add("on");
		ll.add("now");

		if (canSegmented(s, ll)) {
			System.out.println("String can be segmented");
		} else {
			System.out.println("String cannot be segmented");
		}

	}

	private static boolean canSegmented(String s, ArrayList<String> ll) {

		for (int i = 1; i <= s.length(); i++) {
			String first = s.substring(0, i);
			if (ll.contains(first)) {
				String second = s.substring(i);
				if (second.length() == 0 || ll.contains(second) || canSegmented(second, ll)) {
					return true;
				}
			}
		}

		return false;

	}

}
