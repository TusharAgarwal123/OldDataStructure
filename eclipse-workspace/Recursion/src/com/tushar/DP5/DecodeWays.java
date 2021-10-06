package com.tushar.DP5;

public class DecodeWays {

	public static void main(String[] args) {

		/*
		 * you are given a string of digit(will never start with zero). you are required
		 * to encode the str as per following rule.
		 * 
		 * 1=a 2=b 3=c . . . 25=y 26=z
		 * 
		 * you are required to find the count of encodings.
		 * 
		 * for 123 there are 3 encodings =abc,aw,lc
		 * 
		 */

		String str = "123";
		int dp[] = new int[str.length()];

		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {

			if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
				dp[i] = dp[i - 1];
			} else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
				if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
					dp[i] = i >= 2 ? dp[i - 2] : 1;
				} else {
					dp[i] = 0;
				}
			} else if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
				dp[i] = 0;
			} else { // if both are not equal to zero.

				if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
					dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
				} else {
					dp[i] = dp[i - 1];
				}

			}

		}

		System.out.println(dp[str.length() - 1]);
	}

}
