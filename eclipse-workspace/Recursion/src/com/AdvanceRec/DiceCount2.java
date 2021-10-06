package com.AdvanceRec;

import java.util.ArrayList;

public class DiceCount2 {

	public static void main(String[] args) {
		
		System.out.println(diceCount("",3));

	}

	static ArrayList<String> diceCount(String s, int i) {
		
		if(i==0) {
			ArrayList<String> ll=new ArrayList<String>();
			ll.add(s);
			return ll;
		}
		
		ArrayList<String> list=new ArrayList<String>();
		
		for(int j=1;j<=i;j++) {
			list.addAll(diceCount(s+j, i-j));
		}
		return list;
		
	}

	
}
