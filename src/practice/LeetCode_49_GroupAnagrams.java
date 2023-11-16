package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_49_GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs[] = { "ate", "eat", "tea" };
		List<List<String>> a = groupAnagrams(strs);
		for (int j = 0; j < a.size(); j++) {
			for (int i = 0; i < a.get(j).size(); i++) {
				System.out.print(a.get(j).get(i) + " ");
			}
			System.out.println();
		}
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		int n = strs.length;
		boolean temp[] = new boolean[n];
		List<List<String>> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			List<String> temps = new ArrayList<>();
			if (n == 0) {
				temps.add(strs[i]);
				temp[i] = true;
			}
			if (temp[i] == false) {
				String content = strs[i];
				char[] StringtoChar = content.toCharArray();
				Arrays.sort(StringtoChar);
				temps.add(strs[i]);
				temp[i] = true;
				for (int j = i + 1; j < n; j++) {
					String now = strs[j];
					char[] toChar = now.toCharArray();
					Arrays.sort(toChar);
					if (Arrays.equals(StringtoChar, toChar)) {
						temps.add(strs[j]);
						temp[j] = true;
					}
				}
				ans.add(temps);
			}
		}

		return ans;

	}

	public static List<List<String>> groupAnagrams2(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<>();
		}

		Map<String, List<String>> map = new HashMap<>();

		for (String i : strs) {
			char[] chars = i.toCharArray();
			Arrays.sort(chars);
			String sortedStr = String.valueOf(chars);

			if (!map.containsKey(sortedStr)) {
				map.put(sortedStr, new ArrayList<>());
			}

			map.get(sortedStr).add(i);
		}

		return new ArrayList<>(map.values());

	}
}
