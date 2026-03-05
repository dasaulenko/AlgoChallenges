package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryGapTest {

	@Test
	@DisplayName("n = 22 -> 2")
	void testSolutionBinaryGap1() {
		BinaryGap task = new BinaryGap();
		BinaryGap.Solution solution = task.new Solution();
		int result = solution.binaryGap(22);
		assert result == 2;
	}

	@Test
	@DisplayName("n = 8 -> 0")
	void testSolutionBinaryGap2() {
		BinaryGap task = new BinaryGap();
		BinaryGap.Solution solution = task.new Solution();
		int result = solution.binaryGap(8);
		assert result == 0;
	}

	@Test
	@DisplayName("n = 5 -> 2")
	void testSolutionBinaryGap3() {
		BinaryGap task = new BinaryGap();
		BinaryGap.Solution solution = task.new Solution();
		int result = solution.binaryGap(5);
		assert result == 2;
	}
}
