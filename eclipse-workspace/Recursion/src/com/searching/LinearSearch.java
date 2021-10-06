package com.searching;

public class LinearSearch {

	public static void main(String[] args) {
		int ar[]= {2,7,4,2,8,3};
		System.out.println(linear(ar,9,0));

	}
	static int linear(int []ar,int ele,int i) {
		if(i==ar.length) {
			return -1;
		}
		if(ar[i]==ele) {
			return i;
		}
		return linear(ar, ele, i+1);
	}

}
