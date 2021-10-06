package com.tushar.DP4;

public class CountPalindromicSubString {

	public static void main(String[] args) {

		String str = "abccbc";
		boolean dp[][] = new boolean[str.length()][str.length()];
		int c=0;
		
		for(int gap=0;gap<dp.length;gap++) {
			for(int i=0,j=gap;j<dp.length;j++,i++) {
				if(gap==0) {
					dp[i][j]=true;
				}else if(gap==1) {
					if(str.charAt(i)==str.charAt(j)) {
						dp[i][j]=true;
					}else {
						dp[i][j]=false;
					}
				}else {
					if(str.charAt(i)!=str.charAt(j)) {
						dp[i][j]=false;
					}else {
						dp[i][j]=dp[i+1][j-1];
					}
				}
				
				if(dp[i][j]) {
					c++;
				}
			}
		}
		
		System.out.println("No Of SubString "+c);
		print(dp);

	}
	
	public static void print(boolean dp[][]) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

}
