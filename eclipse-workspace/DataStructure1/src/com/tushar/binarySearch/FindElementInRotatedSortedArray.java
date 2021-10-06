package com.tushar.binarySearch;

public class FindElementInRotatedSortedArray {

	public static void main(String[] args) {

		int ar[] = { 10, 12, 2, 4, 6, 8 };
		int ele = 12;
		int l = 0;
		int r = ar.length - 1;
		int N = ar.length;

		int idx = findSmall(ar, l, r, N); // this is index of minimum element.

		int i1 = search(ar, 0, idx - 1, ele);
		int i2 = search(ar, idx, ar.length - 1, ele);

		int ans = i1 != -1 ? i1 : i2;
		System.out.println(ans);

	}

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

	public static int findSmall(int[] ar, int l, int r, int N) {

		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			int next = (mid + 1) % N;
			int pre = (mid + N - 1) % N;

			if (ar[mid] <= ar[pre] && ar[mid] <= ar[next]) {
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
