package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LongestPalindromeByConcatenatingTwoLetterWordsTest {
	@Test
	@DisplayName("words = [\"lc\",\"cl\",\"gg\"] -> 6")
	void testGridSolutionLongestPalindrome1() {
		LongestPalindromeByConcatenatingTwoLetterWords main 
				= new LongestPalindromeByConcatenatingTwoLetterWords();
		LongestPalindromeByConcatenatingTwoLetterWords.GridSolution solution 
				= main.new GridSolution();
		int result = solution.longestPalindrome(new String[] {"lc","cl","gg"});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("words = [\"ab\",\"ty\",\"yt\",\"lc\",\"cl\",\"ab\"] -> 8")
	void testGridSolutionLongestPalindrome2() {
		LongestPalindromeByConcatenatingTwoLetterWords main 
				= new LongestPalindromeByConcatenatingTwoLetterWords();
		LongestPalindromeByConcatenatingTwoLetterWords.GridSolution solution 
				= main.new GridSolution();
		int result = solution.longestPalindrome(
				new String[] {"ab","ty","yt","lc","cl","ab"});
		assertEquals(8, result);
	}

	@Test
	@DisplayName("words = [\"cc\",\"ll\",\"xx\"] -> 2")
	void testGridSolutionLongestPalindrome3() {
		LongestPalindromeByConcatenatingTwoLetterWords main 
				= new LongestPalindromeByConcatenatingTwoLetterWords();
		LongestPalindromeByConcatenatingTwoLetterWords.GridSolution solution 
				= main.new GridSolution();
		int result = solution.longestPalindrome(new String[] {"cc","ll","xx"});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("words = [\"lc\",\"cl\",\"gg\"] -> 6")
	void testHashMapSolutionLongestPalindrome1() {
		LongestPalindromeByConcatenatingTwoLetterWords main 
				= new LongestPalindromeByConcatenatingTwoLetterWords();
		LongestPalindromeByConcatenatingTwoLetterWords.HashMapSolution solution 
				= main.new HashMapSolution();
		int result = solution.longestPalindrome(new String[] {"lc","cl","gg"});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("words = [\"ab\",\"ty\",\"yt\",\"lc\",\"cl\",\"ab\"] -> 8")
	void testHashMapSolutionLongestPalindrome2() {
		LongestPalindromeByConcatenatingTwoLetterWords main 
				= new LongestPalindromeByConcatenatingTwoLetterWords();
		LongestPalindromeByConcatenatingTwoLetterWords.HashMapSolution solution 
				= main.new HashMapSolution();
		int result = solution.longestPalindrome(
				new String[] {"ab","ty","yt","lc","cl","ab"});
		assertEquals(8, result);
	}

	@Test
	@DisplayName("words = [\"cc\",\"ll\",\"xx\"] -> 2")
	void testHashMapSolutionLongestPalindrome3() {
		LongestPalindromeByConcatenatingTwoLetterWords main 
				= new LongestPalindromeByConcatenatingTwoLetterWords();
		LongestPalindromeByConcatenatingTwoLetterWords.HashMapSolution solution 
				= main.new HashMapSolution();
		int result = solution.longestPalindrome(new String[] {"cc","ll","xx"});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("words = [\"lc\",\"cl\",\"gg\"] -> 6")
	void testBruteforceSolutionLongestPalindrome1() {
		LongestPalindromeByConcatenatingTwoLetterWords main 
				= new LongestPalindromeByConcatenatingTwoLetterWords();
		LongestPalindromeByConcatenatingTwoLetterWords.BruteforceSolution solution 
				= main.new BruteforceSolution();
		int result = solution.longestPalindrome(new String[] {"lc","cl","gg"});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("words = [\"ab\",\"ty\",\"yt\",\"lc\",\"cl\",\"ab\"] -> 8")
	void testBruteforceSolutionLongestPalindrome2() {
		LongestPalindromeByConcatenatingTwoLetterWords main 
				= new LongestPalindromeByConcatenatingTwoLetterWords();
		LongestPalindromeByConcatenatingTwoLetterWords.BruteforceSolution solution 
				= main.new BruteforceSolution();
		int result = solution.longestPalindrome(
				new String[] {"ab","ty","yt","lc","cl","ab"});
		assertEquals(8, result);
	}

	@Test
	@DisplayName("words = [\"cc\",\"ll\",\"xx\"] -> 2")
	void testBruteforceSolutionLongestPalindrome3() {
		LongestPalindromeByConcatenatingTwoLetterWords main 
				= new LongestPalindromeByConcatenatingTwoLetterWords();
		LongestPalindromeByConcatenatingTwoLetterWords.BruteforceSolution solution 
				= main.new BruteforceSolution();
		int result = solution.longestPalindrome(new String[] {"cc","ll","xx"});
		assertEquals(2, result);
	}
}
