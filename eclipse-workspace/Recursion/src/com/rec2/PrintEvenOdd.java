package com.rec2;

public class PrintEvenOdd {

	public static void main(String[] args) {
		
		int n=18;
		
		System.out.println("All Even No from 1 to"+ n);
		EvenOdd(2,n);
		System.out.println("All Odd No from 1 to"+ n);
		EvenOdd(1,n);

	}

	 static void EvenOdd(int i, int n) {
		
		 if(i>n) {
			 return;
		 }
		 System.out.println(i);
		 EvenOdd(i+2, n);
		
	}

}
