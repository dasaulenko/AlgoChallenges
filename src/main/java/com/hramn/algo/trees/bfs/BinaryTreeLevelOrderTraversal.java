package com.hramn.algo.trees.bfs;

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

	// use ArrayList of ArrayLists
	// use bfs
	// use recursion

	static class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();	
	        if (root == null) {
			    return result;
	        }
	        levelOrder(Arrays.asList(root), result);
	        return result;
	    }

	    private void levelOrder(List<TreeNode> nodes, List<List<Integer>> result) {
	        List<TreeNode> nextLevelNodes = new ArrayList<>();
	        List<Integer> r = new ArrayList<>();
	        for (TreeNode node : nodes) {
		        if (node.left != null) {
		            nextLevelNodes.add(node.left);
	            }
	            if (node.right != null) {
		            nextLevelNodes.add(node.right);
	            }
	            r.add(node.val);
	        }
	        result.add(r);
	        if (nextLevelNodes.size() > 0) {
		        levelOrder(nextLevelNodes, result);
	        }        
	    }
	}
}
