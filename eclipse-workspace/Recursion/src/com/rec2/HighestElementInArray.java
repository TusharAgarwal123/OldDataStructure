package com.rec2;

public class HighestElementInArray {
	
	static int ar[]= {3,8,11,7,9,4};
	static int max=ar[0];

	public static void main(String[] args) {
		
		
		System.out.println(maxEle(1,ar));

	}

	 static int maxEle(int i,int[] ar) {
		
		 if(i==ar.length) {
			 return max;
		 }
		 if(ar[i]>max) {
			 max=ar[i];
		 }
		 
		 return maxEle(i+1, ar);
		 
	}

}
