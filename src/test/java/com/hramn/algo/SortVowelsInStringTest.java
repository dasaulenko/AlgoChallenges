package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortVowelsInStringTest {
	@Test
	@DisplayName("s = \"lEetcOde\" -> \"lEOtcede\"")
	void testSolutionSortVowels1() {
		SortVowelsInString task = new SortVowelsInString();
		SortVowelsInString.Solution solution = task.new Solution();
		String result = solution.sortVowels("lEetcOde");
		assertNotNull(result);
		assertEquals("lEOtcede", result);
	}

	@Test
	@DisplayName("s = \"lYmpH\" -> \"lYmpH\"")
	void testSolutionSortVowels2() {
		SortVowelsInString task = new SortVowelsInString();
		SortVowelsInString.Solution solution = task.new Solution();
		String result = solution.sortVowels("lYmpH");
		assertNotNull(result);
		assertEquals("lYmpH", result);
	}
}
