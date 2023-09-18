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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> qe = new LinkedList<>();
        qe.offer(root);
        int response = 0;
        while(!qe.isEmpty()) {
            int size = qe.size();
            for(int i=0; i<size; i++) {
                TreeNode top = qe.poll();
                if(i==0) {
                    response = top.val;
                }
                if(top.left!=null) {
                    qe.offer(top.left);
                }
                if(top.right!=null) {
                    qe.offer(top.right);
                }
            }
        }
        return response;
    }
}