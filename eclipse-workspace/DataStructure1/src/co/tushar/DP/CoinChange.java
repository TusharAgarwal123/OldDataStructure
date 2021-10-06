package co.tushar.DP;

public class CoinChange {

	public static void main(String[] args) {

		int ar[] = { 2, 3, 6, 1, 4 };
		System.out.println(coinChangePermutation(ar, 5));
		System.out.println(coinChangePermutation_Memo(ar, 5, new int[6]));
		System.out.println(coinChangePermutation_DP(ar, 5, new int[6]));
	}

	public static int coinChangePermutation_DP(int[] ar, int tar, int[] dp) {

		int N = tar;

		for (tar = 0; tar <= N; tar++) {
			if (tar == 0) {
				dp[tar] = 1;
				continue;
			}

			int c = 0;
			for (int i = 0; i < ar.length; i++) {

				if (tar >= ar[i]) {
					c += dp[tar-ar[i]];
				}

			}
			dp[tar] = c;

		}
		return dp[N];

	}

	public static int coinChangePermutation(int[] ar, int tar) {

		if (tar == 0) {

			return 1;
		}

		int c = 0;
		for (int i = 0; i < ar.length; i++) {

			if (tar >= ar[i]) {
				c += coinChangePermutation(ar, tar - ar[i]);
			}

		}
		return c;

	}

	public static int coinChangePermutation_Memo(int[] ar, int tar, int[] dp) {

		if (tar == 0) {
			return dp[tar] = 1;
		}

		if (dp[tar] != 0) {
			return dp[tar];
		}

		int c = 0;
		for (int i = 0; i < ar.length; i++) {

			if (tar >= ar[i]) {
				c += coinChangePermutation(ar, tar - ar[i]);
			}

		}
		return dp[tar] = c;

	}

}
