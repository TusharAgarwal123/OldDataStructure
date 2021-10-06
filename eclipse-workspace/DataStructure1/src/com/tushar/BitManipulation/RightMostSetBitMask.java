package com.tushar.BitManipulation;

public class RightMostSetBitMask {

	public static void main(String[] args) {


		//to find the right most set bit mask,just do and with 2's compliment of the no.

		int n=12;
		
		//to find the 2's compliment just write (-n);
		
		int rmsb=n & -n;
		System.out.println(Integer.toBinaryString(rmsb));  //return string representation of integer argument.
		
	}

}
