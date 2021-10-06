package com.rec;

public class PrintINReverse {

	public static void main(String[] args) {
		
		int ar[]= {3,8,6,1,9,5,4};
		print(ar,0);

	}

	private static void print(int[] ar, int i) {
		
		if(i==ar.length) {
			return;
		}
		
		print(ar,i+1);
		System.out.print(ar[i]+" ");
		
	}

}
