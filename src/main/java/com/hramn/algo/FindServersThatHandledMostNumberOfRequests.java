package com.hramn.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 1606. Find Servers That Handled Most Number of Requests
 * 
 * <p>You have k servers numbered from 0 to k-1 that are being used to handle 
 * multiple requests simultaneously. Each server has infinite computational 
 * capacity but cannot handle more than one request at a time. The requests are 
 * assigned to servers according to a specific algorithm:
 * 
 * <ul>
 * <li>The ith (0-indexed) request arrives.</li>
 * <li>If all servers are busy, the request is dropped (not handled at all).</li>
 * <li>If the (i % k)th server is available, assign the request to that server.</li>
 * <li>Otherwise, assign the request to the next available server (wrapping 
 * around the list of servers and starting from 0 if necessary). For example, 
 * if the ith server is busy, try to assign the request to the (i+1)th server, 
 * then the (i+2)th server, and so on.</li>
 * </ul>
 * 
 * <p>You are given a strictly increasing array arrival of positive integers, 
 * where arrival[i] represents the arrival time of the ith request, and another 
 * array load, where load[i] represents the load of the ith request (the time 
 * it takes to complete). Your goal is to find the busiest server(s). 
 * A server is considered busiest if it handled the most number of requests 
 * successfully among all the servers.
 * 
 * <p>Return a list containing the IDs (0-indexed) of the busiest server(s). 
 * You may return the IDs in any order.
 * 
 * <p>Example 1:
 * <pre>
 * Input: k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3] 
 * Output: [1] 
 * Explanation: 
 * All of the servers start out available.
 * The first 3 requests are handled by the first 3 servers in order.
 * Request 3 comes in. Server 0 is busy, so it's assigned to the next available server, which is 1.
 * Request 4 comes in. It cannot be handled since all servers are busy, so it is dropped.
 * Servers 0 and 2 handled one request each, while server 1 handled two requests. Hence server 1 is the busiest server.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: k = 3, arrival = [1,2,3,4], load = [1,2,1,2]
 * Output: [0]
 * Explanation: 
 * The first 3 requests are handled by first 3 servers.
 * Request 3 comes in. It is handled by server 0 since the server is available.
 * Server 0 handled two requests, while servers 1 and 2 handled one request each. Hence server 0 is the busiest server.
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: k = 3, arrival = [1,2,3], load = [10,12,11]
 * Output: [0,1,2]
 * Explanation: Each server handles a single request, so they are all considered the busiest.
 * </pre>
 * 
 * <p>Constraints:
 * <pre>
 * 1 <= k <= 10⁵
 * 1 <= arrival.length, load.length <= 10⁵
 * arrival.length == load.length
 * 1 <= arrival[i], load[i] <= 10⁹
 * arrival is strictly increasing.
 * </pre>
 * 
 * @see <a href="https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests">
 * 		Link to source
 * </a>
 * 
 */
public class FindServersThatHandledMostNumberOfRequests {
	class Solution {
		public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
			return solution1(k, arrival, load);
		}

		private List<Integer> solution1(int k, int[] arrival, int[] load) {
			int[] totalLoad = new int[k];
			TreeSet<Integer> freeServers = new TreeSet<>();
			for (int i = 0; i < k; i++) freeServers.add(i);
			PriorityQueue<int[]> buisyServers = new PriorityQueue<>((a,b) -> a[1] - b[1]);
			int max = 0;

			for (int i = 0; i < arrival.length; i++) {
				int startTime = arrival[i];
				while(!buisyServers.isEmpty() && buisyServers.peek()[1] <= startTime) {
					int[] s = buisyServers.poll();
					freeServers.add(s[0]);
				}
				if (freeServers.size() == 0) continue;
				Integer srv = i % k;
				if (!freeServers.contains(srv)) {
					srv = freeServers.higher(srv);
					if (srv == null) srv = freeServers.first();
				}
				totalLoad[srv]++;
				max = Math.max(max, totalLoad[srv]);
				freeServers.remove(srv);
				buisyServers.add(new int[] {srv, startTime + load[i]});
			}
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				if (totalLoad[i] == max) result.add(i);
			}
			return result;
		}
	}
}
