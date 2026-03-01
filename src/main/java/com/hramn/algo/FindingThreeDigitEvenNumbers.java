package com.hramn.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2094. Finding 3-Digit Even Numbers
 * https://leetcode.com/problems/finding-3-digit-even-numbers/description
 * 
 * You are given an integer array digits, where each element is a digit. The 
 * array may contain duplicates.
 * 
 * You need to find all the unique integers that follow the given requirements:
 * - The integer consists of the concatenation of three elements from digits in 
 *   any arbitrary order.
 * - The integer does not have leading zeros.
 * - The integer is even.
 * 
 * For example, if the given digits were [1, 2, 3], integers 132 and 312 follow 
 * the requirements.
 * 
 * Return a sorted array of the unique integers.
 * 
 * Example 1:
 * Input: digits = [2,1,3,0]
 * Output: [102,120,130,132,210,230,302,310,312,320]
 * Explanation: All the possible integers that follow the requirements are in 
 * the output array. 
 * Notice that there are no odd integers or integers with leading zeros.
 * 
 * Example 2:
 * Input: digits = [2,2,8,8,2]
 * Output: [222,228,282,288,822,828,882]
 * Explanation: The same digit can be used as many times as it appears in 
 * digits. 
 * In this example, the digit 8 is used twice each time in 288, 828, and 882.
 * 
 * Example 3:
 * Input: digits = [3,7,5]
 * Output: []
 * Explanation: No even integers can be formed using the given digits.
 * 
 * Constraints:
 * 3 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * 
 * TAG: 20250512
 * TAG: easy
 * TAG: array
 */
public class FindingThreeDigitEvenNumbers {
// 1. Максимальный размер итогового массива предсказуем. Нас интересуют
//    только трёхзначные четные числа - их всего 450
// 2. Важно обратить внимание, что каждый элемент исходного массива - это
//    цифра от 0 до 9. Вместо сортировки исходного массива и трёхуровнего
//    цикла по всем элементам исходного массива, нужно посчитать количество
//    каждой цифры в исходном массиве и сделать трёхуровневый цикл по каждой
//    цифре.
// 3. В конце можно образать массив операцией Arrays.copyOf(arr, size);
	class Solution { // O(N^3), O(1), N - digits.length
		public int[] findEvenNumbers(int[] digits) {
			int n = digits.length;
			Arrays.sort(digits);
			List<Integer> result = new ArrayList<>();
			// d1 - any extends 0
			// d2 - any extends d1
			// d3 - 0, even but extends d1, d2
			int n1 = 0;
			for (int d1 = 0; d1 < n; d1++) {
				if (digits[d1] != n1) {
					n1 = digits[d1];
					int n2 = -1;
					for (int d2 = 0; d2 < n; d2++) {
						if (d2 != d1 && digits[d2] != n2) {
							n2 = digits[d2];
							int n3 = -1;
							for (int d3 = 0; d3 < n; d3++) {
								if (d3 != d1 && d3 != d2 && digits[d3] != n3 && digits[d3] % 2 == 0) {
									n3 = digits[d3];
									result.add(digits[d1]*100 + digits[d2]*10 + digits[d3]);
								}
							}
						}
					}
				}
			}
			return result.stream().mapToInt(i->i).toArray();
		}
	}
}
