package com.hramn.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Task
 * Given a string s, find the first non-repeating character in it and return 
 * its index. If it does not exist, return -1.
 * 
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * 
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * 
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * 
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */

public class FirstUniqueCharacterInString {
	public static void main(String[] args) {

	}
	
	static class Solution_my {
		public int firstUniqChar(String s) {
			char[] arr = s.toCharArray();
			Set<Character> notSingle = new HashSet<>();
			for (int i = 0; i < arr.length; i++) {
				boolean isSingle = true;
				if (!notSingle.contains(arr[i])) {
					for (int j = i+1; j < arr.length; j++) {
						if(arr[i] == arr[j]) {
							isSingle = false;
							notSingle.add(arr[i]);
							break;
						}
					}
					if (isSingle) {
						return i;
					}
				}
			}
			return -1;
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
