package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumScoreFromRemovingSubstringsTest {
	@Test
	@DisplayName("s = \"cdbcbbaaabab\", x = 4, y = 5 -> 19")
	void testSolutionMaximumGain1() {
		MaximumScoreFromRemovingSubstrings task = new MaximumScoreFromRemovingSubstrings();
		MaximumScoreFromRemovingSubstrings.Solution solution = task.new Solution();
		int result = solution.maximumGain("cdbcbbaaabab", 4, 5);
		assertEquals(19, result);
	}

	@Test
	@DisplayName("s = \"aabbaaxybbaabb\", x = 5, y = 4 -> 20")
	void testSolutionMaximumGain2() {
		MaximumScoreFromRemovingSubstrings task = new MaximumScoreFromRemovingSubstrings();
		MaximumScoreFromRemovingSubstrings.Solution solution = task.new Solution();
		int result = solution.maximumGain("cdbcbbaaabab", 4, 5);
		assertEquals(19, result);
	}
}
