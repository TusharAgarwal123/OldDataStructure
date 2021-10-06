package com.AdvanceRec2;

public class TargetSum {
	
	/*
	 * we have an array and target,we have to print all subsets whose sum is equal to
	 * target.
	 */

	public static void main(String[] args) {
		
		int ar[]= {10,20,30,40,50};
		int target=70;
		
		printWays(ar,0,target,"",0);

	}

	private static void printWays(int[] ar, int i, int target, String ans, int ssf) {

 
		if(i==ar.length) {
			if(ssf==target) {
				System.out.println(ans);
				
			}
			return;
		}
		
		
		
		if(ssf>target) {
			return;
		}
		
		printWays(ar, i+1, target, ans+ar[i]+",", ssf+ar[i]);  //include
		printWays(ar, i+1, target, ans, ssf);  //not include
		
		
	}

}
