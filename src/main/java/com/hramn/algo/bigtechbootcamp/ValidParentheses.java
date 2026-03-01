package com.hramn.algo.bigtechbootcamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Task
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and 
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * - Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * 
 * Example 4:
 * Input: s = "([])"
 * Output: true
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 10**4
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

	class Solution_20250220 {
		public boolean isValid (String s) {
			if ( s == null || s.length() == 1) return false;

			char[] chars = s.toCharArray();
			Stack<Character> stack = new Stack<>();
			stack.push(chars[0]);
			int l = 1;

			Map<Character, Character> map = new HashMap<>();
			map.put(')', '(');
			map.put(']','[');
			map.put('}', '{');

			while (l < chars.length) {
				Character ch = map.get(chars[l]);
				if (ch != null) {
					if (stack.pop().charValue() != ch) {
						return false;
					}
				} else {
					stack.push(chars[l]);
				}
				l++;
			}

			return stack.isEmpty();
		}
	}



	class Solution {
	    public boolean isValid(String s) {
	        char[] arr = s.toCharArray();
	        Stack<Character> stack = new Stack<>();
	        for (int i = 0; i < arr.length; i++) {
	        	if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
	        		stack.push(arr[i]);
	        	} else if (!stack.isEmpty()) {
	        		char l = stack.pop();
	        		if ((l == '(' && arr[i] != ')') 
	        				|| (l == '[' && arr[i] != ']')
	        				|| (l == '{' && arr[i] != '}')) {
	        			return false;
	        		}
	        	} else {
	        		return false;
	        	}
	        }
	        if (!stack.isEmpty()) {
	        	return false;
	        }
	        return true;
	    }
	}
	
	class Solution_best_runtime {
	    public boolean isValid(String s) {
	        char[] list = new char[s.length()];
	        int index = -1;
	        for(char c : s.toCharArray()) {
	        	if(c == '(') list[++index] = ')';
	            else if(c == '[') list[++index] = ']';
	            else if(c == '{') list[++index] = '}';
	            else if(index == -1 || list[index--] != c) return false;
	        }
	        return index == -1;
	    }
	}
	
	class Solution_best_memory {
	    public boolean isValid(String s) {
	        Stack<Character> stack = new Stack<>();
	        
	        for (char c : s.toCharArray()) {
	            if (c == '(' || c == '{' || c == '[') {
	                stack.push(c);
	            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
	                stack.pop();
	            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
	                stack.pop();
	            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
	                stack.pop();
	            } else {
	                return false;
	            }
	        }
	        
	        return stack.isEmpty();
	    }
	}
}
