package com.tushar.BitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NumberOfValidWordsForEachPuzzle {

	/*
	 * LeetCode(1178).
	 * 
	 * With respect to a given puzzle string, a word is valid if both the following
	 * conditions are satisfied: word contains the first letter of puzzle. For each
	 * letter in word, that letter is in puzzle. For example, if the puzzle is
	 * "abcdefg", then valid words are "faced", "cabbage", and "baggage"; while
	 * invalid words are "beefed" (doesn't include "a") and "based" (includes "s"
	 * which isn't in the puzzle). Return an array answer, where answer[i] is the
	 * number of words in the given word list words that are valid with respect to
	 * the puzzle puzzles[i].
	 * 
	 */

	public static void main(String[] args) {

		String words[] = { "aaaa", "asas", "able", "ability", "actt", "actor", "access" };
		String puzzles[] = { "aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz" };

		ArrayList<Integer> list = solution(words, puzzles);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(puzzles[i]+ "-->" +list.get(i));
		}

	}

	public static ArrayList<Integer> solution(String[] words, String[] puzzles) {

		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < 26; i++) {

			map.put((char) ('a' + i), new ArrayList<Integer>());

		}

		for (String word : words) {
			int mask = 0;
			for (char ch : word.toCharArray()) {
				int po = ch - 'a';
				mask = mask | (1 << po);
			}

			HashSet<Character> ss = new HashSet<>();
			for (char ch : word.toCharArray()) {

				if (ss.contains(ch)) {
					continue;
				}
				ss.add(ch);
				map.get(ch).add(mask);
			}

		}

		ArrayList<Integer> ans = new ArrayList<>();
		for (String puzzle : puzzles) {

			int pmask = 0;
			int count = 0;
			for (char ch : puzzle.toCharArray()) {
				int po = ch - 'a';
				pmask = pmask | (1 << po);
			}

			char cc = puzzle.charAt(0);
			ArrayList<Integer> res = map.get(cc);
			for (int val : res) {
				if ((val & pmask) == val) {
					count++;
				}
			}
			ans.add(count);

		}

		return ans;
	}

}
