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
    public boolean evaluateTree(TreeNode root) {
        return postOrder(root);
    }
    
    boolean postOrder(TreeNode root) {
        if(root==null) {
            return true;
        }
        if(root.left==null && root.right==null) {
            return root.val==1;    
        }
        boolean status = false;
        if(root.val==2) {
            status = postOrder(root.left) || postOrder(root.right);
        } else {
            status = postOrder(root.left) && postOrder(root.right);
        }
        return status;
    }
}