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
    public boolean isCompleteTree(TreeNode root) {
        return bfs(root);
    }
    
    boolean bfs(TreeNode root) {
        if(root==null) {
            return true;
        }
        boolean isNullNodeFound = false;
        Queue<TreeNode> qe = new LinkedList<TreeNode>();
        qe.offer(root);
        while(!qe.isEmpty()) {
            TreeNode top = qe.poll();
            if(top==null) {
                isNullNodeFound = true;
            } else {
                if(isNullNodeFound) {
                    return false;
                }
                qe.offer(top.left);
                qe.offer(top.right);
            }
        }
        return true;
    }
}