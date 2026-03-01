package com.hramn.algo;

import java.util.LinkedList;
import java.util.List;

/**
 * 3439. Reschedule Meetings for Maximum Free Time I
 * https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/description
 * 
 * You are given an integer eventTime denoting the duration of an event, where 
 * the event occurs from time t = 0 to time t = eventTime.
 * 
 * You are also given two integer arrays startTime and endTime, each of 
 * length n. These represent the start and end time of n non-overlapping 
 * meetings, where the ith meeting occurs during the time [startTime[i], 
 * endTime[i]].
 * 
 * You can reschedule at most k meetings by moving their start time while 
 * maintaining the same duration, to maximize the longest continuous period of 
 * free time during the event.
 * 
 * The relative order of all the meetings should stay the same and they should 
 * remain non-overlapping.
 * 
 * Return the maximum amount of free time possible after rearranging 
 * the meetings.
 * 
 * Note that the meetings can not be rescheduled to a time outside the event.
 * 
 * Example 1:
 * Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
 * Output: 2
 * Explanation:
 * Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during 
 * the time [0, 2].
 * 
 * Example 2:
 * Input: eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]
 * Output: 6
 * Explanation:
 * Reschedule the meeting at [2, 4] to [1, 3], leaving no meetings during 
 * the time [3, 9].
 * 
 * Example 3:
 * Input: eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
 * Output: 0
 * Explanation:
 * There is no time during the event not occupied by meetings.
 * 
 * Constraints:
 * 1 <= eventTime <= 10^9
 * n == startTime.length == endTime.length
 * 2 <= n <= 10^5
 * 1 <= k <= n
 * 0 <= startTime[i] < endTime[i] <= eventTime
 * endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].
 * 
 * TAG: 20250712
 * TAG: medium
 * TAG: reschedule
 * TAG: prefix_sums
 * TAG: sliding_window
 */
public class RescheduleMeetingsForMaximumFreeTimeI {
	class Solution { // O(N), O(N + M), N - startTime.length, M - k
		public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
			int n = startTime.length;
			int[] gaps = new int[n+1];
			int prev = 0;
			for (int i = 0; i < n; i++) {
				gaps[i] = startTime[i] - prev;
				prev = endTime[i];
			}
			gaps[n] = eventTime - prev;
			int curentSize = gaps[0] + gaps[1];
			int maxSize = curentSize;
			List<Integer> queue = new LinkedList<>();
			queue.add (gaps[0]);
			queue.add (gaps[1]);
			for (int i = 1; i < n; i++) {
				if (queue.size() > k) {
					int dif = queue.removeFirst();
					curentSize -= dif;
				}
				curentSize += gaps[i+1];
				queue.add(gaps[i+1]);
				maxSize = Math.max(maxSize, curentSize);
			}
			return maxSize;
		}
	}

	class OptSolution {// O(N), O(N), N - startTime.length
		public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
			int n = startTime.length;
			int[] prefixSum = new int[n + 1];
			int maxFree = 0;

			for (int i = 0; i < n; i++) {
				prefixSum[i + 1] = prefixSum[i] + endTime[i] - startTime[i];
			}

			for (int i = k - 1; i < n; i++) {
				int occupied = prefixSum[i + 1] - prefixSum[i - k + 1];
				int windowEnd = (i == n - 1) ? eventTime : startTime[i + 1];
				int windowStart = (i == k - 1) ? 0 : endTime[i - k];
				int freeTime = windowEnd - windowStart - occupied;
				maxFree = Math.max(maxFree, freeTime);
			}

			return maxFree;
		}
	}
}
