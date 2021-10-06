package co.tushar.Important;

import java.util.ArrayList;
import java.util.List;

public class FindOneMisMatchString {

	/*
	 * given a string and array of strings,find whether the array contains a string
	 * with one character difference from the given string. find if an array
	 * contains a string with one mismatch
	 */

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("bana");
		list.add("apple");
		list.add("banabb");
		list.add("bonanzo");
		list.add("banamf");

		String s = "banana";

		System.out.println(check(list, s));

	}

	private static boolean check(List<String> list, String s) {

		if (list.size() == 0) {
			return false;
		}

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).length() == s.length()) {

				int c = 0;
				for (int j = 0; j < list.get(i).length(); j++) {

					if (s.charAt(j) != list.get(i).charAt(j)) {

						if (c == 0) {
							c++;
						} else {
							c++;
							break;
						}

					}

				}

				if (c == 1) {
					return true;
				}

			}

		}
		return false;

	}

}
