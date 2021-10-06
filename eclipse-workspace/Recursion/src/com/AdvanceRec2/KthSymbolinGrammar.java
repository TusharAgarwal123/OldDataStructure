package com.AdvanceRec2;

public class KthSymbolinGrammar {

	public static void main(String[] args) {

         System.out.println(kthGrammar(4, 6));

	}
	
	//leetcode 779.
	
	 public static int kthGrammar(int n, int k) {
	        
	        if(n==1 && k==1){
	            return 0;
	        }
	        
	        
	        int mid=(int)Math.pow(2,n-1)/2;
	        if(k<=mid){

	            return kthGrammar(n-1,k);
	        
	        }else{

	          int t= kthGrammar(n-1,k-mid);
	            if(t==0){

	             return 1;
	            }else{

	             return 0;
	            }
	            
	        }
	        
	        
	        
	    }

}
