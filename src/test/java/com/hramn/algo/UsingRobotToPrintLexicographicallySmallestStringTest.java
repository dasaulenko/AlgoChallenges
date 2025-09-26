package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsingRobotToPrintLexicographicallySmallestStringTest {
	@Test
	@DisplayName("s = \"zza\" -> \"azz\"")
	void testSolutionRobotWithString1() {
		UsingRobotToPrintLexicographicallySmallestString task = new UsingRobotToPrintLexicographicallySmallestString();
		UsingRobotToPrintLexicographicallySmallestString.Solution solution = task.new Solution();
		String result = solution.robotWithString("zza");
		assertNotNull(result);
		assertEquals("azz", result);
	}

	@Test
	@DisplayName("s = \"bac\" -> \"abc\"")
	void testSolutionRobotWithString2() {
		UsingRobotToPrintLexicographicallySmallestString task = new UsingRobotToPrintLexicographicallySmallestString();
		UsingRobotToPrintLexicographicallySmallestString.Solution solution = task.new Solution();
		String result = solution.robotWithString("bac");
		assertNotNull(result);
		assertEquals("abc", result);
	}

	@Test
	@DisplayName("s = \"bdda\" -> \"addb\"")
	void testSolutionRobotWithString3() {
		UsingRobotToPrintLexicographicallySmallestString task = new UsingRobotToPrintLexicographicallySmallestString();
		UsingRobotToPrintLexicographicallySmallestString.Solution solution = task.new Solution();
		String result = solution.robotWithString("bdda");
		assertNotNull(result);
		assertEquals("addb", result);
	}
}
