package com.hramn.algo;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/*
 * Task
 * Дан массив чисел состоящий из n элементов. Числа обозначают температуру в 
 * конкретный день. Нужно определить для каждого дня, сколько суток должно 
 * пройти до наступления более тёплого дня.
 * 
 * Example
 * Input: int[] {13, 12, 15, 11, 9, 12, 16}
 * Output: int[] {2, 1, 4, 2, 1, 1, 0}
 */

public class HotterDaySearch {

	public static void main(String[] args) {
		int[] arr = new int[] {13, 12, 15, 11, 9, 12, 16};
		System.out.println(Arrays.stream(Solution_1.temperatures(arr)).boxed()
				.collect(Collectors.toList()));
		System.out.println(Arrays.stream(Solution_2.temperatures(arr)).boxed()
				.collect(Collectors.toList()));
		System.out.println(Arrays.stream(Solution_2b.temperatures(arr)).boxed()
				.collect(Collectors.toList()));
	}
	
	// Решение 1 (time O(n**2), memory O(n))
	static class Solution_1 {
		static int[] temperatures(int[] t) {
			int[] answer = new int[t.length];
			for (int i = 0; i < t.length; i++) {
				for (int j = i + 1; j < t.length; j++) {
					if (t[i] < t[j]) {
						answer[i] = j - i;
						break;
					}
				}
			}
			return answer;
		}
	}
	
	//Решение 2 (time O(n), memory O(n))
	static class Solution_2 {
		
	    static class C {
	        int value;
	        int index;
	        C (int value, int index) {
	            this.value = value;
	            this.index = index;
	        }
	    }
	    
	    static int[] temperatures(int[] t) {
	        Stack<C> stack = new Stack<>();
	        int[] answer = new int[t.length];
	        for (int i = t.length - 1; i >= 0; i--) {
	            while(!stack.isEmpty() && stack.peek().value <= t[i]) {
	                stack.pop();
	            }
	            if (!stack.isEmpty()) {
	                answer[i] = stack.peek().index - i;
	            }
	            stack.push(new C (t[i], i));
	        }
	        return answer;
	    }
	}
	
	//Решение 2 другими словами (time O(n), memory O(n))
	static class Solution_2b {
		static class Day {
			private int number;
			private int temperature;
			
			public Day(int number, int temperature) {
				this.number = number;
				this.temperature = temperature;
			}
			
			public int getNumber() {
				return this.number;
			}
			
			public int getTemperature() {
				return this.temperature;
			}
		}

		static int[] temperatures(int[] arr) {
			if (arr.length == 0) return new int[0];
			int r = arr.length - 1;
			Stack<Day> stack = new Stack<>();
			int[] result = new int[arr.length];
			while (r >= 0) {
				if (stack.isEmpty()) {
					result[r] = 0;
					stack.push(new Day(r, arr[r]));
					r--;
				} else {
					Day d = stack.peek();
					if (arr[r] < d.getTemperature()) {
						stack.push(new Day(r, arr[r]));
						result[r] = d.getNumber() - r;
						r--;
					} else {
						stack.pop();
					}
				}
			}
			return result;
		}
	}
}
