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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }
    
    int depth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left = 0;
        if(root.left!=null) {
            left = 1 + depth(root.left);
        }
        int right = 0;
        if(root.right!=null) {
            right = 1 + depth(root.right);
        }
        diameter = Math.max(diameter, left+right);
        return Math.max(left, right);
    }
}