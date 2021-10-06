package com.AdvanceRec;

public class Subsequence {

	public static void main(String[] args) {

		System.out.println(countSubSequence("abc", ""));

	}

	static void subsequence(String s1, String s2) {

		if (s2.isEmpty()) {

			System.out.println(s1);
			return;
		}

		char ch = s2.charAt(0);
		s2 = s2.substring(1);
		subsequence(s1 + ch, s2);
		subsequence(s1, s2);

	}

	static int countSubSequence(String s1, String s2) {

		if (s1.isEmpty()) {

			System.out.println(s2);
			return 1;
		}

		int c = 0;

		c += countSubSequence(s1.substring(1), s2 + s1.charAt(0));
		c += countSubSequence(s1.substring(1), s2);

		return c;

	}

}
