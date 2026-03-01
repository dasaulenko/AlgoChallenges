package com.hramn.algo.trees.dfs;

/**
 * 111. Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the 
 * root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example 1:
 *   3
 *  / \ 
 * 9  20
 *   /  \
 *  15   7
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * 
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10**5].
 * -1000 <= Node.val <= 1000
 */
public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode n21 = new TreeNode(15);
		TreeNode n22 = new TreeNode(7);
		TreeNode n11 = new TreeNode(9);
		TreeNode n12 = new TreeNode(20, n21, n22);
		TreeNode n0 = new TreeNode(3, n11, n12);
		Solution solution = new Solution();
		int result = solution.minDepth(n0);
		System.out.println(result);
		assert result == 2;
	}
	
//   1
//  / \
// 2   3
//    / \
//   4   5
// answer = 2
// if null then 0
// we can resolve it with dfs and bfs

/**
* Definition for a binary tree node.
*/
	static class TreeNode {
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
		public int minDepth(TreeNode root) {  
			return dfs(root);
		}
		
		private int dfs(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int left = dfs(node.left);
			int right = dfs(node.right);
			if (left == 0) {
				return right + 1;
			} else if (right == 0) {
				return left + 1;
			}
			return Math.min(left, right) + 1;
		}
	}
}
