package co.tushar.sorting;

public class QuickSort {

	public static void main(String[] args) {

		int ar[] = { 3, 8, 2, 9, 5, 12, 7, 6, 4 };
		int l = 0;
		int h = ar.length - 1;

		quickSort(ar, l, h);

		for (int x : ar) {
			System.out.print(x + " ");
		}

	}

	private static void quickSort(int[] ar, int l, int h) {

		if (l > h) {
			return;
		}

		int pivot = ar[h];
		int pi = partition(ar, pivot, l, h);
		quickSort(ar, l, pi - 1);
		quickSort(ar, pi + 1, h);

	}

	public static int partition(int ar[], int k, int li, int hi) {

		int i = li;
		int j = li;

		while (i <= hi) {
			if (ar[i] > k) {
				i++;
			} else {
				swap(ar, i, j);
				i++;
				j++;
			}
		}

		return (j - 1); // index of pivot element

	}

	private static void swap(int[] ar, int i, int j) {

		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;

	}

}
