package practice;

public class LeetCode_198_HouseRobber {

	public static void main(String[] args) {
		int arr[] = { 1,  2, 3, 1};
		System.out.println("Max : " + rob(arr));

	}

	public static int rob(int[] nums) {
		int n = nums.length;
		int rob[] = new int[n];
		rob[0] = nums[0];
		for (int i = 1; i < n; i++) {
			if (i < 2)
				rob[1] = Math.max(rob[i - 1], nums[i]);
			else {
				rob[i] = Math.max(nums[i] + rob[i - 2], rob[i - 1]);

			}
		}

		return rob[n - 1];

	}
}
