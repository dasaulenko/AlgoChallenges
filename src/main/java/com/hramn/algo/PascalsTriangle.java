package com.hramn.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/description
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly 
 * above it.
 * 
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * 
 * Constraints:
 * 1 <= numRows <= 30
 * 
 * TAG: 20250801
 * TAG: easy
 * TAG: array
 */
public class PascalsTriangle {
	class Solution { // O(N^2), O(1)
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < numRows; i++) {
				List<Integer> row = new ArrayList<>();
				result.add(row);
				if (i == 0) {
					row.add(1);
				} else if (i == 1) {
					row.add(1);
					row.add(1);
				} else {
					row.add(1);
					int prev = 1;
					for (int j = 1; j < i; j++) {
						int num = result.get(i-1).get(j);
						row.add(prev + num);
						prev = num;
					}
					row.add(1);
				}
			}
			return result;
		}
	}
}
