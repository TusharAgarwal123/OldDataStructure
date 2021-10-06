package com.AdvanceRec;

public class DiceCount {

	public static void main(String[] args) {

		diceCount("", 3);

	}

	static void diceCount(String s, int i) {

		if (i == 0) {
			System.out.println(s);
			return;
		}

		for (int j = 1; j <= i; j++) { // for(int j=1;j<=6 && j<=i;j++)
			diceCount(s + j, i - j);
		}

	}

}
