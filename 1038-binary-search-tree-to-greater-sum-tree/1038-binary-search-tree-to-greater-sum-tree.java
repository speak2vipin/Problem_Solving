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
    public TreeNode bstToGst(TreeNode root) {
        int nodeSum[] = new int[1];
        helper(root, nodeSum);
        return root;
    }
  
    void helper(TreeNode node, int nodeSum[]) {
        if(node==null) {
            return ;
        }
        helper(node.right, nodeSum);
        nodeSum[0]+= node.val;
        node.val = nodeSum[0];
        helper(node.left, nodeSum);
    }
}