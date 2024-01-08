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
    List<Integer> l = new ArrayList<>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root);
        int sum = 0;
        for(Integer val : l) {
            //System.out.println(val);
            if(val>=low && val<=high) {
                sum += val;
            }
        }
        return sum;
    }
    
    void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }
    
    
    
}