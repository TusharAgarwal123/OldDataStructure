package com.tushar.BitManipulation;

public class ReduceNTo1GeeksforGeeks {

	/*
	 * Given an integer element ‘N’, the task is to find the minimum number of
	 * operations that need to be performed to make ‘N’ equal to 1. The allowed
	 * operations to be performed are:
	 * 
	 * Decrement N by 1. Increment N by 1. If N is a multiple of 3, you can divide N
	 * by 3.
	 */

	public static void main(String[] args) {

		
		int n=8;
		int c=0;
		while(n!=1) {
			if(n%3==0) {
				n=n/3;
			}else if(n==2) {  //this is exception case.
				n--;
			}else if(n%3==1) {
				n--;
			}else if(n%3==2) {
				n++;
			}
			
			c++;
		}
		
		System.out.println(c);
		
		
	}

}
