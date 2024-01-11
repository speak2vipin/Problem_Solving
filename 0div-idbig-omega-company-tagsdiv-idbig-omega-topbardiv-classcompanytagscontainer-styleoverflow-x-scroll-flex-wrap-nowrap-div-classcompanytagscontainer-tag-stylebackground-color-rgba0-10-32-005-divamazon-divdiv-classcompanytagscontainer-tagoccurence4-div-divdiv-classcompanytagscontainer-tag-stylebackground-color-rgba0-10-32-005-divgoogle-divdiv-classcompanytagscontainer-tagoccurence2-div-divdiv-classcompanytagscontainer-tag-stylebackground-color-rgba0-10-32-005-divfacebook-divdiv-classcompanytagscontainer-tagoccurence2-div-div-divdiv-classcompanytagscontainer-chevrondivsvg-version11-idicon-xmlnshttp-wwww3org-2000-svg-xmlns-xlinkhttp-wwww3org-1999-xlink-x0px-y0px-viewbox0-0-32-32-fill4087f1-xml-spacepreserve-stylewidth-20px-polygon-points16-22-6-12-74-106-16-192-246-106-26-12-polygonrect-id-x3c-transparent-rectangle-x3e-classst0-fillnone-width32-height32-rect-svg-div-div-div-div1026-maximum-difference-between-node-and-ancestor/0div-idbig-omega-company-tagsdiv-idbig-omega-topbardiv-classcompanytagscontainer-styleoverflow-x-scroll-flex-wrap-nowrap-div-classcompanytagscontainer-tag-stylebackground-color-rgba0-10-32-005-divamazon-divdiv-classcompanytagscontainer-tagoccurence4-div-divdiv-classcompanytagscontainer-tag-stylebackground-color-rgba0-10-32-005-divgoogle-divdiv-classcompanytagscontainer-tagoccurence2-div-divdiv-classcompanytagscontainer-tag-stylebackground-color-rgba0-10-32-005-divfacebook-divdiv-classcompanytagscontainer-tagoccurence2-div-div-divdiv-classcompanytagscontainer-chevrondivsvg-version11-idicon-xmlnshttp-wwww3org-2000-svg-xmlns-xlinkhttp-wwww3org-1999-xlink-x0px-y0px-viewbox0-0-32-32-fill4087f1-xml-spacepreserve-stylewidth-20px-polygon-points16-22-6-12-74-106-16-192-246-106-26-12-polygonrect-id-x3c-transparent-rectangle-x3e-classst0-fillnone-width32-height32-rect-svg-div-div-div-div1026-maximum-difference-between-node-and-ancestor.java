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
        
        return helper(root, 0, 5000);
    }
    
    int helper(TreeNode root, int currmax, int currmin) {
        if(root==null) {
            return currmax-currmin;
        }
        //ans = Math.max(ans, Math.abs(maxParent-root.val));
        //maxParent = Math.max(maxParent, root.val);
        currmin = Math.min(currmin, root.val);
        currmax = Math.max(currmax, root.val);
        int L = helper(root.left, currmax, currmin);
        int R = helper(root.right, currmax, currmin);
        return Math.max(L, R);
    }
    
    
}