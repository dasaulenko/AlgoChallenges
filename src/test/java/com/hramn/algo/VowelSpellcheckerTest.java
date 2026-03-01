package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VowelSpellcheckerTest {
	@Test
	@DisplayName("wordlist = [\"KiTe\",\"kite\",\"hare\",\"Hare\"], queries = [\"kite\",\"Kite\",\"KiTe\",\"Hare\",\"HARE\",\"Hear\",\"hear\",\"keti\",\"keet\",\"keto\"] -> [\"kite\",\"KiTe\",\"KiTe\",\"Hare\",\"hare\",\"\",\"\",\"KiTe\",\"\",\"KiTe\"]")
	void testSolutionSpellchecker1() {
		VowelSpellchecker task = new VowelSpellchecker();
		VowelSpellchecker.Solution solution = task.new Solution();
		String[] result = solution.spellchecker(
			new String[] {"KiTe","kite","hare","Hare"}, 
			new String[] {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"});
		assertNotNull(result);
		assertTrue(Arrays.equals(new String[] {"kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"}, result));
	}

	@Test
	@DisplayName("wordlist = [\"yellow\"], queries = [\"YellOw\"] -> [\"yellow\"]")
	void testSolutionSpellchecker2() {
		VowelSpellchecker task = new VowelSpellchecker();
		VowelSpellchecker.Solution solution = task.new Solution();
		String[] result = solution.spellchecker(
			new String[] {"yellow"}, 
			new String[] {"YellOw"});
		assertNotNull(result);
		assertTrue(Arrays.equals(new String[] {"yellow"}, result));
	}
}
