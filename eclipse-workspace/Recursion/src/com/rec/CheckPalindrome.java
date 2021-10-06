package com.rec;

public class CheckPalindrome {

	public static void main(String[] args) {
		String s="nitinsa";
		System.out.println(palindrome(s, 0, s.length()-1));

	}
	static boolean palindrome(String s,int i,int j) {
		
		if(i==j || i>j) {
			return true;
		}
		
		if(s.charAt(i)!=s.charAt(j)) {
			return false;
		}
		
		return palindrome(s, i+1, j-1);
	}

}
