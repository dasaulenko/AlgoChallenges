package com.hramn.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Task
 * Дан массив чисел. Нужно сформировать строку с интервалами значений 
 * представленных в массиве. Интервалы должны быть перечислены через запятую в 
 * порядке возрастания.
 * 
 * Example 1
 * Input: int[] {5, 3, 9, 1, 7, 2, 4, 10}
 * Output: "1-5,7,9-10"
 * 
 * Example 2
 * Input: int[] {}
 * Output: ""
 * 
 * Example 3
 * Input: int[] {4}
 * Output: "4"
 * 
 * Example 4
 * Input: int[] {5, 4}
 * Output: "4-5"
 * 
 * Example 5
 * Input: int[] {2, 11, 3}
 * Output: "2-3,11"
 */

public class FindingRangesInArray {

	public static void main(String[] args) {
		System.out.println(MySolution.ranges(new int[] {5,2,7,9,3,4,11,14,13}));
		System.out.println(MySolution.ranges(new int[0]));
		System.out.println(MySolution.ranges(new int[] {1}));
		
		System.out.println(MySolution_2.getString(Arrays.asList(5,2,7,9,3,4,11,14,13)));
		System.out.println(MySolution_2.getString(new ArrayList<>()));
		System.out.println(MySolution_2.getString(Arrays.asList(1)));
		
		System.out.println(MySolution_3.getString(new int[] {5,2,7,9,3,4,11,14,13}));
		System.out.println(MySolution_3.getString(new int[0]));
		System.out.println(MySolution_3.getString(new int[] {1}));
	}
	
	// Решение 1. 03.2024 (time O(n log(n)), memory O(n))
	static class MySolution {
		static String ranges(int[] arr) {
			if (arr.length == 0) {
				return "";
			}
			if (arr.length == 1) {
				return "" + arr[0];
			}
			StringBuilder res = new StringBuilder();
			Arrays.sort(arr);
			int l = 0, r = 1;
			while(r < arr.length) {
				if (arr[l] + (r-l) != arr[r]) {
					addRange(res, arr[l], arr[r-1]);
					l = r;
				}
				r++;
			}
			addRange(res, arr[l], arr[r-1]);
			return res.toString();
		}
		
		static void addRange(StringBuilder sb, int b, int e) {
			if (!sb.isEmpty()) {
				sb.append(",");
			}
			if (b == e) {
				sb.append(b);
			} else {
				sb.append(b).append("-").append(e);
			}
		}
	}
	
	// Решение 2
	static class MySolution_2 {
		static String getString(List<Integer> list) {
			if (list == null) return null;
			if (list.isEmpty()) return "";
			if (list.size() == 1) return list.get(0).toString();
			Collections.sort(list);
			Integer start = list.get(0);
			Integer end = list.get(0);
			String result = "";
			for (int i=1; i<list.size(); i++) {
				if (list.get(i) == end + 1) {
					end++;
				} else {
					result = result + getStrInterval(start, end) + ",";
					start = list.get(i);
					end = list.get(i);
				}
			}
			result = result + getStrInterval(start, end);
			return result;
		}
	
		static String getStrInterval(Integer start, Integer end) {
			if (start == null || end == null) return "";
			if (start.intValue() == end.intValue()) return start.toString();
			return start.toString() + "-" + end.toString();
		}
	}
	
	// Решение 3
	static class MySolution_3 {
		static String getString(int[] arr) {
			if (arr.length == 0) return "";
			Arrays.sort(arr);
			if (arr.length == 1) return "" + arr[0];
			String result = "";
			int l = 0, m = 0, r = 1;
			while (r < arr.length) {
				if (arr[m]+1 == arr[r]) {
					m = r;
					r++;
				} else {
					if (l == m) {
						result = result + arr[l] + ",";
					} else {
						result = result + arr[l] + "-" + arr[m] + ",";
					}
					l = r++;
					m = l;
				}
			}
			if (l == m) {
				result = result + arr[l];
			} else {
				result = result + arr[l] + "-" + arr[m];
			}
			return result;
		}
	}

}
