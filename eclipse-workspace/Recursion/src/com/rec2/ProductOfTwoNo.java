package com.rec2;

public class ProductOfTwoNo {

	public static void main(String[] args) {

		int a=3;
		int b=4;
		System.out.println(product(a,b));

	}

	 static int product(int a, int b) {
		 
		if(a==0||b==0) {
			return 0;
		}
		
		return a+product(a, b-1);
		 
	}

}
