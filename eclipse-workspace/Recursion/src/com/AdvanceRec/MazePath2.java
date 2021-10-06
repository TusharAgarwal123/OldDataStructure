package com.AdvanceRec;

import java.util.ArrayList;

public class MazePath2 {

	public static void main(String[] args) {

		System.out.println(mazePath("", 3, 3));
		System.out.println(mazePath2(3, 3));

	}

	static ArrayList<String> mazePath(String s, int row, int col) {

		if (row == 1 && col == 1) {
			ArrayList<String> ll = new ArrayList<String>();
			ll.add(s);
			return ll;
		}

		ArrayList<String> list = new ArrayList<String>();
		if (row > 1) {
			list.addAll(mazePath(s + 'V', row - 1, col));
		}
		if (col > 1) {
			list.addAll(mazePath(s + 'H', row, col - 1));
		}
		return list;

	}

	static ArrayList<String> mazePath2(int row, int col) {

		if (row == 1 && col == 1) {
			ArrayList<String> ll = new ArrayList<String>();
			ll.add("");
			return ll;
		}

		ArrayList<String> vPaths = new ArrayList<String>();
		ArrayList<String> hPaths = new ArrayList<String>();

		if (row > 1) {
			vPaths = mazePath2(row - 1, col);
		}
		if (col > 1) {
			hPaths = mazePath2(row, col - 1);
		}

		ArrayList<String> list = new ArrayList<String>();

		for (String ss : vPaths) {
			list.add("V" + ss);
		}

		for (String ss : hPaths) {
			list.add("H" + ss);
		}

		return list;

	}

}
