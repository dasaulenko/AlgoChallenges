package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteDuplicateFoldersInSystemTest {
	@Test
	@DisplayName("paths = [[\"a\"],[\"c\"],[\"d\"],[\"a\",\"b\"],[\"c\",\"b\"],[\"d\",\"a\"]] -> [[\"d\"],[\"d\",\"a\"]]")
	void testSolutionDeleteDuplicateFolder1() {
		DeleteDuplicateFoldersInSystem task = new DeleteDuplicateFoldersInSystem();
		DeleteDuplicateFoldersInSystem.Solution solution = task.new Solution();
		List<List<String>> result = solution.deleteDuplicateFolder(List.of(
			List.of("a"),
			List.of("c"),
			List.of("d"),
			List.of("a","b"),
			List.of("c","b"),
			List.of("d","a")));
		assertNotNull(result);
		assertTrue(List.of(List.of("d"),List.of("d","a")).equals(result));
	}

	@Test
	@DisplayName("paths = [[\"a\"],[\"c\"],[\"a\",\"b\"],[\"c\",\"b\"],[\"a\",\"b\",\"x\"],[\"a\",\"b\",\"x\",\"y\"],[\"w\"],[\"w\",\"y\"]] -> [[\"c\"],[\"c\",\"b\"],[\"a\"],[\"a\",\"b\"]]")
	void testSolutionDeleteDuplicateFolder2() {
		DeleteDuplicateFoldersInSystem task = new DeleteDuplicateFoldersInSystem();
		DeleteDuplicateFoldersInSystem.Solution solution = task.new Solution();
		List<List<String>> result = solution.deleteDuplicateFolder(List.of(
			List.of("a"),
			List.of("c"),
			List.of("a","b"),
			List.of("c","b"),
			List.of("a","b","x"),
			List.of("a","b","x","y"),
			List.of("w"),
			List.of("w","y")));
		assertNotNull(result);
		assertTrue(List.of(
			List.of("a"),
			List.of("c"),
			List.of("a","b"),
			List.of("c","b")).equals(result));
	}

	@Test
	@DisplayName("paths = paths = [[\"a\",\"b\"],[\"c\",\"d\"],[\"c\"],[\"a\"]] -> [[\"c\"],[\"c\",\"d\"],[\"a\"],[\"a\",\"b\"]]")
	void testSolutionDeleteDuplicateFolder3() {
		DeleteDuplicateFoldersInSystem task = new DeleteDuplicateFoldersInSystem();
		DeleteDuplicateFoldersInSystem.Solution solution = task.new Solution();
		List<List<String>> result = solution.deleteDuplicateFolder(List.of(
			List.of("a","b"),
			List.of("c","d"),
			List.of("c"),
			List.of("a")));
						System.out.println(result);
		assertNotNull(result);
		assertTrue(List.of(
			List.of("a","b"),	
			List.of("c","d"),
			List.of("c"),
			List.of("a")).equals(result));
	}
}
