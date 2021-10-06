package com.tushar.binarySearch;

public class BinarySearch {

	public static void main(String[] args) {

		int ar[] = { 2, 4, 6, 8, 10, 34, 67 };
		int l = 0;
		int r = ar.length - 1;

		System.out.println(search(ar, l, r, 10));

	}

	// if array is in ascending order.
	public static int search(int[] ar, int l, int r, int ele) {

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (ar[mid] == ele) {
				return mid;
			} else if (ar[mid] > ele) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;

	}

	// if array is in descending order.
	public static int search2(int[] ar, int l, int r, int ele) {

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (ar[mid] == ele) {
				return mid;
			} else if (ar[mid] > ele) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;

	}

}
