package practice;

import java.util.Stack;

public class LeetCode_20_ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("(){}}{"));

	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(')');
			else if (s.charAt(i) == '{')
				stack.push('}');
			else if (s.charAt(i) == '[')
				stack.push(']');
			else {
				if (stack.empty() || s.charAt(i) != stack.pop()) {
					return false;
				}
			}
		}
		
			return stack.empty();
		
	}
}
