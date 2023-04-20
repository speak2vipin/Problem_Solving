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
    int maxWidth = Integer.MIN_VALUE;
    public int widthOfBinaryTree(TreeNode root) {
        helper(root);
        return maxWidth;
    }
    
    void helper(TreeNode root) {
        Queue<SpecialNode> qe = new LinkedList<>();
        SpecialNode specialNode = new SpecialNode(root, 0);
        qe.offer(specialNode);
        
        while(!qe.isEmpty()) {
            int size = qe.size();
            int min = qe.peek().index;
            int max = 0;
            for(int i=0; i<size; i++) {
                SpecialNode top = qe.poll();
                TreeNode temp = top.node;
                max = top.index;
                if(temp.left != null) {
                     qe.offer(new SpecialNode(temp.left, top.index * 2));
                }
                if(temp.right != null) {
                     qe.offer(new SpecialNode(temp.right, top.index * 2 + 1 ));
                }
            }
            maxWidth = Math.max(maxWidth, max-min+1);
         }
    }
}

class SpecialNode {
    TreeNode node;
    int index;
    public SpecialNode(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}