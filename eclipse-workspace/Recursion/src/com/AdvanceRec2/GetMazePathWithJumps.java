package com.AdvanceRec2;

import java.util.ArrayList;

public class GetMazePathWithJumps {

	/*
	 * in this question you have to go to destination from source,this you have 3
	 * choice you can go in horizontal,vertical and diagonal direction and you can
	 * jumps in all the direction 1,2 and 3.
	 */

	public static void main(String[] args) {

//		System.out.println(getMazePaths(1, 1, 4, 4));
		getMazePaths2(1, 1, 4, 4, "");

	}

	private static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

		if (sr == dr && sc == dc) {
			ArrayList<String> ll = new ArrayList<>();
			ll.add("");
			return ll;
		}

		ArrayList<String> paths = new ArrayList<>();

		// horizontally moves.

		for (int ms = 1; ms <= dc - sc; ms++) {
			ArrayList<String> hPaths = getMazePaths(sr, sc + ms, dr, dc);
			for (String ss : hPaths) {
				paths.add("H" + ms + ss);
			}

		}

		// vertically moves.

		for (int ms = 1; ms <= dr - sr; ms++) {
			ArrayList<String> vPaths = getMazePaths(sr + ms, sc, dr, dc);
			for (String ss : vPaths) {
				paths.add("V" + ms + ss);
			}

		}

		// Diagonally moves.

		for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
			ArrayList<String> dPaths = getMazePaths(sr + ms, sc + ms, dr, dc);
			for (String ss : dPaths) {
				paths.add("D" + ms + ss);
			}

		}

		return paths;

	}

	private static void getMazePaths2(int sr, int sc, int dr, int dc, String ans) {

		if (sr == dr && sc == dc) {
			System.out.print(ans+" ");
			return;
		}

		// horizontally.
		for (int ms = 1; ms <= dc - sc; ms++) {
			getMazePaths2(sr, sc + ms, dr, dc, ans + "H" + ms);
		}

		// vertically.
		for (int ms = 1; ms <= dr - sr; ms++) {
			getMazePaths2(sr + ms, sc, dr, dc, ans + "V" + ms);
		}

		// diagonally.
		for (int ms = 1; ms <= dc - sc && ms <= dr - sr; ms++) {
			getMazePaths2(sr + ms, sc + ms, dr, dc, ans + "D" + ms);
		}

	}

}
