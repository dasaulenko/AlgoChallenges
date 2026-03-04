package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindAllNumbersDisappearedInArrayTest {
	private final int[] nums1 = new int[]{4,3,2,7,8,2,3,1};
	private final List<Integer> expected1 = List.of(5,6);
	private final int[] nums2 = new int[]{1,1};
	private final List<Integer> expected2 = List.of(2);

	@Test
	@DisplayName("[4,3,2,7,8,2,3,1] -> [5,6]")
	void testFindDisappearedNumbers1() {
		FindAllNumbersDisappearedInArray task = new FindAllNumbersDisappearedInArray();
		FindAllNumbersDisappearedInArray.Solution solution = task.new Solution();
		List<Integer> result = solution.findDisappearedNumbers(nums1);
		assertNotNull(result);
		assertEquals(expected1, result);
	}

	@Test
	@DisplayName("[1,1] -> [2]")
	void testFindDisappearedNumbers2() {
		FindAllNumbersDisappearedInArray task = new FindAllNumbersDisappearedInArray();
		FindAllNumbersDisappearedInArray.Solution solution = task.new Solution();
		List<Integer> result = solution.findDisappearedNumbers(nums2);
		assertNotNull(result);
		assertEquals(expected2, result);
	}

	@Test
	@DisplayName("[4,3,2,7,8,2,3,1] -> [5,6]")
	void testBruteforceSolutionFindDisappearedNumbers1() {
		FindAllNumbersDisappearedInArray task = new FindAllNumbersDisappearedInArray();
		FindAllNumbersDisappearedInArray.BruteforceSolution solution = task.new BruteforceSolution();
		List<Integer> result = solution.findDisappearedNumbers(nums1);
		assertNotNull(result);
		assertEquals(expected1, result);
	}

	@Test
	@DisplayName("[1,1] -> [2]")
	void testBruteforceSolutionFindDisappearedNumbers2() {
		FindAllNumbersDisappearedInArray task = new FindAllNumbersDisappearedInArray();
		FindAllNumbersDisappearedInArray.BruteforceSolution solution = task.new BruteforceSolution();
		List<Integer> result = solution.findDisappearedNumbers(nums2);
		assertNotNull(result);
		assertEquals(expected2, result);
	}
}
