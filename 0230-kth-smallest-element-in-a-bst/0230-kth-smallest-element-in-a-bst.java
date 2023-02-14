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
    int index;
    int ans = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        index = k;
        inorder(root);
        return ans;
    }
    
    void inorder(TreeNode root) {
        if(index<1 || root==null) {
            return;
        }
        inorder(root.left);
        if(--index==0) {
            ans = root.val;
        }
        inorder(root.right);
    }
}