package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LongestUnequalAdjacentGroupsSubsequenceIITest {
	@Test
	@DisplayName("words = [\"bab\",\"dab\",\"cab\"], groups = [1,2,2] -> [\"bab\",\"cab\"]")
	void testSolutionGetWordsInLongestSubsequence1() {
		LongestUnequalAdjacentGroupsSubsequenceII main = 
				new LongestUnequalAdjacentGroupsSubsequenceII();
		LongestUnequalAdjacentGroupsSubsequenceII.Solution solution = 
				main.new Solution();
		List<String> result = solution.getWordsInLongestSubsequence(
				new String[] {"bab","dab","cab"}, new int[] {1,2,2});
		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(Arrays.equals(new String[] {"bab","dab"}, result.toArray()));
	}

	@Test
	@DisplayName("words = [\"a\",\"b\",\"c\",\"d\"], groups = [1,2,3,4] -> [\"a\",\"b\",\"c\",\"d\"]")
	void testSolutionGetWordsInLongestSubsequence2() {
		LongestUnequalAdjacentGroupsSubsequenceII main = 
				new LongestUnequalAdjacentGroupsSubsequenceII();
		LongestUnequalAdjacentGroupsSubsequenceII.Solution solution = 
				main.new Solution();
		List<String> result = solution.getWordsInLongestSubsequence(
				new String[] {"a","b","c","d"}, new int[] {1,2,3,4});
		assertNotNull(result);
		assertEquals(4, result.size());
		assertTrue(Arrays.equals(new String[] {"a","b","c","d"}, result.toArray()));
	}
}
