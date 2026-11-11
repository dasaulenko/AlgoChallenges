package com.hramn.example;

import java.util.function.IntPredicate;

public class BinarySearchExample {

	/**
	 * Search the first elemetn in the array greater than of equal to target.
	 * Lower Bound = Ceiling
	 * @param arr
	 * @param target
	 * @return index the first elemetn in the array greater than of equal to 
	 * target or {@code arr.length} if a suitable element is not found
	 */
	public static int lowerBoundBinarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

	/**
	 * Search the first element in the array greater than target.
	 * Upper Bound = Strict Ceiling
	 * @param arr
	 * @param target
	 * @return index the first elemetn in the array greater than target or 
	 * {@code arr.length} if a suitable element is not found
	 */
	public static int upperBoundBinarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	/**
	 * Search the largest element in the array smaller than or equal to target.
	 * @param arr array
	 * @param target target
	 * @return index the largest element in the array smaller than or equal to 
	 * target or {@code -1} if a suitable element is not found
	 */
	public static int floorBinarySearch(int[] arr, int target) {
		// int l = 0;
		// int r = arr.length - 1;
		// int result = -1;

		// while (l <= r) {
		// 	int mid = l + (r-l) / 2;
		// 	if (arr[mid] <= target) {
		// 		result = mid;
		// 		l = mid + 1;
		// 	} else {
		// 		r = mid - 1;
		// 	}
		// }
		// return result;
		return upperBoundBinarySearch(arr, target) - 1;
	}

	/**
	 * Search the largest element in the array smaller than target.
	 * @param arr
	 * @param target
	 * @return index of the largest element in the array smaller than target or 
	 * {@code -1} if a suitable element is not found
	 */
	public static int strictFloorBinarySearch(int[] arr, int target) {
		return lowerBoundBinarySearch(arr, target) - 1;
	}

	/**
	 * Search the exact element in the array.
	 * If an array contains multiple identical target values, an exact binary 
	 * search does not guarantee finding the first or last occurrence.
	 * @param arr
	 * @param target
	 * @return index the exact element in the array or {@code -1} if a suitable 
	 * element is not found
	 */
	public static int exactBinarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * Search the first occurrence of the target in the array.
	 * @param nums
	 * @param target
	 * @return index the first occurrence of the target in the array or 
	 * {@code -1} if a suitable element is not found
	 */
	public static int firstOccurrence(int[] arr, int target) {
		int index = lowerBoundBinarySearch(arr, target);
		if (index == arr.length || arr[index] != target) {
			return -1;
		}
		return index;
	}

	/**
	 * Search the last occurrence of the target in the array.
	 * @param arr
	 * @param target
	 * @returnindex index the last occurrence of the target in the array or 
	 * {@code -1} if a suitable element is not found
	 */
	public static int lastOccurrence(int[] arr, int target) {
		int index = floorBinarySearch(arr, target);
		if (index < 0 || arr[index] != target) {
			return -1;
		}
		return index;
	}

	/**
	 * Count the amount of occurrences of the target in the array.
	 * @param nums
	 * @param target
	 * @return the amount of occurrences of the target in the array
	 */
	public static int countOccurrences(int[] arr, int target) {
		return upperBoundBinarySearch(arr, target) 
			- lowerBoundBinarySearch(arr, target);
	}

	/**
	 * Search the minimum or maximum value that satisfies a specific condition
	 * 
	 * <p><Strong>Requirements:</strong>
	 * <ul>
	 *   <li>monotonicity of the predicate</li>
	 *   <li>there is at least one value in the range that satisfies the condition</li>
	 * </ul>
	 * 
	 * <p>Example: {@code int result = binarySearchAnswer(1, 100, speed -> speed >= 37);}
	 * 
	 * @param left the lowest possible answer
	 * @param right the highest possible answer
	 * @param condition specific condition
	 * @return the minimum value that satisfies a specific condition
	 */
	public static int binarySearchOnAnswer(int left, int right, IntPredicate condition) {
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (condition.test(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	/**
	 * Search the minimum or maximum value that satisfies a specific condition
	 * 
	 * <p><Strong>Requirements:</strong>
	 * <ul>
	 *   <li>monotonicity of the predicate</li>
	 * </ul>
	 * 
	 * @param arr array of possible answers
	 * @param condition specific condition
	 * @return the minimum index of value that satisfies a specific condition or 
	 * {@code arr.length} if a suitable element is not found
	 */
	public static int binarySearchOnAnswer(int[] arr, IntPredicate condition) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (condition.test(arr[mid])) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	/**
	 * Searching for a value in a sorted array that has undergone a cyclic shift
	 * 
	 * <p><Strong>Requirements:</strong>
	 * <ul>
	 *   <li>the given array must not contain duplicates</li>
	 * </ul>
	 * 
	 * @param arr a sorted array that has undergone a cyclic shift
	 * @param target a target value
	 * @return the index of the element or {@code -1} if a suitable element is 
	 * not found
	 */
	public static int rotatedSortedArrayBinarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == target) return mid;

			if (arr[left] <= arr[mid]) {
				if (arr[left] <= target && target < arr[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (arr[mid] < target && target <= arr[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
