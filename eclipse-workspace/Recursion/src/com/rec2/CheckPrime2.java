package com.rec2;

public class CheckPrime2 {

	static int i=2;

	public static void main(String[] args) {
		
		int n=19;
		
		System.out.println(prime(n));
		
	}

	 static boolean prime(int n) {
		 
		 if(n==0 ||n==1) {
			 return false;
		 }
		 if(n==3 || n==2) {
			 return true;
		 }
		 
		 if(i<=Math.sqrt(n)) {
			 if(n%i==0) {
				 return false;
			 }else {
				 i++;
			 }
		 }else {
			 return true;
		 }
		return prime(n);
		 
		 
		 
	}

}
