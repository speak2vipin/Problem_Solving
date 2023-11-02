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
   // int count = 0;
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
    
    int[] helper(TreeNode root) {
        if(root==null) {
            return new int[]{0,0};
        }
        int val = root.val;
        
        int leftVal[] = helper(root.left);
        int rightVal[] = helper(root.right);
        
        int sum = val + leftVal[0] + rightVal[0];
        int nodeCount = 1 + leftVal[1] + rightVal[1];
        int average = sum/nodeCount;
        if(average==val) {
            ans++;
        }
        
        return new int[]{sum, nodeCount};
    }
}