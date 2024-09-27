package com.hramn.algo;

import java.util.Arrays;

/**
 * Task
 * You are given a large integer represented as an integer array digits, where 
 * each digits[i] is the ith digit of the integer. The digits are ordered from 
 * most significant to least significant in left-to-right order. The large 
 * integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * 
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * 
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * 
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */

public class PlusOne {
	
	public static void main(String[] args) {
		
	}
	
	static class Solution_my {
		// 1. Цикл по элементам массива с конца.
		// 2. Если элемент не 9, то увелич на 1.
		// 3. Если элемент 9, то:
		//    - заменить на 0
		//    - перейти к следующему элементу и повторить с п. 2
		// 4. Если п. 3 исполнялся хоть раз, то увеличить размер массива на 1 и 
		// добавить 0.
	    public int[] plusOne(int[] digits) {
	    	int[] result = new int[digits.length + 1];
	    	boolean f = false;
	        for (int i = digits.length - 1; i >= 0; i--) {
	        	if (f) {
	        		result[i+1] = digits[i];
	        	} else {
	        		if (digits[i] != 9) {
	        			result[i+1] = digits[i] + 1;
	        			f = true;
	        		} else {
	        			result[i+1] = 0;
	        		}
	        	}
	        }
	        if (result[1] == 0) {
	        	result[0] = 1;
	        } else {
	        	result = Arrays.copyOfRange(result, 1, result.length);
	        }
	        return result;
	    }
	}

}
