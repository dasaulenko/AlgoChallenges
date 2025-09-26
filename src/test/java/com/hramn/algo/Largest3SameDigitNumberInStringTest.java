package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Largest3SameDigitNumberInStringTest {
	@Test
	@DisplayName("num = \"6777133339\" -> \"777\"")
	void testSolutionLargestGoodInteger1() {
		Largest3SameDigitNumberInString task = new Largest3SameDigitNumberInString();
		Largest3SameDigitNumberInString.Solution solution = task.new Solution();
		String result = solution.largestGoodInteger("6777133339");
		assertNotNull(result);
		assertEquals(result, "777");
	}

	@Test
	@DisplayName("num = \"2300019\" -> \"000\"")
	void testSolutionLargestGoodInteger2() {
		Largest3SameDigitNumberInString task = new Largest3SameDigitNumberInString();
		Largest3SameDigitNumberInString.Solution solution = task.new Solution();
		String result = solution.largestGoodInteger("2300019");
		assertNotNull(result);
		assertEquals(result, "000");
	}

	@Test
	@DisplayName("num = \"42352338\" -> \"\"")
	void testSolutionLargestGoodInteger3() {
		Largest3SameDigitNumberInString task = new Largest3SameDigitNumberInString();
		Largest3SameDigitNumberInString.Solution solution = task.new Solution();
		String result = solution.largestGoodInteger("42352338");
		assertNotNull(result);
		assertEquals(result, "");
	}

		@Test
	@DisplayName("num = \"6777133339\" -> \"777\"")
	void testBestTimeSolutionLargestGoodInteger1() {
		Largest3SameDigitNumberInString task = new Largest3SameDigitNumberInString();
		Largest3SameDigitNumberInString.BestTimeSolution solution = task.new BestTimeSolution();
		String result = solution.largestGoodInteger("6777133339");
		assertNotNull(result);
		assertEquals(result, "777");
	}

	@Test
	@DisplayName("num = \"2300019\" -> \"000\"")
	void testBestTimeSolutionLargestGoodInteger2() {
		Largest3SameDigitNumberInString task = new Largest3SameDigitNumberInString();
		Largest3SameDigitNumberInString.BestTimeSolution solution = task.new BestTimeSolution();
		String result = solution.largestGoodInteger("2300019");
		assertNotNull(result);
		assertEquals(result, "000");
	}

	@Test
	@DisplayName("num = \"42352338\" -> \"\"")
	void testBestTimeSolutionLargestGoodInteger3() {
		Largest3SameDigitNumberInString task = new Largest3SameDigitNumberInString();
		Largest3SameDigitNumberInString.BestTimeSolution solution = task.new BestTimeSolution();
		String result = solution.largestGoodInteger("42352338");
		assertNotNull(result);
		assertEquals(result, "");
	}
}
