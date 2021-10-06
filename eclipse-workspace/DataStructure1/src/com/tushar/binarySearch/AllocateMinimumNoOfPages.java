package com.tushar.binarySearch;

public class AllocateMinimumNoOfPages {

	/*
	 * we have given an array and an element ,size of array represent the no of the
	 * books and value at each element represent the pages in the books and the
	 * element that is given is no of students.
	 * 
	 * we have to minimize the maximum no of pages that student is reading. first
	 * find all the combination then find the minimum one.
	 * 
	 * given array can be sorted or not.
	 */

	public static void main(String[] args) {

		int ar[] = { 10, 20, 30, 40 };
		int k = 2; // no of students.
		int n = ar.length;

		int max = ar[0];
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] > max) {
				max = ar[i];
			}
		}

		int sum = 0;
		for (int i = 0; i < ar.length; i++) {
			sum += ar[i];
		}

		int start = max;
		int end = sum;

		System.out.println(check(ar, start, end, k, n));

	}

	private static int check(int[] ar, int start, int end, int k, int n) {

		if (n < k) {
			return -1;
		}

		int res = -1;
		int mid = 0;

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (isValid(ar, n, k, mid)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;

	}

	public static boolean isValid(int[] ar, int n, int k, int mid) {

		int stu = 1;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + ar[i];
			if (sum > mid) {
				stu++;
				sum = ar[i];
			}
			if (stu > k) {
				return false;
			}
		}

		return true;

	}

}
