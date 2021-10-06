package com.AdvanceRec3;

import java.util.HashSet;

public class WordsKLengthWords2 {

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
		
		solve(uni,1,k,new HashSet<>(),"");

	}

	public static void solve(String uni, int i, int k, HashSet set, String ans) {
		
		
		if(i>k) {
			System.out.println(ans);
			return;
		}
		
		for (int j = 0; j < uni.length(); j++) {
			char ch=uni.charAt(j);
			if(!set.contains(ch)) {
				set.add(ch);
				solve(uni, i+1, k, set, ans+ch);
				set.remove(ch);
			}
		}
		
	}

}
