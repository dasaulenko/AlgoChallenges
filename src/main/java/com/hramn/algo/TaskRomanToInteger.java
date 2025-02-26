package com.hramn.algo;

public class TaskRomanToInteger {

	// Конвертировать римское число в int.
	
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));

	}
	
	private static int getNumber(char c) {
		if (c == 'I') {
			return 1;
		} else if (c == 'V') {
			return 5;
		} else if (c == 'X') {
			return 10;
		} else if (c == 'L') {
			return 50;
		} else if (c == 'C') {
			return 100;
		} else if (c == 'D') {
			return 500;
		} else if (c == 'M') {
			return 1000;
		}
		return 0;
	}
	
	private static int romanToInt(String str) {
		char[] arr = str.toCharArray();
		int r = arr.length - 1;
		int prev = 0;
		int result = 0;
		while(r >= 0) {
			int num = getNumber(arr[r]);
			if (prev == 0) {
				result += num;
			} else {
				if (prev > num) {
					result -= num;
				} else {
					result += num;
				}
			}
			prev = num;
			r--;
		}
		return result;
	}
}
