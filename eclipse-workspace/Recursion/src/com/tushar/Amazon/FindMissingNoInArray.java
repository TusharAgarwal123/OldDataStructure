package com.tushar.Amazon;

public class FindMissingNoInArray {

	/*
	 * you have an array of positive  number from 1 to n,such that all no from 1 to n 
	 * are present except one number.we have to find that no.
	 */
	
	public static void main(String[] args) {
		
		int ar[]= {3,1,5,6,4,7};
		
		int sum_of_elements=0;
		for(int x:ar) {
			sum_of_elements+=x;
		}
		
		int expected_sum=0;
		int n=ar.length+1;
		
		expected_sum=n*(n+1)/2;
		
		System.out.println(expected_sum-sum_of_elements);
		
		

	}

}
