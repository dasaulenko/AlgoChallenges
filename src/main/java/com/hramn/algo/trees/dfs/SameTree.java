package com.hramn.algo.trees.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 100. Same Tree
 * 
 * Given the roots of two binary trees p and q, write a function to check if 
 * they are the same or not.
 * 
 * Two binary trees are considered the same if they are structurally identical, 
 * and the nodes have the same value.
 * 
 * Example 1:
 *   1     1
 *  / \   / \
 * 2   3 2   3
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * 
 * Example 2:
 *   1 1
 *  /   \
 * 2     2
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * 
 * Example 3:
 *   1     1
 *  / \   / \
 * 2   1 1   2
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * 
 * Constraints:
 * The number of nodes in both trees is in the range [0, 100].
 * -10**4 <= Node.val <= 10**4
 */
public class SameTree {

	public static void main(String[] args) {
		TreeNode root1 = createTree(new Integer[]{1, 2, 3, null, null, 4, 5});
		TreeNode root2 = createTree(new Integer[]{1, 2, 3, null, null, 5, 4});
		Solution solution = new Solution();
		boolean result = solution.isSameTree(root1, root2);
		System.out.println(result);
		assert result == false;
	}
	
	private static TreeNode createTree(Integer[] arr) {
		TreeNode root = null, parent = null;
		List<TreeNode> queue = new LinkedList<>();
		int counter = -1;
		for (int i = 0; i < arr.length; i++) {
			counter++;
			TreeNode n = null;
			if (arr[i] != null) {
				 n = new TreeNode(arr[i]); 
				if (counter == 1) {
					parent.left = n; 
				} else if (counter == 2) {
					parent.right = n;
				} else if (counter == 0) {
					root = n;
					parent = n;
				}
			}
			queue.add(n);
			if (counter == 2) {
				queue.removeFirst();
				counter = 0;
				parent = queue.getFirst();
			} 
		}
		return root;
	}
	
//   1       1
//  / \     / \
// 2   3   2   3
//    / \     / \
//   4   5   5   4
// if root1 == root2 == null then true
// we can resolve it with dfs because it’s important to check the structure

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
		public boolean isSameTree(TreeNode p, TreeNode q) {
			return dfs(p, q);
		}

		private boolean dfs(TreeNode n1, TreeNode n2) {
			if (n1 == null && n2 == null) {
				return true;
			}
			if (n1 == null || n2 == null || n1.val != n2.val) {
				return false;
			}
			return dfs(n1.left, n2.left) && dfs(n1.right, n2.right);
		}
	}
}
