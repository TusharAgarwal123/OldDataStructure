package com.rec2;

public class sumOfNaturalNo {

	//sum of natural no between 1 to n.
	
	public static void main(String[] args) {
		
		int n1=5;
		int n2=7;
		System.out.println(sum(n1,n2));

	}

	private static int sum(int n1, int n2) {
		
		if(n1==n2) {
			return n1;
		}
		else {
			return n1+sum(n1+1,n2);
		}
		
	}

}
