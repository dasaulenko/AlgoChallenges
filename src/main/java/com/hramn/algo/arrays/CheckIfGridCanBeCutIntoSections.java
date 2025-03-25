package com.hramn.algo.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description
 * 
 * 3394. Check if Grid can be Cut into Sections
 * 
 * You are given an integer n representing the dimensions of an n x n grid, 
 * with the origin at the bottom-left corner of the grid. You are also given 
 * a 2D array of coordinates rectangles, where rectangles[i] is in the form 
 * [start(x), start(y), end(x), end(y)], representing a rectangle on the grid. 
 * Each rectangle is defined as follows:
 * - (start(x), start(y)): The bottom-left corner of the rectangle.
 * - (end(x), end(y)): The top-right corner of the rectangle.
 * Note that the rectangles do not overlap. Your task is to determine if it is 
 * possible to make either two horizontal or two vertical cuts on the grid such 
 * that:
 * - Each of the three resulting sections formed by the cuts contains at least 
 *   one rectangle.
 * - Every rectangle belongs to exactly one section.
 * 
 * Return true if such cuts can be made; otherwise, return false.
 * 
 * Example 1:
 * Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
 * Output: true
 * Explanation:
 * The grid is shown in the diagram. We can make horizontal cuts at y = 2 and 
 * y = 4. Hence, output is true.
 * 
 * Example 2:
 * Input: n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]
 * Output: true
 * Explanation:
 * We can make vertical cuts at x = 2 and x = 3. Hence, output is true.
 * 
 * Example 3:
 * Input: n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],
 * [3,2,4,4]]
 * Output: false
 * Explanation:
 * We cannot make two horizontal or two vertical cuts that satisfy the 
 * conditions. Hence, output is false.
 * 
 * Constraints:
 * 3 <= n <= 10^9
 * 3 <= rectangles.length <= 10^5
 * 0 <= rectangles[i][0] < rectangles[i][2] <= n
 * 0 <= rectangles[i][1] < rectangles[i][3] <= n
 * No two rectangles overlap.
 */
public class CheckIfGridCanBeCutIntoSections {
	class SortSolution { // O(N * log(N)), O(N)
		public boolean checkValidCuts(int n, int[][] rectangles) {
			int[][] xInter = new int[rectangles.length][2];
			int[][] yInter = new int[rectangles.length][2];
			for (int i = 0; i < rectangles.length; i++) {
				xInter[i][0] = rectangles[i][0];
				xInter[i][1] = rectangles[i][2];
				yInter[i][0] = rectangles[i][1];
				yInter[i][1] = rectangles[i][3];
			}
			return check(xInter) || check(yInter);
		}

		private boolean check(int[][] inter) {
			Arrays.sort(inter, (a,b) -> Integer.compare(a[0], b[0]));
			int count = 0;
			int xMax = 0;
			for (int[] arr : inter) {
				if (arr[0] >= xMax && ++count == 3) {
					return true;
				}
				xMax = Math.max(xMax, arr[1]);
			}
			return false;
		}
	}
	
	class BruteforceSolution { // O(N^2), O(N)
		public boolean checkValidCuts(int n, int[][] rectangles) {
			List<int[]> x = new LinkedList<>();
			List<int[]> y = new LinkedList<>();
			x.add(new int[]{rectangles[0][0], rectangles[0][2]});
			y.add(new int[]{rectangles[0][1], rectangles[0][3]});
			for (int i = 1; i < rectangles.length; i++) {
				int x1 = rectangles[i][0], x2 = rectangles[i][2];
				int y1 = rectangles[i][1], y2 = rectangles[i][3];
				Iterator<int[]> iterator = x.iterator();
				while (iterator.hasNext()) {
					int[] arr = iterator.next();
					if (!((x1 < arr[0] && x2 <= arr[0]) || (x1 >= arr[1] && x2 > arr[1]))) {
						iterator.remove();
						x1 = x1 < arr[0] ? x1 : arr[0];
						x2 = x2 > arr[1] ? x2 : arr[1];
					} 
				}
				x.add(new int[]{x1, x2});
				iterator = y.iterator();
				while (iterator.hasNext()) {
					int[] arr = iterator.next();
					if (!((y1 < arr[0] && y2 <= arr[0]) || (y1 >= arr[1] && y2 > arr[1]))) {
						iterator.remove();
						y1 = y1 < arr[0] ? y1 : arr[0];
						y2 = y2 > arr[1] ? y2 : arr[1];
					} 
				}
				y.add(new int[]{y1, y2});
			}
			if (x.size() >= 3 || y.size() >= 3) {
				return true;
			}
			return false;
		}
	}
}
