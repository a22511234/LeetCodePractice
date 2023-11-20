package practice;

import java.util.Arrays;

public class LeetCode_73_SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void setZeroes(int[][] matrix) {
		int ans[][] = new int[matrix.length][matrix[0].length];
		for (int k = 0; k < ans.length; k++) {
			Arrays.fill(ans[k], -1);
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					set(matrix, ans, i, j);
				} else {
					if (ans[i][j] != 0) {
						ans[i][j] = matrix[i][j];
					}
				}
			}
		}
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				matrix[i][j]=ans[i][j];
			}
		}
	}

	public static void set(int[][] matrix, int ans[][], int i, int j) {
		for (int k = i; k < ans.length; k++) {// 下
			ans[k][j] = 0;
		}
		for (int k = i; k >= 0; k--) {// 上
			ans[k][j] = 0;
		}
		for (int k = j; k >= 0; k--) {// 左
			ans[i][k] = 0;
		}
		for (int k = j; k < ans[0].length; k++) { // 右
			ans[i][k] = 0;
		}
	}
}
