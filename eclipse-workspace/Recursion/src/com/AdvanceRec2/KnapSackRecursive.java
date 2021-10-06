package com.AdvanceRec2;

public class KnapSackRecursive {

	public static void main(String[] args) {
		
		int wt[]= {3,6,2,8,5};
		int vol[]= {15,17,20,26,19};
		
		int w=14;
		
		int n=wt.length;
		
		System.out.println(knapsack(wt,vol,w,n));

	}

	static int knapsack(int[] wt, int[] vol, int w, int n) {
		
		if(w==0 || n==0) {
			return 0;
		}
		
		if(wt[n-1]<=w) {
			int add=knapsack(wt, vol, w-wt[n-1], n-1)+vol[n-1];
			int notAdd=knapsack(wt, vol, w, n-1);
			
			return Math.max(add, notAdd);
			
		}
		
		//if(wt[n-1]>w) 
		else {  
			return knapsack(wt, vol, w, n-1);
		}
		
	}

}
