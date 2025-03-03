package com.hramn.algo.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PartitionArrayAccordingToGivenPivotTest {
	@Test
	@DisplayName("nums = [9,12,5,10,14,3,10], pivot = 10 -> [9,5,3,10,10,12,14]")
	void testPivotArray1() {
		testPivotArray(
			new int[] {9,12,5,10,14,3,10}, 
			10, 
			new int[] {9,5,3,10,10,12,14});
	}

	@Test
	@DisplayName("nums = [-3,4,3,2], pivot = 2 -> [-3,2,4,3]")
	void testPivotArray2() {
		testPivotArray(
			new int[] {-3,4,3,2}, 
			2, 
			new int[] {-3,2,4,3});
	}

	private void testPivotArray(int[] nums, int pivot, int[] expected) {
		PartitionArrayAccordingToGivenPivot parent = 
				new PartitionArrayAccordingToGivenPivot();
		PartitionArrayAccordingToGivenPivot.Solution solution = 
				parent.new Solution();
		int[] result = solution.pivotArray(nums, pivot);
		System.out.println(Arrays.toString(result));
		assertNotNull(result);
		assertEquals(expected.length, result.length);
		assertTrue(Arrays.equals(result, expected));
	}
}
