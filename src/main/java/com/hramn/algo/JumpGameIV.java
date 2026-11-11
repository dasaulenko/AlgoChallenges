package com.hramn.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 1345. Jump Game IV
 * 
 * <p>Given an array of integers arr, you are initially positioned at the first 
 * index of the array.
 * 
 * <p>In one step you can jump from index i to index:
 * <ul>
 * <li>i + 1 where: i + 1 < arr.length.</li>
 * <li>i - 1 where: i - 1 >= 0.</li>
 * <li>j where: arr[i] == arr[j] and i != j.</li>
 * </ul>
 * 
 * <p>Return the minimum number of steps to reach the last index of the array.
 * 
 * <p>Notice that you can not jump outside of the array at any time.
 * 
 * <p>Example 1:
 * <pre>
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that 
 * index 9 is the last index of the array.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You do not need to jump.
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last 
 * index of the array.
 * </pre>
 * 
 * <p>Constraints:
 * <pre>
 * 1 <= arr.length <= 5 * 10⁴
 * -10⁸ <= arr[i] <= 10⁸
 * </pre>
 * 
 * @see <a href="https://leetcode.com/problems/jump-game-iv">
 * 		Link to source
 * </a>
 */
// 1 > 2 <> 3
//     >    <
//     5 >  6 < 4 < 7 < 8 // answer = 7
// 1: 0
// 2: 1
// 3: 2
// 5: 2
// 6: 3

public class JumpGameIV {

	class Solution {

		public int minJumps(int[] arr) {
			int n = arr.length;
			if (n == 1) return 0;

			Map<Integer, List<Integer>> transitions = new HashMap<>();

			for (int i = 0; i < n; i++) {
				transitions.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
			}

			boolean[] visited = new boolean[n];

			Queue<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[]{0,0});

			while(!queue.isEmpty()) {
				int[] s = queue.poll();
				int i = s[0];
				int steps = s[1];

				if (i == n-1) return steps;

				if (i > 0 && !visited[i-1]) {
					queue.offer(new int[]{i-1,steps+1});
					visited[i-1] = true;
				}

				if (!visited[i+1]) {
					queue.offer(new int[]{i+1,steps+1});
					visited[i+1] = true;
				}
				for (int j : transitions.get(arr[i])) {
					if (!visited[j]) {
						queue.offer(new int[] {j, steps+1});
						visited[j] = true;
					}
				}
				transitions.get(arr[i]).clear();
			}
			return n-1;
		}
	}
}
