package co.tushar.sorting;

public class QuickSelect {

	public static void main(String[] args) {

		int ar[] = { 3, 7, 5, 9, 2, 9, 5, 1 };
		int k = 3;
		// find kth smallest element.

		// if we sort the array so kth smallest will be at the k-1 position.

		System.out.println(quickSelect(ar, 0, ar.length - 1, k - 1));

	}

	private static int quickSelect(int[] ar, int l, int h, int k) {

		int pivot = ar[h];
		int pi = partition(ar, pivot, l, h);

		if (k > pi) {
			return quickSelect(ar, pi + 1, h, k);
		} else if (k < pi) {
			return quickSelect(ar, l, pi - 1, k);
		} else {
			return ar[pi];
		}

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
