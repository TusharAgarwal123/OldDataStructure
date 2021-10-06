package com.AdvanceRec3;

public class PrintInLexoGraphicalOrder {

	public static void main(String[] args) {

		int n = 150;

		for (int i = 1; i <= 9; i++) {
			dfs(i, n);
		}

	}

	public static void dfs(int i, int n) {

		if (i > n) {
			return;
		}

		System.out.println(i);
		for (int j = 0; j < 10; j++) {
			dfs(i * 10 + j, n);
		}

	}

}
