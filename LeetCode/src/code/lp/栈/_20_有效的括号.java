package code.lp.栈;

import java.util.Stack;

public class _20_有效的括号 {

	/*
	 * https://leetcode-cn.com/problems/valid-parentheses/
	 */

	/*
	 * 注意带括号
	 */

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();

		char[] charArray = s.toCharArray();

		for (char c : charArray) {
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			} else if (c == '}' || c == ']' || c == ')') {

				if (stack.isEmpty()) { // 必须判断！
					return false;
				}

				char top = stack.pop();

				if (top == '{') {
					if (c != '}') {
						return false;
					}
				} else if (top == '[') {
					if (c != ']') {
						return false;
					}
				} else if (top == '(') {
					if (c != ')') {
						return false;
					}
				}
			} else
				return false;
		}

		return stack.isEmpty();

	}

//
//	public boolean isValid2(String s) {
//		if (null == s)
//			return false;
//		else if (s.equals(""))
//			return true;
//		else {
//			Stack<Character> stack = new Stack<Character>();
//			char[] charArray = s.toCharArray();
//			for (char c : charArray) {
//				if (c == '{' || c == '[' || c == '(') {
//					stack.push(c);
//				} else if (c == '}' || c == ']' || c == ')') {
//					//
//					if (stack.isEmpty()) // 必须判断！
//						return false;
//
//					switch (c) {
//					case '}':
//						if (stack.peek() != '{')
//							return false;
//						else
//							stack.pop();
//						break;
//					case ']':
//						if (stack.peek() != '[')
//							return false;
//						else
//							stack.pop();
//						break;
//					case ')':
//						if (stack.peek() != '(')
//							return false;
//						else
//							stack.pop();
//						break;
//					}
//				} else
//					return false;
//			}
//			return stack.isEmpty();
//		}
//	}
//

}