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
    int total = 0;
    public int rangeSumBSTRecursion(TreeNode root, int low, int high) {
        if(root==null) {
            return 0;
        }
        rangeSumBST(root.left, low, high);
        if(root.val>=low && root.val<=high) {
            total += root.val;
        }
        rangeSumBST(root.right, low, high);
        return total;
    }
    
     public int rangeSumBST(TreeNode root, int low, int high) {
         Stack<TreeNode> st = new Stack<>();
     
         int sum = 0;
         TreeNode temp = root;
         while(!st.isEmpty() || temp!=null) {
             if(temp!=null) {
                 st.push(temp);
                 temp = temp.left;
             } else {
                 temp = st.pop();
                 if(temp.val>=low && temp.val<=high) {
                     sum += temp.val;
                 }
                 temp = temp.right;
             }
         }
         return sum;
    }
    
    
    
   /* void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }*/
}