package practice;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_76_MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.print(minWindow(s,t));
	}

	public static String minWindow(String s, String t) {
		String ans = new String();
		Map<Character, Integer> map = new HashMap<>(); // t出現的每隔字 與 次數
		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}
		
		int left = 0;
		int right = 0;
		ans = "";
		int len = Integer.MAX_VALUE;
		int count = 0;//計算符合字母的個數
		while (right < s.length()) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {//判斷我取得值有沒有包含在t裏
				map.put(c, map.get(c) - 1);//有的話 頻率次數減一
				if (map.get(c) >= 0)
					count++;//符合了 加一 計算符合字母的個數

				while (count == t.length()) { //當我符合個數等於我字串長度時 判斷 有沒有最短的
					if (right - left + 1 < len) {//比較長度大小
						len = right - left + 1;
						ans = s.substring(left, right + 1);//結果
					}
					if (map.containsKey(s.charAt(left))) {//由左邊開始判斷 能不能縮短字串長度
						map.put(s.charAt(left), map.get(s.charAt(left) )+ 1);
						if(map.get(s.charAt(left))>0) {
							count--;
						}
					}
					left++;  
				}
			}
			right++;
		}

		return ans;
	}
}
