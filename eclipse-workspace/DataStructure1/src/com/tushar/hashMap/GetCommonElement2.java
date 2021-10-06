package com.tushar.hashMap;

import java.util.HashMap;

public class GetCommonElement2 {

	public static void main(String[] args) {

		int ar1[] = { 1, 1, 2, 2, 2, 3, 5 };
		int ar2[] = { 1, 1, 1, 2, 2, 4, 5 };

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x : ar1) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		for (int x : ar2) {
			if (map.containsKey(x) && map.get(x) > 0) {

				System.out.print(x + " ");
				map.put(x, map.get(x) - 1);

			}
		}

	}

}
