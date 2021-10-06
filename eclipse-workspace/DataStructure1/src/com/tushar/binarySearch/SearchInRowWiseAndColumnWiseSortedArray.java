package com.tushar.binarySearch;

public class SearchInRowWiseAndColumnWiseSortedArray {

	/*
	 * we have given a matrix which is sorted row wise and column wise both. and a
	 * element we have to find the position of the element.
	 */

	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {

		int ar[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		int l = 0;
		int r = ar.length - 1;
		int ele = 39;

		Pair p = findElement(ar, l, r, ele);
		if (p.first == -1) {
			System.out.println(-1);
		} else {
			System.out.println(p.first + " " + p.second);
		}

	}

	public static Pair findElement(int[][] ar, int l, int r, int ele) {

		while ((l >= 0 && l < ar.length) && (r >= 0 && r < ar.length)) {

			if (ar[l][r] == ele) {

				Pair p = new Pair(l, r);
				return p;

			} else if (ar[l][r] > ele) {
				r--;
			} else if (ar[l][r] < ele) {
				l++;
			}
		}
		return new Pair(-1, -1);

	}

}
