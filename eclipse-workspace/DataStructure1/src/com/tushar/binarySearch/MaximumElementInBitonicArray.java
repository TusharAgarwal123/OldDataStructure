package com.tushar.binarySearch;

public class MaximumElementInBitonicArray {

	/*
	 * an array is called bitonic array if all the element first increasing then after at
	 * some point it start decresing.
	 * in bitonic array there will be only one peak element.
	 * 
	 * so just find the peak element in it.
	 */
	
	public static void main(String[] args) {


		int ar[]= {1,3,8,12,14,2,1};
		int l=0;
		int r=ar.length-1;
		
		System.out.println(findMax(ar,l,r));

	}

	public static int findMax(int[] ar, int l, int r) {


		int mid=0;
		while(l<=r) {
			mid=l+(r-l)/2;
			if(mid>0 && mid<ar.length-1) {
				if(ar[mid]>ar[mid-1] && ar[mid]>ar[mid+1]) {
					return mid;
				}else if(ar[mid-1]>ar[mid]) {
					r=mid-1;
				}else {
					l=mid+1;
				}
			}else if(mid==0) {
				if(ar[mid]>ar[mid+1]) {
					return mid;
				}else {
					return 1;
				}
			}else if(mid==ar.length-1) {
				if(ar[ar.length-1]>ar[ar.length-2]) {
					return ar.length-1;
				}else {
					return ar.length-2;
				}
			}
		}
		return -1;
		
	}

}
