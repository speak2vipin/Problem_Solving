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
    PriorityQueue<Long> pq  = null;
    public long kthLargestLevelSum(TreeNode root, int k) {
        pq = new PriorityQueue<Long>(Collections.reverseOrder());
        long ans = -1;
        traverse(root);
        while(k>1 && !pq.isEmpty()) {
            pq.poll();
            k--;
        }
        if(!pq.isEmpty()) {
            ans = pq.poll();
        }
        return ans;
        
    }
    
    void traverse(TreeNode root) {
        Queue<TreeNode>qe = new LinkedList<TreeNode>();
        qe.offer(root);
        while(!qe.isEmpty()) {
            int size = qe.size();
            long sum = 0;
            for(int i=0; i<size; i++){
                TreeNode temp = qe.poll();
                sum += temp.val;
                if(temp.left!=null) {
                    qe.offer(temp.left);
                }
                if(temp.right!=null) {
                    qe.offer(temp.right);
                }
            }
            pq.offer(sum);
        }
    }
}