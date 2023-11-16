package practice;

public class LeetCode_53_MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -2,1};
		System.out.println("Max : " + maxSubArray2(arr));
	}

	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int currentmax = 0;
		for (int i = 0; i < nums.length; i++) {
			currentmax += nums[i];
			if (currentmax > max)
				max = currentmax;
			if (currentmax < 0) {
				//如果當前和currentSum變為負數，則表示將目前元素包含在子數組中會減少總和。
				//在這種情況下，我們重置currentSum為 0。
				//這實際上會丟棄當前子數組，並允許我們從下一個元素開始一個新的子數組。
				currentmax = 0;
			}
		}

		return max;
	}

	public static int maxSubArray2(int[] nums) {
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int currentmax = 0;
			currentmax += nums[i];
			if (currentmax > max)
				max = currentmax;
			for (int j = i + 1; j < nums.length; j++) {
				currentmax += nums[j];
				if (currentmax > max)
					max = currentmax;
			}
		}

		return max;
	}
}
