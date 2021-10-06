package com.AdvanceRec3;

import java.util.HashMap;

public class PermutationsWords1 {

	/*
	 * 1. You are given a word (may have one character repeat more than once). 2.
	 * You are required to generate and print all arrangements of these characters.
	 * 
	 */

	public static void main(String[] args) {

		String str = "abab";

		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		find(1, str.length(), map, "");

	}

	public static void find(int i, int len, HashMap<Character, Integer> map, String ans) {

		if (i > len) {
			System.out.println(ans);
			return;
		}

		for (char ch : map.keySet()) {

			int fre = map.get(ch);
			if (fre > 0) {
				map.put(ch, fre - 1);
				find(i + 1, len, map, ans + ch);
				map.put(ch, fre);
			}

		}

	}

}
