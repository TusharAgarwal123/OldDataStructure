package com.tushar.DP5;

public class BestTimeToBuyAndSellStocks2 {

	public static void main(String[] args) {

		/*
		 * Say you have an array prices for which the ith element is the price of a
		 * given stock on day i.
		 * 
		 * Design an algorithm to find the maximum profit. You may complete as many
		 * transactions as you like (i.e., buy one and sell one share of the stock
		 * multiple times).
		 */

		int ar[] = { 7, 1, 5, 3, 6, 4 };

		int pr = 0;

		for (int i = 0; i < ar.length - 1; i++) {
			if (ar[i] < ar[i + 1]) {
				pr += ar[i + 1] - ar[i];
			}
		}

		System.out.println(pr);

	}

}
