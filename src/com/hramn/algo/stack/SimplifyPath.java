package com.hramn.algo.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * 71. Simplify Path
 * 
 * You are given an absolute path for a Unix-style file system, which always 
 * begins with a slash '/'. Your task is to transform this absolute path into 
 * its simplified canonical path.
 * 
 * The rules of a Unix-style file system are as follows:
 * - A single period '.' represents the current directory.
 * - A double period '..' represents the previous/parent directory.
 * - Multiple consecutive slashes such as '//' and '///' are treated as a 
 *   single slash '/'.
 * - Any sequence of periods that does not match the rules above should be 
 *   treated as a valid directory or file name. For example, '...' and '....' 
 *   are valid directory or file names.
 *   
 * The simplified canonical path should follow these rules:
 * - The path must start with a single slash '/'.
 * - Directories within the path must be separated by exactly one slash '/'.
 * - The path must not end with a slash '/', unless it is the root directory.
 * - The path must not have any single or double periods ('.' and '..') used to 
 *   denote current or parent directories.
 * 
 * Return the simplified canonical path.
 * 
 * Example 1:
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation:
 * The trailing slash should be removed.
 * 
 * Example 2:
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation:
 * Multiple consecutive slashes are replaced by a single one.
 * 
 * Example 3:
 * Input: path = "/home/user/Documents/../Pictures"
 * Output: "/home/user/Pictures"
 * Explanation:
 * A double period ".." refers to the directory up a level (the parent directory).
 * 
 * Example 4:
 * Input: path = "/../"
 * Output: "/"
 * Explanation:
 * Going one level up from the root directory is not possible.
 * 
 * Example 5:
 * Input: path = "/.../a/../b/c/../d/./"
 * Output: "/.../b/d"
 * Explanation:
 * "..." is a valid name for a directory in this problem.
 * 
 * Constraints:
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 */
public class SimplifyPath {

	public static void main(String[] args) {
		String path = "/a/b/.././//...//c///";
		Solution solution = new Solution();
		String result = solution.simplifyPath(path);
		System.out.println(result);
		assert result.equals("/a/.../c");
	}

	static class Solution {
		public String simplifyPath(String path) {
			List<String> stack = new LinkedList<>();
			String[] arr = path.split("/");
			for (String str : arr) {
				if (str.length() > 0) {
					if (str.equals("..")) {
						if (!stack.isEmpty()) {
							stack.removeLast();
						}
					} else if (!str.equals(".")) {
						stack.add(str);
					}
				}
			}
			if (stack.size() == 0) {
				return "/";
			}
			StringBuilder sb = new StringBuilder();
			for (String str : stack) {
				sb.append("/").append(str);
			}
			return sb.toString();
		}
	}
}
