
package com.rec;

import java.util.Arrays;

public class Power {
	
	static int c=0;
	

	public static void main(String[] args) {
		 System.out.println(power(3,10));
		// System.out.println(c);

		int dp[][]=new int[3+1][10+1]; 
		
		for(int ar[]:dp) {
			Arrays.fill(ar, -1);
		}
		
		System.out.println(powerDP(3, 10, dp));
		 
	}
	static int power(int a,int b) {
		c++;
		if(b==0) {
			return 1;
		}
		if(b%2==0) {
			return power(a*a,b/2);
		}
		return a*power(a,b-1);
	}
	
	//dp
	static int powerDP(int a,int b,int dp[][]) {
		
		
		if(b==0) {
			return dp[a][b]=1;
		}
		
		if(dp[a][b]!=-1) {
			return dp[a][b];
		}
		
		if(b%2==0) {
			return dp[a][b]=power(a*a,b/2);
		}
		return dp[a][b]=a*power(a,b-1);
	}

}
