package com.hramn.algo;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 3025. Find the Number of Ways to Place People I
 * https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/description
 * 
 * You are given a 2D array points of size n x 2 representing integer 
 * coordinates of some points on a 2D plane, where points[i] = [xi, yi].
 * 
 * Count the number of pairs of points (A, B), where
 * - A is on the upper left side of B, and
 * - there are no other points in the rectangle (or line) they make (including 
 *   the border).
 * 
 * Return the count.
 * 
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 0
 * Explanation:
 * There is no way to choose A and B so A is on the upper left side of B.
 * 
 * Example 2:
 * Input: points = [[6,2],[4,4],[2,6]]
 * Output: 2
 * Explanation:
 * The left one is the pair (points[1], points[0]), where points[1] is on 
 * the upper left side of points[0] and the rectangle is empty.
 * The middle one is the pair (points[2], points[1]), same as the left one 
 * it is a valid pair.
 * The right one is the pair (points[2], points[0]), where points[2] is on 
 * the upper left side of points[0], but points[1] is inside the rectangle so 
 * it's not a valid pair.
 * 
 * Example 3:
 * Input: points = [[3,1],[1,3],[1,1]]
 * Output: 2
 * Explanation:
 * The left one is the pair (points[2], points[0]), where points[2] is on 
 * the upper left side of points[0] and there are no other points on 
 * the line they form. Note that it is a valid state when the two points form 
 * a line.
 * The middle one is the pair (points[1], points[2]), it is 
 * a valid pair same as the left one.
 * The right one is the pair (points[1], points[0]), it is not 
 * a valid pair as points[2] is on the border of the rectangle.
 * 
 * Constraints:
 * 2 <= n <= 50
 * points[i].length == 2
 * 0 <= points[i][0], points[i][1] <= 50
 * All points[i] are distinct.
 * 
 * TAG: 20250902
 * TAG: medium
 * TAG: coordinates
 */
public class FindNumberOfWaysToPlacePeopleI {
	class Solution { // O(N^3), O(N)
		public int numberOfPairs(int[][] points) {
			int n = points.length;
			Arrays.sort(points, (a,b) -> {
				int r = a[0] - b[0];
				if (r == 0) {
					return b[1] - a[1];
				}
				return r;
			});
			int result = 0;
			for (int l = 0; l < n-1; l++) {
				int[] tl = points[l];
				Set<Integer> ys = new TreeSet<>();
				for (int r = l+1; r < n; r++) {
					int[] br = points[r];
					if (br[1] <= tl[1]) {
						boolean res = false;
						for (int y : ys) {
							if (y >= br[1] && y <= tl[1]) {
								res = true;
								break;
							} else if (y > tl[1]) {
								break;
							}
						}
						if (!res) {
							result++;
						}
					}
					ys.add(br[1]);
				}
			}
			return result;
		}
	}
}
