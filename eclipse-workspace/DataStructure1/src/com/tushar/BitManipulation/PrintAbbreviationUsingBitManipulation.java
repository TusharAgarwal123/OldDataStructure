package com.tushar.BitManipulation;

public class PrintAbbreviationUsingBitManipulation {

	public static void main(String[] args) {

		String str = "pep";
		solve(str);

	}

	public static void solve(String str) {

		for (int i = 0; i < (1 << str.length()); i++) {

			StringBuilder sb = new StringBuilder();
			int c = 0;

			for (int j = 0; j < str.length(); j++) {
				int bit = str.length() - 1 - j;
				char ch = str.charAt(j);

				if ((i & (1 << bit)) == 0) {
					if (c == 0) {
						sb.append(ch);
					} else {
						sb.append(c);
						sb.append(ch);
						c = 0;
					}
				} else {
					c++;
				}
			}

			if (c > 0) {
				sb.append(c);
			}

			System.out.println(sb);

		}

	}

}
