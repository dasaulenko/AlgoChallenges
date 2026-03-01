package com.hramn.algo.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {
	
	@Test
	@DisplayName("nums = [5,7,7,8,8,10], target = 8 -> [3,4]")
	void testSearchRange1() {
		FindFirstAndLastPositionOfElementInSortedArray 
				findFirstAndLastPositionOfElementInSortedArray = 
				new FindFirstAndLastPositionOfElementInSortedArray();
		FindFirstAndLastPositionOfElementInSortedArray.Solution solution = 
				findFirstAndLastPositionOfElementInSortedArray.new Solution();
		int[] result = solution.searchRange(new int[]{5,7,7,8,8,10}, 8);
		assertNotNull(result);
		assertEquals(result.length, 2);
		assertEquals(result[0], 3);
		assertEquals(result[1], 4);
	}

	@Test
	@DisplayName("nums = [5,7,7,8,8,10], target = 6 -> [-1,-1]")
	void testSearchRange2() {
		FindFirstAndLastPositionOfElementInSortedArray 
				findFirstAndLastPositionOfElementInSortedArray = 
				new FindFirstAndLastPositionOfElementInSortedArray();
		FindFirstAndLastPositionOfElementInSortedArray.Solution solution = 
				findFirstAndLastPositionOfElementInSortedArray.new Solution();
		int[] result = solution.searchRange(new int[]{5,7,7,8,8,10}, 6);
		assertNotNull(result);
		assertEquals(result.length, 2);
		assertEquals(result[0], -1);
		assertEquals(result[1], -1);
	}

	@Test
	@DisplayName("nums = [], target = 0 -> [-1,-1]")
	void testSearchRange3() {
		FindFirstAndLastPositionOfElementInSortedArray 
				findFirstAndLastPositionOfElementInSortedArray = 
				new FindFirstAndLastPositionOfElementInSortedArray();
		FindFirstAndLastPositionOfElementInSortedArray.Solution solution = 
				findFirstAndLastPositionOfElementInSortedArray.new Solution();
		int[] result = solution.searchRange(new int[0], 0);
		assertNotNull(result);
		assertEquals(result.length, 2);
		assertEquals(result[0], -1);
		assertEquals(result[1], -1);
	}
}
