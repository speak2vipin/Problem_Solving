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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return createBalancedBST(inorder, 0, inorder.size()-1);
        
    }
    
    void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if(root==null) {
            return;
        }
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
    
    private TreeNode createBalancedBST(List<Integer> inorder, int st, int en) {
        if(st>en) {
            return null;
        }
        int mid = en - (en - st)/2;
        TreeNode leftSubtree = createBalancedBST(inorder, st, mid-1);
        TreeNode rightSubtree = createBalancedBST(inorder, mid+1, en);
        TreeNode node = new TreeNode(inorder.get(mid), leftSubtree, rightSubtree);
        return node;
    }
}