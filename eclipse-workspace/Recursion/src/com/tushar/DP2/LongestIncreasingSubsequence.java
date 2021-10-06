package com.tushar.DP2;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		String str = "123214839";

		char ch[] = str.toCharArray();

		int ar[] = new int[ch.length];

		Arrays.fill(ar, 1);

		int maxLength = 0;

		for (int i = 1; i < ch.length; i++) {
			for (int j = 0; j < i; j++) {
				if (ch[i] > ch[j] && ar[j] + 1 > ar[i]) {
					ar[i] = ar[j] + 1;
					maxLength = Math.max(maxLength, ar[i]);
				}
			}
		}
		System.out.println(maxLength);

	}

}
