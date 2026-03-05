package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIfStringContainsAllBinaryCodesOfSizeKTest {

	@Test
	@DisplayName("s = \"00110110\", k = 2 -> true")
	void testSolutionHasAllCodes1() {
		CheckIfStringContainsAllBinaryCodesOfSizeK task 
			= new CheckIfStringContainsAllBinaryCodesOfSizeK();
		CheckIfStringContainsAllBinaryCodesOfSizeK.Solution solution
			= task.new Solution();
		boolean result = solution.hasAllCodes("00110110", 2);
		assert result;
	}

	@Test
	@DisplayName("s = \"0110\", k = 1 -> true")
	void testSolutionHasAllCodes2() {
		CheckIfStringContainsAllBinaryCodesOfSizeK task 
			= new CheckIfStringContainsAllBinaryCodesOfSizeK();
		CheckIfStringContainsAllBinaryCodesOfSizeK.Solution solution
			= task.new Solution();
		boolean result = solution.hasAllCodes("0110", 1);
		assert result;
	}

	@Test
	@DisplayName("s = \"0110\", k = 2 -> false")
	void testSolutionHasAllCodes3() {
		CheckIfStringContainsAllBinaryCodesOfSizeK task 
			= new CheckIfStringContainsAllBinaryCodesOfSizeK();
		CheckIfStringContainsAllBinaryCodesOfSizeK.Solution solution
			= task.new Solution();
		boolean result = solution.hasAllCodes("0110", 2);
		assert !result;
	}
}
