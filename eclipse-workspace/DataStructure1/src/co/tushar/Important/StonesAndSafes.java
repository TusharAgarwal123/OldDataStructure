package co.tushar.Important;

import java.util.Arrays;
import java.util.Collections;

public class StonesAndSafes {

	public static void main(String[] args) {

		int st[] = { 3, 1, 2 };
		int sf[] = { 2, 4, 3, 1 };

		Arrays.sort(st);
		Arrays.sort(sf);
		
		int f=st.length-1;
		int s=sf.length-1;
		int c=0;
		
		for (int i = f; i >=0; i--) {
			for (int j = s; j >=0; j--) {
				
				if(2*st[f]<=sf[j]) {
					c++;
					break;
				}
			}
		}
		
		System.out.println(c);
		

		// boolean visit[] = new boolean[sf.length];

		// System.out.println(count(st, sf, st.length, sf.length, visit));

	}

	

	public static int count(int[] st, int[] sf, int n, int m, boolean visit[]) {

		if (n == 0 || m == 0) {
			return 0;
		}

		int add = 0;

		if (2 * st[n - 1] <= sf[m - 1]) {
			if (!visit[m - 1]) {
				visit[m - 1] = true;
				add = count(st, sf, n - 1, sf.length, visit) + 1;

			}
		} else {
			return count(st, sf, n, m - 1, visit);
		}

		return add;

	}

}
