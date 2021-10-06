package com.AdvanceRec3;

import java.util.HashMap;
import java.util.Scanner;

public class PalindromicPermutation {

	public static void main(String[] args) {

		System.out.println("___");
		Scanner sc = new Scanner(System.in);
		String ss = sc.next();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : ss.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		Character odd = null;
		int odds = 0;
		int len = 0;

		for (char ch : map.keySet()) {
			int fre = map.get(ch);
			if (fre % 2 == 1) {
				odd = ch;
				odds++;
			}
			map.put(ch, fre / 2);
			len += fre / 2;
		}

		if (odds > 1) {
			System.out.println(-1);
			return;
		}
		generate(1, len, map, odd, "");

	}

	private static void generate(int i, int len, HashMap<Character, Integer> map, Character odd, String asf) {

		if (i > len) {

			String rev = "";
			for (int j = asf.length() - 1; j >= 0; j--) {
				rev += asf.charAt(j);
			}

			String res = asf;
			if (odd != null) {
				res += odd;
			}
			res += rev;

			System.out.println(res);

			return;
		}

		for (char ch : map.keySet()) {

			int fr = map.get(ch);
			if (fr > 0) {
				map.put(ch, fr - 1);
				generate(i + 1, len, map, odd, asf + ch);
				map.put(ch, fr);
			}

		}

	}

}
