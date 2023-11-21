package practice;

public class LeetCode_11_ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1, 1 };
		System.out.print(maxArea2(height));
	}

	public static int maxArea(int[] height) {
		// Time Limit Exceeded
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int h = Math.min(height[i], height[j]);
				int w = j - i;
				max = Math.max(max, h * w);
			}
		}
		return max;
	}

	public static int maxArea2(int[] height) {
		// Time Limit Exceeded
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int w = right - left;
			int h = Math.min(height[left], height[right]);
			int area = h * w;
			max = Math.max(max, area);
			if (height[left] < height[right]) {
				left++;
			} else if (height[left] > height[right]) {
				right--;
			} else {
				left++;
				right--;
			}
		}
		return max;
	}
}
