package practice;

import java.util.Arrays;

public class LeetCode_242_ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isAnagram(String s, String t) {
		char[] stoarray = s.toCharArray();
		char[] ttoarray = t.toCharArray();
		Arrays.sort(stoarray);
		Arrays.sort(ttoarray);
    	
    	return Arrays.equals(stoarray, ttoarray);
    	
    }
}
