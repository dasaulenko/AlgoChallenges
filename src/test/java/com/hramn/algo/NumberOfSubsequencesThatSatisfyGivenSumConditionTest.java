package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberOfSubsequencesThatSatisfyGivenSumConditionTest {
	@Test
	@DisplayName("nums = [3,5,6,7], target = 9 -> 4")
	void testSolutionNumSubseq1() {
		NumberOfSubsequencesThatSatisfyGivenSumCondition task = new NumberOfSubsequencesThatSatisfyGivenSumCondition();
		NumberOfSubsequencesThatSatisfyGivenSumCondition.Solution solution = task.new Solution();
		int result = solution.numSubseq(new int[] {3,5,6,7}, 9);
		assertEquals(result, 4);
	}

	@Test
	@DisplayName("nums = [3,3,6,8], target = 10 -> 6")
	void testSolutionNumSubseq2() {
		NumberOfSubsequencesThatSatisfyGivenSumCondition task = new NumberOfSubsequencesThatSatisfyGivenSumCondition();
		NumberOfSubsequencesThatSatisfyGivenSumCondition.Solution solution = task.new Solution();
		int result = solution.numSubseq(new int[] {3,3,6,8}, 10);
		assertEquals(result, 6);
	}

	@Test
	@DisplayName("nums = [2,3,3,4,6,7], target = 12 -> 61")
	void testSolutionNumSubseq3() {
		NumberOfSubsequencesThatSatisfyGivenSumCondition task = new NumberOfSubsequencesThatSatisfyGivenSumCondition();
		NumberOfSubsequencesThatSatisfyGivenSumCondition.Solution solution = task.new Solution();
		int result = solution.numSubseq(new int[] {2,3,3,4,6,7}, 12);
		assertEquals(result, 61);
	}
}
