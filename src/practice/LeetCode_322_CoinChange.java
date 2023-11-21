package practice;

import java.util.Arrays;

public class LeetCode_322_CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = { 2 };
		System.out.print(coinChange2(coins, 3));
	}

	public static int coinChange(int[] coins, int amount) {// geedy未必有最佳解
		int count = 0;
		int remain = amount;
		Arrays.sort(coins);
		for (int i = coins.length - 1; i >= 0; i--) {
			count += remain / coins[i];
			remain = remain % coins[i];
			if (remain == 0)
				return count;
		}

		return -1;

	}

	public static int coinChange2(int[] coins, int amount) {
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0)
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];

	}
}
