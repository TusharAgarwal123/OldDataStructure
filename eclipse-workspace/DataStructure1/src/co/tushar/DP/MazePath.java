package co.tushar.DP;

public class MazePath {

	public static void main(String[] args) {

		System.out.println(mazePath_Memorization(0, 0, 2, 2, new int[3][3]));
		System.out.println(mazePath_DP(0, 0, 2, 2, new int[3][3]));

	}

	public static int mazePath_Memorization(int sr, int sc, int er, int ec, int[][] dp) {

		if (sr == er && sc == ec) {
			return dp[sr][sc] = 1;
		}

		if (dp[sr][sc] != 0) {
			return dp[sr][sc];
		}

//		if (sr > er || sc > ec) {
//			return dp[sr][sc]=0;
//		}

		int c = 0;

		if (sr + 1 <= er) {
			c += mazePath_Memorization(sr + 1, sc, er, ec, dp);

		}
		if (sc + 1 <= ec) {
			c += mazePath_Memorization(sr, sc + 1, er, ec, dp);

		}
		return dp[sr][sc] = c;

	}

	public static int mazePath_DP(int sr, int sc, int er, int ec, int[][] dp) {

		for (sr = er; sr >= 0; sr--) {
			for (sc = ec; sc >= 0; sc--) {
				if (sr == er && sc == ec) {
					dp[sr][sc] = 1;
					continue;
				}

				int c = 0;

				if (sr + 1 <= er) {
					c += dp[sr + 1][sc];
				}

				if (sc + 1 <= ec) {
					c += dp[sr][sc + 1];

				}
				dp[sr][sc] = c;

			}
		}

		return dp[0][0];

	}

}
