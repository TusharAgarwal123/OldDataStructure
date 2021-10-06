package com.tushar.hashMap;

import java.util.HashMap;

public class HighestFrequencyCharacter {

	public static void main(String[] args) {

		String str = "abcbabaghadba";
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		char mfc=str.charAt(0);
		for(char cc:map.keySet()) {
			if(map.get(cc)>map.get(mfc)) {
				mfc=cc;
			}
		}
		
		System.out.println(mfc);

	}

}
