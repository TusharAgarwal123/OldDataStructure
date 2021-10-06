package com.rec2;

public class CountDigit {

	static int c = 0;

	public static void main(String[] args) {

		int a = 1233484;
		System.out.println(count(a));

	}

	static int count(int a) {

		if (a > 0) {
			c++;
			count(a / 10);
		}
		return c;

	}

}
