package practice;

import java.util.Arrays;

public class LeetCode_435_NonOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public static int eraseOverlapIntervals(int[][] intervals) {
         if (intervals.length == 0) { 
            return 0; 
        } 
        //Sort the intervals by end time 
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); 
        //Initialize the previous interval to the first one 
        int num_removed = 0, prev_interval_end = intervals[0][1]; 
        for (int i = 1; i < intervals.length; i++) { 
            if (intervals[i][0] < prev_interval_end) { 
                num_removed++; 
            } else { 
                prev_interval_end = intervals[i][1]; 
            } 
        } 

        return num_removed; 
    }
}
