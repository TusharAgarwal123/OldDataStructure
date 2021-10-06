package com.tushar.binarySearch;

public class SearchAnElementInBitonicArray {

	public static void main(String[] args) {

		int ar[] = { 1, 3, 8, 12, 4, 2 };
		int l = 0;
		int r = ar.length - 1;
		int ele = 8;
		int idx = findPeak(ar, l, r); // this is index of peak element.

		int i1 = binarySearchOnAscendingArray(ar, 0, idx - 1, ele);
		int i2 = binarySearchOnDescendingArray(ar, idx, ar.length - 1, ele);

		int ans = i1 != -1 ? i1 : i2;
		System.out.println(ans);

	}

	public static int binarySearchOnDescendingArray(int[] ar, int l, int r, int ele) {
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

	public static int binarySearchOnAscendingArray(int[] ar, int l, int r, int ele) {

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

	public static int findPeak(int[] ar, int l, int r) {

		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (mid > 0 && mid < ar.length - 1) {
				if (ar[mid] > ar[mid - 1] && ar[mid] > ar[mid + 1]) {
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
