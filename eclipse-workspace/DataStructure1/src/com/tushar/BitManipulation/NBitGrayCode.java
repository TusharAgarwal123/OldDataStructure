package com.tushar.BitManipulation;

import java.util.ArrayList;
import java.util.Iterator;

public class NBitGrayCode {

	public static void main(String[] args) {

		int n = 3;
		ArrayList<String> list = generate(n);
		System.out.println(list);

	}

	public static ArrayList<String> generate(int n) {

		if (n == 1) {
			ArrayList<String> ans = new ArrayList<String>();
			ans.add("0");
			ans.add("1");
			return ans;
		}

		ArrayList<String> res = generate(n - 1);
		ArrayList<String> my = new ArrayList<String>();
		for (int i = 0; i < res.size(); i++) {
			String ss = res.get(i);
			my.add("0" + ss);
		}
		for (int i = res.size() - 1; i >= 0; i--) {
			String ss = res.get(i);
			my.add("1" + ss);
		}

		return my;

	}

}
