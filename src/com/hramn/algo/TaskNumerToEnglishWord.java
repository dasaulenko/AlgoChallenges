package com.hramn.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskNumerToEnglishWord {

	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.numberToWords(111));
		System.out.println(solution.numberToWords(2123456789));
	}
	
	static class Solution {
		private Map<Integer, String> digits = new HashMap<Integer, String>() {
			private static final long serialVersionUID = 1L;
		{
			put(1, "One");
			put(2, "Two");
			put(3, "Three");
			put(4, "Four");
			put(5, "Five");
			put(6, "Six");
			put(7, "Seven");
			put(8, "Eight");
			put(9, "Nine");
		}};
	
		private Map<Integer, String> teens = new HashMap<Integer, String>() {
			private static final long serialVersionUID = 1L;
		{
			put(10, "Ten");
			put(11, "Eleven");
			put(12, "Twelve");
			put(13, "Thirteen");
			put(14, "Fourteen");
			put(15, "Fifteen");
			put(16, "Sixteen");
			put(17, "Seventeen");
			put(18, "Eighteen");
			put(19, "Nineteen");
		}};
	
		private Map<Integer, String> tens = new HashMap<Integer, String>() {
			private static final long serialVersionUID = 1L;
		{
			put(2, "Twenty");
			put(3, "Thirty");
			put(4, "Fourty");
			put(5, "Fifty");
			put(6, "Sixty");
			put(7, "Seventy");
			put(8, "Eighty");
			put(9, "Ninety");
		}};
	
		private Map<Integer, String> classes = new HashMap<Integer, String>() {
			private static final long serialVersionUID = 1L;
		{
			put(2, "Hundred");
			put(3, "Thousand");
			put(6, "Million");
			put(9, "Billion");
		}};
	
		public String numberToWords(int num) {
			List<String> strList = new ArrayList<>();
			if (num < 0) {
				throw new IllegalArgumentException(String.valueOf(num));
			}
			if (num == 0) {
				return "Zerro";
			}
			int digitPlaces = 0;
			int d = 0;
			int sum = 0;
			while(num != sum) {
				digitPlaces++;
				d = num % (int)Math.pow(10, digitPlaces) / (int)Math.pow(10, digitPlaces - 1);				
				if (digitPlaces%3 == 1) {	
					int dNext = num % (int)Math.pow(10, digitPlaces+1) / (int)Math.pow(10, digitPlaces);
					if (d != 0 && dNext != 1) {
						strList.add(this.digits.get(d));
					}
				}  else if (digitPlaces%3 == 2) {
					if (d == 1) {
						int dPrev = num % (int)Math.pow(10, digitPlaces-1) / (int)Math.pow(10, digitPlaces - 2);	
						strList.add(this.teens.get(d*10 + dPrev));
					} else if (d > 1) {
						strList.add(this.tens.get(d));
					}
				} else {
					if (d != 0) {
						strList.add(classes.get(2));
						strList.add(this.digits.get(d));
					}
					if (num % (int)Math.pow(10, digitPlaces+3) - num % (int)Math.pow(10, digitPlaces) != 0) {
						strList.add(classes.get(digitPlaces));
					}
				}
				sum += d*Math.pow(10, digitPlaces-1);
			}
			Collections.reverse(strList);
			return String.join(" ", strList);
		}
	}
}
