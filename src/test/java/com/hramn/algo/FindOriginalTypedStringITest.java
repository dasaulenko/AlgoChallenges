package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindOriginalTypedStringITest {
	@Test
	@DisplayName("word = \"abbcccc\" -> 5")
	void testSolutionPossibleStringCount1() {
		FindOriginalTypedStringI task = new FindOriginalTypedStringI();
		FindOriginalTypedStringI.Solution solution = task.new Solution();
		int result = solution.possibleStringCount("abbcccc");
		assertEquals(5, result);
	}

	@Test
	@DisplayName("word = \"abcd\" -> 1")
	void testSolutionPossibleStringCount2() {
		FindOriginalTypedStringI task = new FindOriginalTypedStringI();
		FindOriginalTypedStringI.Solution solution = task.new Solution();
		int result = solution.possibleStringCount("abcd");
		assertEquals(1, result);
	}

	@Test
	@DisplayName("word = \"aaaa\" -> 4")
	void testSolutionPossibleStringCount3() {
		FindOriginalTypedStringI task = new FindOriginalTypedStringI();
		FindOriginalTypedStringI.Solution solution = task.new Solution();
		int result = solution.possibleStringCount("aaaa");
		assertEquals(4, result);
	}
}
