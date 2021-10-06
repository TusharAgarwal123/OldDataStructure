package com.AdvanceRec;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MazePath4 {

	public static void main(String[] args) {


		System.out.println(mazePath(1,1,3,3,""));

	}

	static ArrayList<String> mazePath(int cr, int cc, int er, int ec, String s) {
		
		if(cr==er && cc==ec) {
			ArrayList<String> ll=new ArrayList<String>();
			ll.add(s);
			return ll;
		}
		
		if(cr>er || cc>ec) {
			ArrayList<String> lll=new ArrayList<String>();
			return lll;
		}
		
		ArrayList<String> list=new ArrayList<String>();
		list.addAll(mazePath(cr+1, cc, er, ec, s+'V'));
		list.addAll(mazePath(cr, cc+1, er, ec, s+'H'));
		list.addAll(mazePath(cr+1, cc+1, er, ec, s+'D'));  //for diagonal
		
		return list;
	}

}
