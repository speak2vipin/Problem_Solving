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
    int pathLength = 0;
    
    int longestZigZag(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return 0;
        } 
        maxLen(root, true, 0);
        maxLen(root, false, 0);
        
        return pathLength;
    }
               
    void maxLen(TreeNode root, boolean goLeft, int step) {
        
        if(root==null) {
            return ;
        }
        pathLength = Math.max(pathLength, step);
        
        if(goLeft) {
            maxLen(root.left, !goLeft, step+1);  
            maxLen(root.right, goLeft, 1); 
        } else {
        	maxLen(root.right, !goLeft, step+1);  
            maxLen(root.left, goLeft, 1);  
        }
    }
}