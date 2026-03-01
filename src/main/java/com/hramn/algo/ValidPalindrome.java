package com.hramn.algo;

/**
A phrase is a palindrome if, after converting all uppercase letters into 
lowercase letters and removing all non-alphanumeric characters, it reads the 
same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 
Constraints:
1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.
 */

public class ValidPalindrome {
	public static void main(String[] args) {
		Solution_my.isPalindrome("A man, a plan, a canal: Panama");
	}
	
	static class Solution_my {
	    public static boolean isPalindrome(String s) {
				if (s == null) {
					return false;
				}
				if (s.length() == 0) {
					return true;
				}
				char[] arr = s.toCharArray();
				int l = 0;
				int r = arr.length - 1;
				while(l < r) {
					boolean f = true;
					if ((arr[l] < '0') || (arr[l] > '9' && arr[l] < 'a') || (arr[l] > 'z')) {
						l++;
						f = false;
					}
					if ((arr[r] < '0') || (arr[r] > '9' && arr[r] < 'a') || (arr[r] > 'z')) {
						r--;
						f = false;
					}
					if (f) {
						if (arr[l] != arr[r]) {
								return false;
						}
						l++;
						r--;
					}
				}
				return true;
	    }
	}
	
	class Solution {
	    public int firstUniqChar(String s) {
	        int[] freq = new int[26];
	        char[] chars = s.toCharArray();
	        for(char c:chars){
	            freq[c-'a']++;
	        }

	        for(int i=0;i<chars.length;i++){
	            if(freq[chars[i]-'a']==1){
	                return i;
	            }
	        }
	        return -1;
	        
	    }
	}
}
