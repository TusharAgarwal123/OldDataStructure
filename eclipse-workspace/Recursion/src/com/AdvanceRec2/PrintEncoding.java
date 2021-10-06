package com.AdvanceRec2;

public class PrintEncoding {

	public static void main(String[] args) {

		String ss = "123";
		print(ss, "");

	}

	private static void print(String ss, String ans) {

		if (ss.length() == 0) {
			System.out.println(ans);
			return;
		} else if (ss.length() == 1) {
			char ch = ss.charAt(0);
			if (ch == '0') {
				return;
			} else {
				int chv = ch - '0';
				char code = (char) ('a' + chv - 1);
				ans = ans + code;
				System.out.println(ans);
			}
		} else {
			char ch = ss.charAt(0);
			String ex = ss.substring(1);
			if (ch == '0') {
				return;
			} else {
				int chv = ch - '0';
				char code = (char) ('a' + chv - 1);
				print(ex, ans + code);
			}

			String ch12 = ss.substring(0, 2);
			String roq = ss.substring(2);

			int ch12v = Integer.parseInt(ch12);
			if (ch12v <= 26) {
				char code = (char) ('a' + ch12v - 1);
				print(roq, ans + code);
			}
		}

	}

}
