package co.tushar.Important;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class countPairs {

	// given a list of words with lower cases.print count of number of pairs of
	// words that have the same unique character set.

	public static void main(String[] args) {

		String ar[] = { "pop", "opp", "tot", "ott", "zzz" };

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < ar.length; i++) {
			String s = ar[i];
			char ch[] = s.toCharArray();
			Arrays.sort(ch);
			String ss = new String(ch);

			map.put(ss, map.getOrDefault(ss, 0) + 1);

		}

		System.out.println(work(map));

	}

	private static int work(HashMap<String, Integer> map) {

		int c = 0;
		for (Map.Entry<String, Integer> et : map.entrySet()) {
			if (et.getValue() > 1) {
				c++;
			}
		}
		return c;

	}

}
