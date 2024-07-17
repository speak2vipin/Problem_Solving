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
    List<TreeNode> ans = null;
    Set<Integer> toBeDelete = null;
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        toBeDelete = new HashSet<>();
        for(int val : to_delete) {
            toBeDelete.add(val);
        }
        postorder(root);
        if(!toBeDelete.contains(root.val)) {
            ans.add(root);
        }
        
        return ans;
    }
    
    TreeNode postorder(TreeNode root) {
        if(root==null) {
            return null;
        }
        root.left = postorder(root.left);
        root.right = postorder(root.right);
        if(toBeDelete.contains(root.val)) {
            // Root.left would be not null iff, it is not part of toBeDelete set same apply for root.right
            if(root.left!=null) {
                ans.add(root.left);
            }
            if(root.right!=null) {
                ans.add(root.right);
            }
            return null;
        }
        return root;
        
    }
    
    
}