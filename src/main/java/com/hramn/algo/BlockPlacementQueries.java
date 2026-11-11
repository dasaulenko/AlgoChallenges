package com.hramn.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 3161. Block Placement Queries
 * 
 * @see <a href="https://leetcode.com/problems/block-placement-queries">
 * 		Link to source
 * </a>
 */
public class BlockPlacementQueries {

	class Solution {

		private static class Node {
			// Node prev;
			Node next;
			int value;
			int max = -1;

			public Node (int value) {
				this.value = value;
			}
		}

		public List<Boolean> getResults(int[][] queries) {
			List<Boolean> result = new ArrayList<>();
			TreeMap<Integer, Node> obstacles = new TreeMap<>();

			for (int[] query : queries) {
				int x = query[1];
				if (query[0] == 1) {
					Integer prevKey = obstacles.floorKey(x);
					Integer nextKey = obstacles.ceilingKey(x);
					Node node = new Node(x);
					node.max = x;
					obstacles.put(x, node);
					if (prevKey != null) {
						Node prevNode = obstacles.get(prevKey);
						prevNode.next = node;
						// node.prev = prevNode;
						node.max = Math.max (prevNode.max, x - prevKey);
					}
					if (nextKey != null) {
						Node nextNode = obstacles.get(nextKey);
						// nextNode.prev = node;
						node.next = nextNode;

						int prevMax = Math.max (node.max, nextKey - x);
						while (nextNode != null && nextNode.max > prevMax) {
							nextNode.max = prevMax;
							int prevValue = nextNode.value;
							nextNode = nextNode.next;
							prevMax = Math.max (prevMax, nextNode.value - prevValue);
						}
					}
				} else {
					int sz = query[2];
					Integer key = obstacles.floorKey(x);
					int max = x;
					if (key != null) {
						Node node = obstacles.get(key);
						max = Math.max (node.max, x - key);
					}
					if (max >= sz) result.add(true);
					else result.add(false);
				}
			}
			return result;
		}
	}

}
