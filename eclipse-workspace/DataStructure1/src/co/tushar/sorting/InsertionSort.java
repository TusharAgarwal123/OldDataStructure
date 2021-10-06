package co.tushar.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int ar[] = { 7, 5, 4, 2, -5 };
		insertionSort(ar);

		System.out.println(Arrays.toString(ar));

	}

	public static void insertionSort(int[] ar) {

		int n = ar.length;
		for (int i = 0; i < n - 1; i++) {

			for (int j = i + 1; j > 0; j--) {

				if (ar[j] < ar[j - 1]) {
					int temp = ar[j];
					ar[j] = ar[j - 1];
					ar[j - 1] = temp;
				} else {
					break;
				}

			}

		}

	}

}
