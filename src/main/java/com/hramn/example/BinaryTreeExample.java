package com.hramn.example;

public class BinaryTreeExample {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode (int val) {
			this.val = val;
		}
	}

	public static class BinaryTree {

		/**
		 * Build binary tree
		 * 
		 * <p>Complexity:
		 * <pre>
		 * Time: O(n)
		 * Space: O(log n)
		 * </pre>
		 * @param nums 
		 * @return the root of binary tree
		 */
		public TreeNode buildTree(int[] nums) {
			return build(nums, 0);
		}

		private TreeNode build(int[] nums, int i) {
			if (i >= nums.length) return null;
			TreeNode node = new TreeNode(nums[i]);
			node.left = build(nums, 2 * i + 1);
			node.right = build(nums, 2 * i + 2);
			return node;
		}
	}

	public static class BinarySearchTree {

		/**
		 * Bild binary search tree
		 * <p>Complexity:
		 * <pre>
		 * Time: O(n log n)
		 * Space: O(n)
		 * </pre>
		 * @param nums
		 * @return the root of binary search tree
		 */
		public TreeNode buildBST(int[] nums) {
			TreeNode root = null;

			for (int num : nums) {
				root = insert(root, num);
			}

			return root;
		}

		private TreeNode insert(TreeNode node, int val) {
			if (node == null) {
				return new TreeNode(val);
			}

			if (val < node.val) {
				node.left = insert(node.left, val);
			} else if (val > node.val) {
				node.right = insert(node.right, val);
			}

			return node;
		}
	}

	public static class BalancedBinarySearchTree {
		/**
		 * Build balanced binary search tree
		 * 
		 * <p><strong>Requariments:</strong>
		 * <ul>
		 * <li>input array must be sorted</li>
		 * </ul>
		 * 
		 * <p>Complexity:
		 * <pre>
		 * Time: O(n)
		 * Space: O(log n)
		 * </pre>
		 * @param nums presorted array
		 * @return the root of balanced binary search tree
		 */
		public TreeNode sortedArrayToBST(int[] nums) {
			return build(nums, 0, nums.length - 1);
		}

		private TreeNode build(int[] nums, int left, int right) {
			if (left > right) {
				return null;
			}

			int mid = left + (right - left) / 2;

			TreeNode node = new TreeNode(nums[mid]);

			node.left = build(nums, left, mid - 1);
			node.right = build(nums, mid + 1, right);

			return node;
		}
	}
}
