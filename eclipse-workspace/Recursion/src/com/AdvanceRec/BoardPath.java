package com.AdvanceRec;

public class BoardPath {

	public static void main(String[] args) {
		
		boardPath(0,10,"");
		System.out.println("No of ways "+countBoardPath(0, 10));

	}

	static void boardPath(int i, int j, String s) {
		
		if(i==j) {
			System.out.println(s);
			return;
		}
		
		if(i>j) {
			return;
		}
		
		for(int k=1;k<=6;k++) {
			boardPath(i+k, j, s+k);
		}
		
	}
	
	static int countBoardPath(int i,int j) {
		if(i==j) {
			return 1;
		}
		if(i>j) {
			return 0;
		}
		
		int c=0;
		for(int k=1;k<=6;k++) {
			c+=countBoardPath(i+k, j);
		}
		return c;
	}

}
