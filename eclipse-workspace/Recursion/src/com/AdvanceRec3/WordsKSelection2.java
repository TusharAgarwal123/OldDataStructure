package com.AdvanceRec3;

import java.util.HashSet;

public class WordsKSelection2 {

	/*
	 * 1. You are given a word (may have one character repeat more than once). 2.
	 * You are given an integer k. 2. You are required to generate and print all
	 * ways you can select k distinct characters out of the word.
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

		solve(uni, 1, k, -1, "");

	}

	public static void solve(String uni, int i, int k, int lc, String ans) {

		if (i > k) {
			System.out.println(ans);
			return;
		}

		for (int j = lc + 1; j < uni.length(); j++) {

			char ch = uni.charAt(j);
			solve(uni, i + 1, k, j, ans + ch);

		}

	}

}
