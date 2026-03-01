package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindingThreeDigitEvenNumbersTest {
	@Test
	@DisplayName("digits = [2,1,3,0] -> [102,120,130,132,210,230,302,310,312,320]")
	void testSolutionFindEvenNumbers1() {
		FindingThreeDigitEvenNumbers task = new FindingThreeDigitEvenNumbers();
		FindingThreeDigitEvenNumbers.Solution solution = task.new Solution();
		int[] result = solution.findEvenNumbers(new int[] {2,1,3,0});
		assertNotNull(result);
		assertEquals(10, result.length);
		assertTrue(Arrays.equals(new int[] {102,120,130,132,210,230,302,310,312,320}, result));
	}

	@Test
	@DisplayName("digits = [2,2,8,8,2] -> [222,228,282,288,822,828,882]")
	void testSolutionFindEvenNumbers2() {
		FindingThreeDigitEvenNumbers task = new FindingThreeDigitEvenNumbers();
		FindingThreeDigitEvenNumbers.Solution solution = task.new Solution();
		int[] result = solution.findEvenNumbers(new int[] {2,2,8,8,2});
		assertNotNull(result);
		assertEquals(7, result.length);
		assertTrue(Arrays.equals(new int[] {222,228,282,288,822,828,882}, result));
	}
}
