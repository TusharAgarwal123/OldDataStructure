package co.tushar.Important;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {

		int ar[] = { 2, 5, 7, 9, 4, 2 };
		int k = 4;
		rorate(ar, k);
		System.out.println(Arrays.toString(ar));

	}

	private static void rorate(int[] ar, int k) {
		
		k=k%ar.length;
		if(k<0) {
			k=k+ar.length;
		}
		

		reverse(ar, 0, ar.length - k - 1);
		reverse(ar, ar.length - k, ar.length - 1);
		reverse(ar, 0, ar.length - 1);

	}

	public static void reverse(int ar[], int i, int j) {

		while (i < j) {
			int temp = ar[i];
			ar[i] = ar[j];
			ar[j] = temp;
			i++;
			j--;
		}

	}
}
