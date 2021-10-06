package com.AdvanceRec3;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {

	/*
	 * 1. You are given a string and a pattern. 2. You've to check if the string is
	 * of the same structure as pattern without using any regular expressions.
	 * 
	 */

	public static void main(String[] args) {

		String str = "graphtreesgraph";
		String ptr = "pep";
		HashMap<Character, String> map = new HashMap<>();
		solve(str, ptr, map, ptr);

	}

	public static void solve(String str, String ptr, HashMap<Character, String> map, String op) {

		if (ptr.length() == 0) {
			if (str.length() == 0) {
				HashSet<Character> hs = new HashSet<>();
				for (char ch : op.toCharArray()) {
					if (hs.contains(ch)) {
						continue;
					}
					hs.add(ch);
					System.out.print(ch + "->" + map.get(ch) + ", ");
				}
				System.out.println(".");
			}
			return;
		}

		char ch = ptr.charAt(0);
		String rop = ptr.substring(1);
		if (map.containsKey(ch)) {

			String previousMapping = map.get(ch);
			if (str.length() >= previousMapping.length()) {
				String left = str.substring(0, previousMapping.length());
				String right = str.substring(previousMapping.length());
				if (previousMapping.equals(left)) {
					solve(right, rop, map, op);
				}
			}

		} else {
			for (int i = 0; i < str.length(); i++) {
				String left = str.substring(0, i + 1);
				String right = str.substring(i + 1);
				map.put(ch, left);
				solve(right, rop, map, op);
				map.remove(ch);
			}
		}

	}

}
