package practice;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_54_SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		int left = 0, right = col - 1, top = 0, buttom = row - 1;
		while (left <= right && top <= buttom) {
			for (int i = left; i <= right; i++) {
				ans.add(matrix[top][i]);
			}
			top++;
			for (int i = top; i <= buttom; i++) {
				ans.add(matrix[i][right]);
			}
			right--;
			
			if(top<=buttom) {
				for (int i =right; i >= left; i--) {
					ans.add(matrix[buttom][i]);
				}
				buttom--;
			}
			if(left<=right) {
				for (int i =buttom; i >= top; i--) {
					ans.add(matrix[i][left]);
				}
				left++;
			}
		}
		
		return ans;
	}
}
