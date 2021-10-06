package com.tushar.binarySearch;

public class PeakElement {

	/*
	 * in this question you have an unsorted array ,you have to find the peek
	 * element in the array ,peak element is the element which is larger than it's
	 * left and right element.
	 */

	public static void main(String[] args) {

		int ar[] = { 1,10,5,12,14};
		int l = 0;
		int r = ar.length - 1;

		System.out.println(findPeak(ar, l, r));

	}

	public static int findPeak(int[] ar, int l, int r) {

		int mid = 0;

		while (l <= r) {
			mid = l + (r - l) / 2;

			if (mid > 0 && mid < ar.length - 1) { // excepting last and first element

				if (ar[mid - 1] < ar[mid] && ar[mid + 1] < ar[mid]) {

					return mid;
				} else if (ar[mid - 1] > ar[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
					
				}

			} else if (mid == 0) {
				if (ar[mid] > ar[mid + 1]) {
					return mid;
				} else {
					return 1;
				}
			} else if (mid == ar.length - 1) {
				if (ar[ar.length - 1] > ar[ar.length - 2]) {
					return ar.length - 1;
				} else {
					return ar.length - 2;
				}
			}

		}
		return -1;

	}

}
