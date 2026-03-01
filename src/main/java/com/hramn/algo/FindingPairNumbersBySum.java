package com.hramn.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Task
 * Дан отсортированный массив чисел и значение k. Необходимо найти любую пару чисел в массиве 
 * суммы которых равны k.
 * 
 * Example 1
 * Input: int[] {-1, 2, 5, 8}, k = 7
 * Output: int[] {2, 5} or int[] {-1, 8}
 * 
 * Example 2
 * Input: int[] {-3, -1, 0, 2, 6}, k = 6
 * Output: int[] {0, 6}
 * 
 * Example 3
 * Input: int[] {2, 4, 5}, k = 8
 * Output: int[] {}
 * 
 * Example 4
 * Input: int[] {-2, -1, 1, 2}, k = 0
 * Output: int[] {-2, 2} or int[] {-1, 1}
 */

public class FindingPairNumbersBySum {

	public static void main(String[] args) {
		Random random = new Random();
		int[] nums = new int[1000];
		for (int i=0; i<nums.length; i++) {
			nums[i] = random.nextInt(1000);
		}
		System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		
		int[] result = Solution_1.solution(nums, 1);
		System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
		result = Solution_2.solution(nums, 1);
		System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
		Arrays.sort(nums);
		result = Solution_3.solution(nums, 1);
		System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
		result = Solution_4.solution(nums, 1);
		System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
	}
	
	// Решение 1. Перебор всех пар чисел (time O(n**2), memory O(1))
	static class Solution_1 {
		static int[] solution(int[] nums, int k) {
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == k) {
						return new int[] {nums[i], nums[j]};
					}
				}
			}
			return new int[0];
		}
	}
	
	// Решение 2. Использование HashSet (time O(n), memory O(n))
	static class Solution_2 {
		static int[] solution(int[] nums, int k) {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < nums.length; i++) {
				int numberToFind = k - nums[i];
				if (set.contains(numberToFind)) {
					return new int[] {numberToFind, nums[i]};
				}
				set.add(nums[i]);
			}
			return new int[0];
		}
	}
	
	// Решение 3. Использование бинарного поиска, для отсортированного массива 
	// (time O(n log n), memory O(1))
	static class Solution_3 {
		static int[] solution(int[] nums, int k) {
			for (int i = 0; i < nums.length; i++) {
				int numberToFind = k - nums[i];
				int l = i + 1, r = nums.length - 1;
				while (l <= r) {
					int mid = l + (r - l)/2;
					if (nums[mid] == numberToFind) {
						return new int[] {nums[i], nums[mid]};
					}
					if (numberToFind < nums[mid]) {
						r = mid - 1;
					} else {
						l = mid + 1;
					}
				}
			}
			return new int[0];
		}
	}
	
	// Решение 4. Использование двух указателей для отсортированного массива 
	// (time O(n), memory O(1))
	static class Solution_4 {
		static int[] solution(int[] nums, int k) {
			int l = 0, r = nums.length - 1;
			while (l < r) {
				int sum = nums[l] + nums[r];
				if (sum == k) {
					return new int[] {nums[l], nums[r]};
				}
				if (sum < k) {
					l++;
				} else {
					r--;
				}
			}
			return new int[0];
		}
	}
}
