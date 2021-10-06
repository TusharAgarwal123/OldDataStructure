package co.tushar.HashmapAndHeap;

import java.util.HashMap;

public class FindItineraryFromTickets {

	/*
	 * 1. You are given number N and 2*N number of strings that represent a list of
	 * N tickets(source and destination). 2. You have to find the itinerary in order
	 * using the given list of tickets.
	 */

	public static void main(String[] args) {

		int n = 4;
		HashMap<String, String> map = new HashMap<>();
		map.put("Chennai", "Banglore");
		map.put("Bombay", "Delhi");
		map.put("Goa", "Chennai");
		map.put("Delhi", "Goa");

		HashMap<String, Boolean> map1 = new HashMap<>();
		for (String src : map.keySet()) {

			String des = map.get(src);

			map1.put(des, false);

			if (!map1.containsKey(src)) {
				map1.put(src, true);
			}
		}

		String src = "";
		for (String pot : map1.keySet()) {

			Boolean val = map1.get(pot);
			if (val == true) {
				src = pot;
				break;
			}

		}

		while (true) {

			if (map.containsKey(src)) {
				System.out.print(src + "-->");
				src = map.get(src);
			} else {
				System.out.print(src + ".");
				break;
			}

		}

	}

}
