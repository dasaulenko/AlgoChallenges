package com.hramn.algo;

import java.util.Arrays;

/**
 * 1751. Maximum Number of Events That Can Be Attended II
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description
 * 
 * You are given an array of events where events[i] = [startDayi, endDayi, 
 * valuei]. The ith event starts at startDayi and ends at endDayi, and if you 
 * attend this event, you will receive a value of valuei. You are also given 
 * an integer k which represents the maximum number of events you can attend.
 * 
 * You can only attend one event at a time. If you choose to attend an event, 
 * you must attend the entire event. Note that the end day is inclusive: 
 * that is, you cannot attend two events where one of them starts and the other 
 * ends on the same day.
 * 
 * Return the maximum sum of values that you can receive by attending events.
 * 
 * Example 1:
 * Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
 * Output: 7
 * Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value 
 * of 4 + 3 = 7.
 * 
 * Example 2:
 * Input: events = [[1,2,4],[3,4,3],[2,3,10]], k = 2
 * Output: 10
 * Explanation: Choose event 2 for a total value of 10.
 * Notice that you cannot attend any other event as they overlap, and that you 
 * do not have to attend k events.
 * 
 * Example 3:
 * Input: events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3
 * Output: 9
 * Explanation: Although the events do not overlap, you can only attend 3 
 * events. Pick the highest valued three.
 * 
 *  Constraints:
 * 1 <= k <= events.length
 * 1 <= k * events.length <= 10^6
 * 1 <= startDayi <= endDayi <= 10^9
 * 1 <= valuei <= 10^6
 * 
 * TAG: hard
 * TAG: dp
 * TAG: binary_search
 * TAG: sort
 */
public class MaximumNumberOfEventsThatCanBeAttendedII {
	class Solution { // O(N * (K + log(N))), O(N * K) where N = events.length, K = k
		public int maxValue(int[][] events, int k) {
			
			// Sort events by end date in ascending order
			Arrays.sort(events, (a, b) -> a[1] - b[1]); 
			int n = events.length;
			
			// Initialise DP array
			int[][] dp = new int[n + 1][k + 1];

			for (int i = 1; i <= n; i++) {
				int[] event = events[i - 1];
				// Find the last event that does not overlap with the current event 
				// using binary search
				int prev = binarySearch(events, event[0]);

            for (int j = 1; j <= k; j++) {
								// The new value is the value of the current event plus 
								// the best value from the first prev events with j-1 selections
                dp[i][j] = Math.max(dp[i - 1][j], dp[prev + 1][j - 1] + event[2]);
            }
        }
        return dp[n][k];
    }

		// find the rightmost event that ends before currentStart
    private int binarySearch(int[][] events, int currentStart) {
        int left = 0, right = events.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < currentStart) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
}
