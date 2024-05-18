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
// We will be processing from the leaf node to root
// Extra coin would processed to parent node
    // So node.val-1+left+right
// moves would be, whatever is the balance that need to processed so left + right`
// and extra nodes would be processed one step each

class Solution {
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    
    int dfs(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        moves += Math.abs(left) + Math.abs(right);
        
        // 
        return root.val-1+left+right;
    }
}