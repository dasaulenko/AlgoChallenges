package com.hramn.algo;
/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description
 * 
 * You are given an integer array height of length n. There are n vertical 
 * lines drawn such that the two endpoints of the ith line are (i, 0) and (i, 
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that 
 * the container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array 
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) 
 * the container can contain is 49.
 * 
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * 
 *  Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 
 * TAG: medium
 * TAG: windowed
 */
public class ContainerWithMostWater {
	class Solution { // O(N), O(1), where N = height.length
		public int maxArea(int[] height) {
			int n = height.length;
			int i = 0;
			int j = n-1;
			int result = 0;
			while (i < j) {
				int v = (j-i) * Math.min(height[i], height[j]);
				result = Math.max(result, v);
				if (height[i] < height[j]) i++;
				else j--;
			}
			return result;
		}
	}
}
