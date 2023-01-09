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
    List<Integer>ans = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return ans;    
    }
    void helper(TreeNode temp) {
        if(temp==null) {
            return;
        }
        ans.add(temp.val);
        helper(temp.left);
        helper(temp.right);
    }
}