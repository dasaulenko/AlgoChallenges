package com.hramn.algo.trees.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * 
 * Given the root of a binary tree, return the level order traversal of its 
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * Example 1:
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *  Input: root = [3,9,20,null,null,15,7]
 *  Output: [[3],[9,20],[15,7]]
 *  
 *  Example 2:
 *  Input: root = [1]
 *  Output: [[1]]
 *  
 *  Example 3:
 *  Input: root = []
 *  Output: []
 *  
 *  Constraints:
 *  The number of nodes in the tree is in the range [0, 2000].
 *  -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode n21 = new TreeNode(15);
		TreeNode n22 = new TreeNode(7);
		TreeNode n11 = new TreeNode(9);
		TreeNode n12 = new TreeNode(20, n21, n22);
		TreeNode n0 = new TreeNode(3, n11, n12);
		Solution solution = new Solution();
		List<List<Integer>> result = solution.levelOrder(n0);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
	
	/**
	 * Definition for a binary tree node.
	 */
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// use dfs
	// use recursion

	static class Solution {
		
		private List<List<Integer>> result = new ArrayList<>();
		
	    public List<List<Integer>> levelOrder(TreeNode root) {	
	        if (root == null) {
			    return result;
	        }
	        dfs(root, 0);
	        return result;
	    }

	    private void dfs(TreeNode node, int level) {
	    	while (level >= result.size()) {
	    		result.add(new ArrayList<>());
	    	}
	    	result.get(level).add(node.val);
	    	if (node.left != null) {
	    		dfs(node.left, level + 1);
	    	}
	    	if (node.right != null) {
	    		dfs(node.right, level + 1);
	    	}
	    }
	}
}
