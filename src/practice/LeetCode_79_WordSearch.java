package practice;

public class LeetCode_79_WordSearch {

	public static void main(String[] args) {
		char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCC";
		System.out.println(exist2(board, word));
	}

	// 一開始寫法
	public static boolean exist(char[][] board, String word) {
		int index = 0;
		char findchar = word.charAt(index);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (findchar == board[i][j]) {
					index++;
					findchar = word.charAt(index);
					boolean ans = search(board, index, word, i, j);
					if (ans == true) {
						return true;
					}
				}

			}
		}
		return false;

	}

	public static boolean search(char[][] board, int index, String w, int col, int row) {
		if (index == w.length()) {
			return true;
		} else if (board[col][row + 1] == w.charAt(index) && (row + 1 < board[col].length)) {
			index++;
			return search(board, index, w, col, row + 1);
		} else if (board[col][row - 1] == w.charAt(index) && (row - 1 > 0)) {
			index++;
			return search(board, index, w, col, row - 1);
		} else if (board[col + 1][row] == w.charAt(index) && (col + 1 < board.length)) {
			index++;
			return search(board, index, w, col + 1, row);
		} else if (board[col - 1][row] == w.charAt(index) && (col - 1 > 0)) {
			index++;
			return search(board, index, w, col - 1, row);
		} else
			return false;
	}

	// 參考寫法
	public static boolean exist2(char[][] board, String word) {
		boolean visited[][] = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && search2(board, word, i, j, 0, visited)) {
					return true;
				}
			}
		}
		return false;

	}

	public static boolean search2(char[][] board, String word, int i, int j, int idx, boolean visited[][]) {
		if (idx == word.length()) {
			return true;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)
				|| visited[i][j]) {
			return false;
		}
		visited[i][j] = true;
		if (search2(board, word, i + 1, j, idx + 1, visited) || 
				search2(board, word, i, j + 1, idx + 1, visited)
				|| search2(board, word, i - 1, j, idx + 1, visited)
				|| search2(board, word, i, j - 1, idx + 1, visited)) {
			return true;
		}
		visited[i][j] = false;
		return false;
	}
}
