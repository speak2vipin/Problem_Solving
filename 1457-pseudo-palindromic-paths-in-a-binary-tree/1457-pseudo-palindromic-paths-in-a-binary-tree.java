/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
	int ans = 0;
	// storing the number of palindrome
	int[] arr = new int[10];

	// for storing the occurence of each integer
	public int pseudoPalindromicPaths(TreeNode root) {

		helper(root);
		return ans;
	}

	private void helper(TreeNode node) {
		if (node == null)
			return;
		// when we will call the left or right child of leaf node or our node will be
		// empty

		arr[node.val]++;
		// we will increase the occurece of digit by one
		if (node.left == null && node.right == null) {
			{
				int count = 0;
				for (int i = 1; i <= 9; i++) {

					count += arr[i] % 2;
				}

				if (count == 1 || count == 0)
					ans++;

			}
        }

			helper(node.left);
			// calling left child of node
			helper(node.right);
			// caling right child of node
			arr[node.val]--;
			// removing the occurence of node, when we are going one step back
		
	}
}