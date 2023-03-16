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
    TreeNode root = null;
    Map<Integer, Integer> indexMap = null;
    int postorderIndex = -1;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexMap = new HashMap<>();
        int N = inorder.length;
        postorderIndex = N-1;
        for(int i=0; i<N; i++) {
            indexMap.put(inorder[i], i);
        }
        root = helper(0, N-1, postorder);
        return root;
    }
    
    TreeNode helper(int st, int en, int[] postorder) {
        TreeNode temp = null;
        if(st<=en) {
            int val = postorder[postorderIndex--];
            temp = new TreeNode(val);
            int index = indexMap.get(val);
            temp.right = helper(index+1, en, postorder);
            temp.left = helper(st, index-1, postorder);
        }
        return temp;
        
    }
    
}