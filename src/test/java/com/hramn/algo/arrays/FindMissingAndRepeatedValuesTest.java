package com.hramn.algo.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMissingAndRepeatedValuesTest {
	@Test
	@DisplayName("grid = [[1,3],[2,2]] -> [2,4]")
	void testFindMissingAndRepeatedValues1() {
		FindMissingAndRepeatedValues parent = new FindMissingAndRepeatedValues();
		FindMissingAndRepeatedValues.Solution solution = parent.new Solution();
		int[] result = solution.findMissingAndRepeatedValues(new int[][] {{1,3},{2,2}});
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals(2, result[0]);
		assertEquals(4, result[1]);
	}

	@Test
	@DisplayName("grid = [[9,1,7],[8,9,2],[3,4,6]] -> [9,5]")
	void testFindMissingAndRepeatedValues2() {
		FindMissingAndRepeatedValues parent = new FindMissingAndRepeatedValues();
		FindMissingAndRepeatedValues.Solution solution = parent.new Solution();
		int[] result = solution.findMissingAndRepeatedValues(new int[][] {{9,1,7},{8,9,2},{3,4,6}});
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals(9, result[0]);
		assertEquals(5, result[1]);
	}
}
