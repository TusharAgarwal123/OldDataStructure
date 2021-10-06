package com.tushar.DP5;

public class MinimumCostPath {

	public static void main(String[] args) {
		
		
		/*
		 * you have a matrix you have to go bottom roght from top left,you have to find
		 * the minimum cost to reach at the end.
		 */
		
		int ar[][]= {{2,8,4,1,6,4,2},{6,0,9,5,3,8,5},{1,4,3,4,0,6,5},{6,4,7,2,4,6,1},{1,0,3,7,1,2,7},{1,5,3,2,3,0,9},{2,2,5,1,9,8,2}};
		
		int dp[][]=new int[ar.length][ar[0].length];
		
		for (int i = dp.length-1; i >=0 ; i--) {
			for (int j = dp[0].length-1; j >= 0; j--) {
				if(i==dp.length-1 && j==dp[0].length-1) {
					dp[i][j]=ar[i][j];
				}else if(i==dp.length-1) {		
					dp[i][j]=dp[i][j+1]+ar[i][j];
				}else if(j==dp[0].length-1) {
					dp[i][j]=dp[i+1][j]+ar[i][j];
				}else {
					dp[i][j]=Math.min(dp[i][j+1], dp[i+1][j])+ar[i][j];
				}
			}
		}
		
		System.out.println(dp[0][0]);

	}

}
