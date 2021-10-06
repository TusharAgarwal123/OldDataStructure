package co.tushar.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int ar[] = { 7, 5, 4, 2, 0 };
		bubbleSort(ar);

		System.out.println(Arrays.toString(ar));

	}

	public static void bubbleSort(int[] ar) {

		int n = ar.length;

		for (int i = 0; i < n - 1; i++) {

			boolean sorted = true;

			for (int j = 0; j < n - 1 - i; j++) {

				if (ar[j] > ar[j + 1]) {
					int temp = ar[j];
					ar[j] = ar[j + 1];
					ar[j + 1] = temp;
					sorted = false;
				}

			}
			if (sorted) {
				break;
			}

		}

	}

}
