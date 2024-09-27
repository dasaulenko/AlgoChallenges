package com.hramn.algo.daily;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Task
 * Given two integers n and k, return the kth lexicographically smallest 
 * integer in the range [1, n].
 * 
 * Example 1:
 * Input: n = 13, k = 2
 * Output: 10
 * Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 
 * 7, 8, 9], so the second smallest number is 10.
 * 
 * Example 2:
 * Input: n = 1, k = 1
 * Output: 1
 * 
 * Constraints:
 * 
 * 1 <= k <= n <= 10**9
 */
public class KthSmallestInLexicographicalOrder {
	
	public static void main (String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.findKthNumber(13, 2));
//		System.out.println(solution.findKthNumber(1, 1));
		System.out.println(solution.findKthNumber(4289384, 1922239));
		
		Set<String> set = new TreeSet<>();
		for (int i = 1; i < 10000; i++) {
			set.add(i + "");
		}
		System.out.println(Arrays.toString(set.toArray()));
	}
	
	static class Solution {
	    public int findKthNumber(int n, int k) {
	    	Set<String> set = new TreeSet<>();
	    	for (int i = 1; i < n+1; i++) {
				set.add(i + "");
			}
	    	Iterator<String> iterator = set.iterator();
	    	int i = 1;
	    	while(iterator.hasNext()) {
	    		if (i == k) {
	    			return Integer.valueOf(iterator.next());
	    		}
	    		iterator.next();
	    		i++;
	    	}
	    	return -1;
	    }
	}
	
	static class Solution_ologn_runtime_o1_memory {
	    public int findKthNumber(int n, int k) {
	        int currentPrefix = 1;
	        k--;  // Decrement k to handle zero-based indexing
	        
	        while (k > 0) {
	            int count = countNumbersWithPrefix(currentPrefix, n);
	            if (k >= count) {
	                currentPrefix++;  // Move to the next prefix
	                k -= count;
	            } else {
	                currentPrefix *= 10;  // Go deeper in the current prefix
	                k--;
	            }
	        }
	        
	        return currentPrefix;
	    }

	    private int countNumbersWithPrefix(int prefix, int n) {
	        long firstNumber = prefix, nextNumber = prefix + 1;
	        int totalCount = 0;

	        while (firstNumber <= n) {
	            totalCount += Math.min(n + 1, nextNumber) - firstNumber;
	            firstNumber *= 10;
	            nextNumber *= 10;
	        }

	        return totalCount;
	    }
	}
}
