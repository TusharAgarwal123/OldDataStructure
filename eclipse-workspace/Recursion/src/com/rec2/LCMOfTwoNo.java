package com.rec2;

public class LCMOfTwoNo {
	
	static int mul=0;

	public static void main(String[] args) {
		
		int a=5;
		int b=150;
		if(a>b) {
			System.out.println(lcm(b,a));
		}else {
			System.out.println(lcm(a,b));
		}
	}

	 static int lcm(int a, int b) {
		
		 mul+=b;
		 if((mul%a==0)&&(mul%b==0)) {
			 return mul;
		 }else {
			 return lcm(a,b);
		 }
		 
	}

}
