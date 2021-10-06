package com.AdvanceRec3;

import java.util.HashSet;

import javax.swing.plaf.SliderUI;

public class WordsKSelection1 {

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

		solve(0, uni, 0, k, "");

	}

	public static void solve(int i, String uni, int ssf, int k, String ans) {

		if (i == uni.length()) {

			if (ssf == k) {
				System.out.println(ans);
			}

			return;
		}

		char ch = uni.charAt(i);
		solve(i + 1, uni, ssf + 1, k, ans + ch);
		solve(i + 1, uni, ssf, k, ans + "");

	}

}
