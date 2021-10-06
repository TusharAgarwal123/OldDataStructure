package co.tushar.DP;

import java.util.Arrays;

public class DynamicProgramming {

	public static void main(String[] args) {

//		System.out.println(friend_Pairing_Problem(4));
//		System.out.println(friend_Pairing_Problem_Memo(4, new int[5]));
//		System.out.println(friend_Pairing_Problem_DP(4, new int[5]));

		System.out.println(partition_into_k_subsets(3, 2));
		System.out.println(partition_into_k_subsets_Memo(3, 2, new int[4][3]));
		System.out.println(partition_into_k_subsets_DP(3, 2, new int[4][3]));

	}

	// leetcode 70.
	public int climbStairs(int n) {

		if (n == 0) {

			return 1;

		}
		if (n < 0) {

			return 0;

		}

		int c = 0;
		c += climbStairs(n - 1);
		c += climbStairs(n - 2);

		return c;

	}

	// memorize approach

	// leetcode 70.
	public int climbStairs2(int n, int[] dp) {

		if (n == 0) {

			return dp[n] = 1;

		}

		if (dp[n] != 0) {
			return dp[n];
		}

		int c = 0;
		if (n - 1 >= 0) {
			c += climbStairs(n - 1);
		}
		if (n - 2 >= 0) {
			c += climbStairs(n - 2);
		}

		return dp[n] = c;

	}

	// leetcode 70 dynamic approach.

	public int climbStairs3(int n, int[] dp) { // take size of dp n+1;

		int NUM = n;

		for (n = 0; n <= NUM; n++) {

			if (n == 0) {

				dp[n] = 1;
				continue;

			}

			int c = 0;
			if (n - 1 >= 0) {
				c += dp[n - 1];
			}
			if (n - 2 >= 0) {
				c += dp[n - 2];
			}

			dp[n] = c;

		}

		return dp[NUM];

	}

	// leetcode 198.house robber

	public int rob(int[] nums) {

		int dp[] = new int[nums.length + 2];
		Arrays.fill(dp, -1);
		return maxMoney(nums, 0, dp);

	}

	public int maxMoney(int[] nums, int i, int[] dp) {

		if (i >= nums.length) {
			return dp[i] = 0;
		}

		if (dp[i] != -1) {
			return dp[i];
		}

		int done = maxMoney(nums, i + 2, dp) + nums[i];
		int not_done = maxMoney(nums, i + 1, dp);

		return dp[i] = Math.max(done, not_done);

	}

	// 746. min cost climbing stairs.

	public int minCostClimbingStairs(int[] cost) {

		int n = cost.length;
		int[] dp = new int[n + 1];
		int[] cost_ = new int[n + 1];

		for (int i = 0; i < n; i++) {
			cost_[i] = cost[i];
		}

		return findMinCost(cost_, n, dp);

	}

	public int findMinCost(int[] cost, int n, int[] dp) {

		if (n <= 1) {
			return dp[n] = cost[n];
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		int minCost = Math.min(findMinCost(cost, n - 1, dp), findMinCost(cost, n - 2, dp));

		return dp[n] = minCost + cost[n];
	}

	// geeksForgeeks.
	// friends_Pairing_Problem.

	public static int friend_Pairing_Problem(int n) {

		if (n <= 1) {
			return 1;
		}

		int single = friend_Pairing_Problem(n - 1);
		int pair = friend_Pairing_Problem(n - 2) * (n - 1);

		return single + pair;

	}

	public static int friend_Pairing_Problem_Memo(int n, int[] dp) {

		if (n <= 1) {
			return dp[n] = 1;
		}
		if (dp[n] != 0) {
			return dp[n];
		}

		int single = friend_Pairing_Problem(n - 1);
		int pair = friend_Pairing_Problem(n - 2) * (n - 1);

		return dp[n] = single + pair;

	}

	// best solution.
	public static int friend_Pairing_Problem_DP(int n, int[] dp) {

		int N = n;

		for (n = 0; n <= N; n++) {

			if (n <= 1) {
				dp[n] = 1;
				continue;
			}

			int single = dp[n - 1];
			int pair = dp[n - 2] * (n - 1);

			dp[n] = single + pair;

		}
		return dp[N];

	}

	// geeksforgeeks
	// partition into k subsets.

	public static int partition_into_k_subsets(int n, int k) {

		if (n < k) {
			return 0;
		}
		if (n == k || k == 1) {
			return 1;
		}

		int newSet = partition_into_k_subsets(n - 1, k - 1);
		int existingSet = partition_into_k_subsets(n - 1, k) * k;

		return newSet + existingSet;

	}

	public static int partition_into_k_subsets_Memo(int n, int k, int dp[][]) {

		if (n < k) {
			return dp[n][k] = 0;
		}
		if (n == k || k == 1) {
			return dp[n][k] = 1;
		}

		if (dp[n][k] != 0) {
			return dp[n][k];
		}

		int newSet = partition_into_k_subsets(n - 1, k - 1);
		int existingSet = partition_into_k_subsets(n - 1, k) * k;

		return dp[n][k] = newSet + existingSet;

	}

	public static int partition_into_k_subsets_DP(int n, int k, int dp[][]) {

		int N = n;
		int K = k;

		for (n = 0; n <= N; n++) {
			for (k = 0; k <= K; k++) {
				if (n < k) {
					dp[n][k] = 0;
					continue;
				}
				if (n == k || k == 1) {
					dp[n][k] = 1;
					continue;
				}

				int newSet = dp[n - 1][k - 1];
				int existingSet = dp[n - 1][k] * k;

				dp[n][k] = newSet + existingSet;
			}
		}

		return dp[n][k];

	}

	// robber house 2 leetcode(213)

	public int rob2(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] dp = new int[nums.length + 4];
		Arrays.fill(dp, -1);

		int[] dp2 = new int[nums.length + 4];
		Arrays.fill(dp2, -1);

		int a = houseRobber(nums, 0, nums.length - 2, dp);
		int b = houseRobber(nums, 1, nums.length - 1, dp2);

		return Math.max(a, b);

	}

	public int houseRobber(int[] nums, int i, int n, int[] dp) {

		if (i > n) {

			return dp[i] = 0;

		}

		if (dp[i] != -1) {
			return dp[i];
		}

		int done = houseRobber(nums, i + 2, n, dp) + nums[i];

		int not_done = houseRobber(nums, i + 1, n, dp);

		return dp[i] = Math.max(done, not_done);

	}

	// leetcode 121.best time to buy and sell stock

	int max = 0;

	public int maxProfit(int[] prices) {

		if (prices.length == 0) {

			return 0;

		}

		findMax(prices, 0);
		return max;

	}

	public int findMax(int[] prices, int i) {

		if (i == prices.length - 1) {

			return prices[i];

		}

		int t = prices[i];
		int pr = findMax(prices, i + 1);
		max = Math.max(pr - t, max);

		return Math.max(pr, t);

	}

	// leetcode 123.
	// best time to buy and sell stock 3.

	public int maxProfit3(int[] prices) {

		if (prices.length == 0) {
			return 0;
		}

		int fb = Integer.MIN_VALUE;
		int sb = Integer.MIN_VALUE;

		int fs = 0;
		int ss = 0;

		for (int i = 0; i < prices.length; i++) {

			fb = Math.max(fb, -prices[i]);
			fs = Math.max(fs, fb + prices[i]);
			sb = Math.max(sb, fs - prices[i]);
			ss = Math.max(ss, sb + prices[i]);

		}
		return ss;

	}

	// leetcode 188.
	// best time to buy and sell stock 4.

	public int maxProfit(int k, int[] prices) {

		if (prices.length <= 1 || k <= 0) {
			return 0;
		}

		int pr = 0;

		if (k >= prices.length / 2) {

			for (int i = 0; i < prices.length - 1; i++) {

				if (prices[i] < prices[i + 1]) {

					pr += prices[i + 1] - prices[i];

				}

			}
			return pr;

		}

		int[] buy = new int[k];
		Arrays.fill(buy, Integer.MIN_VALUE);

		int[] sell = new int[k];

		int n = prices.length;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < k; j++) {

				buy[j] = Math.max(buy[j], j == 0 ? 0 - prices[i] : sell[j - 1] - prices[i]);
				sell[j] = Math.max(sell[j], buy[j] + prices[i]);

			}

		}

		return sell[k - 1];

	}

}
