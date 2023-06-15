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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> qe = new LinkedList<>();
        qe.offer(root);
        int maxLevel = -1;
        int sum = Integer.MIN_VALUE;
        int level = 0;
        while(!qe.isEmpty()) {
            level++;
            int size = qe.size();
            int tempSum = 0;
            for(int i=0; i<size; i++) {
                TreeNode top = qe.poll();
                tempSum += top.val; 
                if(top.left!=null) {
                    qe.offer(top.left);
                }
                if(top.right!=null) {
                    qe.offer(top.right);
                }
            }
            if(tempSum>sum) {
                maxLevel = level;
                sum = tempSum;
            }
        }
        return maxLevel;
    }
}