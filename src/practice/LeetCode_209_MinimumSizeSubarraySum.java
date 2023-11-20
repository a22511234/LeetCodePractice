package practice;

public class LeetCode_209_MinimumSizeSubarraySum {

	public int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int right = 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;

		for (; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= target) {
				res = Math.min(right - left + 1, res);
				sum -= nums[left];
				left++;
			}
		}
		if (res == Integer.MAX_VALUE)
			return 0;
		else
			return res;
	}

}
