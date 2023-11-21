package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_56_MergeIntervals {

	public static void main(String[] args) {
		int[][] interval = { { 1, 4 }, { 0, 4 } };
		interval = merge(interval);
		int[][] intervals = merge2(interval);
		for (int i = 0; i < interval.length; i++) {
			for (int j = 0; j < interval[i].length; j++) {
				System.out.print(interval[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals[i].length; j++) {
				System.out.print(intervals[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> ans = new LinkedList<>(Arrays.asList(intervals));
		int n = ans.size();
		int index = 0;
		if (n == 1 || intervals == null) {
			return ans.toArray(new int[ans.size()][]);
		}
		for (; index < n;) {
			int left[] = ans.get(index);
			int right[] = ans.get(index + 1);
			if (left[1] >= right[0]) {
				int temp[] = new int[2];
				temp[0] = Math.min(left[0], right[0]);
				temp[1] = Math.max(left[1], right[1]);
				ans.set(index, temp);
				ans.remove(index + 1);
				n = ans.size();
			} else {
				index++;
			}
			if (index + 1 == n)
				break;

		}

		return ans.toArray(new int[ans.size()][]);
	}
	public static int[][] merge2(int[][] intervals) {
		List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        if (intervals.length == 0) {
            return ans.toArray(new int[0][]);
        }

        int[] temp = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                ans.add(temp);
                temp = intervals[i];
            }
        }
        ans.add(temp);

        return ans.toArray(new int[0][]);
    
	}
}
