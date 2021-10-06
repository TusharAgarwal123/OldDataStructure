package co.tushar.Important;

import java.util.Arrays;

public class FindElement {

	/*
	 * we have given an array we need to check whether there exist an element which
	 * is strictly greter than all the elements on left of it and strictly smaller
	 * than than all it's right element.
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };

		int left_MAX[] = new int[ar.length];
		int right_MIN[] = new int[ar.length];

		left_MAX[0] = ar[0];
		for (int i = 1; i < ar.length; i++) {
			left_MAX[i] = Math.max(left_MAX[i - 1], ar[i - 1]);

		}

		int n = ar.length;

		right_MIN[n-1] = ar[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right_MIN[i] = Math.min(right_MIN[i + 1], ar[i + 1]);
		}

		System.out.println(Arrays.toString(left_MAX));
		System.out.println(Arrays.toString(right_MIN));

		boolean flag = false;
		int c=0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > left_MAX[i] && ar[i] < right_MIN[i]) {
				flag = true;
				c=i;
				break;
			}
		}

		if (flag) {
			System.out.println("True");
			System.out.println(c);
		} else {
			System.out.println("False");
		}

	}
}