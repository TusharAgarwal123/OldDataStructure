package com.tushar.DP5;

public class CountSubseQuencesOfFormABC {

	public static void main(String[] args) {


		/*
		 * you have given an string you have to count subsequence of form
		 * A^i B^j C^k.
		 */
		
		int a=0;
		int ab=0;
		int abc=0;
		
		String str="abcabc";
		
		for (int i = 0; i <str.length() ; i++) {
			char ch=str.charAt(i);
			
			if(ch=='a') {
				a=2*a+1;
			}else if(ch=='b') {
				ab=2*ab+a;
			}else if(ch=='c') {
				abc=2*abc+ab;
			}
		}
		
		System.out.println(abc);

	}

}
