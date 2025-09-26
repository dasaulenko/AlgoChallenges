package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindKthCharacterInStringGameITest {
	@Test
	@DisplayName("k = 5 -> 'b'")
	void testSolutionKthCharacter1() {
		FindKthCharacterInStringGameI task = new FindKthCharacterInStringGameI();
		FindKthCharacterInStringGameI.Solution solution = task.new Solution();
		char result = solution.kthCharacter(5);
		assertEquals('b', result);
	}

	@Test
	@DisplayName("k = 10 -> 'c'")
	void testSolutionKthCharacter2() {
		FindKthCharacterInStringGameI task = new FindKthCharacterInStringGameI();
		FindKthCharacterInStringGameI.Solution solution = task.new Solution();
		char result = solution.kthCharacter(10);
		assertEquals('c', result);
	}

	@Test
	@DisplayName("k = 5 -> 'b'")
	void testBestSolutionKthCharacter1() {
		FindKthCharacterInStringGameI task = new FindKthCharacterInStringGameI();
		FindKthCharacterInStringGameI.BestSolution solution = task.new BestSolution();
		char result = solution.kthCharacter(5);
		assertEquals('b', result);
	}

	@Test
	@DisplayName("k = 10 -> 'c'")
	void testBestSolutionKthCharacter2() {
		FindKthCharacterInStringGameI task = new FindKthCharacterInStringGameI();
		FindKthCharacterInStringGameI.BestSolution solution = task.new BestSolution();
		char result = solution.kthCharacter(10);
		assertEquals('c', result);
	}
}
