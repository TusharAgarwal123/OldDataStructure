package com.AdvanceRec;

public class CountMazePath {

	public static void main(String[] args) {
		
		System.out.println(countPath(3,3));

	}

	static int countPath(int i, int j) {
		
		if(i==1 && j==1) {
			return 1;
		}
		int c=0;
		if(i>1) {
			c+=countPath(i-1, j);
		}
		if(j>1) {
			c+=countPath(i, j-1);
		}
		return c;
	}

}
