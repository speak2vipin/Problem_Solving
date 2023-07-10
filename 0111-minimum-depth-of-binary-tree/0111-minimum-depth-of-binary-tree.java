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
    //int height = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        return helper(root);
    }
    
    int helper(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            return 1;
        }
        int h1 = Integer.MAX_VALUE;
        if(root.left!=null) {
            h1 = 1+helper(root.left);
        }
        
        int h2 = Integer.MAX_VALUE;
        if(root.right!=null) {
            h2 = 1+helper(root.right);
        }
        
        return Math.min(h1,h2);
    }
}