package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConcatenationOfConsecutiveBinaryNumbersTest {

	@Test
	@DisplayName("n = 1 -> 1")
	void testConcatenatedBinary1() {
		ConcatenationOfConsecutiveBinaryNumbers task = new ConcatenationOfConsecutiveBinaryNumbers();
		ConcatenationOfConsecutiveBinaryNumbers.Solution solution = task.new Solution();
		int result = solution.concatenatedBinary(1);
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("n = 3 -> 27")
	void testConcatenatedBinary2() {
		ConcatenationOfConsecutiveBinaryNumbers task = new ConcatenationOfConsecutiveBinaryNumbers();
		ConcatenationOfConsecutiveBinaryNumbers.Solution solution = task.new Solution();
		int result = solution.concatenatedBinary(3);
		assertEquals(27, result);
	}
	
	@Test
	@DisplayName("n = 12 -> 505379714")
	void testConcatenatedBinary3() {
		ConcatenationOfConsecutiveBinaryNumbers task = new ConcatenationOfConsecutiveBinaryNumbers();
		ConcatenationOfConsecutiveBinaryNumbers.Solution solution = task.new Solution();
		int result = solution.concatenatedBinary(12);
		assertEquals(505379714, result);
	}

}
