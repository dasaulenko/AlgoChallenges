package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RemoveSubFoldersFromFilesystemTest {
	@Test
	@DisplayName("folder = [\"/a\",\"/a/b\",\"/c/d\",\"/c/d/e\",\"/c/f\"] -> [\"/a\",\"/c/d\",\"/c/f\"]")
	void testSolutionRemoveSubfolders1() {
		RemoveSubFoldersFromFilesystem task = new RemoveSubFoldersFromFilesystem();
		RemoveSubFoldersFromFilesystem.Solution solution = task.new Solution();
		List<String> result = solution.removeSubfolders(new String[] {"/a","/a/b","/c/d","/c/d/e","/c/f"});
		assertTrue(result.equals(List.of("/a","/c/d","/c/f")));
	}

	@Test
	@DisplayName("folder = [\"/a\",\"/a/b/c\",\"/a/b/d\"] -> [\"/a\"]")
	void testSolutionRemoveSubfolders2() {
		RemoveSubFoldersFromFilesystem task = new RemoveSubFoldersFromFilesystem();
		RemoveSubFoldersFromFilesystem.Solution solution = task.new Solution();
		List<String> result = solution.removeSubfolders(new String[] {"/a","/a/b/c","/a/b/d"});
		assertTrue(result.equals(List.of("/a")));
	}

	@Test
	@DisplayName("folder = [\"/a/b/c\",\"/a/b/ca\",\"/a/b/d\"] -> [\"/a/b/c\",\"/a/b/ca\",\"/a/b/d\"]")
	void testSolutionRemoveSubfolders3() {
		RemoveSubFoldersFromFilesystem task = new RemoveSubFoldersFromFilesystem();
		RemoveSubFoldersFromFilesystem.Solution solution = task.new Solution();
		List<String> result = solution.removeSubfolders(new String[] {"/a/b/c","/a/b/ca","/a/b/d"});
		assertTrue(result.equals(List.of("/a/b/c","/a/b/ca","/a/b/d")));
	}
}
