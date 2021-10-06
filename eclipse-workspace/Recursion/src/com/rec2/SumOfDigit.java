package com.rec2;

public class SumOfDigit {
	
	static int sum=0;

	public static void main(String[] args) {

		int a=1235;
		System.out.println(FindSum(a));

	}

	 static int FindSum(int a) {
		
		 if(a>0) {
			 sum+=a%10;
			 FindSum(a/10);
		 }
		 return sum;
		 
		 
	}

}
