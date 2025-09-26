package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LongestUnequalAdjacentGroupsSubsequenceITest {
	@Test
	@DisplayName("words = [\"e\",\"a\",\"b\"], groups = [0,0,1] -> [\"e\",\"b\"]")
	void testSolutionGetLongestSubsequence1() {
		LongestUnequalAdjacentGroupsSubsequenceI main 
				= new LongestUnequalAdjacentGroupsSubsequenceI();
		LongestUnequalAdjacentGroupsSubsequenceI.Solution solution 
				= main.new Solution();
		List<String> result = solution.getLongestSubsequence(
				new String[] {"e","a","b"}, new int[] {0,0,1});
		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(Arrays.equals(new String[] {"e","b"}, result.toArray()));
	}

	@Test
	@DisplayName("words = [\"a\",\"b\",\"c\",\"d\"], groups = [1,0,1,1] -> [\"a\",\"b\",\"c\"]")
	void testSolutionGetLongestSubsequence2() {
		LongestUnequalAdjacentGroupsSubsequenceI main 
				= new LongestUnequalAdjacentGroupsSubsequenceI();
		LongestUnequalAdjacentGroupsSubsequenceI.Solution solution 
				= main.new Solution();
		List<String> result = solution.getLongestSubsequence(
				new String[] {"a","b","c","d"}, new int[] {1,0,1,1});
		assertNotNull(result);
		assertEquals(3, result.size());
		assertTrue(Arrays.equals(new String[] {"a","b","c"}, result.toArray()));
	}
}
