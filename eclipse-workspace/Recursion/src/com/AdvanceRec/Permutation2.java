package com.AdvanceRec;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Permutation2 {

	public static void main(String[] args) {

		System.out.println(permutationWithoutDuplicate("abcb"));

	}

	static ArrayList<String> permutation(String s) {

		if (s.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		char ch = s.charAt(0);
		s = s.substring(1);
		ArrayList<String> my = new ArrayList<String>();
		ArrayList<String> cur = permutation(s); 
		for (String ss : cur) {

			for (int i = 0; i <= ss.length(); i++) {
				String val = ss.substring(0, i) + ch + ss.substring(i);
				my.add(val);
			}

		}
		return my;

	}

	static ArrayList<String> permutationWithoutDuplicate(String s1) {

		if (s1.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		char ch = s1.charAt(0);
		ArrayList<String> cur = permutationWithoutDuplicate(s1.substring(1));
		ArrayList<String> my = new ArrayList<String>();
		for (String str : cur) {
			for (int i = 0; i <= str.length(); i++) {
				String ans = str.substring(0, i) + ch + str.substring(i);
				if (!my.contains(ans)) {
					my.add(ans);
				}
			}
		}
		return my;

	}
	
   
}
