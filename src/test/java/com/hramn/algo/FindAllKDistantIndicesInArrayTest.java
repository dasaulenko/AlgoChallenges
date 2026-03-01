package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindAllKDistantIndicesInArrayTest {
	@Test
	@DisplayName("nums = [3,4,9,1,3,9,5], key = 9, k = 1 -> [1,2,3,4,5,6]")
	void testSolutionFindKDistantIndices1() {
		FindAllKDistantIndicesInArray task = new FindAllKDistantIndicesInArray();
		FindAllKDistantIndicesInArray.Solution solution = task.new Solution();
		List<Integer> result = solution.findKDistantIndices(new int[] {3,4,9,1,3,9,5}, 9, 1);
		assertNotNull(result);
		assertEquals(6, result.size());
		assertTrue(Arrays.asList(1,2,3,4,5,6).equals(result));
	}

	@Test
	@DisplayName("nums = [2,2,2,2,2], key = 2, k = 2 -> [0,1,2,3,4]")
	void testSolutionFindKDistantIndices2() {
		FindAllKDistantIndicesInArray task = new FindAllKDistantIndicesInArray();
		FindAllKDistantIndicesInArray.Solution solution = task.new Solution();
		List<Integer> result = solution.findKDistantIndices(new int[] {2,2,2,2,2}, 2, 2);
		assertNotNull(result);
		assertEquals(5, result.size());
		assertTrue(Arrays.asList(0,1,2,3,4).equals(result));
	}
}
