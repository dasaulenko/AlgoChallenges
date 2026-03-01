package com.hramn.algo;
/**
 * 3440. Reschedule Meetings for Maximum Free Time II
 * https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/description
 * 
 * You are given an integer eventTime denoting the duration of an event. 
 * You are also given two integer arrays startTime and endTime, each of 
 * length n.
 * 
 * These represent the start and end times of n non-overlapping meetings that 
 * occur during the event between time t = 0 and time t = eventTime, where 
 * the ith meeting occurs during the time [startTime[i], endTime[i]].
 * 
 * You can reschedule at most one meeting by moving its start time while 
 * maintaining the same duration, such that the meetings remain non-overlapping, 
 * to maximize the longest continuous period of free time during the event.
 * 
 *  Return the maximum amount of free time possible after rearranging 
 * the meetings.
 * 
 * Note that the meetings can not be rescheduled to a time outside the event 
 * and they should remain non-overlapping.
 * 
 * Note: In this version, it is valid for the relative ordering of the meetings 
 * to change after rescheduling one meeting.
 * 
 * Example 1:
 * Input: eventTime = 5, startTime = [1,3], endTime = [2,5]
 * Output: 2
 * Explanation:
 * Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during 
 * the time [0, 2].
 * 
 * Example 2:
 * Input: eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]
 * Output: 7
 * Explanation:
 * Reschedule the meeting at [0, 1] to [8, 9], leaving no meetings during 
 * the time [0, 7].
 * 
 * Example 3:
 * Input: eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]
 * Output: 6
 * Explanation:
 * Reschedule the meeting at [3, 4] to [8, 9], leaving no meetings during 
 * the time [1, 7].
 * 
 * Example 4:
 * Input: eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
 * Output: 0
 * Explanation:
 * There is no time during the event not occupied by meetings.
 * 
 * Constraints:
 * 1 <= eventTime <= 10^9
 * n == startTime.length == endTime.length
 * 2 <= n <= 10^5
 * 0 <= startTime[i] < endTime[i] <= eventTime
 * endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].
 * 
 * TAG: 20250710
 * TAG: medium
 * TAG: reschedule
 */
public class RescheduleMeetingsForMaximumFreeTimeII {
	class Solution { // O(N), O(N)
		public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
			int n = startTime.length;
			int[] gaps = new int[n+1];
			int[] maxLeft = new int[n];
			gaps[0] = startTime[0];
			maxLeft[0] = gaps[0];
			int prev = endTime[0];
			for (int i = 1; i < n; i++) {
				gaps[i] = startTime[i] - prev;
				maxLeft[i] = Math.max(maxLeft[i-1], gaps[i]);
				prev = endTime[i];
			}
			gaps[n] = eventTime - prev;
			int[] maxRight = new int[n];
			maxRight[n-1] = gaps[n];
			for (int i = n-2; i >= 0; i--) {
				maxRight[i] = Math.max(maxRight[i+1], gaps[i+1]);
			}
			int maxGap = 0;
			for (int i = 0; i < n; i++) {
				int time = endTime[i] - startTime[i];
				if (i > 0 && maxLeft[i-1] >= time) {
					maxGap = Math.max (maxGap, gaps[i] + time + gaps[i+1]);
				} else {
					maxGap = Math.max (maxGap, gaps[i] + gaps[i+1]);
				}
				if (i < n-1 && maxRight[i+1] >= time) {
					maxGap = Math.max (maxGap, gaps[i] + time + gaps[i+1]);
				} else {
					maxGap = Math.max (maxGap, gaps[i] + gaps[i+1]);
				}
			}
			return maxGap;
		}
	}

	class OptSolution { // O(N), O(N)
		public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
			int n = startTime.length;
			int[] gaps = new int[n+1];
			int prev = 0;
			for (int i = 0; i < n; i++) {
				gaps[i] = startTime[i] - prev;
				prev = endTime[i];
			}
			gaps[n] = eventTime - prev;
			int[] maxRight = new int[n];
			for (int i = n-1; i >= 0; i--) {
				maxRight[i] = gaps[i+1];
			}
			int maxLeft = 0;
			int maxGap = 0;
			for (int i = 0; i < n; i++) {
				int event = endTime[i] - startTime[i];
				if (maxLeft >= event) {
					maxGap = Math.max (maxGap, gaps[i] + event + gaps[i+1]);
				} else if (i < n-1 && maxRight[i+1] >= event) {
					maxGap = Math.max (maxGap, gaps[i] + event + gaps[i+1]);
				} else {
					maxGap = Math.max (maxGap, gaps[i] + gaps[i+1]);
				}
				maxLeft = Math.max (maxLeft, gaps[i]);
			}
			return maxGap;
		}
	}
}
