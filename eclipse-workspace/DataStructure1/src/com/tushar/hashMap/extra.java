package com.tushar.hashMap;

public class extra {

	public static void main(String[] args) {


		String ss="public static void main(String args[])  if(true) {sout(); } }";
		
		boolean flag=check(ss);
		if(flag) {
			System.out.println("correct");
		}else {
			System.out.println("error");
		}
		

	}

	private static boolean check(String ss) {


		int open=0;
		int close=0;
		
		for(char ch:ss.toCharArray()) {
			if(ch=='{') {
				open++;
			}else if(ch=='}') {
				close++;
			}
		}
		
		return open==close;
		
	}

}
