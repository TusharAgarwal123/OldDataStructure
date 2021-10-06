package com.AdvanceRec2;

import java.util.ArrayList;

public class GetStairsPath {

	/*
	 * in this question you are at the nth stair ,you have to come to ground,you can
	 * take one step,two step,three step at a time ,you have to print all possible
	 * ways.
	 */

	public static void main(String[] args) {

//		int n = 3;
//		int count = find(n, 0, "");
//		System.out.println("No of Ways " + count);
		System.out.println(find2(6));
//		System.out.println(find_DP(6, new int[7]));
//		System.out.println(find_DP2(6, new int[7]));

	}

	public static int find(int n, int i, String ans) {

		if (n == i) {
			System.out.println(ans);
			return 1;
		}

		if (n < i) {
			return 0;
		}

		int c = 0;

		c += find(n - 1, i, ans + "1");
		c += find(n - 2, i, ans + "2");
		c += find(n - 3, i, ans + "3");

		return c;

	}

	public static int find_DP(int n, int dp[]) {

		if (n == 0) {

			return 1;
		} else if (n < 0) {
			return 0;
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		int c = 0;

		c += find_DP(n - 1, dp);
		c += find_DP(n - 2, dp);
		c += find_DP(n - 3, dp);

		return dp[n] = c;

	}

	public static int find_DP2(int n, int dp[]) {

		int N = n;
		for (n = 0; n < N + 1; n++) {
			if (n == 0) {

				dp[n] = 1;
				continue;
			}
			int c = 0;

			if (n - 1 >= 0) {
				c += dp[n - 1];
			}
			if (n - 2 >= 0) {
				c += dp[n - 2];
			}
			if (n - 3 >= 0) {
				c += dp[n - 3];
			}

			dp[n] = c;
		}

		return dp[N];
	}

	public static ArrayList<String> find2(int n) {

		if (n == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		} else if (n < 0) {
			ArrayList<String> list = new ArrayList<>();
			return list;
		}

		ArrayList<String> p1 = find2(n - 1);
		ArrayList<String> p2 = find2(n - 2);
		ArrayList<String> p3 = find2(n - 3);

		ArrayList<String> paths = new ArrayList<String>();

		for (String s : p1) {
			paths.add(1 + s);
		}

		for (String s : p2) {
			paths.add(2 + s);
		}

		for (String s : p3) {
			paths.add(3 + s);
		}

		return paths;

	}

}
