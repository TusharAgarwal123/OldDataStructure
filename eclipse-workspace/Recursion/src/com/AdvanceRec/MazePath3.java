package com.AdvanceRec;

import java.util.ArrayList;

public class MazePath3 {

	public static void main(String[] args) {

//		mazePath(1, 1, 3, 3, "");
//		System.out.println(mazePath_Count(1, 1, 3, 3, ""));
		System.out.println(mazePath2(1, 1, 3, 3, ""));
		System.out.println(mazePath3(1, 1, 3, 3));

	}

	static void mazePath(int cr, int cc, int er, int ec, String s) {

		if (cr == er && cc == ec) {
			System.out.println(s);
			return;
		}
		if (cr > er || cc > ec) {
			return;
		}

		mazePath(cr + 1, cc, er, ec, s + 'V');
		mazePath(cr, cc + 1, er, ec, s + 'H');

	}

	static int mazePath_Count(int cr, int cc, int er, int ec, String s) {

		if (cr == er && cc == ec) {
			System.out.println(s);
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		int c = 0;

		c += mazePath_Count(cr + 1, cc, er, ec, s + 'V');
		c += mazePath_Count(cr, cc + 1, er, ec, s + 'H');

		return c;

	}

	static ArrayList<String> mazePath2(int cr, int cc, int er, int ec, String s) {

		if (cr == er && cc == ec) {
			ArrayList<String> ll = new ArrayList<String>();
			ll.add(s);
			return ll;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> lll = new ArrayList<String>();

			return lll;
		}

		ArrayList<String> list = new ArrayList<String>();

		list.addAll(mazePath2(cr + 1, cc, er, ec, s + 'V'));
		list.addAll(mazePath2(cr, cc + 1, er, ec, s + 'H'));

		return list;

	}

	static ArrayList<String> mazePath3(int cr, int cc, int er, int ec) {
		
		if(cr==er && cc==ec) {
			ArrayList<String> ll = new ArrayList<String>();
			ll.add("");
			return ll;
		}

		ArrayList<String> hPaths = new ArrayList<String>();
		ArrayList<String> vPaths = new ArrayList<String>();

		if (cc < ec) {
			hPaths = mazePath3(cr, cc + 1, er, ec);
		}
		if (cr < er) {
			vPaths = mazePath3(cr + 1, cc, er, ec);
		}

		ArrayList<String> paths = new ArrayList<String>();

		for (String ss : hPaths) {
			paths.add("h" + ss);
		}

		for (String ss : vPaths) {
			paths.add("V" + ss);
		}

		return paths;

	}

}
