package com.tushar.BitManipulation;

public class FindTheElementThatAppearsOnce {

	/*
	 * FindTheElementThatAppearsOnce while all other elements appears twice.
	 */
	
	public static void main(String[] args) {
		
		int ar[]= {2,6,8,2,8};
		int xor=0;
		for(int val:ar) {
			xor=xor^val;
		}
		
		System.out.println(xor);
		System.out.println(Integer.toBinaryString(xor));

	}

}
