package com.hramn.algo.binary_search;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 * 
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has 
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she 
 * chooses some pile of bananas and eats k bananas from that pile. If the pile 
 * has less than k bananas, she eats all of them instead and will not eat any 
 * more bananas during this hour.
 * 
 * Koko likes to eat slowly but still wants to finish eating all the bananas 
 * before the guards return.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h 
 * hours.
 * 
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * 
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * 
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * 
 * Constraints:
 * 1 <= piles.length <= 10**4
 * piles.length <= h <= 10**9
 * 1 <= piles[i] <= 10**9
 */
public class KokoEatingBananas {

	public static void main(String[] args) {
		int[] piles = {30,11,23,4,20};
		int h = 6;
		Solution solution = new Solution();
		int result = solution.minEatingSpeed(piles, h);
		System.out.println(result);
		assert result == 23;
	}
	
	static class Solution {
	    public int minEatingSpeed(int[] piles, int h) {
	        if (piles.length == h) {
		        Arrays.sort(piles);
		        return piles[piles.length - 1];
	        }
	        int l = 0;
	        int r = 1000000000;
		    while (r - l > 1) {
			    int mid = l + (r - l) / 2;
			    if (canEatAll(piles, h, mid)) {
				    r = mid;
	            } else {
		            l = mid;
	             }
	        }
		    return r;
	    }

	    private boolean canEatAll(int[] piles, int h, int k) {
		    int res = 0;
	        for (int bananas : piles) {
		        res += bananas / k;
		        if (bananas % k != 0) {
	    		    res++;
	            }
	            if (res > h) {
		            return false;
	            }
	        }
	        return res <= h;
	    }
	}
}
