package com.rec;

public class SortCheck {

	public static void main(String[] args) {
		int ar[]= {2,3,4,5,8,7};
		System.out.println(check(ar,0));

	}
	
	static boolean check(int []ar,int i) {
		if(i==ar.length-1) {
			return true;
		}
		if(ar[i]>ar[i+1]) {
			return false;
		}
		return check(ar,i+1);
	}

}
