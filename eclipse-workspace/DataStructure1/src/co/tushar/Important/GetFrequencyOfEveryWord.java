package co.tushar.Important;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetFrequencyOfEveryWord {

	public static void main(String[] args) {

		String str = "hi yre eqw juo yre. eqw, hi juo hjk* hi";

		Map<String, Integer> map = mostFrequent(str);
		
		for(Map.Entry et:map.entrySet()) {
			System.out.println(et.getKey()+" "+et.getValue());
		}
		
		//System.out.println(map);

	}

	static Map<String, Integer> mostFrequent(String str) {

		str = str.replaceAll("[^a-zA-Z0-9]", " ");  // [^a-zA-Z0-9] other than what ever come it will replace.
		String[] st = str.split(" +"); // it means it will from space,space can be any time more than 1, 2 also.

		//System.out.println(Arrays.toString(st));

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String words : st) {
			words = words.toLowerCase();
			map.put(words, map.getOrDefault(words, 0) + 1);
		}

		return map;

	}

}
