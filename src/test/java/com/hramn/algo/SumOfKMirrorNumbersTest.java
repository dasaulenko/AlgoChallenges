package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumOfKMirrorNumbersTest {
	@Test
	@DisplayName("k = 2, n = 5 -> 25")
	void testSolutionKMirror1() {
		SumOfKMirrorNumbers task = new SumOfKMirrorNumbers();
		SumOfKMirrorNumbers.Solution solution = task.new Solution();
		long result = solution.kMirror(2, 5);
		assertEquals(result, 25);
	}

	@Test
	@DisplayName("k = 3, n = 7 -> 499")
	void testSolutionKMirror2() {
		SumOfKMirrorNumbers task = new SumOfKMirrorNumbers();
		SumOfKMirrorNumbers.Solution solution = task.new Solution();
		long result = solution.kMirror(3, 7);
		assertEquals(result,499);
	}

	@Test
	@DisplayName("k = 7, n = 17 -> 20379000")
	void testSolutionKMirror3() {
		SumOfKMirrorNumbers task = new SumOfKMirrorNumbers();
		SumOfKMirrorNumbers.Solution solution = task.new Solution();
		long result = solution.kMirror(7, 17);
		assertEquals(result,20379000);
	}
}
