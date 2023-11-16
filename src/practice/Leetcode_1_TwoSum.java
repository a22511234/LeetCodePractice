package practice;

import java.util.Arrays;

public class Leetcode_1_TwoSum {

	public static void main(String[] args) {
		int arr[]= {2,5,5,11};
		int targer = 10;
		System.out.println(Arrays.toString(twoSum(arr,targer)));

	}

	public static int[] twoSum(int[] nums, int target) {
		int ans[] = {-1,-1};
		for (int j = 0; j < nums.length; j++) {
			int remain = target - nums[j];
			ans[0] = j;
			for (int i = j+1; i < nums.length; i++) {
				if (nums[i] == remain) {
					ans[1] = i;
					break;
				}
			}
			if(ans[1]!=-1)
				break;
			ans[1]=-1;
		}
		return ans;

	}
}
