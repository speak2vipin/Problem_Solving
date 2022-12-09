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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) {
            return 0;
        }
        // 1 less than min value
        // 5001 greater than max value
        return helper(root, 1, 5001); 
    }
    
    public int helper(TreeNode root, int currMax, int currMin) {
        if(root==null) {
            return currMax-currMin;
        }
        
        currMax = Math.max(root.val, currMax);
        currMin = Math.min(root.val, currMin);
        int left = helper(root.left, currMax, currMin);
        int right = helper(root.right, currMax, currMin);
        return Math.max(left, right);
    }
}