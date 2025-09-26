package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompareVersionNumbersTest {
	@Test
	@DisplayName("version1 = \"1.2\", version2 = \"1.10\" -> -1")
	void testSolution2025092301CompareVersion1() {
		CompareVersionNumbers task = new CompareVersionNumbers();
		CompareVersionNumbers.Solution2025092301 solution = task.new Solution2025092301();
		int result = solution.compareVersion("1.2", "1.10");
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("version1 = \"1.01\", version2 = \"1.001\" -> 0")
	void testSolution2025092301CompareVersion2() {
		CompareVersionNumbers task = new CompareVersionNumbers();
		CompareVersionNumbers.Solution2025092301 solution = task.new Solution2025092301();
		int result = solution.compareVersion("1.01", "1.001");
		assertEquals(0, result);
	}

	@Test
	@DisplayName("version1 = \"1.0\", version2 = \"1.0.0.0\" -> 0")
	void testSolution2025092301CompareVersion3() {
		CompareVersionNumbers task = new CompareVersionNumbers();
		CompareVersionNumbers.Solution2025092301 solution = task.new Solution2025092301();
		int result = solution.compareVersion("1.0", "1.0.0.0");
		assertEquals(0, result);
	}

	@Test
	@DisplayName("version1 = \"1.2\", version2 = \"1.10\" -> -1")
	void testSolution2025092302CompareVersion1() {
		CompareVersionNumbers task = new CompareVersionNumbers();
		CompareVersionNumbers.Solution2025092302 solution = task.new Solution2025092302();
		int result = solution.compareVersion("1.2", "1.10");
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("version1 = \"1.01\", version2 = \"1.001\" -> 0")
	void testSolution2025092302CompareVersion2() {
		CompareVersionNumbers task = new CompareVersionNumbers();
		CompareVersionNumbers.Solution2025092302 solution = task.new Solution2025092302();
		int result = solution.compareVersion("1.01", "1.001");
		assertEquals(0, result);
	}

	@Test
	@DisplayName("version1 = \"1.0\", version2 = \"1.0.0.0\" -> 0")
	void testSolution2025092302CompareVersion3() {
		CompareVersionNumbers task = new CompareVersionNumbers();
		CompareVersionNumbers.Solution2025092302 solution = task.new Solution2025092302();
		int result = solution.compareVersion("1.0", "1.0.0.0");
		assertEquals(0, result);
	}
}
