package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIfNumberIsSumOfPowersOfThreeTest {
	@Test
	@DisplayName("n = 12 -> true")
	void checkPowersOfThreeTest1() {
		CheckIfNumberIsSumOfPowersOfThree parent = 
				new CheckIfNumberIsSumOfPowersOfThree();
		CheckIfNumberIsSumOfPowersOfThree.Solution solution = parent.new Solution();
		boolean result = solution.checkPowersOfThree(12);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 91 -> true")
	void checkPowersOfThreeTest2() {
		CheckIfNumberIsSumOfPowersOfThree parent = 
				new CheckIfNumberIsSumOfPowersOfThree();
		CheckIfNumberIsSumOfPowersOfThree.Solution solution = parent.new Solution();
		boolean result = solution.checkPowersOfThree(91);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 21 -> false")
	void checkPowersOfThreeTest3() {
		CheckIfNumberIsSumOfPowersOfThree parent = 
				new CheckIfNumberIsSumOfPowersOfThree();
		CheckIfNumberIsSumOfPowersOfThree.Solution solution = parent.new Solution();
		boolean result = solution.checkPowersOfThree(21);
		assertFalse(result);
	}
}
