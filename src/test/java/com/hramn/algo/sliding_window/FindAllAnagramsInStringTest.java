package com.hramn.algo.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindAllAnagramsInStringTest {
	@Test
	@DisplayName("s = \"cbaebabacd\", p = \"abc\" -> [0,6]")
	void testSortingSolutionFindAnagrams1() {
		FindAllAnagramsInString findAllAnagramsInString = 
				new FindAllAnagramsInString();
		FindAllAnagramsInString.SortingSolution sortingSolution= 
				findAllAnagramsInString.new SortingSolution();
		List<Integer> result = 
				sortingSolution.findAnagrams("cbaebabacd", "abc");
		assertNotNull(result);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), 0);
		assertEquals(result.get(1), 6);
	}

	@Test
	@DisplayName("s = \"abab\", p = \"ab\" -> [0,1,2]")
	void testSortingSolutionFindAnagrams2() {
		FindAllAnagramsInString findAllAnagramsInString = 
				new FindAllAnagramsInString();
		FindAllAnagramsInString.SortingSolution sortingSolution= 
				findAllAnagramsInString.new SortingSolution();
		List<Integer> result = 
				sortingSolution.findAnagrams("abab", "ab");
		assertNotNull(result);
		assertEquals(result.size(), 3);
		assertEquals(result.get(0), 0);
		assertEquals(result.get(1), 1);
		assertEquals(result.get(2), 2);
	}

	@Test
	@DisplayName("s = \"cbaebabacd\", p = \"abc\" -> [0,6]")
	void testBruteforceSolutionFindAnagrams1() {
		FindAllAnagramsInString findAllAnagramsInString = 
				new FindAllAnagramsInString();
		FindAllAnagramsInString.BruteforceSolution bruteforceSolution= 
				findAllAnagramsInString.new BruteforceSolution();
		List<Integer> result = 
				bruteforceSolution.findAnagrams("cbaebabacd", "abc");
		assertNotNull(result);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), 0);
		assertEquals(result.get(1), 6);
	}

	@Test
	@DisplayName("s = \"abab\", p = \"ab\" -> [0,1,2]")
	void testBruteforceSolutionFindAnagrams2() {
		FindAllAnagramsInString findAllAnagramsInString = 
				new FindAllAnagramsInString();
		FindAllAnagramsInString.BruteforceSolution bruteforceSolution= 
				findAllAnagramsInString.new BruteforceSolution();
		List<Integer> result = 
				bruteforceSolution.findAnagrams("abab", "ab");
		assertNotNull(result);
		assertEquals(result.size(), 3);
		assertEquals(result.get(0), 0);
		assertEquals(result.get(1), 1);
		assertEquals(result.get(2), 2);
	}

	@Test
	@DisplayName("s = \"cbaebabacd\", p = \"abc\" -> [0,6]")
	void testSlidingWindowSolution1FindAnagrams1() {
		FindAllAnagramsInString findAllAnagramsInString = 
				new FindAllAnagramsInString();
		FindAllAnagramsInString.SlidingWindowSolution1 slidingWindowSolution1= 
				findAllAnagramsInString.new SlidingWindowSolution1();
		List<Integer> result = 
				slidingWindowSolution1.findAnagrams("cbaebabacd", "abc");
		assertNotNull(result);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), 0);
		assertEquals(result.get(1), 6);
	}

	@Test
	@DisplayName("s = \"abab\", p = \"ab\" -> [0,1,2]")
	void testSlidingWindowSolution1FindAnagrams2() {
		FindAllAnagramsInString findAllAnagramsInString = 
				new FindAllAnagramsInString();
		FindAllAnagramsInString.SlidingWindowSolution1 slidingWindowSolution1= 
				findAllAnagramsInString.new SlidingWindowSolution1();
		List<Integer> result = 
				slidingWindowSolution1.findAnagrams("abab", "ab");
		assertNotNull(result);
		assertEquals(result.size(), 3);
		assertEquals(result.get(0), 0);
		assertEquals(result.get(1), 1);
		assertEquals(result.get(2), 2);
	}

	@Test
	@DisplayName("s = \"cbaebabacd\", p = \"abc\" -> [0,6]")
	void testSlidingWindowSolution2FindAnagrams1() {
		FindAllAnagramsInString findAllAnagramsInString = 
				new FindAllAnagramsInString();
		FindAllAnagramsInString.SlidingWindowSolution2 slidingWindowSolution2= 
				findAllAnagramsInString.new SlidingWindowSolution2();
		List<Integer> result = 
				slidingWindowSolution2.findAnagrams("cbaebabacd", "abc");
		assertNotNull(result);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), 0);
		assertEquals(result.get(1), 6);
	}

	@Test
	@DisplayName("s = \"abab\", p = \"ab\" -> [0,1,2]")
	void testSlidingWindowSolution2FindAnagrams2() {
		FindAllAnagramsInString findAllAnagramsInString = 
				new FindAllAnagramsInString();
		FindAllAnagramsInString.SlidingWindowSolution2 slidingWindowSolution2 = 
				findAllAnagramsInString.new SlidingWindowSolution2();
		List<Integer> result = 
				slidingWindowSolution2.findAnagrams("abab", "ab");
		assertNotNull(result);
		assertEquals(result.size(), 3);
		assertEquals(result.get(0), 0);
		assertEquals(result.get(1), 1);
		assertEquals(result.get(2), 2);
	}
}
