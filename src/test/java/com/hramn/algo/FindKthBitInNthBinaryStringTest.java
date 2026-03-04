package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindKthBitInNthBinaryStringTest {

	@Test
	@DisplayName("n = 3, k = 1 -> '0'")
	void testSolutionFindKthBit1() {
		FindKthBitInNthBinaryString task = new FindKthBitInNthBinaryString();
		FindKthBitInNthBinaryString.Solution solution = task.new Solution();
		char result = solution.findKthBit(3, 1);
		assert result == '0';
	}

	@Test
	@DisplayName("n = 4, k = 11 -> '1'")
	void testSolutionFindKthBit2() {
		FindKthBitInNthBinaryString task = new FindKthBitInNthBinaryString();
		FindKthBitInNthBinaryString.Solution solution = task.new Solution();
		char result = solution.findKthBit(4, 11);
		assert result == '1';
	}

}
