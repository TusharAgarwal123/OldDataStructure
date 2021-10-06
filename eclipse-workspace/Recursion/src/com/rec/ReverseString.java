package com.rec;

public class ReverseString {

	public static void main(String[] args) {
		String s = "tushar";

		char ch[] = s.toCharArray();
		int l = 0;
		int r = ch.length - 1;

		while (l < r) {
			char temp = ch[l];
			ch[l] = ch[r];
			ch[r] = temp;
			l++;
			r--;
		}

		String rev = new String(ch);
		System.out.println(rev);

	}

}
