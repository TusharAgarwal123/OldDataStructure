package com.AdvanceRec;

public class MazePath {

	public static void main(String[] args) {

		mazePath("", 3, 3);

	}

	static void mazePath(String s, int row, int col) {

		if (row == 1 && col == 1) {
			System.out.println(s);
			return;
		}

		if (row > 1) {
			mazePath(s + 'V', row - 1, col);
		}
		if (col > 1) {
			mazePath(s + 'H', row, col - 1);
		}

	}

}
