package practice;

import java.util.Arrays;

public class LeetCode_121_BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 5, 5, 11 };
		System.out.println(maxProfit(arr));
		System.out.println(maxProfit2(arr));
	}

	public static int maxProfit(int[] prices) {
		int max = 0;

		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if (profit > 0) {
					max = Math.max(max, profit);
				}
			}
		}

		return max;
	}

	public static int maxProfit2(int[] prices) {
		int max = 0;
		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}

			else if ((prices[i] - min) > max) {
				max = prices[i] - min;
			}
		}
		return max;
	}

}
