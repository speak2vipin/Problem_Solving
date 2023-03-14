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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, ""+root.val);
        return sum;
    }
    void helper(TreeNode root, String s) {
        if(root.left==null && root.right==null) {
        	sum += Integer.parseInt(s.toString());
            return;
        }
        if(root.left!=null)
        	helper(root.left, s+root.left.val);
        if(root.right!=null)
        	helper(root.right, s+root.right.val);     
    }
}