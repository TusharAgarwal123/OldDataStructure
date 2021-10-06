package com.rec2;

public class PowerOfNumber {

	public static void main(String[] args) {
		
		int base=5;
		int power=3;
		System.out.println(Findpower(base,power));

	}

	static int Findpower(int base, int power) {
		
		if(power==0) {
			return 1;
		}
		if(power%2==0) {
			return Findpower(base*base, power/2);
		}else {
			return base*Findpower(base, power-1);
		}
		
	}

}
