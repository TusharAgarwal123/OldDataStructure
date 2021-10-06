package com.rec;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		
		int ar[]= {2,4,6,8,10,12};
		ar=reverse(ar, 0, ar.length-1);
		System.out.println(Arrays.toString(ar));

	}
	
	static int[] reverse(int ar[],int i,int j) {
		if(i>j) {
			return ar;
		}
		if(i<=j) {
			int temp=ar[i];
			ar[i]=ar[j];
			ar[j]=temp;
		}
		return reverse(ar, i+1, j-1);
	}

}
