package com.hramn.algo.arrays;
/**
 * Task
 * You are given an array prices where prices[i] is the price of a given stock 
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock 
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you 
 * cannot achieve any profit, return 0.
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), 
 * profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you 
 * must buy before you sell.
 * 
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * [100, 50, 200, 5, 5000, 500, 1000]
 * 
 * Constraints:
 * 1 <= prices.length <= 10**5
 * 0 <= prices[i] <= 10**4
 */
public class BestTimeToBuyAndSellStock {

	public static void main (String[] args) {
		BestTimeToBuyAndSellStock cl = new BestTimeToBuyAndSellStock();
		Solution_20250220 s = cl.new Solution_20250220();
		int[] arr = {3, 5, 10, 1, 9 ,2};
		System.out.println (s.profit(arr));
	}

// 3 5 10 1 9 2 
// - 2 7  0 6 0
// - - 5  0 4 0
// - - -  0 0 0
// - - -  - 8 1
// - - -  - - 0

	class Solution_20250220 {
		public int profit (int[] arr) {
			if (arr == null || arr.length < 2) return 0;
			
			int r = arr.length - 1;
			int maxPrice = arr[r];
			int maxProfit = 0;

			while (r > 0) {
				if (arr[r-1] > maxPrice) {
					maxPrice = arr[r-1];
				} else if (maxProfit < maxPrice - arr[r-1]) {
					maxProfit = maxPrice - arr[r-1];
				}
				r--;
			}
			return maxProfit;
		}
	}

	class Solution {
	    public int maxProfit(int[] prices) {
	        int l = 0, current_max = 0, total_max = 0;
	        for (int i = 0; i < prices.length; i++) {
	        	if (prices[i] < prices[l]) {
	        		if (current_max > total_max) {
	        			total_max = current_max;
	        		}
	        		l = i;
	        	} else {
	        		int difference = prices[i] - prices[l];
	        		if (difference > current_max) {
	        			current_max = difference;
		        	}
	        	}
	        }
	        if (current_max > total_max) {
    			total_max = current_max;
    		}
	        return total_max;
	    }
	}
	
	class Solution_best_runtime {
	    public int maxProfit(int[] prices) {
	        int buy = prices[0], max = 0;
	        for (int i = 1; i < prices.length; i++) {
	        	if (prices[i] < buy) {
	        		buy = prices[i];
	        	} else {
	        		int difference = prices[i] - buy;
	        		if (difference > max) {
	        			max = difference;
		        	}
	        	}
	        }
	        return max;
	    }
	}
	
	class Solution_best_memory {
	    public int maxProfit(int[] prices) {
	    	if (prices.length == 1)
	            return 0;
	    	
	    	int output = 0, lowestPrice = prices[0];

	        for (int i = 1; i < prices.length; i++) {
	            lowestPrice = prices[i] < lowestPrice ? prices[i] : lowestPrice;
	            output = (prices[i] - lowestPrice) > output ? (prices[i] - lowestPrice) : output;
	        }
	        
	        System.gc();
	        return output;
	    }
	}
	
}
