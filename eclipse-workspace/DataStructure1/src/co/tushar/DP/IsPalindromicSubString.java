
package co.tushar.DP;

public class IsPalindromicSubString {

	public static void main(String[] args) {

//		boolean[][] dp = isPalindrome_Substring("abbac");
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp.length; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(longestPalindromic_Substring("ghjjhgk"));
		System.out.println(longestPalindromic_Subsequence("abcab", 0, 4));
		System.out.println(longestPalindromic_Subsequence2("abcab", 0, 4, new int[5][5]));
		System.out.println(longestPalindromic_Subsequence3("abcab"));

	}

	public static boolean[][] isPalindrome_Substring(String s) {

		int n = s.length();

		boolean[][] dp = new boolean[n][n];

		for (int gap = 0; gap < n; gap++) {

			for (int i = 0, j = gap; i < n && j < n; i++, j++) {

				if (i == j) {
					dp[i][j] = true;
				} else if (gap == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1]);
				}

			}

		}
		return dp;

	}

	public static String longestPalindromic_Substring(String s) {

		int n = s.length();
		int max = 0;
		int st = 0;
		int ed = 0;

		int[][] dp = new int[n][n];

		for (int gap = 0; gap < n; gap++) {

			for (int i = 0, j = gap; i < n && j < n; i++, j++) {

				if (i == j) {
					dp[i][j] = 1;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 2;
					}
				} else {
					if ((s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1] != 0)) {
						dp[i][j] = gap + 1;
					}
				}

				if (dp[i][j] > max) {
					max = dp[i][j];
					st = i;
					ed = j;
				}

			}

		}

		return s.substring(st, ed + 1);

	}

	public static int longestPalindromic_Subsequence(String s, int si, int ei) {

		if (si > ei) {
			return 0;
		}

		if (si == ei) {
			return 1;
		}

		int c = 0;
		if (s.charAt(si) == s.charAt(ei)) {
			c = longestPalindromic_Subsequence(s, si + 1, ei - 1) + 2;
		} else {
			c = Math.max(longestPalindromic_Subsequence(s, si + 1, ei), longestPalindromic_Subsequence(s, si, ei - 1));
		}

		return c;
	}

	// memorized solution.
	public static int longestPalindromic_Subsequence2(String s, int si, int ei, int[][] dp) {

		if (si == ei) {
			return dp[si][ei] = 1;
		}

		if (dp[si][ei] != 0) {
			return dp[si][ei];
		}

		int c = 0;
		if (s.charAt(si) == s.charAt(ei)) {
			c = longestPalindromic_Subsequence(s, si + 1, ei - 1) + 2;
		} else {
			c = Math.max(longestPalindromic_Subsequence(s, si + 1, ei), longestPalindromic_Subsequence(s, si, ei - 1));
		}

		return dp[si][ei] = c;
	}

	// dp solution.
	public static int longestPalindromic_Subsequence3(String s) {

		int n = s.length();
		int dp[][] = new int[n][n];
		int max = 0;
		

		for (int gap = 0; gap < n; gap++) {

			for (int i = 0, j = gap; i < n && j < n; i++, j++) {

				if (i == j) {
					dp[i][j] = 1;

				}

				else {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i + 1][j - 1] + 2;
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}
				}

				if (dp[i][j] > max) {
					max = dp[i][j];
					
				}

			}

		}

		
		return max;

	}

}
