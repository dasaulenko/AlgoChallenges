package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalCharactersInStringAfterTransformationsIITest {
	@Test
	@DisplayName("s = \"abcyy\", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2] -> 7")
	void testBruteForceSolutionLengthAfterTransformations1() {
		TotalCharactersInStringAfterTransformationsII main 
				= new TotalCharactersInStringAfterTransformationsII();
		TotalCharactersInStringAfterTransformationsII.BruteForceSolution solution 
				= main.new BruteForceSolution();
		int result = solution.lengthAfterTransformations("abcyy", 2, List.of(
				1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2));
		assertEquals(7, result);
	}

	@Test
	@DisplayName("s = \"azbk\", t = 1, nums = [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2] -> 8")
	void testBruteForceSolutionLengthAfterTransformations2() {
		TotalCharactersInStringAfterTransformationsII main 
				= new TotalCharactersInStringAfterTransformationsII();
		TotalCharactersInStringAfterTransformationsII.BruteForceSolution solution 
				= main.new BruteForceSolution();
		int result = solution.lengthAfterTransformations("azbk", 1, List.of(
				2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2));
		assertEquals(8, result);
	}
}
