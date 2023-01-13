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
        helper(root);
        return diameter;
    }
    
    int helper(TreeNode root) {
        if(root.left==null && root.right==null ) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if(root.left!=null) {
            left =  1+helper(root.left);
        }
        if(root.right!=null) {
            right = 1+helper(root.right);
        }
        
        diameter = Math.max(diameter,left+right);
        return Math.max(left, right);
    }
}