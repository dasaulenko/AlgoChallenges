package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalCharactersInStringAfterTransformationsITest {
	@Test
	@DisplayName("s = \"abcyy\", t = 2 -> 7")
	void testSolutionLengthAfterTransformations1() {
		TotalCharactersInStringAfterTransformationsI task = 
				new TotalCharactersInStringAfterTransformationsI();
		TotalCharactersInStringAfterTransformationsI.Solution solution = 
				task.new Solution();
		int result = solution.lengthAfterTransformations("abcyy", 2);
		assertEquals(7, result);
	}

	@Test
	@DisplayName("s = \"azbk\", t = 1 -> 5")
	void testSolutionLengthAfterTransformations2() {
		TotalCharactersInStringAfterTransformationsI task = 
				new TotalCharactersInStringAfterTransformationsI();
		TotalCharactersInStringAfterTransformationsI.Solution solution = 
				task.new Solution();
		int result = solution.lengthAfterTransformations("azbk", 1);
		assertEquals(5, result);
	}
}
