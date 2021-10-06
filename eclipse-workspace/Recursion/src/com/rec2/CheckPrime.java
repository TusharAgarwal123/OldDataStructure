
package com.rec2;

public class CheckPrime {
	
	static int i;

	public static void main(String[] args) {
		
		int n=19;
		
		
		 i=n/2;
		System.out.println(prime(n));
		
	}

	 static boolean prime(int n) {
		 
		 if(n==1) {
			 return false;
		 }
		
		 if(i==1) {
			 return true;
		 }
		 
		 else if(n%i==0) {
			 return false;
		 }else {
			 i--;
		 }
		 
		 return prime(n);
		 
	}
	
}
