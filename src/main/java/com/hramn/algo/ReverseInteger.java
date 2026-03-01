package com.hramn.algo;

/**
 * Task
 * Given a signed 32-bit integer x, return x with its digits reversed. If 
 * reversing x causes the value to go outside the signed 32-bit integer range 
 * [-2**31, 2**31 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed 
 * or unsigned).
 * 
 * Example 1:
 * Input: x = 123
 * Output: 321
 * 
 * Example 2:
 * Input: x = -123
 * Output: -321
 * 
 * Example 3:
 * Input: x = 120
 * Output: 21
 * 
 * Constraints:
 * -231 <= x <= 231 - 1
 */

public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(Solution_my.reverse(-90));
		System.out.println(Solution_my.reverse(1534236469));
	}
	
	static class Solution_my {
	    static int reverse(int x) {
	    	// trivial cases
	    	if (x > -10 && x < 10) return x;
	    	// preparation
	        char[] arr = String.valueOf(x).toCharArray();
	        int l = 0;
	        if (arr[0] == '-') {
	        	l = 1;
	        }
	        int r = arr.length - 1;
	        // main action
	        while (l < r) {
	        	char temp = arr[l];
	        	arr[l] = arr[r];
	        	arr[r] = temp;
	        	l++; r--;
	        }
	        try {
	        	return Integer.parseInt(String.valueOf(arr));
	        } catch (NumberFormatException e) {
	        	return 0;
	        }
	    }
	}
	
	static class Solution {
	    public int reverse(int x) {
	        int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            x /= 10;
	            // this is just for overflow
	            if (
	                rev > Integer.MAX_VALUE / 10
	            ) return 0;
	            if (
	                rev < Integer.MIN_VALUE / 10 
	            ) return 0;
	            rev = rev * 10 + pop;
	        }
	        return rev;
	    }
	}
}
