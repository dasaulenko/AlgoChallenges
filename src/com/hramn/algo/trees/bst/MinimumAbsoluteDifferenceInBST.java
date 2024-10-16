package com.hramn.algo.trees.bst;

import com.hramn.algo.TreeNode;

/**
 * 530. Minimum Absolute Difference in BST
 * 
 * Given the root of a Binary Search Tree (BST), return the minimum absolute 
 * difference between the values of any two different nodes in the tree.
 * 
 * Example 1:
 *     4
 *    / \
 *   2   6
 *  / \
 * 1   3
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * 
 * Example 2:
 *   1
 *  / \
 * 0  48
 *   /  \
 * 12    49
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [2, 10**4].
 * 0 <= Node.val <= 10**5
 */
public class MinimumAbsoluteDifferenceInBST {

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new Integer[]{4,2,6,1,3});
		Solution solution = new Solution();
		int result = solution.getMinimumDifference(root);
		System.out.println(result);
		assert result == 1;
		Solution_best solution_b = new Solution_best();
		int result_b = solution_b.getMinimumDifference(root);
		System.out.println(result_b);
		assert result_b == 1;
	}

	static class Solution {
		
		class Result {
			int min;
			int max;
			int dif;
			public Result() {
				min = Integer.MAX_VALUE;
				max = Integer.MIN_VALUE;
				dif = -1;
			}
		}
		
		public int getMinimumDifference(TreeNode root) {
			if (root == null || (root.left == null && root.right == null)) {
				return -1;
			}
			Result result = dfs (root);
			return result.dif;
		}
		
		private Result dfs (TreeNode n) {
			Result result = new Result();
			if (n.left != null) {
				Result leftRes = dfs (n.left);
				int dif = n.val - leftRes.max;
				if (leftRes.dif > 0) {
					dif = Math.min(leftRes.dif, dif);
				}
				result.dif = dif;
				result.min = leftRes.min;
			} else {
				result.min = n.val;
			}

			if (n.right != null) {
				Result rightRes = dfs (n.right);
				int dif = rightRes.min - n.val;
				if (rightRes.dif > 0) {
					dif = Math.min(rightRes.dif, dif);
				}
				if (result.dif > 0) {
					dif = Math.min(result.dif, dif);
				}
				result.dif = dif;
				result.max = rightRes.max;
			} else {
				result.max = n.val;
			}
			return result;
		}
	}
	
	static class Solution_best {
	    int result = Integer.MAX_VALUE;
	    Integer prev = null;
	    public int getMinimumDifference(TreeNode root) {
	        if(root == null) {
	            return result;
	        }

	        getMinimumDifference(root.left);

	        if(prev != null)
	        	result = Math.min(result, Math.abs(root.val - prev));

	        prev = root.val;

	        getMinimumDifference(root.right);

	        return result;
	    }
	}
}
