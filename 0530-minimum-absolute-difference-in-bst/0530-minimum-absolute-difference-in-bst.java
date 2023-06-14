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
    // Logic:
        // Inorder traversal makes values in sorted order. Subsequently you can calculate    minimum difference. TC: O(n), SC: O(n)
        // Or we can maintain a prev value to keep track of previous value as inorder traversal would be in sorted order so we need to find the diff of current and prev node only.
// Doing this we can reduce it's space complexity to O(h), height of the tree.
    
    Integer prev = null;
    int ans = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        if(root==null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int res = Integer.MAX_VALUE;
        int N = list.size();
        for(int i=1; i<N; i++) {
            //res = Math.min(res, list.get(i)-list.get(i-1));
        }
        //return res;
        return ans;
    }
    
    void inorder(TreeNode root, List<Integer> list) {
        if(root==null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        if(prev == null) {
            prev = root.val;
        } else {
            ans = Math.min(ans, root.val - prev);
            prev = root.val;
        }
        inorder(root.right, list);
    }
}