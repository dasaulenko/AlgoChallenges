package com.hramn.algo.trees.bst;

/**
 * 98. Validate Binary Search Tree
 * 
 * Given the root of a binary tree, determine if it is a valid binary search 
 * tree (BST).
 * 
 * A valid BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the 
 *   node's key.
 * - The right subtree of a node contains only nodes with keys greater than the 
 *   node's key.
 * - Both the left and right subtrees must also be binary search trees.
 * 
 *  Example 1:
 *   2
 *  / \
 * 1   3
 * Input: root = [2,1,3]
 * Output: true
 * 
 * Example 2:
 *   5
 *  / \
 * 1   4
 *    / \
 *   3   6
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10**4].
 * -2**31 <= Node.val <= 2**31 - 1
 */
public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		TreeNode n21 = new TreeNode(3);
		TreeNode n22 = new TreeNode(6);
		TreeNode n11 = new TreeNode(1);
		TreeNode n12 = new TreeNode(4, n21, n22);
		TreeNode n0 = new TreeNode(5, n11, n12);
		Solution solution = new Solution();
		boolean result = solution.isValidBST(n0);
		System.out.println(result);
		assert result == false;
		n21 = new TreeNode(6);
		n22 = new TreeNode(8);
		n11 = new TreeNode(1);
		n12 = new TreeNode(7, n21, n22);
		n0 = new TreeNode(5, n11, n12);
		result = solution.isValidBST(n0);
		System.out.println(result);
		assert result == true;
	}
	
	//  n0
	// /         \
	// n1l1       n1r1
	// /  \       /   \
	// n2l1 n2r1 n2l2 n2r2
	// 1: n0 - no check
	// 2: n1l1 < n0 // left
	// 3: n2l1 < n1l1 // left left
	// 4: n0 > n2r1 > n1l1 // left right
	// 5: n1r1 < n0 // right
	// 6: n0 < n2l2 < n1r1 // right left
	// 7: n2r2 > n1r1 // right right
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
	
		public boolean isValidBST(TreeNode root) {
			return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		private boolean isValidBST(TreeNode node, int min, int max) {
			if (node == null) {
				return true;
			}
			if (node.val <= min || node.val >= max) {
				return false;
			}
			return isValidBST(node.left, min, node.val) 
					&& isValidBST(node.right, node.val, max);
		}
	}


//1 000 000
//100 000 10 000 000
//10 000 000
//1 000

// 1: val = 5, min = inf, max = inf
// 2: val = 1, min = inf, max = 5
// 3: val = 3, min = 5, max = inf

}
