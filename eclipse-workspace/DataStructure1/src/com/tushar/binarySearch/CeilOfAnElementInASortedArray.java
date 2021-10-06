package com.tushar.binarySearch;

public class CeilOfAnElementInASortedArray {

	/*
	 * ceil will be smallest of all greater element than element.
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3, 4, 6, 7, 9, 10, 12 };
		int l = 0;
		int r = ar.length - 1;
		int ele = 8;

		System.out.println(findCeil(ar, l, r, ele));

	}

	private static int findCeil(int[] ar, int l, int r, int ele) {

		int ans = 0;
		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (ar[mid] == ele) {
				return ele;
			} else if (ar[mid] > ele) {
				ans = ar[mid];
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ans;

	}

}
