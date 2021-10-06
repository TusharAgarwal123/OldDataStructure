package com.tushar.hashMap;

import java.util.HashMap;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int ar[] = { 10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2 };
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int x : ar) {
			map.put(x, true);
		}

		for (int x : ar) {
			if (map.containsKey(x - 1)) {
				map.put(x, false);
			}
		}

		int msp = 0;
		int ml = 0;

		for (int x : ar) {
			if (map.get(x) == true) {
				int tl = 1;
				int tsp = x;

				while (map.containsKey(tsp + tl)) {
					tl++;
				}
				if (tl > ml) {
					ml = tl;
					msp = tsp;
				}
			}
		}

		for (int i = 0; i < ml; i++) {
			System.out.print(msp + i + " ");
		}
	}

}
