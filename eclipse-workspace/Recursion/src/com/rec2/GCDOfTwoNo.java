package com.rec2;

public class GCDOfTwoNo {

	public static void main(String[] args) {
		
		int a=20;
		int b=8;
		System.out.println(gcd(a,b));

	}

	 static int gcd(int a, int b) {
		
		 if(a==0) {
			 return b;
		 }
		
		 return gcd(b%a,a);
		
	}

}
