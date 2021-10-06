package com.tushar.DP5;

public class ArrangeBuildings {

	public static void main(String[] args) {

		/*
		 * we have road and on both side of road we have some empty plots ,we can either
		 * make building on that plots or can leave it empty,but condition is that no
		 * two building can come together , two empty plot can come together we have
		 * find ways for both side.
		 */

		int n = 3;

		int dps[] = new int[n + 1];
		int dpb[] = new int[n + 1];

		System.out.println(find(dps, dpb, n));
		System.out.println(find2(n));

	}

	private static int find2(int n) {

		// if n value is large then use long.

		int ob = 1;
		int os = 1;

		for (int i = 2; i <= n; i++) {
			int nb = os;
			int ns = os + ob;

			ob = nb;
			os = ns;
		}
		int t = ob + os;
		t = t * t; // bcoz ask for both sides of the road/
		return t;

	}

	private static int find(int[] dps, int[] dpb, int n) {

		dps[1] = 1; // when we have only one plot ,for empty plot
		dpb[1] = 1; // when we have only one plot ,for building

		for (int i = 2; i <= n; i++) {
			dps[i] = dps[i - 1] + dpb[i - 1];
			dpb[i] = dps[i - 1];
		}

		int t = dps[n] + dpb[n];
		t = t * t; // bcoz ask for both sides of the road/
		return t;

	}

}
