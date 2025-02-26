package com.hramn.algo.numbers;
/**
 * Task
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * 
 * Example 1
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Example 2
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
 * Constraints:
 * -2**31 <= x <= 2**31 - 1
 * 
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

	public static void main (String[] args) {
		PalindromeNumber palindromeNumber = new PalindromeNumber();
		Solution_20250220 s = palindromeNumber.new Solution_20250220();
		System.out.println (s.palindrome(123450));
	}

	class Solution_20250220 {
		public boolean palindrome (int x) {
			if (x < 0) return false;
			if (x < 10) return true;
			if (x % 10 == 0) return false;

			int p = 0;

			while (p < x) {
				p = (p * 10) + (x % 10);
				x = x / 10;
			}

			if (p == x) return true;
			if (p - (x * 10) < 10) return true;
			return false;
		}
	}

	class Solution {
	    public boolean isPalindrome(int x) {
	        char[] arr = ("" + x).toCharArray();
	        int l = 0;
	        int r = arr.length-1;
	        while (l < r) {
	            if (arr[l] != arr[r]) {
	                return false;
	            }
	            l++;
	            r--;
	        }
	        return true;
	    }
	}
	
	// Best runtime
	class Solution_best_runtime {
	    public boolean isPalindrome(int x) {
	        if(x<0){
	            return false;
	        }
	        int temp=x;
	        int rever=0;
	        while(temp!=0){
	           int num= temp%10;
	           rever=rever*10+num;
	           temp/=10;

	        }
	        return rever==x;
	        
	    }
	}
	
	// Best memory
	class Solution_best_memory {
	    public boolean isPalindrome(int x) {
	        int r=0,a=x;
	        if(x<0)
	        return false;
	        for(;x!=0;x/=10)
	        r=(r*10)+(x%10);
	        if(r==a)
	           return true;
	        else
	          return false;
	    }
	}
	
}
