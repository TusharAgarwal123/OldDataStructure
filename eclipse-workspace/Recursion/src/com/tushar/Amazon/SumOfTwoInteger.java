package com.tushar.Amazon;

public class SumOfTwoInteger {

	/*
	 * determine if the sum of two integers is equal to the given value.
	 */
	
	public static void main(String[] args) {
		
		int ar[]= {5,7,1,2,8,4,3};
		int target=17;
		
		System.out.println(find(ar,0,ar.length-1,target));

	}

	private static boolean find(int[] ar, int l, int r, int target) {
		
		while(l<r) {
			if(ar[l]+ar[r]>target) {
				r--;
			}else if(ar[l]+ar[r]<target) {
				l++;
			}else {
				return true;
			}
		}
		return false;
		
	}

}
