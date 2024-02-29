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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> qe = new LinkedList<>();
        qe.offer(root);
        boolean even = true;
        int prev = 0;
        while(!qe.isEmpty()) {
            int size = qe.size();
            if(even) {
                prev = Integer.MIN_VALUE;
            } else {
                prev = Integer.MAX_VALUE;
            }
            for(int i=0; i<size; i++) {
                TreeNode top = qe.poll();
                if(even) {
                    if((top.val%2)==0 || prev>=top.val) {
                        return false;
                    }
                } else {
                     if((top.val%2)!=0 || prev<=top.val) {
                        return false;
                    }
                }
                prev = top.val;
                if(top.left!=null) {
                    qe.offer(top.left);
                } 
                if(top.right!=null) {
                    qe.offer(top.right);
                }
            }
            even = !even;
        }
        return true;
    }
}