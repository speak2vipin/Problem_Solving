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
    public void flatten(TreeNode root) {
        TreeNode temp = root;
        while(temp!=null) {
            TreeNode rightMostNode = rightMostNodeInLeftSubTree(temp);
            if(rightMostNode!=null) {
                rightMostNode.right = temp.right;
                temp.right = temp.left;
                temp.left = null;
            }
            temp = temp.right;
        }
        //return root;     
    }
    
    TreeNode rightMostNodeInLeftSubTree(TreeNode r) {
        TreeNode temp = r.left;
        while(temp!=null && temp.right!=null) {
            temp = temp.right;
        }
        return temp;
    }
}