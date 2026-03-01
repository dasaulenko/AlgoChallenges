package com.hramn.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
Given a string array words, return an array of all characters that show up in 
all strings within the words (including duplicates). You may return the answer 
in any order.

Example 1:
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 
Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
*/

public class FindCommonCharacters {
	public static void main(String[] args) {
//		String[] words = {"bella","label","roller"};
		String[] words = {"cool","lock","cook"};
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.commonChars(words)));
	}
	
	static class Solution {
		public char[] commonChars(String[] words) {
			Map<Character, Integer> resultMap = new HashMap<>();
			int count = 0; 
			for (int i = 0; i < words.length; i++) {
				Map<Character, Integer> current = new HashMap<>();
				for (int j = 0; j < words[i].length(); j++) {
					char c = words[i].charAt(j);
					if (i == 0) {
						resultMap.put(c, resultMap.getOrDefault(c, 0) + 1);
						count++;
					} else {
						if (resultMap.get(c) != null) {
							current.put(c, current.getOrDefault(c, 0) + 1);
						}
					}
				}
				if (i != 0) {
					for (Character c : resultMap.keySet()) {
						Integer cur = current.get(c);
						Integer res = resultMap.get(c);
						if (cur == null) {
							count -= res;
							resultMap.put(c, 0);
						} else if (cur != null && cur < resultMap.get(c)) {
							count -= res-cur;
							resultMap.put(c, cur);
						}
						if (count == 0) return new char[0];
					}
				}
			}
			char[] result = new char[count];
			int index = 0;
			for (Character c : resultMap.keySet()) {
				for (int i = 0; i < resultMap.get(c); i++) {
					result[index] = c;
					index++;
				}
			}
			return result;
		}
	}
	
//	static class Solution_my {
//		public List<String> commonChars(String[] words) {
//			if (words == null || words.length == 0) {
//				return new ArrayList<>();
//			}
//			char[] result = words[0].toCharArray();
//			Arrays.sort(result);
//			for (int i = 1; i < words.length; i++) {
//				char[] tmp = words[i].toCharArray();
//				Arrays.sort(tmp);
//				int resIndex = 0;
//				int tmpIndex = 0;
//				while (resIndex < result.length || tmpIndex < tmp.length) {
//					if (result[resIndex] == tmp[tmpIndex]) {
//						resIndex++;
//						tmpIndex++;
//					} else if (result[resIndex] < tmp[tmpIndex]) {
//						removeElementFromArray(result, resIndex);
//					} else {
//						tmpIndex++;
//					}
//				}
//			}
//	    }
//		private static void removeElementFromArray(char[] arr, int index) {
//
//			
//		}
//	}
	
//	class Solution {
//	    public int firstUniqChar(String s) {
//	        int[] freq = new int[26];
//	        char[] chars = s.toCharArray();
//	        for(char c:chars){
//	            freq[c-'a']++;
//	        }
//
//	        for(int i=0;i<chars.length;i++){
//	            if(freq[chars[i]-'a']==1){
//	                return i;
//	            }
//	        }
//	        return -1;
//	        
//	    }
//	}
}
