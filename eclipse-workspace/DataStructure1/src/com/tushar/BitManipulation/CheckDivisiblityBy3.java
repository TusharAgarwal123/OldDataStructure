package com.tushar.BitManipulation;

public class CheckDivisiblityBy3 {

	/*
	 * you are given a binary string which represent a number. you have to check
	 * whether this no is divisible by 3 or not.
	 */

	public static void main(String[] args) {

		String str="10111";
		
		//rather than converting this binary no into decimal,convert 3 into binary.
		
		//to check it is divisible by 3 or not,we know binary of 3 is 11,so just 
		//check whether it is divisible by 11 or not. 
		
		int odd=0;
		int even=0;
		for (int i = 0; i < str.length(); i++) {
			if(i%2==0) {
				even+=str.charAt(i)-'0';
			}else {
				odd+=str.charAt(i)-'0';
			}
		}
		
		int delta=even-odd;
		if(delta % 11==0) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
	}

}
