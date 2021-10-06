package co.tushar.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int ar[] = { 7, 5, 4, 2, -3 };
		selectionSort(ar);

		System.out.println(Arrays.toString(ar));

	}

	public static void selectionSort(int[] ar) {

		int n = ar.length;

		for (int i = 0; i < n - 1; i++) {

			int min = i;
			for (int j = i; j < n; j++) {

				if (ar[j] < ar[min]) {
					min = j;
				}

			}

			int temp = ar[i];
			ar[i] = ar[min];
			ar[min] = temp;

		}

	}

}
