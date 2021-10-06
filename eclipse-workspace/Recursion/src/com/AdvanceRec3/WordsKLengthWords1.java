package com.AdvanceRec3;

import java.util.HashSet;

public class WordsKLengthWords1 {

	/*
	 * 1. You are given a word (may have one character repeat more than once). 2.
	 * You are given an integer k. 3. You are required to generate and print all k
	 * length words (of distinct chars) by using chars of the word.
	 */

	public static void main(String[] args) {

		String str = "aabbbccdde";
		int k = 3;

		HashSet<Character> set = new HashSet<>();
		String uni = "";
		for (char ch : str.toCharArray()) {

			if (!set.contains(ch)) {
				set.add(ch);
				uni += ch;
			}

		}

		Character ch[] = new Character[k];
		solve(0, uni, 0, k, ch);

	}

	public static void solve(int i, String uni, int ssf, int k, Character[] ch) {

		if (i == uni.length()) {
			if (ssf == k) {
				for (int j = 0; j < ch.length; j++) {
					System.out.print(ch[j]);
				}
				System.out.println();
			}
			return;
		}

		char c = uni.charAt(i);

		for (int j = 0; j < ch.length; j++) {
			if (ch[j] == null) {
				ch[j] = c;
				solve(i + 1, uni, ssf + 1, k, ch);
				ch[j] = null;
			}
		}

		solve(i + 1, uni, ssf, k, ch);

	}

}
