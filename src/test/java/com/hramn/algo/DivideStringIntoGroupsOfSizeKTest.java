package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivideStringIntoGroupsOfSizeKTest {
	@Test
	@DisplayName("s = \"abcdefghi\", k = 3, fill = \"x\" -> [\"abc\",\"def\",\"ghi\"]")
	void testSolutionDivideString1() {
		DivideStringIntoGroupsOfSizeK task = new DivideStringIntoGroupsOfSizeK();
		DivideStringIntoGroupsOfSizeK.Solution solution = task.new Solution();
		String[] result = solution.divideString("abcdefghi", 3, 'x');
		assertNotNull(result);
		assertEquals(3, result.length);
		assertTrue(Arrays.equals(new String[] {"abc","def","ghi"}, result));
	}

	@Test
	@DisplayName("s = \"abcdefghij\", k = 3, fill = \"x\" -> [\"abc\",\"def\",\"ghi\",\"jxx\"]")
	void testSolutionDivideString2() {
		DivideStringIntoGroupsOfSizeK task = new DivideStringIntoGroupsOfSizeK();
		DivideStringIntoGroupsOfSizeK.Solution solution = task.new Solution();
		String[] result = solution.divideString("abcdefghij", 3, 'x');
		assertNotNull(result);
		assertEquals(4, result.length);
		assertTrue(Arrays.equals(new String[] {"abc","def","ghi","jxx"}, result));
	}
}
