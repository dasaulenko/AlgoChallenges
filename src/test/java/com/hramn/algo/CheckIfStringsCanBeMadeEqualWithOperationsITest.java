package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIfStringsCanBeMadeEqualWithOperationsITest {
	@Test
	@DisplayName("s1 = \"abcd\", s2 = \"cdab\" -> true")
	void testSolutionCanBeEqual1() {
		CheckIfStringsCanBeMadeEqualWithOperationsI task 
				= new CheckIfStringsCanBeMadeEqualWithOperationsI();
		CheckIfStringsCanBeMadeEqualWithOperationsI.Solution solution 
				= task.new Solution();
		boolean result = solution.canBeEqual("abcd", "cdab");
		assert result;
	}

	@Test
	@DisplayName("s1 = \"abcd\", s2 = \"dacb\" -> false")
	void testSolutionCanBeEqual2() {
		CheckIfStringsCanBeMadeEqualWithOperationsI task 
				= new CheckIfStringsCanBeMadeEqualWithOperationsI();
		CheckIfStringsCanBeMadeEqualWithOperationsI.Solution solution 
				= task.new Solution();
		boolean result = solution.canBeEqual("abcd", "dacb");
		assert !result;
	}
}
