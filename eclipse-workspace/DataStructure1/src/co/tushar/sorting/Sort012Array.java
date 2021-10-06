package co.tushar.sorting;

public class Sort012Array {

	public static void main(String[] args) {

		int ar[] = { 0, 2, 1, 0, 0, 1, 1, 2, 2, 0, 1, 2, 0, 1 };
		int i = 0;
		int j = 0;
		int k = ar.length - 1;

		while (i <= k) {

			if (ar[i] == 1) {
				i++;
			} else if (ar[i] == 0) {
				swap(ar, i, j);
				i++;
				j++;
			} else {
				swap(ar, i, k);
				k--;
			}
		}

		for (int x : ar) {
			System.out.print(x + " ");
		}

	}

	public static void swap(int ar[], int i, int j) {
		int tm = ar[i];
		ar[i] = ar[j];
		ar[j] = tm;
	}

}
