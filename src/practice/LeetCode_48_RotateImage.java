package practice;

public class LeetCode_48_RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[][] matrix) {
		int index = matrix.length;
		for (int i = 0; i < index; i++) {
			for (int j = i + 1; j < index; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
		for (int i = 0; i < index; i++) {
			for (int j = 0; j < index/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][index-j-1];
				matrix[i][index-j-1] = temp;
			}
		}
	}
}
