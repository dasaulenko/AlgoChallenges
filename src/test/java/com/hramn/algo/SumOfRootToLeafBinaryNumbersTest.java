package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumOfRootToLeafBinaryNumbersTest {

	@Test
	@DisplayName("root = [1,0,1,0,1,0,1] -> 22")
	void testSolutionSumRootToLeaf1() {
		SumOfRootToLeafBinaryNumbers task = new SumOfRootToLeafBinaryNumbers();
		SumOfRootToLeafBinaryNumbers.Solution solution = task.new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		int result = solution.sumRootToLeaf(root);
		assert result == 22;
	}

	@Test
	@DisplayName("root = [0] -> 0")
	void testSolutionSumRootToLeaf2() {
		SumOfRootToLeafBinaryNumbers task = new SumOfRootToLeafBinaryNumbers();
		SumOfRootToLeafBinaryNumbers.Solution solution = task.new Solution();
		TreeNode root = new TreeNode(0);
		int result = solution.sumRootToLeaf(root);
		assert result == 0;
	}
}