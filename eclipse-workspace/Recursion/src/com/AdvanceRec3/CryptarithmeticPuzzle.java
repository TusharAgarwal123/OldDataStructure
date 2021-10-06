package com.AdvanceRec3;

import java.util.HashMap;
import java.util.Scanner;

public class CryptarithmeticPuzzle {

	/*
	 * 1. You are given three strings s1, s2 and s3. 2. First two are supposed to
	 * add and form third. s1 + s2 = s3 3. You have to map each individual character
	 * to a digit, so that the above equation holds true.
	 */

	public static void main(String[] args) {

		System.out.println("----");
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();

		String unique = "";
		HashMap<Character, Integer> map = new HashMap<>();

		for (char c : s1.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, -1);
				unique += c;
			}
		}

		for (char c : s2.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, -1);
				unique += c;
			}
		}

		for (char c : s3.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, -1);
				unique += c;
			}
		}

		boolean[] usedNumbers = new boolean[10];
		solve(unique, 0, usedNumbers, map, s1, s2, s3);

	}

	public static void solve(String unique, int i, boolean[] usedNumbers, HashMap<Character, Integer> map, String s1,
			String s2, String s3) {

		if (i == unique.length()) {
			int num1 = getNum(s1, map);
			int num2 = getNum(s2, map);
			int num3 = getNum(s3, map);

			if ((num1 + num2) == num3) {
				for (int z = 0; z < 26; z++) {
					char ch = (char) ('a' + z);
					if (map.containsKey(ch)) {
						System.out.print(ch + "-" + map.get(ch) + " ");
					}
				}
				System.out.println();
			}
			return;
		}

		char ch = unique.charAt(i);
		for (int num = 0; num <= 9; num++) {
			if (usedNumbers[num] == false) {
				map.put(ch, num);
				usedNumbers[num] = true;
				solve(unique, i + 1, usedNumbers, map, s1, s2, s3);
				usedNumbers[num] = false;
				map.put(ch, -1);
			}
		}

	}

	public static int getNum(String s, HashMap<Character, Integer> map) {

		String sum = "";
		for (char c : s.toCharArray()) {

			if (map.containsKey(c)) {
				sum += map.get(c);
			}

		}
		return Integer.parseInt(sum);

	}

}
