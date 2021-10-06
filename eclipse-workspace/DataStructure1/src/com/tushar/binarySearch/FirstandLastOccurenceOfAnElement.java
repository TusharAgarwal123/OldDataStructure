package com.tushar.binarySearch;

public class FirstandLastOccurenceOfAnElement {

	public static void main(String[] args) {

		int ar[] = { 2, 4, 5, 6, 6, 6, 8, 10 };
		int l = 0;
		int r = ar.length - 1;
		int ele = 6;
		int res = -1;

		int mid = 0;
		while (l <= r) {

			mid = l + (r - l) / 2;
			if (ar[mid] == ele) {
				res = mid;
				r = mid - 1;

				// if ask for last occurence then do
				// l=mid+1;

			} else if (ar[mid] > ele) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		System.out.println(res);

	}

}
