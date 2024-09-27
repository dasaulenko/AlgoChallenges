package com.hramn.algo;

import java.util.HashMap;
import java.util.Map;

public class TaskIntegerToRoman {

	// Конвертировать int в римское число
	
	public static void main(String[] args) {
		System.out.println(intToRoman(1999));
	}
	
	private static Map<Integer, String> one = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
	{
		put(1, "I");
		put(10, "X");
		put(100, "C");
		put(1000, "M");
	}};
	private static Map<Integer, String> five = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
	{
		put(5, "V");
		put(50, "L");
		put(500, "D");
	}};
	
    // 1 - I    / X    / C   / M
	// 2 - II   / XX   / CC  / MM
	// 3 - III  / XXX  / CCC / MMM
	// 4 - IV   / XL   / CD
	// 5 - V    / L    / D
	// 6 - VI   / LX   / DC
	// 7 - VII  / LXX  / DCC
	// 8 - VIII / LXXX / DCCC
	// 9 - IX   / XC   / CM
	// 0 - 
	private static String intToRoman(int num) {
		if (num > 9999) throw new IllegalStateException();
		String str = Integer.toString(num);
		String result = "";
		int digit = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			result = getNumber(str.charAt(i) - '0', digit) + result;
			digit = digit * 10;
		}
		return result;
	}
	
	private static String getNumber(int n, int digit) {
		String result = "";
		if (n == 0) return result;
		if (n < 4) {
			for (int i = 0; i < n; i++) {
				result += one.get(digit);
			}
		} else if (n == 4) {
			result = "" + one.get(digit) + five.get(digit*5);
		} else if (n < 9) {
			result = five.get(digit*5);
			for (int i = 5; i < n; i++) {
				result += one.get(digit);
			}
		} else if (n == 9) {
			result = "" + one.get(digit) + one.get(digit*10);
		}
		return result;
	}
}
