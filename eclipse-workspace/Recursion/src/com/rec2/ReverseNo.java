package com.rec2;

public class ReverseNo {
	
	static int sum=0;
	static int rem;
	
	public static void main(String[] args) {
		
		
		int n=123;
		int rs=rev(n);
		System.out.println(rs);
		
	}

	 static int rev(int n) {
		
		
		 
		if(n!=0) {
		rem=n%10;
		sum=sum*10+rem;
		rev(n/10);
		
		}
		
		return sum;
		
	}
	
	
	
}
