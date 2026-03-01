package com.hramn.algo.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Task
 * A sentence is a string of single-space separated words where each word 
 * consists only of lowercase letters.
 * 
 * A word is uncommon if it appears exactly once in one of the sentences, and 
 * does not appear in the other sentence.
 * 
 * Given two sentences s1 and s2, return a list of all the uncommon words. You 
 * may return the answer in any order.
 * 
 * Example 1:
 * Input: s1 = "this apple is sweet", s2 = "this apple is sour"
 * Output: ["sweet","sour"]
 * Explanation:
 * The word "sweet" appears only in s1, while the word "sour" appears only in s2.
 * 
 * Example 2:
 * Input: s1 = "apple apple", s2 = "banana"
 * Output: ["banana"]
 * 
 * Constraints:
 * 1 <= s1.length, s2.length <= 200
 * s1 and s2 consist of lowercase English letters and spaces.
 * s1 and s2 do not have leading or trailing spaces.
 * All the words in s1 and s2 are separated by a single space.
 */
public class UncommonWordsFromTwoSentences {
	
	public static void main(String[] args) {
		String s1 = "apple apple";
		String s2 = "banana";
//		String s1 = "this apple is sweet";
//		String s2 = "this apple is sour";
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.uncommonFromSentences(s1, s2)));
	}
	
	// BEST RUNTIME !!!
	// CREASY SOLUTION... We should just count the quantity of each word in 
	// both of sentences and return words with count = 1 (see Solution2 sclass)
	static class Solution {
	    public String[] uncommonFromSentences(String s1, String s2) {
	        String[] s1Words = s1.split(" ");
	        Arrays.sort(s1Words);
	        String[] s2Words = s2.split(" ");
	        Arrays.sort(s2Words);
	        String word = null;
	        boolean acc = false;
	        int s1Index = 0, s2Index = 0;
	        List<String> result = new ArrayList<>();
	        while (s1Index < s1Words.length || s2Index < s2Words.length) {
	        	if (s1Index < s1Words.length && s1Words[s1Index].equals(word)) {
	        		acc = false;
	        		s1Index++;
	        		continue;
	        	}
	        	if (s2Index < s2Words.length && s2Words[s2Index].equals(word)) {
	        		acc = false;
	        		s2Index++;
	        		continue;
	        	}
	        	if (word != null && acc) {
	        		result.add(word);
	        	}
	        	if (s1Index == s1Words.length) {
	        		word = s2Words[s2Index];
	        		acc = true;
	        		s2Index++;
	        	} else if (s2Index == s2Words.length) {
	        		word = s1Words[s1Index];
	        		acc = true;
	        		s1Index++;
	        	} else {
		        	int compare = s1Words[s1Index].compareTo(s2Words[s2Index]);
		        	if (compare == 0) {
		        		word = s1Words[s1Index];
		        		acc = false;
		        		s1Index++;
		        		s2Index++;
		        	} else if (compare > 0) {
		        		word = s2Words[s2Index];
		        		acc = true;
		        		s2Index++;
		        	} else {
		        		word = s1Words[s1Index];
		        		acc = true;
		        		s1Index++;
		        	}
	        	}
	        }
	        if (acc) {
	        	result.add(word);
	        }
	        return result.toArray(new String[result.size()]);
	    }
	}
	
	static class Solution2 {
	    public String[] uncommonFromSentences(String s1, String s2) {
	    	String[] s1Words = s1.split(" ");
	    	String[] s2Words = s2.split(" ");
	    	Map<String, Integer> map = new HashMap<>();
	    	Set<String> result = new HashSet<>();
	    	for (String word : s1Words) {
	    		map.put(word, map.getOrDefault(word, 0) + 1);
	    	}
	    	for (String word : s2Words) {
	    		map.put(word, map.getOrDefault(word, 0) + 1);
	    	}
	    	for (String word : map.keySet()) {
	    		if (map.get(word) == 1) {
	    			result.add(word);
	    		}
	    	}
	    	return result.toArray(new String[result.size()]);
	    }
	}
	
	class Solution_best_runtime {
	    public String[] uncommonFromSentences(String s1, String s2) {
	        List<String> output = new ArrayList<>(); 
	        HashMap<String, Integer> map = new HashMap<>();
	        String s1Str[] = s1.split(" ");
	        // for(int i = 0; i < s1.length(); ++i) {
	        //         map.put(s1Str[i], map.getOrDefault(s1Str[i], 0 ) + 1);
	        // }
	        for(String word: s1Str) {
	            map.put(word, map.getOrDefault(word, 0) + 1);
	        }
	        String s2Str[] = s2.split(" ");
	         // Count occurrences of words from the second sentence
	        for (String word : s2Str) {
	            map.put(word, map.getOrDefault(word, 0) + 1);
	        }

	        // Add words that appear only once to the output list
	        for (String word : map.keySet()) {
	            if (map.get(word) == 1) {
	                output.add(word);
	            }
	        }

	        // covert list to a string array
	        return output.toArray(new String[0]);
	        //     for(int i = 0; i < s2.length(); ++i) {
	        //         if(map.containsKey(s2Str[i]) && map.get(s2Str[i]) == 1) {
	        //             output.add(s2Str[i]);
	        //         }
	        //     }
	        //     String[] stringArr = output.toArray(new String[0]);
	        //     return stringArr;
	        // }
	    }
	}
	
	class Solution_best_memory {
	    public String[] uncommonFromSentences(String s1, String s2) {
	                String arr1[] = s1.split(" ");
	        String arr2[] = s2.split(" ");
	        int n1 = arr1.length;
	        int n2 = arr2.length;

	        HashMap<String,Integer> hp1 = new HashMap<>();
	        HashMap<String,Integer> hp2 = new HashMap<>();

	        for(int i=0; i<n1; i++){
	            hp1.put(arr1[i],hp1.getOrDefault(arr1[i],0)+1);
	        }

	        for(int i=0; i<n2; i++){
	            hp2.put(arr2[i],hp2.getOrDefault(arr2[i],0)+1);
	        }

	        HashSet<String> hp = new HashSet<>();
	        for(var a : hp1.keySet()){
	            if(hp1.get(a)==1){
	                if(!hp2.containsKey(a)) hp.add(a);
	            }
	        }

	        for(var a : hp2.keySet()){
	            if(hp2.get(a)==1){
	                if(!hp1.containsKey(a)) hp.add(a);
	            }
	        }

	        String ans[] = new String[hp.size()];
	        int idx = 0;
	        for(var a : hp) ans[idx++] = a;
	        return ans;
	    }
	}
}
