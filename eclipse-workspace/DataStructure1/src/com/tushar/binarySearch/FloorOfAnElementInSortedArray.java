package com.tushar.binarySearch;

public class FloorOfAnElementInSortedArray {

	/*
	 * given an array and element , you have to return the floor of element if
	 * element is present then floor will be itself otherwise floor will be greatest
	 * of all smaller element than given element.
	 * 
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3, 4, 6, 7, 9, 10, 12 };
		int l = 0;
		int r = ar.length - 1;
		int ele = 8;

		System.out.println(findFloor(ar, l, r, ele));

	}

	private static int findFloor(int[] ar, int l, int r, int ele) {

		int mid = 0;
		int ans=0;

		while (l <= r) {
			mid = l + (r - l) / 2;
			if (ar[mid] == ele) {
				return ele;
			} else if (ar[mid] < ele) {

				ans=ar[mid];
				l=mid+1;
				
			} else {
				r = mid - 1;
			}

		}
		return ans;
	}

}
