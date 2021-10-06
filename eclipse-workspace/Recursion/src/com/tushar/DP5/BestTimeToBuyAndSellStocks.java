package com.tushar.DP5;

public class BestTimeToBuyAndSellStocks {

	public static void main(String[] args) {

		/*
		 * Say you have an array for which the ith element is the price of a given stock
		 * on day i.
		 * 
		 * If you were only permitted to complete at most one transaction (i.e., buy one
		 * and sell one share of the stock), design an algorithm to find the maximum
		 * profit.
		 * 
		 * Note that you cannot sell a stock before you buy one.
		 */

		int ar[] = { 7, 1, 5, 3, 6, 4 };

		int lsf = Integer.MAX_VALUE;
		int op = 0;
		int pist = 0;

		for (int i = 0; i < ar.length; i++) {
			if (ar[i] < lsf) {
				lsf = ar[i];
			}

			pist = ar[i] - lsf;
			op = Math.max(pist, op);
		}

		System.out.println(op);

	}

}
