package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_57_InsertInterval {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 2, 5 };
		int[][] newIntervals = insert(intervals, newInterval);
		for (int i = 0; i < newIntervals.length; i++) {
				System.out.println(Arrays.toString(newIntervals[i]));
		}

	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> temp = new ArrayList<>();
		int n = intervals.length;
		int index = 0;
		while (index < n && newInterval[0] > intervals[index][1]) {
			temp.add(intervals[index]);
			index++;
		}
		while (index < n && newInterval[1] >= intervals[index][0]) {
			newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
			index++;
		}
		temp.add(newInterval);
		while (index < n) {
			temp.add(intervals[index]);
			index++;
		}
		return temp.toArray(new int[temp.size()][]);
	}
}
