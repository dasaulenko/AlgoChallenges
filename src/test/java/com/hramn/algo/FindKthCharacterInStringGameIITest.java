package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindKthCharacterInStringGameIITest {
	@Test
	@DisplayName("k = 5, operations = [0,0,0] -> 'a'")
	void testSolutionKthCharacter1() {
		FindKthCharacterInStringGameII task = new FindKthCharacterInStringGameII();
		FindKthCharacterInStringGameII.Solution solution = task.new Solution();
		char result = solution.kthCharacter(5, new int[] {0,0,0});
		assertEquals('a', result);
	}

	@Test
	@DisplayName("k = 10, operations = [0,1,0,1] -> 'b'")
	void testSolutionKthCharacter2() {
		FindKthCharacterInStringGameII task = new FindKthCharacterInStringGameII();
		FindKthCharacterInStringGameII.Solution solution = task.new Solution();
		char result = solution.kthCharacter(10, new int[] {0,1,0,1});
		assertEquals('b', result);
	}

	@Test
	@DisplayName("k = 5, operations = [0,0,0] -> 'a'")
	void testSolution2KthCharacter1() {
		FindKthCharacterInStringGameII task = new FindKthCharacterInStringGameII();
		FindKthCharacterInStringGameII.Solution2 solution = task.new Solution2();
		char result = solution.kthCharacter(5, new int[] {0,0,0});
		assertEquals('a', result);
	}

	@Test
	@DisplayName("k = 10, operations = [0,1,0,1] -> 'b'")
	void testSolution2KthCharacter2() {
		FindKthCharacterInStringGameII task = new FindKthCharacterInStringGameII();
		FindKthCharacterInStringGameII.Solution2 solution = task.new Solution2();
		char result = solution.kthCharacter(10, new int[] {0,1,0,1});
		assertEquals('b', result);
	}
}
