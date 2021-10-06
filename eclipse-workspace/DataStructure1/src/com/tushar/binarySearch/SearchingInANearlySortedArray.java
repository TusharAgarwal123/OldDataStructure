package com.tushar.binarySearch;

public class SearchingInANearlySortedArray {

	/*
	 * in this question you have given an array and element ,you have to find the
	 * the index of element but array is nearly sorted means ,element at ith
	 * position can be at i+1th or i-1th or at ith,
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 5, 10, 30, 20, 40 };
		int ele = 20;
		int l = 0;
		int r = ar.length;

		System.out.println(search(ar, ele, l, r));

	}

	private static int search(int[] ar, int ele, int l, int r) {

		int mid = 0;

		while (l <= r) {
			mid = l + (r - l) / 2;
			if (ar[mid] == ele) {
				return mid;
			} else if (mid - 1 >= l && ar[mid - 1] == ele) {
				return mid - 1;
			} else if (mid + 1 <= r && ar[mid + 1] == ele) {
				return mid + 1;
			}

			if (ar[mid] > ele) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		return -1;

	}

}
