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
    public TreeNode bstToGstWithRecurssion(TreeNode root) {
        int nodeSum[] = new int[1];
        helper(root, nodeSum);
        return root;
    }
    
    public TreeNode bstToGst(TreeNode root) {
        helperWithoutRecurssion(root);
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
    
    void helperWithoutRecurssion(TreeNode node) {
        Stack<TreeNode> st = new Stack<>();
        int nodeSum = 0;
        while(!st.isEmpty() || node!=null) {
            if(node!=null) {
                st.push(node);
                node = node.right;
                continue;
            }
            node = st.pop();
            nodeSum += node.val;
            node.val = nodeSum;
            node = node.left;
        }
    }
}