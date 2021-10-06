package co.tushar.Important;

import java.util.Arrays;

public class InverseOfAnArray {

	public static void main(String[] args) {
		
		int ar[]= {3,4,1,2,0};
		
		int inr[]=inverse(ar);
		System.out.println(Arrays.toString(inr));

	}

	private static int[] inverse(int[] ar) {
		
		int inr[]=new int[ar.length];
		
		for (int i = 0; i < ar.length; i++) {
			int v=ar[i];
			inr[v]=i;
		}
		return inr;
	}

}
