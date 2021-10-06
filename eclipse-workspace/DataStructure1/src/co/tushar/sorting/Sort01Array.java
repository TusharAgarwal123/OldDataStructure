package co.tushar.sorting;

public class Sort01Array {

	public static void main(String[] args) {

		int arr[] = { 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1 };

		int i = 0;
		int j = 0;

		while (i < arr.length) {
			if (arr[i] == 1) {
				i++;
			} else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}

		for (int x : arr) {
			System.out.print(x + " ");
		}

	}

	private static void swap(int[] ar, int i, int j) {

		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;

	}

}
