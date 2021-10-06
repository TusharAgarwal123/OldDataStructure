package com.AdvanceRec3;

public class MaximumScoreOfWords {

	/*
	 * we have given a number n and number of words and a variable k and k alphabets
	 * and which define the frequency of each aplhabets.the n words that you have
	 * you have to find the subsets of these words in which frequency of given
	 * alphabets meets and you have to find the subsets whose score is maximum. you
	 * have given the value for each alphabets.
	 */

	public static void main(String[] args) {

	}

	public static int solution(String words[], int fre[], int score[], int id) {

		// words[] array contains the words.
		// fre [] array contains the frequency of each letter.
		// score[] array contains the score for each letter.
		// id is index currently it is 0.

		if (id == words.length) {
			return 0;
		}

		int sno = 0 + solution(words, fre, score, id + 1); // if first word not included.

		// if first word included.
		int sword = 0;
		String word = words[id];
		boolean flag = true;
		for (char ch : word.toCharArray()) {

			if (fre[ch - 'a'] == 0) {
				flag = false;
			}

			fre[ch - 'a']--;
			sword += score[ch - 'a'];

		}

		int syes = 0;
		if (flag) {
			syes = sword + solution(words, fre, score, id + 1);
		}

		for (char ch : word.toCharArray()) { // backtrack.
			fre[ch - 'a']++;
		}

		return Math.max(syes, sno);

	}

}
