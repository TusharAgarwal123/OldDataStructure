package com.AdvanceRec3;

public class CrosswordPuzzle {

	public static void main(String[] args) {

		char[][] ch = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '-', '-', '-', '-', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '-', '-', '-', '-', '-', '-', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' } };

		String str[] = { "LONDON", "DELHI", "ICELAND", "ANKARA" };
		solve(ch, str, 0);

	}

	public static void print(char ch[][]) {
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[0].length; j++) {
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}
	}

	public static void solve(char ar[][], String[] words, int id) {

		if (id == words.length) {

			print(ar);
			return;
		}

		String word = words[id];

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				if (ar[i][j] == '-' || ar[i][j] == word.charAt(0)) {

					if (canPlaceWordHorizontally(ar, word, i, j)) {
						boolean[] wePlaced = placeWordHorizontally(ar, word, i, j);
						solve(ar, words, id + 1);
						unPlaceWordHorizontally(ar, wePlaced, i, j);
					}

					if (canPlaceWordVertically(ar, word, i, j)) {
						boolean[] wePlaced = placeWordVertically(ar, word, i, j);
						solve(ar, words, id + 1);
						unPlaceWordVertically(ar, wePlaced, i, j);
					}
				}
			}
		}

	}

	public static void unPlaceWordVertically(char[][] ar, boolean[] wePlaced, int i, int j) {

		for (int i2 = 0; i2 < wePlaced.length; i2++) {
			if (wePlaced[i2] == true) {
				ar[i + i2][j] = '-';
			}
		}

	}

	public static boolean[] placeWordVertically(char[][] ar, String word, int i, int j) {

		boolean[] wePlaced = new boolean[word.length()];

		for (int i2 = 0; i2 < word.length(); i2++) {

			if (ar[i + i2][j] == '-') {
				ar[i + i2][j] = word.charAt(i2);
				wePlaced[i2] = true;
			}

		}
		return wePlaced;

	}

	public static boolean canPlaceWordVertically(char[][] ar, String word, int i, int j) {

		if (i - 1 >= 0 && ar[i - 1][j] != '+') {
			return false;
		} else if (i + word.length() < ar[0].length && ar[i + word.length()][j] != '+') {
			return false;
		}

		for (int ii = 0; ii < word.length(); ii++) {

			if (i + ii >= ar[0].length) {
				return false;
			}

			if (ar[i + ii][j] == '-' || ar[i + ii][j] == word.charAt(ii)) {
				continue;
			} else {
				return false;
			}
		}

		return true;

	}

	public static void unPlaceWordHorizontally(char[][] ar, boolean[] wePlaced, int i, int j) {

		for (int j2 = 0; j2 < wePlaced.length; j2++) {
			if (wePlaced[j2] == true) {
				ar[i][j + j2] = '-';
			}
		}

	}

	public static boolean[] placeWordHorizontally(char[][] ar, String word, int i, int j) {

		boolean[] wePlaced = new boolean[word.length()];

		for (int j2 = 0; j2 < word.length(); j2++) {

			if (ar[i][j + j2] == '-') {
				ar[i][j + j2] = word.charAt(j2);
				wePlaced[j2] = true;
			}

		}
		return wePlaced;

	}

	public static boolean canPlaceWordHorizontally(char[][] ar, String word, int i, int j) {

		if (j - 1 >= 0 && ar[i][j - 1] != '+') {
			return false;
		} else if (j + word.length() < ar[0].length && ar[i][j + word.length()] != '+') {
			return false;
		}

		for (int jj = 0; jj < word.length(); jj++) {

			if (j + jj >= ar[0].length) {
				return false;
			}

			if (ar[i][j + jj] == '-' || ar[i][j + jj] == word.charAt(jj)) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

}
