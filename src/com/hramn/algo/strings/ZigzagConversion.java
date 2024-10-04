package com.hramn.algo.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Zigzag Conversion
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
 * of rows like this: (you may want to display this pattern in a fixed font for 
 * better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a 
 * number of rows:
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 * 
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class ZigzagConversion {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "ABCDEFGHIJKLMN";
		String result = solution.convert(s, 4);
		System.out.println(result);
		assert result == "AGMBFHLNCEIKDJ";

	}
	
	// s = “ABCDEFGHIJKLMN” numRows = 4
	//      12343212343212
	// A     G    M
	// B   F H   L  N
	// C E   I K
	// D     J
	//* if the length of the string is less or equal then numRows than return
	//the length of the string
	//* if numRows is equal one than return the length of the string

	static class Solution {
	    public String convert(String s, int numRows) {
	        if (s.length() <= numRows || numRows == 1) {
		        return s;
	        }
			StringBuilder result = new StringBuilder();
			List<Character>[] rows = new ArrayList[numRows];
	        int index = 0, k = 1;
	        boolean b = false;
	        for (Character ch : s.toCharArray()) {
		        if (rows[index] == null) {
	                rows[index] = new ArrayList<>();
	            }
	            rows[index].add(ch);
		        if ((b && index == 0) || index == numRows - 1) {
		            k *= -1;
		            b = true;
	            }
	            index += k;
	        }
	        for (int i = 0; i < numRows; i++) {
		        for (Character ch: rows[i]) {
		            result.append(ch);
	            }
	        }
	        return result.toString();
	    }
	}
	
}
