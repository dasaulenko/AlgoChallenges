package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindResultantArrayAfterRemovingAnagramsTest {
	@Test
	@DisplayName("words = [\"abba\",\"baba\",\"bbaa\",\"cd\",\"cd\"] -> [\"abba\",\"cd\"]")
	void testSolutionRemoveAnagrams1() {
		FindResultantArrayAfterRemovingAnagrams task = new FindResultantArrayAfterRemovingAnagrams();
		FindResultantArrayAfterRemovingAnagrams.Solution solution = task.new Solution();
		List<String> result = solution.removeAnagrams(new String[] {"abba","baba","bbaa","cd","cd"});
		assertEquals(List.of("abba","cd"), result);
	}

	@Test
	@DisplayName("words = [\"a\",\"b\",\"c\",\"d\",\"e\"] -> [\"a\",\"b\",\"c\",\"d\",\"e\"]")
	void testSolutionRemoveAnagrams2() {
		FindResultantArrayAfterRemovingAnagrams task = new FindResultantArrayAfterRemovingAnagrams();
		FindResultantArrayAfterRemovingAnagrams.Solution solution = task.new Solution();
		List<String> result = solution.removeAnagrams(new String[] {"a","b","c","d","e"});
		assertEquals(List.of("a","b","c","d","e"), result);
	}
}
