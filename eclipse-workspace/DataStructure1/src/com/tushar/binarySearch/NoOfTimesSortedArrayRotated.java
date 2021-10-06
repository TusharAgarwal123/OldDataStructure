package com.tushar.binarySearch;

public class NoOfTimesSortedArrayRotated {

	/*
	 * given an roated array ,initially it was sorted,you have to find no of time it
	 * is rotated.
	 * 
	 * so no of times rotated is equal to index of smallest element.
	 */

	public static void main(String[] args) {

		int ar[] = { 10, 12, 2, 4, 6, 8 };
		int l = 0;
		int r = ar.length - 1;
		int N = ar.length;

		int idx = search(ar, l, r, N);
		System.out.println(idx);

	}

	static int search(int[] ar, int l, int r, int N) {

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;
			int next = (mid + 1) % N;
			int pre = (mid + N - 1) % N;

			if (ar[mid] <= ar[next] && ar[mid] <= ar[pre]) {
				return mid;
			}
			if (ar[l] <= ar[mid]) {
				l = mid + 1;
			} else if (ar[mid] <= ar[r]) {
				r = mid - 1;
			}

		}
		return -1;

	}

}
