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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>>  nodes = new ArrayList<List<Integer>>(); 
        if(root==null) {
            return nodes;
        }
        Queue<TreeNode> qe = new LinkedList<TreeNode>();
        qe.offer(root);
        boolean flag = true;
        while(!qe.isEmpty()) {
            int size = qe.size();
            List<Integer> l = new ArrayList<Integer>();
            
            for(int i=0; i<size; i++) {
                TreeNode temp = qe.poll();
                if(temp.left!=null) {
                    qe.offer(temp.left);
                }
                if(temp.right!=null) {
                    qe.offer(temp.right);
                }
                l.add(temp.val);
            }
            if(flag) {
                nodes.add(l);
            } else{
            	Collections.reverse(l);  
                nodes.add(l);
            }
            flag = !flag;
        }
        return nodes;     
    }
}