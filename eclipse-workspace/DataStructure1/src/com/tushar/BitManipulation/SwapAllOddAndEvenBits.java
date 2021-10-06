package com.tushar.BitManipulation;

public class SwapAllOddAndEvenBits {

	public static void main(String[] args) {

		/*
		 * to swap all even bits with odd bits,first we will make two mask in first mask
		 * at all even position 1 will be there.and in second mask at all odd position 1
		 * will be there.
		 */

		int n = 14;

		int m1 = 0xAAAAAAAA; //even mask

		/*
		 * hexadecimal represent no in 4 bits,bcoz base is 15 and till 15 no we can store
		 * in 4 bits.
		 * 
		 * we are writing 0x to convert in hexa decimal,A in hexa decimal is equal to
		 * 1010 so we write it 8 times so that it become 32 bits.
		 * 
		 */

		int m2 = 0x55555555;   //odd mask
		
		int odds=(n & m2);
		int even=(n & m1);
		
		odds=odds<<1;  //odd become even.
		even=even>>1;  //even become odd.
		
		n=odds | even;
		
		System.out.println(n);
		
		
		

	}

}
