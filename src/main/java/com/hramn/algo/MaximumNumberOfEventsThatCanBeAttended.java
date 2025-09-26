package com.hramn.algo;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1353. Maximum Number of Events That Can Be Attended
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description
 * 
 * You are given an array of events where events[i] = [startDayi, endDayi]. 
 * Every event i starts at startDayi and ends at endDayi.
 * 
 * You can attend an event i at any day d where startDayi <= d <= endDayi. You 
 * can only attend one event at any time d.
 * 
 * Return the maximum number of events you can attend.
 * 
 * Example 1:
 * Input: events = [[1,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: You can attend all the three events.
 * One way to attend them all is as shown.
 * Attend the first event on day 1.
 * Attend the second event on day 2.
 * Attend the third event on day 3.
 * 
 * Example 2:
 * Input: events= [[1,2],[2,3],[3,4],[1,2]]
 * Output: 4
 * 
 * Constraints:
 * 1 <= events.length <= 10^5
 * events[i].length == 2
 * 1 <= startDayi <= endDayi <= 10^5
 * 
 * TAG: 20250710
 * TAG: medium
 * TAG: heap
 * TAG: PriorityQueue
 * TAG: sort
 */
public class MaximumNumberOfEventsThatCanBeAttended {
	class Solution { // O(N*log(N)), O(N), N - events.length
		public int maxEvents(int[][] events) {
			int n = events.length;
			Arrays.sort (events, (a,b) -> a[0] - b[0]);
			int maxEnd = 0;
			for (int[] e : events) {
				maxEnd = Math.max(maxEnd, e[1]);
			}
			PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
			int index = 0;
			int counter = 0;
			for (int i = events[0][0]; i <= maxEnd; i++) {
				while (index < n && events[index][0] <= i) {
					heap.add(events[index++]);
				}
				while (!heap.isEmpty() && heap.peek()[1] < i) {
					heap.poll();
				}
				if (!heap.isEmpty()) {
					heap.poll();
					counter++;
				}
			}
			return counter;
		}
	}
}
