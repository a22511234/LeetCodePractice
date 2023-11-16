package practice;

public class LeetCode_200_NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = { 
				{ '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' }, 
				{ '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		int count = 0;
		int i = grid.length;
		int j = grid[0].length;
		for (int index = 0; index < i; index++) {
			for (int index2 = 0; index2 < j; index2++) {
				if (grid[index][index2] == '1') {
					count++;
					destory(index,index2,grid);
				}
			}
		}
		return count;

	}

	public static void destory(int i, int j, char[][] grid) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == '1') {
			grid[i][j] = '0';
			destory(i, j + 1, grid);
			destory(i, j - 1, grid);
			destory(i + 1, j, grid);
			destory(i - 1, j, grid);
		}

	}

}
