package com.hramn.algo.trees.dfs;
/**
 * 112. Path Sum
 * Given the root of a binary tree and an integer targetSum, return true if the 
 * tree has a root-to-leaf path such that adding up all the values along the 
 * path equals targetSum.
 * 
 * A leaf is a node with no children.
 * 
 * Example 1:
 *         5
 *      /     \
 *     4       8
 *    /       / \
 *   11      13  4
 *  /  \          \
 * 7    2          1
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * 
 * Example 2:
 *   1
 *  / \
 * 2   3
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * 
 * Example 3:
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class PathSum {

	public static void main(String[] args) {
		TreeNode n31 = new TreeNode(7);
		TreeNode n32 = new TreeNode(2);
		TreeNode n33 = new TreeNode(1);
		TreeNode n21 = new TreeNode(11, n31, n32);
		TreeNode n22 = new TreeNode(13);
		TreeNode n23 = new TreeNode(4, null, n33);
		TreeNode n11 = new TreeNode(4, n21, null);
		TreeNode n12 = new TreeNode(8, n22, n23);
		TreeNode n0 = new TreeNode(5, n11, n12);
		Solution solution = new Solution();
		boolean result = solution.hasPathSum(n0, 22);
		System.out.println(result);
		assert result == true;
	}
	
	// recursion: sum + node value, call method for left child, call method for 
	// right child, return true if node doesn’t have any children and 
	// sum == targetSum or if previous return value was true

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
	
	static class Solution {
		public boolean hasPathSum(TreeNode root, int targetSum) {
			if (root == null) {
				return false;
			}
			return hasPathSum(root, 0, targetSum);
		}

		private boolean hasPathSum(TreeNode node, int currentSum, int targetSum) {
			boolean result = false;
			currentSum += node.val;
			if (node.left == null && node.right == null) {
				if (currentSum == targetSum) {
					result = true;
				}
			} else {
				if (node.left != null) {
					result = hasPathSum(node.left, currentSum, targetSum);
				}
				if (node.right != null && !result) {
					result = hasPathSum(node.right, currentSum, targetSum);
				}
			}
			return result;
		}
	}
}