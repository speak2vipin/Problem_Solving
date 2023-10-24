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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) {
            return ans;    
        }
        Queue<TreeNode> qe = new LinkedList<>();
        qe.offer(root);
        while(!qe.isEmpty()) {
            int size = qe.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++) {
                TreeNode top = qe.poll();
                max = Math.max(max, top.val);
                if(top.left!=null) {
                    qe.offer(top.left);
                }
                if(top.right!=null) {
                    qe.offer(top.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}