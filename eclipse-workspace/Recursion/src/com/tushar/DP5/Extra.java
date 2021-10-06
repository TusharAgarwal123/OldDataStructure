package com.tushar.DP5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Extra {

	public static void main(String[] args) {

		HashMap<String, ArrayList<String>> map = new HashMap<>();
		ArrayList<String> l1 = new ArrayList<>();
		l1.add("mass");
		l1.add("world");
		l1.add("stress");

		ArrayList<String> l2 = new ArrayList<>();
		l2.add("happy");
		l2.add("pride");

		ArrayList<String> l3 = new ArrayList<>();
		l3.add("alexendar");

		map.put("fred", l1);
		map.put("jenie", l2);
		map.put("rone", l3);

		HashMap<String, ArrayList<String>> map2 = new HashMap<>();
		ArrayList<String> l4 = new ArrayList<>();
		l4.add("mass");

		l4.add("stress");

		ArrayList<String> l5 = new ArrayList<>();
		l5.add("happy");

		ArrayList<String> l6 = new ArrayList<>();
		l6.add("alexendar");
		l6.add("world");
		l6.add("pride");

		map2.put("horror", l4);
		map2.put("comedy", l5);
		map2.put("romance", l6);

		HashMap<String, ArrayList<String>> ans = favoriteVideoGenre(3, map, 6, map2);

		System.out.println(ans);

	}

	public static HashMap<String, ArrayList<String>> favoriteVideoGenre(int numUsers,
			HashMap<String, ArrayList<String>> userBook, int numGenres, HashMap<String, ArrayList<String>> bookGenre) {

		HashMap<String, ArrayList<String>> ans = new HashMap<>();

		for (String str : userBook.keySet()) {
			ArrayList<String> lans = userBook.get(str);
			ArrayList<String> kli = work(str, lans, bookGenre);
			ans.put(str, kli);
		}

		return ans;

	}

	private static ArrayList<String> work(String str, ArrayList<String> lans, HashMap<String, ArrayList<String>> map2) {

		ArrayList<String> lp = new ArrayList<String>();
		for (int i = 0; i < lans.size(); i++) {

			String s1 = lans.get(i);
			String kl = find(s1, map2);
			if (!kl.equals("123")) {
				if (!lp.contains(kl)) {
					lp.add(kl);
				}
			}
		}

		return lp;

	}

	private static String find(String s1, HashMap<String, ArrayList<String>> map2) {

		for (Map.Entry<String, ArrayList<String>> vl : map2.entrySet()) {

			ArrayList<String> lo = vl.getValue();
			for (int i = 0; i < lo.size(); i++) {
				if (s1.equals(lo.get(i))) {
					return vl.getKey();
				}
			}

		}

		return "123";

	}

}
