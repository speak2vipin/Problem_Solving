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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //inorder(ans, root);
        inorderByStack(ans, root);
        return ans;
    }
    
    void inorder(List<Integer> ans, TreeNode root) {
        if(root==null) {
            return;
        }
        inorder(ans, root.left);
        ans.add(root.val);
        inorder(ans, root.right);
    }
    
     
    void inorderByStack(List<Integer> ans, TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
      
        while(root!=null || !st.isEmpty()) {
            while(root!=null) {
                st.push(root);
                root=root.left;
            }
            root = st.pop();
            ans.add(root.val);
            root = root.right;
        }
    }
}