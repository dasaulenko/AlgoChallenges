package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumChangesToMakeAlternatingBinaryStringTest {

	@Test
	@DisplayName("s = \"0100\" -> 1")
	void testSolution1MinOperations1() {
		MinimumChangesToMakeAlternatingBinaryString task 
			= new MinimumChangesToMakeAlternatingBinaryString();
		MinimumChangesToMakeAlternatingBinaryString.Solution1 solution 
			= task.new Solution1();
		int result = solution.minOperations("0100");
		assert result == 1;
	}

	@Test
	@DisplayName("s = \"10\" -> 0")
	void testSolution1MinOperations2() {
		MinimumChangesToMakeAlternatingBinaryString task 
			= new MinimumChangesToMakeAlternatingBinaryString();
		MinimumChangesToMakeAlternatingBinaryString.Solution1 solution 
			= task.new Solution1();
		int result = solution.minOperations("10");
		assert result == 0;
	}

	@Test
	@DisplayName("s = \"1111\" -> 2")
	void testSolution1MinOperations3() {
		MinimumChangesToMakeAlternatingBinaryString task 
			= new MinimumChangesToMakeAlternatingBinaryString();
		MinimumChangesToMakeAlternatingBinaryString.Solution1 solution 
			= task.new Solution1();
		int result = solution.minOperations("1111");
		assert result == 2;
	}

		@Test
	@DisplayName("s = \"0100\" -> 1")
	void testSolution2MinOperations1() {
		MinimumChangesToMakeAlternatingBinaryString task 
			= new MinimumChangesToMakeAlternatingBinaryString();
		MinimumChangesToMakeAlternatingBinaryString.Solution2 solution 
			= task.new Solution2();
		int result = solution.minOperations("0100");
		assert result == 1;
	}

	@Test
	@DisplayName("s = \"10\" -> 0")
	void testSolution2MinOperations2() {
		MinimumChangesToMakeAlternatingBinaryString task 
			= new MinimumChangesToMakeAlternatingBinaryString();
		MinimumChangesToMakeAlternatingBinaryString.Solution2 solution 
			= task.new Solution2();
		int result = solution.minOperations("10");
		assert result == 0;
	}

	@Test
	@DisplayName("s = \"1111\" -> 2")
	void testSolution2MinOperations3() {
		MinimumChangesToMakeAlternatingBinaryString task 
			= new MinimumChangesToMakeAlternatingBinaryString();
		MinimumChangesToMakeAlternatingBinaryString.Solution2 solution 
			= task.new Solution2();
		int result = solution.minOperations("1111");
		assert result == 2;
	}
}
