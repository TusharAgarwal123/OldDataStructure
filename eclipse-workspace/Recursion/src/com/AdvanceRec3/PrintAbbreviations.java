package com.AdvanceRec3;

public class PrintAbbreviations {

	public static void main(String[] args) {

		String str = "pep";
		solution(str, "", 0);

	}

	public static void solution(String str, String ans, int i) {

		if (str.isEmpty()) {
			if (i == 0) {
				System.out.println(ans);
			} else {
				System.out.println(ans + i);
			}
			return;
		}

		char ch = str.charAt(0);
		str = str.substring(1);

		if (i == 0) {
			solution(str, ans + ch, 0);
		} else {
			solution(str, ans + i + ch, 0);
		}

		solution(str, ans, i + 1); // not adding

	}

}
