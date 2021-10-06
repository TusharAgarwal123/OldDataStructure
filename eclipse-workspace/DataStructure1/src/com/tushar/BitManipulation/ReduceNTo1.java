package com.tushar.BitManipulation;

public class ReduceNTo1 {

	/*
	 * 1. You are given a positive number N. 2. You have to find the minimum number
	 * of operations required to convert N into 1. 3. Operations allowed : (i) If n
	 * is even, you have to replace n with n/2. (ii) If n is odd, you can replace n
	 * with either n-1 or n+1.
	 */

	public static void main(String[] args) {

		int n=15;
		int c=0;
		while(n!=1) {
			
			if(n%2==0) {
				n=n/2;
			}else if(n==3) {   //for n=3 this is exception.
				n--;   
			}else if(n%4==1) {
				n--;
			}else if(n%4==3) {
				n++;
			}
			c++;
			
		}
		
		System.out.println(c);
		
	}

}
