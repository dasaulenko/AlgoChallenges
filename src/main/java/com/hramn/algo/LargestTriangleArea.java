package com.hramn.algo;
/**
 * 812. Largest Triangle Area
 * https://leetcode.com/problems/largest-triangle-area/description
 * 
 * Given an array of points on the X-Y plane points where points[i] = [xi, yi], 
 * return the area of the largest triangle that can be formed by any three 
 * different points. Answers within 10-5 of the actual answer will be accepted.
 * 
 * Example 1:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2.00000
 * Explanation: The five points are shown in the above figure. The red triangle 
 * is the largest.
 * 
 * Example 2:
 * Input: points = [[1,0],[0,0],[0,1]]
 * Output: 0.50000
 * 
 * Constraints:
 * 3 <= points.length <= 50
 * -50 <= xi, yi <= 50
 * All the given points are unique.
 * 
 * TAG: easy
 * TAG: triangle area
 */
public class LargestTriangleArea {
	class Solution { // O(N^3), O(1), where N = points.length
		public double largestTriangleArea(int[][] points) {
			int n = points.length;
			double max = 0;
			for (int i = 0; i < n-2; i++) {
				int x1 = points[i][0];
				int y1 = points[i][1];
				for (int j = i+1; j < n-1; j++) {
					int x2 = points[j][0];
					int y2 = points[j][1];
					int x2x1 = x2 - x1;
					int y2y1 = y2 - y1;
					for (int k = j+1; k < n; k++) {
						int x3 = points[k][0];
						int y3 = points[k][1];
						int x3x1 = x3 - x1;
						int y3y1 = y3 - y1;
						double s = 0.5 * Math.abs((x2x1 * y3y1) - (y2y1 * x3x1));
						max = Math.max(max, s);
					}
				}
			}
			return max;
		}
	}
}
