package co.tushar.DP;

public class fibonacci {

	public static void main(String[] args) {

		System.out.println(fibo(20));

		System.out.println(fibo_Memorization(20, new int[21]));
		System.out.println(fibo_dp(20, new int[21]));

	}

	public static int fibo(int n) {

		if (n <= 1) {
			return n;
		}

		int res = fibo(n - 1) + fibo(n - 2);
		return res;

	}

	public static int fibo_Memorization(int n, int a[]) {

		if (n <= 1) {
			return a[n] = n;
		}

		if (a[n] != 0) {
			return a[n];
		}

		int res = fibo_Memorization(n - 1, a) + fibo_Memorization(n - 2, a);
		return a[n] = res;

	}

	public static int fibo_dp(int n, int a[]) {

		int num = n;
		for (n = 0; n <= num; n++) {

			if (n <= 1) {
				a[n] = n;
				continue;
			}

			int res = a[n - 1] + a[n - 2];
			a[n] = res;

		}

		return a[num];

	}
	
	
}
