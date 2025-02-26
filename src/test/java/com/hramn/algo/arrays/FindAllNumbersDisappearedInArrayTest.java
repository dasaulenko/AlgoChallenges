package com.hramn.algo.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindAllNumbersDisappearedInArrayTest {

	@Test
	@DisplayName("[4,3,2,7,8,2,3,1] -> [5,6]")
	void testFindDisappearedNumbers1() {
		FindAllNumbersDisappearedInArray findAllNumbersDisappearedInArray =
				new FindAllNumbersDisappearedInArray();
		FindAllNumbersDisappearedInArray.Solution solution = 
				findAllNumbersDisappearedInArray.new Solution();
		List<Integer> result = 
				solution.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
		assertNotNull(result);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), 5);
		assertEquals(result.get(1), 6);
	}

	@Test
	@DisplayName("[1,1] -> [2]")
	void testFindDisappearedNumbers2() {
		FindAllNumbersDisappearedInArray findAllNumbersDisappearedInArray =
				new FindAllNumbersDisappearedInArray();
		FindAllNumbersDisappearedInArray.Solution solution = 
				findAllNumbersDisappearedInArray.new Solution();
		List<Integer> result = 
				solution.findDisappearedNumbers(new int[]{1,1});
		assertNotNull(result);
		assertEquals(result.size(), 1);
		assertEquals(result.get(0), 2);
	}
}
