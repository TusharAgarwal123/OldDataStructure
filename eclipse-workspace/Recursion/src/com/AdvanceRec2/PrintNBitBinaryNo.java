package com.AdvanceRec2;

public class PrintNBitBinaryNo {

	//print n bit binary no having more 1 than 0 prefix geeksforgeeks.
	public static void main(String[] args) {
	
		int n=3;
		solve("",0,0,n);

	}

	private static void solve(String ans, int one, int zero, int n) {
		
		if(n==0) {
			System.out.print(ans+" ");
			return;
		}
		solve(ans+"1",one+1,zero,n-1);
		
		if(zero<one) {
			solve(ans+"0",one,zero+1,n-1);
		}
		
	}

}
